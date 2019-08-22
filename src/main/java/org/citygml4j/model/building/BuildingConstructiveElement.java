package org.citygml4j.model.building;

import org.citygml4j.model.construction.AbstractConstructiveElement;
import org.citygml4j.model.core.AbstractThematicSurfaceProperty;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class BuildingConstructiveElement extends AbstractConstructiveElement<AbstractThematicSurfaceProperty> implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<ADEPropertyOfBuildingConstructiveElement> adeProperties;

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

    public List<ADEPropertyOfBuildingConstructiveElement> getADEPropertyOfBuildingConstructiveElement() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfBuildingConstructiveElement(List<ADEPropertyOfBuildingConstructiveElement> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
