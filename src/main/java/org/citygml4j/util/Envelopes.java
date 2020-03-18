package org.citygml4j.util;

import org.citygml4j.model.ade.ADEObject;
import org.citygml4j.model.ade.ADEProperty;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.AbstractArrayProperty;
import org.xmlobjects.gml.model.base.AbstractInlineOrByReferenceProperty;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public class Envelopes {

    public static void updateEnvelope(ADEObject object, Envelope envelope, EnvelopeOptions options) {
        updateEnvelope(((ADEProperty<?>) object).getValue(), envelope, options, Collections.newSetFromMap(new IdentityHashMap<>()));
    }

    private static void updateEnvelope(Object object, Envelope envelope, EnvelopeOptions options, Set<Object> visited) {
        if (!visited.add(object))
            return;

        if (object instanceof AbstractGeometry)
            envelope.include(((AbstractGeometry) object).computeEnvelope());
        else if (object instanceof AbstractFeature)
            envelope.include(((AbstractFeature) object).computeEnvelope(options));
        else if (object instanceof AbstractArrayProperty<?>)
            ((AbstractArrayProperty<?>) object).getObjects().forEach(v -> updateEnvelope(v, envelope, options, visited));
        else if (object instanceof AbstractInlineOrByReferenceProperty<?>)
            updateEnvelope(((AbstractInlineOrByReferenceProperty<?>) object).getObject(), envelope, options, visited);
        else if (object instanceof AbstractInlineProperty<?>)
            updateEnvelope(((AbstractInlineProperty<?>) object).getObject(), envelope, options, visited);
        else if (object instanceof Collection<?>)
            ((Collection<?>) object).forEach(v -> updateEnvelope(v, envelope, options, visited));
        else if (object instanceof Object[])
            Arrays.stream(((Object[]) object)).forEach(v -> updateEnvelope(v, envelope, options, visited));
        else if (object instanceof GMLObject) {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    updateEnvelope(field.get(object), envelope, options, visited);
                } catch (Throwable e) {
                    //
                }
            }
        }
    }
}
