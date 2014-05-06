package es.indra.formacion.springint.tms;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.indra.formacion.springint.tms.channel.TicketChannel;

public class Principal {
	public static void main(String[] args) {
		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext(
						"classpath:META-INF/spring"
						+ "/integration/ticket-ctx.xml");
		context.start();

		TicketChannel tc = context.getBean(TicketChannel.class);
		tc.suscribir();
		System.out.println("TicketChannel suscrito...");
	}
}
