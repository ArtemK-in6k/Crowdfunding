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
