/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.model.building;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BuildingUnit extends AbstractBuildingSubdivision {
    private List<Reference> storeys;
    private List<AddressProperty> addresses;
    private List<ADEOfBuildingUnit> adeOfBuildingUnit;

    public List<Reference> getStoreys() {
        if (storeys == null)
            storeys = new ChildList<>(this);

        return storeys;
    }

    public void setStoreys(List<Reference> storeys) {
        this.storeys = asChild(storeys);
    }

    public List<AddressProperty> getAddresses() {
        if (addresses == null)
            addresses = new ChildList<>(this);

        return addresses;
    }

    public void setAddresses(List<AddressProperty> addresses) {
        this.addresses = asChild(addresses);
    }

    public List<ADEOfBuildingUnit> getADEOfBuildingUnit() {
        if (adeOfBuildingUnit == null)
            adeOfBuildingUnit = new ChildList<>(this);

        return adeOfBuildingUnit;
    }

    public void setADEOfBuildingUnit(List<ADEOfBuildingUnit> adeOfBuildingUnit) {
        this.adeOfBuildingUnit = asChild(adeOfBuildingUnit);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfBuildingUnit != null) {
            for (ADEOfBuildingUnit container : adeOfBuildingUnit)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfBuildingUnit != null) {
            for (ADEOfBuildingUnit container : adeOfBuildingUnit)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
