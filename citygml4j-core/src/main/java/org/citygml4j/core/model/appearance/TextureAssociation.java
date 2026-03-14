/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.CityGMLObject;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.citygml4j.core.visitor.VisitableObject;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;

public class TextureAssociation extends AbstractGML implements CityGMLObject, VisitableObject {
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
