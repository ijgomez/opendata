package org.opendata.madrid.domain;

import java.time.ZonedDateTime;

import org.opendata.madrid.enums.Magnitude;
import org.opendata.madrid.enums.MeasureStatus;
import org.opendata.madrid.enums.MeasureType;
import org.opendata.madrid.enums.Technique;

import lombok.Data;

@Data
public class Measure {
	
	private Station station;

	private ZonedDateTime dateTime;
	
	private Double value;
	
	private Magnitude magnitude;
	
	private MeasureType type;
	
	private Technique technique;
	
	private MeasureStatus status;

}
