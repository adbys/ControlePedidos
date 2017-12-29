app.factory("marcaService", function ($http) {

	var _carregarMarcas = function () {
		return $http.get("/marca");
	};

	var _salvarMarca = function (marca) {
		return $http.post("/marca", marca);
	};

	return {
		carregarMarcas : _carregarMarcas,
		salvarMarca : _salvarMarca
	};


});