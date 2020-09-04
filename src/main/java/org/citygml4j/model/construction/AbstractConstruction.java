/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.model.construction;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractOccupiedSpace;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.core.OccupancyProperty;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.time.LocalDate;
import java.util.List;

public abstract class AbstractConstruction extends AbstractOccupiedSpace {
    private ConditionOfConstructionValue conditionOfConstruction;
    private LocalDate dateOfConstruction;
    private LocalDate dateOfDemolition;
    private List<ConstructionEventProperty> constructionEvents;
    private List<ElevationProperty> elevations;
    private List<HeightProperty> heights;
    private List<OccupancyProperty> occupancies;
    private List<ADEOfAbstractConstruction> adeOfAbstractConstruction;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof AbstractConstructionSurface
                || boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
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

    public List<OccupancyProperty> getOccupancies() {
        if (occupancies == null)
            occupancies = new ChildList<>(this);

        return occupancies;
    }

    public void setOccupancies(List<OccupancyProperty> occupancies) {
        this.occupancies = asChild(occupancies);
    }

    public List<ADEOfAbstractConstruction> getADEOfAbstractConstruction() {
        if (adeOfAbstractConstruction == null)
            adeOfAbstractConstruction = new ChildList<>(this);

        return adeOfAbstractConstruction;
    }

    public void setADEOfAbstractConstruction(List<ADEOfAbstractConstruction> adeOfAbstractConstruction) {
        this.adeOfAbstractConstruction = asChild(adeOfAbstractConstruction);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfAbstractConstruction != null) {
            for (ADEOfAbstractConstruction container : adeOfAbstractConstruction)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfAbstractConstruction != null) {
            for (ADEOfAbstractConstruction container : adeOfAbstractConstruction)
                updateGeometryInfo(container, geometryInfo);
        }
    }
}
