angular.module("controlePedidos", []).controller("lojaCtrl", function($scope, $http){


	init();
	function init() {
		console.log("======");
	}

	$scope.salvarLoja = function () {
		console.log($scope.loja);
		$http.post("/loja", $scope.loja).then(function successCallback(response) {
		    console.log(response);
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

});