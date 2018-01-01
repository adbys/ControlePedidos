app.controller("formaDePagamentoCtrl", function($scope, toastr, $location, formaDePagamentoService){

	$scope.salvarFormaDePagamento = function (tags) {
		var formaDePagamento = {parcelas: []};
		
		for (index in tags) {
		    formaDePagamento.parcelas.push(tags[index].text);
		}
		console.log(formaDePagamento);

		formaDePagamentoService.salvarFormaDePagamento(formaDePagamento).then(function successCallback(response) {
		    console.log(response);
		    $location.path("/index");
		    toastr.success("Forma de Pagamento adicionada com sucesso!");
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

});