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


    $scope.deleteProject = function (id,name) {
        var project = {
            "id": id
        }
        $http.post("/admin/deleteProject/", project).success(function (data) {
            $scope.projects = data;
            $scope.projectDelete = name;
            $scope.projectDeleteSuccess = true;

            $timeout(function () {
                $scope.projectDeleteSuccess = false;
            },3000);
        })

    }
}]);

crowdfundingApp.directive('ngConfirmClick', [
    function(){
        return {
            link: function (scope, element, attr) {
                var msg ="Would you delete project " + attr.ngConfirmClick +"? \nYou can lost all data for this project." || "Are you sure?";
                var clickAction = attr.confirmedClick;
                element.bind('click',function (event) {
                    if ( window.confirm(msg) ) {
                        scope.$eval(clickAction)
                    }
                });
            }
        };
    }])


