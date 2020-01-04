package org.citygml4j.model.transportation;

import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.citygml4j.util.Envelopes;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Section extends AbstractTransportationSpace {
    private Code classifier;
    private List<ADEPropertyOfSection<?>> adeProperties;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof HoleSurface
                || boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    public Code getClassifier() {
        return classifier;
    }

    public void setClassifier(Code classifier) {
        this.classifier = asChild(classifier);
    }

    public List<ADEPropertyOfSection<?>> getADEPropertiesOfSection() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfSection(List<ADEPropertyOfSection<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEPropertyOfSection<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
