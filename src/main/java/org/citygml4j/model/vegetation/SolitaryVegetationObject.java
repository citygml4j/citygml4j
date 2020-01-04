package org.citygml4j.model.vegetation;

import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.vegetation.DeprecatedPropertiesOfSolitaryVegetationObject;
import org.citygml4j.util.Envelopes;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.measures.Length;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class SolitaryVegetationObject extends AbstractVegetationObject implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private Code species;
    private Length height;
    private Length trunkDiameter;
    private Length crownDiameter;
    private Length rootBallDiameter;
    private Length maxRootBallDepth;
    private List<ADEPropertyOfSolitaryVegetationObject<?>> adeProperties;

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

    public Code getSpecies() {
        return species;
    }

    public void setSpecies(Code species) {
        this.species = asChild(species);
    }

    public Length getHeight() {
        return height;
    }

    public void setHeight(Length height) {
        this.height = asChild(height);
    }

    public Length getTrunkDiameter() {
        return trunkDiameter;
    }

    public void setTrunkDiameter(Length trunkDiameter) {
        this.trunkDiameter = asChild(trunkDiameter);
    }

    public Length getCrownDiameter() {
        return crownDiameter;
    }

    public void setCrownDiameter(Length crownDiameter) {
        this.crownDiameter = asChild(crownDiameter);
    }

    public Length getRootBallDiameter() {
        return rootBallDiameter;
    }

    public void setRootBallDiameter(Length rootBallDiameter) {
        this.rootBallDiameter = asChild(rootBallDiameter);
    }

    public Length getMaxRootBallDepth() {
        return maxRootBallDepth;
    }

    public void setMaxRootBallDepth(Length maxRootBallDepth) {
        this.maxRootBallDepth = asChild(maxRootBallDepth);
    }

    @Override
    public DeprecatedPropertiesOfSolitaryVegetationObject getDeprecatedProperties() {
        return (DeprecatedPropertiesOfSolitaryVegetationObject) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfSolitaryVegetationObject createDeprecatedProperties() {
        return new DeprecatedPropertiesOfSolitaryVegetationObject();
    }

    public List<ADEPropertyOfSolitaryVegetationObject<?>> getADEPropertiesOfSolitaryVegetationObject() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfSolitaryVegetationObject(List<ADEPropertyOfSolitaryVegetationObject<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfSolitaryVegetationObject properties = getDeprecatedProperties();

            if (properties.getLod1Geometry() != null && properties.getLod1Geometry().getObject() != null)
                envelope.include(properties.getLod1Geometry().getObject().computeEnvelope());

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
            for (ADEPropertyOfSolitaryVegetationObject<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
