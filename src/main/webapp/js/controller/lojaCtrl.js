app.controller("lojaCtrl", function($scope, $http, toastr){

	$scope.salvarLoja = function (loja) {
		console.log(loja);
		$http.post("/loja", loja).then(function successCallback(response) {
		    console.log(response);
		    toastr.success("Loja adicionada com sucesso!");
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

});