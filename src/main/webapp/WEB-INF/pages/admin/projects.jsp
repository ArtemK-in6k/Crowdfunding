<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div ng-controller="ProjectListForAdmin">
    <div class="col-sm-12 col-md-12">
        <div ng-show="projectUpdateSuccess" class="alert-success alert text-center">Project updated successful</div>
        <div ng-show="projectDeleteSuccess" class="alert-danger alert text-center">Project {{projectDelete}} delete successful</div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th></th>
                <th class="text-center">Project name</th>
                <th class="text-center">Author</th>
                <th class="text-center">Actual amount</th>
                <th class="text-center">Need amount</th>
                <th class="text-center">Status</th>
                <th class="text-center">Action</th>
            </tr>
            </thead>
            <tbody class="text-center" ng-repeat="project in projects | orderBy : 'id' ">
            <tr>
                <td>
                    <img src="{{project.image}}" height="50px" width="50px">
                </td>
                <td>
                    {{project.nameProject}}
                </td>
                <td>
                    {{project.fullNameUser}}
                </td>
                <td>{{project.donate_amount}}</td>
                <td>{{project.needAmount}}</td>
                <td>
                    <select class="form-control" ng-model="project.status">
                        <option value="Archive">Archive</option>
                        <option value="Actual">Actual</option>
                        <option value="Whip-round">Whip-round</option>
                    </select>
                </td>
                <td>
                    <button type="button" class="btn btn-primary btn-sm" ng-click="updateStatus(project.status, project.id)">Update</button>
                    <button class="btn btn-danger btn-sm" confirmed-click="deleteProject(project.id,project.nameProject)" ng-confirm-click={{project.nameProject}}>Delete</button>
                </td>
            </tr>
            </tbody>
        </table>

        <div ng-if="projects.length == 0" class="text-center text-danger"><h3>Sorry, we have any projects</h3></div>
    </div>
</div>
