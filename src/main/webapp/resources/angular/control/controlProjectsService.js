(function () {
    'use strict';

    angular.module('crowdfundingApp.control').factory('ControlProjectsService', ControlProjectsService);

    ControlProjectsService.$inject = ['$http'];

    function ControlProjectsService($http) {

        function getAllOwnProject() {
            return $http.get('/control/projects/list');
        }

        function deleteOwnProject(projectId) {
            return $http.delete('/control/projects/' + projectId);
        }

        function updateOwnProject(project) {
            return $http.post("/control/projects", project);
        }

        function isProjectDeleted(projectsToRemove, projectsAfterRemove){
            var projectDeleted = projectsAfterRemove.length == projectsToRemove.length;
            return !projectDeleted;
        }

        return {
            getAllOwnProject: getAllOwnProject,
            deleteOwnProject: deleteOwnProject,
            updateOwnProject: updateOwnProject,
            isProjectDeleted : isProjectDeleted
        };
    }
})();
