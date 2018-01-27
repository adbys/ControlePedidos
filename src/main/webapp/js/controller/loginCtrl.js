app.controller("loginCtrl", function($scope, $state, authService){

	$scope.doLogin = function () {
		authService.signin($scope.usuario).then(function (success) {
			authService.setToken(success.data.token)
			$state.go('index');
		},function (error) {
			alert("Usuário e/ou senha incorretos!")
		});
	}
});