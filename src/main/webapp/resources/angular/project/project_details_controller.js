(function () {
    'use strict';

    angular
        .module('crowdfundingApp.projects')
        .controller('ProjectDetailsController', ProjectDetailsController)
        .requires.push('crowdfundingApp.control');

    ProjectDetailsController.$inject = ['$http', 'ProjectDonatesService', 'Pagination', 'ControlDonatesService'];

    function ProjectDetailsController($http, ProjectDonatesService, Pagination, ControlDonatesService) {

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

        self.pagination = Pagination.getNew(5);

        self.loadDonates = function (projectId) {
            ProjectDonatesService.getAllProjectDonates(projectId)
                .then(function (result) {
                    self.donateList = result.data.donates;
                    self.pagination.numPages = Math.ceil(self.donateList.length / self.pagination.perPage);
                })
            ;
        };

        self.approveDonate = function (donateId,projectId) {
            ProjectDonatesService.approveDonate(donateId).then(function (result) {
                self.loadDonates(projectId);
                self.getProjectData(projectId);
            });
        };

        self.deleteDonate = function (donateId, project) {
            ControlDonatesService.deleteOwnDonate(donateId).then(function (result) {
                ProjectDonatesService.getAllProjectDonates(project.id)
                    .then(function (result) {
                        ControlDonatesService.isDonateDeleted(self.donateList, result.data.donates, project.name);
                    });
                self.loadDonates(project.id);
                self.getProjectData(project.id);
            })
        };
    }
})();
