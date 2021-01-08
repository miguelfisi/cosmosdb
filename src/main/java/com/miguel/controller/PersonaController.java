package com.miguel.controller;

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

@RestController
@RequestMapping("/personas")
public class PersonaController {

//	private static final Logger Log = LoggerFactory.getLogger(PersonaController.class);

	@Autowired
	private IPersonaRepo repo;

	// +
	@GetMapping("/lista")
	public Flowable<Persona> listar() {
//		return repo.findAll(apellido);
//		List<Persona> listPers = repo.findAll().collectList().block();

		return RxJava2Adapter.fluxToFlowable(repo.findAll());
//		return Single.create(singleSubscriber -> {
//
//			singleSubscriber.onSuccess(listPers);
//		});

	}

//	@GetMapping("/{apellido}")
////	@GetMapping(value = "{apellido}")
//	public Flowable<Persona> listarporPK(@PathVariable("apellido") PartitionKey apellido) {
////		return repo.findAll(apellido);
//
////		List<Persona> listPers = repo.findAll(apellido).collectList().block();
////		Flux<Persona> flux = repo.findAll(apellido);
////		Flowable<Persona> flowable = RxJava2Adapter.fluxToFlowable(flux);
//
//		return RxJava2Adapter.fluxToFlowable(repo.findAll(apellido));
//
//	}

	// [hacer un if dentro: si nombre existe tall ...si id existe tall ..en un solo
	// metodo]

//	@GetMapping("/nombre/{nom}")
//	public Flowable<Persona> listarporNombre(@PathVariable("nom") String nombre) {
////		return repo.findAll(apellido);
////		List<Persona> listPers = repo.findByNombre(nombre).collectList().block();
//
//		return RxJava2Adapter.fluxToFlowable(repo.findByNombre(nombre));
//
//	}

	@GetMapping("/nombre")
	public Flowable<Persona> listarporNombre(String nombre) {
//		return repo.findAll(apellido);
//		List<Persona> listPers = repo.findByNombre(nombre).collectList().block();

		return RxJava2Adapter.fluxToFlowable(repo.findByNombre(nombre));

	}

	@GetMapping("/apellido")
	public Flowable<Persona> listarporKP(PartitionKey apellido) {
//		return repo.findAll(apellido);
//		List<Persona> listPers = repo.findByNombre(nombre).collectList().block();

		return RxJava2Adapter.fluxToFlowable(repo.findAll(apellido));

	}

	@GetMapping("/id/{idPersona}")
	public Single<Persona> listarPorId(@PathVariable("idPersona") String id) {
//		Persona pers = repo.findById(idPersona).block();
//		return Single.create(singleSubscriber -> {
//
//			singleSubscriber.onSuccess(pers);
//		});

		return RxJava2Adapter.monoToSingle(repo.findById(id));

	}

	// +
	@PostMapping
	public Single<Persona> registrar(@RequestBody Persona per) {

//		return Single.create(singleSubscriber -> {
//
//			singleSubscriber.onSuccess(repo.save(per).block());
//		});
//		
		return RxJava2Adapter.monoToSingle(repo.save(per));

	}

	// [verificar la operacion reactiva crud ]
	@PutMapping
	public Single<Persona> modificar(@RequestBody Persona per) {

		return RxJava2Adapter.monoToSingle(repo.save(per));

	}

	@DeleteMapping("/{id}")
	public Single<Void> eliminar(@PathVariable("id") String idPersona) {

//		return Single.create(singleSubscriber -> {
//
//			singleSubscriber.onSuccess(repo.deleteById(idPersona).block());
//		});

		return RxJava2Adapter.monoToSingle(repo.deleteById(idPersona));

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
