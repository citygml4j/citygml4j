package org.citygml4j.model.deprecated;

import org.citygml4j.model.core.AbstractCityObject;
import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.common.GenericElement;

public class WeakCityObjectReference extends AbstractWeakReference<AbstractCityObject> {
    private GenericElement genericElement;

    public WeakCityObjectReference() {
    }

    public WeakCityObjectReference(String href) {
        super(href);
    }

    public WeakCityObjectReference(AbstractCityObject object) {
        super(object);
    }

    public WeakCityObjectReference(AssociationAttributes reference) {
        super(reference);
    }

    public boolean isSetObject() {
        return getObject() != null;
    }

    public GenericElement getGenericElement() {
        return genericElement;
    }

    public boolean isSetGenericElement() {
        return genericElement != null;
    }

    public void setGenericElement(GenericElement genericElement) {
        this.genericElement = asChild(genericElement);
    }

    @Override
    public Class<AbstractCityObject> getTargetType() {
        return AbstractCityObject.class;
    }
}
