<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row" ng-controller="CategoryListController as categoryList">
    <h4 class="text-success text-center title" >Categories</h4>
        <div class="list-group" ng-repeat="category in categoryList.categories">
            <a class="list-group-item" href="/categories/{{ category.id }}/">{{category.title}}</a>
        </div>
</div>
<script src="<c:url value="/resources/angular/category/categoryList/category_list_controller.js" />"></script>
<script src="<c:url value="/resources/angular/category/categoryList/category_list_service.js" />"></script>
