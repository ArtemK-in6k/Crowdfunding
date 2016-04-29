(function () {
  'use strict';

  angular
      .module('crowdfundingApp.control')
      .controller('OwnProjects', OwnProjects);

  OwnProjects.$inject = ['$http', '$timeout', '$uibModal'];

  function OwnProjects($http, $timeout, $uibModal) {

    var self = this;
    $http.get('/control/projects/ownprojects').success(function (data) {
      self.projects = data;
    }).error(function (datat) {
      console.log(datat);
    });
      
    self.updateStatus = function (status, id, name) {
      var project = {
        "id": id,
        "status": status
      };
        
      $http.post("/control/projects/savestatus/", project).success(function (data, status) {
          self.projects = data;
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
      var project = {
        "id": id
      };
      $http.post("/control/projects/deleteProject/", project).success(function (data) {
        self.projects = data;
        self.projectDelete = name;
        self.projectDeleteSuccess = true;

        $timeout(function () {
          self.projectDeleteSuccess = false;
        }, 3000);
      })

    }
  }
})();
