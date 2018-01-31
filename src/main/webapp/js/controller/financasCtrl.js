app.controller("financasCtrl", function($scope, meses){
	$scope.meses = meses.data;
	console.log($scope.meses);
});