app.factory("authService", function ($injector, $cookies) {

	var _isTokenValid = function() {
		var http = $injector.get('$http');
		var token = {'token': _getToken()};
		JSON.stringify(token);
		console.log("valido");
		return http.post('/auth/checkToken', token);
	};

	var _setToken = function (token) {
		$cookies.put('token', token);
	};

	var _getToken = function (token) {
		return $cookies.get('token');
	};

	var _signin = function (data) {
		var http = $injector.get('$http');
		console.log("sigin");
		return http.post('/auth/signin', data);
	};

	var _logout = function () {
		_clearToken();
		var state = $injector.get('$state');
		state.go('login');
	};

	var _clearToken = function () {
		$cookies.remove('token');
	}

	return {
		isTokenValid : _isTokenValid,
		setToken : _setToken,
		getToken: _getToken,
		signin : _signin,
		logout : _logout,
		clearToken: _clearToken
	}

}); 