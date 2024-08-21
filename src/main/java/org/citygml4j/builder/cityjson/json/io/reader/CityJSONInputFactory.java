/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.cityjson.feature.CityObjectTypeFilter;
import org.citygml4j.xml.io.reader.CityGMLInputFilter;

import java.io.*;

public class CityJSONInputFactory {
    boolean processUnknownExtensions;

    public CityJSONReader createCityJSONReader(File file) throws CityJSONReadException {
        try {
            return new CityJSONReader(new BufferedReader(new FileReader(file)), this);
        } catch (FileNotFoundException e) {
            throw new CityJSONReadException("Caused by: ", e);
        }
    }

    public CityJSONReader createCityJSONReader(File file, String encoding) throws CityJSONReadException {
        try {
            return new CityJSONReader(new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding)), this);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new CityJSONReadException("Caused by: ", e);
        }
    }

    public CityJSONReader createCityJSONReader(InputStream inputStream) throws CityJSONReadException {
        return new CityJSONReader(new InputStreamReader(inputStream), this);
    }

    public CityJSONReader createCityJSONReader(InputStream inputStream, String encoding) throws CityJSONReadException {
        try {
            return new CityJSONReader(new InputStreamReader(inputStream, encoding), this);
        } catch (UnsupportedEncodingException e) {
            throw new CityJSONReadException("Caused by: ", e);
        }
    }

    public CityJSONChunkReader createCityJSONChunkReader(File file) throws CityJSONReadException {
        try {
            return new CityJSONChunkReader(new BufferedReader(new FileReader(file)), this);
        } catch (FileNotFoundException e) {
            throw new CityJSONReadException("Caused by: ", e);
        }
    }

    public CityJSONChunkReader createCityJSONChunkReader(File file, String encoding) throws CityJSONReadException {
        try {
            return new CityJSONChunkReader(new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding)), this);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new CityJSONReadException("Caused by: ", e);
        }
    }

    public CityJSONChunkReader createCityJSONChunkReader(InputStream inputStream) throws CityJSONReadException {
        return new CityJSONChunkReader(new InputStreamReader(inputStream), this);
    }

    public CityJSONChunkReader createCityJSONChunkReader(InputStream inputStream, String encoding) throws CityJSONReadException {
        try {
            return new CityJSONChunkReader(new InputStreamReader(inputStream, encoding), this);
        } catch (UnsupportedEncodingException e) {
            throw new CityJSONReadException("Caused by: ", e);
        }
    }

    public <T extends AbstractCityJSONReader> T createFilteredCityJSONReader(T reader, CityObjectTypeFilter filter) throws CityJSONReadException {
        reader.setObjectTypeFilter(filter);
        return reader;
    }

    public <T extends AbstractCityJSONReader> T createFilteredCityJSONReader(T reader, CityGMLInputFilter filter) throws CityJSONReadException {
        reader.setCityGMLNameFilter(filter);
        return reader;
    }

    public boolean isProcessUnknownExtensions() {
        return processUnknownExtensions;
    }

    public void setProcessUnknownExtensions(boolean processUnknownExtensions) {
        this.processUnknownExtensions = processUnknownExtensions;
    }
}
