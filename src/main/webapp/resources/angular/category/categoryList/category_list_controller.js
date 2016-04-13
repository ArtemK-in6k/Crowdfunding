(function () {
    'use strict';

    angular
        .module('crowdfundingApp')
        .controller('CategoryListController', CategoryListController);

    CategoryListController.$inject = ['CategoryListService'];

    function CategoryListController(CategoryListService) {

        var self = this;

        CategoryListService.getAllCategories().then(function (result) {
            self.categories = result.data;
        });

    }
})();
