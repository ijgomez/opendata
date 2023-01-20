package org.opendata.madrid.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class MadridAirQualityDataService extends MadridOpenDataService<Measure> {
	
	private static final String URL_BASE = "https://www.mambiente.madrid.es/opendata/horario";

	public List<Measure> readRealTimeTxtData() throws OpenDataServiceException {
		return super.downloadCsvData(URL_BASE + ".txt", ',', false, line -> {
			List<Measure> measures = new ArrayList<>();
			
			try {
				Station station = this.buildStation(line[0], line[1], line[2]);

				for (int i = 9; i < line.length; i+=2) {
					this.buildMeasure(station, MeasureType.HOURLY, DateTimeHelper.toZonedDateTime(line[6], line[7], line[8], String.valueOf(((i - 9)/2) + 1)), line[i], line[i + 1], Magnitude.getByCode(Integer.parseInt(line[3])), Technique.getByCode(Integer.parseInt(line[4])), measures);
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

	
	
	public List<Measure> readHistoricalData(int year) throws OpenDataServiceException {
		String url;

		if (year == 2020) {
			url = "https://datos.madrid.es/egob/catalogo/201200-10306316-calidad-aire-horario.zip";
		} else if (year == 2021) {
			url = "https://datos.madrid.es/egob/catalogo/201200-10306317-calidad-aire-horario.zip";
		} else if (year == 2022) {
			url = "https://datos.madrid.es/egob/catalogo/201200-10306318-calidad-aire-horario.zip";
		} else {
			throw new OpenDataServiceException("Invalid year", null);
		}
		return super.downloadZipData(url, ';', true, this::toMeasures);

	}
	
}
