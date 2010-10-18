/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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

public enum CityGMLClass {
	UNDEFINED,
	
	// ADE
	ADE_COMPONENT,
	
	// Core
	ADDRESS,
	ADDRESS_PROPERTY,
	CITY_MODEL,
	CITY_OBJECT_MEMBER,
	EXTERNAL_OBJECT,
	EXTERNAL_REFERENCE,
	GENERALIZATION_RELATION,
	IMPLICIT_GEOMETRY,
	IMPLICIT_REPRESENTATION_PROPERTY,
	TRANSFORMATION_MATRIX_2X2,
	TRANSFORMATION_MATRIX_3X4,
	TRANSFORMATION_MATRIX_4X4,
	XAL_ADDRESS_PROPERTY_TYPE,	

	// Appearance
	APPEARANCE,
	APPEARANCE_MEMBER,
	APPEARANCE_PROPERTY,
	COLOR,
	COLOR_PLUS_OPACITY,
	GEOREFERENCED_TEXTURE,
	PARAMETERIZED_TEXTURE,
	SURFACE_DATA_PROPERTY,
	TEX_COORD_GEN,
	TEX_COORD_LIST,
	TEXTURE_ASSOCIATION,
	TEXTURE_COORDINATES,
	TEXTURE_TYPE,
	WORLD_TO_TEXTURE,
	WRAP_MODE,
	X3D_MATERIAL,
	
	// Building	
	BOUNDARY_SURFACE_PROPERTY,
	BUILDING,
	BUILDING_FURNITURE,
	INTERIOR_FURNITURE_PROPERTY,
	BUILDING_INSTALLATION,
	BUILDING_INSTALLATION_PROPERTY,
	BUILDING_PART,
	BUILDING_PART_PROPERTY,
	INT_BUILDING_INSTALLATION,
	INT_BUILDING_INSTALLATION_PROPERTY,
	ROOM,	
	INTERIOR_ROOM_PROPERTY,
	CEILING_SURFACE,
	CLOSURE_SURFACE,
	FLOOR_SURFACE,
	GROUND_SURFACE,	
	INTERIOR_WALL_SURFACE,
	ROOF_SURFACE,
	WALL_SURFACE,	
	DOOR,
	WINDOW,	
	OPENING_PROPERTY,
	
	// CityFurniture
	CITY_FURNITURE,
	
	// CityObjectGroup
	CITY_OBJECT_GROUP,
	CITY_OBJECT_GROUP_MEMBER,
	CITY_OBJECT_GROUP_PARENT,
	
	// Generics
	GENERIC_CITY_OBJECT,
	DATE_ATTRIBUTE,
	DOUBLE_ATTRIBUTE,
	INT_ATTRIBUTE,
	STRING_ATTRIBUTE,
	URI_ATTRIBUTE,
	
	// LandUse
	LAND_USE,
	
	// Relief
	RELIEF_FEATURE,
	BREAKLINE_RELIEF,
	GRID_PROPERTY,
	MASSPOINT_RELIEF,
	RASTER_RELIEF,
	TIN_RELIEF,
	RELIEF_COMPONENT_PROPERTY,
	TIN_PROPERTY,
	
	// Transportation
	TRANSPORTATION_COMPLEX,	
	AUXILIARY_TRAFFIC_AREA,	
	RAILWAY,	
	ROAD,
	SQUARE,	
	TRACK,
	TRAFFIC_AREA,
	AUXILIARY_TRAFFIC_AREA_PROPERTY,
	TRAFFIC_AREA_PROPERTY,
	
	// Vegetation	
	PLANT_COVER,	
	SOLITARY_VEGETATION_OBJECT,
	
	// WaterBody	
	WATER_BODY,
	WATER_CLOSURE_SURFACE,
	WATER_GROUND_SURFACE,	
	WATER_SURFACE,
	BOUNDED_BY_WATER_SURFACE_PROPERTY,
	
	// TexturedSurface
	_MATERIAL,
	_SIMPLE_TEXTURE,
	_TEXTURED_SURFACE,	
	_COLOR,
	_TEXTURE_TYPE,
	_APPEARANCE_PROPERTY	
}
