package org.citygml4j.model.generics;

import org.xmlobjects.gml.model.basictypes.Measure;

public class MeasureAttribute extends AbstractGenericAttribute<Measure> {

    public MeasureAttribute() {
    }

    public MeasureAttribute(String name, Measure value) {
        super(name, value);
    }

    @Override
    public void setValue(Measure value) {
        super.setValue(asChild(value));
    }
}
