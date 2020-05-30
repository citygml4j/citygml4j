package org.citygml4j.model.core;

import org.citygml4j.model.common.GeometryInfo;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractPointCloud extends AbstractFeature {
    private List<ADEOfAbstractPointCloud> adeOfAbstractPointCloud;

    public List<ADEOfAbstractPointCloud> getADEOfAbstractPointCloud() {
        if (adeOfAbstractPointCloud == null)
            adeOfAbstractPointCloud = new ChildList<>(this);

        return adeOfAbstractPointCloud;
    }

    public void setADEOfAbstractPointCloud(List<ADEOfAbstractPointCloud> adeOfAbstractPointCloud) {
        this.adeOfAbstractPointCloud = asChild(adeOfAbstractPointCloud);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        if (adeOfAbstractPointCloud != null) {
            for (ADEOfAbstractPointCloud container : adeOfAbstractPointCloud)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfAbstractPointCloud != null) {
            for (ADEOfAbstractPointCloud container : adeOfAbstractPointCloud)
                updateGeometryInfo(container, geometryInfo);
        }
    }
}
