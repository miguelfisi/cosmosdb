package com.miguel.model;

import org.springframework.data.annotation.Id;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

@Document(collection = "clientByPersonId")
public class ClientePorPersonId {

	private String msghubPlatform;
	private String firstName;
	private String firebaseToken;
	private String documentType;
	private String documentNumber;
	private String segment;
	private String personIdEncrypt;

	@Id
	@PartitionKey
	private String personId;

	private String firstAccess;
	private String lastAccess;
	private String msghubId;

	public ClientePorPersonId(String msghubPlatform, String firstName, String firebaseToken, String documentType,
			String documentNumber, String segment, String personIdEncrypt, String personId, String firstAccess,
			String lastAccess, String msghubId) {
		super();
		this.msghubPlatform = msghubPlatform;
		this.firstName = firstName;
		this.firebaseToken = firebaseToken;
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.segment = segment;
		this.personIdEncrypt = personIdEncrypt;
		this.personId = personId;
		this.firstAccess = firstAccess;
		this.lastAccess = lastAccess;
		this.msghubId = msghubId;
	}

	public String getMsghubPlatform() {
		return msghubPlatform;
	}

	public void setMsghubPlatform(String msghubPlatform) {
		this.msghubPlatform = msghubPlatform;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirebaseToken() {
		return firebaseToken;
	}

	public void setFirebaseToken(String firebaseToken) {
		this.firebaseToken = firebaseToken;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getPersonIdEncrypt() {
		return personIdEncrypt;
	}

	public void setPersonIdEncrypt(String personIdEncrypt) {
		this.personIdEncrypt = personIdEncrypt;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getFirstAccess() {
		return firstAccess;
	}

	public void setFirstAccess(String firstAccess) {
		this.firstAccess = firstAccess;
	}

	public String getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(String lastAccess) {
		this.lastAccess = lastAccess;
	}

	public String getMsghubId() {
		return msghubId;
	}

	public void setMsghubId(String msghubId) {
		this.msghubId = msghubId;
	}

	@Override
	public String toString() {
		return "ClientePorPersonId [msghubPlatform=" + msghubPlatform + ", firstName=" + firstName + ", firebaseToken="
				+ firebaseToken + ", documentType=" + documentType + ", documentNumber=" + documentNumber + ", segment="
				+ segment + ", personIdEncrypt=" + personIdEncrypt + ", personId=" + personId + ", firstAccess="
				+ firstAccess + ", lastAccess=" + lastAccess + ", msghubId=" + msghubId + "]";
	}

}
