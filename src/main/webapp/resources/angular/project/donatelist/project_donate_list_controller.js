(function () {
    'use strict';

    angular
        .module('crowdfundingApp.projects')
        .controller('ProjectDonateListController', ProjectDonateListController);

    ProjectDonateListController.$inject = ['ProjectDonatesService', 'Pagination'];

    function ProjectDonateListController(ProjectDonatesService, Pagination) {

        var self = this;

        self.pagination = Pagination.getNew(5);

        self.loadDonates = function (projectId) {
            ProjectDonatesService.getAllProjectDonates(projectId)
                .then(function (result) {
                    self.donateList = result.data.donates;
                    self.pagination.numPages = Math.ceil(self.donateList.length / self.pagination.perPage);
                });
        }

        self.approveDonate = function (donateId,projectId) {
            ProjectDonatesService.approveDonate(donateId).then(function (result) {
                self.loadDonates(projectId);
            })

        }
    }
})();