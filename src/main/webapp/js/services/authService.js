app.factory("authService", function ($injector, $cookies) {

	var _isTokenValid = function() {
		if ($cookies.get('token') != null) {
			return true;
		} else {
			return false;
		}
	};

	var _setToken = function (token) {
		$cookies.put('token', token);
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
		signin : _signin,
		logout : _logout,
		clearToken: _clearToken
	}

}); 