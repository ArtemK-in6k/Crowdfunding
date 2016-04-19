<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<script src="<c:url value="/resources/angular/control/controlDonateCtrl.js" />"></script>
<script src="<c:url value="/resources/angular/control/clickDonateDirective.js" />"></script>

<div ng-controller="OwnDonates">
    <div class="col-sm-12 col-md-12">
        <h3 class="text-center">My Donations</h3>
        <div ng-show="donateDeleteSuccess" class="alert-danger alert text-center">Donation {{donateDelete}} delete successful</div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th></th>
                <th class="text-center">Project name</th>
                <th class="text-center">Author</th>
                <th class="text-center">Actual amount</th>
                <th class="text-center">Need amount</th>
                <th class="text-center">Your donate</th>
                <th class="text-center">Action</th>
            </tr>
            </thead>
            <tbody class="text-center" ng-repeat="donate in donates">
            <tr>
                <td>
                    <img src="{{donate.image}}" height="50px" width="50px">
                </td>
                <td>
                    <a href="/projects/{{donate.projectId}}"> {{donate.projectName}} </a>
                </td>
                <td>{{donate.author}}</td>
                <td>{{donate.donateAmount}}</td>
                <td>{{donate.needAmount}}</td>
                <td>{{donate.donate}}</td>
                <td>
                    <button class="btn btn-danger btn-sm" confirmed-click="deleteProject(donate.id)" ng-confirm-click={{donate.projectName}}>Delete</button>
                </td>
            </tr>
            </tbody>
        </table>
        <div ng-if="donates.length == 0" class="text-center text-danger"><h3>Sorry, you haven't any donations</h3></div>
    </div>
</div>
