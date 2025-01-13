/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.module.Module;

import java.util.List;

public abstract class AbstractTexture extends AbstractSurfaceData {
    private String imageURI;
    private Code mimeType;
    private TextureType textureType;
    private WrapMode wrapMode;
    private ColorPlusOpacity borderColor;
    private List<ADEComponent> ade;

    public AbstractTexture() {

    }

    public AbstractTexture(Module module) {
        super(module);
    }

    public void addGenericApplicationPropertyOfTexture(ADEComponent ade) {
        getGenericApplicationPropertyOfTexture().add(ade);
    }

    public ColorPlusOpacity getBorderColor() {
        return borderColor;
    }

    public List<ADEComponent> getGenericApplicationPropertyOfTexture() {
        if (ade == null)
            ade = new ChildList<>(this);

        return ade;
    }

    public String getImageURI() {
        return imageURI;
    }

    public Code getMimeType() {
        return mimeType;
    }

    public TextureType getTextureType() {
        return textureType;
    }

    public WrapMode getWrapMode() {
        return wrapMode;
    }

    public boolean isSetBorderColor() {
        return borderColor != null;
    }

    public boolean isSetGenericApplicationPropertyOfTexture() {
        return ade != null && !ade.isEmpty();
    }

    public boolean isSetImageURI() {
        return imageURI != null;
    }

    public boolean isSetMimeType() {
        return mimeType != null;
    }

    public boolean isSetTextureType() {
        return textureType != null;
    }

    public boolean isSetWrapMode() {
        return wrapMode != null;
    }

    public void setBorderColor(ColorPlusOpacity borderColor) {
        this.borderColor = ModelObjects.setParent(borderColor, this);
    }

    public void setGenericApplicationPropertyOfTexture(List<ADEComponent> ade) {
        this.ade = new ChildList<>(this, ade);
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public void setMimeType(Code mimeType) {
        this.mimeType = ModelObjects.setParent(mimeType, this);
    }

    public void setTextureType(TextureType textureType) {
        this.textureType = textureType;
    }

    public void setWrapMode(WrapMode wrapMode) {
        this.wrapMode = wrapMode;
    }

    public void unsetBorderColor() {
        borderColor = ModelObjects.setNull(borderColor);
    }

    public void unsetGenericApplicationPropertyOfTexture() {
        ade = ModelObjects.setNull(ade);
    }

    public boolean unsetGenericApplicationPropertyOfTexture(ADEComponent ade) {
        return isSetGenericApplicationPropertyOfTexture() && this.ade.remove(ade);
    }

    public void unsetImageURI() {
        imageURI = null;
    }

    public void unsetMimeType() {
        mimeType = null;
    }

    public void unsetTextureType() {
        textureType = null;
    }

    public void unsetWrapMode() {
        wrapMode = null;
    }

    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        if (target == null)
            throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

        AbstractTexture copy = (AbstractTexture) target;
        super.copyTo(copy, copyBuilder);

        if (isSetImageURI())
            copy.setImageURI(copyBuilder.copy(imageURI));

        if (isSetMimeType())
            copy.setMimeType((Code) copyBuilder.copy(mimeType));

        if (isSetTextureType())
            copy.setTextureType((TextureType) copyBuilder.copy(textureType));

        if (isSetWrapMode())
            copy.setWrapMode((WrapMode) copyBuilder.copy(wrapMode));

        if (isSetBorderColor()) {
            copy.setBorderColor((ColorPlusOpacity) copyBuilder.copy(borderColor));
            if (copy.getBorderColor() == borderColor)
                borderColor.setParent(this);
        }

        if (isSetGenericApplicationPropertyOfTexture()) {
            for (ADEComponent part : ade) {
                ADEComponent copyPart = (ADEComponent) copyBuilder.copy(part);
                copy.addGenericApplicationPropertyOfTexture(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        return copy;
    }

}
