(function () {
    'use strict';

    angular
        .module('crowdfundingApp.control')
        .controller('OwnProjects', OwnProjects);

    OwnProjects.$inject = ['$timeout', '$uibModal', 'ControlProjectsService'];

    function OwnProjects($timeout, $uibModal, ControlProjectsService) {

        var self = this;

        ControlProjectsService.getAllOwnProject().then(function (result) {
            self.projects = result.data;
        });

        self.updateStatus = function (status, id, name) {
            var project = {
                "id": id,
                "status": status
            };

            ControlProjectsService.updateOwnProject(project).then(function (result) {
                self.projects = result.data;
                self.projectCompleted = name;
                self.projectUpdateSuccess = true;

                $timeout(function () {
                    self.projectUpdateSuccess = false;
                }, 3000);
            })
        };

        self.openCreateProjectModal = function (size) {

            $uibModal.open({
                templateUrl: '/resources/angular/templates/createProjectModal.html',
                controller: 'CreateProjectController as app',
                size: size
            });

        };


        self.deleteProject = function (projectId, name) {
            ControlProjectsService.deleteOwnProject(projectId).then(function (result) {
                self.projectDeleteSuccess = ControlProjectsService.isProjectDeleted(self.projects, result.data);
                self.projectDeleteWarning = !ControlProjectsService.isProjectDeleted(self.projects, result.data);
                self.projects = result.data;
                self.projectDelete = name;

                $timeout(function () {
                    self.projectDeleteSuccess = false;
                    self.projectDeleteWarning = false;
                }, 3000);
            })

        }
    }
})();
