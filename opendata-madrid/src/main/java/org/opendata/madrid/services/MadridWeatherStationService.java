package org.opendata.madrid.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.opendata.madrid.domain.Station;
import org.opendata.madrid.enums.Region;
import org.opendata.madrid.enums.Town;
import org.opendata.madrid.exceptions.OpenDataServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MadridWeatherStationService extends OpenDataService<Station> {


	public List<Station> readStationCsvData() throws OpenDataServiceException {
		
		return super.downloadCsvData("https://datos.madrid.es/egob/catalogo/300360-1-meteorologicos-estaciones.csv", ';', true, line -> {
			List<Station> stations = new ArrayList<>();
			Station station;
			
			try {
				if (line[0].isEmpty()) {
					return null;
				}
				station = new Station();
				station.setUid(line[0]);
				station.setCode(line[1]);
				station.setName(line[2]);
				station.setTown(Town.MADRID);
				station.setRegion(Region.MADRID);
				station.setAddress(line[3]);
				station.setAltitude(Integer.valueOf(line[6]));
				
				//  8 - VV (81);
				//  9 - DV (82);
				// 10 -  T (83);
				// 11 - HR (86);
				// 12 - PB (87);
				// 13 - RS (88);
				// 14 -  P (89);
				
				station.setLongitude(line[22]);
				station.setLatitude(line[23]);

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
