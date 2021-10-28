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

import org.citygml4j.model.core.TransformationMatrix2x2;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class GeoreferencedTexture extends AbstractTexture {
    private Boolean preferWorldFile;
    private PointProperty referencePoint;
    private TransformationMatrix2x2 orientation;
    private List<GeometryReference> targets;
    private List<ADEOfGeoreferencedTexture> adeOfGeoreferencedTexture;

    public Boolean getPreferWorldFile() {
        return preferWorldFile;
    }

    public boolean isSetPreferWorldFile() {
        return preferWorldFile != null;
    }

    public void setPreferWorldFile(Boolean preferWorldFile) {
        this.preferWorldFile = preferWorldFile;
    }

    public PointProperty getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(PointProperty referencePoint) {
        this.referencePoint = asChild(referencePoint);
    }

    public TransformationMatrix2x2 getOrientation() {
        return orientation;
    }

    public void setOrientation(TransformationMatrix2x2 orientation) {
        this.orientation = asChild(orientation);
    }

    public List<GeometryReference> getTargets() {
        if (targets == null)
            targets = new ChildList<>(this);

        return targets;
    }

    public void setTargets(List<GeometryReference> targets) {
        this.targets = asChild(targets);
    }

    public List<ADEOfGeoreferencedTexture> getADEOfGeoreferencedTexture() {
        if (adeOfGeoreferencedTexture == null)
            adeOfGeoreferencedTexture = new ChildList<>(this);

        return adeOfGeoreferencedTexture;
    }

    public void setADEOfGeoreferencedTexture(List<ADEOfGeoreferencedTexture> adeOfGeoreferencedTexture) {
        this.adeOfGeoreferencedTexture = asChild(adeOfGeoreferencedTexture);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
