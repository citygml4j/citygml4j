package org.citygml4j.builder.json.marshal.util;

import java.util.List;

public class SurfaceDataInfo {
	private final String theme;
	private final int sequenceNumber;
	private final boolean isFront;
	private final List<Double> textureCoordinates;
	
	public SurfaceDataInfo(String theme, int sequenceNumber, boolean isFront, List<Double> textureCoordinates) {
		this.theme = theme;
		this.sequenceNumber = sequenceNumber;
		this.isFront = isFront;
		this.textureCoordinates = textureCoordinates;
	}
	
	public SurfaceDataInfo(String theme, int sequenceNumber, boolean isFront) {
		this(theme, sequenceNumber, isFront, null);
	}
	
	public boolean isMaterial() {
		return textureCoordinates == null;
	}

	public String getTheme() {
		return theme;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public boolean isFront() {
		return isFront;
	}

	public List<Double> getTextureCoordinates() {
		return textureCoordinates;
	}

}
