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

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.ade.ADEProperty;
import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.model.deprecated.DeprecatedProperties;
import org.citygml4j.core.model.deprecated.core.DeprecatedPropertiesOfAbstractFeature;
import org.citygml4j.core.visitor.ObjectWalker;
import org.citygml4j.core.visitor.VisitableObject;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractFeature extends org.xmlobjects.gml.model.feature.AbstractFeature implements CityGMLObject, VisitableObject {
    private DeprecatedPropertiesOfAbstractFeature deprecatedProperties;
    private List<ADEProperty> adeProperties;

    public DeprecatedPropertiesOfAbstractFeature getDeprecatedProperties() {
        return getDeprecatedProperties(DeprecatedPropertiesOfAbstractFeature.class);
    }

    protected <T extends DeprecatedProperties> T getDeprecatedProperties(Class<T> type) {
        if (!type.isInstance(deprecatedProperties)) {
            deprecatedProperties = asChild(createDeprecatedProperties());
        }

        return type.cast(deprecatedProperties);
    }

    public boolean hasDeprecatedProperties() {
        return deprecatedProperties != null;
    }

    protected DeprecatedPropertiesOfAbstractFeature createDeprecatedProperties() {
        return new DeprecatedPropertiesOfAbstractFeature();
    }

    public boolean hasADEProperties() {
        return adeProperties != null && !adeProperties.isEmpty();
    }

    public boolean isValidADEProperty(ADEProperty adeProperty) {
        return adeProperty != null && adeProperty.getTargetType().isInstance(this);
    }

    public List<ADEProperty> getADEProperties() {
        if (adeProperties == null) {
            adeProperties = new ChildList<>(this);
        }

        return adeProperties;
    }

    public <T extends ADEProperty> List<T> getADEProperties(Class<T> type) {
        return hasADEProperties() ?
                adeProperties.stream().filter(type::isInstance).map(type::cast).collect(Collectors.toList()) :
                Collections.emptyList();
    }

    public void setADEProperties(List<ADEProperty> adeProperties) {
        this.adeProperties = asChild(adeProperties);
        if (this.adeProperties != null) {
            this.adeProperties.removeIf(adeProperty -> !isValidADEProperty(adeProperty));
        }
    }

    public void addADEProperty(ADEProperty property) {
        if (isValidADEProperty(property)) {
            getADEProperties().add(property);
        }
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
            for (ADEProperty property : adeProperties) {
                updateEnvelope(property, envelope, options);
            }
        }
    }

    protected final void updateEnvelope(ADEProperty property, Envelope envelope, EnvelopeOptions options) {
        ADEEnvelopeBuilder.updateEnvelope(property, envelope, options, Collections.newSetFromMap(new IdentityHashMap<>()));
    }

    public final GeometryInfo getGeometryInfo() {
        return getGeometryInfo(false);
    }

    public final GeometryInfo getGeometryInfo(boolean includeNestedFeatures) {
        GeometryInfo geometryInfo = new GeometryInfo();

        if (!includeNestedFeatures) {
            updateGeometryInfo(geometryInfo);
        } else {
            accept(new ObjectWalker() {
                @Override
                public void visit(AbstractFeature feature) {
                    feature.updateGeometryInfo(geometryInfo);
                }
            });
        }

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
            for (ADEProperty property : adeProperties) {
                updateGeometryInfo(property, geometryInfo);
            }
        }
    }

    protected final void updateGeometryInfo(ADEProperty property, GeometryInfo geometryInfo) {
        try {
            property.getClass().getDeclaredMethod("updateGeometryInfo", GeometryInfo.class)
                    .invoke(property, geometryInfo);
        } catch (Exception e) {
            ADEGeometryInfoBuilder.updateGeometryInfo(property, geometryInfo);
        }
    }
}
