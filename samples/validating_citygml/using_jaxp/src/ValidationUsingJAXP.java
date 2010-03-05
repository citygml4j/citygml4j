import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] ");
		
		System.out.println(df.format(new Date()) + "creating SchemaHandler and parsing ADE schema file CityGML-SubsurfaceADE-0_9_0.xsd");		
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		System.out.println(df.format(new Date()) + "creating JAXP schema factory and schema for validation");		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);		
		Schema schema = schemaFactory.newSchema(schemaHandler.getSchemaSources());
		
		System.out.println(df.format(new Date()) + "creating JAXP validator");		
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
		
		System.out.println(df.format(new Date()) + "validating CityGML file LOD2_SubsurfaceStructureADE_invalid_v100.xml");		
		validator.validate(new StreamSource("../../datasets/LOD2_SubsurfaceStructureADE_invalid_v100.xml"));

		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
