package com.miguel.model;

import java.util.List;

import org.springframework.data.annotation.Id;

//import org.hibernate.validator.constraints.UniqueElements;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

@Document(collection = "benefitSearchByBenefitId")
public class BeneficioPorBenefitId {

	private String additionalInformation;
	private String image;
	private String restrictionInformation;
	private List<ListItem> address;
	private String organizationName;
	private String dueDate;
	private String groupId;
	private List<String> searchTags;

//	@UniqueElements
	@Id
	private String benefitId;

	private String loadingDate;
	private String typeCode;
	private String provider;

	@PartitionKey
	private String segment;

	private String codComercio;
	private String category;
	private String value;
	private String effectiveDate;

	public BeneficioPorBenefitId(String additionalInformation, String image, String restrictionInformation,
			List<ListItem> address, String organizationName, String dueDate, String groupId, List<String> searchTags,
			String benefitId, String loadingDate, String typeCode, String provider, String segment, String codComercio,
			String category, String value, String effectiveDate) {
		super();
		this.additionalInformation = additionalInformation;
		this.image = image;
		this.restrictionInformation = restrictionInformation;
		this.address = address;
		this.organizationName = organizationName;
		this.dueDate = dueDate;
		this.groupId = groupId;
		this.searchTags = searchTags;
		this.benefitId = benefitId;
		this.loadingDate = loadingDate;
		this.typeCode = typeCode;
		this.provider = provider;
		this.segment = segment;
		this.codComercio = codComercio;
		this.category = category;
		this.value = value;
		this.effectiveDate = effectiveDate;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRestrictionInformation() {
		return restrictionInformation;
	}

	public void setRestrictionInformation(String restrictionInformation) {
		this.restrictionInformation = restrictionInformation;
	}

	public List<ListItem> getAddress() {
		return address;
	}

	public void setAddress(List<ListItem> address) {
		this.address = address;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public List<String> getSearchTags() {
		return searchTags;
	}

	public void setSearchTags(List<String> searchTags) {
		this.searchTags = searchTags;
	}

	public String getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(String benefitId) {
		this.benefitId = benefitId;
	}

	public String getLoadingDate() {
		return loadingDate;
	}

	public void setLoadingDate(String loadingDate) {
		this.loadingDate = loadingDate;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getCodComercio() {
		return codComercio;
	}

	public void setCodComercio(String codComercio) {
		this.codComercio = codComercio;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Override
	public String toString() {
		return "BeneficioPorBenefitId [additionalInformation=" + additionalInformation + ", image=" + image
				+ ", restrictionInformation=" + restrictionInformation + ", address=" + address + ", organizationName="
				+ organizationName + ", dueDate=" + dueDate + ", groupId=" + groupId + ", searchTags=" + searchTags
				+ ", benefitId=" + benefitId + ", loadingDate=" + loadingDate + ", typeCode=" + typeCode + ", provider="
				+ provider + ", segment=" + segment + ", codComercio=" + codComercio + ", category=" + category
				+ ", value=" + value + ", effectiveDate=" + effectiveDate + "]";
	}

}
