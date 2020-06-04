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
import org.citygml4j.model.ade.ADEContainer;
import org.citygml4j.model.ade.ADEObject;
import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public abstract class AbstractFeature extends org.xmlobjects.gml.model.feature.AbstractFeature implements CityGMLObject, Visitable {
    private List<ADEOfAbstractFeature> adeOfAbstractFeature;

    public List<ADEOfAbstractFeature> getADEOfAbstractFeature() {
        if (adeOfAbstractFeature == null)
            adeOfAbstractFeature = new ChildList<>(this);

        return adeOfAbstractFeature;
    }

    public void setADEOfAbstractFeature(List<ADEOfAbstractFeature> adeOfAbstractFeature) {
        this.adeOfAbstractFeature = asChild(adeOfAbstractFeature);
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

        if (adeOfAbstractFeature != null) {
            for (ADEOfAbstractFeature container : adeOfAbstractFeature)
                updateEnvelope(container, envelope, options);
        }
    }

    protected final void updateEnvelope(ADEContainer container, Envelope envelope, EnvelopeOptions options) {
        ADEEnvelopeBuilder.updateEnvelope(container, envelope, options, Collections.newSetFromMap(new IdentityHashMap<>()));
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

        if (adeOfAbstractFeature != null) {
            for (ADEOfAbstractFeature container : adeOfAbstractFeature)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    protected final void updateGeometryInfo(ADEContainer container, GeometryInfo geometryInfo) {
        ADEGeometryInfoBuilder.updateGeometryInfo(container, geometryInfo);
    }
}
