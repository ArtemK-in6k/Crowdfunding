(function () {
  'use strict';

  angular
      .module('crowdfundingApp.control')
      .directive('ngConfirmClickDonate', ngConfirmClickDonate);

  ngConfirmClickDonate.$inject = [];

  function ngConfirmClickDonate() {
    return {
      link: function (scope, element, attr) {
        var msg = "Would you delete your donate " + attr.ngConfirmClickDonate + "? \nYou can lost all data for this project." || "Are you sure?";
        var clickAction = attr.confirmClickDonate;
        element.bind('click', function (event) {
          if (window.confirm(msg)) {
            scope.$eval(clickAction)
          }
        });
      }
    };
  }
})();