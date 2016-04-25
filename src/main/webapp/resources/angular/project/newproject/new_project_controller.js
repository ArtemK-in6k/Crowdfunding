(function () {
    'use strict';

    angular
        .module('crowdfundingApp.projects')
        .controller('AppCtrl', AppCtrl);

    AppCtrl.$inject = ['$http'];

    function AppCtrl($http) {

        var self = this;

        self.htmlcontent = "";

        self.isEditorLoaded = false;
        setTimeout(function () {
            self.$apply(function () {
                self.isEditorLoaded = true;
            });
        }, 1000);
    }
})();
