(function () {
    'use strict';

    angular
        .module('crowdfundingApp')
        .controller('AdminProjectDonatesController', AdminProjectDonatesController);

    AdminProjectDonatesController.$inject = ['ProjectsService'];

    function AdminProjectDonatesController(ProjectsService) {

        var vm = this;

        vm.loadDonates = function (projectId) {
            ProjectsService.getAllProjectDonates(projectId)
                .then(function (result) {
                    console.log(result);
                    vm.projectName = result.name;
                    vm.projectDonates = result.donates;
                }, function (err) {
                });
        }
    }
})();
