(function () {
  'use strict';

  angular
      .module('crowdfundingApp.control')
      .controller('OwnDonates', OwnDonates)
      .run(function (editableOptions, editableThemes) {
        editableThemes.bs3.inputClass = 'form-control-inline';
        editableThemes.bs3.buttonsClass = 'btn-md';
        editableOptions.theme = 'bs3';
      });

  OwnDonates.$inject = ['$scope', '$http', '$timeout'];

  function OwnDonates($scope, $http, $timeout) {

    $http.get('/control/donates/list').success(function (data) {
      $scope.donates = data;
    }).error(function (datat) {
      console.log(datat);
    });

    $scope.deleteProject = function (donateId, name) {

      $http.delete("/control/donates/" + donateId).success(function (data) {
        $scope.donates = data;
        $scope.donateDelete = name;
        $scope.donateDeleteSuccess = true;

        $timeout(function () {
          $scope.donateDeleteSuccess = false;
        }, 3000);
      })

    }
    $scope.saveDonate = function (donate, id) {
      var donation = {
        "id": id,
        "donate": donate
      };
      $scope.donationUpdateSuccess = true;
      $http.post("/control/donates", donation).success(function (data) {
        $scope.donates = data;

        $timeout(function () {
          $scope.donationUpdateSuccess = false;
        }, 3000);
      })
    };
  }
})();

