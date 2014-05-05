package es.indra.formacion.springint;

public class Mensaje implements IMensaje {
	private String texto;
	public Mensaje(String texto) { this.texto = texto; }
	public String toString() { return "mensaje: " + texto; }
}
