package org.citygml4j.impl.citygml.waterbody;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.module.citygml.WaterBodyModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class WaterGroundSurfaceImpl extends WaterBoundarySurfaceImpl implements WaterGroundSurface {
	private List<ADEComponent> ade;

	public WaterGroundSurfaceImpl() {

	}

	public WaterGroundSurfaceImpl(WaterBodyModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfWaterGroundSurface(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfWaterGroundSurface() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfWaterGroundSurface() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfWaterGroundSurface(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfWaterGroundSurface() {
		if (isSetGenericApplicationPropertyOfWaterGroundSurface())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfWaterGroundSurface(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfWaterGroundSurface() ? this.ade.remove(ade) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WATERGROUNDSURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new WaterGroundSurfaceImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		WaterGroundSurface copy = (target == null) ? new WaterGroundSurfaceImpl() : (WaterGroundSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfWaterGroundSurface()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfWaterGroundSurface(copyPart);

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
