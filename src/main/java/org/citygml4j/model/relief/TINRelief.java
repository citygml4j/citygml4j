package org.citygml4j.model.relief;

import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class TINRelief extends AbstractReliefComponent {
    private TinProperty tin;
    private List<ADEPropertyOfTINRelief<?>> adeProperties;

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

    public List<ADEPropertyOfTINRelief<?>> getADEPropertiesOfTINRelief() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfTINRelief(List<ADEPropertyOfTINRelief<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (tin != null && tin.getObject() != null)
            envelope.include(tin.getObject().computeEnvelope());

        if (adeProperties != null) {
            for (ADEPropertyOfTINRelief<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
