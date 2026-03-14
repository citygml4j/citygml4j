/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.deprecated.appearance.DeprecatedPropertiesOfParameterizedTexture;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class ParameterizedTexture extends AbstractTexture {
    private List<TextureAssociationProperty> textureParameterizations;

    public List<TextureAssociationProperty> getTextureParameterizations() {
        if (textureParameterizations == null)
            textureParameterizations = new ChildList<>(this);

        return textureParameterizations;
    }

    public boolean isSetTextureParameterizations() {
        return textureParameterizations != null && !textureParameterizations.isEmpty();
    }

    public void setTextureParameterizations(List<TextureAssociationProperty> textureParameterizations) {
        this.textureParameterizations = asChild(textureParameterizations);
    }

    @Override
    public DeprecatedPropertiesOfParameterizedTexture getDeprecatedProperties() {
        return super.getDeprecatedProperties(DeprecatedPropertiesOfParameterizedTexture.class);
    }

    @Override
    protected DeprecatedPropertiesOfParameterizedTexture createDeprecatedProperties() {
        return new DeprecatedPropertiesOfParameterizedTexture();
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
