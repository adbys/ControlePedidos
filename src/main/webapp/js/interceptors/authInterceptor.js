app.factory("authInterceptor", function ($state, $q, authService) {
	return {
		request: function (config) {

			config.headers['authorization'] = authService.getToken(); 
     
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
			return $q.reject(error);
        }
	};
});