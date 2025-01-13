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
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.Module;

import java.util.List;

public class TexCoordList extends AbstractTextureParameterization {
    private List<TextureCoordinates> textureCoordinates;
    private List<ADEComponent> ade;

    public TexCoordList() {

    }

    public TexCoordList(Module module) {
        super(module);
    }

    public void addGenericApplicationPropertyOfTexCoordList(ADEComponent ade) {
        getGenericApplicationPropertyOfTexCoordList().add(ade);
    }

    public void addTextureCoordinates(TextureCoordinates textureCoordinates) {
        getTextureCoordinates().add(textureCoordinates);
    }

    public List<ADEComponent> getGenericApplicationPropertyOfTexCoordList() {
        if (ade == null)
            ade = new ChildList<>(this);

        return ade;
    }

    public List<TextureCoordinates> getTextureCoordinates() {
        if (textureCoordinates == null)
            textureCoordinates = new ChildList<>(this);

        return textureCoordinates;
    }

    public boolean isSetGenericApplicationPropertyOfTexCoordList() {
        return ade != null && !ade.isEmpty();
    }

    public boolean isSetTextureCoordinates() {
        return textureCoordinates != null && !textureCoordinates.isEmpty();
    }

    public void setGenericApplicationPropertyOfTexCoordList(List<ADEComponent> ade) {
        this.ade = new ChildList<>(this, ade);
    }

    public void setTextureCoordinates(List<TextureCoordinates> textureCoordinates) {
        this.textureCoordinates = new ChildList<>(this, textureCoordinates);
    }

    public void unsetGenericApplicationPropertyOfTexCoordList() {
        ade = ModelObjects.setNull(ade);
    }

    public boolean unsetGenericApplicationPropertyOfTexCoordList(ADEComponent ade) {
        return isSetGenericApplicationPropertyOfTexCoordList() && this.ade.remove(ade);
    }

    public void unsetTextureCoordinates() {
        textureCoordinates = ModelObjects.setNull(textureCoordinates);
    }

    public boolean unsetTextureCoordinates(TextureCoordinates textureCoordinates) {
        return isSetTextureCoordinates() && this.textureCoordinates.remove(textureCoordinates);
    }

    public CityGMLClass getCityGMLClass() {
        return CityGMLClass.TEX_COORD_LIST;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new TexCoordList(), copyBuilder);
    }

    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        TexCoordList copy = (target == null) ? new TexCoordList() : (TexCoordList) target;
        super.copyTo(copy, copyBuilder);

        if (isSetTextureCoordinates()) {
            for (TextureCoordinates part : textureCoordinates) {
                TextureCoordinates copyPart = (TextureCoordinates) copyBuilder.copy(part);
                copy.addTextureCoordinates(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetGenericApplicationPropertyOfTexCoordList()) {
            for (ADEComponent part : ade) {
                ADEComponent copyPart = (ADEComponent) copyBuilder.copy(part);
                copy.addGenericApplicationPropertyOfTexCoordList(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        return copy;
    }

    public void accept(GMLVisitor visitor) {
        visitor.visit(this);
    }

    public <T> T accept(GMLFunctor<T> visitor) {
        return visitor.apply(this);
    }

}
