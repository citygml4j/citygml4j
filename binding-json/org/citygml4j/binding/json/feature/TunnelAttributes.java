package org.citygml4j.binding.json.feature;

public class TunnelAttributes extends Attributes {
	private Integer yearOfConstruction;
	private Integer yearOfDemolition;
	
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
	
	public boolean hasAttributes() {
		return super.hasAttributes()
				|| yearOfConstruction != null
				|| yearOfDemolition != null;
	}
}
