app.factory("pedidoService", function ($http) {

	var _cadastraPedido = function (pedido, produtos) {
		var valorTotal = 0;

		pedido.produtos = produtos

		for (index in pedido.produtos) {
		    valorTotal += pedido.produtos[index].quantidade * pedido.produtos[index].precoCusto 
		}

		pedido.valorTotal = valorTotal

		return $http.post("/pedidos", pedido);
	};

	var _carregarPedidos = function () {
		return $http.get("/pedidos");
	};


	return {
		cadastraPedido : _cadastraPedido,
		carregarPedidos : _carregarPedidos
	};

}); 