<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <spring:url value="/resources/css/form.css" var="form"/>
    <link href="${form}" type="text/css" rel="stylesheet"/>
    <title>Title</title>
</head>
<body>
<div class="login-wrap">
    <h2>Login</h2>
    <form name="loginForm" action='/j_spring_security_check' method='post'>
        <div class="form">
            <input type="text" placeholder="Username" name="j_username"/>
            <input type="password" placeholder="Password" name="j_password"/>
            <button> Sign in</button>
            <a href="/register"><p> Don't have an account? Register </p></a>
        </div>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
</div>
<spring:url value="resources/js/form.js" var="formJs"/>
<script src="${formJs}"></script>
</body>
</html>
