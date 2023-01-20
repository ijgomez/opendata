package org.opendata.madrid.enums;

import lombok.Getter;

public enum Technique {

	FLUORESCENCIA(38, "Fluorescencia ultravioleta"), 
	INFRAROJA(48, "Absorción infrarroja"),
	QUIMIO(8, "Quimioluminiscencia"), 
	MICROBALANZA(47, "Microbalanza"),
	ULTRAVIOLETA(06, "Absorción ultravioleta"), 
	CROMATOLOGIA(59, "Cromatografía de gases"),
	IONIZACION(2, "Ionización de llama"),
	T98(98, "");

	@Getter
	private Integer code;

	@Getter
	private String description;

	private Technique(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static Technique getByCode(Integer code) {
		for (Technique t : Technique.values()) {
			if (t.code.equals(code)) {
				return t;
			}
		}
		throw new IllegalArgumentException("technique with code " + code + " not exists");
	}
}
