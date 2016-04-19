<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="row" ng-controller="CategoryListController as categoryList">

    <h4 class="main-title text-center title" >Categories</h4>
        <div class="list-group" ng-repeat="category in categoryList.categories">
            <a class="list-group-item" href="/categories/{{ category.id }}/">{{category.title}}</a>
        </div>
    <br/>
    <div class="col-lg-3 col-md-3 col-sm-3"></div>
    <a href="/projects/new" class="btn btn-success col-lg-6 col-md-6 col-sm-6">Create new project</a>
</div>
<script src="<c:url value="/resources/angular/category/categoryList/category_list_controller.js" />"></script>
<script src="<c:url value="/resources/angular/category/categoryList/category_list_service.js" />"></script>
