package es.indra.formacion.springint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx =
				new ClassPathXmlApplicationContext(
						"applicationContext.xml"
						);
		IMensaje msg = ctx.getBean("mensaje1", IMensaje.class);
		msg.setTexto("Cambiado #1");
		ctx.getBean("holaMundo1", IHolaMundo.class)
			.saludar(); // => Hola Mundo: mensaje: Cambiado #1 
		ctx.getBean("holaMundo2", IHolaMundo.class)
			.saludar(); // => Hello Wolrd: message: Juan 
		ctx.getBean("holaMundo3", IHolaMundo.class)
			.saludar(); // => Hello World: mensaje: Juan
	}
}
