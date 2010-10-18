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
package org.citygml4j.util.walker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
import org.citygml4j.model.citygml.appearance.AbstractTextureParameterization;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.SurfaceDataProperty;
import org.citygml4j.model.citygml.appearance.TexCoordGen;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
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
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.AbstractSite;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.GeneralizationRelation;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.relief.AbstractReliefComponent;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.texturedsurface._AbstractAppearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
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
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.base.AssociationByRep;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.gml.coverage.AbstractCoverage;
import org.citygml4j.model.gml.coverage.AbstractDiscreteCoverage;
import org.citygml4j.model.gml.coverage.DataBlock;
import org.citygml4j.model.gml.coverage.File;
import org.citygml4j.model.gml.coverage.RangeSet;
import org.citygml4j.model.gml.coverage.RectifiedGridCoverage;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.AbstractFeatureCollection;
import org.citygml4j.model.gml.feature.FeatureArrayProperty;
import org.citygml4j.model.gml.feature.FeatureMember;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryArrayProperty;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.InlineGeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.AbstractGeometricAggregate;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurve;
import org.citygml4j.model.gml.geometry.aggregates.MultiLineString;
import org.citygml4j.model.gml.geometry.aggregates.MultiPoint;
import org.citygml4j.model.gml.geometry.aggregates.MultiPolygon;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolid;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.complexes.CompositeCurve;
import org.citygml4j.model.gml.geometry.complexes.CompositeSolid;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplex;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplexProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;
import org.citygml4j.model.gml.geometry.primitives.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.geometry.primitives.AbstractRing;
import org.citygml4j.model.gml.geometry.primitives.AbstractRingProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurfacePatch;
import org.citygml4j.model.gml.geometry.primitives.Curve;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;
import org.citygml4j.model.gml.geometry.primitives.GeometricPrimitiveProperty;
import org.citygml4j.model.gml.geometry.primitives.LineString;
import org.citygml4j.model.gml.geometry.primitives.LineStringProperty;
import org.citygml4j.model.gml.geometry.primitives.LinearRing;
import org.citygml4j.model.gml.geometry.primitives.OrientableCurve;
import org.citygml4j.model.gml.geometry.primitives.OrientableSurface;
import org.citygml4j.model.gml.geometry.primitives.Point;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.PolygonProperty;
import org.citygml4j.model.gml.geometry.primitives.Rectangle;
import org.citygml4j.model.gml.geometry.primitives.Ring;
import org.citygml4j.model.gml.geometry.primitives.Solid;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.geometry.primitives.Surface;
import org.citygml4j.model.gml.geometry.primitives.SurfacePatchArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.Tin;
import org.citygml4j.model.gml.geometry.primitives.Triangle;
import org.citygml4j.model.gml.geometry.primitives.TriangulatedSurface;
import org.citygml4j.model.gml.grids.Grid;
import org.citygml4j.model.gml.grids.RectifiedGrid;
import org.citygml4j.model.gml.valueObjects.CompositeValue;
import org.citygml4j.model.gml.valueObjects.Value;
import org.citygml4j.model.gml.valueObjects.ValueArray;
import org.citygml4j.model.gml.valueObjects.ValueArrayProperty;
import org.citygml4j.model.gml.valueObjects.ValueObject;
import org.citygml4j.model.gml.valueObjects.ValueProperty;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class GMLFunctionWalker<T> implements GMLFunctor<T>, Walker {
	private Set<Object> visited = new HashSet<Object>();
	private boolean shouldWalk = true;
	private SchemaHandler schemaHandler;

	public GMLFunctionWalker() {
	}

	public GMLFunctionWalker(SchemaHandler schemaHandler) {
		this.schemaHandler = schemaHandler;
	}

	public void reset() {
		visited.clear();
		shouldWalk = true;
	}

	public boolean shouldWalk() {
		return shouldWalk;
	}

	public void setShouldWalk(boolean shouldWalk) {
		this.shouldWalk = shouldWalk;
	}

	public void setSchemaHandler(SchemaHandler schemaHandler) {
		this.schemaHandler = schemaHandler;
	}

	public SchemaHandler getSchemaHandler() {
		return schemaHandler;
	}

	public boolean addToVisited(Object object) {
		return visited.add(object);
	}

	public boolean hasVisited(Object object) {
		return visited.contains(object);
	}

	public T apply(LodRepresentation lodRepresentation) {
		if (lodRepresentation != null) {
			for (int lod = 0; lod < 5; lod++) {
				if (lodRepresentation.isSetLodGeometry(lod)) {
					for (GeometryProperty<?> geometryProperty : lodRepresentation.getLodGeometry(lod)) {
						T object = apply(geometryProperty);
						if (object != null)
							return object;
					}
				}
			}
		}

		return null;
	}

	public T apply(AbstractGML abstractGML) {
		return null;
	}

	public T apply(AbstractCoverage abstractCoverage) {
		T object = apply((AbstractFeature)abstractCoverage);
		if (object != null)
			return object;

		if (abstractCoverage.isSetRangeSet()) {
			RangeSet rangeSet = abstractCoverage.getRangeSet();
			if (rangeSet.isSetValueArray()) {
				for (ValueArray valueArray : new ArrayList<ValueArray>(rangeSet.getValueArray())) {
					object = apply(valueArray);
					if (object != null)
						return object;
				}
			}

			else if (rangeSet.isSetDataBlock()) {
				DataBlock dataBlock = rangeSet.getDataBlock();
				if (dataBlock.isSetRangeParameters() && dataBlock.getRangeParameters().isSetValueObject()) {
					object = apply(dataBlock.getRangeParameters().getValueObject());
					if (object != null)
						return object;
				}
			}

			else if (rangeSet.isSetFile()) {
				File file = rangeSet.getFile();
				if (file.isSetRangeParameters() && file.getRangeParameters().isSetValueObject()) {
					object = apply(file.getRangeParameters().getValueObject());
					if (object != null)
						return object;
				}
			}
		}

		return null;
	}

	public T apply(AbstractDiscreteCoverage abstractDiscreteCoverage) {
		return apply((AbstractCoverage)abstractDiscreteCoverage);
	}

	public T apply(AbstractFeature abstractFeature) {
		T object = apply((AbstractGML)abstractFeature);
		if (object != null)
			return object;

		if (abstractFeature.isSetLocation()) {
			object = apply(abstractFeature.getLocation());
			if (object != null)
				return object;
		}

		if (abstractFeature.isSetGenericADEComponent()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractFeature.getGenericADEComponent())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(AbstractFeatureCollection abstractFeatureCollection) {
		T object = apply((AbstractFeature)abstractFeatureCollection);
		if (object != null)
			return object;

		if (abstractFeatureCollection.isSetFeatureMember()) {
			for (FeatureMember featureMember : new ArrayList<FeatureMember>(abstractFeatureCollection.getFeatureMember())) {
				object = apply(featureMember);
				if (object != null)
					return object;
			}
		}

		if (abstractFeatureCollection.isSetFeatureMembers())
			apply(abstractFeatureCollection.getFeatureMembers());

		return null;
	}

	public T apply(AbstractCityObject abstractCityObject) {
		T object = apply((AbstractFeature)abstractCityObject);
		if (object != null)
			return object;

		if (abstractCityObject.isSetGeneralizesTo()) {
			for (GeneralizationRelation generalizationRelation : new ArrayList<GeneralizationRelation>(abstractCityObject.getGeneralizesTo())) {
				object = apply(generalizationRelation);
				if (object != null)
					return object;
			}
		}

		if (abstractCityObject.isSetAppearance()) {
			for (AppearanceProperty appearanceProperty : new ArrayList<AppearanceProperty>(abstractCityObject.getAppearance())) {
				object = apply(appearanceProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractCityObject.isSetGenericApplicationPropertyOfCityObject()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractCityObject.getGenericApplicationPropertyOfCityObject())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractTransportationObject abstractTransportationObject) {
		T object = apply((AbstractCityObject)abstractTransportationObject);
		if (object != null)
			return object;

		if (abstractTransportationObject.isSetGenericApplicationPropertyOfTransportationObject()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTransportationObject.getGenericApplicationPropertyOfTransportationObject())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractReliefComponent abstractReliefComponent) {
		T object = apply((AbstractCityObject)abstractReliefComponent);
		if (object != null)
			return object;

		if (abstractReliefComponent.isSetExtent()) {
			object = apply(abstractReliefComponent.getExtent());
			if (object != null)
				return object;
		}

		if (abstractReliefComponent.isSetGenericApplicationPropertyOfReliefComponent()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractReliefComponent.getGenericApplicationPropertyOfReliefComponent())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractSite abstractSite) {
		T object = apply((AbstractCityObject)abstractSite);
		if (object != null)
			return object;

		if (abstractSite.isSetGenericApplicationPropertyOfSite()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractSite.getGenericApplicationPropertyOfSite())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractBuilding abstractBuilding) {
		T object = apply((AbstractSite)abstractBuilding);
		if (object != null)
			return object;

		if (abstractBuilding.isSetOuterBuildingInstallation()) {
			for (BuildingInstallationProperty buildingInstallationProperty : new ArrayList<BuildingInstallationProperty>(abstractBuilding.getOuterBuildingInstallation())) {
				object = apply(buildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetInteriorBuildingInstallation()) {
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : new ArrayList<IntBuildingInstallationProperty>(abstractBuilding.getInteriorBuildingInstallation())) {
				object = apply(intBuildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<BoundarySurfaceProperty>(abstractBuilding.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetConsistsOfBuildingPart()) {
			for (BuildingPartProperty buildingPartProperty : new ArrayList<BuildingPartProperty>(abstractBuilding.getConsistsOfBuildingPart())) {
				object = apply(buildingPartProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetInteriorRoom()) {
			for (InteriorRoomProperty interiorRoomProperty : new ArrayList<InteriorRoomProperty>(abstractBuilding.getInteriorRoom())) {
				object = apply(interiorRoomProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetAddress()) {
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(abstractBuilding.getAddress())) {
				object = apply(addressProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetLod1Solid()) {
			object = apply(abstractBuilding.getLod1Solid());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod2Solid()) {
			object = apply(abstractBuilding.getLod2Solid());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod3Solid()) {
			object = apply(abstractBuilding.getLod3Solid());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod4Solid()) {
			object = apply(abstractBuilding.getLod4Solid());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod1TerrainIntersection()) {
			object = apply(abstractBuilding.getLod1TerrainIntersection());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod2TerrainIntersection()) {
			object = apply(abstractBuilding.getLod2TerrainIntersection());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod3TerrainIntersection()) {
			object = apply(abstractBuilding.getLod3TerrainIntersection());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod4TerrainIntersection()) {
			object = apply(abstractBuilding.getLod4TerrainIntersection());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod2MultiCurve()) {
			object = apply(abstractBuilding.getLod2MultiCurve());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod3MultiCurve()) {
			object = apply(abstractBuilding.getLod3MultiCurve());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod4MultiCurve()) {
			object = apply(abstractBuilding.getLod4MultiCurve());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod1MultiSurface()) {
			object = apply(abstractBuilding.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod2MultiSurface()) {
			object = apply(abstractBuilding.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod3MultiSurface()) {
			object = apply(abstractBuilding.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod4MultiSurface()) {
			object = apply(abstractBuilding.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetGenericApplicationPropertyOfAbstractBuilding()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBuilding.getGenericApplicationPropertyOfAbstractBuilding())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractBoundarySurface abstractBoundarySurface) {
		T object = apply((AbstractCityObject)abstractBoundarySurface);
		if (object != null)
			return object;

		if (abstractBoundarySurface.isSetOpening()) {
			for (OpeningProperty openingProperty : new ArrayList<OpeningProperty>(abstractBoundarySurface.getOpening())) {
				object = apply(openingProperty);
				if (object != null)
					return object;					
			}
		}

		if (abstractBoundarySurface.isSetLod2MultiSurface()) {
			object = apply(abstractBoundarySurface.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBoundarySurface.isSetLod3MultiSurface()) {
			object = apply(abstractBoundarySurface.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBoundarySurface.isSetLod4MultiSurface()) {
			object = apply(abstractBoundarySurface.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBoundarySurface.isSetGenericApplicationPropertyOfBoundarySurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBoundarySurface.getGenericApplicationPropertyOfBoundarySurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractOpening abstractOpening) {
		T object = apply((AbstractCityObject)abstractOpening);
		if (object != null)
			return object;

		if (abstractOpening.isSetLod3MultiSurface()) {
			object = apply(abstractOpening.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractOpening.isSetLod4MultiSurface()) {
			object = apply(abstractOpening.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractOpening.isSetGenericApplicationPropertyOfOpening()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractOpening.getGenericApplicationPropertyOfOpening())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractSurfaceData abstractSurfaceData) {
		T object = apply((AbstractFeature)abstractSurfaceData);
		if (object != null)
			return object;

		if (abstractSurfaceData.isSetGenericApplicationPropertyOfSurfaceData()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractSurfaceData.getGenericApplicationPropertyOfSurfaceData())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractTexture abstractTexture) {
		T object = apply((AbstractSurfaceData)abstractTexture);
		if (object != null)
			return object;

		if (abstractTexture.isSetGenericApplicationPropertyOfTexture()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTexture.getGenericApplicationPropertyOfTexture())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractTextureParameterization abstractTextureParameterization) {
		T object = apply((AbstractGML)abstractTextureParameterization);
		if (object != null)
			return object;

		if (abstractTextureParameterization.isSetGenericADEComponent()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTextureParameterization.getGenericADEComponent())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		if (abstractTextureParameterization.isSetGenericApplicationPropertyOfTextureParameterization()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTextureParameterization.getGenericApplicationPropertyOfTextureParameterization())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractVegetationObject abstractVegetationObject) {
		T object = apply((AbstractCityObject)abstractVegetationObject);
		if (object != null)
			return object;

		if (abstractVegetationObject.isSetGenericApplicationPropertyOfVegetationObject()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractVegetationObject.getGenericApplicationPropertyOfVegetationObject())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractWaterObject abstractWaterObject) {
		T object = apply((AbstractCityObject)abstractWaterObject);
		if (object != null)
			return object;

		if (abstractWaterObject.isSetGenericApplicationPropertyOfWaterObject()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractWaterObject.getGenericApplicationPropertyOfWaterObject())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractWaterBoundarySurface abstractWaterBoundarySurface) {
		T object = apply((AbstractCityObject)abstractWaterBoundarySurface);
		if (object != null)
			return object;

		if (abstractWaterBoundarySurface.isSetLod2Surface()) {
			object = apply(abstractWaterBoundarySurface.getLod2Surface());
			if (object != null)
				return object;
		}

		if (abstractWaterBoundarySurface.isSetLod3Surface()) {
			object = apply(abstractWaterBoundarySurface.getLod3Surface());
			if (object != null)
				return object;
		}

		if (abstractWaterBoundarySurface.isSetLod3Surface()) {
			object = apply(abstractWaterBoundarySurface.getLod3Surface());
			if (object != null)
				return object;
		}

		if (abstractWaterBoundarySurface.isSetGenericApplicationPropertyOfWaterBoundarySurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractWaterBoundarySurface.getGenericApplicationPropertyOfWaterBoundarySurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(_AbstractAppearance abstractAppearance) {
		return apply((AbstractGML)abstractAppearance);
	}

	public T apply(CompositeValue compositeValue) {
		T object = apply((AbstractGML)compositeValue);
		if (object != null)
			return object;

		if (compositeValue.isSetValueComponent()) {
			for (ValueProperty valueProperty : new ArrayList<ValueProperty>(compositeValue.getValueComponent())) {
				if (valueProperty.isSetValue()) {
					object = apply(valueProperty.getValue());
					if (object != null)
						return object;
				}
			}
		}

		if (compositeValue.isSetValueComponents()) {
			ValueArrayProperty valueArrayProperty = compositeValue.getValueComponents();
			if (valueArrayProperty.isSetValue()) {
				for (Value value : new ArrayList<Value>(valueArrayProperty.getValue())) {
					object = apply(value);
					if (object != null)
						return object;
				}
			}
		}

		return null;
	}

	public T apply(ValueArray valueArray) {
		return apply((CompositeValue)valueArray);
	}

	public T apply(RectifiedGridCoverage rectifiedGridCoverage) {
		T object = apply((AbstractDiscreteCoverage)rectifiedGridCoverage);
		if (object != null)
			return object;

		if (rectifiedGridCoverage.isSetRectifiedGridDomain()) {
			object = apply(rectifiedGridCoverage.getRectifiedGridDomain());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(Address address) {
		T object = apply((AbstractFeature)address);
		if (object != null)
			return object;

		if (address.isSetMultiPoint()) {
			object = apply(address.getMultiPoint());
			if (object != null)
				return object;
		}			

		if (address.isSetGenericApplicationPropertyOfAddress()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(address.getGenericApplicationPropertyOfAddress())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Appearance appearance) {
		T object = apply((AbstractFeature)appearance);
		if (object != null)
			return object;

		if (appearance.isSetSurfaceDataMember())
			for (SurfaceDataProperty surfaceDataProperty : new ArrayList<SurfaceDataProperty>(appearance.getSurfaceDataMember())) {
				object = apply(surfaceDataProperty);
				if (object != null)
					return object;
			}

		if (appearance.isSetGenericApplicationPropertyOfAppearance()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(appearance.getGenericApplicationPropertyOfAppearance())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(AuxiliaryTrafficArea auxiliaryTrafficArea) {
		T object = apply((AbstractTransportationObject)auxiliaryTrafficArea);
		if (object != null)
			return object;

		if (auxiliaryTrafficArea.isSetLod2MultiSurface()) {
			object = apply(auxiliaryTrafficArea.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (auxiliaryTrafficArea.isSetLod3MultiSurface()) {
			object = apply(auxiliaryTrafficArea.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (auxiliaryTrafficArea.isSetLod4MultiSurface()) {
			object = apply(auxiliaryTrafficArea.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (auxiliaryTrafficArea.isSetGenericApplicationPropertyOfAuxiliaryTrafficArea()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(auxiliaryTrafficArea.getGenericApplicationPropertyOfAuxiliaryTrafficArea())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(BreaklineRelief breaklineRelief) {
		T object = apply((AbstractReliefComponent)breaklineRelief);
		if (object != null)
			return object;

		if (breaklineRelief.isSetBreaklines()) {
			object = apply(breaklineRelief.getBreaklines());
			if (object != null)
				return object;
		}

		if (breaklineRelief.isSetRidgeOrValleyLines()) {
			object = apply(breaklineRelief.getRidgeOrValleyLines());
			if (object != null)
				return object;
		}

		if (breaklineRelief.isSetGenericApplicationPropertyOfBreaklineRelief()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(breaklineRelief.getGenericApplicationPropertyOfBreaklineRelief())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Building building) {
		T object = apply((AbstractBuilding)building);
		if (object != null)
			return object;

		if (building.isSetGenericApplicationPropertyOfBuilding()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(building.getGenericApplicationPropertyOfBuilding())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(BuildingFurniture buildingFurniture) {
		T object = apply((AbstractCityObject)buildingFurniture);
		if (object != null)
			return object;

		if (buildingFurniture.isSetLod4Geometry()) {
			object = apply(buildingFurniture.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (buildingFurniture.isSetLod4ImplicitRepresentation()) {
			object = apply(buildingFurniture.getLod4ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (buildingFurniture.isSetGenericApplicationPropertyOfBuildingFurniture()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingFurniture.getGenericApplicationPropertyOfBuildingFurniture())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(BuildingInstallation buildingInstallation) {
		T object = apply((AbstractCityObject)buildingInstallation);
		if (object != null)
			return object;

		if (buildingInstallation.isSetLod2Geometry()) {
			object = apply(buildingInstallation.getLod2Geometry());
			if (object != null)
				return object;
		}

		if (buildingInstallation.isSetLod3Geometry()) {
			object = apply(buildingInstallation.getLod3Geometry());
			if (object != null)
				return object;
		}

		if (buildingInstallation.isSetLod4Geometry()) {
			object = apply(buildingInstallation.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (buildingInstallation.isSetGenericApplicationPropertyOfBuildingInstallation()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingInstallation.getGenericApplicationPropertyOfBuildingInstallation())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(BuildingPart buildingPart) {
		T object = apply((AbstractBuilding)buildingPart);
		if (object != null)
			return object;

		if (buildingPart.isSetGenericApplicationPropertyOfBuildingPart()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingPart.getGenericApplicationPropertyOfBuildingPart())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(CeilingSurface ceilingSurface) {
		T object = apply((AbstractBoundarySurface)ceilingSurface);
		if (object != null)
			return object;

		if (ceilingSurface.isSetGenericApplicationPropertyOfCeilingSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(ceilingSurface.getGenericApplicationPropertyOfCeilingSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(CityFurniture cityFurniture) {
		T object = apply((AbstractCityObject)cityFurniture);
		if (object != null)
			return object;

		if (cityFurniture.isSetLod1Geometry()) {
			object = apply(cityFurniture.getLod1Geometry());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod2Geometry()) {
			object = apply(cityFurniture.getLod2Geometry());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod3Geometry()) {
			object = apply(cityFurniture.getLod3Geometry());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod4Geometry()) {
			object = apply(cityFurniture.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod1TerrainIntersection()) {
			object = apply(cityFurniture.getLod1TerrainIntersection());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod2TerrainIntersection()) {
			object = apply(cityFurniture.getLod2TerrainIntersection());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod3TerrainIntersection()) {
			object = apply(cityFurniture.getLod3TerrainIntersection());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod4TerrainIntersection()) {
			object = apply(cityFurniture.getLod4TerrainIntersection());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod1ImplicitRepresentation()) {
			object = apply(cityFurniture.getLod1ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod2ImplicitRepresentation()) {
			object = apply(cityFurniture.getLod2ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod3ImplicitRepresentation()) {
			object = apply(cityFurniture.getLod3ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod4ImplicitRepresentation()) {
			object = apply(cityFurniture.getLod4ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetGenericApplicationPropertyOfCityFurniture()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityFurniture.getGenericApplicationPropertyOfCityFurniture())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(CityModel cityModel) {
		T object = apply((AbstractFeatureCollection)cityModel);
		if (object != null)
			return object;

		if (cityModel.isSetCityObjectMember()) {
			for (CityObjectMember cityObjectMember : new ArrayList<CityObjectMember>(cityModel.getCityObjectMember())) {
				object = apply(cityObjectMember);
				if (object != null)
					return object;
			}
		}

		if (cityModel.isSetAppearanceMember()) {
			for (AppearanceMember appearanceMember : new ArrayList<AppearanceMember>(cityModel.getAppearanceMember())) {
				object = apply(appearanceMember);
				if (object != null)
					return object;
			}
		}

		if (cityModel.isSetGenericApplicationPropertyOfCityModel()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityModel.getGenericApplicationPropertyOfCityModel())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(CityObjectGroup cityObjectGroup) {
		T object = apply((AbstractCityObject)cityObjectGroup);
		if (object != null)
			return object;

		if (cityObjectGroup.isSetGroupMember()) {
			for (CityObjectGroupMember cityObjectGroupMember : new ArrayList<CityObjectGroupMember>(cityObjectGroup.getGroupMember())) {
				object = apply(cityObjectGroupMember);
				if (object != null)
					return object;
			}
		}

		if (cityObjectGroup.isSetGroupParent()) {
			object = apply(cityObjectGroup.getGroupParent());
			if (object != null)
				return object;
		}

		if (cityObjectGroup.isSetGeometry()) {
			object = apply(cityObjectGroup.getGeometry());
			if (object != null)
				return object;
		}

		if (cityObjectGroup.isSetGenericApplicationPropertyOfCityObjectGroup()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityObjectGroup.getGenericApplicationPropertyOfCityObjectGroup())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(ClosureSurface closureSurface) {
		T object = apply((AbstractBoundarySurface)closureSurface);
		if (object != null)
			return object;

		if (closureSurface.isSetGenericApplicationPropertyOfClosureSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(closureSurface.getGenericApplicationPropertyOfClosureSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Door door) {
		T object = apply((AbstractOpening)door);
		if (object != null)
			return object;

		if (door.isSetAddress()) {
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(door.getAddress())) {
				object = apply(addressProperty);
				if (object != null)
					return object;
			}
		}

		if (door.isSetGenericApplicationPropertyOfDoor()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(door.getGenericApplicationPropertyOfDoor())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(FloorSurface floorSurface) {
		T object = apply((AbstractBoundarySurface)floorSurface);
		if (object != null)
			return object;

		if (floorSurface.isSetGenericApplicationPropertyOfFloorSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(floorSurface.getGenericApplicationPropertyOfFloorSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(GenericCityObject genericCityObject) {
		T object = apply((AbstractCityObject)genericCityObject);
		if (object != null)
			return object;

		if (genericCityObject.isSetLod0Geometry()) {
			object = apply(genericCityObject.getLod0Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod1Geometry()) {
			object = apply(genericCityObject.getLod1Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod2Geometry()) {
			object = apply(genericCityObject.getLod2Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod3Geometry()) {
			object = apply(genericCityObject.getLod3Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod4Geometry()) {
			object = apply(genericCityObject.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod0TerrainIntersection()) {
			object = apply(genericCityObject.getLod0TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod1TerrainIntersection()) {
			object = apply(genericCityObject.getLod1TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod2TerrainIntersection()) {
			object = apply(genericCityObject.getLod2TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod3TerrainIntersection()) {
			object = apply(genericCityObject.getLod3TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod4TerrainIntersection()) {
			object = apply(genericCityObject.getLod4TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod0ImplicitRepresentation()) {
			object = apply(genericCityObject.getLod0ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod1ImplicitRepresentation()) {
			object = apply(genericCityObject.getLod1ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod2ImplicitRepresentation()) {
			object = apply(genericCityObject.getLod2ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod3ImplicitRepresentation()) {
			object = apply(genericCityObject.getLod3ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod4ImplicitRepresentation()) {
			object = apply(genericCityObject.getLod4ImplicitRepresentation());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(GeoreferencedTexture georeferencedTexture) {
		T object = apply((AbstractTexture)georeferencedTexture);
		if (object != null)
			return object;

		if (georeferencedTexture.isSetReferencePoint()) {
			object = apply(georeferencedTexture.getReferencePoint());
			if (object != null)
				return object;
		}

		if (georeferencedTexture.isSetGenericApplicationPropertyOfGeoreferencedTexture()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(georeferencedTexture.getGenericApplicationPropertyOfGeoreferencedTexture())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(GroundSurface groundSurface) {
		T object = apply((AbstractBoundarySurface)groundSurface);
		if (object != null)
			return object;

		if (groundSurface.isSetGenericApplicationPropertyOfGroundSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(groundSurface.getGenericApplicationPropertyOfGroundSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(IntBuildingInstallation intBuildingInstallation) {
		T object = apply((AbstractCityObject)intBuildingInstallation);
		if (object != null)
			return object;

		if (intBuildingInstallation.isSetLod4Geometry()) {
			object = apply(intBuildingInstallation.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (intBuildingInstallation.isSetGenericApplicationPropertyOfIntBuildingInstallation()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(intBuildingInstallation.getGenericApplicationPropertyOfIntBuildingInstallation())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(InteriorWallSurface interiorWallSurface) {
		T object = apply((AbstractBoundarySurface)interiorWallSurface);
		if (object != null)
			return object;

		if (interiorWallSurface.isSetGenericApplicationPropertyOfInteriorWallSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(LandUse landUse) {
		T object = apply((AbstractCityObject)landUse);
		if (object != null)
			return object;

		if (landUse.isSetLod0MultiSurface()) {
			object = apply(landUse.getLod0MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetLod1MultiSurface()) {
			object = apply(landUse.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetLod2MultiSurface()) {
			object = apply(landUse.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetLod3MultiSurface()) {
			object = apply(landUse.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetLod4MultiSurface()) {
			object = apply(landUse.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetGenericApplicationPropertyOfLandUse()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(landUse.getGenericApplicationPropertyOfLandUse())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(MassPointRelief massPointRelief) {
		T object = apply((AbstractReliefComponent)massPointRelief);
		if (object != null)
			return object;

		if (massPointRelief.isSetReliefPoints()) {
			object = apply(massPointRelief.getReliefPoints());
			if (object != null)
				return object;
		}

		if (massPointRelief.isSetGenericApplicationPropertyOfMassPointRelief()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(massPointRelief.getGenericApplicationPropertyOfMassPointRelief())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(ParameterizedTexture parameterizedTexture) {
		T object = apply((AbstractTexture)parameterizedTexture);
		if (object != null)
			return object;

		if (parameterizedTexture.isSetTarget()) {
			for (TextureAssociation textureAssociation : new ArrayList<TextureAssociation>(parameterizedTexture.getTarget())) {
				object = apply(textureAssociation);
				if (object != null)
					return object;
			}
		}

		if (parameterizedTexture.isSetGenericApplicationPropertyOfParameterizedTexture()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(parameterizedTexture.getGenericApplicationPropertyOfParameterizedTexture())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(PlantCover plantCover) {
		T object = apply((AbstractVegetationObject)plantCover);
		if (object != null)
			return object;

		if (plantCover.isSetLod1MultiSurface()) {
			object = apply(plantCover.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod2MultiSurface()) {
			object = apply(plantCover.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod3MultiSurface()) {
			object = apply(plantCover.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod4MultiSurface()) {
			object = apply(plantCover.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod1MultiSolid()) {
			object = apply(plantCover.getLod1MultiSolid());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod2MultiSolid()) {
			object = apply(plantCover.getLod2MultiSolid());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod3MultiSolid()) {
			object = apply(plantCover.getLod3MultiSolid());
			if (object != null)
				return object;
		}

		if (plantCover.isSetGenericApplicationPropertyOfPlantCover()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(plantCover.getGenericApplicationPropertyOfPlantCover())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Railway railway) {
		T object = apply((TransportationComplex)railway);
		if (object != null)
			return object;

		if (railway.isSetGenericApplicationPropertyOfRailway()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(railway.getGenericApplicationPropertyOfRailway())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(RasterRelief rasterRelief) {
		T object = apply((AbstractReliefComponent)rasterRelief);
		if (object != null)
			return object;

		if (rasterRelief.isSetGrid()) {
			object = apply(rasterRelief.getGrid());
			if (object != null)
				return object;
		}

		if (rasterRelief.isSetGenericApplicationPropertyOfRasterRelief()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(rasterRelief.getGenericApplicationPropertyOfRasterRelief())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(ReliefFeature reliefFeature) {
		T object = apply((AbstractCityObject)reliefFeature);
		if (object != null)
			return object;

		if (reliefFeature.isSetReliefComponent()) {
			for (ReliefComponentProperty reliefComponentProperty : new ArrayList<ReliefComponentProperty>(reliefFeature.getReliefComponent())) {
				object = apply(reliefComponentProperty);
				if (object != null)
					return object;
			}
		}

		if (reliefFeature.isSetGenericApplicationPropertyOfReliefFeature()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(reliefFeature.getGenericApplicationPropertyOfReliefFeature())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Road road) {
		T object = apply((TransportationComplex)road);
		if (object != null)
			return object;

		if (road.isSetGenericApplicationPropertyOfRoad()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(road.getGenericApplicationPropertyOfRoad())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(RoofSurface roofSurface) {
		T object = apply((AbstractBoundarySurface)roofSurface);
		if (object != null)
			return object;

		if (roofSurface.isSetGenericApplicationPropertyOfRoofSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(roofSurface.getGenericApplicationPropertyOfRoofSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Room room) {
		T object = apply((AbstractCityObject)room);
		if (object != null)
			return object;

		if (room.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<BoundarySurfaceProperty>(room.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetInteriorFurniture()) {
			for (InteriorFurnitureProperty interiorFurnitureProperty : new ArrayList<InteriorFurnitureProperty>(room.getInteriorFurniture())) {
				object = apply(interiorFurnitureProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetRoomInstallation()) {
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : new ArrayList<IntBuildingInstallationProperty>(room.getRoomInstallation())) {
				object = apply(intBuildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetLod4MultiSurface()) {
			object = apply(room.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (room.isSetLod4Solid()) {
			object = apply(room.getLod4Solid());
			if (object != null)
				return object;
		}

		if (room.isSetGenericApplicationPropertyOfRoom()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(room.getGenericApplicationPropertyOfRoom())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(SolitaryVegetationObject solitaryVegetationObject) {
		T object = apply((AbstractVegetationObject)solitaryVegetationObject);
		if (object != null)
			return object;

		if (solitaryVegetationObject.isSetLod2Geometry()) {
			object = apply(solitaryVegetationObject.getLod2Geometry());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod3Geometry()) {
			object = apply(solitaryVegetationObject.getLod3Geometry());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod4Geometry()) {
			object = apply(solitaryVegetationObject.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod1ImplicitRepresentation()) {
			object = apply(solitaryVegetationObject.getLod1ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod2ImplicitRepresentation()) {
			object = apply(solitaryVegetationObject.getLod2ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod3ImplicitRepresentation()) {
			object = apply(solitaryVegetationObject.getLod3ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod4ImplicitRepresentation()) {
			object = apply(solitaryVegetationObject.getLod4ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetGenericApplicationPropertyOfSolitaryVegetationObject()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(solitaryVegetationObject.getGenericApplicationPropertyOfSolitaryVegetationObject())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Square square) {
		T object = apply((TransportationComplex)square);
		if (object != null)
			return object;

		if (square.isSetGenericApplicationPropertyOfSquare()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(square.getGenericApplicationPropertyOfSquare())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(TINRelief tinRelief) {
		T object = apply((AbstractReliefComponent)tinRelief);
		if (object != null)
			return object;

		if (tinRelief.isSetTin()) {
			object = apply(tinRelief.getTin());
			if (object != null)
				return object;
		}

		if (tinRelief.isSetGenericApplicationPropertyOfTinRelief()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(tinRelief.getGenericApplicationPropertyOfTinRelief())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Track track) {
		T object = apply((TransportationComplex)track);
		if (object != null)
			return object;

		if (track.isSetGenericApplicationPropertyOfTrack()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(track.getGenericApplicationPropertyOfTrack())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(TrafficArea trafficArea) {
		T object = apply((AbstractTransportationObject)trafficArea);
		if (object != null)
			return object;

		if (trafficArea.isSetLod2MultiSurface()) {
			object = apply(trafficArea.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (trafficArea.isSetLod3MultiSurface()) {
			object = apply(trafficArea.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (trafficArea.isSetLod4MultiSurface()) {
			object = apply(trafficArea.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (trafficArea.isSetGenericApplicationPropertyOfTrafficArea()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(trafficArea.getGenericApplicationPropertyOfTrafficArea())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(TransportationComplex transportationComplex) {
		T object = apply((AbstractTransportationObject)transportationComplex);
		if (object != null)
			return object;

		if (transportationComplex.isSetTrafficArea()) {
			for (TrafficAreaProperty trafficAreaProperty : new ArrayList<TrafficAreaProperty>(transportationComplex.getTrafficArea())) {
				object = apply(trafficAreaProperty);
				if (object != null)
					return object;
			}
		}

		if (transportationComplex.isSetAuxiliaryTrafficArea()) {
			for (AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty : new ArrayList<AuxiliaryTrafficAreaProperty>(transportationComplex.getAuxiliaryTrafficArea())) {
				object = apply(auxiliaryTrafficAreaProperty);
				if (object != null)
					return object;
			}
		}

		if (transportationComplex.isSetLod0Network()) {
			for (GeometricComplexProperty geometricComplexProperty : new ArrayList<GeometricComplexProperty>(transportationComplex.getLod0Network())) {
				object = apply(geometricComplexProperty);
				if (object != null)
					return object;
			}
		}

		if (transportationComplex.isSetLod1MultiSurface()) {
			object = apply(transportationComplex.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (transportationComplex.isSetLod2MultiSurface()) {
			object = apply(transportationComplex.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (transportationComplex.isSetLod3MultiSurface()) {
			object = apply(transportationComplex.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (transportationComplex.isSetLod4MultiSurface()) {
			object = apply(transportationComplex.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (transportationComplex.isSetGenericApplicationPropertyOfTransportationComplex()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(transportationComplex.getGenericApplicationPropertyOfTransportationComplex())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(WallSurface wallSurface) {
		T object = apply((AbstractBoundarySurface)wallSurface);
		if (object != null)
			return object;

		if (wallSurface.isSetGenericApplicationPropertyOfWallSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(wallSurface.getGenericApplicationPropertyOfWallSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(WaterBody waterBody) {
		T object = apply((AbstractWaterObject)waterBody);
		if (object != null)
			return object;

		if (waterBody.isSetBoundedBySurface()) {
			for (BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty : new ArrayList<BoundedByWaterSurfaceProperty>(waterBody.getBoundedBySurface())) {
				object = apply(boundedByWaterSurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (waterBody.isSetLod0MultiCurve()) {
			object = apply(waterBody.getLod0MultiCurve());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod1MultiCurve()) {
			object = apply(waterBody.getLod1MultiCurve());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod0MultiSurface()) {
			object = apply(waterBody.getLod0MultiSurface());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod1MultiSurface()) {
			object = apply(waterBody.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod1Solid()) {
			object = apply(waterBody.getLod1Solid());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod2Solid()) {
			object = apply(waterBody.getLod2Solid());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod3Solid()) {
			object = apply(waterBody.getLod3Solid());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod4Solid()) {
			object = apply(waterBody.getLod4Solid());
			if (object != null)
				return object;
		}		

		if (waterBody.isSetGenericApplicationPropertyOfWaterBody()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterBody.getGenericApplicationPropertyOfWaterBody())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(WaterClosureSurface waterClosureSurface) {
		T object = apply((AbstractWaterBoundarySurface)waterClosureSurface);
		if (object != null)
			return object;

		if (waterClosureSurface.isSetGenericApplicationPropertyOfWaterClosureSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterClosureSurface.getGenericApplicationPropertyOfWaterClosureSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(WaterGroundSurface waterGroundSurface) {
		T object = apply((AbstractWaterBoundarySurface)waterGroundSurface);
		if (object != null)
			return object;

		if (waterGroundSurface.isSetGenericApplicationPropertyOfWaterGroundSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterGroundSurface.getGenericApplicationPropertyOfWaterGroundSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(WaterSurface waterSurface) {
		T object = apply((AbstractWaterBoundarySurface)waterSurface);
		if (object != null)
			return object;

		if (waterSurface.isSetGenericApplicationPropertyOfWaterSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterSurface.getGenericApplicationPropertyOfWaterSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Window window) {
		T object = apply((AbstractOpening)window);
		if (object != null)
			return object;

		if (window.isSetGenericApplicationPropertyOfWindow()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(window.getGenericApplicationPropertyOfWindow())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(X3DMaterial x3dMaterial) {
		T object = apply((AbstractSurfaceData)x3dMaterial);
		if (object != null)
			return object;

		if (x3dMaterial.isSetGenericApplicationPropertyOfX3DMaterial()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(x3dMaterial.getGenericApplicationPropertyOfX3DMaterial())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(_Material material) {
		return apply((_AbstractAppearance)material);
	}

	public T apply(_SimpleTexture simpleTexture) {
		return apply((_AbstractAppearance)simpleTexture);
	}

	public T apply(ImplicitGeometry implicitGeometry) {
		T object = apply((AbstractGML)implicitGeometry);
		if (object != null)
			return object;

		if (implicitGeometry.isSetRelativeGMLGeometry()) {
			object = apply(implicitGeometry.getRelativeGMLGeometry());
			if (object != null)
				return object;
		}

		if (implicitGeometry.isSetReferencePoint()) {
			object = apply(implicitGeometry.getReferencePoint());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(TexCoordGen texCoordGen) {
		T object = apply((AbstractTextureParameterization)texCoordGen);
		if (object != null)
			return object;

		if (texCoordGen.isSetGenericApplicationPropertyOfTexCoordGen()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordGen.getGenericApplicationPropertyOfTexCoordGen())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(TexCoordList texCoordList) {
		T object = apply((AbstractTextureParameterization)texCoordList);
		if (object != null)
			return object;

		if (texCoordList.isSetGenericApplicationPropertyOfTexCoordList()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordList.getGenericApplicationPropertyOfTexCoordList())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(AbstractGeometry abstractGeometry) {
		return apply((AbstractGML)abstractGeometry);
	}

	public T apply(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		return apply((AbstractGeometry)abstractGeometricPrimitive);
	}

	public T apply(AbstractGeometricAggregate abstractGeometricAggregate) {
		return apply((AbstractGeometry)abstractGeometricAggregate);
	}

	public T apply(AbstractCurve abstractCurve) {
		return apply((AbstractGeometricPrimitive)abstractCurve);
	}

	public T apply(AbstractSolid abstractSolid) {
		return apply((AbstractGeometricPrimitive)abstractSolid);
	}

	public T apply(AbstractSurface abstractSurface) {
		return apply((AbstractGeometricPrimitive)abstractSurface);
	}

	public T apply(AbstractRing abstractRing) {
		return apply((AbstractGeometry)abstractRing);
	}

	public T apply(Triangle triangle) {
		if (triangle.isSetExterior()) {
			T object = apply(triangle.getExterior());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(Rectangle rectangle) {
		if (rectangle.isSetExterior()) {
			T object = apply(rectangle.getExterior());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(CompositeCurve compositeCurve) {
		T object = apply((AbstractCurve)compositeCurve);
		if (object != null)
			return object;

		if (compositeCurve.isSetCurveMember()) {
			for (CurveProperty curveProperty : new ArrayList<CurveProperty>(compositeCurve.getCurveMember())) {
				object = apply(curveProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(CompositeSolid compositeSolid) {
		T object = apply((AbstractSolid)compositeSolid);
		if (object != null)
			return object;

		if (compositeSolid.isSetSolidMember()) {
			for (SolidProperty solidProperty : new ArrayList<SolidProperty>(compositeSolid.getSolidMember())) {
				object = apply(solidProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(CompositeSurface compositeSurface) {
		T object = apply((AbstractSurface)compositeSurface);
		if (object != null)
			return object;

		if (compositeSurface.isSetSurfaceMember()) {
			for (SurfaceProperty surfaceProperty : new ArrayList<SurfaceProperty>(compositeSurface.getSurfaceMember())) {
				object = apply(surfaceProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Curve curve) {
		return apply((AbstractCurve)curve);
	}

	public T apply(GeometricComplex geometricComplex) {
		T object = apply((AbstractGeometry)geometricComplex);
		if (object != null)
			return object;

		if (geometricComplex.isSetElement()) {
			for (GeometricPrimitiveProperty geometricPrimitiveProperty : new ArrayList<GeometricPrimitiveProperty>(geometricComplex.getElement())) {
				object = apply(geometricPrimitiveProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Grid grid) {
		return apply((AbstractGeometry)grid);
	}

	public T apply(LinearRing linearRing) {
		return apply((AbstractRing)linearRing);
	}

	public T apply(LineString lineString) {
		return apply((AbstractCurve)lineString);
	}

	public T apply(MultiCurve multiCurve) {
		T object = apply((AbstractGeometricAggregate)multiCurve);
		if (object != null)
			return object;

		if (multiCurve.isSetCurveMember()) {
			for (CurveProperty curveProperty : new ArrayList<CurveProperty>(multiCurve.getCurveMember())) {
				object = apply(curveProperty);
				if (object != null)
					return object;
			}
		}

		if (multiCurve.isSetCurveMembers()) {
			object = apply(multiCurve.getCurveMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(MultiLineString multiLineString) {
		T object = apply((AbstractGeometricAggregate)multiLineString);
		if (object != null)
			return object;

		if (multiLineString.isSetLineStringMember()) {
			for (LineStringProperty lineStringProperty : new ArrayList<LineStringProperty>(multiLineString.getLineStringMember())) {
				object = apply(lineStringProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(MultiPoint multiPoint) {
		T object = apply((AbstractGeometricAggregate)multiPoint);
		if (object != null)
			return object;

		if (multiPoint.isSetPointMember()) {
			for (PointProperty pointProperty : new ArrayList<PointProperty>(multiPoint.getPointMember())) {
				object = apply(pointProperty);
				if (object != null)
					return object;
			}
		}

		if (multiPoint.isSetPointMembers()) {
			object = apply(multiPoint.getPointMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(MultiPolygon multiPolygon) {
		T object = apply((AbstractGeometricAggregate)multiPolygon);
		if (object != null)
			return object;

		if (multiPolygon.isSetPolygonMember()) {
			for (PolygonProperty polygonProperty : new ArrayList<PolygonProperty>(multiPolygon.getPolygonMember())) {
				object = apply(polygonProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(MultiSolid multiSolid) {
		T object = apply((AbstractGeometricAggregate)multiSolid);
		if (object != null)
			return object;

		if (multiSolid.isSetSolidMember()) {
			for (SolidProperty solidProperty : new ArrayList<SolidProperty>(multiSolid.getSolidMember())) {
				object = apply(solidProperty);
				if (object != null)
					return object;
			}
		}

		if (multiSolid.isSetSolidMembers()) {
			object = apply(multiSolid.getSolidMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(MultiSurface multiSurface) {
		T object = apply((AbstractGeometricAggregate)multiSurface);
		if (object != null)
			return object;

		if (multiSurface.isSetSurfaceMember()) {
			for (SurfaceProperty surfaceProperty : new ArrayList<SurfaceProperty>(multiSurface.getSurfaceMember())) {
				object = apply(surfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (multiSurface.isSetSurfaceMembers()) {
			object = apply(multiSurface.getSurfaceMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(OrientableCurve orientableCurve) {
		T object = apply((AbstractCurve)orientableCurve);
		if (object != null)
			return object;

		if (orientableCurve.isSetBaseCurve()) {
			object = apply(orientableCurve.getBaseCurve());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(OrientableSurface orientableSurface) {
		T object = apply((AbstractSurface)orientableSurface);
		if (object != null)
			return object;

		if (orientableSurface.isSetBaseSurface()) {
			object = apply(orientableSurface.getBaseSurface());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(_TexturedSurface texturedSurface) {
		T object = apply((OrientableSurface)texturedSurface);
		if (object != null)
			return object;

		if (texturedSurface.isSetAppearance()) {
			for (_AppearanceProperty appearanceProperty : new ArrayList<_AppearanceProperty>(texturedSurface.getAppearance())) {
				object = apply(appearanceProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Point point) {
		return apply((AbstractGeometricPrimitive)point);
	}

	public T apply(Polygon polygon) {
		T object = apply((AbstractSurface)polygon);
		if (object != null)
			return object;

		if (polygon.isSetExterior()) {
			object = apply(polygon.getExterior());
			if (object != null)
				return object;
		}

		if (polygon.isSetInterior()) {
			for (AbstractRingProperty abstractRingProperty : new ArrayList<AbstractRingProperty>(polygon.getInterior())) {
				object = apply(abstractRingProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(RectifiedGrid rectifiedGrid) {
		T object = apply((Grid)rectifiedGrid);
		if (object != null)
			return object;

		if (rectifiedGrid.isSetOrigin()) {
			object = apply(rectifiedGrid.getOrigin());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(Ring ring) {
		T object = apply((AbstractRing)ring);
		if (object != null)
			return object;

		if (ring.isSetCurveMember()) {
			for (CurveProperty curveProperty : new ArrayList<CurveProperty>(ring.getCurveMember())) {
				object = apply(curveProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Solid solid) {
		T object = apply((AbstractSolid)solid);
		if (object != null)
			return object;

		if (solid.isSetExterior()) {
			object = apply(solid.getExterior());
			if (object != null)
				return object;
		}

		if (solid.isSetInterior()) {
			for (SurfaceProperty surfaceProperty : new ArrayList<SurfaceProperty>(solid.getInterior())) {
				object = apply(surfaceProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Surface surface) {
		T object = apply((AbstractSurface)surface);
		if (object != null)
			return object;

		if (surface.isSetPatches()) {
			object = apply(surface.getPatches());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(Tin tin) {
		return apply((TriangulatedSurface)tin);
	}

	public T apply(TriangulatedSurface triangulatedSurface) {
		return apply((Surface)triangulatedSurface);
	}

	public <E extends AbstractGML> T apply(AssociationByRep<E> association) {
		if (association.isSetObject() && shouldWalk && visited.add(association.getObject())) {
			T object = association.getObject().accept(this);
			if (object != null)
				return object;
		}

		return null;
	}

	public <E extends AbstractGML> T apply(AssociationByRepOrRef<E> association) {
		return apply((AssociationByRep<E>)association);
	}

	public <E extends AbstractFeature> T apply(FeatureProperty<E> featureProperty) {
		T object = apply((AssociationByRepOrRef<E>)featureProperty);
		if (object != null)
			return object;

		if (featureProperty.isSetGenericADEComponent()) {
			object = apply(featureProperty.getGenericADEComponent());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(FeatureArrayProperty featureArrayProperty) {
		if (featureArrayProperty.isSetFeature()) {
			for (AbstractFeature feature : new ArrayList<AbstractFeature>(featureArrayProperty.getFeature())) {
				if (shouldWalk && visited.add(feature)) {
					T object = feature.accept(this);
					if (object != null)
						return object;
				}					
			}
		}

		if (featureArrayProperty.isSetGenericADEComponent()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(featureArrayProperty.getGenericADEComponent())) {
				T object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public <E extends AbstractGeometry> T apply(GeometryProperty<E> geometryProperty) {
		return apply((AssociationByRepOrRef<E>)geometryProperty);
	}

	public <E extends AbstractGeometry> T apply(InlineGeometryProperty<E> geometryProperty) {
		return apply((AssociationByRep<E>)geometryProperty);
	}

	public <E extends AbstractGeometry> T apply(GeometryArrayProperty<E> geometryArrayProperty) {
		if (geometryArrayProperty.isSetGeometry()) {
			for (AbstractGeometry abstractGeometry : new ArrayList<AbstractGeometry>(geometryArrayProperty.getGeometry())) {
				if (shouldWalk && visited.add(abstractGeometry)) {
					T object = abstractGeometry.accept(this);
					if (object != null)
						return object;
				}
			}
		}

		return null;
	}

	public T apply(SurfacePatchArrayProperty surfacePatchArrayProperty) {
		T object = null;

		if (surfacePatchArrayProperty.isSetSurfacePatch()) {
			for (AbstractSurfacePatch abstractSurfacePatch : new ArrayList<AbstractSurfacePatch>(surfacePatchArrayProperty.getSurfacePatch())) {
				if (shouldWalk && visited.add(abstractSurfacePatch)) {
					if (abstractSurfacePatch instanceof Triangle) {
						object = apply((Triangle)abstractSurfacePatch);
						if (object != null)
							return object;
					} else if (abstractSurfacePatch instanceof Rectangle) {
						object = apply((Rectangle)abstractSurfacePatch);
						if (object != null)
							return object;
					}
				}
			}
		}

		return null;
	}

	public T apply(Element element, ElementDecl decl) {
		return null;
	}

	public T apply(ADEComponent adeComponent) {
		if (adeComponent.isSetContent() && shouldWalk && visited.add(adeComponent.getContent())) {
			T object = adeComponent(adeComponent.getContent(), null);
			if (object != null)
				return object;
		}

		return null;
	}

	protected T adeComponent(Element element, ElementDecl decl) {
		Schema schema = schemaHandler.getSchema(element.getNamespaceURI());
		T object = null;

		if (schema != null) {
			decl = schema.getElementDecl(element.getLocalName(), decl);
			if (decl != null && decl.isAbstractGML()) {
				object = apply(element, decl);
				if (object != null)
					return object;
			} else {
				object = iterateNodeList(element, decl);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	protected T iterateNodeList(Element element, ElementDecl decl) {
		NodeList nodeList = element.getChildNodes();

		List<Element> children = new ArrayList<Element>(nodeList.getLength());
		for (int i = 0; i < nodeList.getLength(); ++i) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE)
				children.add((Element)node);
		}	

		for (Element child : children) {
			if (shouldWalk && visited.add(child)) {
				T object = adeComponent((Element)child, decl);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	protected T apply(Value value) {
		if (value.isSetGeometry() && shouldWalk && visited.add(value.getGeometry())) {
			T object = value.getGeometry().accept(this);
			if (object != null)
				return object;
		} else if (value.isSetValueObject()) {
			T object = apply(value.getValueObject());
			if (object != null)
				return object;
		}

		return null;
	}

	protected T apply(ValueObject valueObject) {
		if (valueObject.isSetCompositeValue()) {
			T object = valueObject.getCompositeValue().accept(this);
			if (object != null)
				return object;
		}

		return null;
	}
}
