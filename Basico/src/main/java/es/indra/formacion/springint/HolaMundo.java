package es.indra.formacion.springint;

public class HolaMundo implements IHolaMundo {
	private IMensaje mensaje;
	public void saludar() {
		System.out.println("Hola mundo: " + mensaje);
	}
	public void setMensaje(IMensaje mensaje) {
		this.mensaje = mensaje;
	}
}
