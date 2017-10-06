app.config(function ($routeProvider){
	$routeProvider
    .when("/", {
        templateUrl : "views/pedidos.html",
        controller: "pedidosCtrl"
    })
    .when("/cadastrar", {
        templateUrl : "views/cadastraPedido.html",
        controller: "cadastraPedidoCtrl"
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