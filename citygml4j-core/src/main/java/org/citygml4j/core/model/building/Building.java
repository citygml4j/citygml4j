/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.common.TopLevelFeature;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Building extends AbstractBuilding implements TopLevelFeature {
    private List<BuildingPartProperty> buildingParts;

    public List<BuildingPartProperty> getBuildingParts() {
        if (buildingParts == null)
            buildingParts = new ChildList<>(this);

        return buildingParts;
    }

    public boolean isSetBuildingParts() {
        return buildingParts != null && !buildingParts.isEmpty();
    }

    public void setBuildingParts(List<BuildingPartProperty> buildingParts) {
        this.buildingParts = asChild(buildingParts);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (buildingParts != null) {
            for (BuildingPartProperty property : buildingParts) {
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
