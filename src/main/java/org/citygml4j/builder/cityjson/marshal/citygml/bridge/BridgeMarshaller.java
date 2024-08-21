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
package org.citygml4j.builder.cityjson.marshal.citygml.bridge;

import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.util.DuplicateGeometryRemover;
import org.citygml4j.builder.cityjson.marshal.util.SemanticSurfaceCollector;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.feature.*;
import org.citygml4j.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.bridge.*;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class BridgeMarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;
	private BiFunctionTypeMapper<CityJSON, AbstractCityObjectType> typeMapper;
	private BiFunctionTypeMapper<CityJSON, SemanticsType> semanticsMapper;

	public BridgeMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();
	}

	private BiFunctionTypeMapper<CityJSON, AbstractCityObjectType> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObjectType>create()
							.with(Bridge.class, this::marshalBridge)
							.with(BridgePart.class, this::marshalBridgePart)
							.with(BridgeConstructionElement.class, this::marshalBridgeConstructionElement)
							.with(BridgeInstallation.class, this::marshalBridgeInstallation);
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

	public void marshalAbstractBridge(AbstractBridge src, AbstractBridgeType dest, CityJSON cityJSON) {
		citygml.getCoreMarshaller().marshalAbstractSite(src, dest, cityJSON);

		BridgeAttributes attributes = dest.getAttributes();
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
		
		if (src.isSetIsMovable())
			attributes.setIsMovable(src.getIsMovable());

		if (src.isSetGenericApplicationPropertyOfAbstractBridge())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfAbstractBridge(), dest, cityJSON);

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

		if (src.isSetOuterBridgeConstructionElement()) {
			for (BridgeConstructionElementProperty property : src.getOuterBridgeConstructionElement()) {
				AbstractCityObjectType cityObject = json.getGMLMarshaller().marshalFeatureProperty(property, cityJSON);
				if (cityObject instanceof BridgeConstructionElementType) {
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
		
		if (src.isSetOuterBridgeInstallation()) {
			for (BridgeInstallationProperty property : src.getOuterBridgeInstallation()) {
				AbstractCityObjectType cityObject = json.getGMLMarshaller().marshalFeatureProperty(property, cityJSON);
				if (cityObject instanceof BridgeInstallationType) {
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

		if (dest instanceof BridgeType && src.isSetConsistsOfBridgePart()) {
			for (BridgePartProperty property : src.getConsistsOfBridgePart()) {
				AbstractCityObjectType cityObject = json.getGMLMarshaller().marshalFeatureProperty(property, cityJSON);
				if (cityObject instanceof BridgePartType) {
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
		
		if (src.isSetAddress()) {
			for (AddressProperty property : src.getAddress()) {
				if (property.isSetAddress()) {
					dest.setAddress(citygml.getCoreMarshaller().marshalAddress(property.getAddress(), cityJSON));
					break;
				}
			}
		}

		if (collector != null)
			postprocessGeometry(src, collector);
	}

	public void marshalBridge(Bridge src, BridgeType dest, CityJSON cityJSON) {
		marshalAbstractBridge(src, dest, cityJSON);

		if (src.isSetGenericApplicationPropertyOfBridge())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfBridge(), dest, cityJSON);
	}

	public BridgeType marshalBridge(Bridge src, CityJSON cityJSON) {
		BridgeType dest = new BridgeType();
		marshalBridge(src, dest, cityJSON);

		return dest;
	}

	public void marshalBridgePart(BridgePart src, BridgePartType dest, CityJSON cityJSON) {
		marshalAbstractBridge(src, dest, cityJSON);

		if (src.isSetGenericApplicationPropertyOfBridgePart())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfBridgePart(), dest, cityJSON);
	}

	public BridgePartType marshalBridgePart(BridgePart src, CityJSON cityJSON) {
		BridgePartType dest = new BridgePartType();
		marshalBridgePart(src, dest, cityJSON);

		return dest;
	}
	
	public void marshalBridgeConstructionElement(BridgeConstructionElement src, BridgeConstructionElementType dest, CityJSON cityJSON) {
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

		if (src.isSetGenericApplicationPropertyOfBridgeConstructionElement())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfBridgeConstructionElement(), dest, cityJSON);

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

	public BridgeConstructionElementType marshalBridgeConstructionElement(BridgeConstructionElement src, CityJSON cityJSON) {
		BridgeConstructionElementType dest = new BridgeConstructionElementType();
		marshalBridgeConstructionElement(src, dest, cityJSON);

		return dest;
	}

	public void marshalBridgeInstallation(BridgeInstallation src, BridgeInstallationType dest, CityJSON cityJSON) {
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

		if (src.isSetGenericApplicationPropertyOfBridgeInstallation())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfBridgeInstallation(), dest, cityJSON);

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

	public BridgeInstallationType marshalBridgeInstallation(BridgeInstallation src, CityJSON cityJSON) {
		BridgeInstallationType dest = new BridgeInstallationType();
		marshalBridgeInstallation(src, dest, cityJSON);

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

	private SemanticSurfaceCollector preprocessGeometry(AbstractBridge src) {
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

	private void postprocessGeometry(AbstractBridge src, SemanticSurfaceCollector collector) {
		for (int lod = 2; lod < 4; lod++) {
			if (collector.hasSurfaces(lod)) {
				if (lod == 2)
					collector.clean(src::getLod2MultiSurface, src::unsetLod2MultiSurface);
				else
					collector.clean(src::getLod3MultiSurface, src::unsetLod3MultiSurface);
			}
		}
	}

	private SemanticSurfaceCollector preprocessGeometry(BridgeInstallation src) {
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

	private void postprocessGeometry(BridgeInstallation src, SemanticSurfaceCollector collector) {
		for (int lod = 2; lod < 4; lod++) {
			if (collector.hasSurfaces(lod)) {
				if (lod == 2)
					collector.clean(src::getLod2Geometry, src::unsetLod2Geometry);
				else
					collector.clean(src::getLod3Geometry, src::unsetLod3Geometry);
			}
		}
	}
	
	private SemanticSurfaceCollector preprocessGeometry(BridgeConstructionElement src) {
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

	private void postprocessGeometry(BridgeConstructionElement src, SemanticSurfaceCollector collector) {
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
