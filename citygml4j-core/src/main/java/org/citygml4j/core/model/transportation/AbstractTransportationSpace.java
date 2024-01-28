/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;
import org.citygml4j.core.model.core.AbstractUnoccupiedSpace;
import org.citygml4j.core.model.core.ClosureSurface;
import org.citygml4j.core.model.core.OccupancyProperty;
import org.citygml4j.core.model.deprecated.transportation.DeprecatedPropertiesOfAbstractTransportationSpace;
import org.citygml4j.core.model.generics.GenericThematicSurface;
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

    @Override
    public boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type) {
        return Marking.class.isAssignableFrom(type)
                || ClosureSurface.class.isAssignableFrom(type)
                || GenericThematicSurface.class.isAssignableFrom(type)
                || ADEObject.class.isAssignableFrom(type);
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

    public List<TrafficSpaceProperty> getTrafficSpaces() {
        if (trafficSpaces == null)
            trafficSpaces = new ChildList<>(this);

        return trafficSpaces;
    }

    public boolean isSetTrafficSpaces() {
        return trafficSpaces != null && !trafficSpaces.isEmpty();
    }

    public void setTrafficSpaces(List<TrafficSpaceProperty> trafficSpaces) {
        this.trafficSpaces = asChild(trafficSpaces);
    }

    public List<AuxiliaryTrafficSpaceProperty> getAuxiliaryTrafficSpaces() {
        if (auxiliaryTrafficSpaces == null)
            auxiliaryTrafficSpaces = new ChildList<>(this);

        return auxiliaryTrafficSpaces;
    }

    public boolean isSetAuxiliaryTrafficSpaces() {
        return auxiliaryTrafficSpaces != null && !auxiliaryTrafficSpaces.isEmpty();
    }

    public void setAuxiliaryTrafficSpaces(List<AuxiliaryTrafficSpaceProperty> auxiliaryTrafficSpaces) {
        this.auxiliaryTrafficSpaces = asChild(auxiliaryTrafficSpaces);
    }

    public List<HoleProperty> getHoles() {
        if (holes == null)
            holes = new ChildList<>(this);

        return holes;
    }

    public boolean isSetHoles() {
        return holes != null && !holes.isEmpty();
    }

    public void setHoles(List<HoleProperty> holes) {
        this.holes = asChild(holes);
    }

    public List<MarkingProperty> getMarkings() {
        if (markings == null)
            markings = new ChildList<>(this);

        return markings;
    }

    public boolean isSetMarkings() {
        return markings != null && !markings.isEmpty();
    }

    public void setMarkings(List<MarkingProperty> markings) {
        this.markings = asChild(markings);
    }

    @Override
    public DeprecatedPropertiesOfAbstractTransportationSpace getDeprecatedProperties() {
        return super.getDeprecatedProperties(DeprecatedPropertiesOfAbstractTransportationSpace.class);
    }

    @Override
    protected DeprecatedPropertiesOfAbstractTransportationSpace createDeprecatedProperties() {
        return new DeprecatedPropertiesOfAbstractTransportationSpace();
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (trafficSpaces != null) {
            for (TrafficSpaceProperty property : trafficSpaces) {
                if (property.getObject() != null) {
                    envelope.include(property.getObject().computeEnvelope(options));
                }
            }
        }

        if (auxiliaryTrafficSpaces != null) {
            for (AuxiliaryTrafficSpaceProperty property : auxiliaryTrafficSpaces) {
                if (property.getObject() != null) {
                    envelope.include(property.getObject().computeEnvelope(options));
                }
            }
        }

        if (holes != null) {
            for (HoleProperty property : holes) {
                if (property.getObject() != null) {
                    envelope.include(property.getObject().computeEnvelope(options));
                }
            }
        }

        if (markings != null) {
            for (MarkingProperty property : markings) {
                if (property.getObject() != null) {
                    envelope.include(property.getObject().computeEnvelope(options));
                }
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
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractTransportationSpace properties = getDeprecatedProperties();

            geometryInfo.addGeometry(0, properties.getLod0Network());
            geometryInfo.addGeometry(1, properties.getLod1MultiSurface());
            geometryInfo.addGeometry(4, properties.getLod4MultiSurface());
        }
    }
}
