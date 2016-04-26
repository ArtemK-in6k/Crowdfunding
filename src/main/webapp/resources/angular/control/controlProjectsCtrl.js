(function () {
  'use strict';

  angular
      .module('crowdfundingApp.control')
      .controller('OwnProjects', OwnProjects);

  OwnProjects.$inject = ['$scope', '$timeout','ControlProjectsService'];

  function OwnProjects($scope, $timeout,ControlProjectsService) {

    ControlProjectsService.getAllOwnProject().then(function (result) {
      $scope.projects = result.data;
    });

    $scope.updateStatus = function (status, id,name) {
      var project = {
        "id": id,
        "status": status
      };
      ControlProjectsService.updateOwnProject(project).then(function (result) {
        $scope.projects = result.data;
        $scope.projectCompleted = name;
        $scope.projectUpdateSuccess = true;

        $timeout(function () {
          $scope.projectUpdateSuccess = false;
        }, 3000);
      })
    };


    $scope.deleteProject = function (projectId, name) {
      ControlProjectsService.deleteOwnProject(projectId).then(function (result) {
        $scope.projects = result.data;
        $scope.projectDelete = name;
        $scope.projectDeleteSuccess = true;

        $timeout(function () {
          $scope.projectDeleteSuccess = false;
        }, 3000);
      })

    }
  }
})();
