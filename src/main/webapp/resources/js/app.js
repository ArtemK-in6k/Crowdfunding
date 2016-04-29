(function () {
    'use strict';

    angular
        .module('crowdfundingApp', [
            'ui.bootstrap',
            'angularValidator',
            'crowdfundingApp.registration',
            'crowdfundingApp.projects',
            'crowdfundingApp.control',
            'crowdfundingApp.search'
        ]);

})();
