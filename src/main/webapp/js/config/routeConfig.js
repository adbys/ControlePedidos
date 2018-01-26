app.config(function ($stateProvider){
	$stateProvider
    .state("login", {
        url: "/login",
        views: {
            'body': {
                templateUrl : "views/login.html",
                controller: "loginCtrl"        
            }
        }
        
    })
    .state("index", {
        url: "/index",
        views: {
            'header': {
                templateUrl: "views/navbar.html"
            },
            'body': {
                templateUrl : "views/pedidos.html",
                controller: "pedidosCtrl"
            }
        },
        resolve: {
            pedidos: function(pedidoService) {
                return pedidoService.carregarPedidos();
            },
            lojas: function(lojaService) {
                return lojaService.carregarLojas();
            },
            marcas: function(marcaService) {
                return marcaService.carregarMarcas();
            }
        }
    })
    .state("cadastrar", {
        url: "/cadastrar",
        views: {
            'header': {
                templateUrl: "views/navbar.html"
            },
            'body': {
                templateUrl : "views/cadastraPedido.html",
                controller: "cadastraPedidoCtrl"
                
            }
        },
        resolve: {
            lojas: function(lojaService) {
                return lojaService.carregarLojas();
            },
            marcas: function(marcaService) {
                return marcaService.carregarMarcas();
            },
            categorias: function(categoriaService) {
                return categoriaService.carregarCategorias();
            },
            formasDePagamento: function(formaDePagamentoService) {
                return formaDePagamentoService.carregarFormasDePagamento();
            }
        }
    })
    .state("marca", {
        url: "/marca",
        views: {
            'header': {
                templateUrl: "views/navbar.html"
            },
            'body': {
                templateUrl : "views/marca.html",
                controller: "marcaCtrl"
            }
        }
    })
    .state("loja", {
        url: "/loja",
        views: {
            'header': {
                templateUrl: "views/navbar.html"
            },
            'body': {
                templateUrl : "views/loja.html",
                controller: "lojaCtrl"
            }
        }
    })
    .state("categoria", {
        url: "/categoria",
        views: {
            'header': {
                templateUrl: "views/navbar.html"
            },
            'body': {
                templateUrl : "views/categoria.html",
                controller: "categoriaCtrl"    
            }
        }
    })
    .state("financas", {
        url: "/financas",
        views: {
            'header': {
                templateUrl: "views/navbar.html"
            },
            'body': {
                templateUrl : "views/financas.html",
                controller: "financasCtrl"
                
            }
        },
        resolve: {
            meses: function(financeiroService) {
                return financeiroService.carregarMeses();
            }
        }
    }).state("visualizaPedido", {
        url: "/visualizaPedido/:pedidoId",
        views: {
            'header': {
                templateUrl: "views/navbar.html"
            },
            'body': {
                templateUrl : "views/visualizaPedido.html",
                controller: "visualizaPedidoCtrl"
                
            }
        },
        resolve: {
            pedido: function(pedidoService, $stateParams) {
                return pedidoService.buscarPedidoPorId($stateParams.pedidoId);
            }
        }
    }).state("formaDePagamento", {
        url: "/formaDePagamento",
        views: {
            'header': {
                templateUrl: "views/navbar.html"
            },
            'body': {
                templateUrl : "views/formaDePagamento.html",
                controller: "formaDePagamentoCtrl"
                
            }
        }
    });

});