<div ng-controller="ChangePasswordController as changePassword">
    <h3 class="text-center">Settings</h3>

    <form angular-validator-submit="changePassword.updatePassword()" name="form" class="form-horizontal" novalidate angular-validator>
        <h4>Change account password form:</h4>
        <div class="form-group">
            <label class="col-sm-3 control-label">Old password</label>
            <div class="col-sm-9">
                <input  type = "password"
                        name = "currentPassword"
                        class = "form-control"
                        ng-model = "changePassword.currentPassword"
                        required-message="'This field is required..'"
                        required></div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">New password</label>
            <div class="col-sm-9">
                <input  type = "password"
                        name = "password"
                        class = "form-control"
                        ng-model = "changePassword.newPassword"
                        required-message="'This field is required..'"
                        required></div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Confirm new password</label>
            <div class="col-sm-9">
                <input  type = "password"
                        name = "confirmPassword"
                        class = "form-control"
                        ng-model = "changePassword.confirmPassword"
                        required-message="'This field is required..'"
                        validator = "changePassword.newPassword === changePassword.confirmPassword"
                        validate-on="dirty"
                        invalid-message = "'Passwords do not match!'"
                        required></div>
        </div>
        <hr>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
                <button type="submit" class="btn btn-primary">Change password</button>
                <button type="button" ng-click="form.reset()" class="btn btn-default">Reset</button>
            </div>
        </div>
    </form>
</div>