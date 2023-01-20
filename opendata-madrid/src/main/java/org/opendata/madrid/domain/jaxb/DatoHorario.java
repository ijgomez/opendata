package org.opendata.madrid.domain.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "Dato_Horario")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatoHorario {

	@XmlElement
	private String provincia;
	
	@XmlElement
	private String municipio;
	
	@XmlElement
	private String estacion;
	
	@XmlElement
	private String magnitud;
	
	@XmlElement(name = "punto_muestreo")
	private String puntoMuestreo;
	
	@XmlElement
	private String ano;
	
	@XmlElement
	private String mes;
    
    @XmlElement
    private String dia;
    
    @XmlElement(name = "H01")
    private String h01;
    
    @XmlElement(name = "V01")
    private String v01;
    
    @XmlElement(name = "H02")
    private String h02;
    
    @XmlElement(name = "V02")
    private String v02;
    
    @XmlElement(name = "H03")
    private String h03;
    
    @XmlElement(name = "V03")
    private String v03;
    
    @XmlElement(name = "H04")
    private String h04;
    
    @XmlElement(name = "V04")
    private String v04;
    
    @XmlElement(name = "H05")
    private String h05;
    
    @XmlElement(name = "V05")
    private String v05;
    
    @XmlElement(name = "H06")
    private String h06;
    
    @XmlElement(name = "V06")
    private String v06;
    
    @XmlElement(name = "H07")
    private String h07;
    
    @XmlElement(name = "V07")
    private String v07;
    
    @XmlElement(name = "H08")
    private String h08;
    
    @XmlElement(name = "V08")
    private String v08;
    
    @XmlElement(name = "H09")
    private String h09;
    
    @XmlElement(name = "V09")
    private String v09;
    
    @XmlElement(name = "H10")
    private String h10;
    
    @XmlElement(name = "V10")
    private String v10;
    
    @XmlElement(name = "H11")
    private String h11;
    
    @XmlElement(name = "V11")
    private String v11;
    
    @XmlElement(name = "H12")
    private String h12;
    
    @XmlElement(name = "V12")
    private String v12;
    
    @XmlElement(name = "H13")
    private String h13;
    
    @XmlElement(name = "V13")
    private String v13;
    
    @XmlElement(name = "H14")
    private String h14;
    
    @XmlElement(name = "V14")
    private String v14;
    
    @XmlElement(name = "H15")
    private String h15;
    
    @XmlElement(name = "V15")
    private String v15;
    
    @XmlElement(name = "H16")
    private String h16;
    
    @XmlElement(name = "V16")
    private String v16;
    
    @XmlElement(name = "H17")
    private String h17;
    
    @XmlElement(name = "V17")
    private String v17;
    
    @XmlElement(name = "H18")
    private String h18;
    
    @XmlElement(name = "V18")
    private String v18;
    
    @XmlElement(name = "H19")
    private String h19;
    
    @XmlElement(name = "V19")
    private String v19;
    
    @XmlElement(name = "H20")
    private String h20;
    
    @XmlElement(name = "V20")
    private String v20;
	
    @XmlElement(name = "H21")
    private String h21;
    
    @XmlElement(name = "V21")
    private String v21;
    
    @XmlElement(name = "H22")
    private String h22;
    
    @XmlElement(name = "V22")
    private String v22;
    
    @XmlElement(name = "H23")
    private String h23;
    
    @XmlElement(name = "V23")
    private String v23;
    
    @XmlElement(name = "H24")
    private String h24;
    
    @XmlElement(name = "V24")
    private String v24;
	
}
