package org.citygml4j.model.appearance;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.visitor.ObjectVisitor;
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.gml.model.base.AbstractGML;

public class TextureAssociation extends AbstractGML implements CityGMLObject, Visitable {
    private String target;
    private AbstractTextureParameterizationProperty textureParameterization;

    public TextureAssociation() {
    }

    public TextureAssociation(String target, AbstractTextureParameterizationProperty textureParameterization) {
        this.target = target;
        setTextureParameterization(textureParameterization);
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
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
