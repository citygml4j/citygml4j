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
