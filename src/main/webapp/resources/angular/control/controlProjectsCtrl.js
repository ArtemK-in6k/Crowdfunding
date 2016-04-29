(function () {
  'use strict';

  angular
      .module('crowdfundingApp.control')
      .controller('OwnProjects', OwnProjects);

  OwnProjects.$inject = ['$http', '$timeout', '$uibModal','ControlProjectsService'];

  function OwnProjects($http, $timeout, $uibModal,ControlProjectsService) {

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


    self.deleteProject = function (id, name) {
        ControlProjectsService.deleteOwnProject(projectId).then(function (result) {
            self.projects = result.data;
            self.projectDelete = name;
            self.projectDeleteSuccess = true;

        $timeout(function () {
          self.projectDeleteSuccess = false;
        }, 3000);
      })

    }
  }
})();
