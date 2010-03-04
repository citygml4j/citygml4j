package org.citygml4j.impl.citygml.building;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class BuildingPartImpl extends AbstractBuildingImpl implements BuildingPart {
	private List<ADEComponent> ade;

	public BuildingPartImpl() {
		
	}
	
	public BuildingPartImpl(BuildingModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfBuildingPart(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfBuildingPart() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfBuildingPart() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfBuildingPart(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfBuildingPart() {
		if (isSetGenericApplicationPropertyOfBuildingPart())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfBuildingPart(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfBuildingPart() ? this.ade.remove(ade) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BUILDINGPART;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingPartImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BuildingPart copy = (target == null) ? new BuildingPartImpl() : (BuildingPart)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfBuildingPart()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfBuildingPart(copyPart);

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
