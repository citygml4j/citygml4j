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

package org.citygml4j.cityjson.adapter.construction;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.core.AbstractOccupiedSpaceAdapter;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.construction.*;
import org.xmlobjects.gml.model.measures.Length;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.format.SignStyle;

import static java.time.temporal.ChronoField.*;

public abstract class AbstractConstructionAdapter<T extends AbstractConstruction> extends AbstractOccupiedSpaceAdapter<T> {
    private DateTimeFormatter localDateParser;

    @Override
    public void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);
        CityJSONVersion version = helper.getVersion();

        JsonNode conditionOfConstruction = attributes.consume("conditionOfConstruction");
        if (conditionOfConstruction.isTextual()) {
            object.setConditionOfConstruction(ConditionOfConstructionValue.fromValue(conditionOfConstruction.asText()));
        }

        JsonNode dateOfConstruction = attributes.consume(version == CityJSONVersion.v1_0 ?
                "yearOfConstruction" :
                "dateOfConstruction");
        if (dateOfConstruction.isTextual()) {
            object.setDateOfConstruction(toLocalDate(dateOfConstruction.asText()));
        } else if (dateOfConstruction.isInt()) {
            object.setDateOfConstruction(toLocalDate(dateOfConstruction.asInt()));
        }

        JsonNode dateOfDemolition = attributes.consume(version == CityJSONVersion.v1_0 ?
                "yearOfDemolition" :
                "dateOfDemolition");
        if (dateOfDemolition.isTextual()) {
            object.setDateOfDemolition(toLocalDate(dateOfDemolition.asText()));
        } else if (dateOfDemolition.isInt()) {
            object.setDateOfDemolition(toLocalDate(dateOfDemolition.asInt()));
        }

        JsonNode measuredHeight = attributes.consume("measuredHeight");
        if (measuredHeight.isNumber()) {
            object.getHeights().add(new HeightProperty(Height.ofMeasuredHeight(new Length(measuredHeight.doubleValue(), "m"))));
        }
    }

    @Override
    public void writeObject(T object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        CityJSONVersion version = helper.getVersion();
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        if (object.getConditionOfConstruction() != null) {
            attributes.put("conditionOfConstruction", object.getConditionOfConstruction().toValue());
        }

        if (object.getDateOfConstruction() != null) {
            if (version == CityJSONVersion.v1_0) {
                attributes.put("yearOfConstruction", object.getDateOfConstruction().getYear());
            } else {
                attributes.put("dateOfConstruction", object.getDateOfConstruction().format(DateTimeFormatter.ISO_LOCAL_DATE));
            }
        }

        if (object.getDateOfDemolition() != null) {
            if (version == CityJSONVersion.v1_0) {
                attributes.put("yearOfDemolition", object.getDateOfConstruction().getYear());
            } else {
                attributes.put("dateOfDemolition", object.getDateOfDemolition().format(DateTimeFormatter.ISO_LOCAL_DATE));
            }
        }

        if (object.isSetHeights()) {
            for (HeightProperty property : object.getHeights()) {
                if (property.getObject() != null
                        && property.getObject().getStatus() == HeightStatusValue.MEASURED
                        && property.getObject().getValue() != null) {
                    attributes.put("measuredHeight", property.getObject().getValue().getValue());
                    break;
                }
            }
        }
    }

    private LocalDate toLocalDate(String date) {
        try {
            if (localDateParser == null) {
                localDateParser = new DateTimeFormatterBuilder()
                        .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
                        .optionalStart()
                        .appendLiteral('-')
                        .appendValue(MONTH_OF_YEAR, 2)
                        .appendLiteral('-')
                        .appendValue(DAY_OF_MONTH, 2)
                        .optionalEnd()
                        .parseDefaulting(MONTH_OF_YEAR, 1)
                        .parseDefaulting(DAY_OF_MONTH, 1)
                        .toFormatter()
                        .withResolverStyle(ResolverStyle.STRICT)
                        .withChronology(IsoChronology.INSTANCE);
            }

            return LocalDate.parse(date, localDateParser);
        } catch (Exception e) {
            return null;
        }
    }

    private LocalDate toLocalDate(int year) {
        try {
            return LocalDate.of(year, 1, 1);
        } catch (Exception e) {
            return null;
        }
    }
}
