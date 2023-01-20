package org.opendata.madrid.services;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.opendata.madrid.domain.Measure;
import org.opendata.madrid.exceptions.OpenDataServiceException;

public class MadridAirQualityDataServiceTest {

	private MadridAirQualityDataService madridAirQualityService;
	
	@Before
	public void init () {
		this.madridAirQualityService = new MadridAirQualityDataService();
	}
	
	@Test
	public void testRealTimeTxtData() throws OpenDataServiceException {
		List<Measure> results = madridAirQualityService.readRealTimeTxtData();
		assertNotNull(results);
		assertNotEquals(0, results.size());
		results.stream().forEach(aq -> {
			assertNotNull(aq.getDateTime());
			assertNotNull(aq.getValue());
			assertNotNull(aq.getMagnitude());
			assertNotNull(aq.getStatus());
			assertNotNull(aq.getStation());
		});
	}
	
	@Test
	public void testRealTimeCsvData() throws OpenDataServiceException {
		List<Measure> results = madridAirQualityService.readRealTimeCsvData();
		assertNotNull(results);
		assertNotEquals(0, results.size());
		results.stream().forEach(aq -> {
			assertNotNull(aq.getDateTime());
			assertNotNull(aq.getValue());
			assertNotNull(aq.getMagnitude());
			assertNotNull(aq.getStatus());
			assertNotNull(aq.getStation());
		});
	}
	
	@Test
	public void testRealTimeXmlData() throws OpenDataServiceException {
		List<Measure> results = madridAirQualityService.readRealTimeXmlData();
		assertNotNull(results);
		assertNotEquals(0, results.size());
		results.stream().forEach(aq -> {
			assertNotNull(aq.getDateTime());
			assertNotNull(aq.getValue());
			assertNotNull(aq.getMagnitude());
			assertNotNull(aq.getStatus());
			assertNotNull(aq.getStation());
		});
	}
	
	@Test
	public void testReadHistoricalData() throws OpenDataServiceException {
		List<Measure> results = madridAirQualityService.readHistoricalData(2022);
		assertNotNull(results);
		assertNotEquals(0, results.size());
		results.stream().forEach(aq -> {
			assertNotNull(aq.getDateTime());
			assertNotNull(aq.getValue());
			assertNotNull(aq.getMagnitude());
			assertNotNull(aq.getStatus());
			assertNotNull(aq.getStation());
		});
	}

}
