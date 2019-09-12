package org.citygml4j.model.appearance;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractGML;

public class TextureAssociation extends AbstractGML implements CityGMLObject {
    private String uri;
    private AbstractTextureParameterizationProperty textureParameterization;

    public TextureAssociation() {
    }

    public TextureAssociation(String uri, AbstractTextureParameterizationProperty textureParameterization) {
        this.uri = uri;
        setTextureParameterization(textureParameterization);
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public AbstractTextureParameterizationProperty getTextureParameterization() {
        return textureParameterization;
    }

    public void setTextureParameterization(AbstractTextureParameterizationProperty textureParameterization) {
        this.textureParameterization = asChild(textureParameterization);
    }
}
