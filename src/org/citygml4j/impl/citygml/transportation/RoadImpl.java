package org.citygml4j.impl.citygml.transportation;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.module.citygml.TransportationModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class RoadImpl extends TransportationComplexImpl implements Road {
	private List<ADEComponent> ade;

	public RoadImpl() {

	}

	public RoadImpl(TransportationModule module) {
		super(module);
	}

	public void addGenericApplicationPropertyOfRoad(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfRoad() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfRoad() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfRoad(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfRoad() {
		if (isSetGenericApplicationPropertyOfRoad())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfRoad(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfRoad() ? this.ade.remove(ade) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ROAD;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RoadImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Road copy = (target == null) ? new RoadImpl() : (Road)target;
		super.copyTo(copy, copyBuilder);

		if (isSetGenericApplicationPropertyOfRoad()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfRoad(copyPart);

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
