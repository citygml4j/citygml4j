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
package org.citygml4j.model.citygml;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
import org.citygml4j.model.citygml.appearance.AbstractTextureParameterization;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.appearance.Color;
import org.citygml4j.model.citygml.appearance.ColorPlusOpacity;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.SurfaceDataProperty;
import org.citygml4j.model.citygml.appearance.TexCoordGen;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.citygml.appearance.TextureCoordinates;
import org.citygml4j.model.citygml.appearance.TextureType;
import org.citygml4j.model.citygml.appearance.WorldToTexture;
import org.citygml4j.model.citygml.appearance.WrapMode;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.citygml.bridge.AbstractBridge;
import org.citygml4j.model.citygml.bridge.Bridge;
import org.citygml4j.model.citygml.bridge.BridgeConstructionElement;
import org.citygml4j.model.citygml.bridge.BridgeConstructionElementProperty;
import org.citygml4j.model.citygml.bridge.BridgeFurniture;
import org.citygml4j.model.citygml.bridge.BridgeInstallation;
import org.citygml4j.model.citygml.bridge.BridgeInstallationProperty;
import org.citygml4j.model.citygml.bridge.BridgePart;
import org.citygml4j.model.citygml.bridge.BridgePartProperty;
import org.citygml4j.model.citygml.bridge.BridgeRoom;
import org.citygml4j.model.citygml.bridge.IntBridgeInstallation;
import org.citygml4j.model.citygml.bridge.IntBridgeInstallationProperty;
import org.citygml4j.model.citygml.bridge.InteriorBridgeRoomProperty;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.building.BuildingPartProperty;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.IntBuildingInstallationProperty;
import org.citygml4j.model.citygml.building.InteriorRoomProperty;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.AbstractSite;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.ExternalObject;
import org.citygml4j.model.citygml.core.ExternalReference;
import org.citygml4j.model.citygml.core.GeneralizationRelation;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.RelativeToTerrain;
import org.citygml4j.model.citygml.core.RelativeToWater;
import org.citygml4j.model.citygml.core.TransformationMatrix2x2;
import org.citygml4j.model.citygml.core.TransformationMatrix3x4;
import org.citygml4j.model.citygml.core.TransformationMatrix4x4;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.citygml.generics.AbstractGenericAttribute;
import org.citygml4j.model.citygml.generics.DateAttribute;
import org.citygml4j.model.citygml.generics.DoubleAttribute;
import org.citygml4j.model.citygml.generics.GenericAttributeSet;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.generics.IntAttribute;
import org.citygml4j.model.citygml.generics.MeasureAttribute;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.citygml.generics.UriAttribute;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.relief.AbstractReliefComponent;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.GridProperty;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;
import org.citygml4j.model.citygml.texturedsurface._AbstractAppearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TextureType;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.citygml.transportation.AbstractTransportationObject;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.citygml.tunnel.AbstractTunnel;
import org.citygml4j.model.citygml.tunnel.HollowSpace;
import org.citygml4j.model.citygml.tunnel.IntTunnelInstallation;
import org.citygml4j.model.citygml.tunnel.IntTunnelInstallationProperty;
import org.citygml4j.model.citygml.tunnel.InteriorHollowSpaceProperty;
import org.citygml4j.model.citygml.tunnel.Tunnel;
import org.citygml4j.model.citygml.tunnel.TunnelFurniture;
import org.citygml4j.model.citygml.tunnel.TunnelInstallation;
import org.citygml4j.model.citygml.tunnel.TunnelInstallationProperty;
import org.citygml4j.model.citygml.tunnel.TunnelPart;
import org.citygml4j.model.citygml.tunnel.TunnelPartProperty;
import org.citygml4j.model.citygml.vegetation.AbstractVegetationObject;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.AbstractWaterObject;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.common.base.ModelClassEnum;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.xal.XALClass;

public enum CityGMLClass implements ModelClassEnum {
	UNDEFINED(null),
	ABSTRACT_GML_GEOMETRY(null),

	// ADE
	ADE_COMPONENT(ADEComponent.class),

