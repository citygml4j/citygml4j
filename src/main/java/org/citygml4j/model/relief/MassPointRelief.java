package org.citygml4j.model.relief;

import org.citygml4j.model.core.AbstractPointCloudProperty;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;
import org.xmlobjects.gml.util.EnvelopeOptions;
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

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (reliefPoints != null && reliefPoints.getObject() != null)
            envelope.include(reliefPoints.getObject().computeEnvelope());

        if (pointCloud != null && pointCloud.getObject() != null)
            envelope.include(pointCloud.getObject().computeEnvelope(options));

        if (adeProperties != null) {
            for (ADEPropertyOfMassPointRelief<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
