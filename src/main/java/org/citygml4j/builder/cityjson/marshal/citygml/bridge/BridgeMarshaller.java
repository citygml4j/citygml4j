/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractBridgeType;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.binding.cityjson.feature.BridgeAttributes;
import org.citygml4j.binding.cityjson.feature.BridgeConstructionElementType;
import org.citygml4j.binding.cityjson.feature.BridgeInstallationType;
import org.citygml4j.binding.cityjson.feature.BridgePartType;
import org.citygml4j.binding.cityjson.feature.BridgeType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.binding.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.ade.ExtensionAttribute;
import org.citygml4j.builder.cityjson.marshal.util.SurfaceCollector;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.bridge.AbstractBoundarySurface;
import org.citygml4j.model.citygml.bridge.AbstractBridge;
import org.citygml4j.model.citygml.bridge.AbstractOpening;
import org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.bridge.Bridge;
import org.citygml4j.model.citygml.bridge.BridgeConstructionElement;
import org.citygml4j.model.citygml.bridge.BridgeConstructionElementProperty;
import org.citygml4j.model.citygml.bridge.BridgeInstallation;
import org.citygml4j.model.citygml.bridge.BridgeInstallationProperty;
import org.citygml4j.model.citygml.bridge.BridgePart;
import org.citygml4j.model.citygml.bridge.BridgePartProperty;
import org.citygml4j.model.citygml.bridge.ClosureSurface;
import org.citygml4j.model.citygml.bridge.Door;
import org.citygml4j.model.citygml.bridge.GroundSurface;
import org.citygml4j.model.citygml.bridge.OpeningProperty;
import org.citygml4j.model.citygml.bridge.OuterCeilingSurface;
import org.citygml4j.model.citygml.bridge.OuterFloorSurface;
import org.citygml4j.model.citygml.bridge.RoofSurface;
import org.citygml4j.model.citygml.bridge.WallSurface;
import org.citygml4j.model.citygml.bridge.Window;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.util.Collection;
import java.util.List;

public class BridgeMarshaller {
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;
	private final BiFunctionTypeMapper<CityJSON, AbstractCityObjectType> typeMapper;

	public BridgeMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();

		typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObjectType>create()
				.with(Bridge.class, this::marshalBridge)
				.with(BridgePart.class, this::marshalBridgePart)
				.with(BridgeConstructionElement.class, this::marshalBridgeConstructionElement)
				.with(BridgeInstallation.class, this::marshalBridgeInstallation);
	}

	public AbstractCityObjectType marshal(ModelObject src, CityJSON cityJSON) {
		return typeMapper.apply(src, cityJSON);
	}

	public SemanticsType marshalSemantics(AbstractCityObject cityObject) {
		SemanticsType semantics = null;

		if (cityObject instanceof RoofSurface)
			semantics = new SemanticsType("RoofSurface");
		else if (cityObject instanceof GroundSurface)
			semantics = new SemanticsType("GroundSurface");
		else if (cityObject instanceof WallSurface)
			semantics = new SemanticsType("WallSurface");
		else if (cityObject instanceof ClosureSurface)
			semantics = new SemanticsType("ClosureSurface");
		else if (cityObject instanceof OuterCeilingSurface)
			semantics = new SemanticsType("OuterCeilingSurface");
		else if (cityObject instanceof OuterFloorSurface)
			semantics = new SemanticsType("OuterFloorSurface");
		else if (cityObject instanceof Window)
			semantics = new SemanticsType("Window");
		else if (cityObject instanceof Door)
			semantics = new SemanticsType("Door");

		if (semantics != null)
			citygml.getGenericsMarshaller().marshalSemanticSurfaceAttributes(cityObject, semantics);

		return semantics;
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

		if (src.isSetGenericApplicationPropertyOfAbstractBridge()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfAbstractBridge()) {
				if (ade instanceof ADEModelObject) {
					ExtensionAttribute attribute = json.getADEMarshaller().unmarshalExtensionAttribute((ADEModelObject) ade);
					if (attribute != null)
						attributes.addExtensionAttribute(attribute.getName(), attribute.getValue());
				}
			}
		}

		if (src.isSetBoundedBySurface())
			preprocessGeometry(src);

		if (src.isSetLod1MultiSurface()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1MultiSurface());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod2MultiSurface()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2MultiSurface());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod3MultiSurface()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3MultiSurface());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod1Solid()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1Solid());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod2Solid()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2Solid());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod3Solid()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3Solid());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetOuterBridgeConstructionElement()) {
			for (BridgeConstructionElementProperty property : src.getOuterBridgeConstructionElement()) {
				AbstractCityObjectType cityObject = json.getGMLMarshaller().marshal(property, cityJSON);
				if (cityObject instanceof BridgeConstructionElementType) {
					dest.addChild(cityObject);
					cityJSON.addCityObject(cityObject);
				}
			}
		}
		
		if (src.isSetOuterBridgeInstallation()) {
			for (BridgeInstallationProperty property : src.getOuterBridgeInstallation()) {
				AbstractCityObjectType cityObject = json.getGMLMarshaller().marshal(property, cityJSON);
				if (cityObject instanceof BridgeInstallationType) {
					dest.addChild(cityObject);
					cityJSON.addCityObject(cityObject);
				}
			}
		}

		if (dest instanceof BridgeType && src.isSetConsistsOfBridgePart()) {
			for (BridgePartProperty property : src.getConsistsOfBridgePart()) {
				AbstractCityObjectType cityObject = json.getGMLMarshaller().marshal(property, cityJSON);
				if (cityObject instanceof BridgePartType) {
					dest.addChild(cityObject);
					cityJSON.addCityObject(cityObject);
				}
			}
		}
		
		if (src.isSetAddress()) {
			for (AddressProperty property : src.getAddress()) {
				if (property.isSetAddress()) {
					dest.setAddress(citygml.getCoreMarshaller().marshalAddress(property.getAddress()));
					break;
				}
			}
		}
	}

	public void marshalBridge(Bridge src, BridgeType dest, CityJSON cityJSON) {
		marshalAbstractBridge(src, dest, cityJSON);

		if (src.isSetGenericApplicationPropertyOfBridge()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfBridge()) {
				if (ade instanceof ADEModelObject) {
					ExtensionAttribute attribute = json.getADEMarshaller().unmarshalExtensionAttribute((ADEModelObject) ade);
					if (attribute != null)
						dest.getAttributes().addExtensionAttribute(attribute.getName(), attribute.getValue());
				}
			}
		}
	}

	public BridgeType marshalBridge(Bridge src, CityJSON cityJSON) {
		BridgeType dest = new BridgeType();
		marshalBridge(src, dest, cityJSON);

		return dest;
	}

	public void marshalBridgePart(BridgePart src, BridgePartType dest, CityJSON cityJSON) {
		marshalAbstractBridge(src, dest, cityJSON);

		if (src.isSetGenericApplicationPropertyOfBridgePart()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfBridgePart()) {
				if (ade instanceof ADEModelObject) {
					ExtensionAttribute attribute = json.getADEMarshaller().unmarshalExtensionAttribute((ADEModelObject) ade);
					if (attribute != null)
						dest.getAttributes().addExtensionAttribute(attribute.getName(), attribute.getValue());
				}
			}
		}
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

		if (src.isSetBoundedBySurface())
			preprocessGeometry(src);

		if (src.isSetLod2Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2Geometry());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod3Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3Geometry());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod2ImplicitRepresentation()) {
			GeometryInstanceType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation(), 2);
			if (geometry != null)
				dest.addGeometry(geometry);
		}
		
		if (src.isSetLod3ImplicitRepresentation()) {
			GeometryInstanceType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation(), 3);
			if (geometry != null)
				dest.addGeometry(geometry);
		}
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

		if (src.isSetBoundedBySurface())
			preprocessGeometry(src);

		if (src.isSetLod2Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2Geometry());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod3Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3Geometry());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod2ImplicitRepresentation()) {
			GeometryInstanceType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation(), 2);
			if (geometry != null)
				dest.addGeometry(geometry);
		}
		
		if (src.isSetLod3ImplicitRepresentation()) {
			GeometryInstanceType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation(), 3);
			if (geometry != null)
				dest.addGeometry(geometry);
		}
	}

	public BridgeInstallationType marshalBridgeInstallation(BridgeInstallation src, CityJSON cityJSON) {
		BridgeInstallationType dest = new BridgeInstallationType();
		marshalBridgeInstallation(src, dest, cityJSON);

		return dest;
	}

	private void preprocessGeometry(AbstractBridge bridge) {
		SurfaceCollector collector = collectBoundarySurfaces(bridge.getBoundedBySurface());		
		if (collector.hasSurfaces()) {		
			for (int lod = 2; lod < 4; lod++) {
				Collection<AbstractSurface> surfaces = collector.getSurfaces(lod);
				if (surfaces != null) {
					MultiSurface multiSurface = null;
					switch (lod) {
					case 2:
						if (bridge.isSetLod2MultiSurface() && bridge.getLod2MultiSurface().isSetMultiSurface())
							multiSurface = bridge.getLod2MultiSurface().getMultiSurface();
						else {
							multiSurface = new MultiSurface();
							bridge.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
						}
						break;
					case 3:
						if (bridge.isSetLod3MultiSurface() && bridge.getLod3MultiSurface().isSetMultiSurface())
							multiSurface = bridge.getLod3MultiSurface().getMultiSurface();
						else {
							multiSurface = new MultiSurface();
							bridge.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
						}
					}

					for (AbstractSurface surface : surfaces) {					
						SurfaceProperty dummy = new SurfaceProperty();
						dummy.setLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK, surface);
						surface.setLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK_TARGET, true);
						multiSurface.addSurfaceMember(dummy);
					}
				}
			}
		}
	}

	private void preprocessGeometry(BridgeInstallation installation) {
		SurfaceCollector collector = collectBoundarySurfaces(installation.getBoundedBySurface());		
		if (collector.hasSurfaces()) {		
			for (int lod = 2; lod < 4; lod++) {
				Collection<AbstractSurface> surfaces = collector.getSurfaces(lod);
				if (surfaces != null) {
					MultiSurface multiSurface = null;
					switch (lod) {
					case 2:
						if (installation.isSetLod2Geometry() && installation.getLod2Geometry().getGeometry() instanceof MultiSurface)
							multiSurface = (MultiSurface)installation.getLod2Geometry().getGeometry();
						else {
							multiSurface = new MultiSurface();
							installation.setLod2Geometry(new MultiSurfaceProperty(multiSurface));
						}
						break;
					case 3:
						if (installation.isSetLod3Geometry() && installation.getLod3Geometry().getGeometry() instanceof MultiSurface)
							multiSurface = (MultiSurface)installation.getLod3Geometry().getGeometry();
						else {
							multiSurface = new MultiSurface();
							installation.setLod3Geometry(new MultiSurfaceProperty(multiSurface));
						}
					}

					for (AbstractSurface surface : surfaces) {					
						SurfaceProperty dummy = new SurfaceProperty();
						dummy.setLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK, surface);
						surface.setLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK_TARGET, true);
						multiSurface.addSurfaceMember(dummy);
					}
				}
			}
		}
	}
	
	private void preprocessGeometry(BridgeConstructionElement element) {
		SurfaceCollector collector = collectBoundarySurfaces(element.getBoundedBySurface());		
		if (collector.hasSurfaces()) {		
			for (int lod = 2; lod < 4; lod++) {
				Collection<AbstractSurface> surfaces = collector.getSurfaces(lod);
				if (surfaces != null) {
					MultiSurface multiSurface = null;
					switch (lod) {
					case 2:
						if (element.isSetLod2Geometry() && element.getLod2Geometry().getGeometry() instanceof MultiSurface)
							multiSurface = (MultiSurface)element.getLod2Geometry().getGeometry();
						else {
							multiSurface = new MultiSurface();
							element.setLod2Geometry(new MultiSurfaceProperty(multiSurface));
						}
						break;
					case 3:
						if (element.isSetLod3Geometry() && element.getLod3Geometry().getGeometry() instanceof MultiSurface)
							multiSurface = (MultiSurface)element.getLod3Geometry().getGeometry();
						else {
							multiSurface = new MultiSurface();
							element.setLod3Geometry(new MultiSurfaceProperty(multiSurface));
						}
					}

					for (AbstractSurface surface : surfaces) {					
						SurfaceProperty dummy = new SurfaceProperty();
						dummy.setLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK, surface);
						surface.setLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK_TARGET, true);
						multiSurface.addSurfaceMember(dummy);
					}
				}
			}
		}
	}

	private SurfaceCollector collectBoundarySurfaces(List<BoundarySurfaceProperty> boundaryProperties) {
		SurfaceCollector collector = new SurfaceCollector();

		for (BoundarySurfaceProperty boundaryProperty : boundaryProperties) {
			if (boundaryProperty.isSetBoundarySurface()) {
				AbstractBoundarySurface boundarySurface = boundaryProperty.getBoundarySurface();
				LodRepresentation lodRepresentation = boundarySurface.getLodRepresentation();
				for (int lod = 2; lod < 4; lod++) {
					if (lodRepresentation.isSetGeometry(lod)) {
						collector.setLod(lod);
						for (GeometryProperty<?> geometryProperty : lodRepresentation.getGeometry(lod))
							collector.visit(geometryProperty);
					}
				}

				if (boundarySurface.isSetOpening()) {
					for (OpeningProperty openingProperty : boundarySurface.getOpening()) {
						if (openingProperty.isSetOpening()) {
							AbstractOpening opening = openingProperty.getOpening();
							lodRepresentation = opening.getLodRepresentation();
							for (int lod = 3; lod < 4; lod++) {
								if (lodRepresentation.isSetGeometry(lod)) {
									collector.setLod(lod);
									for (GeometryProperty<?> geometryProperty : lodRepresentation.getGeometry(lod))
										collector.visit(geometryProperty);
								}
							}
						}
					}
				}
			}
		}

		return collector;
	}
}
