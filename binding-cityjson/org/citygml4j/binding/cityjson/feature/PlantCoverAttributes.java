package org.citygml4j.binding.cityjson.feature;

public class PlantCoverAttributes extends Attributes {
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
	
	public boolean hasAttributes() {
		return super.hasAttributes()
				|| averageHeight != null;
	}
	
}
