package org.opendata.madrid.services;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.opendata.madrid.domain.Station;
import org.opendata.madrid.exceptions.OpenDataServiceException;

public class MadridWeatherStationServiceTest {

	private MadridWeatherStationService madridWeatherStationService;
	
	@Before
	public void init () {
		this.madridWeatherStationService = new MadridWeatherStationService();
	}
	@Test
	public void testReadStationCsvData() throws OpenDataServiceException {
		List<Station> results = madridWeatherStationService.readStationCsvData();
		assertNotNull(results);
		assertNotEquals(0, results.size());
	}

}
