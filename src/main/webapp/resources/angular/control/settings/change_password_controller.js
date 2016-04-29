(function () {
    'use strict';

    angular
        .module('crowdfundingApp.control')
        .controller('ChangePasswordController', ChangePasswordController);

    ChangePasswordController.$inject = ['SettingsService', '$timeout', '$scope'];

    function ChangePasswordController(SettingsService, $timeout, $scope) {

        var self = this;

        self.alert = {};
        
        self.isConfirmPasswordEqualToNewPassword = function () {
            self.passwordsNotEquals = self.newPassword != self.confirmPassword;
            return !self.passwordsNotEquals;
        }

        self.updatePassword = function () {
            if (self.isConfirmPasswordEqualToNewPassword()) {
                SettingsService.updatePassword(self.currentPassword, self.newPassword).then(function (result) {

                    self.alert.msg = result.data.message;

                    if (result.data.success) {
                        self.alert.type = 'success';
                        resetFormFields();
                    } else {
                        self.alert.type = 'danger';
                    }

                    self.show = true;
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
            $scope.form.reset()
        }
    }
})();
