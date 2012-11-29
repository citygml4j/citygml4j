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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.xal;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public class ThoroughfareNumberRange implements XAL, GrPostal, Child, Copyable {
	private List<AddressLine> addressLine;
	private ThoroughfareNumberFrom thoroughfareNumberFrom;
	private ThoroughfareNumberTo thoroughfareNumberTo;
	private String rangeType;
	private String indicator;
	private String separator;
	private String indicatorOccurrence;
	private String numberRangeOccurrence;
	private String type;
	private String code;
	private ModelObject parent;
	
	public void addAddressLine(AddressLine addressLine) {
		if (this.addressLine == null)
			this.addressLine = new ChildList<AddressLine>(this);

		this.addressLine.add(addressLine);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<AddressLine>(this);

		return addressLine;
	}

	public String getIndicator() {
		return indicator;
	}

	public String getIndicatorOccurrence() {
		return indicatorOccurrence;
	}

	public String getNumberRangeOccurrence() {
		return numberRangeOccurrence;
	}

	public String getRangeType() {
		return rangeType;
	}

	public String getSeparator() {
		return separator;
	}

	public ThoroughfareNumberFrom getThoroughfareNumberFrom() {
		return thoroughfareNumberFrom;
	}

	public ThoroughfareNumberTo getThoroughfareNumberTo() {
		return thoroughfareNumberTo;
	}

	public String getType() {
		return type;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetIndicator() {
		return indicator != null;
	}

	public boolean isSetIndicatorOccurrence() {
		return indicatorOccurrence != null;
	}

	public boolean isSetNumberRangeOccurrence() {
		return numberRangeOccurrence != null;
	}

	public boolean isSetRangeType() {
		return rangeType != null;
	}

	public boolean isSetSeparator() {
		return separator != null;
	}

	public boolean isSetThoroughfareNumberFrom() {
		return thoroughfareNumberFrom != null;
	}

	public boolean isSetThoroughfareNumberTo() {
		return thoroughfareNumberTo != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<AddressLine>(this, addressLine);
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Before") || indicatorOccurrence.equals("After"))
			this.indicatorOccurrence = indicatorOccurrence;
	}

	public void setNumberRangeOccurrence(String numberRangeOccurrence) {
		if (numberRangeOccurrence.equals("BeforeName") || numberRangeOccurrence.equals("AfterName") ||
				numberRangeOccurrence.equals("BeforeType") || numberRangeOccurrence.equals("AfterType"))
			this.numberRangeOccurrence = numberRangeOccurrence;
	}

	public void setRangeType(String rangeType) {
		if (rangeType.equals("Odd") || rangeType.equals("Even"))
			this.rangeType = rangeType;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public void setThoroughfareNumberFrom(ThoroughfareNumberFrom thoroughfareNumberFrom) {
		if (thoroughfareNumberFrom != null)
			thoroughfareNumberFrom.setParent(this);
		
		this.thoroughfareNumberFrom = thoroughfareNumberFrom;
	}

	public void setThoroughfareNumberTo(ThoroughfareNumberTo thoroughfareNumberTo) {
		if (thoroughfareNumberTo != null)
			thoroughfareNumberTo.setParent(this);
		
		this.thoroughfareNumberTo = thoroughfareNumberTo;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void unsetAddressLine() {
		if (isSetAddressLine())
			addressLine.clear();
		
		addressLine = null;
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		return isSetAddressLine() ? this.addressLine.remove(addressLine) : false;
	}

	public void unsetIndicator() {
		indicator = null;
	}

	public void unsetIndicatorOccurrence() {
		indicatorOccurrence = null;
	}

	public void unsetNumberRangeOccurrence() {
		numberRangeOccurrence = null;
	}

	public void unsetRangeType() {
		rangeType = null;
	}

	public void unsetSeparator() {
		separator = null;
	}

	public void unsetThoroughfareNumberFrom() {
		if (isSetThoroughfareNumberFrom())
			thoroughfareNumberFrom.unsetParent();
		
		thoroughfareNumberFrom = null;
	}

	public void unsetThoroughfareNumberTo() {
		if (isSetThoroughfareNumberTo())
			thoroughfareNumberTo.unsetParent();
		
		thoroughfareNumberTo = null;
	}

	public void unsetType() {
		type = null;
	}

	public ModelType getModelType() {
		return ModelType.XAL;
	}

	public XALClass getXALClass() {
		return XALClass.THOROUGHFARE_NUMBER_RANGE;
	}

	public String getCode() {
		return code;
	}

	public boolean isSetCode() {
		return code != null;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void unsetCode() {
		code = null;
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

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ThoroughfareNumberRange(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ThoroughfareNumberRange copy = (target == null) ? new ThoroughfareNumberRange() : (ThoroughfareNumberRange)target;
		
		if (isSetAddressLine()) {
			for (AddressLine part : addressLine) {
				AddressLine copyPart = (AddressLine)copyBuilder.copy(part);
				copy.addAddressLine(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetThoroughfareNumberFrom()) {
			copy.setThoroughfareNumberFrom((ThoroughfareNumberFrom)copyBuilder.copy(thoroughfareNumberFrom));
			if (copy.getThoroughfareNumberFrom() == thoroughfareNumberFrom)
				thoroughfareNumberFrom.setParent(this);
		}
		
		if (isSetThoroughfareNumberTo()) {
			copy.setThoroughfareNumberTo((ThoroughfareNumberTo)copyBuilder.copy(thoroughfareNumberTo));
			if (copy.getThoroughfareNumberTo() == thoroughfareNumberTo)
				thoroughfareNumberTo.setParent(this);
		}
		
		if (isSetRangeType())
			copy.setRangeType(copyBuilder.copy(rangeType));
		
		if (isSetIndicator())
			copy.setIndicator(copyBuilder.copy(indicator));
		
		if (isSetSeparator())
			copy.setSeparator(copyBuilder.copy(separator));
		
		if (isSetIndicatorOccurrence())
			copy.setIndicatorOccurrence(copyBuilder.copy(indicatorOccurrence));
		
		if (isSetNumberRangeOccurrence())
			copy.setNumberRangeOccurrence(copyBuilder.copy(numberRangeOccurrence));
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));
		
		if (isSetCode())
			copy.setCode(copyBuilder.copy(code));		
		
		copy.unsetParent();
		
		return copy;
	}
	
	public void visit(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T visit(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
