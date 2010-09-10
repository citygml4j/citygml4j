package org.citygml4j.impl.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.coverage.DomainSet;
import org.citygml4j.model.gml.geometry.AbstractGeometry;

public class DomainSetImpl<T extends AbstractGeometry> extends GeometryPropertyImpl<T> implements DomainSet<T> {
	
	public GMLClass getGMLClass() {
		return GMLClass.DOMAIN_SET;
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DomainSet<T> copy = (target == null) ? new DomainSetImpl<T>() : (DomainSet<T>)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new DomainSetImpl<T>(), copyBuilder);
	}

}
