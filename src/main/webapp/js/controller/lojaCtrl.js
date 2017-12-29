app.controller("lojaCtrl", function($scope, toastr, $location, lojaService){

	$scope.salvarLoja = function (loja) {
		console.log(loja);
		lojaService.salvarLoja(loja).then(function successCallback(response) {
		    console.log(response);
		    $location.path("/index");
		    toastr.success("Loja adicionada com sucesso!");
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
	}

});