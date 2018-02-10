app.factory("authService", function ($injector, $cookies) {

	var _setToken = function (token) {
		$cookies.put('token', token);
	};

	var _getToken = function (token) {
		return $cookies.get('token');
	};

	var _signin = function (data) {
		var http = $injector.get('$http');
		return http.post('/signin', data);
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
		setToken : _setToken,
		getToken: _getToken,
		signin : _signin,
		logout : _logout,
		clearToken: _clearToken
	}

}); 