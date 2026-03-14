/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.core.TransformationMatrix2x2;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class GeoreferencedTexture extends AbstractTexture {
    private Boolean preferWorldFile;
    private PointProperty referencePoint;
    private TransformationMatrix2x2 orientation;
    private List<GeometryReference> targets;

    public Boolean getPreferWorldFile() {
        return preferWorldFile != null ? preferWorldFile : true;
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
