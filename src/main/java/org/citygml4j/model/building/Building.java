package org.citygml4j.model.building;

import org.citygml4j.util.Envelopes;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Building extends AbstractBuilding {
    private List<BuildingPartProperty> buildingParts;
    private List<ADEPropertyOfBuilding<?>> adeProperties;

    public List<BuildingPartProperty> getBuildingParts() {
        if (buildingParts == null)
            buildingParts = new ChildList<>(this);

        return buildingParts;
    }

    public void setBuildingParts(List<BuildingPartProperty> buildingParts) {
        this.buildingParts = asChild(buildingParts);
    }

    public List<ADEPropertyOfBuilding<?>> getADEPropertiesOfBuilding() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfBuilding(List<ADEPropertyOfBuilding<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (buildingParts != null) {
            for (BuildingPartProperty property : buildingParts) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope(options));
            }
        }

        if (adeProperties != null) {
            for (ADEPropertyOfBuilding<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
