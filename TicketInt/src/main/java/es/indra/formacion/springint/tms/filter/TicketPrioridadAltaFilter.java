package es.indra.formacion.springint.tms.filter;

import org.springframework.integration.Message;
import org.springframework.integration.core.MessageSelector;
import org.springframework.stereotype.Component;

import es.indra.formacion.springint.tms.model.Ticket;

@Component
public class TicketPrioridadAltaFilter implements MessageSelector {
	@Override
	public boolean accept(Message<?> msg) {
		Ticket t = (Ticket)msg;
		
		if (t.getPriority().equals(Ticket.Priority.high) || 
				t.getPriority().equals(Ticket.Priority.emergency)) 
			return true;
		else
			return false;
	}
}
