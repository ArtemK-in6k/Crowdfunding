<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script src="<c:url value="/resources/angular/registration/registration_controller.js" />"></script>
<script src="<c:url value="/resources/angular/registration/registration_service.js" />"></script>

<div class="row" ng-controller="RegistrationController as regController">

    <div class="col-lg-6 col-lg-offset-3">
        <form name="regController.regForm" id="registerForm" action="/register" method="post">
            <h3>Registration form</h3>
            <c:if test="${error}">${error}</c:if>
            <div class="form-group">
                <div class="input-group">
                    <input name="firstName"
                           type="text" class="form-control"
                           placeholder="Enter first name" required>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                </div>
            </div>

            <div class="form-group">
                <div class="input-group">
                    <input type="text" class="form-control" name="lastName"
                           placeholder="Enter last name" required>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                </div>
            </div>

            <div class="form-group">
                <div class="input-group">
                    <input ng-model="regController.form.email"
                           ng-change="regController.checkEmailUnique(regController.form.email)" type="email"
                           name="email"
                           class="form-control"
                           placeholder="Enter Email" required>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span>
                        <span ng-if="regController.isEmailNotUnique && !regController.regForm.email.$error.required">Choose another email</span>
                    </span>
                </div>
            </div>


            <div class="form-group">
                <div class="input-group">
                    <input ng-model="regController.form.login"
                           ng-change="regController.checkLoginUnique(regController.form.login)" type="text"
                           class="form-control" name="login" placeholder="Enter login" required>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span>
                        <span ng-if="regController.isLoginNotUnique && !regController.regForm.login.$error.required">Choose another login</span>
                    </span>
                </div>
            </div>

            <div class="form-group">
                <div class="input-group">
                    <input type="password" class="form-control" name="password"
                           placeholder="Enter password" required>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span>
                    </span>
                </div>
            </div>

            <div class="form-group">

                <input type="submit" name="submit" value="Create account" ng-disabled="regController.regForm.$invalid"
                       class="btn btn-success pull-right">
            </div>

        </form>
    </div>
</div>
