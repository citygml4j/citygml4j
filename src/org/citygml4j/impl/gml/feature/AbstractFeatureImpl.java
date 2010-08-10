package org.citygml4j.impl.gml.feature;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.impl.gml.base.AbstractGMLImpl;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.feature.LocationProperty;
import org.citygml4j.model.gml.geometry.AbstractGeometry;

public abstract class AbstractFeatureImpl extends AbstractGMLImpl implements AbstractFeature {
	private BoundingShape boundedBy;
	private LocationProperty location;
	private List<ADEComponent> ade;

	public void addGenericADEComponent(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);
		
		this.ade.add(ade);
	}
	
	public BoundingShape getBoundedBy() {
		return boundedBy;
	}

	public LocationProperty getLocation() {
		return location;
	}
	
	public List<ADEComponent> getGenericADEComponent() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);
		
		return ade;
	}

	public boolean isSetBoundedBy() {
		return boundedBy != null;
	}

	public boolean isSetLocation() {
		return location != null;
	}
	
	public boolean isSetGenericADEComponent() {
		return ade != null && !ade.isEmpty();
	}

	public void setBoundedBy(BoundingShape boundingShape) {
		if (boundingShape != null)
			boundingShape.setParent(this);

		boundedBy = boundingShape;
	}

	public void setLocation(LocationProperty location) {
		if (location != null)
			location.setParent(this);

		this.location = location;
	}
	
	public void setGenericADEComponent(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetBoundedBy() {
		if (boundedBy != null)
			boundedBy.unsetParent();

		boundedBy = null;
	}

	public void unsetLocation() {
		if (location != null)
			location.unsetParent();

		location = null;
	}
	
	public void unsetGenericADEComponent() {
		if (isSetGenericADEComponent())
			ade.clear();
		
		ade = null;
	}

	public boolean unsetGenericADEComponent(ADEComponent ade) {
		return isSetGenericADEComponent() ? this.ade.remove(ade) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACT_FEATURE;
	}

	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		// return null by default
		return null;
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractFeature copy = (AbstractFeature)target;
		super.copyTo(copy, copyBuilder);

		if (isSetBoundedBy()) {
			copy.setBoundedBy((BoundingShape)copyBuilder.copy(boundedBy));
			if (copy.getBoundedBy() == boundedBy)
				boundedBy.setParent(this);
		}

		if (isSetLocation()) {
			copy.setLocation((LocationProperty)copyBuilder.copy(location));
			if (copy.getLocation() == location)
				location.setParent(this);
		}
		
		if (isSetGenericADEComponent()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericADEComponent(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}

	protected BoundingShape calcBoundedBy(BoundingShape boundedBy, AbstractFeature abstractFeature, boolean setBoundedBy) {
		if (abstractFeature != null && boundedBy != null) {		
			BoundingShape nestedBoundedBy = abstractFeature.getBoundedBy();
			
			if (nestedBoundedBy == null || !nestedBoundedBy.isSetEnvelope())
				nestedBoundedBy = abstractFeature.calcBoundedBy(setBoundedBy);

			if (nestedBoundedBy != null && nestedBoundedBy.isSetEnvelope())
				boundedBy.updateEnvelope(nestedBoundedBy.getEnvelope().toBoundingBox());
		}	

		return boundedBy;
	}

	protected BoundingShape calcBoundedBy(BoundingShape boundedBy, AbstractGeometry abstractGeometry) {
		if (boundedBy != null)
			boundedBy.updateEnvelope(abstractGeometry.calcBoundingBox());

		return boundedBy;
	}

}
