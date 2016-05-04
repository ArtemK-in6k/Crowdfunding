<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<script src="<c:url value="/resources/angular/control/clickDonateDirective.js" />"></script>

<div ng-controller="OwnDonates as ownDonates">
    <div class="">
        <h3 class="text-center">My Donations</h3>
        <div ng-show="ownDonates.donationUpdateSuccess" class="alert-success alert text-center">Donation updated
            successful
        </div>
        <div ng-show="ownDonates.donateDeleteSuccess" class="alert-danger alert text-center">Donation
            {{ownDonates.donateDelete}} delete successful
        </div>
        <div ng-show="ownDonates.donateDeleteWarning" class="alert-warning alert text-center">You can't delete
            {{ownDonates.donateDelete}},because this project have move than 90% donates
        </div>
        <table class="table table-hover donate-list">
            <thead>
            <tr>
                <th></th>
                <th class="text-center">Project name</th>
                <th class="text-center">Raised</th>
                <th class="text-center">Goal</th>
                <th class="text-center">Your contribution</th>
                <th class="text-center"></th>
            </tr>
            </thead>
            <tbody class="text-center" ng-repeat="donate in ownDonates.donates | orderBy:'id'">
            <tr>
                <td>
                    <img ng-src="{{donate.image || '/resources/img/no_img.jpg'}}" height="50px" width="50px">
                </td>
                <td>
                    <div class="table-long-text">
                        <a class="table-long-text" href="/projects/{{donate.projectId}}" title="{{donate.projectName}}">
                            {{donate.projectName}} </a>
                    </div>
                </td>
                <td>{{donate.donateAmount}} &#8372;</td>
                <td>{{donate.needAmount}} &#8372;</td>
                <td>
                    <span class="form-control-inline" e-min="1" editable-number="donate.donate" e-name="donation"
                          e-form="rowform" onbeforesave="ownDonates.saveDonate($data, donate.id)" e-required>
                            {{donate.donate}} &#8372;</span>
                </td>
                <td>
                    <div class="pull-right">
                        <button class="btn btn-primary btn-sm" ng-click="rowform.$show()">Edit</button>
                        <button class="btn btn-danger btn-sm"
                                confirmed-click="ownDonates.deleteDonate(donate.id,donate.projectName)"
                                ng-confirm-click-donate={{donate.projectName}}>Remove
                        </button>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
        <div ng-if="ownDonates.donates.length == 0" class="text-center text-danger"><h3>Sorry, you haven't any
            donations</h3></div>
    </div>
</div>
