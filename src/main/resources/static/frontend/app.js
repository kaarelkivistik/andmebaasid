/**
 * Created by kaarel on 26/04/15.
 */

angular.module("garaazh", ["ui.router", "ui.bootstrap"]);

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

        $httpProvider.interceptors.push(function(API, $injector) {
            return {
                'request': function(config) {
                    if(config.api)
                        config.url = API + config.url;

                    return config;
                },

                'response': function(response) {
                    return response;
                },

                'responseError': function(rejection) {
                    $injector.invoke(function($modal, $q){
                        $modal.open({
                            templateUrl: "templates/error.html",
                            controller: function($scope, error){
                                $scope.error = error;
                            },
                            resolve: {
                                error: function() {
                                    return rejection.data;
                                }
                            }
                        });
                    });

                    console.log(rejection.data);

                    return $q.reject(rejection);
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
        });
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
        url: "/staatused",
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
        $scope.staatused = responses[2].data;
        $scope.kategooriad = responses[3].data;

        if(responses[4]) {
            $scope.kaup = responses[4].data;

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
                if(angular.equals($scope.kategooriad[i], $scope.kaup.kaubaKategooria)){
                    $scope.kaup.kaubaKategooria = $scope.kategooriad[i];
                    break;
                }

            for(var i in $scope.staatused)
                if(angular.equals($scope.staatused[i], $scope.kaup.kaubaStaatus)){
                    $scope.kaup.kaubaStaatus = $scope.staatused[i];
                    break;
                }

            $scope.existingEntity = true;
        }
    })
});