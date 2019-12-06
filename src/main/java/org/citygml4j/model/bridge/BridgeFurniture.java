package org.citygml4j.model.bridge;

import org.citygml4j.model.construction.AbstractFurniture;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.bridge.DeprecatedPropertiesOfBridgeFurniture;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BridgeFurniture extends AbstractFurniture implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<ADEPropertyOfBridgeFurniture<?>> adeProperties;

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
    public DeprecatedPropertiesOfBridgeFurniture getDeprecatedProperties() {
        return (DeprecatedPropertiesOfBridgeFurniture) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfBridgeFurniture createDeprecatedProperties() {
        return new DeprecatedPropertiesOfBridgeFurniture();
    }

    public List<ADEPropertyOfBridgeFurniture<?>> getADEPropertiesOfBridgeFurniture() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfBridgeFurniture(List<ADEPropertyOfBridgeFurniture<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
