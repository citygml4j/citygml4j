package org.citygml4j.model.common;

import org.citygml4j.visitor.ObjectVisitor;

public interface VisitableObject {
    void accept(ObjectVisitor visitor);
}
