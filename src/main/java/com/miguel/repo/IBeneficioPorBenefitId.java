package com.miguel.repo;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.miguel.model.BeneficioPorBenefitId;

import reactor.core.publisher.Flux;

@Repository
public interface IBeneficioPorBenefitId extends ReactiveCosmosRepository<BeneficioPorBenefitId, String> {

//	Flux<BeneficioPorBenefitId> findBySegment(String segmento);
	
	Flux<BeneficioPorBenefitId> findBySegment(String segmento);
}
