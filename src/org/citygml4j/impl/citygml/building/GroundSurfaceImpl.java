package org.citygml4j.impl.citygml.building;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.GroundSurface;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class GroundSurfaceImpl extends AbstractBoundarySurfaceImpl implements GroundSurface {
	private List<ADEComponent> ade;

	public GroundSurfaceImpl() {
		
	}
	
	public GroundSurfaceImpl(BuildingModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfGroundSurface(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfGroundSurface() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfGroundSurface() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfGroundSurface(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfGroundSurface() {
		if (isSetGenericApplicationPropertyOfGroundSurface())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfGroundSurface(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfGroundSurface() ? this.ade.remove(ade) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.GROUND_SURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GroundSurfaceImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GroundSurface copy = (target == null) ? new GroundSurfaceImpl() : (GroundSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfGroundSurface()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfGroundSurface(copyPart);

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
