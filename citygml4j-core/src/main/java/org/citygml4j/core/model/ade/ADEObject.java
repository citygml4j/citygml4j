/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.ade;

import org.citygml4j.core.visitor.ObjectVisitor;
import org.citygml4j.core.visitor.VisitableObject;
import org.xmlobjects.model.Child;

import java.io.Serializable;

public interface ADEObject extends Child, VisitableObject, Serializable {

    @Override
    default void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
