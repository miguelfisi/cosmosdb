package com.miguel.service;

import com.miguel.model.BeneficioPorBenefitId;
import com.miguel.model.ClientePorPersonId;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface IBenefitService {

	public Flowable<BeneficioPorBenefitId> obtenerBeneficios(String id);

//	public Single<BeneficioPorBenefitId> listarPorId(String id);
//
//	public Single<BeneficioPorBenefitId> registrar(BeneficioPorBenefitId beneficioPorBenefitId);
//
//	public Flowable<BeneficioPorBenefitId> findBySegment(String segmento);

	public Single<ClientePorPersonId> registrarClientByPersonId(ClientePorPersonId beneficioBenefitId);

	public Single<BeneficioPorBenefitId> registrarBenefitSearchByBenefitId(BeneficioPorBenefitId beneficioBenefitId);

//	public Single<BeneficioPorBenefitId> save(BeneficioPorBenefitId beneficioBenefitId);

//	public Single<BeneficioPorBenefitId> registrar(@RequestBody BeneficioPorBenefitId beneficioBenefitId) {
//		return iBenefitService.

//	return iBenefitService.findById(id);
//
//	public Single<BeneficioPorBenefitId> listarPorId(@PathVariable("id") String id) {
//
//		return iBenefitService.findById(id);
//
//	}

}
