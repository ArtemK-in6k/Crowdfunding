(function () {
    'use strict';

    angular.module('crowdfundingApp').factory('CategoryUtils', CategoryUtils);

    CategoryUtils.$inject = ['$q', '$http'];

    function CategoryUtils($q, $http) {


        function getAllCategories() {
            var defer = $q.defer();
            $http.get('/api/categories')
                .success(function (ok, status, headers, config) {
                    defer.resolve(ok);
                })
                .error(function (err, status, headers, config) {
                    defer.reject(err);
                });

            return defer.promise;
        }

       
        return {
            getAllCategories: getAllCategories,
        };
    }
})();
