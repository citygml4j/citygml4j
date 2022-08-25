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

package org.citygml4j.cityjson.adapter.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.core.AbstractFeatureWithLifespan;

import java.time.OffsetDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;

import static java.time.temporal.ChronoField.*;

public abstract class AbstractFeatureWithLifespanAdapter<T extends AbstractFeatureWithLifespan> extends AbstractFeatureAdapter<T> {
    private DateTimeFormatter dateTimeParser;

    @Override
    public void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        JsonNode creationDate = attributes.consume("creationDate");
        if (creationDate.isTextual()) {
            object.setCreationDate(toOffsetDateTime(creationDate.asText()));
        }

        JsonNode terminationDate = attributes.consume("terminationDate");
        if (terminationDate.isTextual()) {
            object.setTerminationDate(toOffsetDateTime(terminationDate.asText()));
        }

        JsonNode validFrom = attributes.consume("validFrom");
        if (validFrom.isTextual()) {
            object.setValidFrom(toOffsetDateTime(validFrom.asText()));
        }

        JsonNode validTo = attributes.consume("validTo");
        if (validTo.isTextual()) {
            object.setValidTo(toOffsetDateTime(validTo.asText()));
        }
    }

    @Override
    public void writeObject(T object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        CityJSONVersion version = helper.getVersion();
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        if (object.getCreationDate() != null) {
            attributes.put("creationDate", object.getCreationDate().format(getDateTimeFormatter(version)));
        }

        if (object.getTerminationDate() != null) {
            attributes.put("terminationDate", object.getTerminationDate().format(getDateTimeFormatter(version)));
        }

        if (object.getValidFrom() != null) {
            attributes.put("validFrom", object.getValidFrom().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        }

        if (object.getValidTo() != null) {
            attributes.put("validTo", object.getValidTo().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        }
    }

    private DateTimeFormatter getDateTimeFormatter(CityJSONVersion version) {
        return version == CityJSONVersion.v1_0 ?
                DateTimeFormatter.ISO_LOCAL_DATE :
                DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    }

    private OffsetDateTime toOffsetDateTime(String dateTime) {
        try {
            if (dateTimeParser == null) {
                dateTimeParser = new DateTimeFormatterBuilder()
                        .parseCaseInsensitive()
                        .append(DateTimeFormatter.ISO_LOCAL_DATE)
                        .optionalStart()
                        .appendLiteral('T')
                        .append(DateTimeFormatter.ISO_LOCAL_TIME)
                        .optionalStart()
                        .appendOffsetId()
                        .optionalEnd()
                        .optionalEnd()
                        .parseDefaulting(HOUR_OF_DAY, 0)
                        .parseDefaulting(MINUTE_OF_HOUR, 0)
                        .parseDefaulting(SECOND_OF_MINUTE, 0)
                        .parseDefaulting(OFFSET_SECONDS, 0)
                        .toFormatter()
                        .withResolverStyle(ResolverStyle.STRICT)
                        .withChronology(IsoChronology.INSTANCE);
            }

            return OffsetDateTime.parse(dateTime, dateTimeParser);
        } catch (Exception e) {
            return null;
        }
    }
}
