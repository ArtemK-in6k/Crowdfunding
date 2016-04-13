(function () {
    'use strict';

    angular.module('crowdfundingApp').factory('CategoryListService', CategoryListService);

    CategoryListService.$inject = ['$q', '$http'];

    function CategoryListService($q, $http) {

        function getAllCategories() {
            return $http.get('/api/categories');
        }

        return {
            getAllCategories: getAllCategories,
        };
    }
})();
