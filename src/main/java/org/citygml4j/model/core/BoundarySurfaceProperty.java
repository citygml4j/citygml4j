package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.base.OwnershipAttributes;
import org.xmlobjects.gml.model.common.GenericElement;

public interface BoundarySurfaceProperty<T extends AbstractThematicSurface> extends AssociationAttributes, OwnershipAttributes, CityGMLObject {
    T getObject();
    boolean isSetObject();
    GenericElement getGenericElement();
    boolean isSetGenericElement();
}
