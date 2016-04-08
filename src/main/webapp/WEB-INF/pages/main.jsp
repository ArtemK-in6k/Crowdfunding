<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html ng-app="crowdfundingApp">
<head>
    <meta charset="utf-8">
    <title>Crowdfunding</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.min.js"/>
    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
    <spring:url value="resources/angular/controllers.js" var="contrJS"/>
    <script src="${contrJS}"></script>

</head>
<body ng-controller="ProjectList">
<jsp:include page="head.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md-3" style="height: 600px">
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
                <select ng-model="orderProp" class="selectpicker">
                    <option value="1">All</option>
                    <option value="Actual">Actual</option>
                    <option value="Archive">Archive</option>
                    <option value="Whip-round">Whip-round</option>
                </select>
            </nav>
        </div>

        <h3 class="text-success text-center">Projects now</h3>
        <div class="col-md-8">
            <div class="col-sm-6 col-md-6" ng-repeat="projectt in projects | filter:orderProp">
                <div class="thumbnail">
                    <a href="/categories/{{projectt.categoryId}}/projects/{{projectt.id}}">
                        <img ng-src={{projectt.image}} class="img-responsive" alt="placeholder image"
                             style="width: 200px; height: 200px;"/>
                    </a>
                    <div class="caption text-center">
                        <a href="/categories/{{projectt.categoryId}}/projects/{{projectt.id}}">
                            <p class="lead">{{projectt.nameProject}}</p>
                        </a>
                        <div class="progress">
                            <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar"
                                 aria-valuenow="{{projectt.percendDonate}}" aria-valuemin="0"
                                 aria-valuemax="100"
                                 style="width:{{projectt.percendDonate}}%">
                            </div>
                        </div>
                    </div>
                    <p class="text-center">$ {{projectt.donate_amount}} pledged of $ {{projectt.needAmount}} goal</p>
                    <p class="text-center">This project was created : {{projectt.date}}</p>
                    <p class="text-center">by {{projectt.fullNameUser}}</p>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
