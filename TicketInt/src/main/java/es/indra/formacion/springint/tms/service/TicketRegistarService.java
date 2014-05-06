package es.indra.formacion.springint.tms.service;

import org.springframework.stereotype.Component;

import es.indra.formacion.springint.tms.model.Ticket;

@Component
public class TicketRegistarService {
	public void low(Ticket ticket) {
		System.out.println("low: " + ticket);
	}

	public void medium(Ticket ticket) {
		System.out.println("medium: " + ticket);
	}
	
	public void high(Ticket ticket) {
		System.out.println("high: " + ticket);
	}

	public void emergency(Ticket ticket) {
		System.out.println("emergency: " + ticket);
	}

	public void lowSplitted(String ticket) {
		System.out.println("lowSplitted: " + ticket);
	}

}
