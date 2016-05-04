(function () {
    'use strict';

    angular
        .module('crowdfundingApp.projects')
        .controller('ProjectDetailsController', ProjectDetailsController);

    ProjectDetailsController.$inject = ['$http'];

    function ProjectDetailsController($http) {

        var self = this;
        
        self.defaultProjectImage = '/resources/img/no_img.jpg';
        self.avatarImageUrl = '/resources/img/no_avatar.png';

        self.getProjectData = function (id) {
            $http.get("/projects/project/" + id).success(function (data) {
                self.project = data;
            })
        };

        self.isCompleted = function () {
            return self.project.status != 'COMPLETED';
        };
    }
})();
