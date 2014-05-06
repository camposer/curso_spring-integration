package es.indra.formacion.springint.channel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.Message;
import org.springframework.integration.MessagingException;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.core.MessageHandler;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class HolaMundoPSChannel implements MessageHandler {
	private PublishSubscribeChannel canal;
	
	@Value("#{canalPS}")
	public void setCanal(PublishSubscribeChannel canal) {
		this.canal = canal;
	}
	
	public void enviar(String mensaje) {
		canal.send(MessageBuilder.withPayload(mensaje).build());
	}

	public void suscribir() {
		canal.subscribe(this);
	}

	@Override
	public void handleMessage(Message<?> msg) throws MessagingException {
		System.out.println("HolaMundoPSChannel: " + msg);
	}
}
