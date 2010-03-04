package org.citygml4j.impl.citygml.transportation;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.impl.gml.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.MultiSurfaceProperty;
import org.citygml4j.model.module.citygml.TransportationModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class TrafficAreaImpl extends TransportationObjectImpl implements TrafficArea {
	private List<String> function;
	private List<String> usage;
	private String surfaceMaterial;
	private MultiSurfaceProperty lod2MultiSurface;
	private MultiSurfaceProperty lod3MultiSurface;
	private MultiSurfaceProperty lod4MultiSurface;
	private List<ADEComponent> ade;
	
	public TrafficAreaImpl() {

	}

	public TrafficAreaImpl(TransportationModule module) {
		super(module);
	}
	
	public void addFunction(String function) {
		if (this.function == null)
			this.function = new ArrayList<String>();

		this.function.add(function);
	}

	public void addGenericApplicationPropertyOfTrafficArea(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addUsage(String usage) {
		if (this.usage == null)
			this.usage = new ArrayList<String>();

		this.usage.add(usage);
	}

	public List<String> getFunction() {
		if (function == null)
			function = new ArrayList<String>();

		return function;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfTrafficArea() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
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

	public String getSurfaceMaterial() {
		return surfaceMaterial;
	}

	public List<String> getUsage() {
		if (usage == null)
			usage = new ArrayList<String>();

		return usage;
	}

	public boolean isSetFunction() {
		return function != null && !function.isEmpty();
	}

	public boolean isSetGenericApplicationPropertyOfTrafficArea() {
		return ade != null && !ade.isEmpty();
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

	public boolean isSetSurfaceMaterial() {
		return surfaceMaterial != null;
	}

	public boolean isSetUsage() {
		return usage != null && !usage.isEmpty();
	}

	public void setFunction(List<String> function) {
		this.function = function;
	}

	public void setGenericApplicationPropertyOfTrafficArea(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
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

	public void setSurfaceMaterial(String surfaceMaterial) {
		this.surfaceMaterial = surfaceMaterial;
	}

	public void setUsage(List<String> usage) {
		this.usage = usage;
	}

	public void unsetFunction() {
		function = null;
	}

	public boolean unsetFunction(String function) {
		return isSetFunction() ? this.function.remove(function) : false;
	}

	public void unsetGenericApplicationPropertyOfTrafficArea() {
		if (isSetGenericApplicationPropertyOfTrafficArea())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTrafficArea(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTrafficArea() ? this.ade.remove(ade) : false;
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

	public void unsetSurfaceMaterial() {
		surfaceMaterial = null;
	}

	public void unsetUsage() {
		usage = null;
	}

	public boolean unsetUsage(String usage) {
		return isSetUsage() ? this.usage.remove(usage) : false;
	}
	
	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRAFFICAREA;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShapeImpl();
		MultiSurfaceProperty multiSurfaceProperty = null;

		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
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

		if (boundedBy.isSetEnvelope()) {
			if (setBoundedBy)
				setBoundedBy(boundedBy);

			return boundedBy;
		} else
			return null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TrafficAreaImpl(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TrafficArea copy = (target == null) ? new TrafficAreaImpl() : (TrafficArea)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetFunction())
			copy.setFunction((List<String>)copyBuilder.copy(function));
		
		if (isSetUsage())
			copy.setFunction((List<String>)copyBuilder.copy(usage));
		
		if (isSetSurfaceMaterial())
			copy.setSurfaceMaterial(copyBuilder.copy(surfaceMaterial));
		
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

		if (isSetGenericApplicationPropertyOfTrafficArea()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTrafficArea(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}
	
	public void visit(FeatureVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T apply(FeatureFunction<T> visitor) {
		return visitor.accept(this);
	}
	
	public void visit(GMLVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T apply(GMLFunction<T> visitor) {
		return visitor.accept(this);
	}
	
}
