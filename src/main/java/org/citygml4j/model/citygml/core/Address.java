/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.feature.SpatialRepresentation;
import org.citygml4j.model.gml.geometry.aggregates.MultiPointProperty;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class Address extends AbstractFeature implements CoreModuleComponent {
	private XalAddressProperty xalAddress;
	private MultiPointProperty multiPoint;
	private List<ADEComponent> ade;

	public Address() {
		
	}
	
	public Address(Module module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfAddress(ADEComponent ade) {
		getGenericApplicationPropertyOfAddress().add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfAddress() {
		if (ade == null)
			ade = new ChildList<>(this);

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
		this.ade = new ChildList<>(this, ade);
	}

	public void setMultiPoint(MultiPointProperty multiPoint) {
		this.multiPoint = ModelObjects.setParent(multiPoint, this);
	}

	public void setXalAddress(XalAddressProperty xalAddress) {
		this.xalAddress = ModelObjects.setParent(xalAddress, this);
	}

	public void unsetGenericApplicationPropertyOfAddress() {
		ade = ModelObjects.setNull(ade);
	}

	public boolean unsetGenericApplicationPropertyOfAddress(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfAddress() && this.ade.remove(ade);
	}

	public void unsetMultiPoint() {
		multiPoint = ModelObjects.setNull(multiPoint);
	}

	public void unsetXalAddress() {
		xalAddress = ModelObjects.setNull(xalAddress);
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ADDRESS;
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

	@Override
	public SpatialRepresentation getSpatialRepresentation() {
		SpatialRepresentation representation = new SpatialRepresentation();
		representation.addRepresentation(multiPoint);

		return representation;
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
