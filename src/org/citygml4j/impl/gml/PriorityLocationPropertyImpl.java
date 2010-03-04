package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.PriorityLocationProperty;

public class PriorityLocationPropertyImpl extends LocationPropertyImpl implements PriorityLocationProperty {
	private String priority;
	
	public String getPriority() {
		return priority;
	}

	public boolean isSetPriority() {
		return priority != null;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void unsetPriority() {
		priority = null;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PriorityLocationPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PriorityLocationProperty copy = (target == null) ? new PriorityLocationPropertyImpl() : (PriorityLocationProperty)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetPriority())
			copy.setPriority(copyBuilder.copy(priority));
		
		return copy;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.PRIORITYLOCATIONPROPERTY;
	}

}
