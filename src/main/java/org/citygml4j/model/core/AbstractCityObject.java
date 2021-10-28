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

package org.citygml4j.model.core;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractCityObject extends AbstractFeatureWithLifespan {
    private List<ExternalReferenceProperty> externalReferences;
    private List<Reference> generalizesTo;
    private RelativeToTerrain relativeToTerrain;
    private RelativeToWater relativeToWater;
    private List<CityObjectRelationProperty> relatedTo;
    private List<AbstractAppearanceProperty> appearances;
    private List<AbstractGenericAttributeProperty> genericAttributes;
    private List<AbstractDynamizerProperty> dynamizers;
    private List<ADEOfAbstractCityObject> adeOfAbstractCityObject;

    public List<ExternalReferenceProperty> getExternalReferences() {
        if (externalReferences == null)
            externalReferences = new ChildList<>(this);

        return externalReferences;
    }

    public void setExternalReferences(List<ExternalReferenceProperty> externalReferences) {
        this.externalReferences = asChild(externalReferences);
    }

    public List<Reference> getGeneralizesTo() {
        if (generalizesTo == null)
            generalizesTo = new ChildList<>(this);

        return generalizesTo;
    }

    public void setGeneralizesTo(List<Reference> generalizesTo) {
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

    public void setRelatedTo(List<CityObjectRelationProperty> relatedTo) {
        this.relatedTo = asChild(relatedTo);
    }

    public List<AbstractAppearanceProperty> getAppearances() {
        if (appearances == null)
            appearances = new ChildList<>(this);

        return appearances;
    }

    public void setAppearances(List<AbstractAppearanceProperty> appearances) {
        this.appearances = asChild(appearances);
    }

    public List<AbstractGenericAttributeProperty> getGenericAttributes() {
        if (genericAttributes == null)
            genericAttributes = new ChildList<>(this);

        return genericAttributes;
    }

    public void setGenericAttributes(List<AbstractGenericAttributeProperty> genericAttributes) {
        this.genericAttributes = asChild(genericAttributes);
    }

    public List<AbstractDynamizerProperty> getDynamizers() {
        if (dynamizers == null)
            dynamizers = new ChildList<>(this);

        return dynamizers;
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

    public List<ADEOfAbstractCityObject> getADEOfAbstractCityObject() {
        if (adeOfAbstractCityObject == null)
            adeOfAbstractCityObject = new ChildList<>(this);

        return adeOfAbstractCityObject;
    }

    public void setADEOfAbstractCityObject(List<ADEOfAbstractCityObject> adeOfAbstractCityObject) {
        this.adeOfAbstractCityObject = asChild(adeOfAbstractCityObject);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfAbstractCityObject != null) {
            for (ADEOfAbstractCityObject container : adeOfAbstractCityObject)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfAbstractCityObject != null) {
            for (ADEOfAbstractCityObject container : adeOfAbstractCityObject)
                updateGeometryInfo(container, geometryInfo);
        }
    }
}
