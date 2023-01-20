package org.opendata.madrid.helpers;

import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

public class ObjectHelper {
	
	
	private ObjectHelper() {
	}

	
	/**
	 * Converts an {@link String} xml to object.
	 * 
	 * @param <E>
	 * @param message
	 * @param clazz
	 * @return
	 * @throws JAXBException
	 * @throws XMLStreamException 
	 */
	@SuppressWarnings("unchecked")
	public static <E> E toObject(final InputStream inputStream, Class<E> clazz) throws JAXBException, XMLStreamException {
		var unmarshaller = JAXBContext.newInstance(clazz).createUnmarshaller();

		XMLInputFactory factory = XMLInputFactory.newInstance();
		// to be compliant, completely disable DOCTYPE declaration:
		factory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
		// or completely disable external entities declarations:
		factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.FALSE);
		// or prohibit the use of all protocols by external entities:
		factory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		factory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        XMLStreamReader xsr = factory.createXMLStreamReader(inputStream);
        xsr = new XsiTypeReader(xsr);
		
		return (E) unmarshaller.unmarshal(xsr);
	}
	
	private static class XsiTypeReader extends StreamReaderDelegate {
        public XsiTypeReader(XMLStreamReader reader) {
            super(reader);
        }
        @Override
        public String getNamespaceURI() {
            return "";
        }
    }
	
	
}
