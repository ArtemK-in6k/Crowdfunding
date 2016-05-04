(function () {
    'use strict';

    angular.module('crowdfundingApp.projects').factory('ProjectListService', ProjectListService);

    function ProjectListService() {

        function getLabelByStatus(status) {
            var label;
            switch (status) {
                case 'NOT_STARTED':
                    label = 'label-default';
                    break;
                case 'IN_PROGRESS' :
                    label = 'label-warning';
                    break;

                case 'FUNDED' :
                    label = 'label-primary';
                    break;

                case 'COMPLETED' :
                    label = 'label-success';
                    break;

                default:
                    label = 'label-default';
                    break;

            }
            return label;
        }

        return {
            getLabelByStatus: getLabelByStatus
        };
    }
})();
