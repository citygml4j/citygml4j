package org.citygml4j.model.ade;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.util.Envelopes;
import org.citygml4j.visitor.ObjectVisitor;
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.gml.model.common.EnvelopeProvider;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;

public interface ADEObject extends CityGMLObject, Visitable, EnvelopeProvider {

    @Override
    default void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    default void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        Envelopes.updateEnvelope(this, envelope, options);
    }
}
