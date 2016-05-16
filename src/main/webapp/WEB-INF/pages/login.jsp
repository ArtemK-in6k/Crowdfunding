<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>DOM Test</title>
    <script src="http://code.angularjs.org/1.0.8/angular.js"></script>
    <script src="https://rawgithub.com/mrzmyr/angular-google-plus/master/dist/angular-google-plus.min.js"></script>
    <script src="<c:url value="/resources/angular/loginCtrl.js" />"></script>
</head>

<body ng-app="app" ng-controller="AuthCtrl">
<a href="javascript:void(0);" ng-click="login()">Login with Google Plus</a>
</body>

</html>

