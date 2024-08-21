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
package org.citygml4j.builder.cityjson.marshal.citygml.vegetation;

import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.feature.*;
import org.citygml4j.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.model.citygml.vegetation.AbstractVegetationObject;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.util.concurrent.locks.ReentrantLock;

public class VegetationMarshaller {
    private final ReentrantLock lock = new ReentrantLock();
    private final CityJSONMarshaller json;
    private final CityGMLMarshaller citygml;
    private BiFunctionTypeMapper<CityJSON, AbstractCityObjectType> typeMapper;

    public VegetationMarshaller(CityGMLMarshaller citygml) {
        this.citygml = citygml;
        json = citygml.getCityJSONMarshaller();
    }

    private BiFunctionTypeMapper<CityJSON, AbstractCityObjectType> getTypeMapper() {
        if (typeMapper == null) {
            lock.lock();
            try {
                if (typeMapper == null) {
                    typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObjectType>create()
                            .with(PlantCover.class, this::marshalPlantCover)
                            .with(SolitaryVegetationObject.class, this::marshalSolitaryVegetationObject);
                }
            } finally {
                lock.unlock();
            }
        }

        return typeMapper;
    }

    public AbstractCityObjectType marshal(ModelObject src, CityJSON cityJSON) {
        return getTypeMapper().apply(src, cityJSON);
    }

    public void marshalAbstractVegetationObject(AbstractVegetationObject src, AbstractCityObjectType dest, CityJSON cityJSON) {
        citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfVegetationObject())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfVegetationObject(), dest, cityJSON);
    }

    public void marshalPlantCover(PlantCover src, PlantCoverType dest, CityJSON cityJSON) {
        marshalAbstractVegetationObject(src, dest, cityJSON);

        PlantCoverAttributes attributes = dest.getAttributes();
        if (src.isSetClazz())
            attributes.setClazz(src.getClazz().getValue());

        if (src.isSetFunction()) {
            for (Code function : src.getFunction()) {
                if (function.isSetValue()) {
                    attributes.setFunction(function.getValue());
                    break;
                }
            }
        }

        if (src.isSetUsage()) {
            for (Code usage : src.getUsage()) {
                if (usage.isSetValue()) {
                    attributes.setUsage(usage.getValue());
                    break;
                }
            }
        }

        if (src.isSetAverageHeight())
            attributes.setAverageHeight(src.getAverageHeight().getValue());

        if (src.isSetGenericApplicationPropertyOfPlantCover())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfPlantCover(), dest, cityJSON);

        if (src.isSetLod1MultiSurface()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1MultiSurface(), cityJSON);
            if (geometry != null) {
                geometry.setLod(1);
                dest.addGeometry(geometry);
            }
        }

        if (src.isSetLod2MultiSurface()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2MultiSurface(), cityJSON);
            if (geometry != null) {
                geometry.setLod(2);
                dest.addGeometry(geometry);
            }
        }

        if (src.isSetLod3MultiSurface()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3MultiSurface(), cityJSON);
            if (geometry != null) {
                geometry.setLod(3);
                dest.addGeometry(geometry);
            }
        }

        if (src.isSetLod1MultiSolid()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1MultiSolid(), cityJSON);
            if (geometry != null) {
                geometry.setLod(1);
                dest.addGeometry(geometry);
            }
        }

        if (src.isSetLod2MultiSolid()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2MultiSolid(), cityJSON);
            if (geometry != null) {
                geometry.setLod(2);
                dest.addGeometry(geometry);
            }
        }

        if (src.isSetLod3MultiSolid()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3MultiSolid(), cityJSON);
            if (geometry != null) {
                geometry.setLod(3);
                dest.addGeometry(geometry);
            }
        }
    }

    public PlantCoverType marshalPlantCover(PlantCover src, CityJSON cityJSON) {
        PlantCoverType dest = new PlantCoverType();
        marshalPlantCover(src, dest, cityJSON);

        return dest;
    }

    public void marshalSolitaryVegetationObject(SolitaryVegetationObject src, SolitaryVegetationObjectType dest, CityJSON cityJSON) {
        marshalAbstractVegetationObject(src, dest, cityJSON);

        SolitaryVegetationObjectAttributes attributes = dest.getAttributes();
        if (src.isSetClazz())
            attributes.setClazz(src.getClazz().getValue());

        if (src.isSetFunction()) {
            for (Code function : src.getFunction()) {
                if (function.isSetValue()) {
                    attributes.setFunction(function.getValue());
                    break;
                }
            }
        }

        if (src.isSetUsage()) {
            for (Code usage : src.getUsage()) {
                if (usage.isSetValue()) {
                    attributes.setUsage(usage.getValue());
                    break;
                }
            }
        }

        if (src.isSetSpecies())
            attributes.setSpecies(src.getSpecies().getValue());

        if (src.isSetTrunkDiameter())
            attributes.setTrunkDiameter(src.getTrunkDiameter().getValue());

        if (src.isSetCrownDiameter())
            attributes.setCrownDiameter(src.getCrownDiameter().getValue());

        if (src.isSetGenericApplicationPropertyOfSolitaryVegetationObject())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfSolitaryVegetationObject(), dest, cityJSON);

        if (src.isSetLod1Geometry()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1Geometry(), cityJSON);
            if (geometry != null) {
                geometry.setLod(1);
                dest.addGeometry(geometry);
            }
        }

        if (src.isSetLod2Geometry()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2Geometry(), cityJSON);
            if (geometry != null) {
                geometry.setLod(2);
                dest.addGeometry(geometry);
            }
        }

        if (src.isSetLod3Geometry()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3Geometry(), cityJSON);
            if (geometry != null) {
                geometry.setLod(3);
                dest.addGeometry(geometry);
            }
        }

        if (src.isSetLod1ImplicitRepresentation()) {
            GeometryInstanceType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod1ImplicitRepresentation(), 1, cityJSON);
            if (geometry != null)
                dest.addGeometry(geometry);
        }

        if (src.isSetLod2ImplicitRepresentation()) {
            GeometryInstanceType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation(), 2, cityJSON);
            if (geometry != null)
                dest.addGeometry(geometry);
        }

        if (src.isSetLod3ImplicitRepresentation()) {
            GeometryInstanceType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation(), 3, cityJSON);
            if (geometry != null)
                dest.addGeometry(geometry);
        }
    }

    public SolitaryVegetationObjectType marshalSolitaryVegetationObject(SolitaryVegetationObject src, CityJSON cityJSON) {
        SolitaryVegetationObjectType dest = new SolitaryVegetationObjectType();
        marshalSolitaryVegetationObject(src, dest, cityJSON);

        return dest;
    }
}
