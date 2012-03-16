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
import org.citygml4j.model.citygml.building.OuterCeilingSurface;
import org.citygml4j.model.citygml.building.OuterFloorSurface;
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
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.relief.AbstractReliefComponent;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
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
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.gml.coverage.AbstractCoverage;
import org.citygml4j.model.gml.coverage.AbstractDiscreteCoverage;
import org.citygml4j.model.gml.coverage.RectifiedGridCoverage;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.AbstractFeatureCollection;
import org.citygml4j.model.gml.feature.FeatureArrayProperty;
import org.citygml4j.model.gml.feature.FeatureMember;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class FeatureFunctionWalker<T> implements FeatureFunctor<T>, Walker {
	private Set<Object> visited = new HashSet<Object>();
	private boolean shouldWalk = true;
	private SchemaHandler schemaHandler;

	public FeatureFunctionWalker() {
	}

	public FeatureFunctionWalker(SchemaHandler schemaHandler) {
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

	public T apply(AbstractFeature abstractFeature) {
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

	public T apply(AbstractCoverage abstractCoverage) {
		return apply((AbstractFeature)abstractCoverage);
	}

	public T apply(AbstractDiscreteCoverage abstractDiscreteCoverage) {
		return apply((AbstractCoverage)abstractDiscreteCoverage);
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

		if (abstractWaterBoundarySurface.isSetGenericApplicationPropertyOfWaterBoundarySurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractWaterBoundarySurface.getGenericApplicationPropertyOfWaterBoundarySurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(RectifiedGridCoverage rectifiedGridCoverage) {
		T object = apply((AbstractDiscreteCoverage)rectifiedGridCoverage);
		if (object != null)
			return object;

		return null;
	}

	public T apply(Address address) {
		T object = apply((AbstractFeature)address);
		if (object != null)
			return object;

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
	
	public T apply(OuterCeilingSurface outerCeilingSurface) {
		T object = apply((AbstractBoundarySurface)outerCeilingSurface);
		if (object != null)
			return object;

		if (outerCeilingSurface.isSetGenericApplicationPropertyOfOuterCeilingSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerCeilingSurface.getGenericApplicationPropertyOfOuterCeilingSurface())) {
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
	
	public T apply(OuterFloorSurface outerFloorSurface) {
		T object = apply((AbstractBoundarySurface)outerFloorSurface);
		if (object != null)
			return object;

		if (outerFloorSurface.isSetGenericApplicationPropertyOfOuterFloorSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerFloorSurface.getGenericApplicationPropertyOfOuterFloorSurface())) {
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

		return null;
	}

	public T apply(GeoreferencedTexture georeferencedTexture) {
		T object = apply((AbstractTexture)georeferencedTexture);
		if (object != null)
			return object;

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
				if (textureAssociation.isSetTextureParameterization() && shouldWalk && visited.add(textureAssociation.getTextureParameterization())) {
					AbstractTextureParameterization textureParameterization = textureAssociation.getTextureParameterization();

					if (textureAssociation instanceof TexCoordGen) {
						TexCoordGen texCoordGen = (TexCoordGen)textureParameterization;
						if (texCoordGen.isSetGenericApplicationPropertyOfTexCoordGen()) {
							for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordGen.getGenericApplicationPropertyOfTexCoordGen())) {
								object = apply(ade);
								if (object != null)
									return object;
							}
						}
					}

					else if (textureAssociation instanceof TexCoordList) {
						TexCoordList texCoordList = (TexCoordList)textureParameterization;
						if (texCoordList.isSetGenericApplicationPropertyOfTexCoordList()) {
							for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordList.getGenericApplicationPropertyOfTexCoordList())) {
								object = apply(ade);
								if (object != null)
									return object;
							}
						}
					}

					if (textureParameterization.isSetGenericADEComponent()) {
						for (ADEComponent ade : new ArrayList<ADEComponent>(textureParameterization.getGenericADEComponent())) {
							object = apply(ade);
							if (object != null)
								return object;
						}
					}

					if (textureParameterization.isSetGenericApplicationPropertyOfTextureParameterization()) {
						for (ADEComponent ade : new ArrayList<ADEComponent>(textureParameterization.getGenericApplicationPropertyOfTextureParameterization())) {
							object = apply(ade);
							if (object != null)
								return object;
						}
					}
				}				
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

	public <E extends AbstractFeature> T apply(FeatureProperty<E> featureProperty) {
		if (featureProperty.isSetFeature() && shouldWalk && visited.add(featureProperty.getFeature())) {
			T object = featureProperty.getFeature().accept(this);
			if (object != null)
				return object;
		}

		if (featureProperty.isSetGenericADEComponent()) {
			T object = apply(featureProperty.getGenericADEComponent());
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

}
