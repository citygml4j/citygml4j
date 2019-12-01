package org.citygml4j.model.tunnel;

import org.citygml4j.visitor.FeatureVisitor;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class TunnelPart extends AbstractTunnel {
    private List<ADEPropertyOfTunnelPart<?>> adeProperties;

    public List<ADEPropertyOfTunnelPart<?>> getADEPropertiesOfTunnelPart() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfTunnelPart(List<ADEPropertyOfTunnelPart<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(FeatureVisitor visitor) {
        visitor.visit(this);
    }
}
