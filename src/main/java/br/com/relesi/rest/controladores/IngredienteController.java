package br.com.relesi.rest.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.relesi.rest.modelo.entidades.Ingrediente;
import br.com.relesi.rest.modelo.enumeracoes.CategoriaDeIngrediente;
import br.com.relesi.rest.modelo.repositorios.IngredienteRepositorio;

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {

	@Autowired
	private IngredienteRepositorio ingredienteRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	public String listarIngredientes(Model model) {
		Iterable<Ingrediente> ingredientes = ingredienteRepositorio.findAll();

		model.addAttribute("titulo", "Listagem de Ingredientes");
		model.addAttribute("ingredientes", ingredientes);
		model.addAttribute("categorias", CategoriaDeIngrediente.values());
		return "ingrediente/listagem";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarIngrediente(@Valid @ModelAttribute Ingrediente ingrediente, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			FieldError error = bindingResult.getFieldErrors().get(0);
			redirectAttributes.addFlashAttribute("mensagemErro",
					"Não foi possível salvar o ingrediente" + error.getField() + " " + error.getDefaultMessage());
		} else {

			ingredienteRepositorio.save(ingrediente);
			redirectAttributes.addFlashAttribute("mensagemInfo",
					"O ingrediente foi salvo corretamente" );
		}

		return "redirect:/app/ingredientes";
	}
}