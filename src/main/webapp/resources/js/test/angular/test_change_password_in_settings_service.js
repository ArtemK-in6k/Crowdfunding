describe('ChangePasswordController', function () {
    var scope, ctrl, httpBackend;

    beforeEach(module("crowdfundingApp.control"));

    beforeEach(
        inject(
            function ($controller, $rootScope, SettingsService, $httpBackend) {
                httpBackend = $httpBackend;
                scope = $rootScope.$new();
                ctrl = $controller("ChangePasswordController", {
                    $scope: scope, SettingsService: SettingsService
                });
            }
        )
    );

    it('should be equals new password and confirm of new password', function () {

        ctrl.currentPassword = '1234';
        ctrl.newPassword = '12345';
        ctrl.confirmPassword = '12345';

        expect(ctrl.isConfirmPasswordEqualToNewPassword()).toBe(true);
    });

    it('should set searchResult on successful search', function () {

        ctrl.currentPassword = '1234';
        ctrl.newPassword = '12345';
        ctrl.confirmPassword = '12345';

        ctrl.updatePassword();

        httpBackend
            .when('POST', '/api/users/change-password')
            .respond(200, { success: 'true' });

        httpBackend.flush();

        expect(ctrl.success).toBe(true);
    });
});
