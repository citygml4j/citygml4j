package org.citygml4j.reader.xml;

import org.xmlobjects.stream.XMLReadException;

public class MissingADESchemaException extends XMLReadException {
    private static final long serialVersionUID = 1529067977516724914L;

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
