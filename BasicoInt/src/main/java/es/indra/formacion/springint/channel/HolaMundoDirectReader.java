package es.indra.formacion.springint.channel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.Message;
import org.springframework.integration.MessagingException;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageHandler;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class HolaMundoDirectReader implements MessageHandler {
	private DirectChannel canal;
	
	@Value("#{canalDirecto}")
	public void setCanal(DirectChannel canal) {
		this.canal = canal;
	}
	
	public void suscribir() {
		canal.subscribe(this);
	}
	
	public void enviar(String mensaje) {
		canal.send(MessageBuilder.withPayload(mensaje).build());
	}

	@Override
	public void handleMessage(Message<?> msg) throws MessagingException {
		System.out.println("HolaMundoDirectReader: " + msg);
	}
}
