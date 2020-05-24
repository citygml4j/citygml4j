package org.citygml4j.model.core;

import org.citygml4j.model.common.GeometryInfo;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.time.OffsetDateTime;
import java.util.List;

public abstract class AbstractFeatureWithLifespan extends AbstractFeature {
    private OffsetDateTime creationDate;
    private OffsetDateTime terminationDate;
    private OffsetDateTime validFrom;
    private OffsetDateTime validTo;
    private List<ADEOfAbstractFeatureWithLifespan> adeOfAbstractFeatureWithLifespan;

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public OffsetDateTime getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(OffsetDateTime terminationDate) {
        this.terminationDate = terminationDate;
    }

    public OffsetDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(OffsetDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public OffsetDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(OffsetDateTime validTo) {
        this.validTo = validTo;
    }

    public List<ADEOfAbstractFeatureWithLifespan> getADEOfAbstractFeatureWithLifespan() {
        if (adeOfAbstractFeatureWithLifespan == null)
            adeOfAbstractFeatureWithLifespan = new ChildList<>(this);

        return adeOfAbstractFeatureWithLifespan;
    }

    public void setADEOfAbstractFeatureWithLifespan(List<ADEOfAbstractFeatureWithLifespan> adeOfAbstractFeatureWithLifespan) {
        this.adeOfAbstractFeatureWithLifespan = asChild(adeOfAbstractFeatureWithLifespan);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEOfAbstractFeatureWithLifespan<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfAbstractFeatureWithLifespan<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
