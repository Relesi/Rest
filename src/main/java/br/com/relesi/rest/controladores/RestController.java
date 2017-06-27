package br.com.relesi.rest.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.relesi.rest.modelo.repositorios.PizzaRepositorio;

@Controller
@RequestMapping("/pizzas")
public class RestController {



		@Autowired private PizzaRepositorio pizzaRepositorio;
		
	@RequestMapping("/quantas")
	@ResponseBody
	public String quantasPizzas(){
		
		return "Atualmente há "  +pizzaRepositorio.count()+ " cadastradas!!! -> corrigir erro de string em categorias no banco";
	}

	
}
