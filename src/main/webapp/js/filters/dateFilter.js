app.filter("dateFilter", function () {
	return function (input, dateFrom, dateEnd) {

		var inputs = [];

		if (dateFrom != null) {
			if (dateEnd != null) {

				for (var i in input) {
					var dataPedido = new Date(input[i].dataPedido);
					if (dataPedido >= dateFrom && dataPedido <= dateEnd) inputs.push(input[i]);
				}
				return inputs;
				
			}
			
			for (var i in input) {

				var dataPedido = new Date(input[i].dataPedido);

				if (dataPedido >= dateFrom) inputs.push(input[i]);
			}

			return inputs;
			
		} else {
			return input;
		}
		
	}; 
});