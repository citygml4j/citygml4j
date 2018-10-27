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
package org.citygml4j.model.citygml.waterbody;

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
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.module.citygml.WaterBodyModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class WaterBody extends AbstractWaterObject implements StandardObjectClassifier {
	private Code clazz;
	private List<Code> function;
	private List<Code> usage;
	private MultiCurveProperty lod0MultiCurve;
	private MultiCurveProperty lod1MultiCurve;
	private MultiSurfaceProperty lod0MultiSurface;
	private MultiSurfaceProperty lod1MultiSurface;
	private SolidProperty lod1Solid;
	private SolidProperty lod2Solid;
	private SolidProperty lod3Solid;
	private SolidProperty lod4Solid;
	private List<BoundedByWaterSurfaceProperty> boundedBySurface;
	private List<ADEComponent> ade;

	public WaterBody() {

	}

	public WaterBody(WaterBodyModule module) {
		super(module);
	}

	public void addBoundedBySurface(BoundedByWaterSurfaceProperty boundedBySurface) {
		if (this.boundedBySurface == null)
			this.boundedBySurface = new ChildList<BoundedByWaterSurfaceProperty>(this);

		this.boundedBySurface.add(boundedBySurface);
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

	public void addGenericApplicationPropertyOfWaterBody(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<BoundedByWaterSurfaceProperty> getBoundedBySurface() {
		if (boundedBySurface == null)
			boundedBySurface = new ChildList<BoundedByWaterSurfaceProperty>(this);

		return boundedBySurface;
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

	public List<ADEComponent> getGenericApplicationPropertyOfWaterBody() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public MultiCurveProperty getLod0MultiCurve() {
		return lod0MultiCurve;
	}

	public MultiSurfaceProperty getLod0MultiSurface() {
		return lod0MultiSurface;
	}

	public MultiCurveProperty getLod1MultiCurve() {
		return lod1MultiCurve;
	}

	public MultiSurfaceProperty getLod1MultiSurface() {
		return lod1MultiSurface;
	}

	public SolidProperty getLod1Solid() {
		return lod1Solid;
	}

	public SolidProperty getLod2Solid() {
		return lod2Solid;
	}

	public SolidProperty getLod3Solid() {
		return lod3Solid;
	}

	public SolidProperty getLod4Solid() {
		return lod4Solid;
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

	public boolean isSetGenericApplicationPropertyOfWaterBody() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod0MultiCurve() {
		return lod0MultiCurve != null;
	}

	public boolean isSetLod0MultiSurface() {
		return lod0MultiSurface != null;
	}

	public boolean isSetLod1MultiCurve() {
		return lod1MultiCurve != null;
	}

	public boolean isSetLod1MultiSurface() {
		return lod1MultiSurface != null;
	}

	public boolean isSetLod1Solid() {
		return lod1Solid != null;
	}

	public boolean isSetLod2Solid() {
		return lod2Solid != null;
	}

	public boolean isSetLod3Solid() {
		return lod3Solid != null;
	}

	public boolean isSetLod4Solid() {
		return lod4Solid != null;
	}

	public void setBoundedBySurface(List<BoundedByWaterSurfaceProperty> boundedBySurface) {
		this.boundedBySurface = new ChildList<BoundedByWaterSurfaceProperty>(this, boundedBySurface);
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

	public void setGenericApplicationPropertyOfWaterBody(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setLod0MultiCurve(MultiCurveProperty lod0MultiCurve) {
		if (lod0MultiCurve != null)
			lod0MultiCurve.setParent(this);

		this.lod0MultiCurve = lod0MultiCurve;
	}

	public void setLod0MultiSurface(MultiSurfaceProperty lod0MultiSurface) {
		if (lod0MultiSurface != null)
			lod0MultiSurface.setParent(this);

		this.lod0MultiSurface = lod0MultiSurface;
	}

	public void setLod1MultiCurve(MultiCurveProperty lod1MultiCurve) {
		if (lod1MultiCurve != null)
			lod1MultiCurve.setParent(this);

		this.lod1MultiCurve = lod1MultiCurve;
	}

	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		if (lod1MultiSurface != null)
			lod1MultiSurface.setParent(this);

		this.lod1MultiSurface = lod1MultiSurface;
	}

	public void setLod1Solid(SolidProperty lod1Solid) {
		if (lod1Solid != null)
			lod1Solid.setParent(this);

		this.lod1Solid = lod1Solid;
	}

	public void setLod2Solid(SolidProperty lod2Solid) {
		if (lod2Solid != null)
			lod2Solid.setParent(this);

		this.lod2Solid = lod2Solid;
	}

	public void setLod3Solid(SolidProperty lod3Solid) {
		if (lod3Solid != null)
			lod3Solid.setParent(this);

		this.lod3Solid = lod3Solid;
	}

	public void setLod4Solid(SolidProperty lod4Solid) {
		if (lod4Solid != null)
			lod4Solid.setParent(this);

		this.lod4Solid = lod4Solid;
	}

	public void unsetBoundedBySurface() {
		if (isSetBoundedBySurface())
			boundedBySurface.clear();

		boundedBySurface = null;
	}

	public boolean unsetBoundedBySurface(BoundedByWaterSurfaceProperty boundedBySurface) {
		return isSetBoundedBySurface() ? this.boundedBySurface.remove(boundedBySurface) : false;
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

	public void unsetGenericApplicationPropertyOfWaterBody() {
		if (isSetGenericApplicationPropertyOfWaterBody())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfWaterBody(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfWaterBody() ? this.ade.remove(ade) : false;
	}

	public void unsetLod0MultiCurve() {
		if (isSetLod0MultiCurve())
			lod0MultiCurve.unsetParent();

		lod0MultiCurve = null;
	}

	public void unsetLod0MultiSurface() {
		if (isSetLod0MultiSurface())
			lod0MultiSurface.unsetParent();

		lod0MultiSurface = null;
	}

	public void unsetLod1MultiCurve() {
		if (isSetLod1MultiCurve())
			lod1MultiCurve.unsetParent();

		lod1MultiCurve = null;
	}

	public void unsetLod1MultiSurface() {
		if (isSetLod1MultiSurface())
			lod1MultiSurface.unsetParent();

		lod1MultiSurface = null;
	}

	public void unsetLod1Solid() {
		if (isSetLod1Solid())
			lod1Solid.unsetParent();

		lod1Solid = null;
	}

	public void unsetLod2Solid() {
		if (isSetLod2Solid())
			lod2Solid.unsetParent();

		lod2Solid = null;
	}

	public void unsetLod3Solid() {
		if (isSetLod3Solid())
			lod3Solid.unsetParent();

		lod3Solid = null;
	}

	public void unsetLod4Solid() {
		if (isSetLod4Solid())
			lod4Solid.unsetParent();

		lod4Solid = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WATER_BODY;
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		SolidProperty solidProperty = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				solidProperty = lod1Solid;
				break;
			case 2:
				solidProperty = lod2Solid;
				break;
			case 3:
				solidProperty = lod3Solid;
				break;
			case 4:
				solidProperty = lod4Solid;
				break;
			}

			if (solidProperty != null) {
				if (solidProperty.isSetSolid()) {
					boundedBy.updateEnvelope(solidProperty.getSolid().calcBoundingBox());
				} else {
					// xlink
				}
			}
		}

		MultiSurfaceProperty multiSurfaceProperty = null;
		for (int lod = 0; lod < 2; lod++) {
			switch (lod) {
			case 0:
				multiSurfaceProperty = lod0MultiSurface;
				break;
			case 1:
				multiSurfaceProperty = lod1MultiSurface;
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

		MultiCurveProperty multiCurveProperty = null;
		for (int lod = 0; lod < 2; lod++) {
			switch (lod) {
			case 0:
				multiCurveProperty = lod0MultiCurve;
				break;
			case 1:
				multiCurveProperty = lod1MultiCurve;
				break;
			}

			if (multiCurveProperty != null) {
				if (multiCurveProperty.isSetMultiCurve()) {
					boundedBy.updateEnvelope(multiCurveProperty.getMultiCurve().calcBoundingBox());
				} else {
					// xlink
				}
			}
		}

		if (isSetBoundedBySurface()) {
			for (BoundedByWaterSurfaceProperty boundedBySurfaceProperty : boundedBySurface) {
				if (boundedBySurfaceProperty.isSetObject()) {
					boundedBy.updateEnvelope(boundedBySurfaceProperty.getObject().calcBoundedBy(options).getEnvelope());
				} else {
					// xlink
				}
			}
		}
		
		if (isSetGenericApplicationPropertyOfWaterBody()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfWaterBody()) {
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
				property = lod1Solid;
				break;
			case 2:
				property = lod2Solid;
				break;
			case 3:
				property = lod3Solid;
				break;
			case 4:
				property = lod4Solid;
				break;
			}

			if (property != null)
				lodRepresentation.addRepresentation(lod, property);
		}

		property = null;
		for (int lod = 0; lod < 2; lod++) {
			switch (lod) {
			case 0:
				property = lod0MultiSurface;
				break;
			case 1:
				property = lod1MultiSurface;
				break;
			}

			if (property != null)
				lodRepresentation.addRepresentation(lod, property);
		}

		property = null;
		for (int lod = 0; lod < 2; lod++) {
			switch (lod) {
			case 0:
				property = lod0MultiCurve;
				break;
			case 1:
				property = lod1MultiCurve;
				break;
			}

			if (property != null)
				lodRepresentation.addRepresentation(lod, property);
		}
		
		return lodRepresentation;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new WaterBody(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		WaterBody copy = (target == null) ? new WaterBody() : (WaterBody)target;
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
			for (BoundedByWaterSurfaceProperty part : boundedBySurface) {
				BoundedByWaterSurfaceProperty copyPart = (BoundedByWaterSurfaceProperty)copyBuilder.copy(part);
				copy.addBoundedBySurface(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetLod0MultiCurve()) {
			copy.setLod0MultiCurve((MultiCurveProperty)copyBuilder.copy(lod0MultiCurve));
			if (copy.getLod0MultiCurve() == lod0MultiCurve)
				lod0MultiCurve.setParent(this);
		}

		if (isSetLod1MultiCurve()) {
			copy.setLod1MultiCurve((MultiCurveProperty)copyBuilder.copy(lod1MultiCurve));
			if (copy.getLod1MultiCurve() == lod1MultiCurve)
				lod1MultiCurve.setParent(this);
		}

		if (isSetLod0MultiSurface()) {
			copy.setLod0MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod0MultiSurface));
			if (copy.getLod0MultiSurface() == lod0MultiSurface)
				lod0MultiSurface.setParent(this);
		}

		if (isSetLod1MultiSurface()) {
			copy.setLod1MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod1MultiSurface));
			if (copy.getLod1MultiSurface() == lod1MultiSurface)
				lod1MultiSurface.setParent(this);
		}

		if (isSetLod1Solid()) {
			copy.setLod1Solid((SolidProperty)copyBuilder.copy(lod1Solid));
			if (copy.getLod1Solid() == lod1Solid)
				lod1Solid.setParent(this);
		}

		if (isSetLod2Solid()) {
			copy.setLod2Solid((SolidProperty)copyBuilder.copy(lod2Solid));
			if (copy.getLod2Solid() == lod2Solid)
				lod2Solid.setParent(this);
		}

		if (isSetLod3Solid()) {
			copy.setLod3Solid((SolidProperty)copyBuilder.copy(lod3Solid));
			if (copy.getLod3Solid() == lod3Solid)
				lod3Solid.setParent(this);
		}

		if (isSetLod4Solid()) {
			copy.setLod4Solid((SolidProperty)copyBuilder.copy(lod4Solid));
			if (copy.getLod4Solid() == lod4Solid)
				lod4Solid.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfWaterBody()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfWaterBody(copyPart);

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
