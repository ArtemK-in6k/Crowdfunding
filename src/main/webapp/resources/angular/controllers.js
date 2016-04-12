'use strict';

var crowdfundingApp = angular.module('crowdfundingApp', []);

crowdfundingApp.controller('ProjectList', ['$scope', '$http', function ($scope, $http) {
    $http.get('/projects').success(function (data) {
        $scope.projects = data;
    }).error(function (datat) {
        console.log(datat);
    })
    ;
    $scope.orderProp = '';
}]);

crowdfundingApp.controller('ProjectListForAdmin', ['$scope', '$http', function ($scope, $http) {
    $http.get('/projects').success(function (data) {
        $scope.projects = data;
    }).error(function (datat) {
        console.log(datat);
    });

    $scope.updateStatus = function (status, id) {
        var project = {
            "id" : id,
            "status" : status
        }
        $http.post("/admin/savestatus/", project).success(function(data, status) {
            $scope.projects = data;
        })
    }
}]);