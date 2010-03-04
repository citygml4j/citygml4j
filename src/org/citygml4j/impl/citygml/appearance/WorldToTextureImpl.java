package org.citygml4j.impl.citygml.appearance;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.impl.citygml.core.TransformationMatrix3x4Impl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.WorldToTexture;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class WorldToTextureImpl extends TransformationMatrix3x4Impl implements WorldToTexture {
	private Integer srsDimension;
	private String srsName;
	private List<String> axisLabels;
	private List<String> uomLabels;
	private AppearanceModule module;
	
	public WorldToTextureImpl() {

	}
	
	public WorldToTextureImpl(AppearanceModule module) {
		this.module = module;
	}

	public WorldToTextureImpl(Matrix matrix) {
		super(matrix);
	}
	
	public WorldToTextureImpl(List<Double> vals) {
		super(vals);
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WORLDTOTEXTURE;
	}

	@Override
	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	@Override
	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Integer getSrsDimension() {
		return srsDimension;
	}

	public String getSrsName() {
		return srsName;
	}

	public boolean isSetSrsDimension() {
		return srsDimension != null;
	}

	public boolean isSetSrsName() {
		return srsName != null;
	}

	public void setSrsDimension(Integer srsDimension) {
		if (srsDimension > 0)
			this.srsDimension = srsDimension;
	}

	public void setSrsName(String srsName) {
		this.srsName = srsName;
	}

	public void unsetSrsDimension() {
		srsDimension = null;
	}

	public void unsetSrsName() {
		srsName = null;
	}

	public void addAxisLabel(String axisLabel) {
		if (axisLabels == null)
			axisLabels = new ArrayList<String>();
		
		axisLabels.add(axisLabel);
	}

	public void addUomLabel(String uomLabel) {
		if (uomLabels == null)
			uomLabels = new ArrayList<String>();
		
		uomLabels.add(uomLabel);
	}

	public List<String> getAxisLabels() {
		if (axisLabels == null)
			axisLabels = new ArrayList<String>();

		return axisLabels;
	}

	public List<String> getUomLabels() {
		if (uomLabels == null)
			uomLabels = new ArrayList<String>();

		return uomLabels;
	}

	public boolean isSetAxisLabels() {
		return axisLabels != null && !axisLabels.isEmpty();
	}

	public boolean isSetUomLabels() {
		return uomLabels != null && !uomLabels.isEmpty();
	}

	public void setAxisLabels(List<String> axisLabels) {
		this.axisLabels = axisLabels;
	}

	public void setUomLabels(List<String> uomLabels) {
		this.uomLabels = uomLabels;
	}

	public void unsetAxisLabels() {
		axisLabels = null;
	}

	public boolean unsetAxisLabels(String axisLabel) {
		return isSetAxisLabels() ? axisLabels.remove(axisLabel) : false;
	}

	public void unsetUomLabels() {
		uomLabels = null;
	}

	public boolean unsetUomLabels(String uomLabel) {
		return isSetUomLabels() ? uomLabels.remove(uomLabel) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.CITYGMLCLASS;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new WorldToTextureImpl(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		WorldToTexture copy = (target == null) ? new WorldToTextureImpl() : (WorldToTexture)target;
		super.copyTo(copy, copyBuilder);

		if (isSetSrsDimension())
        	copy.setSrsDimension((Integer)copyBuilder.copy(srsDimension));
        
        if (isSetSrsName())
        	copy.setSrsName(copyBuilder.copy(srsName));
        
        if (isSetAxisLabels())
        	copy.setAxisLabels((List<String>)copyBuilder.copy(axisLabels));
        
        if (isSetUomLabels())
        	copy.setUomLabels((List<String>)copyBuilder.copy(uomLabels));
		
		return copy;
	}

}
