package org.citygml4j.model.transportation;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.model.core.AbstractUnoccupiedSpace;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class AuxiliaryTrafficSpace extends AbstractUnoccupiedSpace implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private GranularityValue granularity;
    private List<ADEPropertyOfAuxiliaryTrafficSpace> adeProperties;

    public AuxiliaryTrafficSpace() {
    }

    public AuxiliaryTrafficSpace(GranularityValue granularity) {
        this.granularity = granularity;
    }

    @Override
    public boolean isValidBoundarySurface(AbstractThematicSurface boundarySurface) {
        return boundarySurface instanceof AuxiliaryTrafficArea
                || boundarySurface instanceof ClosureSurface
                || boundarySurface instanceof GenericThematicSurface;
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

    public List<ADEPropertyOfAuxiliaryTrafficSpace> getADEPropertiesOfAuxiliaryTrafficSpace() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAuxiliaryTrafficSpace(List<ADEPropertyOfAuxiliaryTrafficSpace> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