	// Core
	ABSTRACT_CITY_OBJECT(AbstractCityObject.class),
	ABSTRACT_SITE(AbstractSite.class),
	ADDRESS(Address.class),
	ADDRESS_PROPERTY(AddressProperty.class),
	CITY_MODEL(CityModel.class),
	CITY_OBJECT_MEMBER(CityObjectMember.class),
	EXTERNAL_OBJECT(ExternalObject.class),
	EXTERNAL_REFERENCE(ExternalReference.class),
	GENERALIZATION_RELATION(GeneralizationRelation.class),
	IMPLICIT_GEOMETRY(ImplicitGeometry.class),
	IMPLICIT_REPRESENTATION_PROPERTY(ImplicitRepresentationProperty.class),
	RELATIVE_TO_TERRAIN(RelativeToTerrain.class),
	RELATIVE_TO_WATER(RelativeToWater.class),
	TRANSFORMATION_MATRIX_2X2(TransformationMatrix2x2.class),
	TRANSFORMATION_MATRIX_3X4(TransformationMatrix3x4.class),
	TRANSFORMATION_MATRIX_4X4(TransformationMatrix4x4.class),
	XAL_ADDRESS_PROPERTY(XalAddressProperty.class),	

	// Appearance
	ABSTRACT_SURFACE_DATA(AbstractSurfaceData.class),
	ABSTRACT_TEXTURE(AbstractTexture.class),
	ABSTRACT_TEXTURE_PARAMETERIZATION(AbstractTextureParameterization.class),
	APPEARANCE(Appearance.class),
	APPEARANCE_MEMBER(AppearanceMember.class),
	APPEARANCE_PROPERTY(AppearanceProperty.class),
	COLOR(Color.class),
	COLOR_PLUS_OPACITY(ColorPlusOpacity.class),
	GEOREFERENCED_TEXTURE(GeoreferencedTexture.class),
	PARAMETERIZED_TEXTURE(ParameterizedTexture.class),
	SURFACE_DATA_PROPERTY(SurfaceDataProperty.class),
	TEX_COORD_GEN(TexCoordGen.class),
	TEX_COORD_LIST(TexCoordList.class),
	TEXTURE_ASSOCIATION(TextureAssociation.class),
	TEXTURE_COORDINATES(TextureCoordinates.class),
	TEXTURE_TYPE(TextureType.class),
	WORLD_TO_TEXTURE(WorldToTexture.class),
	WRAP_MODE(WrapMode.class),
	X3D_MATERIAL(X3DMaterial.class),

