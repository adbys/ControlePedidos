app.factory("modeloProdutoService", function ($http) {

	var _salvarModelo = function (modelo) {

		return $http.post("/modeloProduto", modelo);
	};

	var _getModelos = function () {
		return $http.get("/modeloProduto");
	}

	var _getModeloPorId = function (id) {
		return $http.get("/modeloProduto/" + id);
	}



	return {
		salvarModelo : _salvarModelo,
		getModelos : _getModelos,
		getModeloPorId : _getModeloPorId
	};

}); 