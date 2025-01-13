/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.citygml.tunnel;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.feature.FeatureProperty;

public class IntTunnelInstallationProperty extends FeatureProperty<IntTunnelInstallation> implements TunnelModuleComponent {

    public IntTunnelInstallationProperty() {

    }

    public IntTunnelInstallationProperty(IntTunnelInstallation intTunnelInstallation) {
        super(intTunnelInstallation);
    }

    public IntTunnelInstallationProperty(String href) {
        super(href);
    }

    public IntTunnelInstallation getIntTunnelInstallation() {
        return super.getObject();
    }

    public boolean isSetIntTunnelInstallation() {
        return super.isSetObject();
    }

    public void setIntTunnelInstallation(IntTunnelInstallation intTunnelInstallation) {
        super.setObject(intTunnelInstallation);
    }

    public void unsetIntTunnelInstallation() {
        super.unsetObject();
    }

    public CityGMLClass getCityGMLClass() {
        return CityGMLClass.INT_TUNNEL_INSTALLATION_PROPERTY;
    }

    @Override
    public Class<IntTunnelInstallation> getAssociableClass() {
        return IntTunnelInstallation.class;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new IntTunnelInstallationProperty(), copyBuilder);
    }

    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        IntTunnelInstallationProperty copy = (target == null) ? new IntTunnelInstallationProperty() : (IntTunnelInstallationProperty) target;
        return super.copyTo(copy, copyBuilder);
    }

}
