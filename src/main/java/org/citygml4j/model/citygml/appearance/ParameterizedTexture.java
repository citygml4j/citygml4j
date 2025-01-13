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
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.Module;

import java.util.List;

public class ParameterizedTexture extends AbstractTexture {
    private List<TextureAssociation> target;
    private List<ADEComponent> ade;

    public ParameterizedTexture() {

    }

    public ParameterizedTexture(Module module) {
        super(module);
    }

    public void addGenericApplicationPropertyOfParameterizedTexture(ADEComponent ade) {
        getGenericApplicationPropertyOfParameterizedTexture().add(ade);
    }

    public void addTarget(TextureAssociation target) {
        getTarget().add(target);
    }

    public List<ADEComponent> getGenericApplicationPropertyOfParameterizedTexture() {
        if (ade == null)
            ade = new ChildList<>(this);

        return ade;
    }

    public List<TextureAssociation> getTarget() {
        if (target == null)
            target = new ChildList<>(this);

        return target;
    }

    public boolean isSetGenericApplicationPropertyOfParameterizedTexture() {
        return ade != null && !ade.isEmpty();
    }

    public boolean isSetTarget() {
        return target != null && !target.isEmpty();
    }

    public void setGenericApplicationPropertyOfParameterizedTexture(List<ADEComponent> ade) {
        this.ade = new ChildList<>(this, ade);
    }

    public void setTarget(List<TextureAssociation> target) {
        this.target = new ChildList<>(this, target);
    }

    public void unsetGenericApplicationPropertyOfParameterizedTexture() {
        ade = ModelObjects.setNull(ade);
    }

    public boolean unsetGenericApplicationPropertyOfParameterizedTexture(ADEComponent ade) {
        return isSetGenericApplicationPropertyOfParameterizedTexture() && this.ade.remove(ade);
    }

    public void unsetTarget() {
        target = ModelObjects.setNull(target);
    }

    public boolean unsetTarget(TextureAssociation target) {
        return isSetTarget() && this.target.remove(target);
    }

    public CityGMLClass getCityGMLClass() {
        return CityGMLClass.PARAMETERIZED_TEXTURE;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new ParameterizedTexture(), copyBuilder);
    }

    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        ParameterizedTexture copy = (target == null) ? new ParameterizedTexture() : (ParameterizedTexture) target;
        super.copyTo(copy, copyBuilder);

        if (isSetTarget()) {
            for (TextureAssociation part : this.target) {
                TextureAssociation copyPart = (TextureAssociation) copyBuilder.copy(part);
                copy.addTarget(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetGenericApplicationPropertyOfParameterizedTexture()) {
            for (ADEComponent part : ade) {
                ADEComponent copyPart = (ADEComponent) copyBuilder.copy(part);
                copy.addGenericApplicationPropertyOfParameterizedTexture(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        return copy;
    }

    public void accept(FeatureVisitor visitor) {
        visitor.visit(this);
    }

    public <T> T accept(FeatureFunctor<T> visitor) {
        return visitor.apply(this);
    }

    public void accept(GMLVisitor visitor) {
        visitor.visit(this);
    }

    public <T> T accept(GMLFunctor<T> visitor) {
        return visitor.apply(this);
    }

}
