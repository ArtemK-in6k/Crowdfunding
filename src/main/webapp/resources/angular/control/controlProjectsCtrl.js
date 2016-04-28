(function () {
  'use strict';

  angular
      .module('crowdfundingApp.control')
      .controller('OwnProjects', OwnProjects);

  OwnProjects.$inject = ['$scope', '$http', '$timeout', '$uibModal'];

  function OwnProjects($scope, $http, $timeout, $uibModal) {

    $http.get('/control/projects/ownprojects').success(function (data) {
      $scope.projects = data;
    }).error(function (datat) {
      console.log(datat);
    });

    $scope.updateStatus = function (status, id,name) {
      var project = {
        "id": id,
        "status": status
      }
      $http.post("/control/projects/savestatus/", project).success(function (data, status) {
        $scope.projects = data;
        $scope.projectCompleted = name;
        $scope.projectUpdateSuccess = true;

        $timeout(function () {
          $scope.projectUpdateSuccess = false;
        }, 3000);
      })
    }

    $scope.openCreateProjectModal = function (size) {

      $uibModal.open({
        templateUrl: '/resources/angular/templates/createProjectModal.html',
        controller: 'CreateProjectController as app',
        size: size
      });

    };


    $scope.deleteProject = function (id, name) {
      var project = {
        "id": id
      }
      $http.post("/control/projects/deleteProject/", project).success(function (data) {
        $scope.projects = data;
        $scope.projectDelete = name;
        $scope.projectDeleteSuccess = true;

        $timeout(function () {
          $scope.projectDeleteSuccess = false;
        }, 3000);
      })

    }
  }
})();
