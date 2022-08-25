/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.schema;

import org.citygml4j.core.ade.ADERegistry;
import org.citygml4j.xml.CityGMLADELoader;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.module.ade.ADEModule;
import org.xmlobjects.schema.SchemaHandler;
import org.xmlobjects.schema.SchemaHandlerException;

import java.net.URL;

public class CityGMLSchemaHandler extends SchemaHandler {
    private static CityGMLSchemaHandler instance;

    private CityGMLSchemaHandler() {
    }

    public static synchronized CityGMLSchemaHandler newInstance() throws SchemaHandlerException {
        if (instance == null) {
            instance = new CityGMLSchemaHandler();
            instance.parseSchema(CityGMLContext.class.getResource("/org/citygml4j/schemas/citygml4j.xsd"));
        }

        CityGMLSchemaHandler schemaHandler = new CityGMLSchemaHandler();
        schemaHandler.schemas.putAll(instance.schemas);
        schemaHandler.visitedSchemaLocations.putAll(instance.visitedSchemaLocations);

        CityGMLADELoader loader = ADERegistry.getInstance().getADELoader(CityGMLADELoader.class);
        for (ADEModule module : loader.getADEModules()) {
            URL schemaResource = module.getSchemaResource();
            if (schemaResource != null) {
                schemaHandler.parseSchema(schemaResource);
            }
        }

        return schemaHandler;
    }
}
