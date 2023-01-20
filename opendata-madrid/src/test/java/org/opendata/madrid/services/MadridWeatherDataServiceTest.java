package org.opendata.madrid.services;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.opendata.madrid.domain.Measure;
import org.opendata.madrid.exceptions.OpenDataServiceException;

public class MadridWeatherDataServiceTest {
	
	private MadridWeatherDataService madridWeatherDataService;
	
	@Before
	public void init () {
		this.madridWeatherDataService = new MadridWeatherDataService();
	}

	@Test
	public void testReadRealTimeTxtData() throws OpenDataServiceException {
		List<Measure> results = madridWeatherDataService.readRealTimeTxtData();
		assertNotNull(results);
		assertNotEquals(0, results.size());
		results.stream().forEach(w -> {
			assertNotNull(w.getDateTime());
			assertNotNull(w.getValue());
			assertNotNull(w.getMagnitude());
			assertNotNull(w.getStatus());
			assertNotNull(w.getStation());
		});
	}

	@Test
	public void testReadRealTimeCsvData() throws OpenDataServiceException {
		List<Measure> results = madridWeatherDataService.readRealTimeCsvData();
		assertNotNull(results);
		assertNotEquals(0, results.size());
		results.stream().forEach(w -> {
			assertNotNull(w.getDateTime());
			assertNotNull(w.getValue());
			assertNotNull(w.getMagnitude());
			assertNotNull(w.getStatus());
			assertNotNull(w.getStation());
		});
	}

	@Test
	public void testReadRealTimeXmlData() throws OpenDataServiceException {
		List<Measure> results = madridWeatherDataService.readRealTimeXmlData();
		assertNotNull(results);
		assertNotEquals(0, results.size());
		results.stream().forEach(w -> {
			assertNotNull(w.getDateTime());
			assertNotNull(w.getValue());
			assertNotNull(w.getMagnitude());
			assertNotNull(w.getStatus());
			assertNotNull(w.getStation());
		});
	}

	@Test
	public void testReadHistoricalHourlyData() throws OpenDataServiceException {
		List<Measure> results;
		
		int[] years = {2019, 2020, 2021, 2022};
		
		for (int y : years) {
			
			int[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
			
			for (int m : months) {
				results = this.madridWeatherDataService.readHistoricalHourlyData(y, m);
				assertNotNull(results);
				assertNotEquals(0, results.size());
				results.stream().forEach(w -> {
					assertNotNull(w.getDateTime());
					assertNotNull(w.getValue());
					assertNotNull(w.getMagnitude());
					assertNotNull(w.getStatus());
					assertNotNull(w.getStation());
				});
			}
			
		}
		
	}

	@Test
	public void testReadHistoricalDailyData() throws OpenDataServiceException {
		List<Measure> results;
		
		int[] years = {2019, 2020, 2021, 2022};
		
		for (int y : years) {
			results = this.madridWeatherDataService.readHistoricalDailyData(y);
			assertNotNull(results);
			assertNotEquals(0, results.size());
			results.stream().forEach(w -> {
				assertNotNull(w.getDateTime());
				assertNotNull(w.getValue());
				assertNotNull(w.getMagnitude());
				assertNotNull(w.getStatus());
				assertNotNull(w.getStation());
			});
		}
		
	}

}
