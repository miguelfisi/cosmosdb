package com.miguel.controller;

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

import io.reactivex.Flowable;
import io.reactivex.Single;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	private static final Logger Log = LoggerFactory.getLogger(PersonaController.class);

	@Autowired
	private IPersonaRepo repo;

	@GetMapping
	public Flowable<Persona> listar() {
//		return repo.findAll(apellido);
//		List<Persona> listPers = repo.findAll().collectList().block();

		Flux<Persona> flux = repo.findAll();
		Flowable<Persona> flowable = RxJava2Adapter.fluxToFlowable(flux);

		return flowable;
//		return Single.create(singleSubscriber -> {
//
//			singleSubscriber.onSuccess(listPers);
//		});

	}

	@GetMapping("/{apellido}")
	public Flowable<Persona> listarporPK(@PathVariable("apellido") PartitionKey apellido) {
//		return repo.findAll(apellido);

//		List<Persona> listPers = repo.findAll(apellido).collectList().block();
		Flux<Persona> flux = repo.findAll(apellido);
		Flowable<Persona> flowable = RxJava2Adapter.fluxToFlowable(flux);

		return flowable;

	}

	@GetMapping("/{nombre}")
	public Flowable<Persona> listarporNombre(@PathVariable("nombre") String nombre) {
//		return repo.findAll(apellido);
//		List<Persona> listPers = repo.findByNombre(nombre).collectList().block();

		Flux<Persona> flux = repo.findByNombre(nombre);
		Flowable<Persona> flowable = RxJava2Adapter.fluxToFlowable(flux);

		return flowable;

	}

	@GetMapping("/{id}")
	public Single<Persona> listarPorId(@PathVariable("id") String idPersona) {
//		Persona pers = repo.findById(idPersona).block();
//		return Single.create(singleSubscriber -> {
//
//			singleSubscriber.onSuccess(pers);
//		});

		Mono<Persona> mono = repo.findById(idPersona);
		Single<Persona> single = RxJava2Adapter.monoToSingle(mono);
		return single;

	}

	@PostMapping
	public Single<Persona> registrar(@RequestBody Persona per) {

//		return Single.create(singleSubscriber -> {
//
//			singleSubscriber.onSuccess(repo.save(per).block());
//		});
//		

		Mono<Persona> mono = repo.save(per);
		Single<Persona> single = RxJava2Adapter.monoToSingle(mono);
		return single;

	}

	// [verificar la operacion reactiva crud ]
	@PutMapping
	public Single<Persona> modificar(@RequestBody Persona per) {

		Mono<Persona> mono = repo.save(per);
		Single<Persona> single = RxJava2Adapter.monoToSingle(mono);
		return single;

	}

	@DeleteMapping("/{id}")
	public Single<Void> eliminar(@PathVariable("id") String idPersona) {

//		return Single.create(singleSubscriber -> {
//
//			singleSubscriber.onSuccess(repo.deleteById(idPersona).block());
//		});

		Mono<Void> monoVoid = repo.deleteById(idPersona);
		Single<Void> single = RxJava2Adapter.monoToSingle(monoVoid);
		return single;

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
