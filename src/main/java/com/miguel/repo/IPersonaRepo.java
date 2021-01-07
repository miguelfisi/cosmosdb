package com.miguel.repo;

import org.springframework.stereotype.Repository;

import com.azure.data.cosmos.PartitionKey;
import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.miguel.model.Persona;

import reactor.core.publisher.Flux;

@Repository
public interface IPersonaRepo extends ReactiveCosmosRepository<Persona, String> {

//	Mono<Persona> registrar(Persona per);
//
//	Mono<Persona> modificar(Persona per);
//
//	Flux<Persona> listar();
//
//	Mono<Persona> listarPorId(Integer id);
//
//	Mono<Void> eliminar(Integer id);

	

	Flux<Persona> findByNombre(String nombre);

}
