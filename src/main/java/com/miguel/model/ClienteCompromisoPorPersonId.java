package com.miguel.model;

import org.springframework.data.annotation.Id;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

//[como establecer multiples Ids ?]
@Document(collection = "clientCommitmentByPersonId")
public class ClienteCompromisoPorPersonId {

	@PartitionKey
	private String personId;

	private String commitmentId;

	@Id
	private String statusDate;

	private String benefitId;

//	@Id
	private String terminalId;

//	@Id
	private String commerceId;

	private String providerCode;
	private String discountRate;
	private String totalDiscount;
	private String totalAmount;
	private String referenceId;
	private String status;

	public ClienteCompromisoPorPersonId(String personId, String commitmentId, String statusDate, String benefitId,
			String terminalId, String commerceId, String providerCode, String discountRate, String totalDiscount,
			String totalAmount, String referenceId, String status) {
		super();
		this.personId = personId;
		this.commitmentId = commitmentId;
		this.statusDate = statusDate;
		this.benefitId = benefitId;
		this.terminalId = terminalId;
		this.commerceId = commerceId;
		this.providerCode = providerCode;
		this.discountRate = discountRate;
		this.totalDiscount = totalDiscount;
		this.totalAmount = totalAmount;
		this.referenceId = referenceId;
		this.status = status;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getCommitmentId() {
		return commitmentId;
	}

	public void setCommitmentId(String commitmentId) {
		this.commitmentId = commitmentId;
	}

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(String benefitId) {
		this.benefitId = benefitId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getCommerceId() {
		return commerceId;
	}

	public void setCommerceId(String commerceId) {
		this.commerceId = commerceId;
	}

	public String getProviderCode() {
		return providerCode;
	}

	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}

	public String getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(String discountRate) {
		this.discountRate = discountRate;
	}

	public String getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(String totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ClienteCompromisoPorPersonId [personId=" + personId + ", commitmentId=" + commitmentId + ", statusDate="
				+ statusDate + ", benefitId=" + benefitId + ", terminalId=" + terminalId + ", commerceId=" + commerceId
				+ ", providerCode=" + providerCode + ", discountRate=" + discountRate + ", totalDiscount="
				+ totalDiscount + ", totalAmount=" + totalAmount + ", referenceId=" + referenceId + ", status=" + status
				+ "]";
	}

}
