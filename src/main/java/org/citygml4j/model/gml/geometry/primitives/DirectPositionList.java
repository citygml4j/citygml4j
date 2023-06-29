/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.CoordinateListProvider;
import org.citygml4j.model.gml.geometry.SRSReferenceGroup;

import java.util.ArrayList;
import java.util.List;

public class DirectPositionList implements SRSReferenceGroup, Child, Copyable, CoordinateListProvider {
	private List<Double> value;
	private Integer count;
	private Integer srsDimension;
	private String srsName;
	private List<String> axisLabels;
	private List<String> uomLabels;
	private ModelObject parent;
	
	public GMLClass getGMLClass() {
		return GMLClass.DIRECT_POSITION_LIST;
	}

	public void addValue(Double value) {
		getValue().add(value);
	}

	public void addValue(List<Double> value) {
		getValue().addAll(value);
	}

	public Integer getCount() {
		return count;
	}

	public List<Double> getValue() {
		if (value == null)
			value = new ArrayList<>();
		
		return value;
	}

	public boolean isSetCount() {
		return count != null;
	}

	public boolean isSetValue() {
		return value != null && !value.isEmpty();
	}

	public void setCount(Integer count) {
		if (count > 0)
			this.count = count;
	}

	public void setValue(List<Double> value) {
		this.value = value;
	}

	@Override
	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<>();

		if (isSetValue()) {
			tmp.addAll(value);

			int dim = (isSetSrsDimension() && srsDimension == 2) ? 2 : 3;
			while (tmp.size() % dim != 0)
				tmp.add(0.0);

			if (dim == 2) {
				List<Double> points = new ArrayList<>();

				for (int i = 0; i < tmp.size(); i += 2) {
					points.addAll(tmp.subList(i, i + 2));
					points.add(0.0);
				}

				tmp = points;
			}
		}

		return tmp;
	}

	public void unsetCount() {
		count = null;
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
		getAxisLabels().add(axisLabel);
	}

	public void addUomLabel(String uomLabel) {
		getUomLabels().add(uomLabel);
	}

	public List<String> getAxisLabels() {
		if (axisLabels == null)
			axisLabels = new ArrayList<>();

		return axisLabels;
	}

	public List<String> getUomLabels() {
		if (uomLabels == null)
			uomLabels = new ArrayList<>();

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
		return isSetAxisLabels() && axisLabels.remove(axisLabel);
	}

	public void unsetUomLabels() {
		uomLabels = null;
	}

	public boolean unsetUomLabels(String uomLabel) {
		return isSetUomLabels() && uomLabels.remove(uomLabel);
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DirectPositionList copy = (target == null) ? new DirectPositionList() : (DirectPositionList)target;
		
		if (isSetValue())
			copy.setValue((List<Double>)copyBuilder.copy(value));
		
		if (isSetCount())
			copy.setCount((Integer)copyBuilder.copy(count));
		
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
		return copyTo(new DirectPositionList(), copyBuilder);
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

}
