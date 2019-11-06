package org.citygml4j.model.transportation;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class TrafficArea extends AbstractThematicSurface implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private Code surfaceMaterial;
    private List<ADEPropertyOfTrafficArea> adeProperties;

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

    public Code getSurfaceMaterial() {
        return surfaceMaterial;
    }

    public void setSurfaceMaterial(Code surfaceMaterial) {
        this.surfaceMaterial = asChild(surfaceMaterial);
    }

    public List<ADEPropertyOfTrafficArea> getADEPropertiesOfTrafficArea() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfTrafficArea(List<ADEPropertyOfTrafficArea> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
