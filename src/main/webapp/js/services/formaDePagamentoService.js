app.factory("formaDePagamentoService", function ($http) {
	var _carregarFormasDePagamento = function () {
		return $http.get("/formaPagamento");
	};

	var _salvarFormaDePagamento = function (formaPagamento) {
		return $http.post("/formaPagamento", formaPagamento);
	};

	return {
		carregarFormasDePagamento : _carregarFormasDePagamento,
		salvarFormaDePagamento : _salvarFormaDePagamento
	};



});