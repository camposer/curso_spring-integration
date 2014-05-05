package es.indra.formacion.springint;

public class HolaMundo {
	private Mensaje mensaje;
	public void saludar() {
		System.out.println("Hola mundo: " + mensaje);
	}
	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}
}
