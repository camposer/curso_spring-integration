package es.indra.formacion.springint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.indra.formacion.springint.channel.HolaMundoReader;

public class Principal {
	public static void main(String[] args) {
		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext(
						"classpath:META-INF/spring"
						+ "/integration/basico-ctx.xml");
		context.start();

		// Suscribiendo al HolaMundoReader
		HolaMundoReader hr = context.getBean(HolaMundoReader.class);
		hr.suscribir();
		System.out.println("HolaMundoReader suscrito...");
		
		// Enviando un mensaje
		hr.enviar("Hola mundo");
		
	}
}
