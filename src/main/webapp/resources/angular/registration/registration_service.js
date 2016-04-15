(function () {
    'use strict';

    angular.module('crowdfundingApp').factory('RegistrationService', RegistrationService);

    RegistrationService.$inject = ['$q', '$http'];

    function RegistrationService($q, $http) {

        function checkLoginUnique(login) {
            var data = {value: login}
            return $http.post('/api/auth/isUniqueLogin', data);
        }

        function checkEmailUnique(email) {
            var data = {value: email}
            return $http.post('/api/auth/isUniqueEmail', data);
        }

        function createAccount(formData) {
            var registrationData = {
                login: formData.login,
                password: formData.password,
                lastName: formData.lastName,
                firstName: formData.firstName,
                email: formData.email
            }
            return $http.post('/api/auth/create-account', registrationData);
        }

        return {
            checkLoginUnique: checkLoginUnique,
            checkEmailUnique: checkEmailUnique,
            createAccount: createAccount,
        };
    }
})();
