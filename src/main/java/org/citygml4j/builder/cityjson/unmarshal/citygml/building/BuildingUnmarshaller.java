/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.cityjson.unmarshal.citygml.building;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractBuildingType;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.binding.cityjson.feature.BuildingAttributes;
import org.citygml4j.binding.cityjson.feature.BuildingInstallationType;
import org.citygml4j.binding.cityjson.feature.BuildingPartType;
import org.citygml4j.binding.cityjson.feature.BuildingType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.binding.cityjson.geometry.AbstractSemanticsObject;
import org.citygml4j.binding.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.building.AbstractBoundarySurface;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.building.AbstractOpening;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.building.BuildingPartProperty;
import org.citygml4j.model.citygml.building.ClosureSurface;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.building.GroundSurface;
import org.citygml4j.model.citygml.building.OpeningProperty;
import org.citygml4j.model.citygml.building.OuterCeilingSurface;
import org.citygml4j.model.citygml.building.OuterFloorSurface;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.basicTypes.DoubleOrNull;
import org.citygml4j.model.gml.basicTypes.MeasureOrNullList;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class BuildingUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;
	private final BiFunctionTypeMapper<CityJSON, AbstractCityObject> typeMapper;

	public BuildingUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();

		typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObject>create()
				.with(BuildingType.class, this::unmarshalBuilding)
				.with(BuildingPartType.class, this::unmarshalBuildingPart)
				.with(BuildingInstallationType.class, this::unmarshalBuildingInstallation);
	}

	public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
		return typeMapper.apply(src, cityJSON);
	}

	public void unmarshalSemantics(AbstractSemanticsObject src, Map<Integer, List<AbstractSurface>> surfaces, Number lod, AbstractCityObject parent) {
		AbstractBoundarySurface boundarySurface = null;

		for (int i = 0; i < src.getNumSurfaces(); i++) {
			SemanticsType semanticsType = src.getSurfaces().get(i);
			if (semanticsType == null)
				continue;

			List<AbstractSurface> tmp = surfaces.get(i);
			if (tmp == null || tmp.isEmpty())
				continue;

			AbstractCityObject cityObject = null;
			switch (semanticsType.getType()) {
			case ROOF_SURFACE:
				cityObject = unmarshalRoofSurface(semanticsType, tmp, lod);
				break;
			case GROUND_SURFACE:
				cityObject = unmarshalGroundSurface(semanticsType, tmp, lod);
				break;
			case WALL_SURFACE:
				cityObject = unmarshalWallSurface(semanticsType, tmp, lod);
				break;
			case CLOSURE_SURFACE:
				cityObject = unmarshalClosureSurface(semanticsType, tmp, lod);
				break;
			case OUTER_CEILING_SURFACE:
				cityObject = unmarshalOuterCeilingSurface(semanticsType, tmp, lod);
				break;
			case OUTER_FLOOR_SURFACE:
				cityObject = unmarshalOuterFloorSurface(semanticsType, tmp, lod);
				break;
			case WINDOW:
				cityObject = unmarshalWindow(semanticsType, tmp, lod);
				break;
			case DOOR:
				cityObject = unmarshalDoor(semanticsType, tmp, lod);
				break;
			default:
				continue;
			}

			if (cityObject instanceof AbstractBoundarySurface) {
				boundarySurface = (AbstractBoundarySurface)cityObject;

				if (parent instanceof AbstractBuilding)
					((AbstractBuilding)parent).addBoundedBySurface(new BoundarySurfaceProperty(boundarySurface));
				else if (parent instanceof BuildingInstallation)
					((BuildingInstallation)parent).addBoundedBySurface(new BoundarySurfaceProperty(boundarySurface));
			}

			else if (cityObject instanceof AbstractOpening && boundarySurface != null) {
				// we need a boundary surface to assign the opening to
				boundarySurface.addOpening(new OpeningProperty((AbstractOpening)cityObject));
			}
		}
	}

	public void unmarshalAbstractBuilding(AbstractBuildingType src, AbstractBuilding dest, CityJSON cityJSON) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetAttributes()) {
			BuildingAttributes attributes = src.getAttributes();

			if (attributes.isSetClazz())
				dest.setClazz(new Code(attributes.getClazz()));

			if (attributes.isSetFunction())
				dest.addFunction(new Code(attributes.getFunction()));

			if (attributes.isSetUsage())
				dest.addUsage(new Code(attributes.getUsage()));

			if (attributes.isSetMeasuredHeight()) {
				Length measuredHeight = new Length(attributes.getMeasuredHeight());
				measuredHeight.setUom("#m");
				dest.setMeasuredHeight(measuredHeight);
			}

			if (attributes.isSetRoofType())
				dest.setRoofType(new Code(attributes.getRoofType()));

			if (attributes.isSetStoreysAboveGround())
				dest.setStoreysAboveGround(attributes.getStoreysAboveGround());

			if (attributes.isSetStoreysBelowGround())
				dest.setStoreysBelowGround(attributes.getStoreysBelowGround());

			if (attributes.isSetStoreyHeightsAboveGround()) {
				MeasureOrNullList heights = new MeasureOrNullList();
				for (Double height : attributes.getStoreyHeightsAboveGround())
					heights.addDoubleOrNull(new DoubleOrNull(height));

				heights.setUom("#m");
				dest.setStoreyHeightsAboveGround(heights);
			}

			if (attributes.isSetStoreyHeightsBelowGround()) {
				MeasureOrNullList heights = new MeasureOrNullList();
				for (Double height : attributes.getStoreyHeightsBelowGround())
					heights.addDoubleOrNull(new DoubleOrNull(height));

				heights.setUom("#m");
				dest.setStoreyHeightsBelowGround(heights);
			}

			if (attributes.isSetYearOfConstruction())
				dest.setYearOfConstruction(LocalDate.of(attributes.getYearOfConstruction(), 1, 1));

			if (attributes.isSetYearOfDemolition())
				dest.setYearOfDemolition(LocalDate.of(attributes.getYearOfDemolition(), 1, 1));
		}

		for (AbstractGeometryType geometryType : src.getGeometry()) {
			AbstractGeometry geometry = null;
			int lod = 0;

			if (geometryType instanceof AbstractGeometryObjectType) {
				AbstractGeometryObjectType geometryObject = (AbstractGeometryObjectType) geometryType;
				geometry = json.getGMLUnmarshaller().unmarshal(geometryObject, dest);
				geometryObject.getLod().intValue();
			} else if (geometryType instanceof GeometryInstanceType) {
				GeometryInstanceType geometryInstance = (GeometryInstanceType) geometryType;
				geometry = citygml.getCoreUnmarshaller().unmarshalAndTransformGeometryInstance(geometryInstance, dest);
				lod = (int) geometry.getLocalProperty(CityJSONUnmarshaller.GEOMETRY_INSTANCE_LOD);
			}

			if (geometry != null) {
				if (geometry instanceof MultiSurface) {
					MultiSurface multiSurface = (MultiSurface) geometry;
					switch (lod) {
						case 0:
							dest.setLod0FootPrint(new MultiSurfaceProperty(multiSurface));
							break;
						case 1:
							dest.setLod1MultiSurface(new MultiSurfaceProperty(multiSurface));
							break;
						case 2:
							dest.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
							break;
						case 3:
							dest.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
							break;
					}
				} else if (geometry instanceof AbstractSolid) {
					AbstractSolid solid = (AbstractSolid) geometry;
					switch (lod) {
						case 1:
							dest.setLod1Solid(new SolidProperty(solid));
							break;
						case 2:
							dest.setLod2Solid(new SolidProperty(solid));
							break;
						case 3:
							dest.setLod3Solid(new SolidProperty(solid));
							break;
					}
				}
			}
		}

		if (src.isSetChildren()) {
			for (String gmlId : src.getChildren()) {
				AbstractCityObjectType cityObject = cityJSON.getCityObject(gmlId);

				if (cityObject instanceof BuildingInstallationType) {
					BuildingInstallation installation = unmarshalBuildingInstallation((BuildingInstallationType) cityObject, cityJSON);
					dest.addOuterBuildingInstallation(new BuildingInstallationProperty(installation));
				} else if (cityObject instanceof BuildingPartType && src instanceof BuildingType) {
					BuildingPart part = unmarshalBuildingPart((BuildingPartType) cityObject, cityJSON);
					dest.addConsistsOfBuildingPart(new BuildingPartProperty(part));
				}
			}
		}

		if (src.isSetAddress())
			dest.addAddress(new AddressProperty(citygml.getCoreUnmarshaller().unmarshalAddress(src.getAddress())));
	}

	public Building unmarshalBuilding(BuildingType src, CityJSON cityJSON) {
		Building dest = new Building();
		unmarshalAbstractBuilding(src, dest, cityJSON);

		return dest;
	}
	
	public BuildingPart unmarshalBuildingPart(BuildingPartType src, CityJSON cityJSON) {
		BuildingPart dest = new BuildingPart();
		unmarshalAbstractBuilding(src, dest, cityJSON);

		return dest;
	}

	public void unmarshalBuildingInstallation(BuildingInstallationType src, BuildingInstallation dest) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetAttributes()) {
			Attributes attributes = src.getAttributes();
			if (attributes.isSetClazz())
				dest.setClazz(new Code(attributes.getClazz()));

			if (attributes.isSetFunction())
				dest.addFunction(new Code(attributes.getFunction()));

			if (attributes.isSetUsage())
				dest.addUsage(new Code(attributes.getUsage()));
		}

		for (AbstractGeometryType geometryType : src.getGeometry()) {
			if (geometryType instanceof AbstractGeometryObjectType) {
				AbstractGeometryObjectType geometryObject = (AbstractGeometryObjectType) geometryType;
				AbstractGeometry geometry = json.getGMLUnmarshaller().unmarshal(geometryObject, dest);

				if (geometry != null) {
					int lod = geometryObject.getLod().intValue();
					switch (lod) {
						case 2:
							dest.setLod2Geometry(new GeometryProperty<>(geometry));
							break;
						case 3:
							dest.setLod3Geometry(new GeometryProperty<>(geometry));
							break;
					}
				}
			} else if (geometryType instanceof GeometryInstanceType) {
				GeometryInstanceType geometryInstance = (GeometryInstanceType) geometryType;
				ImplicitGeometry geometry = citygml.getCoreUnmarshaller().unmarshalGeometryInstance(geometryInstance);

				if (geometry != null) {
					switch ((int) geometry.getLocalProperty(CityJSONUnmarshaller.GEOMETRY_INSTANCE_LOD)) {
						case 2:
							dest.setLod2ImplicitRepresentation(new ImplicitRepresentationProperty(geometry));
							break;
						case 3:
							dest.setLod3ImplicitRepresentation(new ImplicitRepresentationProperty(geometry));
							break;
					}
				}
			}
		}
	}

	public BuildingInstallation unmarshalBuildingInstallation(BuildingInstallationType src, CityJSON cityJSON) {
		BuildingInstallation dest = new BuildingInstallation();
		unmarshalBuildingInstallation(src, dest);

		return dest;
	}

	public void unmarshalAbstractBoundarySurface(SemanticsType src, AbstractBoundarySurface dest, List<AbstractSurface> surfaces, Number lod) {
		dest.setId(DefaultGMLIdManager.getInstance().generateUUID());
		
		if (src.isSetProperties())
			citygml.getGenericsUnmarshaller().unmarshalSemanticsAttributes(src.getProperties(), dest);

		MultiSurface multiSurface = new MultiSurface();
		for (AbstractSurface surface : surfaces)
			multiSurface.addSurfaceMember(new SurfaceProperty(surface));

		switch (lod.intValue()) {
		case 2:
			dest.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
			break;
		case 3:
			dest.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
			break;
		}
	}

	public RoofSurface unmarshalRoofSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		RoofSurface dest = new RoofSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}

	public GroundSurface unmarshalGroundSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		GroundSurface dest = new GroundSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}

	public WallSurface unmarshalWallSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		WallSurface dest = new WallSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}

	public ClosureSurface unmarshalClosureSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		ClosureSurface dest = new ClosureSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}

	public OuterCeilingSurface unmarshalOuterCeilingSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		OuterCeilingSurface dest = new OuterCeilingSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}

	public OuterFloorSurface unmarshalOuterFloorSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		OuterFloorSurface dest = new OuterFloorSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}

	public void unmarshalAbstractOpening(SemanticsType src, AbstractOpening dest, List<AbstractSurface> surfaces, Number lod) {
		if (src.isSetProperties())
			citygml.getGenericsUnmarshaller().unmarshalSemanticsAttributes(src.getProperties(), dest);

		if (lod.intValue() == 3) {
			MultiSurface multiSurface = new MultiSurface();
			for (AbstractSurface surface : surfaces)
				multiSurface.addSurfaceMember(new SurfaceProperty(surface));

			dest.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
		}
	}

	public Door unmarshalDoor(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		Door dest = new Door();
		unmarshalAbstractOpening(src, dest, surfaces, lod);

		return dest;
	}

	public Window unmarshalWindow(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		Window dest = new Window();
		unmarshalAbstractOpening(src, dest, surfaces, lod);

		return dest;
	}

}
