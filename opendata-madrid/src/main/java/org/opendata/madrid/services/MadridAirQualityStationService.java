package org.opendata.madrid.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.opendata.madrid.domain.Station;
import org.opendata.madrid.enums.Region;
import org.opendata.madrid.enums.Town;
import org.opendata.madrid.exceptions.OpenDataServiceException;
import org.opendata.madrid.helpers.DateTimeHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MadridAirQualityStationService extends OpenDataService<Station> {


	public List<Station> readStationCsvData() throws OpenDataServiceException {
		
		return super.downloadCsvData("https://datos.madrid.es/egob/catalogo/212629-1-estaciones-control-aire.csv", ';', true, line -> {
			List<Station> stations = new ArrayList<>();
			Station station;
			
			try {
				station = new Station();
				station.setUid(line[0]);
				station.setCode(line[1]);
				station.setName(line[2]);
				station.setTown(Town.MADRID);
				station.setRegion(Region.MADRID);
				station.setAddress(line[3]);
				station.setAltitude(Integer.valueOf(line[6]));
				//  7 - COD_TIPO;
				//  8 - NOM_TIPO;
				
				//  9 - NO2;
				// 10 - SO2;
				// 11 - CO;
				// 12 - PM10;
				// 13 - PM2_5;
				// 14 - O3;
				// 15 - BTX;
				station.setActivationDateTime(DateTimeHelper.toZonedDateTime(line[20]));
				station.setLongitude(line[23]);
				station.setLatitude(line[24]);
				
				stations.add(station);
				
				return stations;
			} catch (Exception e) {
				log.error("Invalid CSV Data: {}", e.getMessage());
				log.debug("Data: " + Arrays.toString(line));
			}
			return stations;
		});
	}

	
	
}
