package org.citygml4j.model.deprecated.core;

import org.citygml4j.model.core.AbstractCityObjectProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class DeprecatedPropertiesOfAbstractCityObject extends DeprecatedProperties {
    private List<AbstractCityObjectProperty> generalizesTo;

    public List<AbstractCityObjectProperty> getGeneralizesTo() {
        if (generalizesTo == null)
            generalizesTo = new ChildList<>(this);

        return generalizesTo;
    }

    public void setGeneralizesTo(List<AbstractCityObjectProperty> generalizesTo) {
        this.generalizesTo = asChild(generalizesTo);
    }
}
