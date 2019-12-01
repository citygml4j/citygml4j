package org.citygml4j.model.appearance;

import org.citygml4j.visitor.FeatureVisitor;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.ArrayList;
import java.util.List;

public class ParameterizedTexture extends AbstractTexture {
    private List<TextureAssociationProperty> textureParameterizations;
    private List<ADEPropertyOfParameterizedTexture<?>> adeProperties;

    public List<TextureAssociationProperty> getTextureParameterizations() {
        if (textureParameterizations == null)
            textureParameterizations = new ArrayList<>();

        return textureParameterizations;
    }

    public void setTextureParameterizations(List<TextureAssociationProperty> textureParameterizations) {
        this.textureParameterizations = asChild(textureParameterizations);
    }

    public List<ADEPropertyOfParameterizedTexture<?>> getADEPropertiesOfParameterizedTexture() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfParameterizedTexture(List<ADEPropertyOfParameterizedTexture<?>> adeProperties) {
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
