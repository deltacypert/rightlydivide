(function(){
    var rdapp = angular.module('rdapp');

    rdapp.controller('searchController', function($scope, $http, $location) {
    
        $scope.showSpinner = true;

        $scope.getAllObservations = function() {
            $scope.showSpinner = true;
            $http.get("http://localhost:8080/api/observations")
            .then(function(response) {
                $scope.observations = response.data;
                $scope.showSpinner = false;
            }), function(response) {
                console.log("Error HTTP GET observations: " + response.status)
            }
        }

        $scope.getAllObservations(); // calls the function automatically

        $scope.goToUpdateView = function(observationId) {
            $location.path('/update/' + observationId)
        }

        $scope.reverse = false;

        $scope.sortByDate = function() {
            if ($scope.observations) {
                $scope.observations = $scope.observations.slice().sort(function(a, b) {
                    return $scope.reverse
                        ? new Date(a.createDateTime) - new Date(b.createDateTime) // Ascending
                        : new Date(b.createDateTime) - new Date(a.createDateTime); // Descending
                });
                $scope.reverse = !$scope.reverse; // Toggle sorting direction
            }
        };


    });
})()