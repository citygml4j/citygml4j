
package org.citygml4j.factory.geometry;

public class DimensionMismatchException extends Exception {
	private static final long serialVersionUID = -3767046580120314517L;

	public DimensionMismatchException() {
		super();
	}
	
	public DimensionMismatchException(String message) {
		super(message);
	}
	
	public DimensionMismatchException(Throwable cause) {
		super(cause);
	}
	
	public DimensionMismatchException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
