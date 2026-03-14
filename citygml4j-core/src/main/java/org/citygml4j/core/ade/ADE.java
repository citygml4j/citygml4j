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

    default ADEWalker getADEWalker() {
        return null;
    }
}
