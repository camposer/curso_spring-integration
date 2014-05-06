package es.indra.formacion.springint.tms.model;

import java.util.Calendar;

public class Ticket {
	public enum Priority {
		low, medium, high, emergency
	}

	private long ticketId;
	private Calendar issueDateTime;
	private String description;
	private Priority priority;

	public Ticket() {
	}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public Calendar getIssueDateTime() {
		return issueDateTime;
	}

	public void setIssueDateTime(Calendar issueDateTime) {
		this.issueDateTime = issueDateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", description=" + description
				+ ", priority=" + priority + "]";
	}
}