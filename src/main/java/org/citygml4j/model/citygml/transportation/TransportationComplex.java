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
package org.citygml4j.model.citygml.transportation;

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
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplex;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplexProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;
import org.citygml4j.model.gml.geometry.primitives.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.geometry.primitives.GeometricPrimitiveProperty;
import org.citygml4j.model.module.citygml.TransportationModule;
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

	public TransportationComplex(TransportationModule module) {
		super(module);
	}

	public void addAuxiliaryTrafficArea(AuxiliaryTrafficAreaProperty auxiliaryTrafficArea) {
		if (this.auxiliaryTrafficArea == null)
			this.auxiliaryTrafficArea = new ChildList<AuxiliaryTrafficAreaProperty>(this);

		this.auxiliaryTrafficArea.add(auxiliaryTrafficArea);
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

	public void addGenericApplicationPropertyOfTransportationComplex(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addLod0Network(GeometricComplexProperty lod0Network) {
		if (this.lod0Network == null)
			this.lod0Network = new ChildList<GeometricComplexProperty>(this);

		this.lod0Network.add(lod0Network);
	}

	public void addTrafficArea(TrafficAreaProperty trafficArea) {
		if (this.trafficArea == null)
			this.trafficArea = new ChildList<TrafficAreaProperty>(this);

		this.trafficArea.add(trafficArea);
	}

	public List<AuxiliaryTrafficAreaProperty> getAuxiliaryTrafficArea() {
		if (auxiliaryTrafficArea == null)
			auxiliaryTrafficArea = new ChildList<AuxiliaryTrafficAreaProperty>(this);

		return auxiliaryTrafficArea;
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

	public List<ADEComponent> getGenericApplicationPropertyOfTransportationComplex() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public List<GeometricComplexProperty> getLod0Network() {
		if (lod0Network == null)
			lod0Network = new ChildList<GeometricComplexProperty>(this);

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
			trafficArea = new ChildList<TrafficAreaProperty>(this);

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
		this.clazz = clazz;
	}

	public void setFunction(List<Code> function) {
		this.function = new ChildList<Code>(this, function);
	}
	
	public void setUsage(List<Code> usage) {
		this.usage = new ChildList<Code>(this, usage);
	}

	public void setGenericApplicationPropertyOfTransportationComplex(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setLod0Network(List<GeometricComplexProperty> lod0Network) {
		this.lod0Network = new ChildList<GeometricComplexProperty>(this, lod0Network);
	}

	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		if (lod1MultiSurface != null)
			lod1MultiSurface.setParent(this);

		this.lod1MultiSurface = lod1MultiSurface;
	}

	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		if (lod2MultiSurface != null)
			lod2MultiSurface.setParent(this);

		this.lod2MultiSurface = lod2MultiSurface;
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

	public void setTrafficArea(List<TrafficAreaProperty> trafficArea) {
		this.trafficArea = new ChildList<TrafficAreaProperty>(this, trafficArea);
	}

	public void unsetAuxiliaryTrafficArea() {
		if (isSetAuxiliaryTrafficArea())
			auxiliaryTrafficArea.clear();

		auxiliaryTrafficArea = null;
	}

	public boolean unsetAuxiliaryTrafficArea(AuxiliaryTrafficAreaProperty auxiliaryTrafficArea) {
		return isSetAuxiliaryTrafficArea() ? this.auxiliaryTrafficArea.remove(auxiliaryTrafficArea) : false;
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

	public void unsetGenericApplicationPropertyOfTransportationComplex() {
		if (isSetGenericApplicationPropertyOfTransportationComplex())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTransportationComplex(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTransportationComplex() ? this.ade.remove(ade) : false;
	}

	public void unsetLod0Network() {
		if (isSetLod0Network())
			lod0Network.clear();

		lod0Network = null;
	}

	public boolean unsetLod0Network(GeometricComplexProperty lod0Network) {
		return isSetLod0Network() ? this.lod0Network.remove(lod0Network) : false;
	}

	public void unsetLod1MultiSurface() {
		if (isSetLod1MultiSurface())
			lod1MultiSurface.unsetParent();

		lod1MultiSurface = null;
	}

	public void unsetLod2MultiSurface() {
		if (isSetLod2MultiSurface())
			lod2MultiSurface.unsetParent();

		lod2MultiSurface = null;
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

	public void unsetTrafficArea() {
		if (isSetTrafficArea())
			trafficArea.clear();

		trafficArea = null;
	}

	public boolean unsetTrafficArea(TrafficAreaProperty trafficArea) {
		return isSetTrafficArea() ? this.trafficArea.remove(trafficArea) : false;
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

		if (lod0Network != null) {
			for (GeometricComplexProperty property : lod0Network) {
				if (property != null)
					lodRepresentation.addRepresentation(0, property);
			}
		}
		
		GeometryProperty<? extends AbstractGeometry> property = null;		
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 1:
				property = lod1MultiSurface;
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
