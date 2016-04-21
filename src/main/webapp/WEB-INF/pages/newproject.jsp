<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="row col-lg-9">
    <div class="container">
        <div class="col-md-10">
            <div class="form-area">
                <form name="createProjectForm" role="form" action='/projects' method="POST">
                    <br style="clear:both">
                    <h3 style="margin-bottom: 25px; text-align: left;">Create Project Form</h3>
                    <div class="form-group">
                        <input type="text" class="form-control" id="projectName" name="projectName"
                               placeholder="Project name" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <input type="number" min="0.01" step="0.01" class="form-control" id="needAmount"
                               name="needAmount"
                               placeholder="Funding goal in &#8372;" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="text" name="image" ng-model="newproject.image"
                               placeholder="Image URL"
                               ng-pattern="/([a-z\-_0-9\/\:\.]*\.(jpg|jpeg|png|gif))/i"/>
                    </div>
                    <div class="form-group" ng-controller="AppCtrl as app">
                        <div text-angular ng-model="app.htmlcontent" name="aboutProject">

                        </div>
                    </div>
                    <br/>
                    <div class="col-md-12 text-center">
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
