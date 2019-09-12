package org.citygml4j.model.appearance;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.ArrayList;
import java.util.List;

public class ParameterizedTexture extends AbstractTexture {
    private List<TextureAssociationProperty> textureParameterization;
    private List<ADEPropertyOfParameterizedTexture> adeProperties;

    public List<TextureAssociationProperty> getTextureParameterization() {
        if (textureParameterization == null)
            textureParameterization = new ArrayList<>();

        return textureParameterization;
    }

    public void setTextureParameterization(List<TextureAssociationProperty> textureParameterization) {
        this.textureParameterization = asChild(textureParameterization);
    }

    public List<ADEPropertyOfParameterizedTexture> getADEPropertiesOfParameterizedTexture() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfParameterizedTexture(List<ADEPropertyOfParameterizedTexture> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
