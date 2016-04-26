(function () {
    'use strict';

    angular
        .module('crowdfundingApp.projects')
        .controller('CreateProjectController', CreateProjectController);

    CreateProjectController.$inject = ['$http'];

    function CreateProjectController($http) {

        var self = this;

        self.htmlcontent = "";
        self.projectExternalUrlRegExp = /^((?:http|ftp)s?:\/\/)(?:(?:[A-Z0-9](?:[A-Z0-9-]{0,61}[A-Z0-9])?\.)+(?:[A-Z]{2,6}\.?|[A-Z0-9-]{2,}\.?)|localhost|\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})(?::\d+)?(?:\/?|[\/?]\S+)$/i
        
    }
})();
