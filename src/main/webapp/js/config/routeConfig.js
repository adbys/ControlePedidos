app.config(function ($routeProvider){
	$routeProvider
    .when("/", {
        templateUrl : "views/login.html",
        controller: "loginCtrl"
    })
    .when("/index", {
        templateUrl : "views/pedidos.html",
        controller: "pedidosCtrl",
        resolve: {
            pedidos: function(pedidoService) {
                return pedidoService.carregarPedidos();
            }
        }
    })
    .when("/cadastrar", {
        templateUrl : "views/cadastraPedido.html",
        controller: "cadastraPedidoCtrl",
        resolve: {
            lojas: function(lojaService) {
                return lojaService.carregarLojas();
            },
            marcas: function(marcaService) {
                return marcaService.carregarMarcas();
            },
            categorias: function(categoriaService) {
                return categoriaService.carregarCategorias();
            }
        }
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