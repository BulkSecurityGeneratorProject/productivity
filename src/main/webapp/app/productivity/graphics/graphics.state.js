(function() {

    angular
        .module('productivityApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('graphics', {
            parent: 'app',
            url: '/graphics',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/productivity/graphics/graphics.html',
                    controller: 'GraphicsController',
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
