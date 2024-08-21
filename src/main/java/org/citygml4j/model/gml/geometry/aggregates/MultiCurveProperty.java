/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.gml.geometry.aggregates;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class MultiCurveProperty extends GeometryProperty<MultiCurve> {

    public MultiCurveProperty() {

    }

    public MultiCurveProperty(MultiCurve multiCurve) {
        super(multiCurve);
    }

    public MultiCurveProperty(String href) {
        super(href);
    }

    public MultiCurve getMultiCurve() {
        return super.getGeometry();
    }

    public boolean isSetMultiCurve() {
        return super.isSetGeometry();
    }

    public void setMultiCurve(MultiCurve multiCurve) {
        super.setGeometry(multiCurve);
    }

    public void unsetMultiCurve() {
        super.unsetGeometry();
    }

    public GMLClass getGMLClass() {
        return GMLClass.MULTI_CURVE_PROPERTY;
    }

    @Override
    public Class<MultiCurve> getAssociableClass() {
        return MultiCurve.class;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new MultiCurveProperty(), copyBuilder);
    }

    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        MultiCurveProperty copy = (target == null) ? new MultiCurveProperty() : (MultiCurveProperty) target;
        return super.copyTo(copy, copyBuilder);
    }

}
