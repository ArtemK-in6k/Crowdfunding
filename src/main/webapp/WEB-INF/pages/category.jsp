<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="row" ng-init="projectList.loadProjects(${category.id})" ng-controller="ProjectList as projectList">

    <div class="col-lg-12 col-md-12 col-sm-12 pull-left" >
        <h4 class="main-title title col-lg-7 col-md-7 col-sm-7">Category of ${category.title}</h4>

        <select ng-model="filterOrd" class="selectpicker col-lg-3 col-md-3 col-sm-3 pull-right">
                <option value="">All</option>
                <option value="Actual">Actual</option>
                <option value="Archive">Archive</option>
                <option value="Whip-round">Whip-round</option>
            </select>
    </div>


    <h4 ng-show="projectList.projects.length == 0" ng-class="{'empty-list': !projectList.projects.length }" ng-cloak align="center">This category yet not have projects</h4>

    <div class="col-lg-12 ">
        <div class="col-lg-4 col-md-4" ng-repeat="project in projectList.projects | filter : filterOrd">
            <div class="thumbnail">
                <a href="/projects/{{project.id}}">
                    <img ng-src={{project.image}} class="img-responsive" alt="placeholder image"
                         style="width: 150px; height: 150px;"/>
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
                <p class="text-center">{{project.donate_amount | currency}} pledged of {{project.needAmount | currency}} goal</p>
                <p class="text-center">Created : {{ project.created | date:'MM.dd.yy'}}</p>
                <p class="text-center">by {{project.fullNameUser}}</p>
                <p class="text-center">Status : {{project.status}}</p>
            </div>
        </div>
    </div>
</div>