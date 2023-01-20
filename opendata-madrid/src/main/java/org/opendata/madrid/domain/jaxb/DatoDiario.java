package org.opendata.madrid.domain.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "Dato_Diario")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatoDiario {

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
    
    @XmlElement(name = "D01")
    private String d01;
    
    @XmlElement(name = "V01")
    private String v01;
    
    @XmlElement(name = "D02")
    private String d02;
    
    @XmlElement(name = "V02")
    private String v02;
    
    @XmlElement(name = "D03")
    private String d03;
    
    @XmlElement(name = "V03")
    private String v03;
    
    @XmlElement(name = "D04")
    private String d04;
    
    @XmlElement(name = "V04")
    private String v04;
    
    @XmlElement(name = "D05")
    private String d05;
    
    @XmlElement(name = "V05")
    private String v05;
    
    @XmlElement(name = "D06")
    private String d06;
    
    @XmlElement(name = "V06")
    private String v06;
    
    @XmlElement(name = "D07")
    private String d07;
    
    @XmlElement(name = "V07")
    private String v07;
    
    @XmlElement(name = "D08")
    private String d08;
    
    @XmlElement(name = "V08")
    private String v08;
    
    @XmlElement(name = "D09")
    private String d09;
    
    @XmlElement(name = "V09")
    private String v09;
    
    @XmlElement(name = "D10")
    private String d10;
    
    @XmlElement(name = "V10")
    private String v10;
    
    @XmlElement(name = "D11")
    private String d11;
    
    @XmlElement(name = "V11")
    private String v11;
    
    @XmlElement(name = "D12")
    private String d12;
    
    @XmlElement(name = "V12")
    private String v12;
    
    @XmlElement(name = "D13")
    private String d13;
    
    @XmlElement(name = "V13")
    private String v13;
    
    @XmlElement(name = "D14")
    private String d14;
    
    @XmlElement(name = "V14")
    private String v14;
    
    @XmlElement(name = "D15")
    private String d15;
    
    @XmlElement(name = "V15")
    private String v15;
    
    @XmlElement(name = "D16")
    private String d16;
    
    @XmlElement(name = "V16")
    private String v16;
    
    @XmlElement(name = "D17")
    private String d17;
    
    @XmlElement(name = "V17")
    private String v17;
    
    @XmlElement(name = "D18")
    private String d18;
    
    @XmlElement(name = "V18")
    private String v18;
    
    @XmlElement(name = "D19")
    private String d19;
    
    @XmlElement(name = "V19")
    private String v19;
    
    @XmlElement(name = "D20")
    private String d20;
    
    @XmlElement(name = "V20")
    private String v20;
	
    @XmlElement(name = "D21")
    private String d21;
    
    @XmlElement(name = "V21")
    private String v21;
    
    @XmlElement(name = "D22")
    private String d22;
    
    @XmlElement(name = "V22")
    private String v22;
    
    @XmlElement(name = "D23")
    private String d23;
    
    @XmlElement(name = "V23")
    private String v23;
    
    @XmlElement(name = "D24")
    private String d24;
    
    @XmlElement(name = "V24")
    private String v24;
    
    @XmlElement(name = "D25")
    private String d25;
    
    @XmlElement(name = "V25")
    private String v25;
    
    @XmlElement(name = "D26")
    private String d26;
    
    @XmlElement(name = "V26")
    private String v26;
    
    @XmlElement(name = "D27")
    private String d27;
    
    @XmlElement(name = "V27")
    private String v27;
    
    @XmlElement(name = "D28")
    private String d28;
    
    @XmlElement(name = "V28")
    private String v28;
    
    @XmlElement(name = "D29")
    private String d29;
    
    @XmlElement(name = "V29")
    private String v29;
    
    @XmlElement(name = "D30")
    private String d30;
    
    @XmlElement(name = "V30")
    private String v30;
	
    @XmlElement(name = "D31")
    private String d31;
    
    @XmlElement(name = "V31")
    private String v31;
	
}
