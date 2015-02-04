var express = require('express'),
    Sequelize = require('sequelize'),
    app = express(),
    models = require('./models');

app.get('/', function(req, res) {
    models.User.findAll({
        include: [models.Task]
    }).then(function(users) {
        res.send(users);
    });
});

models.sequelize.sync().then(function() {
    var server = app.listen(8080, function() {

        var host = server.address().address;
        var port = server.address().port;

        console.log('Example app listening at http://%s:%s', host, port);

    });
});
