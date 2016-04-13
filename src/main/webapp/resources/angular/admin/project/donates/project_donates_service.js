(function () {
    'use strict';

    angular.module('crowdfundingApp').factory('ProjectsService', ProjectsService);

    ProjectsService.$inject = ['$q', '$http'];

    function ProjectsService($q, $http) {


        function getAllProjectDonates(project) {
            var defer = $q.defer();
            $http.get('/api/projects/' + project + '/donates')
                .success(function (ok, status, headers, config) {
                    defer.resolve(ok);
                })
                .error(function (err, status, headers, config) {
                    defer.reject(err);
                });

            return defer.promise;
        }

       
        return {
            getAllProjectDonates: getAllProjectDonates,
        };
    }
})();
