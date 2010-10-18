/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 */
package org.citygml4j.impl.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;
import org.citygml4j.model.xal.ThoroughfareNumber;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfareNumberImpl implements ThoroughfareNumber {
	private String content;
	private String numberType;
	private String type;
	private String indicator;
	private String indicatorOccurrence;
	private String numberOccurrence;
	private String code;
	private ModelObject parent;
	
	public String getContent() {
		return content;
	}

	public String getIndicator() {
		return indicator;
	}

	public String getIndicatorOccurrence() {
		return indicatorOccurrence;
	}

	public String getNumberOccurrence() {
		return numberOccurrence;
	}

	public String getNumberType() {
		return numberType;
	}

	public String getType() {
		return type;
	}

	public boolean isSetContent() {
		return content != null;
	}

	public boolean isSetIndicator() {
		return indicator != null;
	}

	public boolean isSetIndicatorOccurrence() {
		return indicatorOccurrence != null;
	}

	public boolean isSetNumberOccurrence() {
		return numberOccurrence != null;
	}

	public boolean isSetNumberType() {
		return numberType != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Before") || indicatorOccurrence.equals("After"))
			this.indicatorOccurrence = indicatorOccurrence;
	}

	public void setNumberOccurrence(String numberOccurrence) {
		if (numberOccurrence.equals("BeforeName") || numberOccurrence.equals("AfterName") ||
				numberOccurrence.equals("BeforeType") || numberOccurrence.equals("AfterType"))
			this.numberOccurrence = numberOccurrence;
	}

	public void setNumberType(String numberType) {
		if (numberType.equals("Single") || numberType.equals("Range"))
			this.numberType = numberType;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void unsetContent() {
		content = null;
	}

	public void unsetIndicator() {
		indicator = null;
	}

	public void unsetIndicatorOccurrence() {
		indicatorOccurrence = null;
	}

	public void unsetNumberOccurrence() {
		numberOccurrence = null;
	}

	public void unsetNumberType() {
		numberType = null;
	}

	public void unsetType() {
		type = null;
	}

	public ModelType getModelType() {
		return ModelType.XAL;
	}

	public XALClass getXALClass() {
		return XALClass.THOROUGHFARE_NUMBER;
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
		return copyTo(new ThoroughfareNumberImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ThoroughfareNumber copy = (target == null) ? new ThoroughfareNumberImpl() : (ThoroughfareNumber)target;
		
		if (isSetContent())
			copy.setContent(copyBuilder.copy(content));
		
		if (isSetNumberType())
			copy.setNumberType(copyBuilder.copy(numberType));
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));
		
		if (isSetIndicator())
			copy.setIndicator(copyBuilder.copy(indicator));
		
		if (isSetIndicatorOccurrence())
			copy.setIndicatorOccurrence(copyBuilder.copy(indicatorOccurrence));
		
		if (isSetNumberOccurrence())
			copy.setNumberOccurrence(copyBuilder.copy(numberOccurrence));
		
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
