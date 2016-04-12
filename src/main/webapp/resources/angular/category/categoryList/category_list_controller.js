(function () {
    'use strict';

    angular
        .module('crowdfundingApp')
        .controller('CategoryListController', CategoryListController);

    CategoryListController.$inject = ['CategoryUtils'];

    function CategoryListController(CategoryUtils) {

        var vm = this;

        loadingCategories();

        function loadingCategories() {
            CategoryUtils.getAllCategories()
                .then(function (result) {
                    vm.categories = result;
                }, function (err) {
                });
        }
    }
})();
