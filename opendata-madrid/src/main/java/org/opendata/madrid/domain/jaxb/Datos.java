package org.opendata.madrid.domain.jaxb;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "Datos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Datos {

	@XmlElement(name="Dato_Horario")
	private List<DatoHorario> datoHorarios;
	
	@XmlElement(name="Dato_Diario")
	private List<DatoDiario> datoDiarios;
	
}
