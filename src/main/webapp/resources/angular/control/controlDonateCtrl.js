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

    OwnDonates.$inject = ['$timeout', 'ControlDonatesService'];

    function OwnDonates($timeout, ControlDonatesService) {

        var self = this;

        ControlDonatesService.getAllOwnDonates()
            .then(function (result) {
                self.donates = result.data;
            });

        self.deleteProject = function (donateId, name) {
            ControlDonatesService.deleteOwnDonate(donateId).then(function (result) {
                self.donateDeleteSuccess = ControlDonatesService.isDonateDeleted(self.donates, result.data);
                self.donateDeleteWarning = !ControlDonatesService.isDonateDeleted(self.donates, result.data);
                self.donates = result.data;
                self.donateDelete = name;

                $timeout(function () {
                    self.donateDeleteSuccess = false;
                    self.donateDeleteWarning = false;
                }, 3000);
            })

        };

        self.saveDonate = function (donate, id) {
            var donation = {
                "id": id,
                "donate": donate
            };
            self.donationUpdateSuccess = true;
            ControlDonatesService.saveOwnDonate(donation).then(function (result) {
                self.donates = result.data;

                $timeout(function () {
                    self.donationUpdateSuccess = false;
                }, 3000);
            })
        };
    }
})();

