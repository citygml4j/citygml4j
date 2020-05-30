package org.citygml4j.model.building;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BuildingPart extends AbstractBuilding {
    private List<ADEOfBuildingPart> adeOfBuildingPart;

    public List<ADEOfBuildingPart> getADEOfBuildingPart() {
        if (adeOfBuildingPart == null)
            adeOfBuildingPart = new ChildList<>(this);

        return adeOfBuildingPart;
    }

    public void setADEOfBuildingPart(List<ADEOfBuildingPart> adeOfBuildingPart) {
        this.adeOfBuildingPart = asChild(adeOfBuildingPart);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfBuildingPart != null) {
            for (ADEOfBuildingPart container : adeOfBuildingPart)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfBuildingPart != null) {
            for (ADEOfBuildingPart container : adeOfBuildingPart)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
