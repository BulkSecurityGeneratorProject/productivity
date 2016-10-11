(function () {
    angular
        .module('productivityApp')
        .controller('GraphicsController', controller);

    controller.$inject = ['$scope', 'ActivityService'];

    function controller($scope, ActivityService) {
        $scope.activityDateStart = new Date();
        $scope.activityDateEnd = new Date();

        $scope.$watchGroup(['activityDateStart', 'activityDateEnd'], function (newVals) {
            var startDate = new Date(newVals[0]);
            var endDate = new Date(newVals[1]);
            ActivityService.getActivitiesByDateRange(startDate, endDate).then(function (result) {
                $scope.labels = [];
                $scope.data = [];

                var activitiesExecutions = result.data;
                var arr = {};

                for (var i = 0; i < activitiesExecutions.length; i++) {
                    var activityName = activitiesExecutions[i].activity.name;
                    if (arr[activityName]) {
                        var ac = arr[activityName];
                        ac.count++;
                    } else {
                        arr[activityName] = { count: 1 };
                    }
                }

                for (var prop in arr) {
                    if (arr.hasOwnProperty(prop)) {
                        $scope.labels.push(prop + "(times)");
                        $scope.data.push(arr[prop].count);
                    }
                }
            });
        });

        $scope.openDatePickerStart = function () {
            $scope.startDatePckerOpened = true
        };

        $scope.openDatePickerEnd = function () {
            $scope.endDatePckerOpened = true
        };
    }
})();
