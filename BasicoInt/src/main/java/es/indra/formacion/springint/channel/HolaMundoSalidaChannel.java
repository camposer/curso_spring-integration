package es.indra.formacion.springint.channel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.Message;
import org.springframework.integration.MessagingException;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageHandler;
import org.springframework.stereotype.Component;

import es.indra.formacion.springint.model.Envoltorio;

@Component
public class HolaMundoSalidaChannel implements MessageHandler {
	private DirectChannel canal;
	
	@Value("#{canalSalida}")
	public void setCanal(DirectChannel canal) {
		this.canal = canal;
	}
	
	public void suscribir() {
		canal.subscribe(this);
	}
	
	@Override
	public void handleMessage(Message<?> msg) throws MessagingException {
		Envoltorio env = (Envoltorio)msg.getPayload();
		System.out.println("HolaMundoSalidaChannel: " + env.getTexto());
	}
}
