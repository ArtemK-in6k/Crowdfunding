'use strict';

var crowdfundingApp = angular.module('crowdfundingApp', ['ngAnimate']);

crowdfundingApp.controller('OwnProjects', ['$scope', '$http','$timeout', function ($scope, $http, $timeout) {
    $http.get('/control/projects/ownprojects').success(function (data) {
        $scope.projects = data;
    }).error(function (datat) {
        console.log(datat);
    });

    $scope.updateStatus = function (status, id) {
        var project = {
            "id": id,
            "status": status
        }
        $http.post("/control/projects/savestatus/", project).success(function (data, status) {
            $scope.projects = data;
            $scope.projectUpdateSuccess = true;

            $timeout(function () {
                $scope.projectUpdateSuccess = false;
            },3000);
        })
    }


    $scope.deleteProject = function (id,name) {
        var project = {
            "id": id
        }
        $http.post("/control/projects/deleteProject/", project).success(function (data) {
            $scope.projects = data;
            $scope.projectDelete = name;
            $scope.projectDeleteSuccess = true;

            $timeout(function () {
                $scope.projectDeleteSuccess = false;
            },3000);
        })

    }
}]);
