package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.model.gml.GMLBase;
import org.citygml4j.model.gml.GMLClass;

public abstract class GMLBaseImpl implements GMLBase {
	public abstract Object getJAXBObject();

	public abstract GMLClass getGMLClass();
	
	public boolean equals(GMLBase other) {
		Object thisJAXB = getJAXBObject();
		Object otherJAXB = ((GMLBaseImpl)other).getJAXBObject();

		if (thisJAXB != null && otherJAXB != null)
			return thisJAXB.equals(otherJAXB);
		else
			return super.equals(other);
	}
	
}
