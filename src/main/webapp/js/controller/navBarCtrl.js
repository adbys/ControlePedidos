app.controller("navBarCtrl", function($scope, authService){


	$scope.logout = function () {
		authService.logout();
	}

});