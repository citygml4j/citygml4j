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

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.model.ade.ADEObject;
import org.citygml4j.model.ade.ADEProperty;
import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.common.LevelOfDetail;
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public abstract class AbstractFeature extends org.xmlobjects.gml.model.feature.AbstractFeature implements CityGMLObject, Visitable {
    private List<ADEPropertyOfAbstractFeature<?>> adeProperties;

    public List<ADEPropertyOfAbstractFeature<?>> getADEPropertiesOfAbstractFeature() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractFeature(List<ADEPropertyOfAbstractFeature<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        if (this instanceof ADEObject) {
            try {
                getClass().getDeclaredMethod("updateEnvelope", Envelope.class, EnvelopeOptions.class);
            } catch (NoSuchMethodException e) {
                // update the envelope in a generic way
                ADEEnvelopeBuilder.updateEnvelope(this, envelope, options, Collections.newSetFromMap(new IdentityHashMap<>()));
            }
        }

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractFeature<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    protected final void updateEnvelope(ADEProperty<?> property, Envelope envelope, EnvelopeOptions options) {
        ADEEnvelopeBuilder.updateEnvelope(property.getValue(), envelope, options, Collections.newSetFromMap(new IdentityHashMap<>()));
    }

    public final GeometryInfo getGeometryInfo() {
        GeometryInfo geometryInfo = new GeometryInfo();
        updateGeometryInfo(geometryInfo);

        return geometryInfo;
    }

    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        if (this instanceof ADEObject) {
            try {
                getClass().getDeclaredMethod("updateGeometryInfo", GeometryInfo.class);
            } catch (NoSuchMethodException e) {
                // update the geometry info in a generic way
                ADEGeometryInfoBuilder.updateGeometryInfo(this, geometryInfo);
            }
        }

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractFeature<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    protected final void updateGeometryInfo(ADEProperty<?> property, GeometryInfo geometryInfo) {
        LevelOfDetail lod = property.getClass().isAnnotationPresent(LevelOfDetail.class) ?
                property.getClass().getAnnotation(LevelOfDetail.class) :
                null;

        ADEGeometryInfoBuilder.updateGeometryInfo(property.getValue(), lod, "", geometryInfo);
    }
}
