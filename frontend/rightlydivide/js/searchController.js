(function(){
    var rdapp = angular.module('rdapp');

    rdapp.controller('searchController', function($scope, $http, $location) {

        $scope.types = ['Literal','Moral','Spiritual'];
    
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

        $scope.getAllObservations();

        $scope.goToUpdateView = function(observationId) {
            $location.path('/update/' + observationId)
        }

        $scope.reverse = false;

        $scope.sortByDate = function() {
            if ($scope.observations) {
                $scope.observations = $scope.observations.slice().sort(function(a, b) {
                    return $scope.reverse
                        ? new Date(a.createDateTime) - new Date(b.createDateTime)
                        : new Date(b.createDateTime) - new Date(a.createDateTime);
                });
                $scope.reverse = !$scope.reverse;
            }
        };

        $scope.selectedType = '';

        $scope.selectType = function(type) {
            $scope.selectedType = type;
            $scope.filterByType();
          };

          $scope.filterByType = function() {
            $scope.showSpinner = true;
      
            if ($scope.selectedType) {
              $http.get("http://localhost:8080/api/observations/type/" + $scope.selectedType)
                .then(function(response) {
                  $scope.observations = response.data;
                  $scope.showSpinner = false;
                })
                .catch(function(error) {
                  console.log("Error HTTP GET by type: ", error.status);
                  $scope.showSpinner = false;
                });
            } else {
              $scope.getAllObservations();
            }
          };

    });
})()