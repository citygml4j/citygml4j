package util;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SchemaParseErrorHandler implements ErrorHandler {

	public void error(SAXParseException exception) throws SAXException {
		System.out.println("SCHEMA PARSE ERROR: " + exception.getMessage() + "\n");
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("SCHEMA PARSE FATAL ERROR: " + exception.getMessage() + "\n");
	}

	public void warning(SAXParseException exception) throws SAXException {
		System.out.println("SCHEMA PARSE WARNING: " + exception.getMessage() + "\n");
	}

}
