<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <spring:url value="/resources/css/main.css" var="mainCss" />
    <spring:url value="/resources/js/bootstrap.js" var="mainJs" />

    <link href="${mainCss}" rel="stylesheet" />
    <script src="${mainJs}"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Crowdfunding</title>
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
                        <c:forEach items="${categories}" var="category">
                            <li>
                                <a style="background-color: lightsteelblue" href="/categories/${category.id}"
                                   class="list-group-item">${category.title}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </nav>
        </div>
        <h3 class="text-success text-center">Projects now</h3>
        <div class="col-md-8">
            <c:forEach items="${projects}" var="project">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <a href="/categories/${project.category.id}/projects/${project.id}">
                        <img class="img-thumbnail" src="http://dummy-images.com/objects/dummy-200x200-Cup.jpg"
                             alt="placeholder image"/></a>
                    <div class="caption text-center">
                        <a href="/categories/${project.category.id}/projects/${project.id}">
                            <p class="lead">${project.nameProject}</p>
                        </a>
                        <div class="progress">
                            <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar"
                                 aria-valuenow="${project.donate_amount/project.needAmount*100}" aria-valuemin="0"
                                 aria-valuemax="100" style="width:${project.donate_amount/project.needAmount*100}%"/>
                        </div>
                    </div>
                    <p>Donate amount : ${project.donate_amount}</p>
                    <p>Need amount : ${project.needAmount} </p>
                    <p>${project.date.date}-${project.date.month + 1}-${project.date.year + 1900}</p>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>
</div>
</body>
</html>
