/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.reader;

import org.citygml4j.cityjson.CityJSONContext;
import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CityJSONChunkReaderTest {

    @Test
    void emptyInputHasNoFeatures() throws Exception {
        CityJSONInputFactory in = CityJSONContext.newInstance().createCityJSONInputFactory()
                .chunkByTopLevelCityObjects(true);

        try (CityJSONReader reader = in.createCityJSONReader(new StringReader(""))) {
            assertFalse(reader.hasNext());
        }

        try (CityJSONReader reader = in.createCityJSONReader(new StringReader("[]"))) {
            assertFalse(reader.hasNext());
        }
    }
}
