app.controller("cadastraProdutoCtrl", function($scope, toastr, categorias, generos, modeloProdutoService) {

	$scope.categorias = categorias.data;
	$scope.generos = generos.data;

	$scope.salvarModeloProduto = function (modelo) {
		
		modeloProdutoService.salvarModelo(modelo).then(function successCallback(response) {
		    console.log(response);
		    toastr.success("Produto: " + response.data.nome + " cadastrado com id: " + response.data.id);
		   }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
			});
	}
});
