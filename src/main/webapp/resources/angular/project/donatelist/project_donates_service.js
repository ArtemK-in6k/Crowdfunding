(function () {
    'use strict';

    angular.module('crowdfundingApp').factory('ProjectDonatesService', ProjectDonatesService);

    ProjectDonatesService.$inject = ['$q', '$http'];

    function ProjectDonatesService($q, $http) {

        function getAllProjectDonates(project) {
            return $http.get('/api/projects/' + project + '/donates');
        }
       
        return {
            getAllProjectDonates: getAllProjectDonates,
        };
    }
})();
