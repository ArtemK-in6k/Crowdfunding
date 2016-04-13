(function () {
    'use strict';

    angular
        .module('crowdfundingApp')
        .controller('AdminProjectDonatesController', AdminProjectDonatesController);

    AdminProjectDonatesController.$inject = ['ProjectDonatesService'];

    function AdminProjectDonatesController(ProjectDonatesService) {

        var vm = this;

        vm.loadDonates = function (projectId) {
            ProjectDonatesService.getAllProjectDonates(projectId)
                .then(function (result) {
                    console.log(result);
                    vm.projectName = result.data.name;
                    vm.projectDonates = result.data.donates;
                });
        }
    }
})();
