/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.writer;

import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceSerializer;
import org.citygml4j.core.model.appearance.ParameterizedTexture;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class AppearanceSerializerTest {

    @Test
    void texturesWithCollidingHashCodesAreDistinct() throws Exception {
        // "Aa" and "BB" have the same String.hashCode()
        ParameterizedTexture first = new ParameterizedTexture();
        first.setImageURI("Aa");
        ParameterizedTexture second = new ParameterizedTexture();
        second.setImageURI("BB");

        try (CityJSONWriter writer = CityJSONContext.newInstance().createCityJSONOutputFactory()
                .createCityJSONWriter(new ByteArrayOutputStream())) {
            AppearanceSerializer serializer = writer.helper.getAppearanceSerializer();
            assertNotSame(serializer.getOrCreateTexture(first), serializer.getOrCreateTexture(second));
            assertEquals(serializer.getOrCreateTexture(first), serializer.getOrCreateTexture(first));
        }
    }
}
