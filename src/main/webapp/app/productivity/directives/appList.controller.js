(function () {
    angular.module("productivityApp").controller("appListController", appListController);

    appListController.$inject = ['$scope', 'ActivityService'];

    function appListController($scope, ActivityService) {
        $scope.activityDate = new Date();

        $scope.$watch('activityDate', function (newValStr) {
            var newValDate = new Date(newValStr);
            ActivityService.getActivitiesByDate(newValDate).then(function (result) {
                $scope.activities = result.data;
            });
        });

        $scope.selectActivity = function (activity) {
            $scope.selectedActivityIndex = activity.$index;
            return true;
        };

        $scope.createActivityExecution = function (elem) {
            var activityExecution = elem.activityExecution;

            if (activityExecution.executionDate) {
                ActivityService.removeActivityExecution(activityExecution.id).then(function (result) {
                    // TODO handle error
                });
            } else {
                ActivityService.createActivityExecution({
                    activityId: activityExecution.activity.id,
                    executionDate: new Date()
                }).then(function (result) {
                    // TODO handle error
                });
            }
        }
    }
})();
