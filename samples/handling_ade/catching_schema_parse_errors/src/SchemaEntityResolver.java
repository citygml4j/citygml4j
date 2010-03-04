import java.io.IOException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class SchemaEntityResolver implements EntityResolver {

	public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
		System.out.println("SCHEMA ENTITY RESOLVE ERROR: Failed to parse schema '" + publicId + "' when reading from '" + systemId +"'");
		
		InputSource inputSource = null;
		if (publicId.equals("http://www.citygml.org/ade/noise_de")) {
			inputSource = new InputSource("../../datasets/schemas/CityGML-NoiseADE-0-5-0.xsd");
			System.out.println("FIX: Reading from '" + inputSource.getSystemId() + "'\n");
		}
			
		return inputSource;
	}

}
