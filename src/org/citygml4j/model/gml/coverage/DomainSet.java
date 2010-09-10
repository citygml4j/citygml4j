package org.citygml4j.model.gml.coverage;

import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface DomainSet<T extends AbstractGeometry> extends GeometryProperty<T> {
	// gml:_TimeObject is not implemented since it is not used in CityGML
}
