app.factory("detalhesService", function ($http) {
	var _carregarMeses = function () {
		return $http.get("/detalhes");
	};

	var _getMes = function (id) {
		return $http.get("/detalhes/" + id);
	}


	return {
		carregarMeses : _carregarMeses,
		getMes : _getMes
	};



});