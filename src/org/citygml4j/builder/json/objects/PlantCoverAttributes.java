package org.citygml4j.builder.json.objects;

public class PlantCoverAttributes extends DefaultAttributes {
	private Double averageHeight;

	public boolean isSetAverageHeight() {
		return averageHeight != null;
	}
	
	public Double getAverageHeight() {
		return averageHeight;
	}

	public void setAverageHeight(Double averageHeight) {
		this.averageHeight = averageHeight;
	}
	
}
