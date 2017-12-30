app.controller("pedidosCtrl", function($scope, pedidos) {

	$scope.pedidos = pedidos.data;

	$scope.limparFiltros = function() {
		$scope.dateFrom = null;
		$scope.dateEnd = null;
	}

});
