package org.citygml4j.model.appearance;

import java.util.ArrayList;
import java.util.List;

public class TexCoordList extends AbstractTextureParameterization {
    private List<Double> textureCoordinates;
    private List<String> rings;

    public List<Double> getTextureCoordinates() {
        if (textureCoordinates == null)
            textureCoordinates = new ArrayList<>();

        return textureCoordinates;
    }

    public void setTextureCoordinates(List<Double> textureCoordinates) {
        this.textureCoordinates = textureCoordinates;
    }

    public List<String> getRings() {
        if (rings == null)
            rings = new ArrayList<>();

        return rings;
    }

    public void setRings(List<String> rings) {
        this.rings = rings;
    }
}
