app.controller("pedidosCtrl", function($scope, pedidoService, pedidos){

	$scope.pedidos = pedidos.data;

});
