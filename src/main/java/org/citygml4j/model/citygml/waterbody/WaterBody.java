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
package org.citygml4j.model.citygml.waterbody;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
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
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.module.Module;
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

	public WaterBody(Module module) {
		super(module);
	}

	public void addBoundedBySurface(BoundedByWaterSurfaceProperty boundedBySurface) {
		getBoundedBySurface().add(boundedBySurface);
	}

	public void addFunction(Code function) {
		getFunction().add(function);
	}
	
	public void addUsage(Code usage) {
		getUsage().add(usage);
	}

	public void addGenericApplicationPropertyOfWaterBody(ADEComponent ade) {
		getGenericApplicationPropertyOfWaterBody().add(ade);
	}

	public List<BoundedByWaterSurfaceProperty> getBoundedBySurface() {
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

	public List<ADEComponent> getGenericApplicationPropertyOfWaterBody() {
		if (ade == null)
			ade = new ChildList<>(this);

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

	public void setGenericApplicationPropertyOfWaterBody(List<ADEComponent> ade) {
		this.ade = new ChildList<>(this, ade);
	}

	public void setLod0MultiCurve(MultiCurveProperty lod0MultiCurve) {
		this.lod0MultiCurve = ModelObjects.setParent(lod0MultiCurve, this);
	}

	public void setLod0MultiSurface(MultiSurfaceProperty lod0MultiSurface) {
		this.lod0MultiSurface = ModelObjects.setParent(lod0MultiSurface, this);
	}

	public void setLod1MultiCurve(MultiCurveProperty lod1MultiCurve) {
		this.lod1MultiCurve = ModelObjects.setParent(lod1MultiCurve, this);
	}

	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		this.lod1MultiSurface = ModelObjects.setParent(lod1MultiSurface, this);
	}

	public void setLod1Solid(SolidProperty lod1Solid) {
		this.lod1Solid = ModelObjects.setParent(lod1Solid, this);
	}

	public void setLod2Solid(SolidProperty lod2Solid) {
		this.lod2Solid = ModelObjects.setParent(lod2Solid, this);
	}

	public void setLod3Solid(SolidProperty lod3Solid) {
		this.lod3Solid = ModelObjects.setParent(lod3Solid, this);
	}

	public void setLod4Solid(SolidProperty lod4Solid) {
		this.lod4Solid = ModelObjects.setParent(lod4Solid, this);
	}

	public void unsetBoundedBySurface() {
		boundedBySurface = ModelObjects.setNull(boundedBySurface);
	}

	public boolean unsetBoundedBySurface(BoundedByWaterSurfaceProperty boundedBySurface) {
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

	public void unsetGenericApplicationPropertyOfWaterBody() {
		ade = ModelObjects.setNull(ade);
	}

	public boolean unsetGenericApplicationPropertyOfWaterBody(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfWaterBody() && this.ade.remove(ade);
	}

	public void unsetLod0MultiCurve() {
		lod0MultiCurve = ModelObjects.setNull(lod0MultiCurve);
	}

	public void unsetLod0MultiSurface() {
		lod0MultiSurface = ModelObjects.setNull(lod0MultiSurface);
	}

	public void unsetLod1MultiCurve() {
		lod1MultiCurve = ModelObjects.setNull(lod1MultiCurve);
	}

	public void unsetLod1MultiSurface() {
		lod1MultiSurface = ModelObjects.setNull(lod1MultiSurface);
	}

	public void unsetLod1Solid() {
		lod1Solid = ModelObjects.setNull(lod1Solid);
	}

	public void unsetLod2Solid() {
		lod2Solid = ModelObjects.setNull(lod2Solid);
	}

	public void unsetLod3Solid() {
		lod3Solid = ModelObjects.setNull(lod3Solid);
	}

	public void unsetLod4Solid() {
		lod4Solid = ModelObjects.setNull(lod4Solid);
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

		lodRepresentation.addRepresentation(1, lod1Solid);
		lodRepresentation.addRepresentation(2, lod2Solid);
		lodRepresentation.addRepresentation(3, lod3Solid);
		lodRepresentation.addRepresentation(4, lod4Solid);

		lodRepresentation.addRepresentation(0, lod0MultiSurface);
		lodRepresentation.addRepresentation(1, lod1MultiSurface);

		lodRepresentation.addRepresentation(0, lod0MultiCurve);
		lodRepresentation.addRepresentation(1, lod1MultiCurve);
		
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
