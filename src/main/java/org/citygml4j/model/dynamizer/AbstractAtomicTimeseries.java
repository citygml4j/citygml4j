package org.citygml4j.model.dynamizer;

import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractAtomicTimeseries extends AbstractTimeseries {
    private String observationProperty;
    private String uom;
    private List<ADEOfAbstractAtomicTimeseries> adeOfAbstractAtomicTimeseries;

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

    public List<ADEOfAbstractAtomicTimeseries> getADEOfAbstractAtomicTimeseries() {
        if (adeOfAbstractAtomicTimeseries == null)
            adeOfAbstractAtomicTimeseries = new ChildList<>(this);

        return adeOfAbstractAtomicTimeseries;
    }

    public void setADEOfAbstractAtomicTimeseries(List<ADEOfAbstractAtomicTimeseries> adeOfAbstractAtomicTimeseries) {
        this.adeOfAbstractAtomicTimeseries = asChild(adeOfAbstractAtomicTimeseries);
    }
}
