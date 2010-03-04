
package org.citygml4j.xml.io.writer;

public class CityGMLWriteException extends Exception {
	private static final long serialVersionUID = -3716015045363231263L;
	
	public CityGMLWriteException() {
		super();
	}
	
	public CityGMLWriteException(String message) {
		super(message);
	}
	
	public CityGMLWriteException(Throwable cause) {
		super(cause);
	}
	
	public CityGMLWriteException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
