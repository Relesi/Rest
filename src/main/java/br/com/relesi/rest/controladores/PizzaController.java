package br.com.relesi.rest.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.relesi.rest.excecoes.IngredienteInvalidoException;
import br.com.relesi.rest.modelo.entidades.Ingrediente;
import br.com.relesi.rest.modelo.entidades.Pizza;
import br.com.relesi.rest.modelo.enumeracoes.CategoriaDePizza;
import br.com.relesi.rest.modelo.repositorios.IngredienteRepositorio;
import br.com.relesi.rest.modelo.repositorios.PizzaRepositorio;
import br.com.relesi.rest.propertyeditors.IngredientePropertyEditor;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

		@Autowired private IngredientePropertyEditor ingredientePropertyEditor;
		@Autowired private PizzaRepositorio pizzaRepositorio;
		@Autowired private IngredienteRepositorio ingredienteRepositorio;
		
		@RequestMapping(method=RequestMethod.GET)
		public String listarPizzas(Model model){
			model.addAttribute("pizzas", pizzaRepositorio.findAll());
			model.addAttribute("categorias", CategoriaDePizza.values());
			model.addAttribute("ingredientes", ingredienteRepositorio.findAll());
			return "pizza/listagem";	
								
			}
					
		
		@RequestMapping(method=RequestMethod.POST)
		public String salvarPizza(
				Model model,
				@Valid @ModelAttribute Pizza pizza,
				BindingResult bindingResult){

			if (bindingResult.hasErrors() ) {
				throw new IngredienteInvalidoException();
			} else {
				pizzaRepositorio.save(pizza);
			}
			model.addAttribute("pizzas", pizzaRepositorio.findAll());
			return "pizza/tabela-pizzas";	 
			
			
			
		}
		
	@RequestMapping("/quantas")
	@ResponseBody
	public String quantasPizzas(){
		
		return "Atualmente h� "  +pizzaRepositorio.count()+ " cadastradas!!!";
	}
	
	@InitBinder
	public void initBinder (WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Ingrediente.class, ingredientePropertyEditor);
	}

	
}
