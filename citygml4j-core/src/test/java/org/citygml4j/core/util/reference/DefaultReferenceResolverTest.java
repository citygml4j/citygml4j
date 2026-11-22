/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.util.reference;

import org.citygml4j.core.model.building.Building;
import org.junit.jupiter.api.Test;
import org.xmlobjects.gml.visitor.Visitable;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DefaultReferenceResolverTest {

    @Test
    void nullScopesGiveEmptyMap() {
        DefaultReferenceResolver resolver = DefaultReferenceResolver.newInstance();
        assertTrue(resolver.getObjectsById(Building.class, (Visitable[]) null).isEmpty());
        assertNotNull(resolver.getObjectsById((Visitable[]) null));
    }
}
