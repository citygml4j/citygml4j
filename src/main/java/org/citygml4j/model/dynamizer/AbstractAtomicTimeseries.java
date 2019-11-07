package org.citygml4j.model.dynamizer;

import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractAtomicTimeseries extends AbstractTimeseries {
    private String observationProperty;
    private String uom;
    private List<ADEPropertyOfAbstractAtomicTimeseries> adeProperties;

    public AbstractAtomicTimeseries() {
    }

    public AbstractAtomicTimeseries(String observationProperty) {
        this.observationProperty = observationProperty;
    }

    public String getObservationProperty() {
        return observationProperty;
    }

    public void setObservationProperty(String observationProperty) {
        this.observationProperty = observationProperty;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public List<ADEPropertyOfAbstractAtomicTimeseries> getADEPropertiesOfAbstractAtomicTimeseries() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractAtomicTimeseries(List<ADEPropertyOfAbstractAtomicTimeseries> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
