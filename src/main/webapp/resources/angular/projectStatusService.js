(function () {
    'use strict';

    angular.module('crowdfundingApp.projects').factory('ProjectStatusService', ProjectStatusService);

    function ProjectStatusService() {

        function getAllProjectStatuses() {
            return {"NOT_STARTED" : "Not started", "IN_PROGRESS" : "In progress",
                "FUNDED": "Funded","COMPLETED" : "Completed"};
        }

        return {
            getAllProjectStatuses: getAllProjectStatuses
        };
    }
})();
