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
import org.citygml4j.model.common.Property;
import org.citygml4j.util.CityGMLPatterns;
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.AbstractArrayProperty;
import org.xmlobjects.gml.model.base.AbstractInlineOrByReferenceProperty;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;

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
                // update the envelope in a generic way if the ADE object does not implement updateEnvelope
                updateEnvelope(this, envelope, options, Collections.newSetFromMap(new IdentityHashMap<>()));
            }
        }

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractFeature<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    protected final void updateEnvelope(ADEProperty<?> property, Envelope envelope, EnvelopeOptions options) {
        updateEnvelope(property.getValue(), envelope, options, Collections.newSetFromMap(new IdentityHashMap<>()));
    }

    private void updateEnvelope(GMLObject object, Envelope envelope, EnvelopeOptions options, Set<Object> visited) {
        Class<?> type = object.getClass();

        do {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(object);
                    if (value != null)
                        updateEnvelope(value, envelope, options, visited);
                } catch (Throwable e) {
                    //
                }
            }
        } while ((type = type.getSuperclass()) != Object.class && ADEObject.class.isAssignableFrom(type));
    }

    private void updateEnvelope(Object object, Envelope envelope, EnvelopeOptions options, Set<Object> visited) {
        if (!visited.add(object))
            return;

        if (object instanceof AbstractGeometry)
            envelope.include(((AbstractGeometry) object).computeEnvelope());
        else if (object instanceof org.xmlobjects.gml.model.feature.AbstractFeature)
            envelope.include(((org.xmlobjects.gml.model.feature.AbstractFeature) object).computeEnvelope(options));
        else if (object instanceof AbstractArrayProperty<?>)
            ((AbstractArrayProperty<?>) object).getObjects().forEach(v -> updateEnvelope(v, envelope, options, visited));
        else if (object instanceof AbstractInlineOrByReferenceProperty<?>)
            updateEnvelope(((AbstractInlineOrByReferenceProperty<?>) object).getObject(), envelope, options, visited);
        else if (object instanceof AbstractInlineProperty<?>)
            updateEnvelope(((AbstractInlineProperty<?>) object).getObject(), envelope, options, visited);
        else if (object instanceof ADEProperty<?>)
            updateEnvelope(((ADEProperty<?>) object).getValue(), envelope, options, visited);
        else if (object instanceof GMLObject)
            updateEnvelope((GMLObject) object, envelope, options, visited);
        else if (object instanceof Collection<?>)
            ((Collection<?>) object).forEach(v -> updateEnvelope(v, envelope, options, visited));
        else if (object instanceof Object[])
            Arrays.stream(((Object[]) object)).forEach(v -> updateEnvelope(v, envelope, options, visited));
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
                // update the geometry info in a generic way if the ADE object does not implement updateGeometryInfo
                updateGeometryInfo(this, geometryInfo);
            }
        }

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractFeature<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    protected final void updateGeometryInfo(ADEProperty<?> property, GeometryInfo geometryInfo) {
        updateGeometryInfo(property.getValue(),
                property.getClass().isAnnotationPresent(Property.class) ? property.getClass().getAnnotation(Property.class) : null,
                "",
                geometryInfo);
    }

    private void updateGeometryInfo(GMLObject object, GeometryInfo geometryInfo) {
        Class<?> type = object.getClass();

        do {
            Field[] fields = type.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    updateGeometryInfo(field.get(object),
                            field.isAnnotationPresent(Property.class) ? field.getAnnotation(Property.class) : null,
                            field.getName(),
                            geometryInfo);
                } catch (Throwable e) {
                    //
                }
            }
        } while ((type = type.getSuperclass()) != Object.class && ADEObject.class.isAssignableFrom(type));
    }

    private void updateGeometryInfo(Object object, Property property, String name, GeometryInfo geometryInfo) {
        if (object instanceof GeometryProperty<?>)
            geometryInfo.addGeometry(getLodFromProperty(property, name), (GeometryProperty<?>) object);
        else if (object instanceof ImplicitGeometryProperty)
            geometryInfo.addImplicitGeometry(getLodFromProperty(property, name), (ImplicitGeometryProperty) object);
        else if (object instanceof Collection<?>)
            ((Collection<?>) object).forEach(v -> updateGeometryInfo(v, property, name, geometryInfo));
        else if (object instanceof Map<?, ?>)
            ((Map<?, ?>) object).values().forEach(v -> updateGeometryInfo(v, property, name, geometryInfo));
        else if (object instanceof Object[])
            Arrays.stream(((Object[]) object)).forEach(v -> updateGeometryInfo(v, property, name, geometryInfo));
    }

    private int getLodFromProperty(Property property, String fieldName) {
        if (property != null && property.lod() != Integer.MIN_VALUE)
            return property.lod();
        else {
            String propertyName = property != null && !property.name().isEmpty() ? property.name() : fieldName;
            Matcher matcher = CityGMLPatterns.LOD_FROM_PROPERTY_NAME.matcher(propertyName);
            if (matcher.matches()) {
                try {
                    return Integer.parseInt(matcher.group(1));
                } catch (NumberFormatException e) {
                    //
                }
            }

            return Integer.MIN_VALUE;
        }
    }
}
