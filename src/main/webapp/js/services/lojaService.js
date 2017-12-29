app.factory("lojaService", function ($http) {
	var _carregarLojas = function () {
		return $http.get("/loja");
	};

	var _salvarLoja = function (loja) {
		return $http.post("/loja", loja);
	};

	return {
		carregarLojas : _carregarLojas,
		salvarLoja : _salvarLoja
	};



});