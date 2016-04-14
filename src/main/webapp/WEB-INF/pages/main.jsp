<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<div class="row" ng-init="projectList.loadProjects()" ng-controller="ProjectList as projectList">

    <div class="row form-inline">
        <h4 class="text-success text-center title">Projects now</h4>

        <select ng-model="orderProp" class="selectpicker pull-right">
            <option value="">All</option>
            <option value="Actual">Actual</option>
            <option value="Archive">Archive</option>
            <option value="Whip-round">Whip-round</option>
        </select>
    </div>

    <div class="col-lg-7 projects-block">
        <div class="col-lg-6"  ng-repeat="project in projectList.projects | filter:orderProp">
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
                             ng-style="{'width':project.percendDonate +'%'}"
                           >
                        </div>
                    </div>
                </div>
                <p class="text-center"> {{project.donate_amount | currency}} pledged of {{project.needAmount | currency}} goal</p>
                <p class="text-center">Created : {{project.date}}</p>
                <p class="text-center">by {{project.fullNameUser}}</p>
                <p class="text-center">Status : {{project.status}}</p>
            </div>
        </div>
    </div>
</div>