	// Bridge
	ABSTRACT_BRIDGE_BOUNDARY_SURFACE(org.citygml4j.model.citygml.bridge.AbstractBoundarySurface.class),
	ABSTRACT_BRIDGE(AbstractBridge.class),
	ABSTRACT_BRIDGE_OPENING(org.citygml4j.model.citygml.bridge.AbstractOpening.class),
	BRIDGE(Bridge.class),
	BRIDGE_FURNITURE(BridgeFurniture.class),
	BRIDGE_CONSTRUCTION_ELEMENT(BridgeConstructionElement.class),
	BRIDGE_CONSTRUCTION_ELEMENT_PROPERTY(BridgeConstructionElementProperty.class),
	BRIDGE_INSTALLATION(BridgeInstallation.class),
	BRIDGE_INSTALLATION_PROPERTY(BridgeInstallationProperty.class),
	BRIDGE_PART(BridgePart.class),
	BRIDGE_PART_PROPERTY(BridgePartProperty.class),
	INT_BRIDGE_INSTALLATION(IntBridgeInstallation.class),
	INT_BRIDGE_INSTALLATION_PROPERTY(IntBridgeInstallationProperty.class),
	BRIDGE_ROOM(BridgeRoom.class),	
	INTERIOR_BRIDGE_ROOM_PROPERTY(InteriorBridgeRoomProperty.class),
	BRIDGE_BOUNDARY_SURFACE_PROPERTY(org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty.class),
	INTERIOR_BRIDGE_FURNITURE_PROPERTY(org.citygml4j.model.citygml.bridge.InteriorFurnitureProperty.class),
	BRIDGE_CEILING_SURFACE(org.citygml4j.model.citygml.bridge.CeilingSurface.class),
	BRIDGE_CLOSURE_SURFACE(org.citygml4j.model.citygml.bridge.ClosureSurface.class),
	BRIDGE_FLOOR_SURFACE(org.citygml4j.model.citygml.bridge.FloorSurface.class),
	BRIDGE_OPENING_PROPERTY(org.citygml4j.model.citygml.bridge.OpeningProperty.class),
	OUTER_BRIDGE_CEILING_SURFACE(org.citygml4j.model.citygml.bridge.OuterCeilingSurface.class),
	OUTER_BRIDGE_FLOOR_SURFACE(org.citygml4j.model.citygml.bridge.OuterFloorSurface.class),
	BRIDGE_GROUND_SURFACE(org.citygml4j.model.citygml.bridge.GroundSurface.class),	
	INTERIOR_BRIDGE_WALL_SURFACE(org.citygml4j.model.citygml.bridge.InteriorWallSurface.class),
	BRIDGE_ROOF_SURFACE(org.citygml4j.model.citygml.bridge.RoofSurface.class),
	BRIDGE_WALL_SURFACE(org.citygml4j.model.citygml.bridge.WallSurface.class),	
	BRIDGE_DOOR(org.citygml4j.model.citygml.bridge.Door.class),
	BRIDGE_WINDOW(org.citygml4j.model.citygml.bridge.Window.class),	

	// Building
	ABSTRACT_BUILDING_BOUNDARY_SURFACE(org.citygml4j.model.citygml.building.AbstractBoundarySurface.class),
	ABSTRACT_BUILDING(AbstractBuilding.class),
	ABSTRACT_BUILDING_OPENING(org.citygml4j.model.citygml.building.AbstractOpening.class),
	BUILDING(Building.class),
	BUILDING_FURNITURE(BuildingFurniture.class),
	BUILDING_INSTALLATION(BuildingInstallation.class),
	BUILDING_INSTALLATION_PROPERTY(BuildingInstallationProperty.class),
	BUILDING_PART(BuildingPart.class),
	BUILDING_PART_PROPERTY(BuildingPartProperty.class),
	INT_BUILDING_INSTALLATION(IntBuildingInstallation.class),
	INT_BUILDING_INSTALLATION_PROPERTY(IntBuildingInstallationProperty.class),
	BUILDING_ROOM(Room.class),	
	INTERIOR_ROOM_PROPERTY(InteriorRoomProperty.class),
	BUILDING_BOUNDARY_SURFACE_PROPERTY(org.citygml4j.model.citygml.building.BoundarySurfaceProperty.class),
	INTERIOR_BUILDING_FURNITURE_PROPERTY(org.citygml4j.model.citygml.building.InteriorFurnitureProperty.class),
	BUILDING_CEILING_SURFACE(org.citygml4j.model.citygml.building.CeilingSurface.class),
	BUILDING_CLOSURE_SURFACE(org.citygml4j.model.citygml.building.ClosureSurface.class),
	BUILDING_FLOOR_SURFACE(org.citygml4j.model.citygml.building.FloorSurface.class),
	BUILDING_OPENING_PROPERTY(org.citygml4j.model.citygml.building.OpeningProperty.class),
	OUTER_BUILDING_CEILING_SURFACE(org.citygml4j.model.citygml.building.OuterCeilingSurface.class),
	OUTER_BUILDING_FLOOR_SURFACE(org.citygml4j.model.citygml.building.OuterFloorSurface.class),
	BUILDING_GROUND_SURFACE(org.citygml4j.model.citygml.building.GroundSurface.class),	
	INTERIOR_BUILDING_WALL_SURFACE(org.citygml4j.model.citygml.building.InteriorWallSurface.class),
	BUILDING_ROOF_SURFACE(org.citygml4j.model.citygml.building.RoofSurface.class),
	BUILDING_WALL_SURFACE(org.citygml4j.model.citygml.building.WallSurface.class),	
	BUILDING_DOOR(org.citygml4j.model.citygml.building.Door.class),
	BUILDING_WINDOW(org.citygml4j.model.citygml.building.Window.class),	

