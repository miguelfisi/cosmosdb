package com.miguel.repo;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.miguel.model.ClienteCompromisoPorPersonId;

@Repository
public interface IClienteCompromisoPorPersonId extends ReactiveCosmosRepository<ClienteCompromisoPorPersonId, String> {

}
