/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.appearance;

import org.xmlobjects.model.ChildList;

import java.util.List;

public class TexCoordList extends AbstractTextureParameterization {
    private List<TextureCoordinates> textureCoordinates;

    public List<TextureCoordinates> getTextureCoordinates() {
        if (textureCoordinates == null)
            textureCoordinates = new ChildList<>(this);

        return textureCoordinates;
    }

    public boolean isSetTextureCoordinates() {
        return textureCoordinates != null && !textureCoordinates.isEmpty();
    }

    public void setTextureCoordinates(List<TextureCoordinates> textureCoordinates) {
        this.textureCoordinates = asChild(textureCoordinates);
    }
}
