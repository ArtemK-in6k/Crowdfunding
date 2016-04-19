<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div ng-controller="CategoryListController as categoryList" class="row col-lg-8 col-lg-offset-2">
    <div class="container">
        <div class="col-md-5">
            <div class="form-area">
                <form name="createProjectForm" role="form" action='/projects' method="POST">
                    <br style="clear:both">
                    <h3 style="margin-bottom: 25px; text-align: center;">Create Project Form</h3>
                    <div class="form-group">
                        <input type="text" class="form-control" id="projectName" name="projectName"
                               placeholder="Project name" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <input type="number" min="0.01" step="0.01" class="form-control" id="needAmount" name="needAmount"
                               placeholder="Funding goal in &#8372;" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="text" name="image" ng-model="newproject.image" placeholder="Image URL"
                               ng-pattern="/([a-z\-_0-9\/\:\.]*\.(jpg|jpeg|png|gif))/i" />
                    </div>
                    <div class="form-group">
                        <select class="form-control input-md" name="category" required>
                            <option ng-repeat="category in categoryList.categories" value="{{category.id}}">{{category.title}}</option>
                        </select>
                    </div>
                    <div class="form-group">
                            <textarea ng-model = "newproject.aboutProject" id="message" type="textarea" name="aboutProject" class="form-control" rows="10"
                                      cols="100" placeholder="Enter here project description..."
                                      style="resize: none" required>
                            </textarea>
                    </div>
                    <div class="col-md-12 text-center">
                        <button ng-disabled="createProjectForm.$invalid" type="submit" id="submit" name="submit" class="btn btn-primary center-pill">
                            Create
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
