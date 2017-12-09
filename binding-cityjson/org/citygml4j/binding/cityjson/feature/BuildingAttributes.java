package org.citygml4j.binding.cityjson.feature;

import java.util.ArrayList;
import java.util.List;

public class BuildingAttributes extends Attributes {
	private Double measuredHeight;
	private String roofType;
	private Integer storeysAboveGround;
	private Integer storeysBelowGround;
	private List<Double> storeyHeightsAboveGround;
	private List<Double> storeyHeightsBelowGround;
	private Integer yearOfConstruction;
	private Integer yearOfDemolition;
	
	public boolean isSetMeasuredHeight() {
		return measuredHeight != null;
	}
	
	public Double getMeasuredHeight() {
		return measuredHeight;
	}
	
	public void setMeasuredHeight(Double measuredHeight) {
		this.measuredHeight = measuredHeight;
	}
	
	public void unsetMeasuredHeight() {
		measuredHeight = null;
	}
	
	public boolean isSetRoofType() {
		return roofType != null;
	}
	
	public String getRoofType() {
		return roofType;
	}
	
	public void setRoofType(String roofType) {
		this.roofType = roofType;
	}
	
	public void unsetRoofType() {
		roofType = null;
	}
	
	public boolean isSetStoreysAboveGround() {
		return storeysAboveGround != null;
	}
	
	public Integer getStoreysAboveGround() {
		return storeysAboveGround;
	}
	
	public void setStoreysAboveGround(Integer storeysAboveGround) {
		this.storeysAboveGround = storeysAboveGround;
	}
	
	public void unsetStoreysAboveGround() {
		storeysAboveGround = null;
	}
	
	public boolean isSetStoreysBelowGround() {
		return storeysBelowGround != null;
	}
	
	public Integer getStoreysBelowGround() {
		return storeysBelowGround;
	}
	
	public void setStoreysBelowGround(Integer storeysBelowGround) {
		this.storeysBelowGround = storeysBelowGround;
	}
	
	public void unsetStoreysBelowGround() {
		storeysBelowGround = null;
	}
	
	public boolean isSetStoreyHeightsAboveGround() {
		return storeyHeightsAboveGround != null;
	}
	
	public void addStoreyHeightsAboveGround(double value) {
		if (storeyHeightsAboveGround == null)
			storeyHeightsAboveGround = new ArrayList<>();
		
		storeyHeightsAboveGround.add(value);
	}
	
	public List<Double> getStoreyHeightsAboveGround() {
		return storeyHeightsAboveGround;
	}
	
	public void setStoreyHeightsAboveGround(List<Double> storeyHeightsAboveGround) {
		this.storeyHeightsAboveGround = storeyHeightsAboveGround;
	}
	
	public void unsetStoreyHeightsAboveGround() {
		storeyHeightsAboveGround = null;
	}
	
	public boolean isSetStoreyHeightsBelowGround() {
		return storeyHeightsBelowGround != null;
	}
	
	public void addStoreyHeightsBelowGround(double value) {
		if (storeyHeightsBelowGround == null)
			storeyHeightsBelowGround = new ArrayList<>();
		
		storeyHeightsBelowGround.add(value);
	}
	
	public List<Double> getStoreyHeightsBelowGround() {
		return storeyHeightsBelowGround;
	}
	
	public void setStoreyHeightsBelowGround(List<Double> storeyHeightsBelowGround) {
		this.storeyHeightsBelowGround = storeyHeightsBelowGround;
	}
	
	public void unsetStoreyHeightsBelowGround() {
		storeyHeightsBelowGround = null;
	}
	
	public boolean isSetYearOfConstruction() {
		return yearOfConstruction != null;
	}
	
	public Integer getYearOfConstruction() {
		return yearOfConstruction;
	}
	
	public void setYearOfConstruction(Integer yearOfConstruction) {
		this.yearOfConstruction = yearOfConstruction;
	}
	
	public void unsetYearOfConstruction() {
		yearOfConstruction = null;
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
	
	public void unsetYearOfDemolition() {
		yearOfDemolition = null;
	}
	
	public boolean hasAttributes() {
		return super.hasAttributes()
				|| measuredHeight != null
				|| roofType != null
				|| storeysAboveGround != null
				|| storeysBelowGround != null
				|| storeyHeightsAboveGround != null
				|| storeyHeightsBelowGround != null
				|| yearOfConstruction != null
				|| yearOfDemolition != null;
	}
}
