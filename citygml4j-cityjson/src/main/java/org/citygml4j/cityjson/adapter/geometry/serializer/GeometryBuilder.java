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

package org.citygml4j.cityjson.adapter.geometry.serializer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.visitor.GeometryWalker;

import java.util.function.BiConsumer;

public abstract class GeometryBuilder extends GeometryWalker {
    final CityJSONSerializerHelper helper;
    private final BiConsumer<Number, ObjectNode> lodSetter;

    GeometryBuilder(CityJSONSerializerHelper helper) {
        this.helper = helper;
        lodSetter = helper.getVersion() == CityJSONVersion.v1_0 ?
                this::setLodAsNumber :
                this::setLodAsString;
    }

    abstract JsonNode build(AbstractGeometry geometry, Number lod);

    abstract int size();

    void setLod(Number lod, ObjectNode node) {
        lodSetter.accept(lod, node);
    }

    private void setLodAsString(Number lod, ObjectNode node) {
        if (lod instanceof Integer) {
            node.put(Fields.LOD, String.valueOf(lod.intValue()));
        } else {
            node.put(Fields.LOD, String.valueOf(lod.doubleValue()));
        }
    }

    private void setLodAsNumber(Number lod, ObjectNode node) {
        if (lod instanceof Integer) {
            node.put(Fields.LOD, lod.intValue());
        } else {
            node.put(Fields.LOD, lod.doubleValue());
        }
    }
}
