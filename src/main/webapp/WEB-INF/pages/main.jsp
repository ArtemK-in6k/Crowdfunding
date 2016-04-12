<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

    <div class="row"  ng-controller="ProjectList">
        <div class="col-md-3" style="height: 600px">
            <nav class="navmenu navmenu-default" role="navigation">
                <div>
                    <h4 class="text-success" style="text-indent: 60px">Categories</h4>
                    <ul class="nav navmenu-nav" style="width: 200px">
                        <c:forEach items="${categories}" var="category">
                            <li>
                                <a style="background-color: lightsteelblue" href="/categories/${category.id}/"
                                   class="list-group-item">${category.title}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </nav>
        </div>

        <h3 class="text-success text-center">Projects now</h3>

        <div style="float:right;top:10px;right:30px;">
            <select ng-model="orderProp" class="selectpicker" style="max-width:90%;">
                <option value="">All</option>
                <option value="Actual">Actual</option>
                <option value="Archive">Archive</option>
                <option value="Whip-round">Whip-round</option>
            </select>
        </div>

        <div class="col-md-8">
            <div class="col-sm-6 col-md-6" ng-repeat="project in projects | filter:orderProp">
                <div class="thumbnail">
                    <a href="/projects/{{project.id}}">
                        <img ng-src={{project.image}} class="img-responsive" alt="placeholder image"
                             style="width: 200px; height: 200px;"/>
                    </a>
                    <div class="caption text-center">
                        <a href="/projects/{{project.id}}">
                            <p class="lead">{{project.nameProject}}</p>
                        </a>
                        <div class="progress">
                            <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar"
                                 aria-valuenow="{{project.percendDonate}}" aria-valuemin="0"
                                 aria-valuemax="100"
                                 style="width:{{project.percendDonate}}%">
                            </div>
                        </div>
                    </div>
                    <p class="text-center">$ {{project.donate_amount}} pledged of $ {{project.needAmount}} goal</p>
                    <p class="text-center">This project was created : {{project.date}}</p>
                    <p class="text-center">by {{project.fullNameUser}}</p>
                    <p class="text-center">Status : {{project.status}}</p>
                </div>
            </div>
        </div>
    </div>
</div>

