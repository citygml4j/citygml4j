package org.citygml4j.model.transportation;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.AbstractUnoccupiedSpace;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class AuxiliaryTrafficSpace extends AbstractUnoccupiedSpace implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private GranularityValue granularity;
    private List<ADEOfAuxiliaryTrafficSpace> adeOfAuxiliaryTrafficSpace;

    public AuxiliaryTrafficSpace() {
    }

    public AuxiliaryTrafficSpace(GranularityValue granularity) {
        this.granularity = granularity;
    }

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof AuxiliaryTrafficArea
                || boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

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

    public GranularityValue getGranularity() {
        return granularity;
    }

    public void setGranularity(GranularityValue granularity) {
        this.granularity = granularity;
    }

    public List<ADEOfAuxiliaryTrafficSpace> getADEOfAuxiliaryTrafficSpace() {
        if (adeOfAuxiliaryTrafficSpace == null)
            adeOfAuxiliaryTrafficSpace = new ChildList<>(this);

        return adeOfAuxiliaryTrafficSpace;
    }

    public void setADEOfAuxiliaryTrafficSpace(List<ADEOfAuxiliaryTrafficSpace> adeOfAuxiliaryTrafficSpace) {
        this.adeOfAuxiliaryTrafficSpace = asChild(adeOfAuxiliaryTrafficSpace);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfAuxiliaryTrafficSpace != null) {
            for (ADEOfAuxiliaryTrafficSpace container : adeOfAuxiliaryTrafficSpace)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfAuxiliaryTrafficSpace != null) {
            for (ADEOfAuxiliaryTrafficSpace container : adeOfAuxiliaryTrafficSpace)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
