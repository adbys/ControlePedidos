app.controller("visualizaProdutosCtrl", function($scope, produtos, marcas, generos, categorias){

	$scope.produtos = produtos.data;
	$scope.marcas = marcas.data;
	$scope.generos = generos.data;
	$scope.categorias = categorias.data;

	$scope.limparFiltros = function() {
		
		$scope.idSearch = undefined;
		$scope.nomeSearch = undefined;
		$scope.marcaSearch = undefined;
		$scope.generoSearch = undefined;
		$scope.categoriaSearch = undefined;
		$scope.corSearch = undefined;
	}

	$scope.sort = function(keyname) {
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    }

});