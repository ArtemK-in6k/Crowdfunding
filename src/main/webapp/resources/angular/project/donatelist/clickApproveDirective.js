(function () {
  'use strict';

  angular
      .module('crowdfundingApp.control')
      .directive('ngConfirmClick', ngConfirmClick);

  ngConfirmClick.$inject = [];

  function ngConfirmClick() {
    return {
      link: function (scope, element, attr) {
        var msg = "Are you sure approve this donate? ";
        var clickAction = attr.confirmedClick;
        element.bind('click', function (event) {
          if (window.confirm(msg)) {
            scope.$eval(clickAction)
          }
        });
      }
    };
  }
})();