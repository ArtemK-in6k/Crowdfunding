(function () {
    'use strict';

    angular
        .module('crowdfundingApp.projects')
        .controller('ProjectDetailsController', ProjectDetailsController);

    ProjectDetailsController.$inject = ['$http'];

    function ProjectDetailsController($http) {

        var self = this;

        self.getProjectData = function (id) {
            $http.get("/projects/project/" + id).success(function (data) {
                self.project = data;
            })
        };
    }
})();
