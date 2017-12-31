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
		$scope.obsSearch = undefined;
	}

	$scope.sort = function(keyname) {
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    }

});
