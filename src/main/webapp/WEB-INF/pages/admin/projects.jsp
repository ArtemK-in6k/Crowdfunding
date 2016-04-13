<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div ng-controller="ProjectListForAdmin">
    <div class="col-sm-12 col-md-12">
        <div ng-show="projectUpdateSuccess" class="alert-success alert text-center">Project updated successful</div>
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
                    <%--<div class="md-padding" id="popupContainer" ng-cloak>--%>
                        <%--<div class="dialog-demo-content" layout="row" layout-wrap layout-margin layout-align="center">--%>
                        <%--<md-button class="md-primary md-raised"--%>
                                   <%--ng-click="updateStatus($event,project.status, project.id)showConfirm(,phone.name)">--%>
                            <%--Update--%>
                        <%--</md-button>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <button type="button" class="btn btn-primary btn-sm" ng-click="updateStatus(project.status, project.id)">Update</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
