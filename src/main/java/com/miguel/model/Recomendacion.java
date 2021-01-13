package com.miguel.model;

//[anotacion ??]
public class Recomendacion {

	private String NUESTRASRECOMENDACIONES;

	public String getNUESTRASRECOMENDACIONES() {
		return NUESTRASRECOMENDACIONES;
	}

	public void setNUESTRASRECOMENDACIONES(String nUESTRASRECOMENDACIONES) {
		NUESTRASRECOMENDACIONES = nUESTRASRECOMENDACIONES;
	}

	@Override
	public String toString() {
		return "Recomendacion [NUESTRASRECOMENDACIONES=" + NUESTRASRECOMENDACIONES + "]";
	}

}
