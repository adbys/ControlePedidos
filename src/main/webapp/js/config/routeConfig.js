app.config(function ($routeProvider){
	$routeProvider
    .when("/", {
        templateUrl : "views/login.html",
        controller: "loginCtrl"
    })
    .when("/index", {
        templateUrl : "views/pedidos.html",
        controller: "pedidosCtrl"
        //TODO: resolve e API para carregar dados
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
    .when("/financas", {
        templateUrl : "views/financas.html",
        controller: "financasCtrl"
    })
    .otherwise({redirectTo:"/index"});

});