app.filter("lojaFilter", function () {
	return function (input, loja) {

		var inputs = [];

		if (loja != null) {
			for (var i in input) {
				if (input[i].loja != null)
					if (input[i].loja.nome == loja) inputs.push(input[i]);
			}

			return inputs;	
			
		} else {
			return input;
		}
		
	}; 
});