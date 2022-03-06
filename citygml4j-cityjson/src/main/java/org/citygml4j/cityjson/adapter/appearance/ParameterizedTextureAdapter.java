/*
 * citygml4j-cityjson - CityJSON module for citygml4j
 * https://github.com/citygml4j/citygml4j-cityjson
 *
 * citygml4j-cityjson is part of the citygml4j project
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.adapter.appearance;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.util.texture.TextureFileHandler;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.appearance.ColorPlusOpacity;
import org.citygml4j.core.model.appearance.ParameterizedTexture;
import org.citygml4j.core.model.appearance.TextureType;
import org.citygml4j.core.model.appearance.WrapMode;
import org.xmlobjects.gml.model.basictypes.Code;

public class ParameterizedTextureAdapter implements JsonObjectBuilder<ParameterizedTexture>, JsonObjectSerializer<ParameterizedTexture> {

    @Override
    public ParameterizedTexture createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new ParameterizedTexture();
    }

    @Override
    public void buildObject(ParameterizedTexture object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        JsonNode image = node.path(Fields.IMAGE);
        if (image.isTextual()) {
            TextureFileHandler textureFileHandler = helper.getProperties().get(TextureFileHandler.class.getName(), TextureFileHandler.class);
            object.setImageURI(textureFileHandler != null ?
                    textureFileHandler.getImageURI(image.asText()) :
                    image.asText());
        }

        JsonNode type = node.path(Fields.TYPE);
        if (type.isTextual()) {
            String mimeType = getMimeType(type.asText());
            if (mimeType != null) {
                object.setMimeType(new Code(mimeType));
            }
        }

        JsonNode wrapMode = node.path(Fields.WRAP_MODE);
        if (wrapMode.isTextual()) {
            object.setWrapMode(WrapMode.fromValue(wrapMode.asText()));
        }

        JsonNode textureType = node.path(Fields.TEXTURE_TYPE);
        if (textureType.isTextual()) {
            object.setTextureType(TextureType.fromValue(textureType.asText()));
        }

        JsonNode borderColor = node.path(Fields.BORDER_COLOR);
        if (borderColor.isArray() && borderColor.size() > 2) {
            ColorPlusOpacity value = new ColorPlusOpacity(
                    borderColor.get(0).asDouble(),
                    borderColor.get(1).asDouble(),
                    borderColor.get(2).asDouble());

            JsonNode opacity = borderColor.path(3);
            if (opacity.isNumber()) {
                value.setOpacity(opacity.asDouble());
            }

            object.setBorderColor(value);
        }
    }

    @Override
    public void writeObject(ParameterizedTexture object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        String type = null;
        if (object.getMimeType() != null) {
            type = getType(object.getMimeType());
        }

        String image = null;
        if (object.getImageURI() != null) {
            TextureFileHandler textureFileHandler = helper.getProperties().get(TextureFileHandler.class.getName(), TextureFileHandler.class);
            if (textureFileHandler != null) {
                image = textureFileHandler.getImageURI(object.getImageURI());
            } else {
                image = object.getImageURI();
            }

            if (type == null) {
                type = getType(image);
            }
        }

        node.put(Fields.TYPE, type);
        node.put(Fields.IMAGE, image);

        if (object.getWrapMode() != null) {
            node.put(Fields.WRAP_MODE, object.getWrapMode().toValue());
        }

        if (object.getTextureType() != null) {
            node.put(Fields.TEXTURE_TYPE, object.getTextureType().toValue());
        }

        if (object.getBorderColor() != null) {
            ArrayNode borderColor = node.putArray(Fields.BORDER_COLOR);
            object.getBorderColor().toList().forEach(borderColor::add);
        }
    }

    private String getMimeType(String type) {
        switch (type.toLowerCase()) {
            case "png":
                return "image/png";
            case "jpg":
                return "image/jpeg";
            default:
                return null;
        }
    }

    private String getType(Code mimeType) {
        if (mimeType.getValue() != null) {
            switch (mimeType.getValue().toLowerCase()) {
                case "image/png":
                    return "PNG";
                case "image/jpeg":
                    return "JPG";
            }
        }

        return null;
    }

    private String getType(String image) {
        int index = image.lastIndexOf('.');
        if (index >= 0 && index < image.length()) {
            String extension = image.substring(index + 1).toUpperCase();
            switch (extension) {
                case "JPG":
                case "JPEG":
                case "JPE":
                case "JFIF":
                case "JIF":
                case "JFI":
                case "PJPEG":
                case "PJP":
                    return "JPG";
                default:
                    return extension;
            }
        }

        return null;
    }
}
