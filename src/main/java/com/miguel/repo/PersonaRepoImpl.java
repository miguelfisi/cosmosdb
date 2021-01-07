package com.miguel.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaRepoImpl  {

	private static final Logger Log = LoggerFactory.getLogger(PersonaRepoImpl.class);

	
	
//	@Override
//	public Mono<Persona> registrar(Persona per) {
//		Log.info(per.toString());
//		return Mono.just(per);
//	}
//
//	@Override
//	public Mono<Persona> modificar(Persona per) {
//		Log.info(per.toString());
//		return Mono.just(per);
//	}
//
//	@Override
//	public Flux<Persona> listar() {
//		List<Persona> personas = new ArrayList<>();
//		personas.add(new Persona(1, "miguel"));
//		personas.add(new Persona(2, "jose"));
//		personas.add(new Persona(3, "manu"));
//		return Flux.fromIterable(personas); 
//		
//	}
//
//	@Override
//	public Mono<Persona> listarPorId(Integer id) {
//		return Mono.just(new Persona(id, "Miguel"));
//	}
//
//	@Override
//	public Mono<Void> eliminar(Integer id) {
//		// TODO Auto-generated method stub
//		return Mono.empty();
//	}

}
