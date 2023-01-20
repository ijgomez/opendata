package org.opendata.madrid.services;

import java.time.Month;
import java.time.Year;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.opendata.madrid.domain.Measure;
import org.opendata.madrid.domain.Station;
import org.opendata.madrid.domain.jaxb.DatoHorario;
import org.opendata.madrid.enums.Magnitude;
import org.opendata.madrid.enums.MeasureStatus;
import org.opendata.madrid.enums.MeasureType;
import org.opendata.madrid.enums.Region;
import org.opendata.madrid.enums.Technique;
import org.opendata.madrid.enums.Town;
import org.opendata.madrid.helpers.DateTimeHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MadridOpenDataService<E> extends OpenDataService<E> { 

	protected List<Measure> toMeasures(DatoHorario datoHorario) {
		List<Measure> measures = new ArrayList<>();
		try {
			Station station = this.buildStation(datoHorario.getProvincia(), datoHorario.getMunicipio(), datoHorario.getEstacion());
			
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf( 1)), datoHorario.getH01(), datoHorario.getV01(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf( 2)), datoHorario.getH02(), datoHorario.getV02(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf( 3)), datoHorario.getH03(), datoHorario.getV03(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf( 4)), datoHorario.getH04(), datoHorario.getV04(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf( 5)), datoHorario.getH05(), datoHorario.getV05(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf( 6)), datoHorario.getH06(), datoHorario.getV06(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf( 7)), datoHorario.getH07(), datoHorario.getV07(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf( 8)), datoHorario.getH08(), datoHorario.getV08(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf( 9)), datoHorario.getH09(), datoHorario.getV09(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(10)), datoHorario.getH10(), datoHorario.getV10(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(11)), datoHorario.getH11(), datoHorario.getV11(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(12)), datoHorario.getH12(), datoHorario.getV12(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(13)), datoHorario.getH13(), datoHorario.getV13(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(14)), datoHorario.getH14(), datoHorario.getV14(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(15)), datoHorario.getH15(), datoHorario.getV15(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(16)), datoHorario.getH16(), datoHorario.getV16(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(17)), datoHorario.getH17(), datoHorario.getV17(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(18)), datoHorario.getH18(), datoHorario.getV18(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(19)), datoHorario.getH19(), datoHorario.getV19(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(20)), datoHorario.getH20(), datoHorario.getV20(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(21)), datoHorario.getH21(), datoHorario.getV21(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(22)), datoHorario.getH22(), datoHorario.getV22(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(23)), datoHorario.getH23(), datoHorario.getV23(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(datoHorario.getAno(), datoHorario.getMes(), datoHorario.getDia(), String.valueOf(24)), datoHorario.getH24(), datoHorario.getV24(), Magnitude.getByCode(Integer.parseInt(datoHorario.getMagnitud())), measures);
			
			return measures;
		} catch (Exception e) {
			log.error("Invalid Data: {}", e.getMessage());
		}
		return measures;
	}

	protected List<Measure> toMeasures(String[] line) {
		List<Measure> measures = new ArrayList<>();
		
		try {
			Station station = this.buildStation(line[0], line[1], line[2]);

			// line[4] -> punto de muestreo

			if (line.length == (8 + 24 * 2)) {
				// Horaria
				for (int i = 8; i < line.length; i+=2) {
					this.buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(line[5], line[6], line[7], String.valueOf((((i - 8)/2) + 1))), line[i], line[i + 1], Magnitude.getByCode(Integer.parseInt(line[3])), measures);
				}
			} else {
				// Diaria
				for (int i = 7; i < line.length; i+=2) {
					int days = Month.of(Integer.valueOf(line[6])).length(Year.of(Integer.valueOf(line[5])).isLeap());
					if ((((i - 7)/2) + 1) <= days) {
						this.buildMeasure(station, MeasureType.DAILY, DateTimeHelper.toZonedDateTime(line[5], line[6], String.valueOf((((i - 7)/2) + 1))), line[i], line[i + 1], Magnitude.getByCode(Integer.parseInt(line[3])), measures);
					}
				}
			}
			return measures;
		} catch (Exception e) {
			log.error("Invalid CSV Data: {}", e.getMessage());
			log.debug("Data: " + Arrays.toString(line));
		}
		return measures;
	}
	
	protected Station buildStation(String provincia, String municipio, String code) {
		Station station;

		station = new Station();
		station.setRegion(Region.getByCode(Integer.parseInt(provincia)));
		station.setTown(Town.getByCode(Integer.parseInt(municipio)));
		station.setCode(code);

		return station;
	}
	
	protected void buildMeasure(Station station, MeasureType type, ZonedDateTime dateTime, String value, String valid, List<Measure> measures) {
		this.buildMeasure(station, type, dateTime, value, valid, null, null, measures);
	}
	
	protected void buildMeasure(Station station, MeasureType type, ZonedDateTime dateTime, String value, String valid, Magnitude magnitude, List<Measure> measures) {
		this.buildMeasure(station, type, dateTime, value, valid, magnitude, null, measures);
	}

	protected void buildMeasure(Station station, MeasureType type, ZonedDateTime dateTime, String value, String valid, Magnitude magnitude, Technique technique, List<Measure> measures) {
		Measure measure;

		if (value != null && valid != null) {
			measure = new Measure();
			measure.setStation(station);
			measure.setType(type);
			measure.setDateTime(dateTime);
			measure.setValue(Double.valueOf(value));
			measure.setMagnitude(magnitude);
			measure.setTechnique(technique);
			measure.setStatus(MeasureStatus.valueOf(valid));
			
			measures.add(measure);
		}
	}
}
