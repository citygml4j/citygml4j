package org.citygml4j.model.core;

import org.citygml4j.model.common.GeometryInfo;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractOccupiedSpace extends AbstractPhysicalSpace {
    private ImplicitGeometryProperty lod1ImplicitRepresentation;
    private ImplicitGeometryProperty lod2ImplicitRepresentation;
    private ImplicitGeometryProperty lod3ImplicitRepresentation;
    private List<ADEOfAbstractOccupiedSpace> adeOfAbstractOccupiedSpace;

    public ImplicitGeometryProperty getLod1ImplicitRepresentation() {
        return lod1ImplicitRepresentation;
    }

    public void setLod1ImplicitRepresentation(ImplicitGeometryProperty lod1ImplicitRepresentation) {
        this.lod1ImplicitRepresentation = asChild(lod1ImplicitRepresentation);
    }

    public ImplicitGeometryProperty getLod2ImplicitRepresentation() {
        return lod2ImplicitRepresentation;
    }

    public void setLod2ImplicitRepresentation(ImplicitGeometryProperty lod2ImplicitRepresentation) {
        this.lod2ImplicitRepresentation = asChild(lod2ImplicitRepresentation);
    }

    public ImplicitGeometryProperty getLod3ImplicitRepresentation() {
        return lod3ImplicitRepresentation;
    }

    public void setLod3ImplicitRepresentation(ImplicitGeometryProperty lod3ImplicitRepresentation) {
        this.lod3ImplicitRepresentation = asChild(lod3ImplicitRepresentation);
    }

    public List<ADEOfAbstractOccupiedSpace> getADEOfAbstractOccupiedSpace() {
        if (adeOfAbstractOccupiedSpace == null)
            adeOfAbstractOccupiedSpace = new ChildList<>(this);

        return adeOfAbstractOccupiedSpace;
    }

    public void setADEOfAbstractOccupiedSpace(List<ADEOfAbstractOccupiedSpace> adeOfAbstractOccupiedSpace) {
        this.adeOfAbstractOccupiedSpace = asChild(adeOfAbstractOccupiedSpace);
    }

    public ImplicitGeometryProperty getImplicitRepresentation(int lod) {
        switch (lod) {
            case 1:
                return getLod1ImplicitRepresentation();
            case 2:
                return getLod2ImplicitRepresentation();
            case 3:
                return getLod3ImplicitRepresentation();
            default:
                return null;
        }
    }

    public boolean setImplicitRepresentation(int lod, ImplicitGeometryProperty property) {
        switch (lod) {
            case 1:
                setLod1ImplicitRepresentation(property);
                return true;
            case 2:
                setLod2ImplicitRepresentation(property);
                return true;
            case 3:
                setLod3ImplicitRepresentation(property);
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        for (int lod = 1; lod < 4; lod++) {
            ImplicitGeometryProperty property = getImplicitRepresentation(lod);
            if (property != null && property.getObject() != null)
                envelope.include(property.getObject().computeEnvelope());
        }

        if (adeOfAbstractOccupiedSpace != null) {
            for (ADEOfAbstractOccupiedSpace container : adeOfAbstractOccupiedSpace)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        for (int lod = 1; lod < 4; lod++)
            geometryInfo.addImplicitGeometry(lod, getImplicitRepresentation(lod));

        if (adeProperties != null) {
            for (ADEOfAbstractOccupiedSpace<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
