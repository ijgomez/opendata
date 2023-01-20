package org.opendata.madrid.enums;

import lombok.Getter;

public enum Unit {

	MICROG_M3("µg/m3"),
    MILLIG_M3("mg/m3"),
    MW_M2("Mw/m2"),
    M_S("m/s"),
    C("ºC"),
    PERCENTAGE("%"),
    MILLI_BARES("mb"),
    W_M2("W/m2"),
    L_M2("l/m2");
	
	@Getter
	private String code;
	
	private Unit(String code) {
		this.code = code;
	}
}
