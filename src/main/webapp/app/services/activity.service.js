(function () {
    angular.module("appApp").factory("ActivityService", activityService);

    activityService.$inject = ['$http'];

    function activityService($http) {
        return {
            getActivitiesByDate: function (activityDate) {
                var date = activityDate.toISOString().slice(0, 10);
                return $http.get("api/activity-execution/date/" + date).then(function (result) {
                    return result;
                });
            },

            createActivityExecution: function (activityExecution) {
                return $http.post("api/activity-execution", activityExecution).then(function (result) {
                    return result;
                });
            },

            removeActivityExecution: function (activityExecutionId) {
                return $http.delete("api/activity-execution/id/" + activityExecutionId).then(function (result) {
                    return result;
                });
            }
        };
    }
})();
