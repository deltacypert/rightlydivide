(function(){
    var rdapp = angular.module('rdapp');

    rdapp.controller('updateController', function($scope, $http, $routeParams, $location) {

        $scope.types = ['Literal','Moral','Spiritual'];

        $scope.getObservationsById = function() {
			$http.get("http://localhost:8080/api/observations/id/" + $routeParams.observationId)
			.then(function(response) {
				var observations = response.data;
				if (observations.length == 1) {
					$scope.observation = observations[0];
				} else {
					//TODO error message
				}				
			}, function(response) {
				console.log('error http GET observations by id: ' + response.status);
			});
		}

		$scope.getObservationsById();

        $scope.updateObservation = function() {
			$http.put("http://localhost:8080/api/observations", $scope.observation)
			.then(function(response) {				
				$scope.updateStatus = 'Update Successful!';			
			}, function(response) {
				$scope.updateStatus = 'Error trying to update observation.';	
				console.log('Error HTTP PUT observation: ' + response.status);
			});
		}

        $scope.deleteObservation = function() {
			$http.delete("http://localhost:8080/api/observations/id/" + $scope.observation.id)
			.then(function(response) {				
				$scope.updateStatus = 'Delete Successful!';	
				$scope.disableUpdate = true;
			}, function(response) {
				$scope.updateStatus = 'Error trying to delete observation.';	
				console.log('Error HTTP DELETE observation: ' + response.status);
			});
		}

        $scope.goToSearchView = function(){
            $location.path('/search')
        }

    });
})()