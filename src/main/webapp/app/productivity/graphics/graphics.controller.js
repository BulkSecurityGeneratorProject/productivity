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
                $scope.barChartLabels = [];
                $scope.barChartSeries = [];
                $scope.barChartData = [];

                var activitiesExecutions = result.data;
                var arr = {};
                var dates = {};

                for (var i = 0; i < activitiesExecutions.length; i++) {
                    var activityName = activitiesExecutions[i].activity.name;
                    if (arr[activityName]) {
                        var ac = arr[activityName];
                        ac.count++;
                    } else {
                        arr[activityName] = {count: 1};
                    }

                    var activityDate = activitiesExecutions[i].executionDate;
                    dates[activityDate] = {};
                    dates[activityDate][activityName] = 1;
                }

                for (var prop in arr) {
                    if (arr.hasOwnProperty(prop)) {
                        $scope.labels.push(prop + "(times)");
                        $scope.data.push(arr[prop].count);

                        $scope.barChartSeries.push(prop);
                        var a = [];

                        for (var date = startDate; date < endDate; date.setDate(date.getDate() + 1)) {
                            $scope.barChartLabels.push(date);
                            if (dates[date]) {
                                if (dates[date][prop]) {
                                    a.push(100);
                                } else {
                                    a.push(0);
                                }
                            } else {
                                a.push(0);
                            }
                        }

                        $scope.barChartData.push(a);
                    }
                }

                //

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
