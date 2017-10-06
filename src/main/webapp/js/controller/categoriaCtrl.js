app.controller("categoriaCtrl", function($scope, $http, toastr){

	$scope.salvarCategoria = function (categoria) {
		console.log(categoria);
		$http.post("/categoria", categoria).then(function successCallback(response) {
		    console.log(response);
		    toastr.success("Categoria adicionada com sucesso!");
		   }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

});