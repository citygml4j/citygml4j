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

package org.citygml4j.core.model.deprecated.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;

public class ExternalObject extends GMLObject implements CityGMLObject {
    private String name;
    private String uri;

    public ExternalObject() {
    }

    public static ExternalObject ofName(String name) {
        ExternalObject externalObject = new ExternalObject();
        externalObject.setName(name);
        return externalObject;
    }

    public static ExternalObject ofURI(String uri) {
        ExternalObject externalObject = new ExternalObject();
        externalObject.setURI(uri);
        return externalObject;
    }

    public String getName() {
        return name;
    }

    public boolean isSetName() {
        return name != null;
    }

    public void setName(String name) {
        this.name = name;
        uri = null;
    }

    public String getURI() {
        return uri;
    }

    public boolean isSetURI() {
        return uri != null;
    }

    public void setURI(String uri) {
        this.uri = uri;
        name = null;
    }
}
