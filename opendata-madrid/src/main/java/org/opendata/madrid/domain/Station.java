package org.opendata.madrid.domain;

import java.time.ZonedDateTime;

import org.opendata.madrid.enums.Region;
import org.opendata.madrid.enums.Town;

import lombok.Data;

@Data
public class Station {
	
	private Region region;
	
	private Town town;

	private String code;

	private String uid;
	
	private ZonedDateTime activationDateTime;
	
	private ZonedDateTime dischargeDateTime;
	
	private String name;
	
	private String address;
	
	private Integer altitude;
	
	private String longitude;
	
	private String latitude;
	
}
