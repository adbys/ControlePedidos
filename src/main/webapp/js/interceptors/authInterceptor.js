app.factory("authInterceptor", function ($state, authService) {
	return {
		request: function (config) {
			console.log(config.url);

			if (config.url == "views/login.html"  && authService.isTokenValid()) {
				$state.go('index');
			}
			if (!authService.isTokenValid()) {
				$state.go('login');
			} 
			if (config.url == '/auth/signin') {

			}
			return config;
		}
	};
});