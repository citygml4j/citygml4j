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
package org.citygml4j.builder.cityjson.marshal.citygml.waterbody;

import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.util.SemanticSurfaceCollector;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.feature.Attributes;
import org.citygml4j.cityjson.feature.WaterBodyType;
import org.citygml4j.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.waterbody.*;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;

public class WaterBodyMarshaller {
    private final ReentrantLock lock = new ReentrantLock();
    private final CityJSONMarshaller json;
    private final CityGMLMarshaller citygml;
    private BiFunctionTypeMapper<CityJSON, SemanticsType> semanticsMapper;

    public WaterBodyMarshaller(CityGMLMarshaller citygml) {
        this.citygml = citygml;
        json = citygml.getCityJSONMarshaller();
    }

    private BiFunctionTypeMapper<CityJSON, SemanticsType> getSemanticsMapper() {
        if (semanticsMapper == null) {
            lock.lock();
            try {
                if (semanticsMapper == null) {
                    semanticsMapper = BiFunctionTypeMapper.<CityJSON, SemanticsType>create()
                            .with(WaterSurface.class, this::marshalWaterSurface)
                            .with(WaterGroundSurface.class, this::marshalWaterGroundSurface)
                            .with(WaterClosureSurface.class, this::marshalWaterClosureSurface);
                }
            } finally {
                lock.unlock();
            }
        }

        return semanticsMapper;
    }

    public AbstractCityObjectType marshal(ModelObject src, CityJSON cityJSON) {
        if (src instanceof WaterBody)
            return marshalWaterBody((WaterBody) src, cityJSON);

        return null;
    }

    public SemanticsType marshalSemanticSurface(AbstractCityObject src, CityJSON cityJSON) {
        return getSemanticsMapper().apply(src, cityJSON);
    }

    public void marshalAbstractWaterObject(AbstractWaterObject src, AbstractCityObjectType dest, CityJSON cityJSON) {
        citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfWaterObject())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfWaterObject(), dest, cityJSON);
    }

    public void marshalWaterBody(WaterBody src, WaterBodyType dest, CityJSON cityJSON) {
        marshalAbstractWaterObject(src, dest, cityJSON);

        Attributes attributes = dest.getAttributes();
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

        if (src.isSetGenericApplicationPropertyOfWaterBody())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfWaterBody(), dest, cityJSON);

        Map<Integer, MultiSurface> multiSurfaces = null;
        if (src.isSetBoundedBySurface())
            multiSurfaces = preprocessGeometry(src);

        if (multiSurfaces != null) {
            for (Entry<Integer, MultiSurface> entry : multiSurfaces.entrySet()) {
                AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshal(entry.getValue(), cityJSON);
                if (geometry != null) {
                    geometry.setLod(entry.getKey());
                    dest.addGeometry(geometry);
                }
            }
        }

        if (src.isSetLod0MultiCurve()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod0MultiCurve(), cityJSON);
            if (geometry != null) {
                geometry.setLod(0);
                dest.addGeometry(geometry);
            }
        }

        if (src.isSetLod1MultiCurve()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1MultiCurve(), cityJSON);
            if (geometry != null) {
                geometry.setLod(1);
                dest.addGeometry(geometry);
            }
        }

        if (src.isSetLod0MultiSurface()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod0MultiSurface(), cityJSON);
            if (geometry != null) {
                geometry.setLod(0);
                dest.addGeometry(geometry);
            }
        }

        if (src.isSetLod1MultiSurface()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1MultiSurface(), cityJSON);
            if (geometry != null) {
                geometry.setLod(1);
                dest.addGeometry(geometry);
            }
        }

        if (src.isSetLod1Solid()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1Solid(), cityJSON);
            if (geometry != null) {
                geometry.setLod(1);
                dest.addGeometry(geometry);
            }
        }

        if (src.isSetLod2Solid()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2Solid(), cityJSON);
            if (geometry != null) {
                geometry.setLod(2);
                dest.addGeometry(geometry);
            }
        }

        if (src.isSetLod3Solid()) {
            AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3Solid(), cityJSON);
            if (geometry != null) {
                geometry.setLod(3);
                dest.addGeometry(geometry);
            }
        }
    }

    public WaterBodyType marshalWaterBody(WaterBody src, CityJSON cityJSON) {
        WaterBodyType dest = new WaterBodyType();
        marshalWaterBody(src, dest, cityJSON);

        return dest;
    }

    public void marshalSemanticSurface(AbstractWaterBoundarySurface src, SemanticsType dest, CityJSON cityJSON) {
        citygml.getCoreMarshaller().marshalSemanticSurface(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfWaterBoundarySurface())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfWaterBoundarySurface(), dest, cityJSON);
    }

    public SemanticsType marshalWaterSurface(WaterSurface src, CityJSON cityJSON) {
        SemanticsType dest = new SemanticsType("WaterSurface");
        marshalSemanticSurface(src, dest, cityJSON);

        if (src.isSetWaterLevel())
            dest.addAttribute("waterLevel", src.getWaterLevel().getValue());

        if (src.isSetGenericApplicationPropertyOfWaterSurface())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfWaterSurface(), dest, cityJSON);

        return dest;
    }

    public SemanticsType marshalWaterGroundSurface(WaterGroundSurface src, CityJSON cityJSON) {
        SemanticsType dest = new SemanticsType("WaterGroundSurface");
        marshalSemanticSurface(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfWaterGroundSurface())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfWaterGroundSurface(), dest, cityJSON);

        return dest;
    }

    public SemanticsType marshalWaterClosureSurface(WaterClosureSurface src, CityJSON cityJSON) {
        SemanticsType dest = new SemanticsType("WaterClosureSurface");
        marshalSemanticSurface(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfWaterClosureSurface())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfWaterClosureSurface(), dest, cityJSON);

        return dest;
    }

    public Map<Integer, MultiSurface> preprocessGeometry(WaterBody src) {
        Map<Integer, MultiSurface> multiSurfaces = new HashMap<>();

        SemanticSurfaceCollector collector = new SemanticSurfaceCollector(src);
        collector.collectSurfaces(src.getBoundedBySurface(), 2, 3);

        for (int lod = 2; lod < 4; lod++) {
            if (collector.hasSurfaces(lod))
                multiSurfaces.put(lod, collector.getSurfaces(lod));
        }

        return multiSurfaces;
    }

}
