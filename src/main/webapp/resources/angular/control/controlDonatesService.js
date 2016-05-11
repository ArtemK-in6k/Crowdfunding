(function () {
    'use strict';

    angular.module('crowdfundingApp.control').factory('ControlDonatesService', ControlDonatesService);

    ControlDonatesService.$inject = ['$http', 'Notification'];

    function ControlDonatesService($http, Notification) {

        function getAllOwnDonates() {
            return $http.get('/control/donates/list');
        }

        function deleteOwnDonate(donateId) {
            return $http.delete("/control/donates/" + donateId);
        }

        function saveOwnDonate(donation) {
            return $http.post("/control/donates", donation);
        }

        function isDonateDeleted(donatesBeforeRemove, donatesAfterRemove, name) {
            var donateDeleteSuccess = donatesAfterRemove.length != donatesBeforeRemove.length;

            if (donateDeleteSuccess) {
                Notification({
                    message: 'Donation ' + name + ' delete successful',
                    title: 'Notification'
                }, 'primary');
            } else {
                Notification({
                    message: 'You can\'t delete donate from ' +
                    name + ' ,because this project have move than 90% donates',
                    title: 'Notification',
                    delay : 10000
                }, 'error');
            }
        }

        function isDonateHaveProjectWithLess90PercentDonate(percentDonate) {
            return percentDonate <= 90;
        }

        function isIncreaseDonation(changeAmount, donateAmount) {
            return changeAmount > donateAmount;
        }

        function donateUpdateSuccessfulNotification(){
            Notification({message: 'Donation updated successful ', title: 'Notification'}, 'success');
        }

        function donateUpdateErrorNotification(){
            Notification({
                message: 'You can\'t change your donate' +
                ' ,because this project have more than 90% donates', title: 'Notification', delay: 10000
            }, 'error');
        }

        return {
            getAllOwnDonates: getAllOwnDonates,
            deleteOwnDonate: deleteOwnDonate,
            saveOwnDonate: saveOwnDonate,
            isDonateDeleted: isDonateDeleted,
            isDonateHaveProjectWithLess90PercentDonate: isDonateHaveProjectWithLess90PercentDonate,
            isIncreaseDonation: isIncreaseDonation,
            donateUpdateSuccessfulNotification: donateUpdateSuccessfulNotification,
            donateUpdateErrorNotification: donateUpdateErrorNotification
        };
    }
})();
