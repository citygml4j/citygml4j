package org.citygml4j.xml.reader;

public class CityGMLReadException extends Exception {
    private static final long serialVersionUID = -2820518959032762590L;

    public CityGMLReadException() {
        super();
    }

    public CityGMLReadException(String message) {
        super(message);
    }

    public CityGMLReadException(Throwable cause) {
        super(cause);
    }

    public CityGMLReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
