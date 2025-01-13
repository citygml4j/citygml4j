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

import java.util.ArrayList;
import java.util.List;

public class X3DMaterial extends AbstractSurfaceData {
    private Double ambientIntensity;
    private Color diffuseColor;
    private Color emissiveColor;
    private Color specularColor;
    private Double shininess;
    private Double transparency;
    private Boolean isSmooth;
    private List<String> target;
    private List<ADEComponent> ade;

    public X3DMaterial() {

    }

    public X3DMaterial(Module module) {
        super(module);
    }

    public void addGenericApplicationPropertyOfX3DMaterial(ADEComponent ade) {
        getGenericApplicationPropertyOfX3DMaterial().add(ade);
    }

    public void addTarget(String target) {
        getTarget().add(target);
    }

    public Double getAmbientIntensity() {
        return !isSetAmbientIntensity() ? 0.2 : ambientIntensity;
    }

    public Color getDiffuseColor() {
        return !isSetDiffuseColor() ? new Color(0.8) : diffuseColor;
    }

    public Color getEmissiveColor() {
        return !isSetEmissiveColor() ? new Color(0.0) : emissiveColor;
    }

    public List<ADEComponent> getGenericApplicationPropertyOfX3DMaterial() {
        if (ade == null)
            ade = new ChildList<>(this);

        return ade;
    }

    public Boolean getIsSmooth() {
        return !isSetIsSmooth() ? false : isSmooth;
    }

    public Double getShininess() {
        return !isSetShininess() ? 0.2 : shininess;
    }

    public Color getSpecularColor() {
        return !isSetSpecularColor() ? new Color(1.0) : specularColor;
    }

    public List<String> getTarget() {
        if (target == null)
            target = new ArrayList<>();

        return target;
    }

    public Double getTransparency() {
        return !isSetTransparency() ? 0.0 : transparency;
    }

    public boolean isSetAmbientIntensity() {
        return ambientIntensity != null;
    }

    public boolean isSetDiffuseColor() {
        return diffuseColor != null;
    }

    public boolean isSetEmissiveColor() {
        return emissiveColor != null;
    }

    public boolean isSetGenericApplicationPropertyOfX3DMaterial() {
        return ade != null && !ade.isEmpty();
    }

    public boolean isSetIsSmooth() {
        return isSmooth != null;
    }

    public boolean isSetShininess() {
        return shininess != null;
    }

    public boolean isSetSpecularColor() {
        return specularColor != null;
    }

    public boolean isSetTarget() {
        return target != null && !target.isEmpty();
    }

    public boolean isSetTransparency() {
        return transparency != null;
    }

    public void setAmbientIntensity(Double ambientIntensity) {
        if (ambientIntensity >= 0.0 && ambientIntensity <= 1.0)
            this.ambientIntensity = ambientIntensity;
    }

    public void setDiffuseColor(Color diffuseColor) {
        this.diffuseColor = ModelObjects.setParent(diffuseColor, this);
    }

    public void setEmissiveColor(Color emissiveColor) {
        this.emissiveColor = ModelObjects.setParent(emissiveColor, this);
    }

    public void setGenericApplicationPropertyOfX3DMaterial(List<ADEComponent> ade) {
        this.ade = new ChildList<>(this, ade);
    }

    public void setIsSmooth(Boolean isSmooth) {
        this.isSmooth = isSmooth;
    }

    public void setShininess(Double shininess) {
        if (shininess >= 0.0 && shininess <= 1.0)
            this.shininess = shininess;
    }

    public void setSpecularColor(Color specularColor) {
        this.specularColor = ModelObjects.setParent(specularColor, this);
    }

    public void setTarget(List<String> target) {
        this.target = target;
    }

    public void setTransparency(Double transparency) {
        if (transparency >= 0.0 && transparency <= 1.0)
            this.transparency = transparency;
    }

    public void unsetAmbientIntensity() {
        ambientIntensity = null;
    }

    public void unsetDiffuseColor() {
        diffuseColor = ModelObjects.setNull(diffuseColor);
    }

    public void unsetEmissiveColor() {
        emissiveColor = ModelObjects.setNull(emissiveColor);
    }

    public void unsetGenericApplicationPropertyOfX3DMaterial() {
        ade = ModelObjects.setNull(ade);
    }

    public boolean unsetGenericApplicationPropertyOfX3DMaterial(ADEComponent ade) {
        return isSetGenericApplicationPropertyOfX3DMaterial() && this.ade.remove(ade);
    }

    public void unsetIsSmooth() {
        isSmooth = null;
    }

    public void unsetShininess() {
        shininess = null;
    }

    public void unsetSpecularColor() {
        specularColor = ModelObjects.setNull(specularColor);
    }

    public void unsetTarget() {
        target = null;
    }

    public boolean unsetTarget(String target) {
        return isSetTarget() && this.target.remove(target);
    }

    public void unsetTransparency() {
        transparency = null;
    }

    public CityGMLClass getCityGMLClass() {
        return CityGMLClass.X3D_MATERIAL;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new X3DMaterial(), copyBuilder);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        X3DMaterial copy = (target == null) ? new X3DMaterial() : (X3DMaterial) target;
        super.copyTo(copy, copyBuilder);

        if (isSetAmbientIntensity())
            copy.setAmbientIntensity((Double) copyBuilder.copy(ambientIntensity));

        if (isSetShininess())
            copy.setShininess((Double) copyBuilder.copy(shininess));

        if (isSetTransparency())
            copy.setTransparency((Double) copyBuilder.copy(transparency));

        if (isSetIsSmooth())
            copy.setIsSmooth(copyBuilder.copy(isSmooth));

        if (isSetTarget())
            copy.setTarget((List<String>) copyBuilder.copy(this.target));

        if (isSetDiffuseColor()) {
            copy.setDiffuseColor((Color) copyBuilder.copy(diffuseColor));
            if (copy.getDiffuseColor() == diffuseColor)
                diffuseColor.setParent(this);
        }

        if (isSetEmissiveColor()) {
            copy.setEmissiveColor((Color) copyBuilder.copy(emissiveColor));
            if (copy.getEmissiveColor() == emissiveColor)
                emissiveColor.setParent(this);
        }

        if (isSetEmissiveColor()) {
            copy.setSpecularColor((Color) copyBuilder.copy(specularColor));
            if (copy.getSpecularColor() == specularColor)
                specularColor.setParent(this);
        }

        if (isSetGenericApplicationPropertyOfX3DMaterial()) {
            for (ADEComponent part : ade) {
                ADEComponent copyPart = (ADEComponent) copyBuilder.copy(part);
                copy.addGenericApplicationPropertyOfX3DMaterial(copyPart);

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
