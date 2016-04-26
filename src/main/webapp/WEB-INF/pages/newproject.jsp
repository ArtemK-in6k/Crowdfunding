<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="row col-sm-9 col-md-9 col-lg-9">
    <div class="container">
        <div class="col-sm-10 col-md-10 col-lg-10">
            <div class="form-area">
                <form name="createProjectForm" role="form" action='/projects' method="POST">
                    <br style="clear:both">
                    <h2 style="margin-bottom: 25px; text-align: center;">Create Project Form</h2>
                    <div class="form-group">
                        <label for="projectName">Project name*</label>
                        <input type="text" class="form-control" id="projectName" ng-model="newproject.name"
                               name="projectName"
                               placeholder="Project name" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="needAmount">Funding goal in &#8372;*</label>
                        <input type="number" min="0.01" step="0.01" class="form-control" id="needAmount"
                               ng-model="newproject.needAmount" name="needAmount"
                               placeholder="Funding goal in &#8372;" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="url">Image URL</label>
                        <input id="url" class="form-control" type="text" name="image" ng-model="newproject.image"
                               placeholder="Image URL"
                               ng-pattern="/([a-z\-_0-9\/\:\.]*\.(jpg|jpeg|png|gif))/i"/>
                    </div>
                    <div class="form-group">
                        <label for="eventUrl">External URL for project description</label>
                        <input id="eventUrl" class="form-control" type="text" name="url" ng-model="newproject.url"
                               placeholder="Project description URL"
                               ng-pattern="/^((?:http|ftp)s?:\/\/)(?:(?:[A-Z0-9](?:[A-Z0-9-]{0,61}[A-Z0-9])?\.)+(?:[A-Z]{2,6}\.?|[A-Z0-9-]{2,}\.?)|localhost|\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})(?::\d+)?(?:\/?|[\/?]\S+)$/i"/>
                    </div>
                    <div class="form-group" ng-controller="AppCtrl as app">
                        <label for="aboutProject">About project</label>
                        <div id="aboutProject" text-angular ng-model="app.htmlcontent" name="aboutProject">
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-12 col-lg-12 text-center">
                        <button ng-disabled="createProjectForm.$invalid" type="submit" id="submit" name="submit"
                                class="btn btn-primary center-pill">
                            Create
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
