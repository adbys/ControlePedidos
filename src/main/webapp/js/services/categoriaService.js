app.factory("categoriaService", function($http) {
	var _carregarCategorias = function() {
		return $http.get("/categoria");
	};

	var _salvarCategoria = function (categoria) {
		return $http.post("/categoria", categoria);
	};

	return {
		carregarCategorias : _carregarCategorias,
		salvarCategoria : _salvarCategoria
	}

});