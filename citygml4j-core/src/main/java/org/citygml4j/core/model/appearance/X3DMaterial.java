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

import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class X3DMaterial extends AbstractSurfaceData {
    private Double ambientIntensity;
    private Color diffuseColor;
    private Color emissiveColor;
    private Color specularColor;
    private Double shininess;
    private Double transparency;
    private Boolean isSmooth;
    private List<GeometryReference> targets;

    public Double getAmbientIntensity() {
        return ambientIntensity != null ? ambientIntensity : 0.2;
    }

    public boolean isSetAmbientIntensity() {
        return ambientIntensity != null;
    }

    public void setAmbientIntensity(Double ambientIntensity) {
        if (ambientIntensity == null || (ambientIntensity >= 0 && ambientIntensity <= 1))
            this.ambientIntensity = ambientIntensity;
    }

    public Color getDiffuseColor() {
        return diffuseColor != null ? diffuseColor : new Color(0.8);
    }

    public boolean isSetDiffuseColor() {
        return diffuseColor != null;
    }

    public void setDiffuseColor(Color diffuseColor) {
        this.diffuseColor = diffuseColor;
    }

    public Color getEmissiveColor() {
        return emissiveColor != null ? emissiveColor : new Color(0);
    }

    public boolean isSetEmissiveColor() {
        return emissiveColor != null;
    }

    public void setEmissiveColor(Color emissiveColor) {
        this.emissiveColor = emissiveColor;
    }

    public Color getSpecularColor() {
        return specularColor != null ? specularColor : new Color(1);
    }

    public boolean isSetSpecularColor() {
        return specularColor != null;
    }

    public void setSpecularColor(Color specularColor) {
        this.specularColor = specularColor;
    }

    public Double getShininess() {
        return shininess != null ? shininess : 0.2;
    }

    public boolean isSetShininess() {
        return shininess != null;
    }

    public void setShininess(Double shininess) {
        if (shininess == null || (shininess >= 0 && shininess <= 1))
            this.shininess = shininess;
    }

    public Double getTransparency() {
        return transparency != null ? transparency : 0;
    }

    public boolean isSetTransparency() {
        return transparency != null;
    }

    public void setTransparency(Double transparency) {
        if (transparency == null || (transparency >= 0 && transparency <= 1))
            this.transparency = transparency;
    }

    public Boolean getIsSmooth() {
        return isSmooth != null ? isSmooth : false;
    }

    public boolean isSetIsSmooth() {
        return isSmooth != null;
    }

    public void setIsSmooth(Boolean smooth) {
        isSmooth = smooth;
    }

    public List<GeometryReference> getTargets() {
        if (targets == null)
            targets = new ChildList<>(this);

        return targets;
    }

    public boolean isSetTargets() {
        return targets != null && !targets.isEmpty();
    }

    public void setTargets(List<GeometryReference> targets) {
        this.targets = asChild(targets);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
