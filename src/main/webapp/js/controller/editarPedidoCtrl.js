app.controller("editarPedidoCtrl", function($scope, toastr, $location, pedidoService, lojas, marcas, categorias, formasDePagamento, pedido){

	$scope.lojas = lojas.data;
	$scope.marcas = marcas.data;
	$scope.categorias = categorias.data;
	$scope.formasDePagamento = formasDePagamento.data;
	
	loadPedido();
	loadDatas();
	loadMarca();
	loadFormaDePagamento();
	loadLoja();
	loadCategoriaProdutos();

	function loadPedido() {
		$scope.pedido = pedido.data;
	}

	function loadDatas() {
		$scope.pedido.dataPedido = new Date(pedido.data.dataPedido);
		$scope.pedido.dataRecebimento = new Date(pedido.data.dataRecebimento);
	}

	function loadMarca() {
		for(i = 0; i < $scope.marcas.length; i++) {
			if($scope.marcas[i].id == pedido.data.marca.id) {
				$scope.pedido.marca = $scope.marcas[i];
				break;
			}
		}
	}

	function loadFormaDePagamento() {
		for(i = 0; i < $scope.formasDePagamento.length; i++) {
			if($scope.formasDePagamento[i].id == pedido.data.formaDePagamento.id) {
				$scope.pedido.formaDePagamento = $scope.formasDePagamento[i];
				break;
			}
		}
	}

	function loadLoja() {
		for(i = 0; i < $scope.lojas.length; i++) {
			if($scope.lojas[i].id == pedido.data.loja.id) {
				$scope.pedido.loja = $scope.lojas[i];
				break;
			}
		}
	}

	function loadCategoriaProdutos() {
		for(i = 0; i < $scope.pedido.produtos.length; i++) {
			console.log(pedido.data.produtos[i]);
			for(j = 0; j < $scope.categorias.length; j++) {
				if($scope.pedido.produtos[i].categoria.id == $scope.categorias[j].id) {
					$scope.pedido.produtos[i].categoria = $scope.categorias[j];
				}

			}
		}
	}


	$scope.produtos = $scope.pedido.produtos

	console.log($scope.pedido);

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