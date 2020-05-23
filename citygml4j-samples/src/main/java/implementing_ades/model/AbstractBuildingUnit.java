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

package implementing_ades.model;

import org.citygml4j.model.ade.ADEObject;
import org.citygml4j.model.common.LevelOfDetail;
import org.citygml4j.model.core.AbstractLogicalSpace;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractBuildingUnit extends AbstractLogicalSpace implements StandardObjectClassifier, ADEObject {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<EnergyPerformanceCertificationProperty> energyPerformanceCertifications;
    @LevelOfDetail(value = 4)
    private SolidProperty lod4Solid;
    @LevelOfDetail(value = 1)
    private MultiSurfaceProperty lod1MultiSurface;
    @LevelOfDetail(value = 4)
    private MultiSurfaceProperty lod4MultiSurface;
    @LevelOfDetail(value = 4)
    private MultiCurveProperty lod4MultiCurve;
    private List<AddressProperty> addresses;
    private List<FacilitiesProperty> equippedWith;
    private List<BuildingUnitPartProperty> consistsOf;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
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
        if (functions == null)
            functions = new ChildList<>(this);

        return functions;
    }

    @Override
    public void setFunctions(List<Code> functions) {
        this.functions = asChild(functions);
    }

    @Override
    public List<Code> getUsages() {
        if (usages == null)
            usages = new ChildList<>(this);

        return usages;
    }

    @Override
    public void setUsages(List<Code> usages) {
        this.usages = asChild(usages);
    }

    public List<EnergyPerformanceCertificationProperty> getEnergyPerformanceCertifications() {
        if (energyPerformanceCertifications == null)
            energyPerformanceCertifications = new ChildList<>(this);

        return energyPerformanceCertifications;
    }

    public void setEnergyPerformanceCertifications(List<EnergyPerformanceCertificationProperty> energyPerformanceCertifications) {
        this.energyPerformanceCertifications = asChild(energyPerformanceCertifications);
    }

    public SolidProperty getLod4Solid() {
        return lod4Solid;
    }

    public void setLod4Solid(SolidProperty lod4Solid) {
        this.lod4Solid = asChild(lod4Solid);
    }

    public MultiSurfaceProperty getLod1MultiSurface() {
        return lod1MultiSurface;
    }

    public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
        this.lod1MultiSurface = asChild(lod1MultiSurface);
    }

    public MultiSurfaceProperty getLod4MultiSurface() {
        return lod4MultiSurface;
    }

    public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
        this.lod4MultiSurface = asChild(lod4MultiSurface);
    }

    public MultiCurveProperty getLod4MultiCurve() {
        return lod4MultiCurve;
    }

    public void setLod4MultiCurve(MultiCurveProperty lod4MultiCurve) {
        this.lod4MultiCurve = asChild(lod4MultiCurve);
    }

    public List<AddressProperty> getAddresses() {
        if (addresses == null)
            addresses = new ChildList<>(this);

        return addresses;
    }

    public void setAddresses(List<AddressProperty> addresses) {
        this.addresses = asChild(addresses);
    }

    public List<FacilitiesProperty> getEquippedWith() {
        if (equippedWith == null)
            equippedWith = new ChildList<>(this);

        return equippedWith;
    }

    public void setEquippedWith(List<FacilitiesProperty> equippedWith) {
        this.equippedWith = equippedWith;
    }

    public List<BuildingUnitPartProperty> getConsistsOf() {
        if (consistsOf == null)
            consistsOf = new ChildList<>(this);

        return consistsOf;
    }

    public void setConsistsOf(List<BuildingUnitPartProperty> consistsOf) {
        this.consistsOf = consistsOf;
    }
}
