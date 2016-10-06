(function() {
    angular.module("productivityApp").directive("appList", appList);

    function appList() {
        var directive = {
            templateUrl: 'app/productivity/directives/appList.html',
            controller: 'appListController'
        };

        return directive;
    }
})();
