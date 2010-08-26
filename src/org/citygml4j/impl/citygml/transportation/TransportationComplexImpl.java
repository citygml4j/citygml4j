package org.citygml4j.impl.citygml.transportation;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
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

public class TransportationComplexImpl extends AbstractTransportationObjectImpl implements TransportationComplex {
	private List<String> function;
	private List<String> usage;
	private List<TrafficAreaProperty> trafficArea;
	private List<AuxiliaryTrafficAreaProperty> auxiliaryTrafficArea;
	private List<GeometricComplexProperty> lod0Network;
	private MultiSurfaceProperty lod1MultiSurface;
	private MultiSurfaceProperty lod2MultiSurface;
	private MultiSurfaceProperty lod3MultiSurface;
	private MultiSurfaceProperty lod4MultiSurface;
	private List<ADEComponent> ade;

	public TransportationComplexImpl() {

	}

	public TransportationComplexImpl(TransportationModule module) {
		super(module);
	}

	public void addAuxiliaryTrafficArea(AuxiliaryTrafficAreaProperty auxiliaryTrafficArea) {
		if (this.auxiliaryTrafficArea == null)
			this.auxiliaryTrafficArea = new ChildList<AuxiliaryTrafficAreaProperty>(this);

		this.auxiliaryTrafficArea.add(auxiliaryTrafficArea);
	}

	public void addFunction(String function) {
		if (this.function == null)
			this.function = new ArrayList<String>();

		this.function.add(function);
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

	public void addUsage(String usage) {
		if (this.usage == null)
			this.usage = new ArrayList<String>();

		this.usage.add(usage);
	}

	public List<AuxiliaryTrafficAreaProperty> getAuxiliaryTrafficArea() {
		if (auxiliaryTrafficArea == null)
			auxiliaryTrafficArea = new ChildList<AuxiliaryTrafficAreaProperty>(this);

		return auxiliaryTrafficArea;
	}

	public List<String> getFunction() {
		if (function == null)
			function = new ArrayList<String>();

		return function;
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

	public List<String> getUsage() {
		if (usage == null)
			usage = new ArrayList<String>();

		return usage;
	}

	public boolean isSetAuxiliaryTrafficArea() {
		return auxiliaryTrafficArea != null && !auxiliaryTrafficArea.isEmpty();
	}

	public boolean isSetFunction() {
		return function != null && !function.isEmpty();
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

	public boolean isSetUsage() {
		return usage != null && !usage.isEmpty();
	}

	public void setAuxiliaryTrafficArea(List<AuxiliaryTrafficAreaProperty> auxiliaryTrafficArea) {
		this.auxiliaryTrafficArea = new ChildList<AuxiliaryTrafficAreaProperty>(this, auxiliaryTrafficArea);
	}

	public void setFunction(List<String> function) {
		this.function = function;
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

	public void setUsage(List<String> usage) {
		this.usage = usage;
	}

	public void unsetAuxiliaryTrafficArea() {
		if (isSetAuxiliaryTrafficArea())
			auxiliaryTrafficArea.clear();

		auxiliaryTrafficArea = null;
	}

	public boolean unsetAuxiliaryTrafficArea(AuxiliaryTrafficAreaProperty auxiliaryTrafficArea) {
		return isSetAuxiliaryTrafficArea() ? this.auxiliaryTrafficArea.remove(auxiliaryTrafficArea) : false;
	}

	public void unsetFunction() {
		function = null;
	}

	public boolean unsetFunction(String function) {
		return isSetFunction() ? this.function.remove(function) : false;
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

	public void unsetUsage() {
		usage = null;
	}

	public boolean unsetUsage(String usage) {
		return isSetUsage() ? this.usage.remove(usage) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRANSPORTATION_COMPLEX;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShapeImpl();
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
					calcBoundedBy(boundedBy, multiSurfaceProperty.getMultiSurface());
				} else {
					// xlink
				}
			}
		}

		// we just consider curve here
		if (isSetLod0Network()) {
			for (GeometricComplexProperty geomProperty : lod0Network) {
				if (geomProperty.isSetCompositeCurve()) {
					if (geomProperty.isSetCompositeCurve()) {
						calcBoundedBy(boundedBy, geomProperty.getCompositeCurve());
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
								calcBoundedBy(boundedBy, absPrimitive);
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
					calcBoundedBy(boundedBy, auxTrafficAreaProperty.getObject(), setBoundedBy);
				} else {
					// xlink
				}
			}
		}

		if (isSetTrafficArea()) {
			for (TrafficAreaProperty trafficAreaProperty : trafficArea) {
				if (trafficAreaProperty.isSetObject()) {
					calcBoundedBy(boundedBy, trafficAreaProperty.getObject(), setBoundedBy);
				} else {
					// xlink
				}
			}
		}

		if (boundedBy.isSetEnvelope()) {
			if (setBoundedBy)
				setBoundedBy(boundedBy);

			return boundedBy;
		} else
			return null;
	}

	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();

		if (isSetLod0Network())
			lodRepresentation.getLod0Representation().addAll(lod0Network);

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
				lodRepresentation.getLodRepresentation(lod).add(property);
		}

		return lodRepresentation;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TransportationComplexImpl(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TransportationComplex copy = (target == null) ? new TransportationComplexImpl() : (TransportationComplex)target;
		super.copyTo(copy, copyBuilder);

		if (isSetFunction())
			copy.setFunction((List<String>)copyBuilder.copy(function));

		if (isSetUsage())
			copy.setFunction((List<String>)copyBuilder.copy(usage));

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
