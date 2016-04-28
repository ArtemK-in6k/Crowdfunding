(function () {
  'use strict';

  angular
      .module('crowdfundingApp.projects')
      .controller('ProjectList', ProjectList);

  ProjectList.$inject = ['$http','ProjectListService'];

  function ProjectList($http,ProjectListService) {

    var self = this;

    self.loadProjects = function (category) {
      var url = (category) ? '/projects/categories/' + category : '/projects';
      $http.get(url).success(function (data) {
        self.projects = data;
      }).error(function (datat) {
      });
    };

    self.statusForBootstrap = function(status){
      return ProjectListService.getLabelByStatus(status);
    };

    self.orderProp = '';
  }
})();
