package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Loja;

@RestController
@RequestMapping(value = "/loja")
public class LojaController {
	
	private List<Loja> lojas = new ArrayList<Loja>();
	
	public LojaController () {
		Loja loja1 = new Loja();
		loja1.setNome("Loja1");
		
		Loja loja2 = new Loja();
		loja2.setNome("Loja2");
		
		Loja loja3 = new Loja();
		loja3.setNome("Loja3");
		
		Loja loja4 = new Loja();
		loja4.setNome("Loja4");
		
		lojas.add(loja1);
		lojas.add(loja2);
		lojas.add(loja3);
		lojas.add(loja4);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Loja> getLojas () {
		
		return lojas;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Loja saveLoja(@RequestBody Loja loja) {
		
		lojas.add(loja);
		
		return loja;
	}

}
