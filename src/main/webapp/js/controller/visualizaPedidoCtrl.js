app.controller("visualizaPedidoCtrl", function($scope, $location, toastr, pedido, pedidoService){

	$scope.pedido = pedido.data;

	$scope.atualizarPedido = function (pedido) {
		console.log(pedido);
		pedidoService.atualizarPedido(pedido).then(function successCallback(response) {
		    console.log(response.data);
		    $location.path("/index");
		    toastr.success("Pedido " + response.data + " atualizado com sucesso!");
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

});