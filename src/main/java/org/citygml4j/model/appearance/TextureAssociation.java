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

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.visitor.ObjectVisitor;
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;

public class TextureAssociation extends AbstractGML implements CityGMLObject, Visitable {
    private GeometryReference target;
    private AbstractTextureParameterizationProperty textureParameterization;

    public TextureAssociation() {
    }

    public TextureAssociation(GeometryReference target, AbstractTextureParameterizationProperty textureParameterization) {
        setTarget(target);
        setTextureParameterization(textureParameterization);
    }

    public TextureAssociation(String target, AbstractTextureParameterizationProperty textureParameterization) {
        this(new GeometryReference(target), textureParameterization);
    }

    public TextureAssociation(AbstractGeometry target, AbstractTextureParameterizationProperty textureParameterization) {
        this(new GeometryReference(target), textureParameterization);
    }

    public GeometryReference getTarget() {
        return target;
    }

    public void setTarget(GeometryReference target) {
        this.target = asChild(target);
    }

    public AbstractTextureParameterizationProperty getTextureParameterization() {
        return textureParameterization;
    }

    public void setTextureParameterization(AbstractTextureParameterizationProperty textureParameterization) {
        this.textureParameterization = asChild(textureParameterization);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
