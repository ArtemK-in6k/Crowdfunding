(function () {
    'use strict';

    angular.module('crowdfundingApp.control').directive('navActive', [function () {

        return {
            link: function (scope, elem, attrs) {
                $('a', $(elem)).each(function () {
                    var navigationPath = $(this).attr('href');
                    var n = getLocationLvlPath(navigationPath)
                    var u = getLocationLvlPath(window.location.pathname);
                    if (n == u) {
                        $(this).parent().addClass('active');
                    }
                });

                function getLocationLvlPath(url) {
                    var pathArray = url.split('/');
                    var secondLevelLocation = pathArray[2];
                    return secondLevelLocation;
                }
            }
        };
    }]);
})();
