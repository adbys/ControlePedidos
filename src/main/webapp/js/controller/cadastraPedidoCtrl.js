app.controller("cadastraPedidoCtrl", function($scope, toastr, $location, pedidoService, lojas, marcas, categorias, formasDePagamento, generos, modeloProdutos){

	$scope.lojas = lojas.data;
	$scope.marcas = marcas.data;
	$scope.categorias = categorias.data;
	$scope.formasDePagamento = formasDePagamento.data;
	$scope.generos = generos.data;
	$scope.modeloProdutos = modeloProdutos.data;


	$scope.produtos = [{}];

	$scope.salvarPedido = function (pedido) {

		pedido.produtos = [];

		for (var index in $scope.produtos) {
			pedido.produtos.push($scope.produtos[index][0]);
		}
		

		pedidoService.cadastraPedido(pedido).then(function successCallback(response) {
		    console.log(response.data);
		    $location.path("/index");
		    toastr.success("Pedido com identificador " + response.data + " adicionado com sucesso!");
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

	$scope.apagaProduto = function (index) {
		
		$scope.produtos.splice(index, 1);

	}

	$scope.addNovoProduto = function() {
	    $scope.produtos.push({});
	}
	

});