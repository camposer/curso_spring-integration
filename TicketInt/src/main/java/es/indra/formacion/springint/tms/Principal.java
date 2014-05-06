package es.indra.formacion.springint.tms;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.indra.formacion.springint.tms.channel.TicketPrioridadAltaChannel;
import es.indra.formacion.springint.tms.channel.TicketPrioridadBajaChannel;

public class Principal {
	public static void main(String[] args) {
		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext(
						"classpath:META-INF/spring"
						+ "/integration/ticket-ctx.xml");
		context.start();

		TicketPrioridadBajaChannel tpbc = context.getBean(TicketPrioridadBajaChannel.class);
		tpbc.suscribir();
		System.out.println("TicketPrioridadBajaChannel suscrito...");

		TicketPrioridadAltaChannel tpac = context.getBean(TicketPrioridadAltaChannel.class);
		tpac.suscribir();
		System.out.println("TicketPrioridadAltaChannel suscrito...");
}
}
