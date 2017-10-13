package org.citygml4j.builder.json.objects.feature;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuildingAttributes extends Attributes {
	private Double measuredHeight;
	private String roofType;
	private Integer storeysAboveGround;
	private Integer storeysBelowGround;
	private List<Double> storeyHeightsAboveGround;
	private List<Double> storeyHeightsBelowGround;
	private Date yearOfConstruction;
	private Date yearOfDemolition;
	
	public boolean isSetMeasuredHeight() {
		return measuredHeight != null;
	}
	
	public Double getMeasuredHeight() {
		return measuredHeight;
	}
	
	public void setMeasuredHeight(Double measuredHeight) {
		this.measuredHeight = measuredHeight;
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
	
	public boolean isSetStoreysAboveGround() {
		return storeysAboveGround != null;
	}
	
	public Integer getStoreysAboveGround() {
		return storeysAboveGround;
	}
	
	public void setStoreysAboveGround(Integer storeysAboveGround) {
		this.storeysAboveGround = storeysAboveGround;
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
	
	public boolean isSetYearOfConstruction() {
		return yearOfConstruction != null;
	}
	
	public Date getYearOfConstruction() {
		return yearOfConstruction;
	}
	
	public void setYearOfConstruction(Date yearOfConstruction) {
		this.yearOfConstruction = yearOfConstruction;
	}
	
	public boolean isSetYearOfDemolition() {
		return yearOfDemolition != null;
	}
	
	public Date getYearOfDemolition() {
		return yearOfDemolition;
	}
	
	public void setYearOfDemolition(Date yearOfDemolition) {
		this.yearOfDemolition = yearOfDemolition;
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
