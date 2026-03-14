/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.basictypes.Code;

public abstract class AbstractTexture extends AbstractSurfaceData implements CityGMLObject {
    private String imageURI;
    private Code mimeType;
    private TextureType textureType;
    private WrapMode wrapMode;
    private ColorPlusOpacity borderColor;

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public Code getMimeType() {
        return mimeType;
    }

    public void setMimeType(Code mimeType) {
        this.mimeType = asChild(mimeType);
    }

    public TextureType getTextureType() {
        return textureType;
    }

    public void setTextureType(TextureType textureType) {
        this.textureType = textureType;
    }

    public WrapMode getWrapMode() {
        return wrapMode;
    }

    public void setWrapMode(WrapMode wrapMode) {
        this.wrapMode = wrapMode;
    }

    public ColorPlusOpacity getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(ColorPlusOpacity borderColor) {
        this.borderColor = asChild(borderColor);
    }
}
