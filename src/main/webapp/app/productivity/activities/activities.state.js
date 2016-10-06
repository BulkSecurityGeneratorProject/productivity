(function () {
    'use strict';

    angular
        .module('productivityApp')
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
            },
            resolve: {
                mainTranslatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('home');
                    return $translate.refresh();
                }]
            }
        });
    }
})();
