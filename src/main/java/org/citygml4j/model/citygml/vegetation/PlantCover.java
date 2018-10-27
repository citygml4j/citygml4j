/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.citygml.vegetation;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
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
import org.citygml4j.model.gml.geometry.aggregates.MultiSolidProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.model.module.citygml.VegetationModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class PlantCover extends AbstractVegetationObject implements StandardObjectClassifier {
	private Code clazz;
	private List<Code> function;
	private List<Code> usage;
	private Length averageHeight;
	private MultiSurfaceProperty lod1MultiSurface;
	private MultiSurfaceProperty lod2MultiSurface;
	private MultiSurfaceProperty lod3MultiSurface;
	private MultiSurfaceProperty lod4MultiSurface;
	private MultiSolidProperty lod1MultiSolid;
	private MultiSolidProperty lod2MultiSolid;
	private MultiSolidProperty lod3MultiSolid;
	private MultiSolidProperty lod4MultiSolid;
	private List<ADEComponent> ade;

	public PlantCover() {

	}

	public PlantCover(VegetationModule module) {
		super(module);
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

	public void addGenericApplicationPropertyOfPlantCover(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public Length getAverageHeight() {
		return averageHeight;
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

	public List<ADEComponent> getGenericApplicationPropertyOfPlantCover() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public MultiSolidProperty getLod1MultiSolid() {
		return lod1MultiSolid;
	}

	public MultiSurfaceProperty getLod1MultiSurface() {
		return lod1MultiSurface;
	}

	public MultiSolidProperty getLod2MultiSolid() {
		return lod2MultiSolid;
	}

	public MultiSurfaceProperty getLod2MultiSurface() {
		return lod2MultiSurface;
	}

	public MultiSolidProperty getLod3MultiSolid() {
		return lod3MultiSolid;
	}

	public MultiSurfaceProperty getLod3MultiSurface() {
		return lod3MultiSurface;
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		return lod4MultiSurface;
	}
	
	public MultiSolidProperty getLod4MultiSolid() {
		return lod4MultiSolid;
	}

	public boolean isSetAverageHeight() {
		return averageHeight != null;
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

	public boolean isSetGenericApplicationPropertyOfPlantCover() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod1MultiSolid() {
		return lod1MultiSolid != null;
	}

	public boolean isSetLod1MultiSurface() {
		return lod1MultiSurface != null;
	}

	public boolean isSetLod2MultiSolid() {
		return lod2MultiSolid != null;
	}

	public boolean isSetLod2MultiSurface() {
		return lod2MultiSurface != null;
	}

	public boolean isSetLod3MultiSolid() {
		return lod3MultiSolid != null;
	}

	public boolean isSetLod3MultiSurface() {
		return lod3MultiSurface != null;
	}

	public boolean isSetLod4MultiSurface() {
		return lod4MultiSurface != null;
	}
	
	public boolean isSetLod4MultiSolid() {
		return lod4MultiSolid != null;
	}

	public void setAverageHeight(Length averageHeight) {
		if (averageHeight != null)
			averageHeight.setParent(this);

		this.averageHeight = averageHeight;
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

	public void setGenericApplicationPropertyOfPlantCover(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setLod1MultiSolid(MultiSolidProperty lod1MultiSolid) {
		if (lod1MultiSolid != null)
			lod1MultiSolid.setParent(this);

		this.lod1MultiSolid = lod1MultiSolid;
	}

	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		if (lod1MultiSurface != null)
			lod1MultiSurface.setParent(this);

		this.lod1MultiSurface = lod1MultiSurface;
	}

	public void setLod2MultiSolid(MultiSolidProperty lod2MultiSolid) {
		if (lod2MultiSolid != null)
			lod2MultiSolid.setParent(this);

		this.lod2MultiSolid = lod2MultiSolid;
	}

	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		if (lod2MultiSurface != null)
			lod2MultiSurface.setParent(this);

		this.lod2MultiSurface = lod2MultiSurface;
	}

	public void setLod3MultiSolid(MultiSolidProperty lod3MultiSolid) {
		if (lod3MultiSolid != null)
			lod3MultiSolid.setParent(this);

		this.lod3MultiSolid = lod3MultiSolid;
	}

	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		if (lod3MultiSurface != null)
			lod3MultiSurface.setParent(this);

		this.lod3MultiSurface = lod3MultiSurface;
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		if (lod4MultiSurface != null)
			lod4MultiSurface.setParent(this);

		this.lod4MultiSurface = lod4MultiSurface;
	}
	
	public void setLod4MultiSolid(MultiSolidProperty lod4MultiSolid) {
		if (lod4MultiSolid != null)
			lod4MultiSolid.setParent(this);

		this.lod3MultiSolid = lod4MultiSolid;
	}

	public void unsetAverageHeight() {
		if (isSetAverageHeight())
			averageHeight.unsetParent();

		averageHeight = null;
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

	public void unsetGenericApplicationPropertyOfPlantCover() {
		if (isSetGenericApplicationPropertyOfPlantCover())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfPlantCover(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfPlantCover() ? this.ade.remove(ade) : false;
	}

	public void unsetLod1MultiSolid() {
		if (isSetLod1MultiSolid())
			lod1MultiSolid.unsetParent();

		lod1MultiSolid = null;
	}

	public void unsetLod1MultiSurface() {
		if (isSetLod1MultiSurface())
			lod1MultiSurface.unsetParent();

		lod1MultiSurface = null;
	}

	public void unsetLod2MultiSolid() {
		if (isSetLod2MultiSolid())
			lod2MultiSolid.unsetParent();

		lod2MultiSolid = null;
	}

	public void unsetLod2MultiSurface() {
		if (isSetLod2MultiSurface())
			lod2MultiSurface.unsetParent();

		lod2MultiSurface = null;
	}

	public void unsetLod3MultiSolid() {
		if (isSetLod3MultiSolid())
			lod3MultiSolid.unsetParent();

		lod3MultiSolid = null;
	}

	public void unsetLod3MultiSurface() {
		if (isSetLod3MultiSurface())
			lod3MultiSurface.unsetParent();

		lod3MultiSurface = null;
	}

	public void unsetLod4MultiSurface() {
		if (isSetLod4MultiSurface())
			lod4MultiSurface.unsetParent();

		lod4MultiSurface = null;
	}
	
	public void unsetLod4MultiSolid() {
		if (isSetLod4MultiSolid())
			lod4MultiSolid.unsetParent();

		lod4MultiSolid = null;
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		MultiSolidProperty multiSolidProperty = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				multiSolidProperty = lod1MultiSolid;
				break;
			case 2:
				multiSolidProperty = lod2MultiSolid;
				break;
			case 3:
				multiSolidProperty = lod3MultiSolid;
				break;
			case 4:
				multiSolidProperty = lod4MultiSolid;
				break;
			}

			if (multiSolidProperty != null) {
				if (multiSolidProperty.isSetMultiSolid()) {
					boundedBy.updateEnvelope(multiSolidProperty.getMultiSolid().calcBoundingBox());
				} else {
					// xlink
				}
			}
		}

		MultiSurfaceProperty multiSurfaceProperty = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				multiSurfaceProperty = lod1MultiSurface;
				break;
			case 2:
				multiSurfaceProperty = lod2MultiSurface;
				break;
			case 3:
				multiSurfaceProperty = lod3MultiSurface;
				break;
			case 4:
				multiSurfaceProperty = lod4MultiSurface;
				break;
			}

			if (multiSurfaceProperty != null) {
				if (multiSurfaceProperty.isSetMultiSurface()) {
					boundedBy.updateEnvelope(multiSurfaceProperty.getMultiSurface().calcBoundingBox());
				} else {
					// xlink
				}
			}
		}
		
		if (isSetGenericApplicationPropertyOfPlantCover()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfPlantCover()) {
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
		
		GeometryProperty<? extends AbstractGeometry> property = null;		
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				property = lod1MultiSolid;
				break;
			case 2:
				property = lod2MultiSolid;
				break;
			case 3:
				property = lod3MultiSolid;
				break;
			case 4:
				property = lod4MultiSolid;
				break;
			}
			
			if (property != null)
				lodRepresentation.addRepresentation(lod, property);
		}
		
		property = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				property = lod1MultiSurface;
				break;
			case 2:
				property = lod2MultiSurface;
				break;
			case 3:
				property = lod3MultiSurface;
				break;
			case 4:
				property = lod4MultiSurface;
				break;
			}
			
			if (property != null)
				lodRepresentation.addRepresentation(lod, property);
		}
		
		return lodRepresentation;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.PLANT_COVER;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PlantCover(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PlantCover copy = (target == null) ? new PlantCover() : (PlantCover)target;
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

		if (isSetAverageHeight()) {
			copy.setAverageHeight((Length)copyBuilder.copy(averageHeight));
			if (copy.getAverageHeight() == averageHeight)
				averageHeight.setParent(this);
		}

		if (isSetLod1MultiSurface()) {
			copy.setLod1MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod1MultiSurface));
			if (copy.getLod1MultiSurface() == lod1MultiSurface)
				lod1MultiSurface.setParent(this);
		}

		if (isSetLod2MultiSurface()) {
			copy.setLod2MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod2MultiSurface));
			if (copy.getLod2MultiSurface() == lod2MultiSurface)
				lod2MultiSurface.setParent(this);
		}

		if (isSetLod3MultiSurface()) {
			copy.setLod3MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod3MultiSurface));
			if (copy.getLod3MultiSurface() == lod3MultiSurface)
				lod3MultiSurface.setParent(this);
		}

		if (isSetLod4MultiSurface()) {
			copy.setLod4MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod4MultiSurface));
			if (copy.getLod4MultiSurface() == lod4MultiSurface)
				lod4MultiSurface.setParent(this);
		}

		if (isSetLod1MultiSolid()) {
			copy.setLod1MultiSolid((MultiSolidProperty)copyBuilder.copy(lod1MultiSolid));
			if (copy.getLod1MultiSolid() == lod1MultiSolid)
				lod1MultiSolid.setParent(this);
		}

		if (isSetLod2MultiSolid()) {
			copy.setLod2MultiSolid((MultiSolidProperty)copyBuilder.copy(lod2MultiSolid));
			if (copy.getLod2MultiSolid() == lod2MultiSolid)
				lod2MultiSolid.setParent(this);
		}

		if (isSetLod3MultiSolid()) {
			copy.setLod3MultiSolid((MultiSolidProperty)copyBuilder.copy(lod3MultiSolid));
			if (copy.getLod3MultiSolid() == lod3MultiSolid)
				lod3MultiSolid.setParent(this);
		}
		
		if (isSetLod4MultiSolid()) {
			copy.setLod4MultiSolid((MultiSolidProperty)copyBuilder.copy(lod4MultiSolid));
			if (copy.getLod4MultiSolid() == lod4MultiSolid)
				lod4MultiSolid.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfPlantCover()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfPlantCover(copyPart);

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
