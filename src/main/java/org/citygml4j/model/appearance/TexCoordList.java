package org.citygml4j.model.appearance;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class TexCoordList extends AbstractTextureParameterization {
    private List<TextureCoordinates> textureCoordinates;

    public List<TextureCoordinates> getTextureCoordinates() {
        if (textureCoordinates == null)
            textureCoordinates = new ChildList<>(this);

        return textureCoordinates;
    }

    public void setTextureCoordinates(List<TextureCoordinates> textureCoordinates) {
        this.textureCoordinates = asChild(textureCoordinates);
    }
}
