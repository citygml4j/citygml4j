package org.citygml4j.model.appearance;

import org.citygml4j.model.core.AbstractFeature;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractSurfaceData extends AbstractFeature {
    private Boolean isFront;
    private List<ADEOfAbstractSurfaceData> adeOfAbstractSurfaceData;

    public Boolean getIsFront() {
        return isFront != null ? isFront : true;
    }

    public boolean isSetIsFront() {
        return isFront != null;
    }

    public void setIsFront(Boolean front) {
        isFront = front;
    }

    public List<ADEOfAbstractSurfaceData> getADEOfAbstractSurfaceData() {
        if (adeOfAbstractSurfaceData == null)
            adeOfAbstractSurfaceData = new ChildList<>(this);

        return adeOfAbstractSurfaceData;
    }

    public void setADEOfAbstractSurfaceData(List<ADEOfAbstractSurfaceData> adeOfAbstractSurfaceData) {
        this.adeOfAbstractSurfaceData = asChild(adeOfAbstractSurfaceData);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
    }
}
