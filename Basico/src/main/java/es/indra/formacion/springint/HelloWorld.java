package es.indra.formacion.springint;

public class HelloWorld implements IHolaMundo {
	private IMensaje mensaje;
	public void saludar() {
		System.out.println("Hello world: " + mensaje);
	}
	public void setMensaje(IMensaje mensaje) {
		this.mensaje = mensaje;
	}
}
