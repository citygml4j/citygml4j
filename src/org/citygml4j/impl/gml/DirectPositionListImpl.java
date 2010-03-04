package org.citygml4j.impl.gml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.DirectPositionList;
import org.citygml4j.model.gml.GMLClass;

public class DirectPositionListImpl implements DirectPositionList {
	private List<Double> value;
	private Integer count;
	private Integer srsDimension;
	private String srsName;
	private List<String> axisLabels;
	private List<String> uomLabels;
	private Object parent;
	
	public GMLClass getGMLClass() {
		return GMLClass.DIRECTPOSITIONLIST;
	}

	public void addValue(Double value) {
		if (this.value == null)
			this.value = new ArrayList<Double>();
		
		this.value.add(value);
	}

	public void addValue(List<Double> value) {
		if (this.value == null)
			this.value = new ArrayList<Double>();
		
		this.value.addAll(value);
	}

	public Integer getCount() {
		return count;
	}

	public List<Double> getValue() {
		if (value == null)
			value = new ArrayList<Double>();
		
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
	
	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<Double>();

		if (isSetValue()) {
			tmp.addAll(value);

			int dim = (isSetSrsDimension() && srsDimension == 2) ? 2 : 3;
			while (tmp.size() % dim != 0)
				tmp.add(0.0);

			if (dim == 2) {
				List<Double> points = new ArrayList<Double>();

				for (int i = 0; i < tmp.size(); i += 2) {
					points.addAll(tmp.subList(i, i + 2));
					points.add(0.0);
				}

				tmp = points;
			}
		}

		return tmp;
	}

	public List<Double> toList3d(boolean reverseOrder) {
		List<Double> tmp = toList3d();

		if (reverseOrder) {
			List<Double> reversed = new ArrayList<Double>();

			for (int i = tmp.size() - 3; i >= 0; i -=3)
				reversed.addAll(tmp.subList(i, i + 3));

			tmp = reversed;
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

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DirectPositionList copy = (target == null) ? new DirectPositionListImpl() : (DirectPositionList)target;
		
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
		return copyTo(new DirectPositionListImpl(), copyBuilder);
	}
	
	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

}
