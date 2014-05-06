package es.indra.formacion.springint.tms.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import es.indra.formacion.springint.tms.model.Ticket;

@Component
public class ByteToTicketService {
	@ServiceActivator
	public List<Ticket> handleBytes(byte[] input) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		int counter = 0;
		String field = "";
		Ticket t = new Ticket();
		
		for (byte b : input) {
			if (((char)b) == '\n') {
				t.setPriority(Ticket.Priority.valueOf(field)); // Adding last field (priority)
				tickets.add(t);
				
				t = new Ticket();
				counter = 0;
				field = "";
			} else if (((char)b) == '|') {
				switch (counter) {
					case 0:
						t.setTicketId(Integer.parseInt(field));
						break;
					case 1:
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Calendar c = new GregorianCalendar();
						try {
							c.setTime(sdf.parse(field));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						t.setIssueDateTime(c);
						break;
					case 2: 
						t.setDescription(field);
						break;
				}

				counter++;
				field = "";
			}
			else 
				field += (char)b;  
		}

		return tickets;
	}
}
