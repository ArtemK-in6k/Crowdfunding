(function () {
    'use strict';

    angular.module('crowdfundingApp.projects').factory('ProjectDonatesService', ProjectDonatesService);

    ProjectDonatesService.$inject = ['$q', '$http'];

    function ProjectDonatesService($q, $http) {

        function getAllProjectDonates(project) {
            return $http.get('/api/projects/' + project + '/donates');
        }

        function approveDonate(donateId) {
            return $http.post('/api/donates/' + donateId + '/approve');
        }

        return {
            getAllProjectDonates: getAllProjectDonates,
            approveDonate: approveDonate
        };
    }
})();
