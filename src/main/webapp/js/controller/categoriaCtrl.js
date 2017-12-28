app.controller("categoriaCtrl", function($scope, $http, toastr, $location){

	$scope.salvarCategoria = function (categoria) {
		console.log(categoria);
		$http.post("/categoria", categoria).then(function successCallback(response) {
		    console.log(response);
		    $location.path("/index");
		    toastr.success("Categoria adicionada com sucesso!");
		   }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

});