package org.citygml4j.impl.citygml.building;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class RoofSurfaceImpl extends AbstractBoundarySurfaceImpl implements RoofSurface {
	private List<ADEComponent> ade;

	public RoofSurfaceImpl() {
		
	}
	
	public RoofSurfaceImpl(BuildingModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfRoofSurface(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfRoofSurface() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfRoofSurface() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfRoofSurface(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfRoofSurface() {
		if (isSetGenericApplicationPropertyOfRoofSurface())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfRoofSurface(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfRoofSurface() ? this.ade.remove(ade) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ROOF_SURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RoofSurfaceImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		RoofSurface copy = (target == null) ? new RoofSurfaceImpl() : (RoofSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfRoofSurface()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfRoofSurface(copyPart);

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
