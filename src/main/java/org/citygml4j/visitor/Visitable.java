package org.citygml4j.visitor;

import org.citygml4j.visitor.ObjectVisitor;

public interface Visitable {
    void accept(ObjectVisitor visitor);
}
