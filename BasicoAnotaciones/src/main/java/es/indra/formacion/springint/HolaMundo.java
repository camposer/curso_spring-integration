package es.indra.formacion.springint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HolaMundo implements IHolaMundo {
	@Autowired
	@Qualifier("mensaje1")
	private IMensaje mensaje;
	public void saludar() {
		System.out.println("Hola mundo: " + mensaje);
	}
}
