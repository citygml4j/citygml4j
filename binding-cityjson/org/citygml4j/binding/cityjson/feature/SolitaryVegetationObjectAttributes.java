package org.citygml4j.binding.cityjson.feature;

public class SolitaryVegetationObjectAttributes extends Attributes {
	private String species;
	private Double trunkDiameter;
	private Double crownDiameter;
	
	public boolean isSetSpecies() {
		return species != null;
	}
	
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	
	public void unsetSpecies() {
		species = null;
	}

	public boolean isSetTrunkDiameter() {
		return trunkDiameter != null;
	}
	
	public Double getTrunkDiameter() {
		return trunkDiameter;
	}

	public void setTrunkDiameter(Double trunkDiameter) {
		this.trunkDiameter = trunkDiameter;
	}
	
	public void unsetTrunkDiameter() {
		trunkDiameter = null;
	}

	public boolean isSetCrownDiameter() {
		return crownDiameter != null;
	}
	
	public Double getCrownDiameter() {
		return crownDiameter;
	}

	public void setCrownDiameter(Double crownDiameter) {
		this.crownDiameter = crownDiameter;
	}
	
	public void unsetCrownDiameter() {
		crownDiameter = null;
	}
	
	public boolean hasAttributes() {
		return super.hasAttributes()
				|| species != null
				|| trunkDiameter != null
				|| crownDiameter != null;
	}
	
}
