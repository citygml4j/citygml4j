/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.util;

import org.citygml4j.core.model.core.AbstractSpaceBoundary;

@FunctionalInterface
public interface BoundaryFilter {
    boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type);

    default boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return isValidBoundary(boundary.getClass());
    }
}
