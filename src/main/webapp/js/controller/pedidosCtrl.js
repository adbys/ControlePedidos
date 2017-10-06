app.controller("pedidosCtrl", function($scope, $http){

	$scope.pedidos = [];

	carregarPedidos();



	function carregarPedidos () {

		console.log("Carregando pedidos")
		$http.get("/pedidos").then(function successCallback(response) {
		    console.log(response.data[0]);
		    for (index in response.data) {
		    	$scope.pedidos.push(response.data[index]);
		    }
	  	}, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
	  	});

	}

});
