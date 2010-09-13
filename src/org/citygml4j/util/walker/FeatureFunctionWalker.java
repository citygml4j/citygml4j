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
			for (FeatureMember featureMember : abstractFeatureCollection.getFeatureMember()) {
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
			for (GeneralizationRelation generalizationRelation : abstractCityObject.getGeneralizesTo()) {
				object = apply(generalizationRelation);
				if (object != null)
					return object;
			}
		}

		if (abstractCityObject.isSetAppearance()) {
			for (AppearanceProperty appearanceProperty : abstractCityObject.getAppearance()) {
				object = apply(appearanceProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractCityObject.isSetGenericApplicationPropertyOfCityObject()) {
			for (ADEComponent ade : abstractCityObject.getGenericApplicationPropertyOfCityObject()) {
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
			for (ADEComponent ade : abstractTransportationObject.getGenericApplicationPropertyOfTransportationObject()) {
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
			for (ADEComponent ade : abstractReliefComponent.getGenericApplicationPropertyOfReliefComponent()) {
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
			for (ADEComponent ade : abstractSite.getGenericApplicationPropertyOfSite()) {
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
			for (BuildingInstallationProperty buildingInstallationProperty : abstractBuilding.getOuterBuildingInstallation()) {
				object = apply(buildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetInteriorBuildingInstallation()) {
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : abstractBuilding.getInteriorBuildingInstallation()) {
				object = apply(intBuildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : abstractBuilding.getBoundedBySurface()) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetConsistsOfBuildingPart()) {
			for (BuildingPartProperty buildingPartProperty : abstractBuilding.getConsistsOfBuildingPart()) {
				object = apply(buildingPartProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetInteriorRoom()) {
			for (InteriorRoomProperty interiorRoomProperty : abstractBuilding.getInteriorRoom()) {
				object = apply(interiorRoomProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetAddress()) {
			for (AddressProperty addressProperty : abstractBuilding.getAddress()) {
				object = apply(addressProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetGenericApplicationPropertyOfAbstractBuilding()) {
			for (ADEComponent ade : abstractBuilding.getGenericApplicationPropertyOfAbstractBuilding()) {
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
			for (OpeningProperty openingProperty : abstractBoundarySurface.getOpening()) {
				object = apply(openingProperty);
				if (object != null)
					return object;					
			}
		}

		if (abstractBoundarySurface.isSetGenericApplicationPropertyOfBoundarySurface()) {
			for (ADEComponent ade : abstractBoundarySurface.getGenericApplicationPropertyOfBoundarySurface()) {
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
			for (ADEComponent ade : abstractOpening.getGenericApplicationPropertyOfOpening()) {
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
			for (ADEComponent ade : abstractSurfaceData.getGenericApplicationPropertyOfSurfaceData()) {
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
			for (ADEComponent ade : abstractTexture.getGenericApplicationPropertyOfTexture()) {
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
			for (ADEComponent ade : abstractVegetationObject.getGenericApplicationPropertyOfVegetationObject()) {
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
			for (ADEComponent ade : abstractWaterObject.getGenericApplicationPropertyOfWaterObject()) {
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
			for (ADEComponent ade : abstractWaterBoundarySurface.getGenericApplicationPropertyOfWaterBoundarySurface()) {
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
			for (ADEComponent ade : address.getGenericApplicationPropertyOfAddress()) {
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
			for (SurfaceDataProperty surfaceDataProperty : appearance.getSurfaceDataMember()) {
				object = apply(surfaceDataProperty);
				if (object != null)
					return object;
			}

		if (appearance.isSetGenericApplicationPropertyOfAppearance()) {
			for (ADEComponent ade : appearance.getGenericApplicationPropertyOfAppearance()) {
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
			for (ADEComponent ade : auxiliaryTrafficArea.getGenericApplicationPropertyOfAuxiliaryTrafficArea()) {
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
			for (ADEComponent ade : breaklineRelief.getGenericApplicationPropertyOfBreaklineRelief()) {
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
			for (ADEComponent ade : building.getGenericApplicationPropertyOfBuilding()) {
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
			for (ADEComponent ade : buildingFurniture.getGenericApplicationPropertyOfBuildingFurniture()) {
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
			for (ADEComponent ade : buildingInstallation.getGenericApplicationPropertyOfBuildingInstallation()) {
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
			for (ADEComponent ade : buildingPart.getGenericApplicationPropertyOfBuildingPart()) {
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
			for (ADEComponent ade : ceilingSurface.getGenericApplicationPropertyOfCeilingSurface()) {
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
			for (ADEComponent ade : cityFurniture.getGenericApplicationPropertyOfCityFurniture()) {
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
			for (CityObjectMember cityObjectMember : cityModel.getCityObjectMember()) {
				object = apply(cityObjectMember);
				if (object != null)
					return object;
			}
		}

		if (cityModel.isSetAppearanceMember()) {
			for (AppearanceMember appearanceMember : cityModel.getAppearanceMember()) {
				object = apply(appearanceMember);
				if (object != null)
					return object;
			}
		}

		if (cityModel.isSetGenericApplicationPropertyOfCityModel()) {
			for (ADEComponent ade : cityModel.getGenericApplicationPropertyOfCityModel()) {
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
			for (CityObjectGroupMember cityObjectGroupMember : cityObjectGroup.getGroupMember()) {
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
			for (ADEComponent ade : cityObjectGroup.getGenericApplicationPropertyOfCityObjectGroup()) {
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
			for (ADEComponent ade : closureSurface.getGenericApplicationPropertyOfClosureSurface()) {
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
			for (AddressProperty addressProperty : door.getAddress()) {
				object = apply(addressProperty);
				if (object != null)
					return object;
			}
		}

		if (door.isSetGenericApplicationPropertyOfDoor()) {
			for (ADEComponent ade : door.getGenericApplicationPropertyOfDoor()) {
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
			for (ADEComponent ade : floorSurface.getGenericApplicationPropertyOfFloorSurface()) {
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
			for (ADEComponent ade : georeferencedTexture.getGenericApplicationPropertyOfGeoreferencedTexture()) {
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
			for (ADEComponent ade : groundSurface.getGenericApplicationPropertyOfGroundSurface()) {
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
			for (ADEComponent ade : intBuildingInstallation.getGenericApplicationPropertyOfIntBuildingInstallation()) {
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
			for (ADEComponent ade : interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface()) {
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
			for (ADEComponent ade : landUse.getGenericApplicationPropertyOfLandUse()) {
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
			for (ADEComponent ade : massPointRelief.getGenericApplicationPropertyOfMassPointRelief()) {
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
			for (TextureAssociation textureAssociation : parameterizedTexture.getTarget()) {
				if (textureAssociation.isSetTextureParameterization() && shouldWalk && visited.add(textureAssociation.getTextureParameterization())) {
					AbstractTextureParameterization textureParameterization = textureAssociation.getTextureParameterization();
					
					if (textureAssociation instanceof TexCoordGen) {
						TexCoordGen texCoordGen = (TexCoordGen)textureParameterization;
						if (texCoordGen.isSetGenericApplicationPropertyOfTexCoordGen()) {
							for (ADEComponent ade : texCoordGen.getGenericApplicationPropertyOfTexCoordGen()) {
								object = apply(ade);
								if (object != null)
									return object;
							}
						}
					}
					
					else if (textureAssociation instanceof TexCoordList) {
						TexCoordList texCoordList = (TexCoordList)textureParameterization;
						if (texCoordList.isSetGenericApplicationPropertyOfTexCoordList()) {
							for (ADEComponent ade : texCoordList.getGenericApplicationPropertyOfTexCoordList()) {
								object = apply(ade);
								if (object != null)
									return object;
							}
						}
					}
					
					if (textureParameterization.isSetGenericADEComponent()) {
						for (ADEComponent ade : textureParameterization.getGenericADEComponent()) {
							object = apply(ade);
							if (object != null)
								return object;
						}
					}
					
					if (textureParameterization.isSetGenericApplicationPropertyOfTextureParameterization()) {
						for (ADEComponent ade : textureParameterization.getGenericApplicationPropertyOfTextureParameterization()) {
							object = apply(ade);
							if (object != null)
								return object;
						}
					}
				}				
			}
		}

		if (parameterizedTexture.isSetGenericApplicationPropertyOfParameterizedTexture()) {
			for (ADEComponent ade : parameterizedTexture.getGenericApplicationPropertyOfParameterizedTexture()) {
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
			for (ADEComponent ade : plantCover.getGenericApplicationPropertyOfPlantCover()) {
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
			for (ADEComponent ade : railway.getGenericApplicationPropertyOfRailway()) {
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
			for (ADEComponent ade : rasterRelief.getGenericApplicationPropertyOfRasterRelief()) {
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
			for (ReliefComponentProperty reliefComponentProperty : reliefFeature.getReliefComponent()) {
				object = apply(reliefComponentProperty);
				if (object != null)
					return object;
			}
		}

		if (reliefFeature.isSetGenericApplicationPropertyOfReliefFeature()) {
			for (ADEComponent ade : reliefFeature.getGenericApplicationPropertyOfReliefFeature()) {
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
			for (ADEComponent ade : road.getGenericApplicationPropertyOfRoad()) {
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
			for (ADEComponent ade : roofSurface.getGenericApplicationPropertyOfRoofSurface()) {
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
			for (BoundarySurfaceProperty boundarySurfaceProperty : room.getBoundedBySurface()) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetInteriorFurniture()) {
			for (InteriorFurnitureProperty interiorFurnitureProperty : room.getInteriorFurniture()) {
				object = apply(interiorFurnitureProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetRoomInstallation()) {
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : room.getRoomInstallation()) {
				object = apply(intBuildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetGenericApplicationPropertyOfRoom()) {
			for (ADEComponent ade : room.getGenericApplicationPropertyOfRoom()) {
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
			for (ADEComponent ade : solitaryVegetationObject.getGenericApplicationPropertyOfSolitaryVegetationObject()) {
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
			for (ADEComponent ade : square.getGenericApplicationPropertyOfSquare()) {
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
			for (ADEComponent ade : tinRelief.getGenericApplicationPropertyOfTinRelief()) {
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
			for (ADEComponent ade : track.getGenericApplicationPropertyOfTrack()) {
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
			for (ADEComponent ade : trafficArea.getGenericApplicationPropertyOfTrafficArea()) {
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
			for (TrafficAreaProperty trafficAreaProperty : transportationComplex.getTrafficArea()) {
				object = apply(trafficAreaProperty);
				if (object != null)
					return object;
			}
		}

		if (transportationComplex.isSetAuxiliaryTrafficArea()) {
			for (AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty : transportationComplex.getAuxiliaryTrafficArea()) {
				object = apply(auxiliaryTrafficAreaProperty);
				if (object != null)
					return object;
			}
		}

		if (transportationComplex.isSetGenericApplicationPropertyOfTransportationComplex()) {
			for (ADEComponent ade : transportationComplex.getGenericApplicationPropertyOfTransportationComplex()) {
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
			for (ADEComponent ade : wallSurface.getGenericApplicationPropertyOfWallSurface()) {
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
			for (BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty : waterBody.getBoundedBySurface()) {
				object = apply(boundedByWaterSurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (waterBody.isSetGenericApplicationPropertyOfWaterBody()) {
			for (ADEComponent ade : waterBody.getGenericApplicationPropertyOfWaterBody()) {
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
			for (ADEComponent ade : waterClosureSurface.getGenericApplicationPropertyOfWaterClosureSurface()) {
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
			for (ADEComponent ade : waterGroundSurface.getGenericApplicationPropertyOfWaterGroundSurface()) {
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
			for (ADEComponent ade : waterSurface.getGenericApplicationPropertyOfWaterSurface()) {
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
			for (ADEComponent ade : window.getGenericApplicationPropertyOfWindow()) {
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
			for (ADEComponent ade : x3dMaterial.getGenericApplicationPropertyOfX3DMaterial()) {
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
			for (AbstractFeature feature : featureArrayProperty.getFeature())
				if (shouldWalk && visited.add(feature)) {
					T object = feature.accept(this);
					if (object != null)
						return object;
				}					
		}

		if (featureArrayProperty.isSetGenericADEComponent()) {
			for (ADEComponent ade : featureArrayProperty.getGenericADEComponent()) {
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

		for (Element child : children)
			if (shouldWalk && visited.add(child)) {
				T object = adeComponent((Element)child, decl);
				if (object != null)
					return object;
			}

		return null;
	}

}
