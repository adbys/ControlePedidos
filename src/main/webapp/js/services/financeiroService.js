app.factory("financeiroService", function ($http) {
	var _carregarMeses = function () {
		return $http.get("/financeiro");
	};

	var _getMes = function (id) {
		return $http.get("/financeiro/" + id);
	}


	return {
		carregarMeses : _carregarMeses,
		getMes : _getMes
	};



});