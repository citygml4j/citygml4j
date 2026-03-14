/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.visitor;

import org.xmlobjects.gml.visitor.Visitable;

public interface VisitableObject extends Visitable {
    void accept(ObjectVisitor visitor);
}
