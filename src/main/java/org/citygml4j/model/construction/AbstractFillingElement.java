package org.citygml4j.model.construction;

import org.citygml4j.model.core.AbstractOccupiedSpace;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.citygml4j.util.Envelopes;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractFillingElement extends AbstractOccupiedSpace {
    private List<ADEPropertyOfAbstractFillingElement<?>> adeProperties;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof AbstractFillingSurface
                || boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    public List<ADEPropertyOfAbstractFillingElement<?>> getADEPropertiesOfAbstractFillingElement() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractFillingElement(List<ADEPropertyOfAbstractFillingElement<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractFillingElement<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }
}
