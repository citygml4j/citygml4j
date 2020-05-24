package org.citygml4j.model.dynamizer;

import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class CompositeTimeseries extends AbstractTimeseries {
    private List<TimeseriesComponentProperty> components;
    private List<ADEOfCompositeTimeseries> adeOfCompositeTimeseries;

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

    public List<ADEOfCompositeTimeseries> getADEOfCompositeTimeseries() {
        if (adeOfCompositeTimeseries == null)
            adeOfCompositeTimeseries = new ChildList<>(this);

        return adeOfCompositeTimeseries;
    }

    public void setADEOfCompositeTimeseries(List<ADEOfCompositeTimeseries> adeOfCompositeTimeseries) {
        this.adeOfCompositeTimeseries = asChild(adeOfCompositeTimeseries);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
