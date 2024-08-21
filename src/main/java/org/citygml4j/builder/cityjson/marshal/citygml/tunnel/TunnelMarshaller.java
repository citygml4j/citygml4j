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
package org.citygml4j.builder.cityjson.marshal.citygml.tunnel;

import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.util.DuplicateGeometryRemover;
import org.citygml4j.builder.cityjson.marshal.util.SemanticSurfaceCollector;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.feature.*;
import org.citygml4j.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.tunnel.*;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TunnelMarshaller {
    private final ReentrantLock lock = new ReentrantLock();
    private final CityJSONMarshaller json;
    private final CityGMLMarshaller citygml;
    private BiFunctionTypeMapper<CityJSON, AbstractCityObjectType> typeMapper;
    private BiFunctionTypeMapper<CityJSON, SemanticsType> semanticsMapper;

    public TunnelMarshaller(CityGMLMarshaller citygml) {
        this.citygml = citygml;
        json = citygml.getCityJSONMarshaller();
    }

    private BiFunctionTypeMapper<CityJSON, AbstractCityObjectType> getTypeMapper() {
        if (typeMapper == null) {
            lock.lock();
            try {
                if (typeMapper == null) {
                    typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObjectType>create()
                            .with(Tunnel.class, this::marshalTunnel)
                            .with(TunnelPart.class, this::marshalTunnelPart)
                            .with(TunnelInstallation.class, this::marshalTunnelInstallation);
                }
            } finally {
                lock.unlock();
            }
        }

        return typeMapper;
    }

    private BiFunctionTypeMapper<CityJSON, SemanticsType> getSemanticsMapper() {
        if (semanticsMapper == null) {
            lock.lock();
            try {
                if (semanticsMapper == null) {
                    semanticsMapper = BiFunctionTypeMapper.<CityJSON, SemanticsType>create()
                            .with(RoofSurface.class, this::marshalRoofSurface)
                            .with(GroundSurface.class, this::marshalGroundSurface)
                            .with(WallSurface.class, this::marshalWallSurface)
                            .with(ClosureSurface.class, this::marshalClosureSurface)
                            .with(OuterCeilingSurface.class, this::marshalOuterCeilingSurface)
                            .with(OuterFloorSurface.class, this::marshalOuterFloorSurface)
                            .with(Window.class, this::marshalWindow)
                            .with(Door.class, this::marshalDoor);
                }
            } finally {
                lock.unlock();
            }
        }

        return semanticsMapper;
    }

    public AbstractCityObjectType marshal(ModelObject src, CityJSON cityJSON) {
        return getTypeMapper().apply(src, cityJSON);
    }

    public SemanticsType marshalSemanticSurface(AbstractCityObject src, CityJSON cityJSON) {
        return getSemanticsMapper().apply(src, cityJSON);
    }

    public void marshalAbstractTunnel(AbstractTunnel src, AbstractTunnelType dest, CityJSON cityJSON) {
        citygml.getCoreMarshaller().marshalAbstractSite(src, dest, cityJSON);

        TunnelAttributes attributes = dest.getAttributes();
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

        if (src.isSetYearOfConstruction())
            attributes.setYearOfConstruction(src.getYearOfConstruction().getYear());

        if (src.isSetYearOfDemolition())
            attributes.setYearOfDemolition(src.getYearOfDemolition().getYear());

        if (src.isSetGenericApplicationPropertyOfAbstractTunnel())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfAbstractTunnel(), dest, cityJSON);

        SemanticSurfaceCollector collector = null;
        if (src.isSetBoundedBySurface())
            collector = preprocessGeometry(src);

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

        DuplicateGeometryRemover remover = null;
        if (json.isRemoveDuplicateChildGeometries())
            remover = new DuplicateGeometryRemover(dest);

        if (src.isSetOuterTunnelInstallation()) {
            for (TunnelInstallationProperty property : src.getOuterTunnelInstallation()) {
                AbstractCityObjectType cityObject = json.getGMLMarshaller().marshalFeatureProperty(property, cityJSON);
                if (cityObject instanceof TunnelInstallationType) {
                    if (remover != null) {
                        remover.removeDuplicateGeometries(cityObject);
                        if (!cityObject.isSetGeometry())
                            continue;
                    }

                    dest.addChild(cityObject);
                    cityJSON.addCityObject(cityObject);
                }
            }
        }

        if (dest instanceof TunnelType && src.isSetConsistsOfTunnelPart()) {
            for (TunnelPartProperty property : src.getConsistsOfTunnelPart()) {
                AbstractCityObjectType cityObject = json.getGMLMarshaller().marshalFeatureProperty(property, cityJSON);
                if (cityObject instanceof TunnelPartType) {
                    if (remover != null) {
                        remover.removeDuplicateGeometries(cityObject);
                        if (!cityObject.isSetGeometry())
                            continue;
                    }

                    dest.addChild(cityObject);
                    cityJSON.addCityObject(cityObject);
                }
            }
        }

        if (collector != null)
            postprocessGeometry(src, collector);
    }

    public void marshalTunnel(Tunnel src, TunnelType dest, CityJSON cityJSON) {
        marshalAbstractTunnel(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfTunnel())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfTunnel(), dest, cityJSON);
    }

    public TunnelType marshalTunnel(Tunnel src, CityJSON cityJSON) {
        TunnelType dest = new TunnelType();
        marshalTunnel(src, dest, cityJSON);

        return dest;
    }

    public void marshalTunnelPart(TunnelPart src, TunnelPartType dest, CityJSON cityJSON) {
        marshalAbstractTunnel(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfTunnelPart())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfTunnelPart(), dest, cityJSON);
    }

    public TunnelPartType marshalTunnelPart(TunnelPart src, CityJSON cityJSON) {
        TunnelPartType dest = new TunnelPartType();
        marshalTunnelPart(src, dest, cityJSON);

        return dest;
    }

    public void marshalTunnelInstallation(TunnelInstallation src, TunnelInstallationType dest, CityJSON cityJSON) {
        citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, cityJSON);

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

        if (src.isSetGenericApplicationPropertyOfTunnelInstallation())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfTunnelInstallation(), dest, cityJSON);

        SemanticSurfaceCollector collector = null;
        if (src.isSetBoundedBySurface())
            collector = preprocessGeometry(src);

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

        if (collector != null)
            postprocessGeometry(src, collector);
    }

    public TunnelInstallationType marshalTunnelInstallation(TunnelInstallation src, CityJSON cityJSON) {
        TunnelInstallationType dest = new TunnelInstallationType();
        marshalTunnelInstallation(src, dest, cityJSON);

        return dest;
    }

    public void marshalAbstractBoundarySurface(AbstractBoundarySurface src, SemanticsType dest, CityJSON cityJSON) {
        citygml.getCoreMarshaller().marshalSemanticSurface(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfBoundarySurface())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfBoundarySurface(), dest, cityJSON);
    }

    public void marshalAbstractOpening(AbstractOpening src, SemanticsType dest, CityJSON cityJSON) {
        citygml.getCoreMarshaller().marshalSemanticSurface(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfOpening())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfOpening(), dest, cityJSON);
    }

    public SemanticsType marshalRoofSurface(RoofSurface src, CityJSON cityJSON) {
        SemanticsType dest = new SemanticsType("RoofSurface");
        marshalAbstractBoundarySurface(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfRoofSurface())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfRoofSurface(), dest, cityJSON);

        return dest;
    }

    public SemanticsType marshalGroundSurface(GroundSurface src, CityJSON cityJSON) {
        SemanticsType dest = new SemanticsType("GroundSurface");
        marshalAbstractBoundarySurface(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfGroundSurface())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfGroundSurface(), dest, cityJSON);

        return dest;
    }

    public SemanticsType marshalWallSurface(WallSurface src, CityJSON cityJSON) {
        SemanticsType dest = new SemanticsType("WallSurface");
        marshalAbstractBoundarySurface(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfWallSurface())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfWallSurface(), dest, cityJSON);

        return dest;
    }

    public SemanticsType marshalClosureSurface(ClosureSurface src, CityJSON cityJSON) {
        SemanticsType dest = new SemanticsType("ClosureSurface");
        marshalAbstractBoundarySurface(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfClosureSurface())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfClosureSurface(), dest, cityJSON);

        return dest;
    }

    public SemanticsType marshalOuterCeilingSurface(OuterCeilingSurface src, CityJSON cityJSON) {
        SemanticsType dest = new SemanticsType("OuterCeilingSurface");
        marshalAbstractBoundarySurface(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfOuterCeilingSurface())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfOuterCeilingSurface(), dest, cityJSON);

        return dest;
    }

    public SemanticsType marshalOuterFloorSurface(OuterFloorSurface src, CityJSON cityJSON) {
        SemanticsType dest = new SemanticsType("OuterFloorSurface");
        marshalAbstractBoundarySurface(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfOuterFloorSurface())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfOuterFloorSurface(), dest, cityJSON);

        return dest;
    }

    public SemanticsType marshalWindow(Window src, CityJSON cityJSON) {
        SemanticsType dest = new SemanticsType("Window");
        marshalAbstractOpening(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfWindow())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfWindow(), dest, cityJSON);

        return dest;
    }

    public SemanticsType marshalDoor(Door src, CityJSON cityJSON) {
        SemanticsType dest = new SemanticsType("Door");
        marshalAbstractOpening(src, dest, cityJSON);

        if (src.isSetGenericApplicationPropertyOfDoor())
            json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfDoor(), dest, cityJSON);

        return dest;
    }

    private SemanticSurfaceCollector preprocessGeometry(AbstractTunnel src) {
        SemanticSurfaceCollector collector = collectBoundarySurfaces(src, src.getBoundedBySurface());

        for (int lod = 2; lod < 4; lod++) {
            if (collector.hasSurfaces(lod)) {
                if (lod == 2)
                    collector.assignSurfaces(src::getLod2MultiSurface, src::setLod2MultiSurface, lod);
                else
                    collector.assignSurfaces(src::getLod3MultiSurface, src::setLod3MultiSurface, lod);
            }
        }

        return collector;
    }

    private void postprocessGeometry(AbstractTunnel src, SemanticSurfaceCollector collector) {
        for (int lod = 2; lod < 4; lod++) {
            if (collector.hasSurfaces(lod)) {
                if (lod == 2)
                    collector.clean(src::getLod2MultiSurface, src::unsetLod2MultiSurface);
                else
                    collector.clean(src::getLod3MultiSurface, src::unsetLod3MultiSurface);
            }
        }
    }

    private SemanticSurfaceCollector preprocessGeometry(TunnelInstallation src) {
        SemanticSurfaceCollector collector = collectBoundarySurfaces(src, src.getBoundedBySurface());

        for (int lod = 2; lod < 4; lod++) {
            if (collector.hasSurfaces(lod)) {
                if (lod == 2)
                    collector.assignSurfaces(src::getLod2Geometry, src::setLod2Geometry, lod);
                else
                    collector.assignSurfaces(src::getLod3Geometry, src::setLod3Geometry, lod);
            }
        }

        return collector;
    }

    private void postprocessGeometry(TunnelInstallation src, SemanticSurfaceCollector collector) {
        for (int lod = 2; lod < 4; lod++) {
            if (collector.hasSurfaces(lod)) {
                if (lod == 2)
                    collector.clean(src::getLod2Geometry, src::unsetLod2Geometry);
                else
                    collector.clean(src::getLod3Geometry, src::unsetLod3Geometry);
            }
        }
    }

    private SemanticSurfaceCollector collectBoundarySurfaces(AbstractCityObject cityObject, List<BoundarySurfaceProperty> boundaryProperties) {
        SemanticSurfaceCollector collector = new SemanticSurfaceCollector(cityObject);

        for (BoundarySurfaceProperty boundaryProperty : boundaryProperties) {
            if (boundaryProperty.isSetBoundarySurface()) {
                AbstractBoundarySurface boundarySurface = boundaryProperty.getBoundarySurface();
                collector.collectSurfaces(boundarySurface, 2, 3);
                collector.collectSurfaces(boundarySurface.getOpening(), 2, 3);
            }
        }

        return collector;
    }
}
