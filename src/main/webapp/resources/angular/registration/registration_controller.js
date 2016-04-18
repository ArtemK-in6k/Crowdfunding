(function () {
    'use strict';

    angular
        .module('crowdfundingApp')
        .controller('RegistrationController', RegistrationController);

    RegistrationController.$inject = ['RegistrationService'];

    function RegistrationController(RegistrationService) {

        var self = this;

        self.checkLoginUnique = function (login) {
            if (login && login.length > 0){
                RegistrationService.checkLoginUnique(login).then(function (result) {
                    self.isLoginNotUnique = !result.data ;
                })
            }
        };

        self.checkEmailUnique = function (email) {
            if (email && email.length > 0) {
                RegistrationService.checkEmailUnique(email).then(function (result) {
                    self.isEmailNotUnique = !result.data;
                })
            }
        };

        self.createAccount = function (formData) {
            RegistrationService.createAccount(formData);
        }
    }
})();
