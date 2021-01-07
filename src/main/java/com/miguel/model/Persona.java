package com.miguel.model;

import org.springframework.data.annotation.Id;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

@Document(collection = "myPersona")
public class Persona {

	@Id
	private String idPersona;

	private String nombre;

	@PartitionKey
	private String apellido;

	public Persona(String idPersona, String nombre, String apellido) {

		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

//	@Override
//	public String toString() {
//		return String.format("%t, %t", idPersona, nombre);
//	}

}
