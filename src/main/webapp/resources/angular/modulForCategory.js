'use strict';

var crowdfunding = angular.module('crowdfunding', []);

crowdfunding.controller('CategoryProjectList', ['$scope', '$http', function ($scope, $http) {
    $http.get('categoryProjects').success(function (data) {
        $scope.projects = data;
    }).error(function (data) {
        console.log(data);
    })
    ;
    $scope.filterOrd = '';
}]);