package es.indra.formacion.springint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.indra.formacion.springint.channel.HolaMundoDirectChannel;
import es.indra.formacion.springint.channel.HolaMundoPSChannel;
import es.indra.formacion.springint.channel.HolaMundoQueueChannel;
import es.indra.formacion.springint.channel.HolaMundoSalidaChannel;

public class Principal {
	public static void main(String[] args) {
		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext(
						"classpath:META-INF/spring"
						+ "/integration/basico-ctx.xml");
		context.start();

		/******* SUSCRIPCIONES ******/
		HolaMundoDirectChannel hmdc = context.getBean(HolaMundoDirectChannel.class);
		hmdc.suscribir();
		System.out.println("HolaMundoDirectReader suscrito...");

		HolaMundoPSChannel hmpsc = context.getBean(HolaMundoPSChannel.class);
		hmpsc.suscribir();
		System.out.println("HolaMundoPSChannel suscrito...");
		
		HolaMundoSalidaChannel hmsc = context.getBean(HolaMundoSalidaChannel.class);
		hmsc.suscribir();
		System.out.println("HolaMundoSalidaChannel suscrito...");
		
		
		/******* DIRECT *******/
		// Enviando mensajes
		hmdc.enviar("Hola mundo");
		hmdc.enviar("Hola mundo");
		hmdc.enviar("Hola mundo");

		/******* COLA *******/
		HolaMundoQueueChannel hmqc = context.getBean(HolaMundoQueueChannel.class);
		// Enviando mensajes
		hmqc.enviar("Hola mundo");
		hmqc.enviar("Hola mundo");
		hmqc.enviar("Hola mundo");
		
		// Recibiendo mensajes
		new Thread(new HolaMundoQueueChannelThread(hmqc)).start();

		/******* PUBLISH SUBSCRIBE *******/
		// Enviando mensajes
		hmpsc.enviar("Hola mundo");
		hmpsc.enviar("Hola mundo");
		hmpsc.enviar("Hola mundo");

	}
	
	public static class HolaMundoQueueChannelThread implements Runnable {
		private HolaMundoQueueChannel hmqr;
		
		public HolaMundoQueueChannelThread(HolaMundoQueueChannel hmqr) {
			this.hmqr = hmqr;
		}
		
		@Override
		public void run() {
			while (true) 
				hmqr.recibir();
		}
	}
}
