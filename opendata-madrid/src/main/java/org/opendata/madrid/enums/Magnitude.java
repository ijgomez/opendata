package org.opendata.madrid.enums;

import lombok.Getter;

public enum Magnitude {

	DIOXIDO_AZUFRE(1, "Dióxido de Azufre", "SO2", Unit.MICROG_M3),
	MONOXIDO_CARBONO(6, "Monóxido de Carbono", "CO", Unit.MILLIG_M3),
	MONOXIDO_NITROGENO(7, "Monóxido de Nitrógeno", "NO", Unit.MICROG_M3),
	DIOXIDO_NITROGENO(8, "Dióxido de Nitrógeno", "NO2", Unit.MICROG_M3),			
	PARTICULAS_25(9, "Partículas < 2.5 µm", "PM2.5", Unit.MICROG_M3),			
	PARTICULAS_10(10, "Partículas < 10 µm", "PM10", Unit.MICROG_M3),		
	OXIDOS_NITROGENO(12, "Óxidos de Nitrógeno", "NOx", Unit.MICROG_M3),			
	OZONO(14, "Ozono", "O3", Unit.MICROG_M3),		
	TOLUENO(20, "Tolueno", "TOL", Unit.MICROG_M3),		
	BENZENO(30, "Benceno", "BEN", Unit.MICROG_M3),			
	ETILBENCENO(35, "Etilbenceno", "EBE", Unit.MICROG_M3),			
	METAXILENO(37, "Metaxileno", "MXY", Unit.MICROG_M3),			
	PARAXILENO(38, "Paraxileno", "PXY", Unit.MICROG_M3),			
	ORTOXILENO(39, "Ortoxileno", "OXY", Unit.MICROG_M3),			
	HIDROCARBUROS_TOTALES(42, "Hidrocarburos totales (hexano)", "TCH", Unit.MILLIG_M3),			
	METANO(43, "Metano", "CH4", Unit.MILLIG_M3),
	HIDROCARBUROS_NO_METALICOS(44, "Hidrocarburos no metánicos (hexano)", "NMHC", Unit.MILLIG_M3),
	RADIACION_ULTRAVIOLETA(80, "Radiación Ultravioleta", null, Unit.MW_M2),
	VELOCIDAD_VIENTO(81, "Velocidad del Viento", null, Unit.M_S),
	DIRECCION_VIENTO(82, "Dirección del Viento", null, null),
	TEMPERATURA(83, "Temperatura", null, Unit.C),
	HUMEDAD_RELATIVA(86, "Humedad Relativa", null, Unit.PERCENTAGE),
	PRESION_BARIOMETRICA(87, "Presión Bariometrica", null, Unit.MILLI_BARES),
	RADIACION_SOLAR(88, "Radiación Solar", null, Unit.W_M2), 
	PRECIPITACION (89, "Precipitación", null, Unit.L_M2)
	;			
	
	@Getter
	private Integer code;
	
	@Getter
	private String description;
	
	@Getter
	private String formula;
	
	@Getter
	private Unit unit;
	
	private Magnitude(Integer code, String description, String formula, Unit unit) {
		this.code = code;
		this.description = description;
		this.formula = formula;
		this.unit = unit;
	}
	
	public static Magnitude getByCode(Integer code) {
		for (Magnitude m : Magnitude.values()) {
			if (m.code.equals(code)) {
				return m;
			}
		}
		throw new IllegalArgumentException("magnitude with code " + code + " not exists");
	}

}
