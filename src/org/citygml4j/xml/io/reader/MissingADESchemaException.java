
package org.citygml4j.xml.io.reader;

public class MissingADESchemaException extends Exception {
	private static final long serialVersionUID = -3716015045363231263L;
	
	public MissingADESchemaException() {
		super();
	}
	
	public MissingADESchemaException(String message) {
		super(message);
	}
	
	public MissingADESchemaException(Throwable cause) {
		super(cause);
	}
	
	public MissingADESchemaException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
