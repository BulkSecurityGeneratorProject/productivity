(function () {
    angular
        .module('productivityApp')
        .controller('GraphicsController', controller);

    controller.$inject = ['$scope'];

    function controller($scope) {
        $scope.labels = ["Download Sales", "In-Store Sales", "Mail-Order Sales"];
        $scope.data = [300, 500, 100];
    }
})();
