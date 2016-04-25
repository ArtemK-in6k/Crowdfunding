<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<script src="<c:url value="/resources/angular/control/clickDirective.js" />"></script>

<div ng-controller="OwnProjects">
    <div class="col-sm-12 col-md-12 col-lg-12">
        <h3 class="text-center">My Projects</h3>
        <div ng-show="projectUpdateSuccess" class="alert-success alert text-center">Project updated successful</div>
        <div ng-show="projectDeleteSuccess" class="alert-danger alert text-center">Project {{projectDelete}} delete successful</div>
        <table class="table table-hover table-project">
            <thead>
            <tr>
                <th></th>
                <th class="text-center">Project name</th>
                <th class="text-center">Raised</th>
                <th class="text-center">Goal</th>
                <th class="text-center">Status</th>
                <th class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <tr class="text-center" ng-repeat="project in projects | orderBy : 'id' ">
                <td>
                    <img ng-src="{{project.image}}" height="50px" width="50px">
                </td>
                <td>
                    <div class="table-long-text">
                        <a href="/projects/{{project.id}}"> {{project.nameProject}} </a>
                    </div>
                </td>
                <td>{{project.donate_amount}} &#8372;</td>
                <td>{{project.needAmount}} &#8372;</td>
                <td>
                    <p ng-if="project.status != 'FOUNDED'" class="table-{{project.status}}">{{project.simpleStatus}}</p>
                    <button ng-if="project.status == 'FOUNDED'" type="button" class="btn btn-primary btn-sm" ng-click="updateStatus('COMPLETED', project.id)">Complete</button>
                </td>
                <td>
                    <button class="btn btn-danger btn-sm" confirmed-click="deleteProject(project.id,project.nameProject)" ng-confirm-click={{project.nameProject}}>Remove</button>
                </td>
            </tr>
            <tr class="text-center" >
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <a href="/projects/new" class="btn btn-success">Create new project</a>
                </td>
            </tr>
            </tbody>
        </table>
        <div ng-if="projects.length == 0" class="text-center text-danger"><h3>Sorry, you don't have any projects</h3></div>
    </div>
</div>
