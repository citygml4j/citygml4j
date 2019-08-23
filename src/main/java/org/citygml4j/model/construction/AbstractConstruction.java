package org.citygml4j.model.construction;

import org.citygml4j.model.core.AbstractOccupiedSpace;
import org.citygml4j.model.core.OccupancyProperty;
import org.xmlobjects.gml.model.common.ChildList;

import java.time.LocalDate;
import java.util.List;

public abstract class AbstractConstruction extends AbstractOccupiedSpace<AbstractConstructionSurfaceProperty> {
    private List<OccupancyProperty> occupancies;
    private ConditionOfConstructionValue conditionOfConstruction;
    private LocalDate dateOfConstruction;
    private LocalDate dateOfDemolition;
    private List<ConstructionEventProperty> constructionEvents;
    private List<ElevationProperty> elevations;
    private List<HeightProperty> heights;
    private List<ADEPropertyOfAbstractConstruction> adeProperties;

    public List<OccupancyProperty> getOccupancies() {
        if (occupancies == null)
            occupancies = new ChildList<>(this);

        return occupancies;
    }

    public void setOccupancies(List<OccupancyProperty> occupancies) {
        this.occupancies = asChild(occupancies);
    }

    public ConditionOfConstructionValue getConditionOfConstruction() {
        return conditionOfConstruction;
    }

    public void setConditionOfConstruction(ConditionOfConstructionValue conditionOfConstruction) {
        this.conditionOfConstruction = conditionOfConstruction;
    }

    public LocalDate getDateOfConstruction() {
        return dateOfConstruction;
    }

    public void setDateOfConstruction(LocalDate dateOfConstruction) {
        this.dateOfConstruction = dateOfConstruction;
    }

    public LocalDate getDateOfDemolition() {
        return dateOfDemolition;
    }

    public void setDateOfDemolition(LocalDate dateOfDemolition) {
        this.dateOfDemolition = dateOfDemolition;
    }

    public List<ConstructionEventProperty> getConstructionEvents() {
        if (constructionEvents == null)
            constructionEvents = new ChildList<>(this);

        return constructionEvents;
    }

    public void setConstructionEvents(List<ConstructionEventProperty> constructionEvents) {
        this.constructionEvents = asChild(constructionEvents);
    }

    public List<ElevationProperty> getElevations() {
        if (elevations == null)
            elevations = new ChildList<>(this);

        return elevations;
    }

    public void setElevations(List<ElevationProperty> elevations) {
        this.elevations = asChild(elevations);
    }

    public List<HeightProperty> getHeights() {
        if (heights == null)
            heights = new ChildList<>(this);

        return heights;
    }

    public void setHeights(List<HeightProperty> heights) {
        this.heights = asChild(heights);
    }

    public List<ADEPropertyOfAbstractConstruction> getADEPropertiesOfAbstractConstruction() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractConstruction(List<ADEPropertyOfAbstractConstruction> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
