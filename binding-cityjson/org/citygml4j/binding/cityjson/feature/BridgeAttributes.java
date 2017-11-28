package org.citygml4j.binding.cityjson.feature;

public class BridgeAttributes extends Attributes {
	private Integer yearOfConstruction;
	private Integer yearOfDemolition;
	private Boolean isMovable;
			
	public boolean isSetYearOfConstruction() {
		return yearOfConstruction != null;
	}
	
	public Integer getYearOfConstruction() {
		return yearOfConstruction;
	}
	
	public void setYearOfConstruction(Integer yearOfConstruction) {
		this.yearOfConstruction = yearOfConstruction;
	}
	
	public boolean isSetYearOfDemolition() {
		return yearOfDemolition != null;
	}
	
	public Integer getYearOfDemolition() {
		return yearOfDemolition;
	}
	
	public void setYearOfDemolition(Integer yearOfDemolition) {
		this.yearOfDemolition = yearOfDemolition;
	}
	
	public boolean isSetIsMovable() {
		return isMovable != null;
	}
	
	public Boolean getIsMovable() {
		return isMovable;
	}
	
	public void setIsMovable(boolean isMovable) {
		this.isMovable = isMovable;
	}
	
	public boolean hasAttributes() {
		return super.hasAttributes()
				|| yearOfConstruction != null
				|| yearOfDemolition != null
				|| isMovable != null;
	}
}
