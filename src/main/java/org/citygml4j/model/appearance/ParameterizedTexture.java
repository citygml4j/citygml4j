package org.citygml4j.model.appearance;

import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.ArrayList;
import java.util.List;

public class ParameterizedTexture extends AbstractTexture {
    private List<TextureAssociationProperty> textureParameterizations;
    private List<ADEOfParameterizedTexture> adeOfParameterizedTexture;

    public List<TextureAssociationProperty> getTextureParameterizations() {
        if (textureParameterizations == null)
            textureParameterizations = new ArrayList<>();

        return textureParameterizations;
    }

    public void setTextureParameterizations(List<TextureAssociationProperty> textureParameterizations) {
        this.textureParameterizations = asChild(textureParameterizations);
    }

    public List<ADEOfParameterizedTexture> getADEOfParameterizedTexture() {
        if (adeOfParameterizedTexture == null)
            adeOfParameterizedTexture = new ChildList<>(this);

        return adeOfParameterizedTexture;
    }

    public void setADEOfParameterizedTexture(List<ADEOfParameterizedTexture> adeOfParameterizedTexture) {
        this.adeOfParameterizedTexture = asChild(adeOfParameterizedTexture);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
