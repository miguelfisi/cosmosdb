package com.miguel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.data.cosmos.PartitionKey;
import com.miguel.model.Persona;
import com.miguel.repo.IPersonaRepo;

import io.reactivex.Single;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	private static final Logger Log = LoggerFactory.getLogger(PersonaController.class);

	@Autowired
	private IPersonaRepo repo;

	@GetMapping
	public Single<List<Persona>> listar() {
//		return repo.findAll(apellido);
		List<Persona> listPers = repo.findAll().collectList().block();

		return Single.create(singleSubscriber -> {

			singleSubscriber.onSuccess(listPers);
		});

	}

	@GetMapping("/{apellido}")
	public Single<List<Persona>> listarporPK(@PathVariable("apellido") PartitionKey apellido) {
//		return repo.findAll(apellido);
		List<Persona> listPers = repo.findAll(apellido).collectList().block();

		return Single.create(singleSubscriber -> {

			singleSubscriber.onSuccess(listPers);
		});

	}

	@GetMapping("/{nombre}")
	public Single<List<Persona>> listarporNombre(@PathVariable("nombre") String nombre) {
//		return repo.findAll(apellido);
		List<Persona> listPers = repo.findByNombre(nombre).collectList().block();

		return Single.create(singleSubscriber -> {

			singleSubscriber.onSuccess(listPers);
		});

	}

	@GetMapping("/{id}")
	public Single<Persona> listarPorId(@PathVariable("id") String idPersona) {
		Persona pers = repo.findById(idPersona).block();
		return Single.create(singleSubscriber -> {

			singleSubscriber.onSuccess(pers);
		});
	}

	@PostMapping
	public Single<Persona> registrar(@RequestBody Persona per) {

		return Single.create(singleSubscriber -> {

			singleSubscriber.onSuccess(repo.save(per).block());
		});

	}

	@PutMapping
	public Single<Persona> modificar(@RequestBody Persona per) {

		return Single.create(singleSubscriber -> {

			singleSubscriber.onSuccess(repo.save(per).block());
		});
	}

	@DeleteMapping("/{id}")
	public Single<Void> eliminar(@PathVariable("id") String idPersona) {

		return Single.create(singleSubscriber -> {

			singleSubscriber.onSuccess(repo.deleteById(idPersona).block());
		});

	}

//	@GetMapping("/{id}")
//	public Mono<Persona> listarPorId(@PathVariable("id") Integer id) {
//		return repo.listarPorId(id);
//	}
//
//	@PostMapping
//	public Mono<Persona> registrar(@RequestBody Persona per) {
//		return repo.registrar(per);
//	}
//
//	@PutMapping
//	public Mono<Persona> modificar(@RequestBody Persona per) {
//		return repo.modificar(per);
//	}
//
//	@DeleteMapping("/{id}")
//	public Mono<Void> eliminar(@PathVariable("id") Integer id) {
//		return repo.eliminar(id);
//	}

}
