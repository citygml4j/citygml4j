package org.citygml4j.model.vegetation;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractOccupiedSpace;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractVegetationObject extends AbstractOccupiedSpace {
    private List<ADEOfAbstractVegetationObject> adeOfAbstractVegetationObject;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    public List<ADEOfAbstractVegetationObject> getADEOfAbstractVegetationObject() {
        if (adeOfAbstractVegetationObject == null)
            adeOfAbstractVegetationObject = new ChildList<>(this);

        return adeOfAbstractVegetationObject;
    }

    public void setADEOfAbstractVegetationObject(List<ADEOfAbstractVegetationObject> adeOfAbstractVegetationObject) {
        this.adeOfAbstractVegetationObject = asChild(adeOfAbstractVegetationObject);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfAbstractVegetationObject != null) {
            for (ADEOfAbstractVegetationObject container : adeOfAbstractVegetationObject)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfAbstractVegetationObject<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
