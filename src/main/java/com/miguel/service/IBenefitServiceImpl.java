package com.miguel.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguel.BenefitsApplication;
import com.miguel.model.BeneficioPorBenefitId;
import com.miguel.model.ClientePorPersonId;
import com.miguel.repo.IBeneficioPorBenefitId;
import com.miguel.repo.IClientePorPersonId;

import io.reactivex.Flowable;
import io.reactivex.Single;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IBenefitServiceImpl implements IBenefitService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BenefitsApplication.class);

//	@Autowired
//	private IListaFavoritosPorPersonId iListaFavoritosPorPersonIdRepo;
//
//	@Autowired
//	private IClientePorPersonId iClientePorPersonIdRepo;

	@Autowired
	private IBeneficioPorBenefitId iBeneficioPorBenefitIdRepo;

	@Autowired
	private IClientePorPersonId iClientePorPersonIdRepo;

//	
//	@Autowired
//	private IBeneficioPorPersonId iBeneficioPorPersonIdRepo;

//	@Autowired
//	private IBeneficioPorPersonId iBeneficioPorPersonIdRepo;
//
//	@Autowired
//	private IClienteCompromisoPorPersonId iclienteCompromisoPorPersonId;

	@Override
	public Flowable<BeneficioPorBenefitId> obtenerBeneficios(String id) {

//		return RxJava2Adapter.fluxToFlowable(
//				iBeneficioPorBenefitIdRepo.findBySegment(iClientePorPersonIdRepo.findById(id).block().getSegment()));
//		return RxJava2Adapter.fluxToFlowable();

		Mono<Flux<BeneficioPorBenefitId>> mono = iClientePorPersonIdRepo.findById(id)
				.map(x -> iBeneficioPorBenefitIdRepo.findBySegment(x.getSegment()));

		Single<Flux<BeneficioPorBenefitId>> single = RxJava2Adapter.monoToSingle(mono);
		Flux<BeneficioPorBenefitId> flux = single.blockingGet();

		return RxJava2Adapter.fluxToFlowable(flux);

	}

//	@Override
//	public Single<BeneficioPorBenefitId> listarPorId(String benefitId) {
//
//		return RxJava2Adapter.monoToSingle(iBeneficioPorBenefitIdRepo.findById(benefitId));
//
//	}

//	@Override
//	public Single<BeneficioPorBenefitId> registrar(BeneficioPorBenefitId beneficioPorBenefitId) {
//		// TODO Auto-generated method stub
//		return RxJava2Adapter.monoToSingle(iBeneficioPorBenefitIdRepo.save(beneficioPorBenefitId));
//	}

//	@Override
//	public Flowable<BeneficioPorBenefitId> findBySegment(String segmento) {
//		// TODO Auto-generated method stub
//
//		return RxJava2Adapter.fluxToFlowable(iBeneficioPorBenefitIdRepo.findBySegment(segmento));
//
//	}

	@Override
	public Single<ClientePorPersonId> registrarClientByPersonId(ClientePorPersonId beneficioBenefitId) {
		return RxJava2Adapter.monoToSingle(iClientePorPersonIdRepo.save(beneficioBenefitId));

	}

	@Override
	public Single<BeneficioPorBenefitId> registrarBenefitSearchByBenefitId(BeneficioPorBenefitId beneficioBenefitId) {
		return RxJava2Adapter.monoToSingle(iBeneficioPorBenefitIdRepo.save(beneficioBenefitId));

	}

//	@Override
//	public Flowable<BeneficioPorBenefitId> findById(String id) {
//		// TODO Auto-generated method stub
//
//		return RxJava2Adapter.fluxToFlowable(iBeneficioPorBenefitIdRepo.findBySegment(segmento));
//
//	}

//
//	public Flowable<BeneficioPorBenefitId> listarAll();
//
//	public Single<BeneficioPorBenefitId> listarPorId(String id);
//
//	
//
//	public Flowable<BeneficioPorBenefitId> findBySegment(String segmento);
//	
//	public Single<BeneficioPorBenefitId> findById(String id);
//	
//	public Single<BeneficioPorBenefitId> save(BeneficioPorBenefitId beneficioBenefitId);

//	@PostConstruct
//	public void setup() {
//		LOGGER.info("Clear the database");
//		this.iClientePorPersonIdRepo.deleteAll().block();
//		this.iBeneficioPorBenefitIdRepo.deleteAll().block();
//	}
//
//	@PreDestroy
//	public void cleanup() {
//		LOGGER.info("Cleaning up benefits by benefitId");
//		this.iClientePorPersonIdRepo.deleteAll().block();
//		this.iBeneficioPorBenefitIdRepo.deleteAll().block();
//	}

}
