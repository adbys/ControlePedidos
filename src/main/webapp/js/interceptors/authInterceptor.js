app.factory("authInterceptor", function ($state, authService) {
	return {
		request: function (config) {

			console.log(authService.getToken());

			config.headers['Authorization'] = authService.getToken(); 
      		console.log(config.headers);

			return config;
		},
		responseError: function(error) {
			if (error.status == 400) {
				authService.clearToken();
				$state.go('login');
			}
			if (error.status == 403) {
				$state.go('login');
			}
        }
	};
});