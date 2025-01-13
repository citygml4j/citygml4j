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
package org.citygml4j.builder.cityjson.json.io.reader;

import org.citygml4j.builder.cityjson.unmarshal.CityObjectProcessor;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.model.citygml.core.CityModel;

import java.io.Reader;

public class CityJSONChunkReader extends AbstractCityJSONReader {
    private CityModel cityModelStub;

    public CityJSONChunkReader(Reader reader, CityJSONInputFactory factory) {
        super(reader, factory.processUnknownExtensions);
        cityModelStub = new CityModel();
    }

    public CityModel getCityModelStub() {
        return cityModelStub;
    }

    public void read(CityObjectProcessor processor) throws Exception {
        CityJSON cityJSON = readCityJSON();
        if (cityJSON != null)
            getCityJSONUnmarshaller().unmarshal(cityJSON, cityModelStub, processor);
    }

    @Override
    public void close() throws CityJSONReadException {
        super.close();
        cityModelStub = null;
    }

}
