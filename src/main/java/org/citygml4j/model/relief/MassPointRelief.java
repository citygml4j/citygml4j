package org.citygml4j.model.relief;

import org.citygml4j.model.core.AbstractPointCloudProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class MassPointRelief extends AbstractReliefComponent {
    private MultiPointProperty reliefPoints;
    private AbstractPointCloudProperty pointCloud;
    private List<ADEPropertyOfMassPointRelief<?>> adeProperties;

    public MassPointRelief() {
    }

    public MassPointRelief(int lod, MultiPointProperty reliefPoints) {
        super(lod);
        setReliefPoints(reliefPoints);
    }

    public MassPointRelief(int lod, AbstractPointCloudProperty pointCloud) {
        super(lod);
        setPointCloud(pointCloud);
    }

    public MultiPointProperty getReliefPoints() {
        return reliefPoints;
    }

    public void setReliefPoints(MultiPointProperty reliefPoints) {
        this.reliefPoints = asChild(reliefPoints);
    }

    public AbstractPointCloudProperty getPointCloud() {
        return pointCloud;
    }

    public void setPointCloud(AbstractPointCloudProperty pointCloud) {
        this.pointCloud = asChild(pointCloud);
    }

    public List<ADEPropertyOfMassPointRelief<?>> getADEPropertiesOfMassPointRelief() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfMassPointRelief(List<ADEPropertyOfMassPointRelief<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
