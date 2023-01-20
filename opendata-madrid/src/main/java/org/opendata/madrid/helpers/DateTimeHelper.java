package org.opendata.madrid.helpers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {
	
	
	private static final DateTimeFormatter DEFAULT  = DateTimeFormatter.ofPattern("dd/MM/yyyy");


	public static ZonedDateTime toZonedDateTime(String year, String month, String day) {
		return ZonedDateTime.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day), 0, 0, 0, 0, ZoneId.systemDefault());
	}
	
	public static ZonedDateTime toZonedDateTime(String year, String month, String day, String period) {
		ZonedDateTime dateTime = ZonedDateTime.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day), 0, 0, 0, 0, ZoneId.systemDefault());
		return dateTime.plusHours(Long.valueOf(period));
	}
	
	public static ZonedDateTime toZonedDateTime(String date) {
		return LocalDate.parse(date, DEFAULT).atStartOfDay().atZone(ZoneId.systemDefault());
	}
	
	private DateTimeHelper() { }

	
	
}
