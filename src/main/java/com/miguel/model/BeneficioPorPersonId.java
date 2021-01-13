package com.miguel.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

@Document(collection = "benefitByPersonId")
public class BeneficioPorPersonId {

	
	@PartitionKey
	private String personId;
	
	@Id
	private String benefitId;
	private List<String> customGroup;
	//[se graba como null]
	private Recomendacion score;

	public BeneficioPorPersonId(String personId, String benefitId, List<String> customGroup, Recomendacion score) {
		super();
		this.personId = personId;
		this.benefitId = benefitId;
		this.customGroup = customGroup;
		this.score = score;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(String benefitId) {
		this.benefitId = benefitId;
	}

	public List<String> getCustomGroup() {
		return customGroup;
	}

	public void setCustomGroup(List<String> customGroup) {
		this.customGroup = customGroup;
	}

	public Recomendacion getScore() {
		return score;
	}

	public void setScore(Recomendacion score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "BeneficioPorPersonId [personId=" + personId + ", benefitId=" + benefitId + ", customGroup="
				+ customGroup + ", score=" + score + "]";
	}

}
