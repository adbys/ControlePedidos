angular.module("controlePedidos", []).controller("indexCtrl", function($scope, $http){

	$scope.produtos = new Array(1);

			$scope.clica = function () {
				$scope.produtos.push(2);
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