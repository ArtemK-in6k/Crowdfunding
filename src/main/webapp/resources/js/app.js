(function () {
    'use strict';

    var app = angular
        .module('crowdfundingApp', [
            'ui.bootstrap',
            'angularValidator',
            'crowdfundingApp.registration',
            'crowdfundingApp.projects',
            'crowdfundingApp.control',
            'crowdfundingApp.search',
            'ui-notification'
        ]);

    app.config(function(NotificationProvider) {
        NotificationProvider.setOptions({
            delay: 3000,
            startTop: 20,
            startRight: 10,
            verticalSpacing: 20,
            horizontalSpacing: 20,
            positionX: 'right',
            positionY: 'top'
        });
    });

})();
