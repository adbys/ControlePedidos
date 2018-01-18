app.factory("financeiroService", function ($http) {
	var _carregarMeses = function () {
		return $http.get("/financeiro");
	};


	return {
		carregarMeses : _carregarMeses
	};



});