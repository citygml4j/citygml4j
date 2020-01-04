package org.citygml4j.model.transportation;

import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.AbstractUnoccupiedSpace;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.core.OccupancyProperty;
import org.citygml4j.model.deprecated.transportation.DeprecatedPropertiesOfAbstractTransportationSpace;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.citygml4j.util.Envelopes;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractTransportationSpace extends AbstractUnoccupiedSpace {
    private TrafficDirectionValue trafficDirection;
    private List<OccupancyProperty> occupancies;
    private List<TrafficSpaceProperty> trafficSpaces;
    private List<AuxiliaryTrafficSpaceProperty> auxiliaryTrafficSpaces;
    private List<HoleProperty> holes;
    private List<MarkingProperty> markings;
    private List<ADEPropertyOfAbstractTransportationSpace<?>> adeProperties;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    public TrafficDirectionValue getTrafficDirection() {
        return trafficDirection;
    }

    public void setTrafficDirection(TrafficDirectionValue trafficDirection) {
        this.trafficDirection = trafficDirection;
    }

    public List<OccupancyProperty> getOccupancies() {
        if (occupancies == null)
            occupancies = new ChildList<>(this);

        return occupancies;
    }

    public void setOccupancies(List<OccupancyProperty> occupancies) {
        this.occupancies = asChild(occupancies);
    }

    public List<TrafficSpaceProperty> getTrafficSpaces() {
        if (trafficSpaces == null)
            trafficSpaces = new ChildList<>(this);

        return trafficSpaces;
    }

    public void setTrafficSpaces(List<TrafficSpaceProperty> trafficSpaces) {
        this.trafficSpaces = asChild(trafficSpaces);
    }

    public List<AuxiliaryTrafficSpaceProperty> getAuxiliaryTrafficSpaces() {
        if (auxiliaryTrafficSpaces == null)
            auxiliaryTrafficSpaces = new ChildList<>(this);

        return auxiliaryTrafficSpaces;
    }

    public void setAuxiliaryTrafficSpaces(List<AuxiliaryTrafficSpaceProperty> auxiliaryTrafficSpaces) {
        this.auxiliaryTrafficSpaces = asChild(auxiliaryTrafficSpaces);
    }

    public List<HoleProperty> getHoles() {
        if (holes == null)
            holes = new ChildList<>(this);

        return holes;
    }

    public void setHoles(List<HoleProperty> holes) {
        this.holes = asChild(holes);
    }

    public List<MarkingProperty> getMarkings() {
        if (markings == null)
            markings = new ChildList<>(this);

        return markings;
    }

    public void setMarkings(List<MarkingProperty> markings) {
        this.markings = asChild(markings);
    }

    @Override
    public DeprecatedPropertiesOfAbstractTransportationSpace getDeprecatedProperties() {
        return (DeprecatedPropertiesOfAbstractTransportationSpace) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfAbstractTransportationSpace createDeprecatedProperties() {
        return new DeprecatedPropertiesOfAbstractTransportationSpace();
    }

    public List<ADEPropertyOfAbstractTransportationSpace<?>> getADEPropertiesOfAbstractTransportationSpace() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractTransportationSpace(List<ADEPropertyOfAbstractTransportationSpace<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (trafficSpaces != null) {
            for (TrafficSpaceProperty property : trafficSpaces) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope(options));
            }
        }

        if (auxiliaryTrafficSpaces != null) {
            for (AuxiliaryTrafficSpaceProperty property : auxiliaryTrafficSpaces) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope(options));
            }
        }

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractTransportationSpace properties = getDeprecatedProperties();

            if (properties.getLod0Network() != null && properties.getLod0Network().getObject() != null)
                envelope.include(properties.getLod0Network().getObject().computeEnvelope());

            if (properties.getLod1MultiSurface() != null && properties.getLod1MultiSurface().getObject() != null)
                envelope.include(properties.getLod1MultiSurface().getObject().computeEnvelope());

            if (properties.getLod4MultiSurface() != null && properties.getLod4MultiSurface().getObject() != null)
                envelope.include(properties.getLod4MultiSurface().getObject().computeEnvelope());

        }

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractTransportationSpace<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }
}
