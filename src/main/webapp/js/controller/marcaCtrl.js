app.controller("marcaCtrl", function($scope, $http, toastr, $location){

	$scope.salvarMarca = function (marca) {
		console.log(marca);
		$http.post("/marca", marca).then(function successCallback(response) {
		    console.log(response);
		   	$location.path("/index");
		   	toastr.success("Marca adicionada com sucesso!");
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

});