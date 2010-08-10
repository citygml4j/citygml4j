package org.citygml4j.impl.citygml.relief;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.impl.gml.feature.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.aggregates.MultiPointProperty;
import org.citygml4j.model.module.citygml.ReliefModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class MassPointReliefImpl extends AbstractReliefComponentImpl implements MassPointRelief {
	private MultiPointProperty reliefPoints;
	private List<ADEComponent> ade;
	
	public MassPointReliefImpl() {
		
	}
	
	public MassPointReliefImpl(ReliefModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfMassPointRelief(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfMassPointRelief() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public MultiPointProperty getReliefPoints() {
		return reliefPoints;
	}

	public boolean isSetGenericApplicationPropertyOfMassPointRelief() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetReliefPoints() {
		return reliefPoints != null;
	}

	public void setGenericApplicationPropertyOfMassPointRelief(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setReliefPoints(MultiPointProperty reliefPoints) {
		if (reliefPoints != null)
			reliefPoints.setParent(this);
		
		this.reliefPoints = reliefPoints;
	}

	public void unsetGenericApplicationPropertyOfMassPointRelief() {
		if (isSetGenericApplicationPropertyOfMassPointRelief())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfMassPointRelief(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfMassPointRelief() ? this.ade.remove(ade) : false;
	}

	public void unsetReliefPoints() {
		if (isSetReliefPoints())
			reliefPoints.unsetParent();
		
		reliefPoints = null;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.MASSPOINT_RELIEF;
	}
	
	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = super.calcBoundedBy(false);
		if (boundedBy == null)
			boundedBy = new BoundingShapeImpl();
		
		if (isSetReliefPoints()) {
			if (reliefPoints.isSetMultiPoint()) {
				calcBoundedBy(boundedBy, reliefPoints.getMultiPoint());
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

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MassPointReliefImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MassPointRelief copy = (target == null) ? new MassPointReliefImpl() : (MassPointRelief)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetReliefPoints()) {
			copy.setReliefPoints((MultiPointProperty)copyBuilder.copy(reliefPoints));
			if (copy.getReliefPoints() == reliefPoints)
				reliefPoints.setParent(this);
		}
		
		if (isSetGenericApplicationPropertyOfMassPointRelief()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfMassPointRelief(copyPart);

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
