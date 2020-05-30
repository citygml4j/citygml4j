package org.citygml4j.model.building;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.construction.AbstractFurniture;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.building.DeprecatedPropertiesOfBuildingFurniture;
import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BuildingFurniture extends AbstractFurniture implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<ADEOfBuildingFurniture> adeOfBuildingFurniture;

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
    public DeprecatedPropertiesOfBuildingFurniture getDeprecatedProperties() {
        return (DeprecatedPropertiesOfBuildingFurniture) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfAbstractCityObject createDeprecatedProperties() {
        return new DeprecatedPropertiesOfBuildingFurniture();
    }

    public List<ADEOfBuildingFurniture> getADEOfBuildingFurniture() {
        if (adeOfBuildingFurniture == null)
            adeOfBuildingFurniture = new ChildList<>(this);

        return adeOfBuildingFurniture;
    }

    public void setADEOfBuildingFurniture(List<ADEOfBuildingFurniture> adeOfBuildingFurniture) {
        this.adeOfBuildingFurniture = asChild(adeOfBuildingFurniture);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBuildingFurniture properties = getDeprecatedProperties();

            if (properties.getLod4Geometry() != null && properties.getLod4Geometry().getObject() != null)
                envelope.include(properties.getLod4Geometry().getObject().computeEnvelope());

            if (properties.getLod4ImplicitRepresentation() != null && properties.getLod4ImplicitRepresentation().getObject() != null)
                envelope.include(properties.getLod4ImplicitRepresentation().getObject().computeEnvelope());
        }

        if (adeOfBuildingFurniture != null) {
            for (ADEOfBuildingFurniture container : adeOfBuildingFurniture)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfBuildingFurniture properties = getDeprecatedProperties();

            geometryInfo.addGeometry(4, properties.getLod4Geometry());
            geometryInfo.addImplicitGeometry(4, properties.getLod4ImplicitRepresentation());
        }

        if (adeOfBuildingFurniture != null) {
            for (ADEOfBuildingFurniture container : adeOfBuildingFurniture)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
