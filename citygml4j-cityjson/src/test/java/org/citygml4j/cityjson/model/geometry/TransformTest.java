/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.model.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransformTest {

    @Test
    void defaultsAreIdentity() {
        Transform transform = new Transform();
        assertEquals(1, transform.getScale().getX());
        assertEquals(1, transform.getScale().getY());
        assertEquals(1, transform.getScale().getZ());
        assertEquals(0, transform.getTranslate().getX());
        assertEquals(0, transform.getTranslate().getY());
        assertEquals(0, transform.getTranslate().getZ());
    }
}
