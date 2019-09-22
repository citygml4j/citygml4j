package org.citygml4j.model.appearance;

import java.util.ArrayList;
import java.util.List;

public class TexCoordList extends AbstractTextureParameterization {
    private List<TextureCoordinates> textureCoordinates;

    public List<TextureCoordinates> getTextureCoordinates() {
        if (textureCoordinates == null)
            textureCoordinates = new ArrayList<>();

        return textureCoordinates;
    }

    public void setTextureCoordinates(List<TextureCoordinates> textureCoordinates) {
        this.textureCoordinates = textureCoordinates;
    }
}
