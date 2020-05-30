package org.citygml4j.model.relief;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractReliefComponent extends AbstractSpaceBoundary {
    private int lod;
    private ExtentProperty extent;
    private List<ADEOfAbstractReliefComponent> adeOfAbstractReliefComponent;

    public AbstractReliefComponent() {
    }

    public AbstractReliefComponent(int lod) {
        setLod(lod);
    }

    public int getLod() {
        return lod;
    }

    public void setLod(int lod) {
        if (lod >= 0)
            this.lod = lod;
    }

    public ExtentProperty getExtent() {
        return extent;
    }

    public void setExtent(ExtentProperty extent) {
        this.extent = asChild(extent);
    }

    public List<ADEOfAbstractReliefComponent> getADEOfAbstractReliefComponent() {
        if (adeOfAbstractReliefComponent == null)
            adeOfAbstractReliefComponent = new ChildList<>(this);

        return adeOfAbstractReliefComponent;
    }

    public void setADEOfAbstractReliefComponent(List<ADEOfAbstractReliefComponent> adeOfAbstractReliefComponent) {
        this.adeOfAbstractReliefComponent = asChild(adeOfAbstractReliefComponent);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfAbstractReliefComponent != null) {
            for (ADEOfAbstractReliefComponent container : adeOfAbstractReliefComponent)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfAbstractReliefComponent<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
