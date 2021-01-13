package com.miguel.model;

import org.springframework.data.annotation.Id;

//import org.hibernate.validator.constraints.UniqueElements;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

@Document(collection = "favoritesListByPersonId")
public class ListaFavoritosPorPersonId {

	@PartitionKey
	private String personId;

	@Id
	private String benefitId;

	private String favoriteFlag;

	private String favoriteUpdate;

	public ListaFavoritosPorPersonId(String personId, String benefitId, String favoriteFlag, String favoriteUpdate) {
		super();
		this.personId = personId;
		this.benefitId = benefitId;
		this.favoriteFlag = favoriteFlag;
		this.favoriteUpdate = favoriteUpdate;
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

	public String getFavoriteFlag() {
		return favoriteFlag;
	}

	public void setFavoriteFlag(String favoriteFlag) {
		this.favoriteFlag = favoriteFlag;
	}

	public String getFavoriteUpdate() {
		return favoriteUpdate;
	}

	public void setFavoriteUpdate(String favoriteUpdate) {
		this.favoriteUpdate = favoriteUpdate;
	}

	@Override
	public String toString() {
		return "ListaFavoritosPorPersonId [personId=" + personId + ", benefitId=" + benefitId + ", favoriteFlag="
				+ favoriteFlag + ", favoriteUpdate=" + favoriteUpdate + "]";
	}

}
