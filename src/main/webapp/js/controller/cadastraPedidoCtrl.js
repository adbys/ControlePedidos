app.controller("cadastraPedidoCtrl", function($scope, $http, toastr){

	$scope.produtos = [{
		nome: '',
	    quantidade: '',
	    categoria: '',
	    precoCusto: '',
	    precoVenda: ''

	}];

	$scope.salvarPedido = function (pedido) {
		var valorTotal = 0;

		console.log(Date.parse(pedido.dataPedido))
		pedido.produtos = $scope.produtos

		for (index in pedido.produtos) {
		    valorTotal += pedido.produtos[index].quantidade * pedido.produtos[index].precoCusto 
		}

		pedido.valorTotal = valorTotal
		
		console.log(pedido)

		$http.post("/pedidos", pedido).then(function successCallback(response) {
		    console.log(response);
		    toastr.success("Pedido adicionado com sucesso!");
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

	$scope.apagaProduto = function (produto) {
		var index = $scope.produtos.indexOf(produto);

		$scope.produtos.splice(index, 1);

	}

	$scope.salvar = function () {
		console.log($scope.produtos);
		$scope.pedido.produtos = $scope.produtos;
		console.log($scope.pedido);

	}


	$scope.addNovo = function() {
	    $scope.produtos.push({
	      nome: '',
	      quantidade: '',
	      categoria: '',
	      precoCusto: '',
	      precoVenda: ''
	    });
	}

	$scope.limparFormulario = function () {

		$scope.produtos = [{
			nome: '',
		    quantidade: '',
		    categoria: '',
		    precoCusto: '',
		    precoVenda: ''

		}];

	}
	
	$scope.lojas = [];

	$scope.marcas = [];

	$scope.categorias = [];

	carregarLojas();
	carregarMarcas();
	carregarCategorias();

	function carregarLojas () {

		console.log("Carregando Lojas")
		$http.get("/loja").then(function successCallback(response) {
		    console.log(response);
		    for (index in response.data) {
		    	$scope.lojas.push(response.data[index]);
		    }
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });

	}

	function carregarMarcas () {

		console.log("Carregando Marcas")
		$http.get("/marca").then(function successCallback(response) {
		    console.log(response);
		    for (index in response.data) {
		    	$scope.marcas.push(response.data[index]);
		    }
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });

	}

	function carregarCategorias () {

		console.log("Carregando Categorias")
		$http.get("/categoria").then(function successCallback(response) {
		    console.log(response);
		    for (index in response.data) {
		    	$scope.categorias.push(response.data[index]);
		    }
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });

	}

});