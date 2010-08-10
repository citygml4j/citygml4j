package org.citygml4j.impl.citygml.building;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.FloorSurface;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class FloorSurfaceImpl extends AbstractBoundarySurfaceImpl implements FloorSurface {
	private List<ADEComponent> ade;

	public FloorSurfaceImpl() {
		
	}
	
	public FloorSurfaceImpl(BuildingModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfFloorSurface(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfFloorSurface() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfFloorSurface() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfFloorSurface(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfFloorSurface() {
		if (isSetGenericApplicationPropertyOfFloorSurface())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfFloorSurface(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfFloorSurface() ? this.ade.remove(ade) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.FLOOR_SURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new FloorSurfaceImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		FloorSurface copy = (target == null) ? new FloorSurfaceImpl() : (FloorSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfFloorSurface()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfFloorSurface(copyPart);

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
