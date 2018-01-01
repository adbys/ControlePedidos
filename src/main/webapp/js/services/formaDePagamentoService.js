app.factory("formaDePagamentoService", function ($http) {
	var _carregarFormasDePagamento = function () {
		return $http.get("/formaDePagamento");
	};

	var _salvarFormaDePagamento = function (formaPagamento) {
		return $http.post("/formaDePagamento", formaPagamento);
	};

	return {
		carregarFormasDePagamento : _carregarFormasDePagamento,
		salvarFormaDePagamento : _salvarFormaDePagamento
	};



});