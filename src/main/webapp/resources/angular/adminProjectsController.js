var crowdfundingApp = angular.module('crowdfundingApp', ['ngAnimate']);

crowdfundingApp.controller('ProjectListForAdmin', ['$scope', '$http','$timeout', function ($scope, $http, $timeout) {
    $http.get('/projects').success(function (data) {
        $scope.projects = data;
    }).error(function (datat) {
        console.log(datat);
    });

    $scope.updateStatus = function (status, id) {
        var project = {
            "id": id,
            "status": status
        }
        $http.post("/admin/savestatus/", project).success(function (data, status) {
            $scope.projects = data;
            $scope.projectUpdateSuccess = true;

            $timeout(function () {
                $scope.projectUpdateSuccess = false;
            },3000);
        })
    }

}]);
