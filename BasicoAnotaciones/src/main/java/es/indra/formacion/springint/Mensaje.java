package es.indra.formacion.springint;

import org.springframework.stereotype.Component;

@Component
public class Mensaje implements IMensaje {
	private String texto;
	public Mensaje() { this.texto = "Sin valor"; }
	public Mensaje(String texto) { this.texto = texto; }
	public String toString() { return "mensaje: " + texto; }
	public void setTexto(String texto) { this.texto = texto; }
}
