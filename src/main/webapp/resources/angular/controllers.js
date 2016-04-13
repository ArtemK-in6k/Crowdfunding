'use strict';

var crowdfundingApp = angular.module('crowdfundingApp', []);

crowdfundingApp.controller('ProjectList', ['$http', function ($http) {
    var vm = this;
    
    vm.loadProjects = function (category) {
        var url = (category) ? '/projects/categories/' + category : '/projects';
        $http.get(url).success(function (data) {
            vm.projects = data;
        }).error(function (datat) {
        });
    }

    vm.orderProp = '';
}]);

