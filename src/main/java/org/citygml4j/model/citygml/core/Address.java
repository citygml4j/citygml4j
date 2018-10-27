/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.aggregates.MultiPointProperty;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class Address extends AbstractFeature implements CoreModuleComponent {
	private XalAddressProperty xalAddress;
	private MultiPointProperty multiPoint;
	private List<ADEComponent> ade;
	private CoreModule module;
	
	public Address() {
		
	}
	
	public Address(CoreModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfAddress(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfAddress() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public MultiPointProperty getMultiPoint() {
		return multiPoint;
	}

	public XalAddressProperty getXalAddress() {
		return xalAddress;
	}

	public boolean isSetGenericApplicationPropertyOfAddress() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetMultiPoint() {
		return multiPoint != null;
	}

	public boolean isSetXalAddress() {
		return xalAddress != null;
	}

	public void setGenericApplicationPropertyOfAddress(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setMultiPoint(MultiPointProperty multiPoint) {
		if (multiPoint != null)
			multiPoint.setParent(this);
		
		this.multiPoint = multiPoint;
	}

	public void setXalAddress(XalAddressProperty xalAddress) {
		if (xalAddress != null)
			xalAddress.setParent(this);
		
		this.xalAddress = xalAddress;
	}

	public void unsetGenericApplicationPropertyOfAddress() {
		if (isSetGenericApplicationPropertyOfAddress())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfAddress(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfAddress() ? this.ade.remove(ade) : false;
	}

	public void unsetMultiPoint() {
		if (isSetMultiPoint())
			multiPoint.unsetParent();
		
		multiPoint = null;
	}

	public void unsetXalAddress() {
		if (isSetXalAddress())
			xalAddress.unsetParent();
		
		xalAddress = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ADDRESS;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}
	
	public final CoreModule getCityGMLModule() {
		return module;
	}
	
	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		if (multiPoint != null && multiPoint.isSetMultiPoint())
			boundedBy.updateEnvelope(getMultiPoint().getGeometry().calcBoundingBox());
		
		if (isSetGenericApplicationPropertyOfAddress()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfAddress()) {
				if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, this, options).getEnvelope());
			}
		}
		
		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Address(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Address copy = (target == null) ? new Address() : (Address)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetXalAddress()) {
			copy.setXalAddress((XalAddressProperty)copyBuilder.copy(xalAddress));
			if (copy.getXalAddress() == xalAddress)
				xalAddress.setParent(this);
		}
		
		if (isSetMultiPoint()) {
			copy.setMultiPoint((MultiPointProperty)copyBuilder.copy(multiPoint));
			if (copy.getMultiPoint() == multiPoint)
				multiPoint.setParent(this);
		}
		
		if (isSetGenericApplicationPropertyOfAddress()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfAddress(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
	
	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
