package org.citygml4j.model.tunnel;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.construction.AbstractInstallation;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.tunnel.DeprecatedPropertiesOfTunnelInstallation;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class TunnelInstallation extends AbstractInstallation implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<ADEOfTunnelInstallation> adeOfTunnelInstallation;

    @Override
    public Code getClassifier() {
        return classifier;
    }

    @Override
    public void setClassifier(Code classifier) {
        this.classifier = asChild(classifier);
    }

    @Override
    public List<Code> getFunctions() {
        if (functions == null)
            functions = new ChildList<>(this);

        return functions;
    }

    @Override
    public void setFunctions(List<Code> functions) {
        this.functions = asChild(functions);
    }

    @Override
    public List<Code> getUsages() {
        if (usages == null)
            usages = new ChildList<>(this);

        return usages;
    }

    @Override
    public void setUsages(List<Code> usages) {
        this.usages = asChild(usages);
    }

    @Override
    public DeprecatedPropertiesOfTunnelInstallation getDeprecatedProperties() {
        return (DeprecatedPropertiesOfTunnelInstallation) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfTunnelInstallation createDeprecatedProperties() {
        return new DeprecatedPropertiesOfTunnelInstallation();
    }

    public List<ADEOfTunnelInstallation> getADEOfTunnelInstallation() {
        if (adeOfTunnelInstallation == null)
            adeOfTunnelInstallation = new ChildList<>(this);

        return adeOfTunnelInstallation;
    }

    public void setADEOfTunnelInstallation(List<ADEOfTunnelInstallation> adeOfTunnelInstallation) {
        this.adeOfTunnelInstallation = asChild(adeOfTunnelInstallation);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfTunnelInstallation properties = getDeprecatedProperties();

            if (properties.getLod2Geometry() != null && properties.getLod2Geometry().getObject() != null)
                envelope.include(properties.getLod2Geometry().getObject().computeEnvelope());

            if (properties.getLod3Geometry() != null && properties.getLod3Geometry().getObject() != null)
                envelope.include(properties.getLod3Geometry().getObject().computeEnvelope());

            if (properties.getLod4Geometry() != null && properties.getLod4Geometry().getObject() != null)
                envelope.include(properties.getLod4Geometry().getObject().computeEnvelope());

            if (properties.getLod4ImplicitRepresentation() != null && properties.getLod4ImplicitRepresentation().getObject() != null)
                envelope.include(properties.getLod4ImplicitRepresentation().getObject().computeEnvelope());
        }

        if (adeOfTunnelInstallation != null) {
            for (ADEOfTunnelInstallation container : adeOfTunnelInstallation)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfTunnelInstallation properties = getDeprecatedProperties();

            geometryInfo.addGeometry(2, properties.getLod2Geometry());
            geometryInfo.addGeometry(3, properties.getLod3Geometry());
            geometryInfo.addGeometry(4, properties.getLod4Geometry());
            geometryInfo.addImplicitGeometry(4, properties.getLod4ImplicitRepresentation());
        }

        if (adeOfTunnelInstallation != null) {
            for (ADEOfTunnelInstallation container : adeOfTunnelInstallation)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
