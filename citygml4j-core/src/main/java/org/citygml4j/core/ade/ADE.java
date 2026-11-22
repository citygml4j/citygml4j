/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.ade;

import org.atteo.classindex.IndexSubclasses;
import org.citygml4j.core.visitor.ADEWalker;

@IndexSubclasses
public interface ADE {
    String getName();

    String getVersion();

    /**
     * Returns a walker for the objects of this ADE, or {@code null} if the ADE does not provide one.
     * <p>
     * Every {@code ObjectWalker} registers itself as parent of the returned walker, so implementations
     * must return a new instance on each call.
     */
    default ADEWalker getADEWalker() {
        return null;
    }
}
