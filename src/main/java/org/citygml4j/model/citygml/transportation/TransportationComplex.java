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
package org.citygml4j.model.citygml.transportation;

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
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplex;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplexProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;
import org.citygml4j.model.gml.geometry.primitives.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.geometry.primitives.GeometricPrimitiveProperty;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class TransportationComplex extends AbstractTransportationObject implements StandardObjectClassifier {
	private Code clazz;
	private List<Code> function;
	private List<Code> usage;
	private List<TrafficAreaProperty> trafficArea;
	private List<AuxiliaryTrafficAreaProperty> auxiliaryTrafficArea;
	private List<GeometricComplexProperty> lod0Network;
	private MultiSurfaceProperty lod1MultiSurface;
	private MultiSurfaceProperty lod2MultiSurface;
	private MultiSurfaceProperty lod3MultiSurface;
	private MultiSurfaceProperty lod4MultiSurface;
	private List<ADEComponent> ade;

	public TransportationComplex() {

	}

	public TransportationComplex(Module module) {
		super(module);
	}

	public void addAuxiliaryTrafficArea(AuxiliaryTrafficAreaProperty auxiliaryTrafficArea) {
		getAuxiliaryTrafficArea().add(auxiliaryTrafficArea);
	}

	public void addFunction(Code function) {
		getFunction().add(function);
	}
	
	public void addUsage(Code usage) {
		getUsage().add(usage);
	}

	public void addGenericApplicationPropertyOfTransportationComplex(ADEComponent ade) {
		getGenericApplicationPropertyOfTransportationComplex().add(ade);
	}

	public void addLod0Network(GeometricComplexProperty lod0Network) {
		getLod0Network().add(lod0Network);
	}

	public void addTrafficArea(TrafficAreaProperty trafficArea) {
		getTrafficArea().add(trafficArea);
	}

	public List<AuxiliaryTrafficAreaProperty> getAuxiliaryTrafficArea() {
		if (auxiliaryTrafficArea == null)
			auxiliaryTrafficArea = new ChildList<>(this);

		return auxiliaryTrafficArea;
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

	public List<ADEComponent> getGenericApplicationPropertyOfTransportationComplex() {
		if (ade == null)
			ade = new ChildList<>(this);

		return ade;
	}

	public List<GeometricComplexProperty> getLod0Network() {
		if (lod0Network == null)
			lod0Network = new ChildList<>(this);

		return lod0Network;
	}

	public MultiSurfaceProperty getLod1MultiSurface() {
		return lod1MultiSurface;
	}

	public MultiSurfaceProperty getLod2MultiSurface() {
		return lod2MultiSurface;
	}

	public MultiSurfaceProperty getLod3MultiSurface() {
		return lod3MultiSurface;
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		return lod4MultiSurface;
	}

	public List<TrafficAreaProperty> getTrafficArea() {
		if (trafficArea == null)
			trafficArea = new ChildList<>(this);

		return trafficArea;
	}

	public boolean isSetAuxiliaryTrafficArea() {
		return auxiliaryTrafficArea != null && !auxiliaryTrafficArea.isEmpty();
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

	public boolean isSetGenericApplicationPropertyOfTransportationComplex() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod0Network() {
		return lod0Network != null && !lod0Network.isEmpty();
	}

	public boolean isSetLod1MultiSurface() {
		return lod1MultiSurface != null;
	}

	public boolean isSetLod2MultiSurface() {
		return lod2MultiSurface != null;
	}

	public boolean isSetLod3MultiSurface() {
		return lod3MultiSurface != null;
	}

	public boolean isSetLod4MultiSurface() {
		return lod4MultiSurface != null;
	}

	public boolean isSetTrafficArea() {
		return trafficArea != null && !trafficArea.isEmpty();
	}

	public void setAuxiliaryTrafficArea(List<AuxiliaryTrafficAreaProperty> auxiliaryTrafficArea) {
		this.auxiliaryTrafficArea = new ChildList<AuxiliaryTrafficAreaProperty>(this, auxiliaryTrafficArea);
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

	public void setGenericApplicationPropertyOfTransportationComplex(List<ADEComponent> ade) {
		this.ade = new ChildList<>(this, ade);
	}

	public void setLod0Network(List<GeometricComplexProperty> lod0Network) {
		this.lod0Network = new ChildList<>(this, lod0Network);
	}

	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		this.lod1MultiSurface = ModelObjects.setParent(lod1MultiSurface, this);
	}

	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		this.lod2MultiSurface = ModelObjects.setParent(lod2MultiSurface, this);
	}

	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		this.lod3MultiSurface = ModelObjects.setParent(lod3MultiSurface, this);
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		this.lod4MultiSurface = ModelObjects.setParent(lod4MultiSurface, this);
	}

	public void setTrafficArea(List<TrafficAreaProperty> trafficArea) {
		this.trafficArea = new ChildList<>(this, trafficArea);
	}

	public void unsetAuxiliaryTrafficArea() {
		auxiliaryTrafficArea = ModelObjects.setNull(auxiliaryTrafficArea);
	}

	public boolean unsetAuxiliaryTrafficArea(AuxiliaryTrafficAreaProperty auxiliaryTrafficArea) {
		return isSetAuxiliaryTrafficArea() && this.auxiliaryTrafficArea.remove(auxiliaryTrafficArea);
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

	public void unsetGenericApplicationPropertyOfTransportationComplex() {
		ade = ModelObjects.setNull(ade);
	}

	public boolean unsetGenericApplicationPropertyOfTransportationComplex(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTransportationComplex() && this.ade.remove(ade);
	}

	public void unsetLod0Network() {
		lod0Network = ModelObjects.setNull(lod0Network);
	}

	public boolean unsetLod0Network(GeometricComplexProperty lod0Network) {
		return isSetLod0Network() && this.lod0Network.remove(lod0Network);
	}

	public void unsetLod1MultiSurface() {
		lod1MultiSurface = ModelObjects.setNull(lod1MultiSurface);
	}

	public void unsetLod2MultiSurface() {
		lod2MultiSurface = ModelObjects.setNull(lod2MultiSurface);
	}

	public void unsetLod3MultiSurface() {
		lod3MultiSurface = ModelObjects.setNull(lod3MultiSurface);
	}

	public void unsetLod4MultiSurface() {
		lod4MultiSurface = ModelObjects.setNull(lod4MultiSurface);
	}

	public void unsetTrafficArea() {
		trafficArea = ModelObjects.setNull(trafficArea);
	}

	public boolean unsetTrafficArea(TrafficAreaProperty trafficArea) {
		return isSetTrafficArea() && this.trafficArea.remove(trafficArea);
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRANSPORTATION_COMPLEX;
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
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

		// we just consider curves here
		if (isSetLod0Network()) {
			for (GeometricComplexProperty geomProperty : lod0Network) {
				if (geomProperty.isSetCompositeCurve()) {
					if (geomProperty.isSetCompositeCurve()) {
						boundedBy.updateEnvelope(geomProperty.getCompositeCurve().calcBoundingBox());
					} else {
						// xlink
					}
				}

				else if (geomProperty.isSetGeometricComplex()) {
					GeometricComplex complex = geomProperty.getGeometricComplex();
					if (complex.isSetElement()) {
						for (GeometricPrimitiveProperty primitiveProperty : complex.getElement()) {
							AbstractGeometricPrimitive absPrimitive = primitiveProperty.getGeometricPrimitive();
							if (absPrimitive != null && absPrimitive instanceof AbstractCurve) {
								boundedBy.updateEnvelope(absPrimitive.calcBoundingBox());
							} else {
								// xlink
							}
						}
					}
				}
			}
		}

		if (isSetAuxiliaryTrafficArea()) {
			for (AuxiliaryTrafficAreaProperty auxTrafficAreaProperty : auxiliaryTrafficArea) {
				if (auxTrafficAreaProperty.isSetObject()) {
					boundedBy.updateEnvelope(auxTrafficAreaProperty.getObject().calcBoundedBy(options).getEnvelope());
				} else {
					// xlink
				}
			}
		}

		if (isSetTrafficArea()) {
			for (TrafficAreaProperty trafficAreaProperty : trafficArea) {
				if (trafficAreaProperty.isSetObject()) {
					boundedBy.updateEnvelope(trafficAreaProperty.getObject().calcBoundedBy(options).getEnvelope());
				} else {
					// xlink
				}
			}
		}
		
		if (isSetGenericApplicationPropertyOfTransportationComplex()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfTransportationComplex()) {
				if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, options).getEnvelope());
			}
		}

		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}

	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();

		if (lod0Network != null) {
			for (GeometricComplexProperty property : lod0Network) {
				if (property != null)
					lodRepresentation.addRepresentation(0, property);
			}
		}

		lodRepresentation.addRepresentation(1, lod1MultiSurface);
		lodRepresentation.addRepresentation(2, lod2MultiSurface);
		lodRepresentation.addRepresentation(3, lod3MultiSurface);
		lodRepresentation.addRepresentation(4, lod4MultiSurface);

		return lodRepresentation;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TransportationComplex(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TransportationComplex copy = (target == null) ? new TransportationComplex() : (TransportationComplex)target;
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

		if (isSetAuxiliaryTrafficArea()) {
			for (AuxiliaryTrafficAreaProperty part : auxiliaryTrafficArea) {
				AuxiliaryTrafficAreaProperty copyPart = (AuxiliaryTrafficAreaProperty)copyBuilder.copy(part);
				copy.addAuxiliaryTrafficArea(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetTrafficArea()) {
			for (TrafficAreaProperty part : trafficArea) {
				TrafficAreaProperty copyPart = (TrafficAreaProperty)copyBuilder.copy(part);
				copy.addTrafficArea(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetLod0Network()) {
			for (GeometricComplexProperty part : lod0Network) {
				GeometricComplexProperty copyPart = (GeometricComplexProperty)copyBuilder.copy(part);
				copy.addLod0Network(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
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

		if (isSetGenericApplicationPropertyOfTransportationComplex()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTransportationComplex(copyPart);

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
