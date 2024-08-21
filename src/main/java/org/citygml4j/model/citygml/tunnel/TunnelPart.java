/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.citygml.tunnel;

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
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class TunnelPart extends AbstractTunnel {
	private List<ADEComponent> ade;

	public TunnelPart() {
		
	}
	
	public TunnelPart(Module module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfTunnelPart(ADEComponent ade) {
		getGenericApplicationPropertyOfTunnelPart().add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfTunnelPart() {
		if (ade == null)
			ade = new ChildList<>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfTunnelPart() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfTunnelPart(List<ADEComponent> ade) {
		this.ade = new ChildList<>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfTunnelPart() {
		ade = ModelObjects.setNull(ade);
	}

	public boolean unsetGenericApplicationPropertyOfTunnelPart(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTunnelPart() && this.ade.remove(ade);
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TUNNEL_PART;
	}
	
	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		if (isSetGenericApplicationPropertyOfTunnelPart()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfTunnelPart()) {
				if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, options).getEnvelope());
			}
		}
		
		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TunnelPart(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TunnelPart copy = (target == null) ? new TunnelPart() : (TunnelPart)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfTunnelPart()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTunnelPart(copyPart);

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
