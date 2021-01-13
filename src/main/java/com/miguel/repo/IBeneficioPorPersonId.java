package com.miguel.repo;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.miguel.model.BeneficioPorPersonId;

@Repository
public interface IBeneficioPorPersonId extends ReactiveCosmosRepository<BeneficioPorPersonId, String> {

	
}
