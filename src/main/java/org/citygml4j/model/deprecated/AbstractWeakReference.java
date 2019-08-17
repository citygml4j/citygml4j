package org.citygml4j.model.deprecated;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.base.Reference;

public abstract class AbstractWeakReference<T extends AbstractGML> extends Reference {
    private T object;

    public AbstractWeakReference() {
    }

    public AbstractWeakReference(String href) {
        super(href);
    }

    public AbstractWeakReference(T object) {
        setObject(object);
    }

    public AbstractWeakReference(AssociationAttributes reference) {
        super(reference);
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = asChild(object);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractGML.class;
    }
}
