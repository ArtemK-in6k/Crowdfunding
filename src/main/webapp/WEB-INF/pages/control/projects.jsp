<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<script src="<c:url value="/resources/angular/control/clickDirective.js" />"></script>

<div ng-controller="OwnProjects as ownProjects">
    <div class=" ">
        <h3 class="text-center">My Projects</h3>
        <a ng-click="ownProjects.openCreateProjectModal('lg')" style="z-index: 1545!important;" class="btn btn-success btn-sm pull-right" style="margin-right:15px">Create new project</a>
        <div ng-show="ownProjects.projectUpdateSuccess" style="z-index: 1!important;" class="alert-success alert text-center">Project updated successful</div>
        <div ng-show="ownProjects.projectDeleteSuccess" style="z-index: 1!important;" class="alert-danger alert text-center">Project {{ownProjects.projectDelete}} delete successful</div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th></th>
                <th class="text-center">Project name</th>
                <th class="text-center">Author</th>
                <th class="text-center">Raised</th>
                <th class="text-center">Goal</th>
                <th class="text-center">Status</th>
                <th class="text-center" > </th>
            </tr>
            </thead>
            <tbody>
            <tr class="text-center" ng-repeat="project in ownProjects.projects | orderBy : 'id' ">
                <td>
                    <img ng-src="{{project.image || '/resources/img/no_img.jpg'}}" height="50px" width="50px">
                </td>
                <td>
                    <a href="/projects/{{project.id}}"> {{project.nameProject}} </a>
                </td>
                <td>
                    {{project.fullNameUser}}
                </td>
                <td>{{project.donate_amount}} &#8372;</td>
                <td>{{project.needAmount}} &#8372;</td>
                <td>
                    <select class="form-control" ng-model="project.status">
                        <option value="Archive">Archive</option>
                        <option value="Actual">Actual</option>
                        <option value="Whip-round">On going</option>
                    </select>
                </td>
                <td>
                    <div class="pull-right">
                        <button type="button" class="btn btn-primary btn-sm" ng-click="ownProjects.updateStatus(project.status, project.id)">Update</button>
                        <button class="btn btn-danger btn-sm" confirmed-click="ownProjects.deleteProject(project.id,project.nameProject)" ng-confirm-click={{project.nameProject}}>Remove</button>
                    </div>
               </td>
            </tr>
            </tbody>
        </table>
        <div ng-if="projects.length == 0" class="text-center text-danger"><h3>Sorry, you don't have any projects</h3></div>
    </div>
</div>
