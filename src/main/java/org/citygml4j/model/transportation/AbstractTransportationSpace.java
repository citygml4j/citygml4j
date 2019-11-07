package org.citygml4j.model.transportation;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.model.core.AbstractUnoccupiedSpace;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.core.OccupancyProperty;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.gml.model.geometry.complexes.GeometricComplexProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractTransportationSpace extends AbstractUnoccupiedSpace {
    private TrafficDirectionValue trafficDirection;
    private List<OccupancyProperty> occupancies;
    private List<TrafficSpaceProperty> trafficSpaces;
    private List<AuxiliaryTrafficSpaceProperty> auxiliaryTrafficSpaces;
    private List<HoleProperty> holes;
    private List<MarkingProperty> markings;
    private GeometricComplexProperty network;
    private List<ADEPropertyOfAbstractTransportationSpace> adeProperties;

    @Override
    public boolean isValidBoundarySurface(AbstractThematicSurface boundarySurface) {
        return boundarySurface instanceof ClosureSurface
                || boundarySurface instanceof GenericThematicSurface;
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

    public GeometricComplexProperty getNetwork() {
        return network;
    }

    public void setNetwork(GeometricComplexProperty network) {
        this.network = asChild(network);
    }

    public List<ADEPropertyOfAbstractTransportationSpace> getADEPropertiesOfAbstractTransportationSpace() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractTransportationSpace(List<ADEPropertyOfAbstractTransportationSpace> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
