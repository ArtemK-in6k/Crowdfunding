(function () {
    'use strict';

    angular.module('crowdfundingApp.control').factory('ControlDonatesService', ControlDonatesService);

    ControlDonatesService.$inject = ['$http'];

    function ControlDonatesService($http) {

        function getAllOwnDonates() {
            return $http.get('/control/donates/list');
        }

        function deleteOwnDonate(donateId) {
            return $http.delete("/control/donates/" + donateId);
        }

        function saveOwnDonate(donation) {
            return $http.post("/control/donates", donation);
        }

        function isDonateDeleted(donatesBeforeRemove, donatesAfterRemove) {
            return !(donatesAfterRemove.length == donatesBeforeRemove.length);
        }

        return {
            getAllOwnDonates: getAllOwnDonates,
            deleteOwnDonate: deleteOwnDonate,
            saveOwnDonate: saveOwnDonate,
            isDonateDeleted: isDonateDeleted
        };
    }
})();
