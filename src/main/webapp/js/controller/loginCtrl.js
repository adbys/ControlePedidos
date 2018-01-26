app.controller("loginCtrl", function($scope, $state, authService){

	$scope.doLogin = function () {
		authService.signin($scope.usuario).then(function (success) {
			authService.setToken(success.data)
			$state.go('index');
		},function (error) {
			console.log(error);
			alert("Usuário e/ou senha incorretos!")
		});
	}
});