package org.citygml4j.model.appearance;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.visitor.ObjectVisitor;
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;

public class TextureAssociation extends AbstractGML implements CityGMLObject, Visitable {
    private GeometryReference target;
    private AbstractTextureParameterizationProperty textureParameterization;

    public TextureAssociation() {
    }

    public TextureAssociation(GeometryReference target, AbstractTextureParameterizationProperty textureParameterization) {
        setTarget(target);
        setTextureParameterization(textureParameterization);
    }

    public TextureAssociation(String target, AbstractTextureParameterizationProperty textureParameterization) {
        this(new GeometryReference(target), textureParameterization);
    }

    public TextureAssociation(AbstractGeometry target, AbstractTextureParameterizationProperty textureParameterization) {
        this(new GeometryReference(target), textureParameterization);
    }

    public GeometryReference getTarget() {
        return target;
    }

    public void setTarget(GeometryReference target) {
        this.target = asChild(target);
    }

    public AbstractTextureParameterizationProperty getTextureParameterization() {
        return textureParameterization;
    }

    public void setTextureParameterization(AbstractTextureParameterizationProperty textureParameterization) {
        this.textureParameterization = asChild(textureParameterization);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
