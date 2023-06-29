/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.builder.cityjson.json.io.reader;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.util.CityGMLMetadata;
import org.citygml4j.builder.cityjson.util.TextureFileHandler;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.CityJSONRegistry;
import org.citygml4j.cityjson.CityJSONTypeAdapterFactory;
import org.citygml4j.cityjson.extension.ExtensionException;
import org.citygml4j.cityjson.feature.CityObjectTypeFilter;
import org.citygml4j.xml.io.reader.CityGMLInputFilter;

import java.io.IOException;
import java.io.Reader;

public abstract class AbstractCityJSONReader implements AutoCloseable {
    private final Reader reader;
    private final boolean processUnknownExtensions;

    private CityObjectTypeFilter typeFilter;
    private CityGMLInputFilter nameFilter;
    private TextureFileHandler textureFileHandler;

    public AbstractCityJSONReader(Reader reader, boolean processUnknownExtensions) {
        this.reader = reader;
        this.processUnknownExtensions = processUnknownExtensions;

        CityJSONRegistry registry = CityJSONRegistry.getInstance();
        if (!registry.hasExtensionProperty(CityGMLMetadata.JSON_KEY, CityJSON.class)) {
            try {
                registry.registerExtensionProperty(CityGMLMetadata.JSON_KEY, CityGMLMetadata.class, CityJSON.class);
            } catch (ExtensionException e) {
                //
            }
        }
    }

    public TextureFileHandler getTextureFileHandler() {
        return textureFileHandler;
    }

    public void setTextureFileHandler(TextureFileHandler textureFileHandler) {
        this.textureFileHandler = textureFileHandler;
    }

    void setObjectTypeFilter(CityObjectTypeFilter typeFilter) {
        this.typeFilter = typeFilter;
    }

    void setCityGMLNameFilter(CityGMLInputFilter nameFilter) {
        this.nameFilter = nameFilter;
    }

    CityJSON readCityJSON() throws CityJSONReadException {
        try {
            return new GsonBuilder()
                    .registerTypeAdapterFactory(new CityJSONTypeAdapterFactory()
                            .withTypeFilter(typeFilter)
                            .processUnknownExtensions(processUnknownExtensions))
                    .create()
                    .fromJson(reader, CityJSON.class);
        } catch (JsonIOException | JsonSyntaxException e) {
            throw new CityJSONReadException("Caused by: ", e);
        }
    }

    CityJSONUnmarshaller getCityJSONUnmarshaller() {
        CityJSONUnmarshaller unmarshaller = new CityJSONUnmarshaller();
        if (nameFilter != null)
            unmarshaller.setCityGMLNameFilter(nameFilter);

        if (textureFileHandler != null)
            unmarshaller.setTextureFileHandler(textureFileHandler);

        return unmarshaller;
    }

    @Override
    public void close() throws CityJSONReadException {
        try {
            reader.close();
        } catch (IOException e) {
            throw new CityJSONReadException("Caused by: ", e);
        }
    }
}
