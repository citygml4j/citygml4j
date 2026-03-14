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
import org.xmlobjects.model.ChildList;

import java.util.List;

public class ClearanceSpace extends AbstractUnoccupiedSpace {
    private List<Code> classifiers;

    @Override
    public boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type) {
        return ClosureSurface.class.isAssignableFrom(type)
                || GenericThematicSurface.class.isAssignableFrom(type)
                || ADEObject.class.isAssignableFrom(type);
    }

    public List<Code> getClassifiers() {
        if (classifiers == null)
            classifiers = new ChildList<>(this);

        return classifiers;
    }

    public boolean isSetClassifiers() {
        return classifiers != null && !classifiers.isEmpty();
    }

    public void setClassifiers(List<Code> classifiers) {
        this.classifiers = asChild(classifiers);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
