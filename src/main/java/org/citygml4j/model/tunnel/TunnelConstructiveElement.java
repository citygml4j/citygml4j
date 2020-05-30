package org.citygml4j.model.tunnel;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.construction.AbstractConstructiveElement;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class TunnelConstructiveElement extends AbstractConstructiveElement implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<ADEOfTunnelConstructiveElement> adeOfTunnelConstructiveElement;

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

    public List<ADEOfTunnelConstructiveElement> getADEOfTunnelConstructiveElement() {
        if (adeOfTunnelConstructiveElement == null)
            adeOfTunnelConstructiveElement = new ChildList<>(this);

        return adeOfTunnelConstructiveElement;
    }

    public void setADEOfTunnelConstructiveElement(List<ADEOfTunnelConstructiveElement> adeOfTunnelConstructiveElement) {
        this.adeOfTunnelConstructiveElement = asChild(adeOfTunnelConstructiveElement);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfTunnelConstructiveElement != null) {
            for (ADEOfTunnelConstructiveElement container : adeOfTunnelConstructiveElement)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfTunnelConstructiveElement != null) {
            for (ADEOfTunnelConstructiveElement container : adeOfTunnelConstructiveElement)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
