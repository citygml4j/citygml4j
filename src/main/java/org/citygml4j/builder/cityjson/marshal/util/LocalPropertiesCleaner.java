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

package org.citygml4j.builder.cityjson.marshal.util;

import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.util.walker.GMLWalker;

public class LocalPropertiesCleaner extends GMLWalker {

    @Override
    public void visit(AbstractGeometry geometry) {
        geometry.unsetLocalProperty(CityJSONMarshaller.GEOMETRY_SURFACE_DATA);
        super.visit(geometry);
    }

    @Override
    public <T extends AbstractGeometry> void visit(GeometryProperty<T> property) {
        property.unsetLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK);
        super.visit(property);
    }
}
