app.factory("authInterceptor", function ($state, authService) {
	return {
		request: function (config) {

			if (config.url == '/auth/signin' || config.url == '/auth/checkToken') {
				return config;
			}

			if(authService.getToken() != null) {
				authService.isTokenValid().then(function(success) {
					if (config.url == 'views/login.html') {
						$state.go('index');
					}
					
				}, function (error) {
					authService.clearToken();
					$state.go('login');
				});
			} else {
				$state.go('login');
			}

			return config;
		}
	};
});