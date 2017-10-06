app.controller("categoriaCtrl", function($scope, $http){

	$scope.salvarCategoria = function () {
		console.log($scope.categoria);
		$http.post("/categoria", $scope.categoria).then(function successCallback(response) {
		    console.log(response);
		   }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

});