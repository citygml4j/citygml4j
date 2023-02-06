/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.core.model.transportation;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.core.*;
import org.citygml4j.core.model.generics.GenericThematicSurface;
import org.citygml4j.core.visitor.ObjectVisitor;
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
    private List<TrafficSpaceReference> predecessors;
    private List<TrafficSpaceReference> successors;
    private List<ClearanceSpaceProperty> clearanceSpaces;

    public TrafficSpace() {
    }

    public TrafficSpace(GranularityValue granularity) {
        this.granularity = granularity;
    }

    @Override
    public boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type) {
        return TrafficArea.class.isAssignableFrom(type)
                || ClosureSurface.class.isAssignableFrom(type)
                || GenericThematicSurface.class.isAssignableFrom(type)
                || ADEObject.class.isAssignableFrom(type);
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
    public boolean isSetFunctions() {
        return functions != null && !functions.isEmpty();
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
    public boolean isSetUsages() {
        return usages != null && !usages.isEmpty();
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

    public boolean isSetOccupancies() {
        return occupancies != null && !occupancies.isEmpty();
    }

    public void setOccupancies(List<OccupancyProperty> occupancies) {
        this.occupancies = asChild(occupancies);
    }

    public List<TrafficSpaceReference> getPredecessors() {
        if (predecessors == null)
            predecessors = new ChildList<>(this);

        return predecessors;
    }

    public boolean isSetPredecessors() {
        return predecessors != null && !predecessors.isEmpty();
    }

    public void setPredecessors(List<TrafficSpaceReference> predecessors) {
        this.predecessors = asChild(predecessors);
    }

    public List<TrafficSpaceReference> getSuccessors() {
        if (successors == null)
            successors = new ChildList<>(this);

        return successors;
    }

    public boolean isSetSuccessors() {
        return successors != null && !successors.isEmpty();
    }

    public void setSuccessors(List<TrafficSpaceReference> successors) {
        this.successors = asChild(successors);
    }

    public List<ClearanceSpaceProperty> getClearanceSpaces() {
        if (clearanceSpaces == null)
            clearanceSpaces = new ChildList<>(this);

        return clearanceSpaces;
    }

    public boolean isSetClearanceSpaces() {
        return clearanceSpaces != null && !clearanceSpaces.isEmpty();
    }

    public void setClearanceSpaces(List<ClearanceSpaceProperty> clearanceSpaces) {
        this.clearanceSpaces = asChild(clearanceSpaces);
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
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
