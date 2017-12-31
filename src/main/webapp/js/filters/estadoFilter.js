app.filter("estadoFilter", function () {
	return function (input, estado) {
		var inputs = [];

		if (estado != null) {
		
			for (var i in input) {
				if (input[i].estado == estado) inputs.push(input[i]);
			}
			return inputs;
		} else {
			return input;
		}
		
	}; 
});