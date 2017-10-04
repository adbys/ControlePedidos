app.config(function ($routeProvider){
	$routeProvider
    .when("/index", {
        templateUrl : "views/cadastraPedido.html",
        controller: "indexCtrl"
    })
    .when("/buscar", {
        templateUrl : "views/buscar.html",
        controller: "indexCtrl"
    })
    .when("/marca", {
        templateUrl : "views/marca.html",
        controller: "marcaCtrl"
    })
    .when("/loja", {
        templateUrl : "views/loja.html",
        controller: "lojaCtrl"
    })
    .when("/categoria", {
        templateUrl : "views/categoria.html",
        controller: "categoriaCtrl"
    })

});