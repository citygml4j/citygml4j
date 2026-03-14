/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.visitor;

public abstract class ADEWalker implements Walker {
    protected ObjectWalker walker;

    public final ObjectWalker getParentWalker() {
        return walker;
    }

    final void setParentWalker(ObjectWalker walker) {
        this.walker = walker;
    }
}
