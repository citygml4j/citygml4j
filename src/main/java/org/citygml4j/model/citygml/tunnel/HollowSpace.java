/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class HollowSpace extends AbstractCityObject implements TunnelModuleComponent, StandardObjectClassifier {
	private Code clazz;
	private List<Code> function;
	private List<Code> usage;
	private List<BoundarySurfaceProperty> boundedBySurface;
	private List<InteriorFurnitureProperty> interiorFurniture;
	private List<IntTunnelInstallationProperty> hollowSpaceInstallation;
	private SolidProperty lod4Solid;
	private MultiSurfaceProperty lod4MultiSurface;
	private List<ADEComponent> ade;

	public HollowSpace() {
		
	}
	
	public HollowSpace(Module module) {
		super(module);
	}
	
	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		getBoundedBySurface().add(boundedBySurface);
	}

	public void addFunction(Code function) {
		getFunction().add(function);
	}
	
	public void addUsage(Code usage) {
		getUsage().add(usage);
	}

	public void addGenericApplicationPropertyOfHollowSpace(ADEComponent ade) {
		getGenericApplicationPropertyOfHollowSpace().add(ade);
	}

	public void addInteriorFurniture(InteriorFurnitureProperty interiorFurniture) {
		getInteriorFurniture().add(interiorFurniture);
	}

	public void addHollowSpaceInstallation(IntTunnelInstallationProperty hollowSpaceInstallation) {
		getHollowSpaceInstallation().add(hollowSpaceInstallation);
	}

	public List<BoundarySurfaceProperty> getBoundedBySurface() {
		if (boundedBySurface == null)
			boundedBySurface = new ChildList<>(this);

		return boundedBySurface;
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

	public List<ADEComponent> getGenericApplicationPropertyOfHollowSpace() {
		if (ade == null)
			ade = new ChildList<>(this);

		return ade;
	}

	public List<InteriorFurnitureProperty> getInteriorFurniture() {
		if (interiorFurniture == null)
			interiorFurniture = new ChildList<>(this);

		return interiorFurniture;
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		return lod4MultiSurface;
	}

	public SolidProperty getLod4Solid() {
		return lod4Solid;
	}

	public List<IntTunnelInstallationProperty> getHollowSpaceInstallation() {
		if (hollowSpaceInstallation == null)
			hollowSpaceInstallation = new ChildList<>(this);

		return hollowSpaceInstallation;
	}
	
	public boolean isSetBoundedBySurface() {
		return boundedBySurface != null && !boundedBySurface.isEmpty();
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

	public boolean isSetGenericApplicationPropertyOfHollowSpace() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetInteriorFurniture() {
		return interiorFurniture != null && !interiorFurniture.isEmpty();
	}

	public boolean isSetLod4MultiSurface() {
		return lod4MultiSurface != null;
	}

	public boolean isSetLod4Solid() {
		return lod4Solid != null;
	}

	public boolean isSetHollowSpaceInstallation() {
		return hollowSpaceInstallation != null && !hollowSpaceInstallation.isEmpty();
	}

	public void setBoundedBySurface(List<BoundarySurfaceProperty> boundedBySurface) {
		this.boundedBySurface = new ChildList<>(this, boundedBySurface);
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
	
	public void setGenericApplicationPropertyOfHollowSpace(List<ADEComponent> ade) {
		this.ade = new ChildList<>(this, ade);
	}

	public void setInteriorFurniture(List<InteriorFurnitureProperty> interiorFurniture) {
		this.interiorFurniture = new ChildList<>(this, interiorFurniture);
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		this.lod4MultiSurface = ModelObjects.setParent(lod4MultiSurface, this);
	}

	public void setLod4Solid(SolidProperty lod4Solid) {
		this.lod4Solid = ModelObjects.setParent(lod4Solid, this);
	}

	public void setHollowSpaceInstallation(List<IntTunnelInstallationProperty> hollowSpaceInstallation) {
		this.hollowSpaceInstallation = new ChildList<>(this, hollowSpaceInstallation);
	}

	public void unsetBoundedBySurface() {
		boundedBySurface = ModelObjects.setNull(boundedBySurface);
	}

	public boolean unsetBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		return isSetBoundedBySurface() && this.boundedBySurface.remove(boundedBySurface);
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

	public void unsetGenericApplicationPropertyOfHollowSpace() {
		ade = ModelObjects.setNull(ade);
	}

	public boolean unsetGenericApplicationPropertyOfHollowSpace(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfHollowSpace() && this.ade.remove(ade);
	}

	public void unsetInteriorFurniture() {
		interiorFurniture = ModelObjects.setNull(interiorFurniture);
	}

	public boolean unsetInteriorFurniture(InteriorFurnitureProperty interiorFurniture) {
		return isSetInteriorFurniture() && this.interiorFurniture.remove(interiorFurniture);
	}

	public void unsetLod4MultiSurface() {
		lod4MultiSurface = ModelObjects.setNull(lod4MultiSurface);
	}

	public void unsetLod4Solid() {
		lod4Solid = ModelObjects.setNull(lod4Solid);
	}

	public void unsetHollowSpaceInstallation() {
		hollowSpaceInstallation = ModelObjects.setNull(hollowSpaceInstallation);
	}

	public boolean unsetHollowSpaceInstallation(IntTunnelInstallationProperty hollowSpaceInstallation) {
		return isSetHollowSpaceInstallation() && this.hollowSpaceInstallation.remove(hollowSpaceInstallation);
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.HOLLOW_SPACE;
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		if (isSetLod4MultiSurface()) {
			if (lod4MultiSurface.isSetMultiSurface()) {
				boundedBy.updateEnvelope(lod4MultiSurface.getMultiSurface().calcBoundingBox());			
			} else {
				// xlink
			}
		}
		
		if (isSetLod4Solid()) {
			if (lod4Solid.isSetSolid()) {
				boundedBy.updateEnvelope(lod4Solid.getSolid().calcBoundingBox());			
			} else {
				// xlink
			}
		}
		
		if (isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : boundedBySurface) {
				if (boundarySurfaceProperty.isSetObject()) {
					boundedBy.updateEnvelope(boundarySurfaceProperty.getObject().calcBoundedBy(options).getEnvelope());
				} else {
					// xlink
				}
			}
		}
		
		if (isSetGenericApplicationPropertyOfHollowSpace()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfHollowSpace()) {
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
		
		lodRepresentation.addRepresentation(4, lod4MultiSurface);
		lodRepresentation.addRepresentation(4, lod4Solid);
		
		return lodRepresentation;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new HollowSpace(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		HollowSpace copy = (target == null) ? new HollowSpace() : (HollowSpace)target;
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
		
		if (isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty part : boundedBySurface) {
				BoundarySurfaceProperty copyPart = (BoundarySurfaceProperty)copyBuilder.copy(part);
				copy.addBoundedBySurface(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetInteriorFurniture()) {
			for (InteriorFurnitureProperty part : interiorFurniture) {
				InteriorFurnitureProperty copyPart = (InteriorFurnitureProperty)copyBuilder.copy(part);
				copy.addInteriorFurniture(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetHollowSpaceInstallation()) {
			for (IntTunnelInstallationProperty part : hollowSpaceInstallation) {
				IntTunnelInstallationProperty copyPart = (IntTunnelInstallationProperty)copyBuilder.copy(part);
				copy.addHollowSpaceInstallation(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetLod4MultiSurface()) {
			copy.setLod4MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod4MultiSurface));
			if (copy.getLod4MultiSurface() == lod4MultiSurface)
				lod4MultiSurface.setParent(this);
		}
		
		if (isSetLod4Solid()) {
			copy.setLod4Solid((SolidProperty)copyBuilder.copy(lod4Solid));
			if (copy.getLod4Solid() == lod4Solid)
				lod4Solid.setParent(this);
		}
		
		if (isSetGenericApplicationPropertyOfHollowSpace()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfHollowSpace(copyPart);

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
