/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.dynamizer;

import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class CompositeTimeseries extends AbstractTimeseries {
    private List<TimeseriesComponentProperty> components;

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

    public boolean isSetComponents() {
        return components != null && !components.isEmpty();
    }

    public void setComponents(List<TimeseriesComponentProperty> components) {
        this.components = asChild(components);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
