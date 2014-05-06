package es.indra.formacion.springint.service;

import org.springframework.stereotype.Component;

import es.indra.formacion.springint.model.Envoltorio;

@Component
public class CanalService {
	public void canalPS(String msg) {
		System.out.println("CanalService.canalPS: " + msg);
	}
	
	public Envoltorio traductor(String msg) {
		return new Envoltorio(msg);
	}
}
