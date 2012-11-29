/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id$
 */
package org.citygml4j.model.gml.geometry.primitives;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.SRSReferenceGroup;

public class Vector implements SRSReferenceGroup, Child, Copyable {
	private List<Double> value;
	private Integer srsDimension;
	private String srsName;
	private List<String> axisLabels;
	private List<String> uomLabels;
	private ModelObject parent;
	
	public Vector() {
		
	}
	
	public Vector(Matrix matrix) {
		if (matrix.getColumnDimension() > 1) 
			throw new IllegalArgumentException("Matrix column dimension must be 1.");
		
		value = matrix.toColumnPackedList();
	}
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.VECTOR;
	}
	
	public List<Double> getValue() {
		if (value == null)
			value = new ArrayList<Double>();

		return value;
	}

	public boolean isSetValue() {
		return value != null && !value.isEmpty();
	}

	public void addValue(Double value) {
		if (this.value == null)
			this.value = new ArrayList<Double>();
		
		this.value.add(value);
	}

	public void setValue(List<Double> value) {
		this.value = value;
	}

	public void unsetValue() {
		value = null;
	}

	public Integer getSrsDimension() {
		return srsDimension;
	}

	public String getSrsName() {
		return srsName;
	}
	
	public String getInheritedSrsName() {
		if (srsName == null) {
			Child child = this;
			ModelObject parent = null;

			while ((parent = child.getParent()) != null) {
				if (parent instanceof AbstractGeometry)
					return ((AbstractGeometry)parent).getInheritedSrsName();
				else if (parent instanceof AbstractFeature) {
					AbstractFeature feature = (AbstractFeature)parent;
					if (feature.isSetBoundedBy() 
							&& feature.getBoundedBy().isSetEnvelope()
							&& feature.getBoundedBy().getEnvelope().isSetSrsName())
						return feature.getBoundedBy().getEnvelope().getSrsName();
				}

				if (parent instanceof Child)
					child = (Child)parent;
				else 
					break;
			}
		} 

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

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Matrix toMatrix() {
		return (isSetValue()) ? new Matrix(value, value.size()) : null;
	}

	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<Double>();

		if (isSetValue()) {
			tmp.addAll(value);
			while (tmp.size() < 3)
				tmp.add(0.0);

			tmp = tmp.subList(0, 3);
		}

		return tmp;
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Vector copy = (target == null) ? new Vector() : (Vector)target;
		
		if (isSetValue())
			copy.setValue((List<Double>)copyBuilder.copy(value));
		
		if (isSetSrsDimension())
			copy.setSrsDimension((Integer)copyBuilder.copy(srsDimension));
		
		if (isSetSrsName())
        	copy.setSrsName(copyBuilder.copy(srsName));
        
        if (isSetAxisLabels())
        	copy.setAxisLabels((List<String>)copyBuilder.copy(axisLabels));
        
        if (isSetUomLabels())
        	copy.setUomLabels((List<String>)copyBuilder.copy(uomLabels));
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Vector(), copyBuilder);
	}

}
