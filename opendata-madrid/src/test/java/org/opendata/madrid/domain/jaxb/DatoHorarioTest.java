package org.opendata.madrid.domain.jaxb;

import static org.junit.Assert.assertNotNull;

import java.io.StringReader;

import org.junit.Test;

import jakarta.xml.bind.JAXBContext;

public class DatoHorarioTest {

	@Test
	public void test() throws Exception {
		String message = 
				"<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + 
				 
				"    <Dato_Horario>\n" + 
				"         <provincia>28</provincia>\n" +
				"    </Dato_Horario>" 
				
				;

	
	
	
	    var unmarshaller = JAXBContext.newInstance(DatoHorario.class).createUnmarshaller();
	    var sr = new StringReader(message);
	    
	    
		Object unmarshal = unmarshaller.unmarshal(sr);
		
		assertNotNull(unmarshal);

	}

}
