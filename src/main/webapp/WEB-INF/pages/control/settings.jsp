<div ng-controller="ChangePasswordController as changePassword">
    <h3 class="text-center">Settings</h3>
    <h4 class="text-center">Change account password form</h4>
    <form class="form-horizontal col-lg-12" role="form" name="changePassword.changeForm">
        <div ng-show="changePassword.success" class="alert-success alert text-center">Password updated successful</div>
        <div ng-if="!changePassword.success && changePassword.errorMessage" class="alert-danger alert text-center">{{ changePassword.errorMessage }}</div>

        <div class="form-group">
            <label class="control-label col-sm-3 required" for="currentPassowrd">Current password:</label>
            <div class="col-sm-9">
                <input ng-model="changePassword.currentPassword" name="currentPassword"
                       type="password" class="form-control" id="currentPassowrd" placeholder="Enter current password" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3 required" for="pwd">New Password:</label>
            <div class="col-sm-9">
                <input ng-model="changePassword.newPassword" name="newPassword"
                       type="password" class="form-control" id="pwd" placeholder="Enter new password" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3 required" for="confirmPwd">Confirm password:</label>
            <div class="col-sm-9">
                <input ng-model="changePassword.confirmPassword" name="confirmPassword"
                       type="password" class="form-control" id="confirmPwd" placeholder="Confirm new password"
                       required>
                <span class="error-text" ng-if="changePassword.passwordsNotEquals"> Password does not match the new password</span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default pull-right" ng-disabled="changePassword.changeForm.$invalid" ng-click="changePassword.updatePassword()">Change password</button>
            </div>
        </div>
    </form>
</div>