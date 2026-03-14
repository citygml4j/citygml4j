/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.transportation;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;
import org.citygml4j.core.model.core.AbstractUnoccupiedSpace;
import org.citygml4j.core.model.core.ClosureSurface;
import org.citygml4j.core.model.generics.GenericThematicSurface;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;

public class Hole extends AbstractUnoccupiedSpace {
    private Code classifier;

    @Override
    public boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type) {
        return HoleSurface.class.isAssignableFrom(type)
                || ClosureSurface.class.isAssignableFrom(type)
                || GenericThematicSurface.class.isAssignableFrom(type)
                || ADEObject.class.isAssignableFrom(type);
    }

    public Code getClassifier() {
        return classifier;
    }

    public void setClassifier(Code classifier) {
        this.classifier = asChild(classifier);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
