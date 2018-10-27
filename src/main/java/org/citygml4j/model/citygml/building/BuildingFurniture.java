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
package org.citygml4j.model.citygml.building;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.core.StandardObjectClassifier;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class BuildingFurniture extends AbstractCityObject implements BuildingModuleComponent, StandardObjectClassifier {
	private Code clazz;
	private List<Code> function;
	private List<Code> usage;
	private GeometryProperty<? extends AbstractGeometry> lod4Geometry;
	private ImplicitRepresentationProperty lod4ImplicitRepresentation;
	private List<ADEComponent> ade;
	private BuildingModule module;

	public BuildingFurniture() {
		
	}
	
	public BuildingFurniture(BuildingModule module) {
		this.module = module;
	}
	
	public void addFunction(Code function) {
		if (this.function == null)
			this.function = new ChildList<Code>(this);

		this.function.add(function);
	}
	
	public void addUsage(Code function) {
		if (this.usage == null)
			this.usage = new ChildList<Code>(this);

		this.usage.add(function);
	}

	public void addGenericApplicationPropertyOfBuildingFurniture(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public Code getClazz() {
		return clazz;
	}

	public List<Code> getFunction() {
		if (function == null)
			function = new ChildList<Code>(this);

		return function;
	}
	
	public List<Code> getUsage() {
		if (usage == null)
			usage = new ChildList<Code>(this);

		return usage;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfBuildingFurniture() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public ImplicitRepresentationProperty getLod4ImplicitRepresentation() {
		return lod4ImplicitRepresentation;
	}

	public GeometryProperty<? extends AbstractGeometry> getLod4Geometry() {
		return lod4Geometry;
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

	public boolean isSetGenericApplicationPropertyOfBuildingFurniture() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod4ImplicitRepresentation() {
		return lod4ImplicitRepresentation != null;
	}

	public boolean isSetLod4Geometry() {
		return lod4Geometry != null;
	}

	public void setClazz(Code clazz) {
		this.clazz = clazz;
	}

	public void setFunction(List<Code> function) {
		this.function = new ChildList<Code>(this, function);
	}
	
	public void setUsage(List<Code> usage) {
		this.usage = new ChildList<Code>(this, usage);
	}

	public void setGenericApplicationPropertyOfBuildingFurniture(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setLod4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation) {
		if (lod4ImplicitRepresentation != null)
			lod4ImplicitRepresentation.setParent(this);
		
		this.lod4ImplicitRepresentation = lod4ImplicitRepresentation;
	}

	public void setLod4Geometry(GeometryProperty<? extends AbstractGeometry> lod4Geometry) {
		if (lod4Geometry != null)
			lod4Geometry.setParent(this);
		
		this.lod4Geometry = lod4Geometry;
	}

	public void unsetClazz() {
		clazz = null;
	}

	public void unsetFunction() {
		function = null;
	}

	public boolean unsetFunction(Code function) {
		return isSetFunction() ? this.function.remove(function) : false;
	}
	
	public void unsetUsage() {
		usage = null;
	}

	public boolean unsetUsage(Code usage) {
		return isSetUsage() ? this.usage.remove(usage) : false;
	}

	public void unsetGenericApplicationPropertyOfBuildingFurniture() {
		if (isSetGenericApplicationPropertyOfBuildingFurniture())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfBuildingFurniture(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfBuildingFurniture() ? this.ade.remove(ade) : false;
	}

	public void unsetLod4ImplicitRepresentation() {
		if (isSetLod4ImplicitRepresentation())
			lod4ImplicitRepresentation.unsetParent();
		
		lod4ImplicitRepresentation = null;
	}

	public void unsetLod4Geometry() {
		if (isSetLod4Geometry())
			lod4Geometry.unsetParent();
		
		lod4Geometry = null;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BUILDING_FURNITURE;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		if (isSetLod4Geometry()) {
			if (lod4Geometry.isSetGeometry()) {
				boundedBy.updateEnvelope(lod4Geometry.getGeometry().calcBoundingBox());	
			} else {
				// xlink
			}
		}	
		
		if (isSetLod4ImplicitRepresentation() && lod4ImplicitRepresentation.isSetImplicitGeometry())
			boundedBy.updateEnvelope(lod4ImplicitRepresentation.getImplicitGeometry().calcBoundingBox(options));
		
		if (isSetGenericApplicationPropertyOfBuildingFurniture()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfBuildingFurniture()) {
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
		
		if (lod4Geometry != null)
			lodRepresentation.addRepresentation(4, lod4Geometry);
		
		if (lod4ImplicitRepresentation != null)
			lodRepresentation.addRepresentation(4, lod4ImplicitRepresentation);
		
		return lodRepresentation;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingFurniture(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BuildingFurniture copy = (target == null) ? new BuildingFurniture() : (BuildingFurniture)target;
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
		
		if (isSetLod4ImplicitRepresentation()) {
			copy.setLod4ImplicitRepresentation((ImplicitRepresentationProperty)copyBuilder.copy(lod4ImplicitRepresentation));
			if (copy.getLod4ImplicitRepresentation() == lod4ImplicitRepresentation)
				lod4ImplicitRepresentation.setParent(this);
		}
		
		if (isSetLod4Geometry()) {
			copy.setLod4Geometry((GeometryProperty<? extends AbstractGeometry>)copyBuilder.copy(lod4Geometry));
			if (copy.getLod4Geometry() == lod4Geometry)
				lod4Geometry.setParent(this);
		}
		
		if (isSetGenericApplicationPropertyOfBuildingFurniture()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfBuildingFurniture(copyPart);

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
