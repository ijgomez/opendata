package org.opendata.madrid.domain.jaxb;

import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;

import org.junit.Test;
import org.opendata.madrid.helpers.ObjectHelper;

public class DatosTest {

	@Test
	public void testXmlToObect() throws Exception {
		
	    Datos d = ObjectHelper.toObject(new FileInputStream("./src/test/resources/horario.xml"), Datos.class);

	    assertNotNull(d);
	    assertNotNull(d.getDatoHorarios());

	    
	}

}
