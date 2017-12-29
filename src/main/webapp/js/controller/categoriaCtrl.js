app.controller("categoriaCtrl", function($scope, toastr, $location, categoriaService){

	$scope.salvarCategoria = function (categoria) {
		console.log(categoria);
		categoriaService.salvarCategoria(categoria).then(function successCallback(response) {
		    console.log(response);
		    $location.path("/index");
		    toastr.success("Categoria adicionada com sucesso!");
		   }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

});