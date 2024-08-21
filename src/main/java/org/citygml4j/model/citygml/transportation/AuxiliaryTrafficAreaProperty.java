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
package org.citygml4j.model.citygml.transportation;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.feature.FeatureProperty;

public class AuxiliaryTrafficAreaProperty extends FeatureProperty<AuxiliaryTrafficArea> implements TransportationModuleComponent {

    public AuxiliaryTrafficAreaProperty() {

    }

    public AuxiliaryTrafficAreaProperty(AuxiliaryTrafficArea auxiliaryTrafficArea) {
        super(auxiliaryTrafficArea);
    }

    public AuxiliaryTrafficAreaProperty(String href) {
        super(href);
    }

    public AuxiliaryTrafficArea getAuxiliaryTrafficArea() {
        return super.getObject();
    }

    public boolean isSetAuxiliaryTrafficArea() {
        return super.isSetObject();
    }

    public void setAuxiliaryTrafficArea(AuxiliaryTrafficArea auxiliaryTrafficArea) {
        super.setObject(auxiliaryTrafficArea);
    }

    public void unsetAuxiliaryTrafficArea() {
        super.unsetObject();
    }

    public CityGMLClass getCityGMLClass() {
        return CityGMLClass.AUXILIARY_TRAFFIC_AREA_PROPERTY;
    }

    @Override
    public Class<AuxiliaryTrafficArea> getAssociableClass() {
        return AuxiliaryTrafficArea.class;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new AuxiliaryTrafficAreaProperty(), copyBuilder);
    }

    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        AuxiliaryTrafficAreaProperty copy = (target == null) ? new AuxiliaryTrafficAreaProperty() : (AuxiliaryTrafficAreaProperty) target;
        return super.copyTo(copy, copyBuilder);
    }

}
