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
package org.citygml4j.model.citygml.relief;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.primitives.TriangulatedSurface;

public class TinProperty extends GeometryProperty<TriangulatedSurface> implements ReliefModuleComponent {

    public TinProperty() {

    }

    public TinProperty(TriangulatedSurface triangulatedSurface) {
        super(triangulatedSurface);
    }

    public TinProperty(String href) {
        super(href);
    }

    public TriangulatedSurface getTriangulatedSurface() {
        return super.getObject();
    }

    public boolean isSetTriangulatedSurface() {
        return super.isSetObject();
    }

    public void setTriangulatedSurface(TriangulatedSurface triangulatedSurface) {
        super.setObject(triangulatedSurface);
    }

    public void unsetTriangulatedSurface() {
        super.unsetObject();
    }

    public CityGMLClass getCityGMLClass() {
        return CityGMLClass.TIN_PROPERTY;
    }

    @Override
    public Class<TriangulatedSurface> getAssociableClass() {
        return TriangulatedSurface.class;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new TinProperty(), copyBuilder);
    }

    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        TinProperty copy = (target == null) ? new TinProperty() : (TinProperty) target;
        return super.copyTo(copy, copyBuilder);
    }

}
