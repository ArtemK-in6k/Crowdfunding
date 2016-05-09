<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<script src="<c:url value="/resources/angular/control/clickDirective.js" />"></script>

<div ng-controller="OwnProjects as ownProjects">
    <div class=" ">
        <div class="row">
            <div class="h3 text-center">My Projects
                <a ng-click="ownProjects.openCreateProjectModal('lg')"
                   class="btn btn-primary btn-sm pull-right create-project-modal-btn">Create new project</a>
            </div>
        </div>

        <table class="table table-hover table-project">
            <thead>
            <tr>
                <th></th>
                <th class="text-center">Project name</th>
                <th class="text-center">Raised(Percent)</th>
                <th class="text-center">Goal</th>
                <th class="text-center">Status</th>
                <th class="text-center"></th>
            </tr>
            </thead>
            <tbody>
            <tr class="text-center" ng-repeat="project in ownProjects.projects | orderBy : '-id' ">
                <td>
                    <img ng-src="{{project.image || '/resources/img/no_img.jpg'}}" height="50px" width="50px">
                </td>
                <td>
                    <div class="table-long-text">
                        <a href="/projects/{{project.id}}" title="{{project.name}}">
                            {{project.name}} </a>
                    </div>
                </td>
                <td>{{project.donate_amount}} &#8372;({{project.percendDonate}}%)</td>
                <td>{{project.needAmount}} &#8372;</td>
                <td>

                    <p ng-if="project.status != 'FUNDED'" class="table-{{project.status}}">
                        {{project.simpleStatus}}</p>
                    <button ng-if="project.status == 'FUNDED'" type="button" class="btn btn-primary btn-sm"
                            ng-click="ownProjects.changeStatusOnComplete(project.id)">
                        Complete
                    </button>
                </td>
                <td>
                    <div class="pull-right">
                        <button class="btn btn-danger btn-sm"
                                confirmed-click="ownProjects.deleteProject(project.id,project.name)"
                                ng-confirm-click="{{project.name}}">Remove
                        </button>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
        <div ng-if="ownProjects.projects.length == 0" class="text-center text-danger"><h3>Sorry, you don't have any
            projects</h3>
        </div>
    </div>
</div>
