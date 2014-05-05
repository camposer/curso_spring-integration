package es.indra.formacion.springint;

public class Message implements IMensaje {
	private String text;
	public Message(String text) { this.text = text; }
	public String toString() { return "message: " + text; }
	public void setTexto(String texto) { this.text = texto; }	
}
