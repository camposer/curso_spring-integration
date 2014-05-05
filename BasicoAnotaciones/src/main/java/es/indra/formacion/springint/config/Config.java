package es.indra.formacion.springint.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import es.indra.formacion.springint.HelloWorld;
import es.indra.formacion.springint.HolaMundo;
import es.indra.formacion.springint.IHolaMundo;
import es.indra.formacion.springint.IMensaje;
import es.indra.formacion.springint.Mensaje;
import es.indra.formacion.springint.Message;

@Configuration
public class Config {
	@Bean
	@Scope("prototype")
	public IMensaje mensaje1() {
		return new Mensaje("Juan");
	}

	@Bean
	public IMensaje mensaje2() {
		return new Message("Juan");
	}

	@Bean
	public IHolaMundo holaMundo1() {
		return new HolaMundo();
	}

	@Bean
	public IHolaMundo holaMundo2() {
		return new HelloWorld();
	}

	@Bean
	public IHolaMundo holaMundo3() {
		return new HolaMundo();
	}
}
