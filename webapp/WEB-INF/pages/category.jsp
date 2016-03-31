<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Category</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    <style type="text/css">
    .but {
        margin-top: 2cm;

    }
    </style>
</head>
<body>

<jsp:include page="head.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-4" style="height: 600px">
            <nav class="navmenu navmenu-default" role="navigation">
                <div>
                    <h4 class="text-success">Categories</h4>
                    <ul class="nav navmenu-nav" style="width: 200px">
                        <c:forEach items="${categories}" var="category">
                            <li>
                                <a style="background-color: lightsteelblue" href="/categories/${category.id}"
                                   class="list-group-item">${category.title}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </nav>
            <span/>
            <span/>
            <div class="but">
                <form action="/categories/${idcategory}/newproject" method="POST">
                    <input class="btn btn-success" type="submit" value="Create project"/>
                </form>
            </div>
        </div>
        <h3 class="text-success text-center">Category of ${category.title}</h3>
        <c:forEach items="${projects}" var="project">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <a href="/categories/${project.category.id}/projects/${project.id}">
                        <img class="img-thumbnail" src="${project.image}"
                             alt="placeholder image" style="width: 300px; height: 300px;"/>
                    </a>
                    <div class="caption text-center">
                        <a href="/categories/${project.category.id}/projects/${project.id}">
                            <p class="lead">${project.nameProject}</p></a>
                        <div class="progress">
                            <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar"
                                 aria-valuenow="${project.donate_amount/project.needAmount*100}" aria-valuemin="0"
                                 aria-valuemax="100"
                                 style="width:${project.donate_amount/project.needAmount*100}%">
                            </div>
                        </div>
                        <p>$${project.donate_amount} pledged of $${project.needAmount} goal</p>
                        <form action="/categories/${project.category.id}/projects/${project.id}/donate" method="POST">
                            <input hidden name="projectId" value="${project.id}">
                            <input class="btn btn-success" type="submit" value="Donate"/>
                        </form>
                    </div>

                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
</body>
</html>
