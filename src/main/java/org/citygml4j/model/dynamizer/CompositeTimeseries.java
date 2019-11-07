package org.citygml4j.model.dynamizer;

import org.xmlobjects.model.ChildList;

import java.util.List;

public class CompositeTimeseries extends AbstractTimeseries {
    private List<TimeseriesComponentProperty> components;
    private List<ADEPropertyOfCompositeTimeseries> adeProperties;

    public CompositeTimeseries() {
    }

    public CompositeTimeseries(List<TimeseriesComponentProperty> components) {
        setComponents(components);
    }

    public List<TimeseriesComponentProperty> getComponents() {
        if (components == null)
            components = new ChildList<>(this);

        return components;
    }

    public void setComponents(List<TimeseriesComponentProperty> components) {
        this.components = asChild(components);
    }

    public List<ADEPropertyOfCompositeTimeseries> getADEPropertiesOfCompositeTimeseries() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfCompositeTimeseries(List<ADEPropertyOfCompositeTimeseries> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
