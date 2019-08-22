package org.citygml4j.model.core;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.base.Reference;

public class SpaceBoundaryReference extends Reference implements SpaceBoundaryProperty {

    public SpaceBoundaryReference() {
    }

    public SpaceBoundaryReference(String href) {
        super(href);
    }

    public SpaceBoundaryReference(AbstractGML object) {
        super(object);
    }

    public SpaceBoundaryReference(AssociationAttributes reference) {
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
