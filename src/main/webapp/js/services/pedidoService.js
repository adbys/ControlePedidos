app.factory("pedidoService", function ($http) {

	var _cadastraPedido = function (pedido) {
		var valorTotal = 0;

		for (index in pedido.produtos) {
		    valorTotal += pedido.produtos[index].quantidade * pedido.produtos[index].precoCusto 
		}

		pedido.valorTotal = valorTotal

		console.log(pedido);

		return $http.post("/pedidos", pedido);
	};

	var _carregarPedidos = function () {
		return $http.get("/pedidos");
	};

	var _buscarPedidoPorId = function (id) {
		return $http.get("/pedidos/" + id);
	};

	var _atualizarPedido = function (pedido) {
		return $http.put("/pedidos", pedido);
	};


	return {
		cadastraPedido : _cadastraPedido,
		carregarPedidos : _carregarPedidos,
		buscarPedidoPorId : _buscarPedidoPorId,
		atualizarPedido : _atualizarPedido
	};

}); 