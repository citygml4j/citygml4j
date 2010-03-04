
package org.citygml4j.xml.validation;

public class CityGMLValidateException extends Exception {
	private static final long serialVersionUID = -54593673266515278L;

	public CityGMLValidateException() {
		super();
	}
	
	public CityGMLValidateException(String message) {
		super(message);
	}
	
	public CityGMLValidateException(Throwable cause) {
		super(cause);
	}
	
	public CityGMLValidateException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
