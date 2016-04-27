<div class="form-area create-project-modal">
    <form name="createProjectForm" role="form" action='/projects' method="POST">
        <br style="clear:both">
        <h2 style="margin-bottom: 25px; text-align: center;">Create Project Form</h2>
        <div class="form-group">
            <label for="projectName" class="required">Project name</label>
            <input type="text" class="form-control" id="projectName" ng-model="newproject.name"
                   name="projectName"
                   placeholder="Project name" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="needAmount" class="required">Funding goal in &#8372;</label>
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
            <label for="externalUrl">External URL for project description</label>
            <input id="externalUrl" class="form-control" type="text" name="url" ng-model="newproject.url"
                   placeholder="Project description URL"
                   ng-pattern="app.projectExternalUrlRegExp"/>
        </div>
        <div class="form-group" ng-if="app.isEditorLoaded">
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