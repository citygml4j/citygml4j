package org.citygml4j.impl.citygml.waterbody;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.WaterBodyModule;

public class WaterSurfaceImpl extends AbstractWaterBoundarySurfaceImpl implements WaterSurface {
	private String waterLevel;
	private List<ADEComponent> ade;

	public WaterSurfaceImpl() {

	}

	public WaterSurfaceImpl(WaterBodyModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfWaterSurface(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfWaterSurface() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public String getWaterLevel() {
		return waterLevel;
	}

	public boolean isSetGenericApplicationPropertyOfWaterSurface() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetWaterLevel() {
		return waterLevel != null;
	}

	public void setGenericApplicationPropertyOfWaterSurface(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setWaterLevel(String waterLevel) {
		this.waterLevel = waterLevel;
	}

	public void unsetGenericApplicationPropertyOfWaterSurface() {
		if (isSetGenericApplicationPropertyOfWaterSurface())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfWaterSurface(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfWaterSurface() ? this.ade.remove(ade) : false;
	}

	public void unsetWaterLevel() {
		waterLevel = null;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WATER_SURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new WaterSurfaceImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		WaterSurface copy = (target == null) ? new WaterSurfaceImpl() : (WaterSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetWaterLevel())
			copy.setWaterLevel(copyBuilder.copy(waterLevel));
		
		if (isSetGenericApplicationPropertyOfWaterSurface()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfWaterSurface(copyPart);

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
