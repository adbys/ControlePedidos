app.controller("cadastraProdutoCtrl", function($scope, $location, toastr, categorias, generos, marcas, modeloProdutoService) {

	$scope.categorias = categorias.data;
	$scope.generos = generos.data;
	$scope.marcas = marcas.data;

	$scope.salvarModeloProduto = function (modelo) {
		
		modeloProdutoService.salvarModelo(modelo).then(function successCallback(response) {
		    console.log(response);
		    $location.path("/index");
		    toastr.success("Produto: " + response.data.nome + " cadastrado com id: " + response.data.id);
		   }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
			});
	}
});
