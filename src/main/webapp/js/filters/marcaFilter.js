app.filter("marcaFilter", function () {
	return function (input, marca) {

		var inputs = [];

		if (marca != null) {
			for (var i in input) {
				if (input[i].marca != null)
					if (input[i].marca.nome == marca) inputs.push(input[i]);
			}

			return inputs;	
			
		} else {
			return input;
		}
		
	}; 
});