package es.indra.formacion.springint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx =
				new ClassPathXmlApplicationContext(
						"applicationContext.xml"
						);
		ctx.getBean("holaMundo1", IHolaMundo.class).saludar();
		ctx.getBean("holaMundo2", IHolaMundo.class).saludar();
		ctx.getBean("holaMundo3", IHolaMundo.class).saludar();
	}
}
