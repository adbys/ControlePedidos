angular.module("controlePedidos", []).controller("indexCtrl", function($scope, $http){

	$scope.produtos = [{
		nome: '',
	    quantidade: '',
	    categoria: '',
	    precoCusto: '',
	    precoVenda: ''

	}];

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