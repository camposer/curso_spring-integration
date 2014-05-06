package es.indra.formacion.springint.tms.router;

import org.springframework.integration.annotation.Router;
import org.springframework.stereotype.Component;

import es.indra.formacion.springint.tms.model.Ticket;

@Component
public class TicketRouter {
	public static final String CANAL_ALTA_PRIORIDAD = "ticketPrioridadAlta";
	public static final String CANAL_BAJA_PRIORIDAD = "ticketPrioridadBaja";
	
	@Router
	public String enrutar(Ticket t) {
		if (t.getPriority().equals(Ticket.Priority.high) || 
				t.getPriority().equals(Ticket.Priority.emergency))
				return CANAL_ALTA_PRIORIDAD;
			else
				return CANAL_BAJA_PRIORIDAD;
	}
}
