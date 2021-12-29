/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.model.appearance;

import org.citygml4j.model.deprecated.appearance.DeprecatedPropertiesOfParameterizedTexture;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class ParameterizedTexture extends AbstractTexture {
    private List<TextureAssociationProperty> textureParameterizations;
    private List<ADEOfParameterizedTexture> adeOfParameterizedTexture;

    public List<TextureAssociationProperty> getTextureParameterizations() {
        if (textureParameterizations == null)
            textureParameterizations = new ChildList<>(this);

        return textureParameterizations;
    }

    public void setTextureParameterizations(List<TextureAssociationProperty> textureParameterizations) {
        this.textureParameterizations = asChild(textureParameterizations);
    }

    @Override
    public DeprecatedPropertiesOfParameterizedTexture getDeprecatedProperties() {
        return (DeprecatedPropertiesOfParameterizedTexture) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfParameterizedTexture createDeprecatedProperties() {
        return new DeprecatedPropertiesOfParameterizedTexture();
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
