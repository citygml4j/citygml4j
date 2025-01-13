/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.builder.cityjson.json.io.writer;

import com.google.gson.stream.JsonWriter;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.model.citygml.core.CityModel;

public class CityJSONWriter extends AbstractCityJSONWriter {
    private DocumentState documentState = DocumentState.INITIAL;

    private enum DocumentState {
        INITIAL,
        END_DOCUMENT,
    }

    public CityJSONWriter(JsonWriter writer, CityJSONOutputFactory factory) {
        super(writer, factory);
    }

    public void write(CityModel cityModel) throws CityJSONWriteException {
        if (documentState == DocumentState.END_DOCUMENT)
            throw new IllegalStateException("CityJSON document is already complete.");

        CityJSON cityJSON = marshaller.marshal(cityModel);
        if (cityJSON != null) {
            if (calcBoundingBox
                    && (metadata == null || !metadata.isSetGeographicalExtent())
                    && !cityJSON.getVertices().isEmpty()) {
                getOrCreateMetadata().setGeographicalExtent(cityJSON.calcBoundingBox());
            }

            if (calcPresentLods
                    && (metadata == null || !metadata.isSetPresentLoDs())
                    && cityJSON.hasCityObjects()) {
                getOrCreateMetadata().setPresentLoDs(cityJSON.calcPresentLoDs());
            }

            // add metadata
            if (metadata != null) {
                cityJSON.setMetadata(metadata);
            }

            // add extensions
            if (extensions != null) {
                cityJSON.setExtensions(extensions);
            }

            gson.toJson(cityJSON, CityJSON.class, writer);
        }

        documentState = DocumentState.END_DOCUMENT;
    }

    @Override
    public void close() throws CityJSONWriteException {
        if (documentState == DocumentState.INITIAL) {
            gson.toJson(new CityJSON(), CityJSON.class, writer);
        }

        super.close();
    }
}
