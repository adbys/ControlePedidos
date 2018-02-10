app.config(function ($stateProvider, $urlRouterProvider){
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
            categorias: function(categoriaService) {
                return categoriaService.carregarCategorias();
            },
            formasDePagamento: function(formaDePagamentoService) {
                return formaDePagamentoService.carregarFormasDePagamento();
            },
            generos: function(generoService) {
                return generoService.carregarGeneros();
            },
            modeloProdutos: function(modeloProdutoService) {
                return modeloProdutoService.getModelos();
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
            meses: function(detalhesService) {
                return detalhesService.carregarMeses();
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
    }).state("visualizaMes", {
        url: "/financeiro/:mesId",
        views: {
            'header': {
                templateUrl: "views/navbar.html"
            },
            'body': {
                templateUrl : "views/mesDetalhes.html",
                controller: "mesDetalhesCtrl"
                
            }
        },
        resolve: {
            mes: function(detalhesService, $stateParams) {
                return detalhesService.getMes($stateParams.mesId);
            }
        }
    }).state("editarPedido", {
        url: "/editarPedido/:pedidoId",
        views: {
            'header': {
                templateUrl: "views/navbar.html"
            },
            'body': {
                templateUrl : "views/editaPedido.html",
                controller: "editarPedidoCtrl"
                
            }
        },
        resolve: {
            lojas: function(lojaService) {
                return lojaService.carregarLojas();
            },
            categorias: function(categoriaService) {
                return categoriaService.carregarCategorias();
            },
            formasDePagamento: function(formaDePagamentoService) {
                return formaDePagamentoService.carregarFormasDePagamento();
            },
            pedido: function(pedidoService, $stateParams) {
                return pedidoService.buscarPedidoPorId($stateParams.pedidoId);
            },
            generos: function(generoService) {
                return generoService.carregarGeneros();
            }
        }
    }).state("inventario", {
        url: "/inventario",
        views: {
            'header': {
                templateUrl: "views/navbar.html"
            },
            'body': {
                templateUrl : "views/inventario.html",
                controller: "inventarioCtrl"
                
            }
        },
        resolve: {
            meses: function(detalhesService) {
                return detalhesService.carregarMeses();
            }
        }
    }).state("inventatrioMes", {
        url: "/inventario/:mesId",
        views: {
            'header': {
                templateUrl: "views/navbar.html"
            },
            'body': {
                templateUrl : "views/inventarioDetalhes.html",
                controller: "inventarioDetalhesCtrl"
                
            }
        },
        resolve: {
            mes: function(detalhesService, $stateParams) {
                return detalhesService.getMes($stateParams.mesId);
            }
        }
    }).state("cadastroProduto", {
        url: "/produto",
        views: {
            'header': {
                templateUrl: "views/navbar.html"
            },
            'body': {
                templateUrl : "views/cadastraProduto.html",
                controller: "cadastraProdutoCtrl"
                
            }
        },
        resolve: {
            categorias: function(categoriaService) {
                return categoriaService.carregarCategorias();
            },
            generos: function(generoService) {
                return generoService.carregarGeneros();
            },
            marcas: function(marcaService) {
                return marcaService.carregarMarcas();
            }
        }
    });

     $urlRouterProvider.otherwise('/index');

});