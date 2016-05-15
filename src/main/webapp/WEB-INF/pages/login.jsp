<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<html>--%>
<%--<head>--%>
<%--<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>--%>
<%--<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>--%>
<%--<spring:url value="/resources/css/form.css" var="form"/>--%>
<%--<link href="${form}" type="text/css" rel="stylesheet"/>--%>
<%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="login-wrap">--%>
<%--<h2>Login</h2>--%>
<%--<form name="loginForm" action='/j_spring_security_check' method='post'>--%>
<%--<div class="form">--%>
<%--<input id="user" type="text" placeholder="Username" name="j_username"/>--%>
<%--<input id="pass" type="password" placeholder="Password" name="j_password"/>--%>
<%--<button> Sign in</button>--%>
<%--<a href="/register"><p> Don't have an account? Register </p></a>--%>
<%--</div>--%>
<%--<input type="hidden" name="${_csrf.parameterName}"--%>
<%--value="${_csrf.token}"/>--%>
<%--</form>--%>
<%--</div>--%>
<%--<spring:url value="resources/js/form.js" var="formJs"/>--%>
<%--<script src="${formJs}"></script>--%>
<%--</body>--%>
<%--</html>--%>

<%--<html lang="en">--%>
<%--<head>--%>
<%--<meta name="google-signin-scope" content="profile email">--%>
<%--<meta name="google-signin-client_id" content="220560473769-vinejdb28vpnrdmvqd22u0m3knltdi80.apps.googleusercontent.com">--%>
<%--<script src="https://apis.google.com/js/platform.js" async defer></script>--%>
<%--<script src="<c:url value="/resources/angular/onSign.js" />"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>--%>
<%--</body>--%>
<%--</html>--%>

<!DOCTYPE html>
<html>

<head>
    <title>DOM Test</title>
    <script src="http://code.angularjs.org/1.0.8/angular.js"></script>
    <script src="https://rawgithub.com/mrzmyr/angular-google-plus/master/dist/angular-google-plus.min.js"></script>
    <script>

        var app = angular.module('app', ['googleplus']);

        app.config(['GooglePlusProvider', function (GooglePlusProvider) {
            GooglePlusProvider.init({
                clientId: '220560473769-vinejdb28vpnrdmvqd22u0m3knltdi80.apps.googleusercontent.com',
                apiKey: 'cCVyo43S7V5ygqpA94ouFan1'

            });
            GooglePlusProvider.setScopes('profile email');
        }]);

        app.controller('AuthCtrl', ['$scope', 'GooglePlus', '$http', function ($scope, GooglePlus, $http) {
            $scope.login = function () {
                GooglePlus.login().then(function (authResult) {
                    console.log(authResult);

                    GooglePlus.getUser().then(function (user) {
                        console.log(user);
                        var googleuser = {
                            email: user.email,
                            family_name: user.family_name,
                            given_name: user.given_name,
                            name: user.name
                        };
                        $http.post("/login", googleuser).success(function (data) {
                        });
                    });

                    self.loadProjects = function (category) {
                        var url = (category) ? '/projects/categories/' + category : '/projects';

                    };
                }, function (err) {
                    console.log(err);
                });
            };
        }])
    </script>
</head>

<body ng-app="app" ng-controller="AuthCtrl">
<a href="javascript:void(0);" ng-click="login()">Login with Google Plus</a>
</body>

</html>

