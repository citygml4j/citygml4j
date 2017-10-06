package org.citygml4j.builder.json.objects;

public class SolitaryVegetationObjectAttributes extends DefaultAttributes {
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

	public boolean isSetTrunkDiameter() {
		return trunkDiameter != null;
	}
	
	public Double getTrunkDiameter() {
		return trunkDiameter;
	}

	public void setTrunkDiameter(Double trunkDiameter) {
		this.trunkDiameter = trunkDiameter;
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
	
	public boolean hasAttributes() {
		return super.hasAttributes()
				|| species != null
				|| trunkDiameter != null
				|| crownDiameter != null;
	}
	
}
