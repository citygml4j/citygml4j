package org.citygml4j.impl.citygml.relief;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.impl.citygml.core.CityObjectImpl;
import org.citygml4j.impl.gml.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.relief.ReliefComponent;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.PolygonProperty;
import org.citygml4j.model.module.citygml.ReliefModule;

public abstract class ReliefComponentImpl extends CityObjectImpl implements ReliefComponent {
	private int lod;
	private PolygonProperty extent;
	private List<ADEComponent> ade;
	private ReliefModule module;

	public ReliefComponentImpl() {
		
	}
	
	public ReliefComponentImpl(ReliefModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfReliefComponent(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);
		
		this.ade.add(ade);
	}

	public PolygonProperty getExtent() {
		return extent;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfReliefComponent() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public int getLod() {
		return lod;
	}

	public boolean isSetExtent() {
		return extent != null;
	}

	public boolean isSetGenericApplicationPropertyOfReliefComponent() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod() {
		return true;
	}

	public void setExtent(PolygonProperty extent) {
		if (extent != null)
			extent.setParent(this);

		this.extent = extent;
	}

	public void setGenericApplicationPropertyOfReliefComponent(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setLod(int lod) {
		if (lod >= 0 && lod <= 4)
			this.lod = lod;
	}

	public void unsetExtent() {
		if (isSetExtent())
			extent.unsetParent();

		extent = null;
	}

	public void unsetGenericApplicationPropertyOfReliefComponent() {
		if (isSetGenericApplicationPropertyOfReliefComponent())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfReliefComponent(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfReliefComponent() ? this.ade.remove(ade) : false;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShapeImpl();

		if (isSetExtent()) {
			if (extent.isSetPolygon()) {
				calcBoundedBy(boundedBy, extent.getPolygon());	
			} else {
				// xlink
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
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RELIEFCOMPONENT;
	}

	public final ReliefModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		ReliefComponent copy = (ReliefComponent)target;		
		super.copyTo(copy, copyBuilder);

		if (isSetLod())
			copy.setLod(copyBuilder.copy(lod));

		if (isSetExtent()) {
			copy.setExtent((PolygonProperty)copyBuilder.copy(extent));
			if (copy.getExtent() == extent)
				extent.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfReliefComponent()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfReliefComponent(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}
}
