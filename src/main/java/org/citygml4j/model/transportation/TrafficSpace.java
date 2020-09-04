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

package org.citygml4j.model.transportation;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.AbstractUnoccupiedSpace;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.core.OccupancyProperty;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class TrafficSpace extends AbstractUnoccupiedSpace implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private GranularityValue granularity;
    private TrafficDirectionValue trafficDirection;
    private List<OccupancyProperty> occupancies;
    private List<TrafficSpaceProperty> predecessors;
    private List<TrafficSpaceProperty> successors;
    private List<ClearanceSpaceProperty> clearanceSpaces;
    private List<ADEOfTrafficSpace> adeOfTrafficSpace;

    public TrafficSpace() {
    }

    public TrafficSpace(GranularityValue granularity) {
        this.granularity = granularity;
    }

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof TrafficArea
                || boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    @Override
    public Code getClassifier() {
        return classifier;
    }

    @Override
    public void setClassifier(Code classifier) {
        this.classifier = asChild(classifier);
    }

    @Override
    public List<Code> getFunctions() {
        if (functions == null)
            functions = new ChildList<>(this);

        return functions;
    }

    @Override
    public void setFunctions(List<Code> functions) {
        this.functions = asChild(functions);
    }

    @Override
    public List<Code> getUsages() {
        if (usages == null)
            usages = new ChildList<>(this);

        return usages;
    }

    @Override
    public void setUsages(List<Code> usages) {
        this.usages = asChild(usages);
    }

    public GranularityValue getGranularity() {
        return granularity;
    }

    public void setGranularity(GranularityValue granularity) {
        this.granularity = granularity;
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

    public List<TrafficSpaceProperty> getPredecessors() {
        if (predecessors == null)
            predecessors = new ChildList<>(this);

        return predecessors;
    }

    public void setPredecessors(List<TrafficSpaceProperty> predecessors) {
        this.predecessors = asChild(predecessors);
    }

    public List<TrafficSpaceProperty> getSuccessors() {
        if (successors == null)
            successors = new ChildList<>(this);

        return successors;
    }

    public void setSuccessors(List<TrafficSpaceProperty> successors) {
        this.successors = asChild(successors);
    }

    public List<ClearanceSpaceProperty> getClearanceSpaces() {
        if (clearanceSpaces == null)
            clearanceSpaces = new ChildList<>(this);

        return clearanceSpaces;
    }

    public void setClearanceSpaces(List<ClearanceSpaceProperty> clearanceSpaces) {
        this.clearanceSpaces = asChild(clearanceSpaces);
    }

    public List<ADEOfTrafficSpace> getADEOfTrafficSpace() {
        if (adeOfTrafficSpace == null)
            adeOfTrafficSpace = new ChildList<>(this);

        return adeOfTrafficSpace;
    }

    public void setADEOfTrafficSpace(List<ADEOfTrafficSpace> adeOfTrafficSpace) {
        this.adeOfTrafficSpace = asChild(adeOfTrafficSpace);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (clearanceSpaces != null) {
            for (ClearanceSpaceProperty property : clearanceSpaces) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope(options));
            }
        }

        if (adeOfTrafficSpace != null) {
            for (ADEOfTrafficSpace container : adeOfTrafficSpace)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfTrafficSpace != null) {
            for (ADEOfTrafficSpace container : adeOfTrafficSpace)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
