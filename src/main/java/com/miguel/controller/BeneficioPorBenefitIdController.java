package com.miguel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguel.model.BeneficioPorBenefitId;
import com.miguel.model.ClientePorPersonId;
import com.miguel.service.IBenefitService;

import io.reactivex.Flowable;
import io.reactivex.Single;

@RestController
@RequestMapping("/benefits")
public class BeneficioPorBenefitIdController {

//	private static final Logger LOGGER = LoggerFactory.getLogger(BenefitsApplication.class);

//	@Autowired
//	private IBeneficioPorBenefitId benefitBenefitIdRepo;

	@Autowired
	IBenefitService iBenefitService;

	// +
	@GetMapping("/benefitsList/{id}")
	public Flowable<BeneficioPorBenefitId> getBenefits(@PathVariable("id") String id) {

		return iBenefitService.obtenerBeneficios(id);

	}

//	@GetMapping("/segment")
//	public Flowable<BeneficioPorBenefitId> listarporSegmento(String segment) {
//
//		return iBenefitService.findBySegment(segment);
//
//	}

//	@GetMapping("/id/{id}")
//	public Single<BeneficioPorBenefitId> listarPorId(@PathVariable("id") String id) {
//
//		return iBenefitService.listarPorId(id);
//
//	}

	// +
	@PostMapping("/clientByPersonId")
	public Single<ClientePorPersonId> saveClientByPersonId(@RequestBody ClientePorPersonId beneficioBenefitId) {
		return iBenefitService.registrarClientByPersonId(beneficioBenefitId);

	}

	@PostMapping("/benefitSearchByBenefitId")
	public Single<BeneficioPorBenefitId> saveBenefitSearchByBenefitId(
			@RequestBody BeneficioPorBenefitId beneficioBenefitId) {
		return iBenefitService.registrarBenefitSearchByBenefitId(beneficioBenefitId);

	}

	// [ ### verificar sgtes estado ### ]

	// [verificar la operacion reactiva crud ]
//	@PutMapping
//	public Single<BeneficioPorBenefitId> modificar(@RequestBody BeneficioPorBenefitId beneficioBenefitId) {
//
//		Single<BeneficioPorBenefitId> singlePers = listarPorId(beneficioBenefitId.getBenefitId());
//
//		if (null != singlePers) {
//
//			return RxJava2Adapter.monoToSingle(benefitBenefitIdRepo.save(beneficioBenefitId));
//		}
//
//		return singlePers;
//
//	}

	// [sale un error]
//	@DeleteMapping("/{id}")
//	public Single<Void> eliminar(@PathVariable("id") String id) {
//
//		return RxJava2Adapter.monoToSingle(benefitBenefitIdRepo.deleteById(id));
//
//	}

//	@PostConstruct
//	public void setup() {
//		LOGGER.info("Clear the database");
//		this.benefitBenefitIdRepo.deleteAll().block();
//	}
//
//	@PreDestroy
//	public void cleanup() {
//		LOGGER.info("Cleaning up benefits by benefitId");
//		this.benefitBenefitIdRepo.deleteAll().block();
//	}

}
