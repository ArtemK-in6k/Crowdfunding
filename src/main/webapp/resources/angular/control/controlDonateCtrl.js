'use strict';

var crowdfundingApp = angular.module('crowdfundingApp', ['ngAnimate']);

crowdfundingApp.controller('OwnDonates', ['$scope', '$http','$timeout', function ($scope, $http, $timeout) {
    $http.get('/control/donates/owndonates').success(function (data) {
        $scope.donates = data;
    }).error(function (datat) {
        console.log(datat);
    });

    $scope.deleteProject = function (donateId,name) {

        $http.post("/control/donates/"+donateId+"/delete").success(function (data) {
            $scope.donates = data;
            $scope.donateDelete = name;
            $scope.donateDeleteSuccess = true;

            $timeout(function () {
                $scope.donateDeleteSuccess = false;
            },3000);
        })

    }
}]);
