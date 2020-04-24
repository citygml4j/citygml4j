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
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.AbstractArrayProperty;
import org.xmlobjects.gml.model.base.AbstractInlineOrByReferenceProperty;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

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

    }

    protected final void updateGeometryInfo(ADEProperty<?> property, GeometryInfo geometryInfo) {

    }
}
