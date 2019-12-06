package org.citygml4j.visitor;

public interface Visitable {
    void accept(ObjectVisitor visitor);
}
