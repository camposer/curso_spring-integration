package es.indra.formacion.springint.tms.channel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.Message;
import org.springframework.integration.MessagingException;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageHandler;
import org.springframework.stereotype.Component;

@Component
public class TicketChannel implements MessageHandler {
	private DirectChannel canal;
	
	@Value("#{ticketPrioridadBaja}")
	public void setCanal(DirectChannel canal) {
		this.canal = canal;
	}

	public void suscribir() {
		canal.subscribe(this);
	}
	
	@Override
	public void handleMessage(Message<?> msg) throws MessagingException {
		System.out.println("TicketChannel: " + msg.getPayload());
	}
}
