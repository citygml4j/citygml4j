package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

public class Location {
	private final int lineNumber;
	private final int columnNumber;
	private final String publicId;
	private final String systemId;
	
	public Location(int lineNumber, int columnNumber, String systemId, String publicId) {
		this.lineNumber = lineNumber;
		this.columnNumber = columnNumber;
		this.systemId = systemId;
		this.publicId = publicId;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public int getColumnNumber() {
		return columnNumber;
	}

	public String getPublicId() {
		return publicId;
	}

	public String getSystemId() {
		return systemId;
	}
	
}
