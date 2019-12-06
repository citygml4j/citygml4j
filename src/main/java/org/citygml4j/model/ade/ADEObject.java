package org.citygml4j.model.ade;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.visitor.Visitable;
import org.citygml4j.visitor.ObjectVisitor;

public interface ADEObject extends CityGMLObject, Visitable {

    @Override
    default void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
