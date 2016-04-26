(function () {
    'use strict';

    angular
        .module('crowdfundingApp.control')
        .controller('OwnDonates', OwnDonates)
        .run(function (editableOptions, editableThemes) {
            editableThemes.bs3.inputClass = 'form-control-inline';
            editableThemes.bs3.buttonsClass = 'btn-md';
            editableOptions.theme = 'bs3';
        });

    OwnDonates.$inject = ['$scope', '$http', '$timeout', 'ControlDonatesService'];

    function OwnDonates($scope, $http, $timeout, ControlDonatesService) {

        ControlDonatesService.getAllOwnDonates()
            .then(function (result) {
                $scope.donates = result.data;
            });

        $scope.deleteProject = function (donateId, name) {
            ControlDonatesService.deleteOwnDonate(donateId).then(function (result) {
                $scope.donates = result.data;
                $scope.donateDelete = name;
                $scope.donateDeleteSuccess = true;

                $timeout(function () {
                    $scope.donateDeleteSuccess = false;
                }, 3000);
            })

        };

        $scope.saveDonate = function (donate, id) {
            var donation = {
                "id": id,
                "donate": donate
            };
            $scope.donationUpdateSuccess = true;
            ControlDonatesService.saveOwnDonate(donation).then(function (result) {
                $scope.donates = result.data;

                $timeout(function () {
                    $scope.donationUpdateSuccess = false;
                }, 3000);
            })
        };
    }
})();

