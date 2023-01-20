package org.opendata.madrid.services;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.opendata.madrid.domain.Measure;
import org.opendata.madrid.domain.Station;
import org.opendata.madrid.domain.jaxb.DatoHorario;
import org.opendata.madrid.domain.jaxb.Datos;
import org.opendata.madrid.enums.Magnitude;
import org.opendata.madrid.enums.MeasureType;
import org.opendata.madrid.enums.Technique;
import org.opendata.madrid.exceptions.OpenDataServiceException;
import org.opendata.madrid.helpers.DateTimeHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MadridWeatherDataService extends MadridOpenDataService<Measure> {
	
	private static final String URL_BASE = "https://www.mambiente.madrid.es/opendata/meteorologia";

	public List<Measure> readRealTimeTxtData() throws OpenDataServiceException {
		return super.downloadCsvData(URL_BASE + ".txt", ',', false, line -> {
			List<Measure> measures = new ArrayList<>();
			
			try {
				Station station = this.buildStation(line[0], line[1], line[2]);

				for (int i = 9; i < line.length; i+=2) {
					this.buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(line[6], line[7], line[8], String.valueOf((((i - 9)/2) + 1))), line[i], line[i + 1], Magnitude.getByCode(Integer.parseInt(line[3])), Technique.getByCode(Integer.parseInt(line[4])), measures);
				}
				return measures;
			} catch (Exception e) {
				log.error("Invalid txt Data: {}", e.getMessage());
				log.debug("Data: " + Arrays.toString(line));
			}
			return measures;
		});
	}
	
	public List<Measure> readRealTimeCsvData() throws OpenDataServiceException {
		return super.downloadCsvData(URL_BASE + ".csv", ';', true, this::toMeasures);
	}

	public List<Measure> readRealTimeXmlData() throws OpenDataServiceException {
		List<Measure> measures = new ArrayList<>();

		Datos datos = super.downloadXmlData(URL_BASE + ".xml", Datos.class);
		try {
			for (DatoHorario datoHorario: datos.getDatoHorarios()) {
				measures.addAll(toMeasures(datoHorario));
			}
		} catch (Exception e) {
			log.error("Invalid XML Data: {}", e.getMessage());
		}
		return measures;
	}

	public List<Measure> readHistoricalHourlyData(int year, int month) throws OpenDataServiceException {
		String url;
		ZonedDateTime dateTime;
		String m;
		String y;
		
		dateTime = ZonedDateTime.of(year, month, 1, 0, 0, 0, 0, ZoneId.systemDefault());

		m = dateTime.getMonth().getDisplayName(TextStyle.SHORT, Locale.getDefault()).substring(0, 3);
		
		y = dateTime.format(DateTimeFormatter.ofPattern("yy"));
		
		url = "https://datos.madrid.es/egobfiles/MANUAL/300352/" + m + "_meteo" + y + ".csv";

		return super.downloadCsvData(url, ';', true, this::toMeasures);
	}
	
	public List<Measure> readHistoricalDailyData(int year) throws OpenDataServiceException {
		String url;

		if (year == 2019) {
			url = "https://datos.madrid.es/egobfiles/MANUAL/300351/meteo19.csv";
		} else if (year == 2020) {
			url = "https://datos.madrid.es/egobfiles/MANUAL/300351/meteo20.csv";
		} else if (year == 2021) {
			url = "https://datos.madrid.es/egobfiles/MANUAL/300351/meteo21.csv";
		} else if (year == 2022) {
			url = "https://datos.madrid.es/egobfiles/MANUAL/300351/meteo22.csv";
		} else {
			throw new OpenDataServiceException("Invalid year", null);
		}
		return super.downloadCsvData(url, ';', true, this::toMeasures);
	}
	
	
}
