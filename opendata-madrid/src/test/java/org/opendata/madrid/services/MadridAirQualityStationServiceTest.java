package org.opendata.madrid.services;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.opendata.madrid.domain.Station;
import org.opendata.madrid.exceptions.OpenDataServiceException;

public class MadridAirQualityStationServiceTest {

	private MadridAirQualityStationService madridAirQualityStationService;
	
	@Before
	public void init () {
		this.madridAirQualityStationService = new MadridAirQualityStationService();
	}
	
	@Test
	public void testReadStationCsvData() throws OpenDataServiceException {
		List<Station> results = madridAirQualityStationService.readStationCsvData();
		assertNotNull(results);
		assertNotEquals(0, results.size());
	}

}
