package org.citygml4j.impl.citygml.building;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class WallSurfaceImpl extends AbstractBoundarySurfaceImpl implements WallSurface {
	private List<ADEComponent> ade;

	public WallSurfaceImpl() {
		
	}
	
	public WallSurfaceImpl(BuildingModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfWallSurface(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfWallSurface() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfWallSurface() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfWallSurface(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);	}

	public void unsetGenericApplicationPropertyOfWallSurface() {
		if (isSetGenericApplicationPropertyOfWallSurface())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfWallSurface(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfWallSurface() ? this.ade.remove(ade) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WALL_SURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new WallSurfaceImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		WallSurface copy = (target == null) ? new WallSurfaceImpl() : (WallSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfWallSurface()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfWallSurface(copyPart);

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
