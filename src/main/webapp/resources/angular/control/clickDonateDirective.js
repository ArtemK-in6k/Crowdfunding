(function () {
  'use strict';

  angular
      .module('crowdfundingApp.control')
      .directive('ngConfirmClick', ngConfirmClick);

  ngConfirmClick.$inject = [];

  function ngConfirmClick() {
    return {
      link: function (scope, element, attr) {
        var msg = "Would you delete your donate " + attr.ngConfirmClick + "? \nYou can lost all data for this project." || "Are you sure?";
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