package com.miguel.repo;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.miguel.model.ClientePorPersonId;

import reactor.core.publisher.Flux;

@Repository
public interface IClientePorPersonId extends ReactiveCosmosRepository<ClientePorPersonId, String>{

	Flux<ClientePorPersonId> findBySegment(String segmento);
}
