var ApiCallController = function($scope, $http) {
    $scope.status = "000";
    $scope.message = "API Call not yet made";
    $scope.data = ["not set", "noot set", "nooot set"];

    $scope.callApi = function(params) {
        $http.get('api.php?' + params).success(function(data, status, headers, config) {
           $scope.status = data['status'];
           $scope.message = data['status_message'];
           $scope.command = data['command'];
           $scope.data = data['data'];
        }).error(function(data, status, headers, config) {
           $scope.status = status;
           $scope.message = "An error occured";
           $scope.command = "Error";
           $scope.data = [];
        });
    }
}