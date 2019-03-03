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
package org.citygml4j.model.citygml.cityobjectgroup;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.core.StandardObjectClassifier;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class CityObjectGroup extends AbstractCityObject implements CityObjectGroupModuleComponent, StandardObjectClassifier {
	private Code clazz;
	private List<Code> function;
	private List<Code> usage;
	private List<CityObjectGroupMember> groupMember;
	private CityObjectGroupParent groupParent;
	private GeometryProperty<? extends AbstractGeometry> geometry;
	private List<ADEComponent> ade;

	public CityObjectGroup() {
		
	}
	
	public CityObjectGroup(Module module) {
		super(module);
	}
	
	public void addFunction(Code function) {
		getFunction().add(function);
	}
	
	public void addUsage(Code usage) {
		getUsage().add(usage);
	}

	public void addGenericApplicationPropertyOfCityObjectGroup(ADEComponent ade) {
		getGenericApplicationPropertyOfCityObjectGroup().add(ade);
	}

	public void addGroupMember(CityObjectGroupMember groupMember) {
		getGroupMember().add(groupMember);
	}

	public Code getClazz() {
		return clazz;
	}

	public List<Code> getFunction() {
		if (function == null)
			function = new ChildList<>(this);

		return function;
	}
	
	public List<Code> getUsage() {
		if (usage == null)
			usage = new ChildList<>(this);

		return usage;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfCityObjectGroup() {
		if (ade == null)
			ade = new ChildList<>(this);

		return ade;
	}

	public GeometryProperty<? extends AbstractGeometry> getGeometry() {
		return geometry;
	}

	public List<CityObjectGroupMember> getGroupMember() {
		if (groupMember == null)
			groupMember = new ChildList<>(this);

		return groupMember;
	}

	public CityObjectGroupParent getGroupParent() {
		return groupParent;
	}

	public boolean isSetClazz() {
		return clazz != null;
	}

	public boolean isSetFunction() {
		return function != null && !function.isEmpty();
	}
	
	public boolean isSetUsage() {
		return usage != null && !usage.isEmpty();
	}

	public boolean isSetGenericApplicationPropertyOfCityObjectGroup() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetGeometry() {
		return geometry != null;
	}

	public boolean isSetGroupMember() {
		return groupMember != null && !groupMember.isEmpty();
	}

	public boolean isSetGroupParent() {
		return groupParent != null;
	}

	public void setClazz(Code clazz) {
		this.clazz = ModelObjects.setParent(clazz, this);
	}

	public void setFunction(List<Code> function) {
		this.function = new ChildList<>(this, function);
	}
	
	public void setUsage(List<Code> usage) {
		this.usage = new ChildList<>(this, usage);
	}

	public void setGenericApplicationPropertyOfCityObjectGroup(List<ADEComponent> ade) {
		this.ade = new ChildList<>(this, ade);
	}

	public void setGeometry(GeometryProperty<? extends AbstractGeometry> geometry) {
		this.geometry = ModelObjects.setParent(geometry, this);
	}

	public void setGroupMember(List<CityObjectGroupMember> groupMember) {
		this.groupMember = new ChildList<>(this, groupMember);
	}

	public void setGroupParent(CityObjectGroupParent groupParent) {
		this.groupParent = ModelObjects.setParent(groupParent, this);
	}

	public void unsetClazz() {
		clazz = ModelObjects.setNull(clazz);
	}

	public void unsetFunction() {
		function = ModelObjects.setNull(function);
	}

	public boolean unsetFunction(Code function) {
		return isSetFunction() && this.function.remove(function);
	}
	
	public void unsetUsage() {
		usage = ModelObjects.setNull(usage);
	}

	public boolean unsetUsage(Code usage) {
		return isSetUsage() && this.usage.remove(usage);
	}

	public void unsetGenericApplicationPropertyOfCityObjectGroup() {
		ade = ModelObjects.setNull(ade);
	}

	public boolean unsetGenericApplicationPropertyOfCityObjectGroup(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfCityObjectGroup() && this.ade.remove(ade);
	}

	public void unsetGeometry() {
		geometry = ModelObjects.setNull(geometry);
	}

	public void unsetGroupMember() {
		groupMember = ModelObjects.setNull(groupMember);
	}

	public boolean unsetGroupMember(CityObjectGroupMember groupMember) {
		return isSetGroupMember() && this.groupMember.remove(groupMember);
	}

	public void unsetGroupParent() {
		groupParent = ModelObjects.setNull(groupParent);
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITY_OBJECT_GROUP;
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		if (isSetGeometry()) {
			if (geometry.isSetGeometry()) {
				boundedBy.updateEnvelope(geometry.getGeometry().calcBoundingBox());
			} else {
				// xlink
			}
		}
		
		if (isSetGroupMember()) {
			for (CityObjectGroupMember member : groupMember) {
				if (member.isSetObject()) {
					boundedBy.updateEnvelope(member.getObject().calcBoundedBy(options).getEnvelope());
				} else {
					// xlink
				}					
			}
		}
		
		if (isSetGenericApplicationPropertyOfCityObjectGroup()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfCityObjectGroup()) {
				if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, this, options).getEnvelope());
			}
		}
		
		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}
	
	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();
		lodRepresentation.addRepresentation(geometry);

		return lodRepresentation;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CityObjectGroup(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CityObjectGroup copy = (target == null) ? new CityObjectGroup() : (CityObjectGroup)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetClazz())
			copy.setClazz((Code)copyBuilder.copy(clazz));

		if (isSetFunction()) {
			for (Code part : function) {
				Code copyPart = (Code)copyBuilder.copy(part);
				copy.addFunction(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetUsage()) {
			for (Code part : usage) {
				Code copyPart = (Code)copyBuilder.copy(part);
				copy.addUsage(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGroupMember()) {
			for (CityObjectGroupMember part : groupMember) {
				CityObjectGroupMember copyPart = (CityObjectGroupMember)copyBuilder.copy(part);
				copy.addGroupMember(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGroupParent()) {
			copy.setGroupParent((CityObjectGroupParent)copyBuilder.copy(groupParent));
			if (copy.getGroupParent() == groupParent)
				groupParent.setParent(this);
		}
		
		if (isSetGeometry()) {
			copy.setGeometry((GeometryProperty<? extends AbstractGeometry>)copyBuilder.copy(geometry));
			if (copy.getGeometry() == geometry)
				geometry.setParent(this);
		}
		
		if (isSetGenericApplicationPropertyOfCityObjectGroup()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfCityObjectGroup(copyPart);
				
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
