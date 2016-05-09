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
                var donateDeleteSuccess = ControlDonatesService.isDonateDeleted(self.donates, result.data);
                self.donates = result.data;

                if (donateDeleteSuccess) {
                    Notification({
                        message: 'Donation ' + name + ' delete successful',
                        title: 'Notification'
                    }, 'primary');
                } else {
                    Notification({
                        message: 'You can\'t delete ' +
                        name + ' ,because this project have move than 90% donates',
                        title: 'Notification'
                    }, 'warning');
                }

            })

        };

        self.saveDonate = function (donate, id, percentDonate) {
            var donation = {
                "id": id,
                "donate": donate
            };
            if (ControlDonatesService.isDonateHaveProjectWithLess90PercentDonate(percentDonate)){
                ControlDonatesService.saveOwnDonate(donation).then(function (result) {
                    self.donates = result.data;
                    Notification({message: 'Donation updated successful ', title: 'Notification'}, 'success');
                })
            }else {
                Notification({message: 'You can\'t change your donate' +
                ' ,because this project have more than 90% donates', title: 'Notification', delay: 10000}, 'error');
            }

        };
    }
})();

