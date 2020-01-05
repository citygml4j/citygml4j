package org.citygml4j.util;

import org.citygml4j.model.ade.ADEObject;
import org.citygml4j.model.ade.ADEProperty;
import org.xmlobjects.gml.model.base.AbstractArrayProperty;
import org.xmlobjects.gml.model.base.AbstractInlineOrByReferenceProperty;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

public class Envelopes {

    public static void updateEnvelope(ADEObject object, Envelope envelope, EnvelopeOptions options) {
        if (object instanceof ADEProperty<?>)
            updateEnvelope(((ADEProperty<?>) object).getValue(), envelope, options);
        else {
            Method method = null;
            try {
                method = object.getClass().getDeclaredMethod("updateEnvelope", Envelope.class, EnvelopeOptions.class);
            } catch (NoSuchMethodException e) {
                //
            }

            if (method == null) {
                Field[] fields = object.getClass().getDeclaredFields();
                for (Field field : fields) {
                    try {
                        field.setAccessible(true);
                        updateEnvelope(field.get(object), envelope, options);
                    } catch (Throwable e) {
                        //
                    }
                }
            }
        }
    }

    private static void updateEnvelope(Object object, Envelope envelope, EnvelopeOptions options) {
        if (object instanceof AbstractGeometry)
            envelope.include(((AbstractGeometry) object).computeEnvelope());
        else if (object instanceof AbstractFeature)
            envelope.include(((AbstractFeature) object).computeEnvelope(options));
        else if (object instanceof AbstractArrayProperty<?>)
            ((AbstractArrayProperty<?>) object).getObjects().forEach(v -> updateEnvelope(v, envelope, options));
        else if (object instanceof AbstractInlineOrByReferenceProperty<?>)
            updateEnvelope(((AbstractInlineOrByReferenceProperty<?>) object).getObject(), envelope, options);
        else if (object instanceof AbstractInlineProperty<?>)
            updateEnvelope(((AbstractInlineProperty<?>) object).getObject(), envelope, options);
        else if (object instanceof Collection<?>)
            ((Collection<?>) object).forEach(v -> updateEnvelope(v, envelope, options));
        else if (object instanceof Object[])
            Arrays.stream(((Object[]) object)).forEach(v -> updateEnvelope(v, envelope, options));
    }
}
