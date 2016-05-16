var app = angular.module('app', ['googleplus']);

app.config(['GooglePlusProvider', function (GooglePlusProvider) {
    GooglePlusProvider.init({
        clientId: '220560473769-vinejdb28vpnrdmvqd22u0m3knltdi80.apps.googleusercontent.com',
        apiKey: 'cCVyo43S7V5ygqpA94ouFan1'

    });
    GooglePlusProvider.setScopes('profile email');
}]);

app.controller('AuthCtrl', ['$scope', 'GooglePlus', '$http','$route', function ($scope, GooglePlus, $http, $route) {
    $scope.login = function () {
        GooglePlus.login().then(function (authResult) {
            console.log(authResult);

            GooglePlus.getUser().then(function (user) {
                console.log(user);
                var googleuser = {
                    email: user.email,
                    family_name: user.family_name,
                    given_name: user.given_name,
                    name: user.name
                };
                $http.post("/login", googleuser).success(function (data) {
                    //window.location.assign("");
                    $http.get("").success(function(data){
                        console.log("Hi")
                    })
                });
            });

        }, function (err) {
            console.log(err);
        });
    };
}])
