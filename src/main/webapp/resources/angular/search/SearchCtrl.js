(function () {
    'use strict';
    angular
        .module('crowdfundingApp.search', ["ngTouch", "angucomplete"])
        .controller('SearchController', ['$scope', '$http', '$window',
            function SearchController($scope, $http, $window) {
                $http.get('/projects').success(function (data) {
                    $scope.searchProjects = data;
                }).error(function (data) {
                    console.log(data);
                });

                $scope.selectedObject;
                $scope.$watch('selectedObject', function () {
                        if ($scope.selectedObject) {
                            console.log($scope.selectedObject);
                            var url ='/projects/' + $scope.selectedObject.originalObject.id;
                            $window.location.href = url;
                        }
                    }
                );
            }]);

})();
