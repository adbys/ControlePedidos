package br.com.pedidos.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.FormaDePagamento;
import br.com.pedidos.model.Mes;
import br.com.pedidos.model.Pedido;
import br.com.pedidos.services.MesFinanceiroService;
import br.com.pedidos.services.PedidoService;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	@Autowired
	MesFinanceiroService financeiroService;
	
	//TODO: REFATORAR
	@RequestMapping(method = RequestMethod.POST)
	public long salvePedido (@RequestBody Pedido pedido) {
		
		if (pedido.getId() != null) {
			pedidoService.salvarPedido(pedido);
			return pedido.getId();
		}
		
		pedidoService.salvarPedido(pedido);

		FormaDePagamento formaPagamento = pedido.getFormaDePagamento();
		List<String> parcelas = formaPagamento.getParcelas();
		TimeZone tz = TimeZone.getTimeZone("America/Fortaleza");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		df.setTimeZone(tz);
		Date data = null;
		try {
			data = df.parse(pedido.getDataRecebimento());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar c = Calendar.getInstance();
		c.setTime(data);
		
		Locale ptBR = new Locale("pt", "BR");
		Formatter fmt = new Formatter(ptBR);
		fmt.format("%tB", c.getTime());
		int anoInt = c.getTime().getYear() + 1900;
		String ano = String.valueOf(anoInt);

		Mes mes = financeiroService.buscarMesEAno(fmt.toString(), ano);

		if (mes != null) {
			mes.adicionarPedidoAReceber(pedido);
			financeiroService.salvarMes(mes);
		} else {
			Mes mesParcela = new Mes(fmt.toString(), ano);
			mesParcela.adicionarPedidoAReceber(pedido);
			financeiroService.salvarMes(mesParcela);
		}

		
		for (String dataParcela : parcelas) {

			Calendar c1 = Calendar.getInstance();
			c1.setTime(data);
	
			Formatter fmt1 = new Formatter(ptBR);
			c1.add(Calendar.DATE, Integer.parseInt(dataParcela)); 
			fmt1.format("%tB", c1.getTime());

			
			
			Mes mes1 = financeiroService.buscarMesEAno(fmt1.toString(), ano);
			
			if (mes1 != null) {
				mes.adicionarPedido(pedido);
				financeiroService.salvarMes(mes);
			} else {
				Mes mesParcela = new Mes(fmt1.toString(), ano);
				mesParcela.adicionarPedido(pedido);
				financeiroService.salvarMes(mesParcela);
			}
			
		}
		
		
		return pedido.getId();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public long atualizarPedido (@RequestBody Pedido pedido) {
		
		pedidoService.atualizarPedido(pedido);
		
		return pedido.getId();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Pedido> getPedidos () {
		return this.pedidoService.buscarTodos();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Pedido getPedidosPorId (@PathVariable long id) {
		return this.pedidoService.buscarPorId(id);
	}

}
