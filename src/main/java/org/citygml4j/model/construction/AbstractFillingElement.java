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

public abstract class AbstractFillingElement extends AbstractOccupiedSpace {
    private List<ADEOfAbstractFillingElement> adeOfAbstractFillingElement;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof AbstractFillingSurface
                || boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    public List<ADEOfAbstractFillingElement> getADEOfAbstractFillingElement() {
        if (adeOfAbstractFillingElement == null)
            adeOfAbstractFillingElement = new ChildList<>(this);

        return adeOfAbstractFillingElement;
    }

    public void setADEOfAbstractFillingElement(List<ADEOfAbstractFillingElement> adeOfAbstractFillingElement) {
        this.adeOfAbstractFillingElement = asChild(adeOfAbstractFillingElement);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfAbstractFillingElement != null) {
            for (ADEOfAbstractFillingElement container : adeOfAbstractFillingElement)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfAbstractFillingElement != null) {
            for (ADEOfAbstractFillingElement container : adeOfAbstractFillingElement)
                updateGeometryInfo(container, geometryInfo);
        }
    }
}
