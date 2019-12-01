package org.citygml4j.model.vegetation;

import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.vegetation.DeprecatedPropertiesOfPlantCover;
import org.citygml4j.visitor.FeatureVisitor;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.measures.Length;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class PlantCover extends AbstractVegetationObject implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private Length averageHeight;
    private Length minHeight;
    private Length maxHeight;
    private List<ADEPropertyOfPlantCover<?>> adeProperties;

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

    public Length getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(Length averageHeight) {
        this.averageHeight = asChild(averageHeight);
    }

    public Length getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(Length minHeight) {
        this.minHeight = asChild(minHeight);
    }

    public Length getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Length maxHeight) {
        this.maxHeight = asChild(maxHeight);
    }

    @Override
    public DeprecatedPropertiesOfPlantCover getDeprecatedProperties() {
        return (DeprecatedPropertiesOfPlantCover) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfPlantCover createDeprecatedProperties() {
        return new DeprecatedPropertiesOfPlantCover();
    }

    public List<ADEPropertyOfPlantCover<?>> getADEPropertiesOfPlantCover() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfPlantCover(List<ADEPropertyOfPlantCover<?>> adeProperties) {
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
