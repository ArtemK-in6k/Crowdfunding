<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="row " ng-controller="ProjectDetailsController as projectDetails"
     ng-init="projectDetails.getProjectData(${projectId})" ng-cloack>
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding: 15px">
        <span class="text-black h3 m-r ng-binding">{{projectDetails.project.nameProject}}</span>
        <div class="text-muted m-t-xs ng-binding">
            <span ng-if="projectDetails.project.urlPresent"><i class="fa fa-link"></i> <a
                    href="{{projectDetails.project.url}}" target="_blank">See game details</a></span>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
            <div class="panel panel-default">
                <img class="img-responsive project-details-img"
                     ng-src="{{projectDetails.project.image || projectDetails.defaultProjectImage}}"
                     alt="placeholder image"/>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="text-center">
                        <div ta-bind ng-model="projectDetails.project.aboutProject"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
            <div class="panel panel-default">
                <div class="panel-body">
                    <span class="donate-pledged">{{projectDetails.project.donate_amount}} &#8372;</span>
                    <span class="donate-pledged-sub">pledged of {{projectDetails.project.needAmount}} &#8372; goal</span>
                    <div class="progress">
                        <div class="progress-bar" role="progressbar" aria-valuenow="{{project.percendDonate}}"
                             aria-valuemin="0" aria-valuemax="100"
                             style="width:{{projectDetails.project.percendDonate}}%">
                        </div>
                    </div>
                    <span class="donate-pledged-sub"> {{projectDetails.project.percendDonate}}%</span>

                    <div class="support-block" ng-if="projectDetails.project.status != 'COMPLETED'">
                        <span class="text-muted text-md ">Support the project directly:</span>
                        <div class=" text-center support-input-block">
                            <form action="/projects/${projectId}/donate" method="POST">
                                <div class="col-lg-3 no-padding">
                                    <input class="form-control text-center" value="15" min="1" name="amount"
                                           placeholder="Amount" type="number">
                                </div>
                                <div class="col-lg-8 col-md-8 pull-right-lg no-padding">
                                    <button type="submit" data-toggle="modal"
                                            class="btn btn-primary btn-lg donate-btn">Donate
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.panel -->
            <div class="short-project-details panel panel-default">
                <div class="panel-body">
                    <a class="pull-left" href="#">
                        <img width="75" height="75" ng-src="{{projectDetails.avatarImageUrl}}" class="media-photo">
                    </a>
                    <div class="media-body ">
                        <div class="project-owner-info">
                            <h4 class="media-heading text-bold">{{projectDetails.project.fullNameUser}}</h4>
                            <p class="label label-info">Project owner</p>
                            <p>
                                Project was created on {{ projectDetails.project.created | date:'dd MMM yyyy'}}
                            </p>
                        </div>

                    </div>
                </div>
                <!-- /.panel-body -->
            </div>
            <div class="panel panel-default">
                <div class="text-center"><h4 class="title">Donations</h4></div>
                <!-- /.panel-heading -->
                <div id="project-donates-box" class="panel-body" ng-init="projectDonates.loadDonates(${projectId})"
                     ng-animate="{enter: 'animate-enter', leave: 'animate-leave'}"
                     ng-controller="ProjectDonateListController as projectDonates">
                    <div class="list-group " ng-class="{'donate-box-approved':donate.approved, 'donate-box-not-approved' :!donate.approved }"
                         ng-repeat="donate in projectDonates.donateList | startFrom: projectDonates.pagination.page * projectDonates.pagination.perPage | limitTo: projectDonates.pagination.perPage">
                        <div class="media ">
                            <a href="#" class="pull-left">
                                <img width="35" height="35" ng-src="{{projectDetails.avatarImageUrl}}"
                                     class="media-photo">
                            </a>
                            <div class="media-body text-center " >
                                    <div class="donate-box-details">
                                        <span class="donate-owner-title pull-left"> {{ donate.ownerName }}</span>

                                        <a confirmed-click="projectDonates.approveDonate(donate.id,projectDetails.project.id)"
                                           ng-if="projectDetails.project.editable && !donate.approved"
                                           ng-confirm-click
                                           class="pull-right donate-approve"><i class="fa fa-plus" aria-hidden="true"></i></a>

                                        <span id="amount" ng-class="{'badge-approved':donate.approved, 'badge-not-approved':!donate.approved}" class="badge pull-right">{{ donate.amount}}  &#8372;</span>
                                    </div>
                            </div>
                        </div>
                    </div>
                    <h5 align="center" class="error-text" ng-if="projectDonates.donateList.length == 0"> The Project
                        still hasn't donations.</h5>
                    <div class="text-center donate-pagination-box"
                         ng-if="projectDonates.donateList.length != 0 && projectDonates.pagination.numPages > 1 ">
                        <ul class="pagination">
                            <li><a href="" ng-click="projectDonates.pagination.prevPage()">&laquo;</a></li>
                            <li ng-repeat="n in [] | range: projectDonates.pagination.numPages"
                                ng-class="{active: n == projectDonates.pagination.page}">
                                <a href="" ng-click="projectDonates.pagination.toPageId(n)">{{n + 1}}</a>
                            </li>
                            <li><a href="" ng-click="projectDonates.pagination.nextPage()">&raquo;</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>