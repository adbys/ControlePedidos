app.factory("generoService", function($http) {
	var _carregarGeneros = function() {
		return $http.get("/genero");
	};


	return {
		carregarGeneros : _carregarGeneros
	}

});