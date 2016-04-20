'use strict';

var app = angular.module('crowdfundingApp',['textAngular']);
    app.controller('ProjectCtrl', function ($scope,$http) {
        $scope.getProjectData = function (id) {
            $http.get("/projects/project/" + id).success(function (data) {
                $scope.project = data;
            })
        };
    });
