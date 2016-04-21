(function () {
  'use strict';

  angular
      .module('crowdfundingApp.projects')
      .controller('ProjectList', ProjectList);

  ProjectList.$inject = ['$http'];

  function ProjectList($http) {

    var self = this;

    self.loadProjects = function (category) {
      var url = (category) ? '/projects/categories/' + category : '/projects';
      $http.get(url).success(function (data) {
        self.projects = data;
      }).error(function (datat) {
      });
    }

    self.orderProp = '';
  }
})();
