package org.citygml4j.model.core;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.base.Reference;

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
    public Class getTargetType() {
        return AbstractThematicSurface.class;
    }
}
