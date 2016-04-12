<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<style type="text/css">
    .but {
        margin-top: 2cm;

    }
</style>
<div class="row" ng-controller="ProjectList">

    <h4 class="text-success title" align="center">Category of ${category.title}</h4>

    <div class="row">
        <div class="pull-right">
            <div class="form-inline">
                <div class="form-group">
                    <select ng-model="filterOrd" class="selectpicker ">
                        <option value="">All</option>
                        <option value="Actual">Actual</option>
                        <option value="Archive">Archive</option>
                        <option value="Whip-round">Whip-round</option>
                    </select>
                </div>
                <div class="form-group">
                    <a href="/categories/${idcategory}/newproject" class="btn btn-success">Create project</a>

                </div>

            </div>
        </div>
    </div>


    <div class="col-md-8 projects-block">
        <div class="col-sm-6 col-md-6" ng-repeat="project in projects | filter : filterOrd">
            <div class="thumbnail">
                <a href="/categories/{{project.categoryId}}/projects/{{project.id}}">
                    <img ng-src={{project.image}} class="img-responsive" alt="placeholder image"
                         style="width: 200px; height: 200px;"/>
                </a>
                <div class="caption text-center">
                    <a href="/categories/{{project.categoryId}}/projects/{{project.id}}">
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
                <p class="text-center">Created : {{project.date}}</p>
                <p class="text-center">by {{project.fullNameUser}}</p>
                <p class="text-center">Status : {{project.status}}</p>
            </div>
        </div>
    </div>
</div>