	// CityFurniture
	CITY_FURNITURE(CityFurniture.class),

	// CityObjectGroup
	CITY_OBJECT_GROUP(CityObjectGroup.class),
	CITY_OBJECT_GROUP_MEMBER(CityObjectGroupMember.class),
	CITY_OBJECT_GROUP_PARENT(CityObjectGroupParent.class),

	// Generics
	ABSTRACT_GENERIC_ATTRIBUTE(AbstractGenericAttribute.class),
	GENERIC_CITY_OBJECT(GenericCityObject.class),
	DATE_ATTRIBUTE(DateAttribute.class),
	DOUBLE_ATTRIBUTE(DoubleAttribute.class),
	INT_ATTRIBUTE(IntAttribute.class),
	STRING_ATTRIBUTE(StringAttribute.class),
	URI_ATTRIBUTE(UriAttribute.class),
	MEASURE_ATTRIBUTE(MeasureAttribute.class),
	GENERIC_ATTRIBUTE_SET(GenericAttributeSet.class),

	// LandUse
	LAND_USE(LandUse.class),

	// Relief
	ABSTRACT_RELIEF_COMPONENT(AbstractReliefComponent.class),
	RELIEF_FEATURE(ReliefFeature.class),
	BREAKLINE_RELIEF(BreaklineRelief.class),
	GRID_PROPERTY(GridProperty.class),
	MASSPOINT_RELIEF(MassPointRelief.class),
	RASTER_RELIEF(RasterRelief.class),
	TIN_RELIEF(TINRelief.class),
	RELIEF_COMPONENT_PROPERTY(ReliefComponentProperty.class),
	TIN_PROPERTY(TinProperty.class),

	// Transportation
	ABSTRACT_TRANSPORTATION_OBJECT(AbstractTransportationObject.class),
	TRANSPORTATION_COMPLEX(TransportationComplex.class),	
	AUXILIARY_TRAFFIC_AREA(AuxiliaryTrafficArea.class),	
	RAILWAY(Railway.class),	
	ROAD(Road.class),
	SQUARE(Square.class),	
	TRACK(Track.class),
	TRAFFIC_AREA(TrafficArea.class),
	AUXILIARY_TRAFFIC_AREA_PROPERTY(AuxiliaryTrafficAreaProperty.class),
	TRAFFIC_AREA_PROPERTY(TrafficAreaProperty.class),

	// Tunnel
	ABSTRACT_TUNNEL_BOUNDARY_SURFACE(org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface.class),
	ABSTRACT_TUNNEL(AbstractTunnel.class),
	ABSTRACT_TUNNEL_OPENING(org.citygml4j.model.citygml.tunnel.AbstractOpening.class),
	TUNNEL(Tunnel.class),
	TUNNEL_FURNITURE(TunnelFurniture.class),
	TUNNEL_INSTALLATION(TunnelInstallation.class),
	TUNNEL_INSTALLATION_PROPERTY(TunnelInstallationProperty.class),
	TUNNEL_PART(TunnelPart.class),
	TUNNEL_PART_PROPERTY(TunnelPartProperty.class),
	INT_TUNNEL_INSTALLATION(IntTunnelInstallation.class),
	INT_TUNNEL_INSTALLATION_PROPERTY(IntTunnelInstallationProperty.class),
	HOLLOW_SPACE(HollowSpace.class),	
	INTERIOR_HOLLOW_SPACE_PROPERTY(InteriorHollowSpaceProperty.class),
	TUNNEL_BOUNDARY_SURFACE_PROPERTY(org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty.class),
	INTERIOR_TUNNEL_FURNITURE_PROPERTY(org.citygml4j.model.citygml.tunnel.InteriorFurnitureProperty.class),
	TUNNEL_CEILING_SURFACE(org.citygml4j.model.citygml.tunnel.CeilingSurface.class),
	TUNNEL_CLOSURE_SURFACE(org.citygml4j.model.citygml.tunnel.ClosureSurface.class),
	TUNNEL_FLOOR_SURFACE(org.citygml4j.model.citygml.tunnel.FloorSurface.class),
	TUNNEL_OPENING_PROPERTY(org.citygml4j.model.citygml.tunnel.OpeningProperty.class),
	OUTER_TUNNEL_CEILING_SURFACE(org.citygml4j.model.citygml.tunnel.OuterCeilingSurface.class),
	OUTER_TUNNEL_FLOOR_SURFACE(org.citygml4j.model.citygml.tunnel.OuterFloorSurface.class),
	TUNNEL_GROUND_SURFACE(org.citygml4j.model.citygml.tunnel.GroundSurface.class),	
	INTERIOR_TUNNEL_WALL_SURFACE(org.citygml4j.model.citygml.tunnel.InteriorWallSurface.class),
	TUNNEL_ROOF_SURFACE(org.citygml4j.model.citygml.tunnel.RoofSurface.class),
	TUNNEL_WALL_SURFACE(org.citygml4j.model.citygml.tunnel.WallSurface.class),	
	TUNNEL_DOOR(org.citygml4j.model.citygml.tunnel.Door.class),
	TUNNEL_WINDOW(org.citygml4j.model.citygml.tunnel.Window.class),	

