(function () {
    'use strict';

    angular.module('crowdfundingApp.control').factory('SettingsService', SettingsService);

    SettingsService.$inject = ['$http'];

    function SettingsService($http) {

        function updatePassword(currentPassword, newPassword) {
            var data = {currentPassword: currentPassword, newPassword:newPassword}
            return $http.post('/api/users/change-password', data);
        }
        
        return {
            updatePassword: updatePassword,
        };
    }
})();
