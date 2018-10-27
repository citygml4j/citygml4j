/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.model.gml.basicTypes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

import java.util.ArrayList;
import java.util.List;

public class MeasureList implements GML, Child, Copyable {
    private List<Double> value;
    private String uom;
    private ModelObject parent;

    public void addValue(Double value) {
        if (this.value == null)
            this.value = new ArrayList<>();

        this.value.add(value);
    }

    public void addValue(List<Double> value) {
        if (this.value == null)
            this.value = new ArrayList<>();

        this.value.addAll(value);
    }

    public List<Double> getValue() {
        if (value == null)
            value = new ArrayList<>();

        return value;
    }

    public boolean isSetValue() {
        return value != null && !value.isEmpty();
    }

    public void setValue(List<Double> value) {
        this.value = value;
    }

    public void unsetValue() {
        value = null;
    }

    public String getUom() {
        return uom;
    }

    public boolean isSetUom() {
        return uom != null;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public void unsetUom() {
        uom = null;
    }

    @Override
    public GMLClass getGMLClass() {
        return GMLClass.MEASURE_LIST;
    }

    @Override
    public ModelObject getParent() {
        return parent;
    }

    @Override
    public boolean isSetParent() {
        return parent != null;
    }

    @Override
    public void setParent(ModelObject parent) {
        this.parent = parent;
    }

    @Override
    public void unsetParent() {
        parent = null;
    }

    @Override
    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new MeasureList(), copyBuilder);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        MeasureList copy = (target == null) ? new MeasureList() : (MeasureList)target;

        if (isSetValue())
            copy.setValue((List<Double>)copyBuilder.copy(value));

        if (isSetUom())
            copy.setUom(copyBuilder.copy(uom));

        copy.unsetParent();
        return copy;
    }
}
