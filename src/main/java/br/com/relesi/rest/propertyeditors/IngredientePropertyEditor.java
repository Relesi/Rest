package br.com.relesi.rest.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.relesi.rest.modelo.entidades.Ingrediente;
import br.com.relesi.rest.modelo.repositorios.IngredienteRepositorio;
@Component
public class IngredientePropertyEditor extends PropertyEditorSupport {

	@Autowired private IngredienteRepositorio ingredienteRepositorio; 
	
	
	public void setAsText(String text) throws IllegalArgumentException{
		long idIngrediente = Long.parseLong(text);
		Ingrediente ingrediente = ingredienteRepositorio.findOne(idIngrediente) ;
		setValue(ingrediente);
	}
}
