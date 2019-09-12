package org.citygml4j.model.appearance;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class AbstractTexture extends AbstractSurfaceData implements CityGMLObject {
    private String imageURI;
    private Code mimeType;
    private TextureType textureType;
    private WrapMode wrapMode;
    private ColorPlusOpacity borderColor;
    private List<ADEPropertyOfAbstractTexture> adeProperties;

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

    public List<ADEPropertyOfAbstractTexture> getADEPropertiesOfAbstractTexture() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractTexture(List<ADEPropertyOfAbstractTexture> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
