package org.citygml4j.model.ade;

import org.citygml4j.visitor.ObjectVisitor;
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.model.Child;
import org.xmlobjects.util.copy.Copyable;

public interface ADEObject extends Child, Copyable, Visitable {

    @Override
    default void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
