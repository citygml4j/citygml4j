package org.citygml4j.impl.citygml.transportation;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.TransportationModule;

public class SquareImpl extends TransportationComplexImpl implements Square {
	private List<ADEComponent> ade;
	
	public SquareImpl() {

	}

	public SquareImpl(TransportationModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfSquare(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfSquare() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfSquare() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfSquare(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfSquare() {
		if (isSetGenericApplicationPropertyOfSquare())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfSquare(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfSquare() ? this.ade.remove(ade) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.SQUARE;
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SquareImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Square copy = (target == null) ? new SquareImpl() : (Square)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfSquare()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfSquare(copyPart);

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
