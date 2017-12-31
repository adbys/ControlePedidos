app.controller("pedidosCtrl", function($scope, pedidos, lojas, marcas) {

	$scope.pedidos = pedidos.data;
	$scope.lojas = lojas.data;
	$scope.marcas = marcas.data;

	$scope.limparFiltros = function() {
		$scope.dateFrom = undefined;
		$scope.dateEnd = undefined;
		$scope.idSearch = undefined;
		$scope.lojaSearch = undefined;
		$scope.marcaSearch = undefined;
		$scope.valorTotalSearch = undefined;
		$scope.obsSearch = undefined;//TODO: problema ao zerar o campo "" - elimina os null null - elimina os que tem valor
	}

});
