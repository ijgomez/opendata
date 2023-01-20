package org.opendata.madrid.enums;

import lombok.Getter;

public enum Town {


	MADRID(79, "Madrid");

	@Getter
	private Integer code;

	@Getter
	private String description;

	private Town(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static Town getByCode(Integer code) {
		for (Town t : Town.values()) {
			if (t.code.equals(code)) {
				return t;
			}
		}
		throw new IllegalArgumentException("Town with code " + code + " not exists");
	}
}
