package org.citygml4j.model.construction;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractOccupiedSpace;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractFurniture extends AbstractOccupiedSpace {
    private List<ADEOfAbstractFurniture> adeOfAbstractFurniture;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    public List<ADEOfAbstractFurniture> getADEOfAbstractFurniture() {
        if (adeOfAbstractFurniture == null)
            adeOfAbstractFurniture = new ChildList<>(this);

        return adeOfAbstractFurniture;
    }

    public void setADEOfAbstractFurniture(List<ADEOfAbstractFurniture> adeOfAbstractFurniture) {
        this.adeOfAbstractFurniture = asChild(adeOfAbstractFurniture);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEOfAbstractFurniture<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfAbstractFurniture<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
