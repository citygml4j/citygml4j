package org.citygml4j.model.core;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.common.GenericElement;

public class BoundarySurfaceReference extends Reference implements BoundarySurfaceProperty {

    public BoundarySurfaceReference() {
    }

    public BoundarySurfaceReference(String href) {
        super(href);
    }

    public BoundarySurfaceReference(AbstractGML object) {
        super(object);
    }

    public BoundarySurfaceReference(AssociationAttributes reference) {
        super(reference);
    }

    @Override
    public AbstractThematicSurface getObject() {
        return null;
    }

    @Override
    public boolean isSetObject() {
        return false;
    }

    @Override
    public GenericElement getGenericElement() {
        return null;
    }

    @Override
    public boolean isSetGenericElement() {
        return false;
    }

    @Override
    public Class getTargetType() {
        return AbstractThematicSurface.class;
    }
}
