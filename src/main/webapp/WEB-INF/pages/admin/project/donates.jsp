<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<script src="<c:url value="/resources/angular/admin/project/donates/project_donates_controller.js" />"></script>
<script src="<c:url value="/resources/angular/admin/project/donates/project_donates_service.js" />"></script>

<div class="row" ng-init="donates.loadDonates(${projectId})" ng-controller="AdminProjectDonatesController as donates">
    <h2 align="center"> {{ donates.projectName }}</h2>

    <div class="table-container" >
        <h4 align="center">Donations</h4>

        <div ng-if="donates.projectDonates.length == 0" class="text-center text-danger"><h3>Project haven't donations</h3></div>

        <div class="col-lg-12 donate-block">

            <div class="col-lg-4 donate-box" ng-repeat="donate in donates.projectDonates" style="">
                <div class="media">
                    <a href="#" class="pull-left">
                        <img width="75" height="75" src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg"
                             class="media-photo">
                    </a>
                    <div class="media-body">
                        <h5 class="title">
                            {{ donate.ownerName }}
                        </h5>
                        <p class="summary">Donate <span class="money">{{donate.amount | currency:"$" }}</span>, {{ donate.date | date:'MMM dd HH:mm'}}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
