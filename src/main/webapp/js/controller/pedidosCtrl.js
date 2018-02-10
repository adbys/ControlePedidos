app.controller("pedidosCtrl", function($scope, pedidos, lojas) {

	$scope.pedidos = pedidos.data;
	$scope.lojas = lojas.data;

	$scope.limparFiltros = function() {
		
		$scope.dateFrom = undefined;
		$scope.dateEnd = undefined;
		$scope.idSearch = undefined;
		$scope.lojaSearch = undefined;
		$scope.valorTotalSearch = undefined;
		$scope.obsSearch = undefined;
		$scope.estadoSearch = undefined;
	}

	$scope.sort = function(keyname) {
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    }

});
