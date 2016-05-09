<div class="row" ng-init="projectList.loadProjects()" ng-controller="ProjectList as projectList">
    <div class="col-lg-12 col-md-12 col-sm-12 ">
        <div class="col-lg-3 col-md-3 col-sm-3"></div>
        <div class="col-lg-6 col-md-6 col-sm-3"><h4 class="main-title title text-center">Projects</h4></div>
        <select ng-model="orderProp" class="selectpicker col-lg-3 col-md-3 col-sm-12 pull-right">
            <option value="">All</option>
            <option ng-repeat="(status, simpleStatus) in projectList.projectStatuses" value="{{status}}">{{simpleStatus}}</option>
        </select>
    </div>

    <div class="col-lg-12 col-md-12 col-sm-12">
        <div class="col-lg-3 col-md-3 col-sm-3" ng-repeat="project in projectList.projects | filter:orderProp">
            <div class="thumbnail">
                <a href="/projects/{{project.id}}">
                    <img ng-src="{{project.image || projectList.defaultProjectImage}}" class="img-responsive" alt="placeholder image"
                         style="width: 100%; height: 150px;"/>
                </a>
                <div class="caption text-center">
                    <a href="/projects/{{project.id}}" class="resize-text" title="{{project.name}}">
                        <p class="lead long-text">{{project.name}}</p>
                    </a>
                    <div class="progress">
                        <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar"
                            aria-valuenow="{{project.percentApprovedDonate}}" aria-valuemin="0"
                            aria-valuemax="100"
                            ng-style="{'width':project.percentApprovedDonate +'%'}">
                        </div>
                        <div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar"
                             aria-valuenow="{{project.donateSubtractApprovePercent}}" aria-valuemin="0"
                             aria-valuemax="100"
                             ng-style="{'width':project.donateSubtractApprovePercent +'%'}">
                        </div>
                    </div>
                </div>
                <p class="text-center"> {{project.donate_amount}} &#8372; pledged of {{project.needAmount}} &#8372; goal</p>
                <p class="text-center">Created : {{ project.created | date:'dd MMM yyyy'}}</p>
                <p class="text-center">by {{project.fullNameUser}}</p>
                <p class="text-center">Status :
                    <span  class="label label-pill {{projectList.statusForBootstrap(project.status)}}">{{project.simpleStatus}}</span>
                </p>
            </div>
        </div>
    </div>
</div>

