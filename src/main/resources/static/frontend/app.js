/**
 * Created by kaarel on 26/04/15.
 */

angular.module("garaazh", ["ui.router"]);

angular.module("garaazh").constant("API", "http://localhost:8080/api");

angular.module("garaazh").config(function($stateProvider, $urlRouterProvider, $httpProvider){
    $urlRouterProvider.otherwise("/");

    $stateProvider
        .state("base", {
            templateUrl: "templates/base.html",
            abstract: true
        })
        .state("base.list", {
            url: "/",
            templateUrl: "templates/list.html",
            controller: "ListController"
        })
        .state("base.add", {
            url: "/add",
            templateUrl: "templates/add.html",
            controller: "AddController"
        })
        .state("base.edit", {
            url: "/edit/:kood",
            templateUrl: "templates/add.html",
            controller: "AddController"
        });

        $httpProvider.interceptors.push(function(API) {
            return {
                'request': function(config) {
                    if(config.api)
                        config.url = API + config.url;

                    return config;
                },

                'response': function(response) {
                    return response;
                }
            };
        });
});

angular.module("garaazh").controller("ListController", function($scope, $http){
    $http({
        method: 'GET',
        url: '/kaubad',
        api: true
    }).success(function(response){
        $scope.kaubad = response;
    });
});

angular.module("garaazh").controller("AddController", function($scope, $http, $state, $stateParams, $q){
    $scope.kaup = {
        omadused: []
    };

    $scope.addKaup = function(){
        $http({
            method: 'POST',
            url: '/kaubad',
            api: true,
            data: $scope.kaup
        }).success(function(response){
            $state.go("base.list");
        }).error(function(reject){
            alert("Vigased andmed!");
        });
    };

    $scope.deleteKaup = function(){
        $http({
            method: 'DELETE',
            url: '/kaubad/' + $stateParams.kood,
            api: true,
            data: $scope.kaup
        }).success(function(response){
            $state.go("base.list");
        }).error(function(reject){
            alert("Midagi läks valesti..");
        });
    };

    $scope.addOmadus = function(){
        $scope.kaup.omadused.push({
            omadus: angular.copy($scope.uusOmadus),
            vaartus: ""
        });
        delete $scope.uusOmadus;
    };

    var requests = [$http({
        method: "GET",
        url: "/tarnijad",
        api: true
    }), $http({
        method: "GET",
        url: "/tootjad",
        api: true
    }), $http({
        method: "GET",
        url: "/omadused",
        api: true
    }), $http({
        method: "GET",
        url: "/seisundid",
        api: true
    }), $http({
        method: "GET",
        url: "/kategooriad",
        api: true
    })];

    if($stateParams.hasOwnProperty("kood"))
        requests.push($http({
            method: 'GET',
            url: '/kaubad/' + $stateParams.kood,
            api: true
        }));

    $q.all(requests).then(function(responses){
        $scope.tarnijad = responses[0].data;
        $scope.tootjad = responses[1].data;
        $scope.omadused = responses[2].data;
        $scope.seisundid = responses[3].data;
        $scope.kategooriad = responses[4].data;

        if(responses[5]) {
            $scope.kaup = responses[5].data;

            for(var i in $scope.tarnijad)
                if(angular.equals($scope.tarnijad[i], $scope.kaup.tarnija)){
                    $scope.kaup.tarnija = $scope.tarnijad[i];
                    break;
                }

            for(var i in $scope.tootjad)
                if(angular.equals($scope.tootjad[i], $scope.kaup.tootja)){
                    $scope.kaup.tootja = $scope.tootjad[i];
                    break;
                }

            for(var i in $scope.kategooriad)
                if(angular.equals($scope.kategooriad[i], $scope.kaup.kategooria)){
                    $scope.kaup.kategooria = $scope.kategooriad[i];
                    break;
                }

            for(var i in $scope.seisundid)
                if(angular.equals($scope.seisundid[i], $scope.kaup.seisund)){
                    $scope.kaup.seisund = $scope.seisundid[i];
                    break;
                }

            $scope.existingEntity = true;
        }
    })
});