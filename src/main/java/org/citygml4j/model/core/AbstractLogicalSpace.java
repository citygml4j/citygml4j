package org.citygml4j.model.core;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractLogicalSpace extends AbstractSpace {
    private List<ADEPropertyOfAbstractLogicalSpace<?>> adeProperties;

    public List<ADEPropertyOfAbstractLogicalSpace<?>> getADEPropertiesOfAbstractLogicalSpace() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractLogicalSpace(List<ADEPropertyOfAbstractLogicalSpace<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractLogicalSpace<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }
}
