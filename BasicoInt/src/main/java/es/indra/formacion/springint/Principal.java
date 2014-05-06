package es.indra.formacion.springint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.indra.formacion.springint.channel.HolaMundoDirectReader;
import es.indra.formacion.springint.channel.HolaMundoQueueReader;

public class Principal {
	public static void main(String[] args) {
		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext(
						"classpath:META-INF/spring"
						+ "/integration/basico-ctx.xml");
		context.start();

		/******* DIRECT *******/
		// Suscribiendo al HolaMundoReader
		HolaMundoDirectReader hmdr = context.getBean(HolaMundoDirectReader.class);
		hmdr.suscribir();
		System.out.println("HolaMundoDirectReader suscrito...");
		
		// Enviando un mensaje
		hmdr.enviar("Hola mundo");

		/******* COLA *******/
		HolaMundoQueueReader hmqr = context.getBean(HolaMundoQueueReader.class);
		hmqr.enviar("Hola mundo");
		
		// Enviando un mensaje
		hmqr.recibir();
	}
}
