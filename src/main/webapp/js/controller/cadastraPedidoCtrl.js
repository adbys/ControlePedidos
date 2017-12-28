app.controller("cadastraPedidoCtrl", function($scope, $http, toastr, $location){

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
		
		console.log(pedido.loja)

		$http.post("/pedidos", pedido).then(function successCallback(response) {
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