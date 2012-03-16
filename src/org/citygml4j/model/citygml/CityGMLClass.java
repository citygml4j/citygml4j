/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
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
import org.citygml4j.model.citygml.building.AbstractBoundarySurface;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.building.AbstractOpening;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.building.BuildingPartProperty;
import org.citygml4j.model.citygml.building.CeilingSurface;
import org.citygml4j.model.citygml.building.ClosureSurface;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.building.FloorSurface;
import org.citygml4j.model.citygml.building.GroundSurface;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.IntBuildingInstallationProperty;
import org.citygml4j.model.citygml.building.InteriorFurnitureProperty;
import org.citygml4j.model.citygml.building.InteriorRoomProperty;
import org.citygml4j.model.citygml.building.InteriorWallSurface;
import org.citygml4j.model.citygml.building.OpeningProperty;
import org.citygml4j.model.citygml.building.OuterCeilingSurface;
import org.citygml4j.model.citygml.building.OuterFloorSurface;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
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
import org.citygml4j.model.citygml.vegetation.AbstractVegetationObject;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.AbstractWaterObject;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.common.base.ModelClassEnum;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.geometry.AbstractGeometry;

public enum CityGMLClass implements ModelClassEnum {
	UNDEFINED(null),
	ABSTRACT_GML_GEOMETRY(AbstractGeometry.class),
	
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
	
	// Building
	ABSTRACT_BOUNDARY_SURFACE(AbstractBoundarySurface.class),
	ABSTRACT_BUILDING(AbstractBuilding.class),
	ABSTRACT_OPENING(AbstractOpening.class),	
	BOUNDARY_SURFACE_PROPERTY(BoundarySurfaceProperty.class),
	BUILDING(Building.class),
	BUILDING_FURNITURE(BuildingFurniture.class),
	INTERIOR_FURNITURE_PROPERTY(InteriorFurnitureProperty.class),
	BUILDING_INSTALLATION(BuildingInstallation.class),
	BUILDING_INSTALLATION_PROPERTY(BuildingInstallationProperty.class),
	BUILDING_PART(BuildingPart.class),
	BUILDING_PART_PROPERTY(BuildingPartProperty.class),
	INT_BUILDING_INSTALLATION(IntBuildingInstallation.class),
	INT_BUILDING_INSTALLATION_PROPERTY(IntBuildingInstallationProperty.class),
	ROOM(Room.class),	
	INTERIOR_ROOM_PROPERTY(InteriorRoomProperty.class),
	CEILING_SURFACE(CeilingSurface.class),
	CLOSURE_SURFACE(ClosureSurface.class),
	FLOOR_SURFACE(FloorSurface.class),
	OPENING_PROPERTY(OpeningProperty.class),
	OUTER_CEILING_SURFACE(OuterCeilingSurface.class),
	OUTER_FLOOR_SURFACE(OuterFloorSurface.class),
	GROUND_SURFACE(GroundSurface.class),	
	INTERIOR_WALL_SURFACE(InteriorWallSurface.class),
	ROOF_SURFACE(RoofSurface.class),
	WALL_SURFACE(WallSurface.class),	
	DOOR(Door.class),
	WINDOW(Window.class),	

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
	BOUNDED_BY_WATER_SURFACE_PROPERTY(BoundarySurfaceProperty.class),

	// TexturedSurface
	_ABSTRACT_APPEARANCE(_AbstractAppearance.class),
	_MATERIAL(_Material.class),
	_SIMPLE_TEXTURE(_SimpleTexture.class),
	_TEXTURED_SURFACE(_TexturedSurface.class),	
	_COLOR(_Color.class),
	_TEXTURE_TYPE(_TextureType.class),
	_APPEARANCE_PROPERTY(_AppearanceProperty.class);

	private final Class<? extends ModelObject> interfaceName;

	private CityGMLClass(Class<? extends ModelObject> interfaceName) {
		this.interfaceName = interfaceName;
	}
	
	public static CityGMLClass fromInterface(Class<? extends ModelObject> interfaceName) {
		if (interfaceName.isInterface()) {
			for (CityGMLClass c : CityGMLClass.values())
				if (c.interfaceName == interfaceName)
					return c;
		}

		return null;
	}
	
	public static CityGMLClass fromInt(int i) {
		for (CityGMLClass c : CityGMLClass.values()) {
			if (c.ordinal() == i) {
				return c;
			}
		}

		return UNDEFINED;
	}

	public Class<? extends ModelObject> getInterface() {
		return interfaceName;
	}
	
	public boolean isInstance(ModelClassEnum type) {
		return isInstance(interfaceName, type.getInterface());
	}
	
	private boolean isInstance(Class<?> a, Class<?> b) {
		if (a == null || b == null)
			return false;

		if (a == b)
			return true;

		for (Class<?> tmp : b.getInterfaces())
			if (isInstance(a, tmp))
				return true;

		return false;
	}
}