	// Vegetation
	ABSTRACT_VEGETATION_OBJECT(AbstractVegetationObject.class),
	PLANT_COVER(PlantCover.class),	
	SOLITARY_VEGETATION_OBJECT(SolitaryVegetationObject.class),

	// WaterBody
	ABSTRACT_WATER_BOUNDARY_SURFACE(AbstractWaterBoundarySurface.class),
	ABSTRACT_WATER_OBJECT(AbstractWaterObject.class),
	WATER_BODY(WaterBody.class),
	WATER_CLOSURE_SURFACE(WaterClosureSurface.class),
	WATER_GROUND_SURFACE(WaterGroundSurface.class),	
	WATER_SURFACE(WaterSurface.class),
	BOUNDED_BY_WATER_SURFACE_PROPERTY(BoundedByWaterSurfaceProperty.class),

	// TexturedSurface
	_ABSTRACT_APPEARANCE(_AbstractAppearance.class),
	_MATERIAL(_Material.class),
	_SIMPLE_TEXTURE(_SimpleTexture.class),
	_TEXTURED_SURFACE(_TexturedSurface.class),	
	_COLOR(_Color.class),
	_TEXTURE_TYPE(_TextureType.class),
	_APPEARANCE_PROPERTY(_AppearanceProperty.class);

	private final Class<? extends CityGML> modelClass;

	private CityGMLClass(Class<? extends CityGML> modelClass) {
		this.modelClass = modelClass;
	}

	public Class<? extends CityGML> getModelClass() {
		return modelClass;
	}

	public static CityGMLClass fromModelClass(Class<? extends CityGML> modelClass) {
		for (CityGMLClass c : CityGMLClass.values())
			if (c.modelClass == modelClass)
				return c;

		return UNDEFINED;
	}

	public static CityGMLClass fromInt(int i) {
		for (CityGMLClass c : CityGMLClass.values()) {
			if (c.ordinal() == i)
				return c;
		}

		return UNDEFINED;
	}

	public boolean isInstance(ModelClassEnum type) {
		if (type == null)
			return false;
		
		Class<?> tmp = modelClass;
		Class<?> otherModelClass = null;

		if (type instanceof CityGMLClass)
			otherModelClass = ((CityGMLClass)type).getModelClass();
		else if (type instanceof GMLClass)
			otherModelClass = ((GMLClass)type).getModelClass();
		else if (type instanceof XALClass)
			otherModelClass = ((XALClass)type).getModelClass();

		if (otherModelClass != null) {
			do {
				if (tmp == otherModelClass)
					return true;
			} while ((tmp = tmp.getSuperclass()) != null);
		}
		
		return false;
	}

}
