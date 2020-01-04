package org.citygml4j.model.cityfurniture;

import org.citygml4j.model.core.AbstractOccupiedSpace;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.cityfurniture.DeprecatedPropertiesOfCityFurniture;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.citygml4j.util.Envelopes;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class CityFurniture extends AbstractOccupiedSpace implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<ADEPropertyOfCityFurniture<?>> adeProperties;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof ClosureSurface
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

    @Override
    public DeprecatedPropertiesOfCityFurniture getDeprecatedProperties() {
        return (DeprecatedPropertiesOfCityFurniture) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfCityFurniture createDeprecatedProperties() {
        return new DeprecatedPropertiesOfCityFurniture();
    }

    public List<ADEPropertyOfCityFurniture<?>> getADEPropertiesOfCityFurniture() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfCityFurniture(List<ADEPropertyOfCityFurniture<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfCityFurniture properties = getDeprecatedProperties();

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
            for (ADEPropertyOfCityFurniture<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
