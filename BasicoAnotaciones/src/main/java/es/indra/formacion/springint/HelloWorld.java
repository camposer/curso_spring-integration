package es.indra.formacion.springint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class HelloWorld implements IHolaMundo {
	@Autowired
	@Qualifier("mensaje2")
	private IMensaje mensaje;
	public void saludar() {
		System.out.println("Hello world: " + mensaje);
	}
}
