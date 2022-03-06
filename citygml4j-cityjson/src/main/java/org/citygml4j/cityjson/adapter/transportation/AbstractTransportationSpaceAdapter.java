/*
 * citygml4j-cityjson - CityJSON module for citygml4j
 * https://github.com/citygml4j/citygml4j-cityjson
 *
 * citygml4j-cityjson is part of the citygml4j project
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

package org.citygml4j.cityjson.adapter.transportation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.core.AbstractUnoccupiedSpaceAdapter;
import org.citygml4j.cityjson.adapter.geometry.MultiSurfaceProvider;
import org.citygml4j.cityjson.adapter.geometry.serializer.SpaceGeometryBuilder;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.core.AbstractSpace;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;
import org.citygml4j.core.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.core.model.deprecated.transportation.DeprecatedPropertiesOfAbstractTransportationSpace;
import org.citygml4j.core.model.transportation.*;
import org.xmlobjects.gml.model.feature.FeatureProperty;
import org.xmlobjects.util.copy.CopyBuilder;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractTransportationSpaceAdapter<T extends AbstractTransportationSpace> extends AbstractUnoccupiedSpaceAdapter<T> {
    private CopyBuilder copyBuilder;
    private final EnumSet<GeometryType> allowedTypes = EnumSet.of(GeometryType.MULTI_LINE_STRING,
            GeometryType.MULTI_SURFACE, GeometryType.COMPOSITE_SURFACE);

    @Override
    public void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        JsonNode geometries = helper.consumeProperty(Fields.GEOMETRY, node);
        super.buildObject(object, attributes, node, parent, helper);

        JsonNode trafficDirection = attributes.consume("trafficDirection");
        if (trafficDirection.isTextual()) {
            object.setTrafficDirection(TrafficDirectionValue.fromValue(trafficDirection.asText()));
        }

        helper.addGeometries(object, geometries, boundary -> object.isValidBoundary(boundary)
                || boundary instanceof TrafficArea
                || boundary instanceof AuxiliaryTrafficArea
                || (helper.getTargetCityGMLVersion() == CityGMLVersion.v3_0
                && (boundary instanceof HoleSurface || boundary instanceof Marking)));

        if (object.isSetBoundaries()) {
            Iterator<AbstractSpaceBoundaryProperty> iterator = object.getBoundaries().iterator();
            while (iterator.hasNext()) {
                AbstractSpaceBoundaryProperty property = iterator.next();
                AbstractSpaceBoundary boundary = property.getObject();

                if (boundary instanceof TrafficArea) {
                    TrafficSpace trafficSpace = new TrafficSpace(GranularityValue.WAY);
                    trafficSpace.addBoundary(property);
                    object.getTrafficSpaces().add(new TrafficSpaceProperty(trafficSpace));
                } else if (boundary instanceof AuxiliaryTrafficArea) {
                    AuxiliaryTrafficSpace auxiliaryTrafficSpace = new AuxiliaryTrafficSpace(GranularityValue.WAY);
                    auxiliaryTrafficSpace.addBoundary(property);
                    object.getAuxiliaryTrafficSpaces().add(new AuxiliaryTrafficSpaceProperty(auxiliaryTrafficSpace));
                } else if (boundary instanceof HoleSurface) {
                    Hole hole = new Hole();
                    hole.addBoundary(property);
                    object.getHoles().add(new HoleProperty(hole));
                } else if (boundary instanceof Marking) {
                    object.getMarkings().add(new MarkingProperty((Marking) boundary));
                } else {
                    continue;
                }

                iterator.remove();
            }
        }
    }

    @Override
    public void writeObject(T object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.isSetTrafficSpaces()) {
            object.getTrafficSpaces().forEach(property -> addBoundaries(property, object));
        }

        if (object.isSetAuxiliaryTrafficSpaces()) {
            object.getAuxiliaryTrafficSpaces().forEach(property -> addBoundaries(property, object));
        }

        if (object.isSetHoles()) {
            object.getHoles().forEach(property -> addBoundaries(property, object));
        }

        if (object.isSetMarkings()) {
            object.getMarkings().forEach(property -> addBoundary(property, object));
        }

        SpaceGeometryBuilder.newInstance().addUnreferencedBoundaryGeometries(object);
        super.writeObject(object, node, helper);

        if (object.isSetBoundaries()) {
            object.getBoundaries().removeIf(boundary -> boundary.hasLocalProperties()
                    && boundary.getLocalProperties().contains(CityJSONSerializerHelper.TEMPORARY_OBJECT));
        }

        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);
        if (object.getTrafficDirection() != null) {
            attributes.put("trafficDirection", object.getTrafficDirection().toValue());
        }
    }

    @Override
    public EnumSet<GeometryType> getAllowedGeometryTypes(CityJSONVersion version) {
        return allowedTypes;
    }

    @Override
    public Map<Integer, MultiSurfaceProvider> getMultiSurfaceProviders(T object) {
        if (object.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractTransportationSpace properties = object.getDeprecatedProperties();
            return Map.of(1, MultiSurfaceProvider.of(properties::getLod1MultiSurface, properties::setLod1MultiSurface),
                    4, MultiSurfaceProvider.of(properties::getLod4MultiSurface, properties::setLod4MultiSurface));
        } else {
            return null;
        }
    }

    private void addBoundary(FeatureProperty<? extends AbstractSpaceBoundary> property, T object) {
        if (property.getObject() != null) {
            AbstractSpaceBoundaryProperty dummy = new AbstractSpaceBoundaryProperty();
            dummy.setReferencedObject(property.getObject());
            dummy.getLocalProperties().set(CityJSONSerializerHelper.TEMPORARY_OBJECT, true);
            object.getBoundaries().add(dummy);
        }
    }

    private void addBoundaries(FeatureProperty<? extends AbstractSpace> property, T object) {
        if (property.getObject() != null && property.getObject().isSetBoundaries()) {
            property.getObject().getBoundaries().forEach(boundary -> addBoundary(boundary, object));
        }
    }

    <S extends AbstractTransportationSpace, D extends AbstractTransportationSpace> D shallowCopy(S src, D dest) {
        if (copyBuilder == null) {
            copyBuilder = new CopyBuilder();
        }

        return copyBuilder.shallowCopy(src, dest, AbstractTransportationSpace.class);
    }
}
