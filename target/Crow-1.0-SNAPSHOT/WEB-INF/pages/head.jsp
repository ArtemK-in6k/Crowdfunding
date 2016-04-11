<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<nav class="navbar-inverse navbar-custom" role="navigation">
    <div class="row">
        <div class="collapse navbar-collapse" style="background-color: palegoldenrod" id="bs-example-navbar-collapse-1">
            <div class="navbar-header navbar-left navbar">
                <a class="navbar-brand text-left" style="line-height: 40px; position: relative; top: 30px;font-size: 1.8em;" href="/">Crowdfunding</a>
      </div>

            <form class="navbar-form navbar-right" style="line-height: 50px" role="search" action="/search"
                  method="post">
                <div class="form-group">
                    <input id="search" name="search" type="text" class="form-control" placeholder="Search">
                    <select class="selectpicker" name="select">
                        <option value="project">by project name</option>
                        <option value="user">by full name</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">Search</button>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>
        </div>
    </div>
    <div class="row" style="background-color: palegoldenrod;">
        <div class="navbar-header navbar-right form-group" style="padding-right: 40px">
            <c:url value="/logout" var="logoutUrl"/>

            <!-- csrt for log out-->
            <form action="${logoutUrl}" method="post" id="logoutForm">
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>

            <script>
                function formSubmit() {
                    document.getElementById("logoutForm").submit();
                }
            </script>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <h3>
                    Welcome : ${pageContext.request.userPrincipal.name} | <a
                        href="javascript:formSubmit()"> Logout</a>
                </h3>
            </c:if>
        </div>
    </div>
</nav>

