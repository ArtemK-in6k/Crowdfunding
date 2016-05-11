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

    OwnDonates.$inject = ['ControlDonatesService', 'Notification'];

    function OwnDonates(ControlDonatesService, Notification) {

        var self = this;

        ControlDonatesService.getAllOwnDonates()
            .then(function (result) {
                self.donates = result.data;
            });

        self.deleteDonate = function (donateId, name) {
            ControlDonatesService.deleteOwnDonate(donateId).then(function (result) {
                ControlDonatesService.isDonateDeleted(self.donates, result.data, name);
                self.donates = result.data;
            })
        };

        self.saveDonate = function (changeDonate, donate) {
            var donation = {
                "id": donate.id,
                "donate": changeDonate
            };
            if (ControlDonatesService.isDonateHaveProjectWithLess90PercentDonate(donate.percentDonateProject) ||
                ControlDonatesService.isIncreaseDonation(changeDonate, donate.donateAmount)) {
                ControlDonatesService.saveOwnDonate(donation).then(function (result) {
                    self.donates = result.data;
                    ControlDonatesService.donateUpdateSuccessfulNotification();
                })
            } else {
                ControlDonatesService.donateUpdateErrorNotification();

            }

        };
    }
})();

