(function() {
    'use strict';

    angular
        .module('appApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('activities', {
            parent: 'app',
            url: '/activities',
            data: {
                authorities: []
            },
            views: {
            'content@': {
                templateUrl: 'app/productivity/activities/activities.html',
                controller: 'ActivitiesController',
                controllerAs: 'vm'
            }
        }
        });
    }
})();
