package org.citygml4j.model.common;

import org.citygml4j.visitor.ObjectVisitor;

public interface Visitable {
    void accept(ObjectVisitor visitor);
}
