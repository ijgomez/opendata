package org.opendata.madrid.enums;

import lombok.Getter;

public enum Region {


	MADRID(28, "Madrid");

	@Getter
	private Integer code;

	@Getter
	private String description;

	private Region(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static Region getByCode(Integer code) {
		for (Region r : Region.values()) {
			if (r.code.equals(code)) {
				return r;
			}
		}
		throw new IllegalArgumentException("Region with code " + code + " not exists");
	}
}
