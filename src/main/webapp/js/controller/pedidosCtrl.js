app.controller("pedidosCtrl", function($scope, $http){

	$scope.pedidos = [];
	$scope.marcas = [];
	$scope.lojas = [];

	carregarPedidos();
	carregarLojas();
	carregarMarcas();

	function carregarLojas () {

		console.log("Carregando Lojas")
		$http.get("/loja").then(function successCallback(response) {
		    console.log(response);
		    for (index in response.data) {
		    	$scope.lojas.push(response.data[index]);
		    }
		    console.log($scope.lojas)
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



	function carregarPedidos () {

		console.log("Carregando pedidos")
		$http.get("/pedidos").then(function successCallback(response) {
		    console.log(response.data[0]);
		    for (index in response.data) {
		    	$scope.pedidos.push(response.data[index]);
		    }
		    console.log($scope.pedidos.length)
	  	}, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
	  	});

	}

});
