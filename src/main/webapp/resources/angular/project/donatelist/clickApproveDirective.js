(function () {
  'use strict';

  angular
      .module('crowdfundingApp.control')
      .directive('ngConfirmClickApprove', ngConfirmClickApprove);

  ngConfirmClickApprove.$inject = [];

  function ngConfirmClickApprove() {
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