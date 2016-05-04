(function () {
  'use strict';

  angular
      .module('crowdfundingApp.projects')
      .controller('ProjectList', ProjectList);

  ProjectList.$inject = ['$http','ProjectStatusService'];

  function ProjectList($http,ProjectStatusService) {

    var self = this;

    self.defaultProjectImage = '/resources/img/no_img.jpg';

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
      self.projectStatuses = ProjectStatusService.getAllProjectStatuses();

    self.orderProp = '';
  }
})();
