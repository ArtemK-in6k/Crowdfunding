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

    OwnDonates.$inject = ['$timeout', 'ControlDonatesService', 'Notification'];

    function OwnDonates($timeout, ControlDonatesService, Notification) {

        var self = this;

        ControlDonatesService.getAllOwnDonates()
            .then(function (result) {
                self.donates = result.data;
            });

        self.deleteDonate = function (donateId, name) {
            ControlDonatesService.deleteOwnDonate(donateId).then(function (result) {
                self.donateDeleteSuccess = ControlDonatesService.isDonateDeleted(self.donates, result.data);
                self.donateDeleteWarning = !ControlDonatesService.isDonateDeleted(self.donates, result.data);
                self.donates = result.data;
                self.donateDelete = name;

                if (self.donateDeleteWarning) {
                    Notification({
                        message: 'You can\'t delete' +
                        self.donateDelete + ',because this project have move than 90% donates',
                        title: 'Notification'
                    }, 'warning');
                } else if (self.donateDeleteSuccess) {
                    Notification({
                        message: 'Donation ' + self.donateDelete + ' delete successful',
                        title: 'Notification'
                    }, 'info');
                }

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
                Notification({message: 'Donation updated successful', title: 'Notification'}, 'success');
            })
        };
    }
})();

