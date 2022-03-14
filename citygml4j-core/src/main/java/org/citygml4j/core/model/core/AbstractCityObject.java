/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractCityObject extends AbstractFeatureWithLifespan {
    private List<ExternalReferenceProperty> externalReferences;
    private List<AbstractCityObjectReference> generalizesTo;
    private RelativeToTerrain relativeToTerrain;
    private RelativeToWater relativeToWater;
    private List<CityObjectRelationProperty> relatedTo;
    private List<AbstractAppearanceProperty> appearances;
    private List<AbstractGenericAttributeProperty> genericAttributes;
    private List<AbstractDynamizerProperty> dynamizers;

    public List<ExternalReferenceProperty> getExternalReferences() {
        if (externalReferences == null)
            externalReferences = new ChildList<>(this);

        return externalReferences;
    }

    public boolean isSetExternalReferences() {
        return externalReferences != null && !externalReferences.isEmpty();
    }

    public void setExternalReferences(List<ExternalReferenceProperty> externalReferences) {
        this.externalReferences = asChild(externalReferences);
    }

    public List<AbstractCityObjectReference> getGeneralizesTo() {
        if (generalizesTo == null)
            generalizesTo = new ChildList<>(this);

        return generalizesTo;
    }

    public boolean isSetGeneralizesTo() {
        return generalizesTo != null && !generalizesTo.isEmpty();
    }

    public void setGeneralizesTo(List<AbstractCityObjectReference> generalizesTo) {
        this.generalizesTo = asChild(generalizesTo);
    }

    public RelativeToTerrain getRelativeToTerrain() {
        return relativeToTerrain;
    }

    public void setRelativeToTerrain(RelativeToTerrain relativeToTerrain) {
        this.relativeToTerrain = relativeToTerrain;
    }

    public RelativeToWater getRelativeToWater() {
        return relativeToWater;
    }

    public void setRelativeToWater(RelativeToWater relativeToWater) {
        this.relativeToWater = relativeToWater;
    }

    public List<CityObjectRelationProperty> getRelatedTo() {
        if (relatedTo == null)
            relatedTo = new ChildList<>(this);

        return relatedTo;
    }

    public boolean isSetRelatedTo() {
        return relatedTo != null && !relatedTo.isEmpty();
    }

    public void setRelatedTo(List<CityObjectRelationProperty> relatedTo) {
        this.relatedTo = asChild(relatedTo);
    }

    public List<AbstractAppearanceProperty> getAppearances() {
        if (appearances == null)
            appearances = new ChildList<>(this);

        return appearances;
    }

    public boolean isSetAppearances() {
        return appearances != null && !appearances.isEmpty();
    }

    public void setAppearances(List<AbstractAppearanceProperty> appearances) {
        this.appearances = asChild(appearances);
    }

    public List<AbstractGenericAttributeProperty> getGenericAttributes() {
        if (genericAttributes == null)
            genericAttributes = new ChildList<>(this);

        return genericAttributes;
    }

    public boolean isSetGenericAttributes() {
        return genericAttributes != null && !genericAttributes.isEmpty();
    }

    public void setGenericAttributes(List<AbstractGenericAttributeProperty> genericAttributes) {
        this.genericAttributes = asChild(genericAttributes);
    }

    public List<AbstractDynamizerProperty> getDynamizers() {
        if (dynamizers == null)
            dynamizers = new ChildList<>(this);

        return dynamizers;
    }

    public boolean isSetDynamizers() {
        return dynamizers != null && !dynamizers.isEmpty();
    }

    public void setDynamizers(List<AbstractDynamizerProperty> dynamizers) {
        this.dynamizers = asChild(dynamizers);
    }

    @Override
    public DeprecatedPropertiesOfAbstractCityObject getDeprecatedProperties() {
        return (DeprecatedPropertiesOfAbstractCityObject) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfAbstractCityObject createDeprecatedProperties() {
        return new DeprecatedPropertiesOfAbstractCityObject();
    }
}
