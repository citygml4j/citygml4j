package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.base.OwnershipAttributes;

public interface BoundarySurfaceProperty<T extends AbstractThematicSurface> extends AssociationAttributes, OwnershipAttributes, CityGMLObject {
    T getObject();
}
