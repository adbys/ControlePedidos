package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Marca;

@RestController
@RequestMapping(value="/marca")
public class MarcaController {
	
private List<Marca> marcas = new ArrayList<Marca>();

	public MarcaController() {
		Marca marca1 = new Marca();
		marca1.setNome("Mizuno");
		marca1.setCodigo("12345");
		
		Marca marca2 = new Marca();
		marca2.setNome("Adidas");
		marca2.setCodigo("12345");
		
		Marca marca3 = new Marca();
		marca3.setNome("Nike");
		marca3.setCodigo("12345");
		
		Marca marca4 = new Marca();
		marca4.setNome("Asics");
		marca4.setCodigo("12345");
		
		marcas.add(marca1);
		marcas.add(marca2);
		marcas.add(marca3);
		marcas.add(marca4);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Marca> getMarcas () {
		
		return marcas;
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Marca saveMarca (@RequestBody Marca marca) {
		
		marcas.add(marca);
		
		return marca;
		
	}

}
