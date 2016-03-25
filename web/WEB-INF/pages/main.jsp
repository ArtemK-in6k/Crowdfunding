<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Online-Shop</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
</head>
<body>
<jsp:include page="head.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <nav class="navmenu navmenu-default" role="navigation">
                <div>
                    <h4 class="text-success">Categories</h4>
                    <ul class="nav navmenu-nav" style="width: 200px">
                        <c:forEach items="${userList}" var="cat">
                            <li>
                                <a style="background-color: khaki" href="/category/${cat.getId()}"
                                   class="list-group-item">${cat.getTitle()}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

            </nav>
        </div>
        <h3 class="text-success text-center">Categories</h3>
        <div class="col-md-8">
            <c:forEach items="${categories}" var="cat">

                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <a href="/category/${cat.getId()}">
                            <img class="img-circle" src="http://dummy-images.com/objects/dummy-200x200-Cup.jpg" alt="placeholder image"/></a>
                        <div class="caption text-center">
                            <a href="/category/${cat.getId()}"><p class="lead">${cat.title}</p></a>
                        </div>
                    </div>
                </div>

            </c:forEach>
        </div>
    </div>
</div>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
</body>
</html>
