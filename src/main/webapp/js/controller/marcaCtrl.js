app.controller("marcaCtrl", function($scope, $http){

	$scope.salvarMarca = function () {
		console.log($scope.marca);
		$http.post("/marca", $scope.marca).then(function successCallback(response) {
		    console.log(response);
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

});