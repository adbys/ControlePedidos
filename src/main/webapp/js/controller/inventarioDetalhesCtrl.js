app.controller("inventarioDetalhesCtrl", function($scope, $state, mes) {

	$scope.mes = mes.data;

	$scope.voltar = function () {
		$state.go("inventario");
	} 

});