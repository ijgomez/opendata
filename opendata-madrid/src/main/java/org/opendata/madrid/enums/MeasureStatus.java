package org.opendata.madrid.enums;

import lombok.Getter;

public enum MeasureStatus {

	V("Valid"),
    N("Not Valid");
	
	@Getter
	private String code;
	
	private MeasureStatus(String code) {
		this.code = code;
	}
	
	public static MeasureStatus getByCode(String code) {
		for (MeasureStatus s : MeasureStatus.values()) {
			if (s.code.equals(code)) {
				return s;
			}
		}
		throw new IllegalArgumentException("Status with code " + code + " not exists");
	}
}
