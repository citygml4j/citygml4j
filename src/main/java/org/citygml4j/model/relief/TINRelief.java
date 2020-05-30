package org.citygml4j.model.relief;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class TINRelief extends AbstractReliefComponent {
    private TinProperty tin;
    private List<ADEOfTINRelief> adeOfTINRelief;

    public TINRelief() {
    }

    public TINRelief(int lod, TinProperty tin) {
        super(lod);
        setTin(tin);
    }

    public TinProperty getTin() {
        return tin;
    }

    public void setTin(TinProperty tin) {
        this.tin = asChild(tin);
    }

    public List<ADEOfTINRelief> getADEOfTINRelief() {
        if (adeOfTINRelief == null)
            adeOfTINRelief = new ChildList<>(this);

        return adeOfTINRelief;
    }

    public void setADEOfTINRelief(List<ADEOfTINRelief> adeOfTINRelief) {
        this.adeOfTINRelief = asChild(adeOfTINRelief);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (tin != null && tin.getObject() != null)
            envelope.include(tin.getObject().computeEnvelope());

        if (adeOfTINRelief != null) {
            for (ADEOfTINRelief container : adeOfTINRelief)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        geometryInfo.addGeometry(getLod(), tin);

        if (adeProperties != null) {
            for (ADEOfTINRelief<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
