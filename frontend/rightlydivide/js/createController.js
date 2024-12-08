(function() {
	var rdapp = angular.module('rdapp');

	rdapp.controller('createController', function($scope, $http, $location) {			
		
		$scope.types = ['Literal','Moral','Spiritual'];
		
		$scope.createObservation = function() {
			$http.post("http://localhost:8080/api/observations", $scope.observation)
			.then(function(response) {				
				$scope.createStatus = 'Create Successful!';
				$scope.disableCreate = true;
			}, function(response) {
				$scope.createStatus = 'Error trying to create observation.';	
				console.log('Error HTTP POST observations: ' + response.status);
			});
		}
		
		$scope.clear = function() {
			$scope.observation.text = '';
			$scope.observation.type = '';
			$scope.observation.scriptureRef = '';
			$scope.disableCreate = false;
            $scope.createForm.$setUntouched();
            $scope.createForm.$setPristine();
		}

		$scope.goToSearchView = function() {
            $location.path('/search')
        }
		
	});
	
})()