package org.citygml4j.impl.citygml.transportation;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.module.citygml.TransportationModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class RailwayImpl extends TransportationComplexImpl implements Railway {
	private List<ADEComponent> ade;
	
	public RailwayImpl() {
		
	}
	
	public RailwayImpl(TransportationModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfRailway(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfRailway() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfRailway() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfRailway(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfRailway() {
		if (isSetGenericApplicationPropertyOfRailway())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfRailway(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfRailway() ? this.ade.remove(ade) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RAILWAY;
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RailwayImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Railway copy = (target == null) ? new RailwayImpl() : (Railway)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfRailway()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfRailway(copyPart);

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
