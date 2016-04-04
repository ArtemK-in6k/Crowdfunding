<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <%--<spring:url value="/resources/css/form.css" var="form"/>--%>
    <%--<link href="${form}" type="text/css" rel="stylesheet"/>--%>
    <link th:href="@{/resources/css/form.css}" type="text/css" rel="stylesheet" href="/resources/css/form.css"/>


    <title>Title</title>
</head>
<body>
<div class="login-wrap">
    <h2>Login</h2>
    <form name="loginForm" action='/login' method='post'>

        <div class="form">
            <input type="text" placeholder="Username" name="user"/>
            <input type="password" placeholder="Password" name="password"/>
            <button> Sign in</button>
            <a href="#"><p> Don't have an account? Register </p></a>
        </div>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
</div>

<spring:url value="resources/js/form.js" var="formJs"/>
<script src="${formJs}"></script>

</body>
</html>
