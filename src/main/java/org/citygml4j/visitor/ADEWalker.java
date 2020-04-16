package org.citygml4j.visitor;

public abstract class ADEWalker implements Walker {
    protected ObjectWalker walker;

    public final ObjectWalker getParentWalker() {
        return walker;
    }

    final void setParentWalker(ObjectWalker walker) {
        this.walker = walker;
    }
}
