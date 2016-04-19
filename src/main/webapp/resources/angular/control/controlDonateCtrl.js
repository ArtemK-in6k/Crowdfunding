'use strict';

var crowdfundingApp = angular.module('crowdfundingApp', ['ngAnimate','xeditable']);

crowdfundingApp.run(function(editableOptions, editableThemes) {
    editableThemes.bs3.inputClass = 'form-control-inline';
    editableThemes.bs3.buttonsClass = 'btn-md';
    editableOptions.theme = 'bs3';
});

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
    $scope.saveDonate = function(donate, id) {
        var donation = {
            "id": id,
            "donate": donate
        };
        $scope.donationUpdateSuccess = true;
        $http.post("/control/donates/save",donation).success(function (data) {
            $scope.donates = data;

            $timeout(function () {
                $scope.donationUpdateSuccess = false;
            },3000);
        })
    };
}]);
