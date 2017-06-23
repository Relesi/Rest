package br.com.relesi.rest.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.relesi.rest.modelo.entidades.Pizza;

@Repository
public interface PizzaRepositorio extends CrudRepository<Pizza, Long> {

}
