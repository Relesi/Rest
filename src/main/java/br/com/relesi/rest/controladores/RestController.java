package br.com.relesi.rest.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rests")
public class RestController {

	public RestController() {

		System.out.println("Criou REST controller!!!");
	}

	@RequestMapping("/ola/{nome}")
	@ResponseBody
	public String ola(@PathVariable String nome) {
		return "olá " + nome;
	}
}
