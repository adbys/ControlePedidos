app.controller("mesDetalhesCtrl", function($scope, $state, mes) {

	$scope.mes = mes.data;

	$scope.voltar = function () {
		$state.go("financas");
	} 

});