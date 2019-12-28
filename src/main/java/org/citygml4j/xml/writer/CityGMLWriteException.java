package org.citygml4j.xml.writer;

public class CityGMLWriteException extends Exception {
    private static final long serialVersionUID = 5452386689774915248L;

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
