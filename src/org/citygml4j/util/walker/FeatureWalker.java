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
import org.citygml4j.model.common.visitor.FeatureVisitor;
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

public abstract class FeatureWalker implements FeatureVisitor, Walker {
	private Set<Object> visited = new HashSet<Object>();
	private boolean shouldWalk = true; 
	private SchemaHandler schemaHandler;

	public FeatureWalker() {
	}

	public FeatureWalker(SchemaHandler schemaHandler) {
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

	public void visit(AbstractCoverage abstractCoverage) {
		visit((AbstractFeature)abstractCoverage);
	}
	
	public void visit(AbstractDiscreteCoverage abstractDiscreteCoverage) {
		visit((AbstractCoverage)abstractDiscreteCoverage);
	}

	public void visit(AbstractFeature abstractFeature) {
		if (abstractFeature.isSetGenericADEComponent())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractFeature.getGenericADEComponent()))
				visit(ade);
	}

	public void visit(AbstractFeatureCollection abstractFeatureCollection) {
		visit((AbstractFeature)abstractFeatureCollection);

		if (abstractFeatureCollection.isSetFeatureMember())
			for (FeatureMember member : new ArrayList<FeatureMember>(abstractFeatureCollection.getFeatureMember()))
				visit(member);

		if (abstractFeatureCollection.isSetFeatureMembers())
			visit(abstractFeatureCollection.getFeatureMembers());
	}

	public void visit(AbstractCityObject abstractCityObject) {
		visit((AbstractFeature)abstractCityObject);

		if (abstractCityObject.isSetGeneralizesTo()) {
			for (GeneralizationRelation generalizationRelation : new ArrayList<GeneralizationRelation>(abstractCityObject.getGeneralizesTo()))
				visit(generalizationRelation);
		}

		if (abstractCityObject.isSetAppearance()) {
			for (AppearanceProperty appearanceProperty : new ArrayList<AppearanceProperty>(abstractCityObject.getAppearance()))
				visit(appearanceProperty);
		}

		if (abstractCityObject.isSetGenericApplicationPropertyOfCityObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractCityObject.getGenericApplicationPropertyOfCityObject()))
				visit(ade);
	}

	public void visit(AbstractSurfaceData abstractSurfaceData) {
		visit((AbstractFeature)abstractSurfaceData);

		if (abstractSurfaceData.isSetGenericApplicationPropertyOfSurfaceData())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractSurfaceData.getGenericApplicationPropertyOfSurfaceData()))
				visit(ade);
	}

	public void visit(AbstractTexture abstractTexture) {
		visit((AbstractSurfaceData)abstractTexture);

		if (abstractTexture.isSetGenericApplicationPropertyOfTexture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTexture.getGenericApplicationPropertyOfTexture()))
				visit(ade);
	}	

	public void visit(AbstractSite abstractSite) {
		visit((AbstractCityObject)abstractSite);

		if (abstractSite.isSetGenericApplicationPropertyOfSite())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractSite.getGenericApplicationPropertyOfSite()))
				visit(ade);
	}

	public void visit(AbstractBuilding abstractBuilding) {
		visit((AbstractSite)abstractBuilding);

		if (abstractBuilding.isSetOuterBuildingInstallation())
			for (BuildingInstallationProperty buildingInstallationProperty : new ArrayList<BuildingInstallationProperty>(abstractBuilding.getOuterBuildingInstallation()))
				visit(buildingInstallationProperty);

		if (abstractBuilding.isSetInteriorBuildingInstallation())
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : new ArrayList<IntBuildingInstallationProperty>(abstractBuilding.getInteriorBuildingInstallation())) 
				visit(intBuildingInstallationProperty);

		if (abstractBuilding.isSetBoundedBySurface())
			for (BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<BoundarySurfaceProperty>(abstractBuilding.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (abstractBuilding.isSetConsistsOfBuildingPart())
			for (BuildingPartProperty buildingPartProperty : new ArrayList<BuildingPartProperty>(abstractBuilding.getConsistsOfBuildingPart()))
				visit(buildingPartProperty);

		if (abstractBuilding.isSetInteriorRoom())
			for (InteriorRoomProperty interiorRoomProperty : new ArrayList<InteriorRoomProperty>(abstractBuilding.getInteriorRoom()))
				visit(interiorRoomProperty);

		if (abstractBuilding.isSetAddress())
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(abstractBuilding.getAddress()))
				visit(addressProperty);

		if (abstractBuilding.isSetGenericApplicationPropertyOfAbstractBuilding())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBuilding.getGenericApplicationPropertyOfAbstractBuilding()))
				visit(ade);
	}

	public void visit(AbstractBoundarySurface abstractBoundarySurface) {
		visit((AbstractCityObject)abstractBoundarySurface);

		if (abstractBoundarySurface.isSetOpening())
			for (OpeningProperty openingProperty : new ArrayList<OpeningProperty>(abstractBoundarySurface.getOpening()))
				visit(openingProperty);

		if (abstractBoundarySurface.isSetGenericApplicationPropertyOfBoundarySurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBoundarySurface.getGenericApplicationPropertyOfBoundarySurface()))
				visit(ade);
	}

	public void visit(AbstractOpening abstractOpening) {
		visit((AbstractCityObject)abstractOpening);

		if (abstractOpening.isSetGenericApplicationPropertyOfOpening())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractOpening.getGenericApplicationPropertyOfOpening()))
				visit(ade);
	}

	public void visit(AbstractReliefComponent abstractReliefComponent) {
		visit((AbstractCityObject)abstractReliefComponent);

		if (abstractReliefComponent.isSetGenericApplicationPropertyOfReliefComponent())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractReliefComponent.getGenericApplicationPropertyOfReliefComponent()))
				visit(ade);
	}

	public void visit(AbstractTransportationObject abstractTransportationObject) {
		visit((AbstractCityObject)abstractTransportationObject);

		if (abstractTransportationObject.isSetGenericApplicationPropertyOfTransportationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTransportationObject.getGenericApplicationPropertyOfTransportationObject()))
				visit(ade);
	}

	public void visit(AbstractVegetationObject abstractVegetationObject) {
		visit((AbstractCityObject)abstractVegetationObject);

		if (abstractVegetationObject.isSetGenericApplicationPropertyOfVegetationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractVegetationObject.getGenericApplicationPropertyOfVegetationObject()))
				visit(ade);
	}

	public void visit(AbstractWaterObject abstractWaterObject) {
		visit((AbstractCityObject)abstractWaterObject);

		if (abstractWaterObject.isSetGenericApplicationPropertyOfWaterObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractWaterObject.getGenericApplicationPropertyOfWaterObject()))
				visit(ade);
	}

	public void visit(AbstractWaterBoundarySurface abstractWaterBoundarySurface) {
		visit((AbstractCityObject)abstractWaterBoundarySurface);

		if (abstractWaterBoundarySurface.isSetGenericApplicationPropertyOfWaterBoundarySurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractWaterBoundarySurface.getGenericApplicationPropertyOfWaterBoundarySurface()))
				visit(ade);
	}
	
	public void visit(RectifiedGridCoverage rectifiedGridCoverage) {
		visit((AbstractDiscreteCoverage)rectifiedGridCoverage);
	}

	public void visit(Appearance appearance) {
		visit((AbstractFeature)appearance);

		if (appearance.isSetSurfaceDataMember())
			for (SurfaceDataProperty surfaceDataProperty : new ArrayList<SurfaceDataProperty>(appearance.getSurfaceDataMember()))
				visit(surfaceDataProperty);

		if (appearance.isSetGenericApplicationPropertyOfAppearance())
			for (ADEComponent ade : new ArrayList<ADEComponent>(appearance.getGenericApplicationPropertyOfAppearance()))
				visit(ade);
	}	

	public void visit(GeoreferencedTexture georeferencedTexture) {
		visit((AbstractTexture)georeferencedTexture);	

		if (georeferencedTexture.isSetGenericApplicationPropertyOfGeoreferencedTexture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(georeferencedTexture.getGenericApplicationPropertyOfGeoreferencedTexture()))
				visit(ade);
	}

	public void visit(ParameterizedTexture parameterizedTexture) {
		visit((AbstractTexture)parameterizedTexture);

		if (parameterizedTexture.isSetTarget()) {
			for (TextureAssociation textureAssociation : new ArrayList<TextureAssociation>(parameterizedTexture.getTarget())) {
				if (textureAssociation.isSetTextureParameterization() && shouldWalk && visited.add(textureAssociation.getTextureParameterization())) {
					AbstractTextureParameterization textureParameterization = textureAssociation.getTextureParameterization();

					if (textureParameterization instanceof TexCoordGen) {
						TexCoordGen texCoordGen = (TexCoordGen)textureParameterization;
						if (texCoordGen.isSetGenericApplicationPropertyOfTexCoordGen()) 
							for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordGen.getGenericApplicationPropertyOfTexCoordGen()))
								visit(ade);
					} 

					else if (textureParameterization instanceof TexCoordList) {
						TexCoordList texCoordList = (TexCoordList)textureParameterization;
						if (texCoordList.isSetGenericApplicationPropertyOfTexCoordList()) 
							for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordList.getGenericApplicationPropertyOfTexCoordList()))
								visit(ade);
					}

					if (textureParameterization.isSetGenericADEComponent())
						for (ADEComponent ade : new ArrayList<ADEComponent>(textureParameterization.getGenericADEComponent()))
							visit(ade);

					if (textureParameterization.isSetGenericApplicationPropertyOfTextureParameterization()) 
						for (ADEComponent ade : new ArrayList<ADEComponent>(textureParameterization.getGenericApplicationPropertyOfTextureParameterization()))
							visit(ade);
				}
			}
		}

		if (parameterizedTexture.isSetGenericApplicationPropertyOfParameterizedTexture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(parameterizedTexture.getGenericApplicationPropertyOfParameterizedTexture()))
				visit(ade);
	}

	public void visit(X3DMaterial x3dMaterial) {
		visit((AbstractSurfaceData)x3dMaterial);

		if (x3dMaterial.isSetGenericApplicationPropertyOfX3DMaterial())
			for (ADEComponent ade : new ArrayList<ADEComponent>(x3dMaterial.getGenericApplicationPropertyOfX3DMaterial()))
				visit(ade);
	}

	public void visit(BuildingFurniture buildingFurniture) {
		visit((AbstractCityObject)buildingFurniture);

		if (buildingFurniture.isSetGenericApplicationPropertyOfBuildingFurniture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingFurniture.getGenericApplicationPropertyOfBuildingFurniture()))
				visit(ade);
	}

	public void visit(Building building) {
		visit((AbstractBuilding)building);

		if (building.isSetGenericApplicationPropertyOfBuilding())
			for (ADEComponent ade : new ArrayList<ADEComponent>(building.getGenericApplicationPropertyOfBuilding()))
				visit(ade);
	}

	public void visit(BuildingInstallation buildingInstallation) {
		visit((AbstractCityObject)buildingInstallation);

		if (buildingInstallation.isSetGenericApplicationPropertyOfBuildingInstallation())
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingInstallation.getGenericApplicationPropertyOfBuildingInstallation()))
				visit(ade);
	}

	public void visit(BuildingPart buildingPart) {
		visit((AbstractBuilding)buildingPart);

		if (buildingPart.isSetGenericApplicationPropertyOfBuildingPart())
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingPart.getGenericApplicationPropertyOfBuildingPart()))
				visit(ade);
	}

	public void visit(CeilingSurface ceilingSurface) {
		visit((AbstractBoundarySurface)ceilingSurface);

		if (ceilingSurface.isSetGenericApplicationPropertyOfCeilingSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(ceilingSurface.getGenericApplicationPropertyOfCeilingSurface()))
				visit(ade);
	}

	public void visit(ClosureSurface closureSurface) {
		visit((AbstractBoundarySurface)closureSurface);

		if (closureSurface.isSetGenericApplicationPropertyOfClosureSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(closureSurface.getGenericApplicationPropertyOfClosureSurface()))
				visit(ade);
	}

	public void visit(Door door) {
		visit((AbstractOpening)door);

		if (door.isSetAddress())
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(door.getAddress()))
				visit(addressProperty);

		if (door.isSetGenericApplicationPropertyOfDoor())
			for (ADEComponent ade : new ArrayList<ADEComponent>(door.getGenericApplicationPropertyOfDoor()))
				visit(ade);
	}

	public void visit(FloorSurface floorSurface) {
		visit((AbstractBoundarySurface)floorSurface);

		if (floorSurface.isSetGenericApplicationPropertyOfFloorSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(floorSurface.getGenericApplicationPropertyOfFloorSurface()))
				visit(ade);
	}

	public void visit(GroundSurface groundSurface) {
		visit((AbstractBoundarySurface)groundSurface);

		if (groundSurface.isSetGenericApplicationPropertyOfGroundSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(groundSurface.getGenericApplicationPropertyOfGroundSurface()))
				visit(ade);
	}

	public void visit(IntBuildingInstallation intBuildingInstallation) {
		visit((AbstractCityObject)intBuildingInstallation);

		if (intBuildingInstallation.isSetGenericApplicationPropertyOfIntBuildingInstallation())
			for (ADEComponent ade : new ArrayList<ADEComponent>(intBuildingInstallation.getGenericApplicationPropertyOfIntBuildingInstallation()))
				visit(ade);
	}

	public void visit(InteriorWallSurface interiorWallSurface) {
		visit((AbstractBoundarySurface)interiorWallSurface);

		if (interiorWallSurface.isSetGenericApplicationPropertyOfInteriorWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface()))
				visit(ade);
	}

	public void visit(RoofSurface roofSurface) {
		visit((AbstractBoundarySurface)roofSurface);

		if (roofSurface.isSetGenericApplicationPropertyOfRoofSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(roofSurface.getGenericApplicationPropertyOfRoofSurface()))
				visit(ade);
	}

	public void visit(Room room) {
		visit((AbstractCityObject)room);

		if (room.isSetBoundedBySurface())
			for (BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<BoundarySurfaceProperty>(room.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (room.isSetInteriorFurniture())
			for (InteriorFurnitureProperty interiorFurnitureProperty : new ArrayList<InteriorFurnitureProperty>(room.getInteriorFurniture()))
				visit(interiorFurnitureProperty);

		if (room.isSetRoomInstallation())
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : new ArrayList<IntBuildingInstallationProperty>(room.getRoomInstallation()))
				visit(intBuildingInstallationProperty);

		if (room.isSetGenericApplicationPropertyOfRoom())
			for (ADEComponent ade : new ArrayList<ADEComponent>(room.getGenericApplicationPropertyOfRoom()))
				visit(ade);
	}

	public void visit(WallSurface wallSurface) {
		visit((AbstractBoundarySurface)wallSurface);

		if (wallSurface.isSetGenericApplicationPropertyOfWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(wallSurface.getGenericApplicationPropertyOfWallSurface()))
				visit(ade);
	}

	public void visit(Window window) {
		visit((AbstractOpening)window);

		if (window.isSetGenericApplicationPropertyOfWindow())
			for (ADEComponent ade : new ArrayList<ADEComponent>(window.getGenericApplicationPropertyOfWindow()))
				visit(ade);
	}

	public void visit(CityFurniture cityFurniture) {
		visit((AbstractCityObject)cityFurniture);

		if (cityFurniture.isSetGenericApplicationPropertyOfCityFurniture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityFurniture.getGenericApplicationPropertyOfCityFurniture()))
				visit(ade);
	}

	public void visit(CityObjectGroup cityObjectGroup) {
		visit((AbstractCityObject)cityObjectGroup);

		if (cityObjectGroup.isSetGroupMember())
			for (CityObjectGroupMember cityObjectGroupMember : new ArrayList<CityObjectGroupMember>(cityObjectGroup.getGroupMember()))
				visit(cityObjectGroupMember);

		if (cityObjectGroup.isSetGroupParent())
			visit(cityObjectGroup.getGroupParent());

		if (cityObjectGroup.isSetGenericApplicationPropertyOfCityObjectGroup())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityObjectGroup.getGenericApplicationPropertyOfCityObjectGroup()))
				visit(ade);
	}

	public void visit(Address address) {
		visit((AbstractFeature)address);

		if (address.isSetGenericApplicationPropertyOfAddress())
			for (ADEComponent ade : new ArrayList<ADEComponent>(address.getGenericApplicationPropertyOfAddress()))
				visit(ade);
	}

	public void visit(CityModel cityModel) {
		visit((AbstractFeatureCollection)cityModel);

		if (cityModel.isSetCityObjectMember())
			for (CityObjectMember member : new ArrayList<CityObjectMember>(cityModel.getCityObjectMember()))
				visit(member);

		if (cityModel.isSetAppearanceMember())
			for (AppearanceProperty member : new ArrayList<AppearanceProperty>(cityModel.getAppearanceMember()))
				visit(member);

		if (cityModel.isSetGenericApplicationPropertyOfCityModel())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityModel.getGenericApplicationPropertyOfCityModel()))
				visit(ade);
	}

	public void visit(GenericCityObject genericCityObject) {
		visit((AbstractCityObject)genericCityObject);
	}

	public void visit(LandUse landUse) {
		visit((AbstractCityObject)landUse);

		if (landUse.isSetGenericApplicationPropertyOfLandUse())
			for (ADEComponent ade : new ArrayList<ADEComponent>(landUse.getGenericApplicationPropertyOfLandUse()))
				visit(ade);
	}

	public void visit(BreaklineRelief breaklineRelief) {
		visit((AbstractReliefComponent)breaklineRelief);

		if (breaklineRelief.isSetGenericApplicationPropertyOfBreaklineRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(breaklineRelief.getGenericApplicationPropertyOfBreaklineRelief()))
				visit(ade);
	}

	public void visit(MassPointRelief massPointRelief) {
		visit((AbstractReliefComponent)massPointRelief);

		if (massPointRelief.isSetGenericApplicationPropertyOfMassPointRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(massPointRelief.getGenericApplicationPropertyOfMassPointRelief()))
				visit(ade);
	}

	public void visit(RasterRelief rasterRelief) {
		visit((AbstractReliefComponent)rasterRelief);

		if (rasterRelief.isSetGrid())
			visit(rasterRelief.getGrid());
		
		if (rasterRelief.isSetGenericApplicationPropertyOfRasterRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(rasterRelief.getGenericApplicationPropertyOfRasterRelief()))
				visit(ade);
	}

	public void visit(ReliefFeature reliefFeature) {
		visit((AbstractCityObject)reliefFeature);

		if (reliefFeature.isSetReliefComponent())
			for (ReliefComponentProperty reliefComponentProperty : new ArrayList<ReliefComponentProperty>(reliefFeature.getReliefComponent()))
				visit(reliefComponentProperty);

		if (reliefFeature.isSetGenericApplicationPropertyOfReliefFeature())
			for (ADEComponent ade : new ArrayList<ADEComponent>(reliefFeature.getGenericApplicationPropertyOfReliefFeature()))
				visit(ade);
	}

	public void visit(TINRelief tinRelief) {
		visit((AbstractReliefComponent)tinRelief);

		if (tinRelief.isSetGenericApplicationPropertyOfTinRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(tinRelief.getGenericApplicationPropertyOfTinRelief()))
				visit(ade);
	}

	public void visit(AuxiliaryTrafficArea auxiliaryTrafficArea) {
		visit((AbstractTransportationObject)auxiliaryTrafficArea);

		if (auxiliaryTrafficArea.isSetGenericApplicationPropertyOfAuxiliaryTrafficArea())
			for (ADEComponent ade : new ArrayList<ADEComponent>(auxiliaryTrafficArea.getGenericApplicationPropertyOfAuxiliaryTrafficArea()))
				visit(ade);
	}

	public void visit(Railway railway) {
		visit((TransportationComplex)railway);

		if (railway.isSetGenericApplicationPropertyOfRailway())
			for (ADEComponent ade : new ArrayList<ADEComponent>(railway.getGenericApplicationPropertyOfRailway()))
				visit(ade);
	}
	
	public void visit(Road road) {
		visit((TransportationComplex)road);

		if (road.isSetGenericApplicationPropertyOfRoad())
			for (ADEComponent ade : new ArrayList<ADEComponent>(road.getGenericApplicationPropertyOfRoad()))
				visit(ade);
	}

	public void visit(Square square) {
		visit((TransportationComplex)square);

		if (square.isSetGenericApplicationPropertyOfSquare())
			for (ADEComponent ade : new ArrayList<ADEComponent>(square.getGenericApplicationPropertyOfSquare()))
				visit(ade);
	}

	public void visit(Track track) {
		visit((TransportationComplex)track);

		if (track.isSetGenericApplicationPropertyOfTrack())
			for (ADEComponent ade : new ArrayList<ADEComponent>(track.getGenericApplicationPropertyOfTrack()))
				visit(ade);
	}

	public void visit(TrafficArea trafficArea) {
		visit((AbstractTransportationObject)trafficArea);

		if (trafficArea.isSetGenericApplicationPropertyOfTrafficArea())
			for (ADEComponent ade : new ArrayList<ADEComponent>(trafficArea.getGenericApplicationPropertyOfTrafficArea()))
				visit(ade);
	}

	public void visit(TransportationComplex transportationComplex) {
		visit((AbstractTransportationObject)transportationComplex);

		if (transportationComplex.isSetTrafficArea())
			for (TrafficAreaProperty trafficAreaProperty : new ArrayList<TrafficAreaProperty>(transportationComplex.getTrafficArea()))
				visit(trafficAreaProperty);

		if (transportationComplex.isSetAuxiliaryTrafficArea())
			for (AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty : new ArrayList<AuxiliaryTrafficAreaProperty>(transportationComplex.getAuxiliaryTrafficArea()))
				visit(auxiliaryTrafficAreaProperty);

		if (transportationComplex.isSetGenericApplicationPropertyOfTransportationComplex())
			for (ADEComponent ade : new ArrayList<ADEComponent>(transportationComplex.getGenericApplicationPropertyOfTransportationComplex()))
				visit(ade);
	}

	public void visit(PlantCover plantCover) {
		visit((AbstractVegetationObject)plantCover);

		if (plantCover.isSetGenericApplicationPropertyOfPlantCover())
			for (ADEComponent ade : new ArrayList<ADEComponent>(plantCover.getGenericApplicationPropertyOfPlantCover()))
				visit(ade);
	}

	public void visit(SolitaryVegetationObject solitaryVegetationObject) {
		visit((AbstractVegetationObject)solitaryVegetationObject);

		if (solitaryVegetationObject.isSetGenericApplicationPropertyOfSolitaryVegetationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(solitaryVegetationObject.getGenericApplicationPropertyOfVegetationObject()))
				visit(ade);
	}

	public void visit(WaterBody waterBody) {
		visit((AbstractWaterObject)waterBody);

		if (waterBody.isSetBoundedBySurface())
			for (BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty : new ArrayList<BoundedByWaterSurfaceProperty>(waterBody.getBoundedBySurface()))
				visit(boundedByWaterSurfaceProperty);

		if (waterBody.isSetGenericApplicationPropertyOfWaterBody())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterBody.getGenericApplicationPropertyOfWaterBody()))
				visit(ade);
	}

	public void visit(WaterClosureSurface waterClosureSurface) {
		visit((AbstractWaterBoundarySurface)waterClosureSurface);

		if (waterClosureSurface.isSetGenericApplicationPropertyOfWaterClosureSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterClosureSurface.getGenericApplicationPropertyOfWaterClosureSurface()))
				visit(ade);
	}

	public void visit(WaterGroundSurface waterGroundSurface) {
		visit((AbstractWaterBoundarySurface)waterGroundSurface);

		if (waterGroundSurface.isSetGenericApplicationPropertyOfWaterGroundSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterGroundSurface.getGenericApplicationPropertyOfWaterGroundSurface()))
				visit(ade);
	}

	public void visit(WaterSurface waterSurface) {
		visit((AbstractWaterBoundarySurface)waterSurface);

		if (waterSurface.isSetGenericApplicationPropertyOfWaterSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterSurface.getGenericApplicationPropertyOfWaterSurface()))
				visit(ade);
	}

	public <T extends AbstractFeature> void visit(FeatureProperty<T> featureProperty) {
		if (featureProperty.isSetFeature() && shouldWalk && visited.add(featureProperty.getFeature()))
			featureProperty.getFeature().accept(this);

		if (featureProperty.isSetGenericADEComponent())
			visit(featureProperty.getGenericADEComponent());
	}
	
	public void visit(FeatureArrayProperty featureArrayProperty) {
		if (featureArrayProperty.isSetFeature()) {
			for (AbstractFeature feature : new ArrayList<AbstractFeature>(featureArrayProperty.getFeature()))
				if (shouldWalk && visited.add(feature))
					feature.accept(this);

			if (featureArrayProperty.isSetGenericADEComponent())
				for (ADEComponent ade : new ArrayList<ADEComponent>(featureArrayProperty.getGenericADEComponent()))
					visit(ade);
		}
	}
	
	public void visit(Element element, ElementDecl decl) {
		iterateNodeList(element, decl);
	}

	public void visit(ADEComponent adeComponent) {
		if (adeComponent.isSetContent() && shouldWalk && visited.add(adeComponent.getContent()) && schemaHandler != null)
			adeComponent(adeComponent.getContent(), null); 
	}

	protected void adeComponent(Element element, ElementDecl decl) {
		Schema schema = schemaHandler.getSchema(element.getNamespaceURI());

		if (schema != null) {
			decl = schema.getElementDecl(element.getLocalName(), decl);
			if (decl != null && decl.isFeature())
				visit(element, decl);
			else
				iterateNodeList(element, decl);
		}		
	}

	protected void iterateNodeList(Element element, ElementDecl decl) {
		NodeList nodeList = element.getChildNodes();

		List<Element> children = new ArrayList<Element>(nodeList.getLength());
		for (int i = 0; i < nodeList.getLength(); ++i) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE)
				children.add((Element)node);
		}	

		for (Element child : children)
			if (shouldWalk && visited.add(child))
				adeComponent((Element)child, decl);
	}
	
}
