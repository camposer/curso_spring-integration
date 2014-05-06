package es.indra.formacion.springint.channel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class HolaMundoQueueReader {
	private QueueChannel canal;
	
	@Value("#{canalCola}")
	public void setCanal(QueueChannel canal) {
		this.canal = canal;
	}
	
	public void enviar(String mensaje) {
		canal.send(MessageBuilder.withPayload(mensaje).build());
	}

	public void recibir() {
		System.out.println("HolaMundoQueueReader: " + canal.receive());
	}
}
