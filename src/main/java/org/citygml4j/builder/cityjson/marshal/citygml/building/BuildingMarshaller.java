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
package org.citygml4j.builder.cityjson.marshal.citygml.building;

import org.citygml4j.binding.cityjson.feature.AbstractBuildingType;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.binding.cityjson.feature.BuildingAttributes;
import org.citygml4j.binding.cityjson.feature.BuildingInstallationType;
import org.citygml4j.binding.cityjson.feature.BuildingPartType;
import org.citygml4j.binding.cityjson.feature.BuildingType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.binding.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.binding.cityjson.geometry.SemanticsTypeName;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.util.SurfaceCollector;
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
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.basicTypes.DoubleOrNull;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.util.mapper.TypeMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BuildingMarshaller {
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;
	private final TypeMapper<List<AbstractCityObjectType>> typeMapper;

	public BuildingMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();

		typeMapper = TypeMapper.<List<AbstractCityObjectType>>create()
				.with(Building.class, this::marshalBuilding)
				.with(BuildingPart.class, this::marshalBuildingPart)
				.with(BuildingInstallation.class, this::marshalBuildingInstallation);
	}

	public List<AbstractCityObjectType> marshal(ModelObject src) {
		return typeMapper.apply(src);
	}

	public SemanticsType marshalSemantics(AbstractCityObject cityObject) {
		SemanticsType semantics = null;

		if (cityObject instanceof RoofSurface)
			semantics = new SemanticsType(SemanticsTypeName.ROOF_SURFACE);
		else if (cityObject instanceof GroundSurface)
			semantics = new SemanticsType(SemanticsTypeName.GROUND_SURFACE);
		else if (cityObject instanceof WallSurface)
			semantics = new SemanticsType(SemanticsTypeName.WALL_SURFACE);
		else if (cityObject instanceof ClosureSurface)
			semantics = new SemanticsType(SemanticsTypeName.CLOSURE_SURFACE);
		else if (cityObject instanceof OuterCeilingSurface)
			semantics = new SemanticsType(SemanticsTypeName.OUTER_CEILING_SURFACE);
		else if (cityObject instanceof OuterFloorSurface)
			semantics = new SemanticsType(SemanticsTypeName.OUTER_FLOOR_SURFACE);
		else if (cityObject instanceof Window)
			semantics = new SemanticsType(SemanticsTypeName.WINDOW);
		else if (cityObject instanceof Door)
			semantics = new SemanticsType(SemanticsTypeName.DOOR);

		if (semantics != null && cityObject.isSetGenericAttribute())
			citygml.getGenericsMarshaller().marshalSemanticsAttributes(cityObject.getGenericAttribute(), semantics);

		return semantics;
	}

	public List<AbstractCityObjectType> marshalAbstractBuilding(AbstractBuilding src, AbstractBuildingType dest) {
		BuildingAttributes attributes = new BuildingAttributes();
		citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, attributes);

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

		if (src.isSetMeasuredHeight())
			attributes.setMeasuredHeight(src.getMeasuredHeight().getValue());

		if (src.isSetRoofType())
			attributes.setRoofType(src.getRoofType().getValue());

		if (src.isSetStoreysAboveGround())
			attributes.setStoreysAboveGround(src.getStoreysAboveGround());

		if (src.isSetStoreysBelowGround())
			attributes.setStoreysBelowGround(src.getStoreysBelowGround());

		if (src.isSetStoreyHeightsAboveGround()) {
			for (DoubleOrNull value : src.getStoreyHeightsAboveGround().getDoubleOrNull()) {
				if (value.isSetDouble())
					attributes.addStoreyHeightsAboveGround(value.getDouble());
			}
		}

		if (src.isSetStoreyHeightsBelowGround()) {
			for (DoubleOrNull value : src.getStoreyHeightsBelowGround().getDoubleOrNull()) {
				if (value.isSetDouble())
					attributes.addStoreyHeightsBelowGround(value.getDouble());
			}
		}

		if (src.isSetYearOfConstruction()) 
			attributes.setYearOfConstruction(src.getYearOfConstruction().getYear());

		if (src.isSetYearOfDemolition())
			attributes.setYearOfDemolition(src.getYearOfDemolition().getYear());

		if (attributes.hasAttributes())
			dest.setAttributes(attributes);

		if (src.isSetBoundedBySurface())
			preprocessGeometry(src);

		MultiSurfaceProperty lod0Representation = src.isSetLod0FootPrint() ? src.getLod0FootPrint() : src.getLod0RoofEdge();
		if (lod0Representation != null) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(lod0Representation);
			if (geometry != null) {
				geometry.setLod(0);
				dest.addGeometry(geometry);
			}
		}

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

		List<AbstractCityObjectType> cityObjects = new ArrayList<>();

		if (src.isSetOuterBuildingInstallation()) {
			for (BuildingInstallationProperty property : src.getOuterBuildingInstallation()) {
				if (property.isSetBuildingInstallation()) {
					for (AbstractCityObjectType cityObject : marshalBuildingInstallation(property.getBuildingInstallation())) {
						if (cityObject instanceof BuildingInstallationType) {
							dest.addChild(cityObject.getGmlId());
							((BuildingInstallationType) cityObject).setParent(dest.getGmlId());
						}

						cityObjects.add(cityObject);
					}
				}
			}
		}

		if (dest instanceof BuildingType && src.isSetConsistsOfBuildingPart()) {
			for (BuildingPartProperty property : src.getConsistsOfBuildingPart()) {
				if (property.isSetBuildingPart()) {
					for (AbstractCityObjectType cityObject : marshalBuildingPart(property.getBuildingPart())) {
						if (cityObject instanceof BuildingPartType) {
							dest.addChild(cityObject.getGmlId());
							((BuildingPartType) cityObject).setParent(dest.getGmlId());
						}

						cityObjects.add(cityObject);
					}
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

		return cityObjects;
	}

	public List<AbstractCityObjectType> marshalBuilding(Building src) {
		BuildingType dest = new BuildingType(src.getId());
		List<AbstractCityObjectType> cityObjects = marshalAbstractBuilding(src, dest);
		cityObjects.add(dest);

		return cityObjects;
	}

	public List<AbstractCityObjectType> marshalBuildingPart(BuildingPart src) {
		BuildingPartType dest = new BuildingPartType(src.getId());
		List<AbstractCityObjectType> cityObjects = marshalAbstractBuilding(src, dest);
		cityObjects.add(dest);

		return cityObjects;
	}

	public void marshalBuildingInstallation(BuildingInstallation src, BuildingInstallationType dest) {
		Attributes attributes = new Attributes();
		citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, attributes);

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

		if (attributes.hasAttributes())
			dest.setAttributes(attributes);

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

	public List<AbstractCityObjectType> marshalBuildingInstallation(BuildingInstallation src) {
		BuildingInstallationType dest = new BuildingInstallationType(src.getId());
		marshalBuildingInstallation(src, dest);

		return Collections.singletonList(dest);
	}

	private void preprocessGeometry(AbstractBuilding building) {
		SurfaceCollector collector = collectBoundarySurfaces(building.getBoundedBySurface());		
		if (collector.hasSurfaces()) {		
			for (int lod = 2; lod < 4; lod++) {
				Collection<AbstractSurface> surfaces = collector.getSurfaces(lod);
				if (surfaces != null) {
					MultiSurface multiSurface = null;
					switch (lod) {
					case 2:
						if (building.isSetLod2MultiSurface() && building.getLod2MultiSurface().isSetMultiSurface())
							multiSurface = building.getLod2MultiSurface().getMultiSurface();
						else {
							multiSurface = new MultiSurface();
							building.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
						}
						break;
					case 3:
						if (building.isSetLod3MultiSurface() && building.getLod3MultiSurface().isSetMultiSurface())
							multiSurface = building.getLod3MultiSurface().getMultiSurface();
						else {
							multiSurface = new MultiSurface();
							building.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
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

	private void preprocessGeometry(BuildingInstallation installation) {
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
							for (int lod = 2; lod < 4; lod++) {
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
