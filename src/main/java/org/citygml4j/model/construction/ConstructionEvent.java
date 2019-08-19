package org.citygml4j.model.construction;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.Reference;

import java.time.LocalDate;

public class ConstructionEvent extends GMLObject implements CityGMLObject {
    private Reference event;
    private LocalDate dateOfEvent;
    private String description;

    public ConstructionEvent() {
    }

    public ConstructionEvent(Reference event, LocalDate dateOfEvent) {
        setEvent(event);
        this.dateOfEvent = dateOfEvent;
    }

    public Reference getEvent() {
        return event;
    }

    public void setEvent(Reference event) {
        this.event = asChild(event);
    }

    public LocalDate getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(LocalDate dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
