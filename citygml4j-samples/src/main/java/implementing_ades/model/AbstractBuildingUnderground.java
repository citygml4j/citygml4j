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

package implementing_ades.model;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.common.LevelOfDetail;
import org.citygml4j.core.model.core.AbstractOccupiedSpace;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;
import org.citygml4j.core.model.core.AddressProperty;
import org.citygml4j.core.model.core.StandardObjectClassifier;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractBuildingUnderground extends AbstractOccupiedSpace implements StandardObjectClassifier, ADEObject {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<EnergyPerformanceCertificationProperty> energyPerformanceCertifications;
    @LevelOfDetail(0)
    private GeometryProperty<?> lod0GenericGeometry;
    private List<AddressProperty> addresses;
    private List<FacilityProperty> equippedWith;

    @Override
    public boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type) {
        return false;
    }

    @Override
    public Code getClassifier() {
        return classifier;
    }

    @Override
    public void setClassifier(Code classifier) {
        this.classifier = asChild(classifier);
    }

    @Override
    public List<Code> getFunctions() {
        if (functions == null) {
            functions = new ChildList<>(this);
        }

        return functions;
    }

    @Override
    public boolean isSetFunctions() {
        return functions != null && !functions.isEmpty();
    }

    @Override
    public void setFunctions(List<Code> functions) {
        this.functions = asChild(functions);
    }

    @Override
    public List<Code> getUsages() {
        if (usages == null) {
            usages = new ChildList<>(this);
        }

        return usages;
    }

    @Override
    public boolean isSetUsages() {
        return usages != null && !usages.isEmpty();
    }

    @Override
    public void setUsages(List<Code> usages) {
        this.usages = asChild(usages);
    }

    public List<EnergyPerformanceCertificationProperty> getEnergyPerformanceCertifications() {
        if (energyPerformanceCertifications == null) {
            energyPerformanceCertifications = new ChildList<>(this);
        }

        return energyPerformanceCertifications;
    }

    public boolean isSetEnergyPerformanceCertifications() {
        return energyPerformanceCertifications != null && !energyPerformanceCertifications.isEmpty();
    }

    public void setEnergyPerformanceCertifications(List<EnergyPerformanceCertificationProperty> energyPerformanceCertifications) {
        this.energyPerformanceCertifications = asChild(energyPerformanceCertifications);
    }

    public GeometryProperty<?> getLod0GenericGeometry() {
        return lod0GenericGeometry;
    }

    public void setLod0GenericGeometry(GeometryProperty<?> lod0GenericGeometry) {
        this.lod0GenericGeometry = asChild(lod0GenericGeometry);
    }

    public List<AddressProperty> getAddresses() {
        if (addresses == null) {
            addresses = new ChildList<>(this);
        }

        return addresses;
    }

    public boolean isSetAddresses() {
        return addresses != null && !addresses.isEmpty();
    }

    public void setAddresses(List<AddressProperty> addresses) {
        this.addresses = asChild(addresses);
    }

    public List<FacilityProperty> getEquippedWith() {
        if (equippedWith == null) {
            equippedWith = new ChildList<>(this);
        }

        return equippedWith;
    }

    public boolean isSetEquippedWith() {
        return equippedWith != null && !equippedWith.isEmpty();
    }

    public void setEquippedWith(List<FacilityProperty> equippedWith) {
        this.equippedWith = asChild(equippedWith);
    }
}
