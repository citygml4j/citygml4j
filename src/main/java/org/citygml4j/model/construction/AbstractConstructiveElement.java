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

public abstract class AbstractConstructiveElement extends AbstractOccupiedSpace {
    private Boolean isStructuralElement;
    private List<AbstractFillingElementProperty> fillings;
    private List<ADEOfAbstractConstructiveElement> adeOfAbstractConstructiveElement;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof AbstractConstructionSurface
                || boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    public Boolean getIsStructuralElement() {
        return isStructuralElement;
    }

    public boolean isSetIsStructuralElement() {
        return isStructuralElement != null;
    }

    public void setIsStructuralElement(Boolean isStructuralElement) {
        this.isStructuralElement = isStructuralElement;
    }

    public List<AbstractFillingElementProperty> getFillings() {
        if (fillings == null)
            fillings = new ChildList<>(this);

        return fillings;
    }

    public void setFillings(List<AbstractFillingElementProperty> fillings) {
        this.fillings = asChild(fillings);
    }

    public List<ADEOfAbstractConstructiveElement> getADEOfAbstractConstructiveElement() {
        if (adeOfAbstractConstructiveElement == null)
            adeOfAbstractConstructiveElement = new ChildList<>(this);

        return adeOfAbstractConstructiveElement;
    }

    public void setADEOfAbstractConstructiveElement(List<ADEOfAbstractConstructiveElement> adeOfAbstractConstructiveElement) {
        this.adeOfAbstractConstructiveElement = asChild(adeOfAbstractConstructiveElement);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfAbstractConstructiveElement != null) {
            for (ADEOfAbstractConstructiveElement container : adeOfAbstractConstructiveElement)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfAbstractConstructiveElement<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
