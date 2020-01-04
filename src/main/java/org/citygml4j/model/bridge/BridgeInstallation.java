package org.citygml4j.model.bridge;

import org.citygml4j.model.construction.AbstractInstallation;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.bridge.DeprecatedPropertiesOfBridgeInstallation;
import org.citygml4j.util.Envelopes;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BridgeInstallation extends AbstractInstallation implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<ADEPropertyOfBridgeInstallation<?>> adeProperties;

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
    public DeprecatedPropertiesOfBridgeInstallation getDeprecatedProperties() {
        return (DeprecatedPropertiesOfBridgeInstallation) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfBridgeInstallation createDeprecatedProperties() {
        return new DeprecatedPropertiesOfBridgeInstallation();
    }

    public List<ADEPropertyOfBridgeInstallation<?>> getADEPropertiesOfBridgeInstallation() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfBridgeInstallation(List<ADEPropertyOfBridgeInstallation<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBridgeInstallation properties = getDeprecatedProperties();

            if (properties.getLod2Geometry() != null && properties.getLod2Geometry().getObject() != null)
                envelope.include(properties.getLod2Geometry().getObject().computeEnvelope());

            if (properties.getLod3Geometry() != null && properties.getLod3Geometry().getObject() != null)
                envelope.include(properties.getLod3Geometry().getObject().computeEnvelope());

            if (properties.getLod4Geometry() != null && properties.getLod4Geometry().getObject() != null)
                envelope.include(properties.getLod4Geometry().getObject().computeEnvelope());

            if (properties.getLod4ImplicitRepresentation() != null && properties.getLod4ImplicitRepresentation().getObject() != null)
                envelope.include(properties.getLod4ImplicitRepresentation().getObject().computeEnvelope());
        }

        if (adeProperties != null) {
            for (ADEPropertyOfBridgeInstallation<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
