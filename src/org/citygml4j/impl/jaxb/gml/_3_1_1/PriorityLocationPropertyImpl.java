package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.PriorityLocationPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.PriorityLocationProperty;

public class PriorityLocationPropertyImpl extends LocationPropertyImpl implements PriorityLocationProperty {
	private PriorityLocationPropertyType priorityLocation; 
	
	public PriorityLocationPropertyImpl() {
		this(new PriorityLocationPropertyType());
	}
	
	public PriorityLocationPropertyImpl(PriorityLocationPropertyType priorityLocation) {
		super(priorityLocation);
		this.priorityLocation = priorityLocation;
	}

	@Override
	public PriorityLocationPropertyType getJAXBObject() {
		return priorityLocation;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.PRIORITYLOCATIONPROPERTY;
	}
	
	@Override
	public String getPriority() {
		return priorityLocation.getPriority();
	}

	@Override
	public boolean isSetPriority() {
		return priorityLocation.isSetPriority();
	}

	@Override
	public void setPriority(String priority) {
		priorityLocation.setPriority(priority);
	}

	@Override
	public void unsetPriority() {
		priorityLocation.setPriority(null);
	}
	
}
