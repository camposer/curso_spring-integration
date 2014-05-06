package es.indra.formacion.springint.tms.splitter;

import java.util.List;

import org.springframework.integration.annotation.Splitter;
import org.springframework.stereotype.Component;

import es.indra.formacion.springint.tms.model.Ticket;

@Component
public class TicketSplitter {
	@Splitter
	public List<Ticket> split(List<Ticket> tickets) {
		return tickets;
	}
}
