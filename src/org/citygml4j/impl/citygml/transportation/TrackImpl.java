package org.citygml4j.impl.citygml.transportation;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.module.citygml.TransportationModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class TrackImpl extends TransportationComplexImpl implements Track {
	private List<ADEComponent> ade;
	
	public TrackImpl() {

	}

	public TrackImpl(TransportationModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfTrack(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfTrack() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfTrack() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfTrack(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfTrack() {
		if (isSetGenericApplicationPropertyOfTrack())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTrack(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTrack() ? this.ade.remove(ade) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRACK;
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TrackImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Track copy = (target == null) ? new TrackImpl() : (Track)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfTrack()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTrack(copyPart);

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
