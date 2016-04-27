(function () {
    'use strict';

    angular
        .module('crowdfundingApp.control')
        .controller('ChangePasswordController', ChangePasswordController);

    ChangePasswordController.$inject = ['SettingsService', '$timeout'];

    function ChangePasswordController(SettingsService, $timeout) {

        var self = this;

        function isConfirmPasswordEqualToNewPassword() {
            self.passwordsNotEquals = self.newPassword != self.confirmPassword;
            return !self.passwordsNotEquals;
        }

        self.updatePassword = function () {
            if (isConfirmPasswordEqualToNewPassword()) {
                SettingsService.updatePassword(self.currentPassword, self.newPassword).then(function (result) {
                    if (result.data.success) {
                        self.success = true;
                        self.errorMessage = null;
                        resetFormFields();
                    } else {
                        self.success = result.data.success;
                        self.errorMessage = result.data.message;
                    }

                    $timeout(function () {
                        self.success = false;
                    }, 3000);
                });
            }
        }

        function resetFormFields() {
            self.currentPassword = '';
            self.newPassword = '';
            self.confirmPassword = '';
        }
    }
})();
