app.controller("loginCtrl", function($scope, $location){

	$scope.doLogin = function () {
		if($scope.usuario == "admin" && $scope.senha == "admin") {
			$location.path("/index");
		}
	}
});