import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.citygml4j.xml.schema.SchemaHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ValidationUsingJAXP {

	public static void main(String[] args) throws Exception {
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
		Schema schema = schemaFactory.newSchema(schemaHandler.getSchemaSources());
		
		Validator validator = schema.newValidator();
		validator.setErrorHandler(new ErrorHandler() {
			public void warning(SAXParseException exception) throws SAXException {
				error(exception);
			}

			public void fatalError(SAXParseException exception) throws SAXException {
				error(exception);
			}

			public void error(SAXParseException exception) throws SAXException {
				System.out.print("[" + exception.getLineNumber() + "," + exception.getColumnNumber() + "] ");
				System.out.println(exception.getMessage());
			}
		});
		
		validator.validate(new StreamSource("../../datasets/LOD2_SubsurfaceStructureADE_invalid_v100.xml"));
	}

}
