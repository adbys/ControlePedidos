app.controller("cadastraPedidoCtrl", function($scope, toastr, $location, pedidoService, modeloProdutoService, lojas, categorias, formasDePagamento, generos, modeloProdutos){

	$scope.lojas = lojas.data;
	$scope.categorias = categorias.data;
	$scope.formasDePagamento = formasDePagamento.data;
	$scope.generos = generos.data;
	$scope.modeloProdutos = modeloProdutos.data;


	$scope.produtos = [];

	$scope.salvarPedido = function (pedido) {

		pedido.produtos = $scope.produtos;

		pedidoService.cadastraPedido(pedido).then(function successCallback(response) {
		    console.log(response.data);
		    $location.path("/index");
		    toastr.success("Pedido com identificador " + response.data + " adicionado com sucesso!");
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

	$scope.buscar = function (codigo) {
		console.log(codigo);
		modeloProdutoService.getModeloPorId(codigo).then(function successCallback(response) {
		    console.log(response);
		    for (var index = 0; index < $scope.produtos.length; index++) {
		    	if($scope.produtos[index].id == response.data.id) {
		    		toastr.error("Produto: " + response.data.nome + " já foi adicionado ao pedido!");
		    		return;
		    	}
		    }
		    $scope.produtos.push(response.data);
		    toastr.success("Produto: " + response.data.nome + " adicionado ao pedido!");
		   }, function errorCallback(response) {
		    alert("Produto não encontrado");
			});
	}

	$scope.apagaProduto = function (index) {
		
		$scope.produtos.splice(index, 1);

	}

	

});