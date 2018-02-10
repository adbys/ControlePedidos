app.controller("editarPedidoCtrl", function($scope, toastr, $location, pedidoService, modeloProdutoService,lojas, categorias, formasDePagamento, generos,pedido){

	$scope.lojas = lojas.data;
	$scope.categorias = categorias.data;
	$scope.formasDePagamento = formasDePagamento.data;
	$scope.generos = generos.data;
	
	loadPedido();
	loadDatas();
	loadFormaDePagamento();
	loadLoja();
	console.log($scope.pedido);



	function loadPedido() {
		$scope.pedido = pedido.data;
	}

	function loadDatas() {
		$scope.pedido.dataPedido = pedido.data.dataPedido;
		$scope.pedido.dataRecebimento = pedido.data.dataRecebimento;
		console.log(pedido);
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


	$scope.produtos = $scope.pedido.produtos


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

	$scope.buscar = function (codigo) {
		modeloProdutoService.getModeloPorId(codigo).then(function successCallback(response) {
		    for (var index = 0; index < $scope.pedido.produtos.length; index++) {
		    	if($scope.pedido.produtos[index].nome === response.data.nome && $scope.pedido.produtos[index].marca.nome === response.data.marca.nome && $scope.pedido.produtos[index].categoria === response.data.categoria) {
		    		toastr.error("Produto: " + response.data.nome + " já foi adicionado ao pedido!");
		    		return;
		    	}
		    }
		    $scope.pedido.produtos.push(response.data);
		    toastr.success("Produto: " + response.data.nome + " adicionado ao pedido!");
		   }, function errorCallback(response) {
		    alert("Produto não encontrado");
		   });
	}

	

});