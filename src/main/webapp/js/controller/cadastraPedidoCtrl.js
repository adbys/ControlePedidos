app.controller("cadastraPedidoCtrl", function($scope, toastr, $location, pedidoService, lojas, marcas, categorias){

	$scope.lojas = lojas.data;
	$scope.marcas = marcas.data;
	$scope.categorias = categorias.data;


	$scope.produtos = [{
		nome: '',
	    quantidade: '',
	    categoria: '',
	    precoCusto: '',
	    precoVenda: ''

	}];

	$scope.salvarPedido = function (pedido) {
		pedidoService.cadastraPedido(pedido, $scope.produtos).then(function successCallback(response) {
		    console.log(response.data);
		    $location.path("/index");
		    toastr.success("Pedido com identificador " + response.data + " adicionado com sucesso!");
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

	$scope.apagaProduto = function (produto) {
		var index = $scope.produtos.indexOf(produto);
		$scope.produtos.splice(index, 1);

	}

	$scope.addNovoProduto = function() {
	    $scope.produtos.push({
	      nome: '',
	      quantidade: '',
	      categoria: '',
	      precoCusto: '',
	      precoVenda: ''
	    });
	}
	

});