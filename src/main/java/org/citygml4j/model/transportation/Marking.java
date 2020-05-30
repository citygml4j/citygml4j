package org.citygml4j.model.transportation;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Marking extends AbstractThematicSurface {
    private Code classifier;
    private List<ADEOfMarking> adeOfMarking;

    public Code getClassifier() {
        return classifier;
    }

    public void setClassifier(Code classifier) {
        this.classifier = asChild(classifier);
    }

    public List<ADEOfMarking> getADEOfMarking() {
        if (adeOfMarking == null)
            adeOfMarking = new ChildList<>(this);

        return adeOfMarking;
    }

    public void setADEOfMarking(List<ADEOfMarking> adeOfMarking) {
        this.adeOfMarking = asChild(adeOfMarking);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfMarking != null) {
            for (ADEOfMarking container : adeOfMarking)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfMarking != null) {
            for (ADEOfMarking container : adeOfMarking)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
