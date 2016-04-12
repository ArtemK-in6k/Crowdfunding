'use strict';

var crowdfundingApp = angular.module('crowdfundingApp.categories', []);

crowdfundingApp.controller('CategoryProjectList', ['$scope', '$http', function ($scope, $http) {

    $http.get('categoryProjects').success(function (data) {
        $scope.projects = data;
    }).error(function (data) {
        console.log(data);
    })
    ;
    $scope.filterOrd = '';
    $scope.orderProp = '';
}]);