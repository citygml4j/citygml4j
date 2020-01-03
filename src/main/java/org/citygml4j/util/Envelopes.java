package org.citygml4j.util;

import org.citygml4j.model.appearance.Appearance;
import org.citygml4j.visitor.ObjectWalker;
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;

import java.util.HashSet;
import java.util.Set;

public class Envelopes {

    public static void updateEnvelope(Visitable object, Envelope envelope, EnvelopeOptions options) {
        object.accept(new ObjectWalker() {
            Set<AbstractFeature> visited = new HashSet<>();

            @Override
            public void visit(AbstractFeature feature) {
                if (feature != object) {
                    envelope.include(feature.computeEnvelope(options));
                    visited.add(feature);
                }
            }

            @Override
            public void visit(AbstractGeometry geometry) {
                AbstractFeature parent = geometry.getParent(AbstractFeature.class);
                if (parent == object || !visited.contains(parent))
                    envelope.include(geometry.computeEnvelope());
            }

            @Override
            public void visit(Appearance appearance) {
            }
        });
    }
}
