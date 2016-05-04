(function () {
    'use strict';

    angular
        .module('crowdfundingApp.control')
        .controller('ChangePasswordController', ChangePasswordController);

    ChangePasswordController.$inject = ['SettingsService', '$timeout', '$scope', 'Notification'];

    function ChangePasswordController(SettingsService, $timeout, $scope, Notification) {

        var self = this;

        self.alert = {};
        
        self.isConfirmPasswordEqualToNewPassword = function () {
            self.passwordsNotEquals = self.newPassword != self.confirmPassword;
            return !self.passwordsNotEquals;
        }

        self.updatePassword = function () {
            if (self.isConfirmPasswordEqualToNewPassword()) {
                SettingsService.updatePassword(self.currentPassword, self.newPassword).then(function (result) {
                    if (result.data.success) {
                        resetFormFields();
                    }
                    Notification({message: result.data.message, title: 'Notification'});
                });
            }
        }

        self.closeAlert = function () {
            self.show = false;
        };

        function resetFormFields() {
            self.currentPassword = '';
            self.newPassword = '';
            self.confirmPassword = '';
            $scope.form.reset();
        }
    }
})();
