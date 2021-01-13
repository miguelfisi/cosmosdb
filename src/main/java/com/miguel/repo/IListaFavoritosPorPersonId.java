package com.miguel.repo;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.miguel.model.ListaFavoritosPorPersonId;

@Repository
public interface IListaFavoritosPorPersonId extends ReactiveCosmosRepository<ListaFavoritosPorPersonId, String> {

}
