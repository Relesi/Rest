package br.com.relesi.rest.configuracoes;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="br.com.relesi.rest")


public class ConfiguracaoWeb extends WebMvcConfigurerAdapter {

	
}
