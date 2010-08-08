package org.citygml4j.visitor.walker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.SurfaceDataProperty;
import org.citygml4j.model.citygml.appearance.TexCoordGen;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.citygml.appearance.TextureParameterization;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.building.BoundarySurface;
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
import org.citygml4j.model.citygml.building.Opening;
import org.citygml4j.model.citygml.building.OpeningProperty;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.GeneralizationRelation;
import org.citygml4j.model.citygml.core.Site;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponent;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.citygml.transportation.TransportationObject;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.vegetation.VegetationObject;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterObject;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.gml.AbstractCoverage;
import org.citygml4j.model.gml.AbstractDiscreteCoverage;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.AbstractFeatureCollection;
import org.citygml4j.model.gml.AbstractGML;
import org.citygml4j.model.gml.Association;
import org.citygml4j.model.gml.CompositeValue;
import org.citygml4j.model.gml.FeatureArrayProperty;
import org.citygml4j.model.gml.FeatureProperty;
import org.citygml4j.model.gml.GenericValueObject;
import org.citygml4j.model.gml.RangeSet;
import org.citygml4j.model.gml.RectifiedGridCoverage;
import org.citygml4j.model.gml.Value;
import org.citygml4j.model.gml.ValueArray;
import org.citygml4j.model.gml.ValueArrayProperty;
import org.citygml4j.model.gml.ValueObject;
import org.citygml4j.model.gml.ValueProperty;
import org.citygml4j.visitor.FeatureVisitor;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public abstract class FeatureWalker implements FeatureVisitor, Walker {
	private Set<Object> visited = new HashSet<Object>();
	private boolean shouldWalk = true; 
	private SchemaHandler schemaHandler;

	public FeatureWalker() {
		try {
			schemaHandler = SchemaHandler.newInstance();
		} catch (SAXException e) {
			//
		}
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

	public void accept(AbstractCoverage abstractCoverage) {
		if (abstractCoverage.isSetRangeSet()) {
			RangeSet rangeSet = abstractCoverage.getRangeSet();
			if (rangeSet.isSetValueArray()) {
				for (ValueArray valueArray : rangeSet.getValueArray())
					accept(valueArray);
			}
		}

		accept((AbstractFeature)abstractCoverage);
	}
	
	public void accept(AbstractDiscreteCoverage abstractDiscreteCoverage) {
		accept((AbstractCoverage)abstractDiscreteCoverage);
	}

	public void accept(AbstractFeature abstractFeature) {
		if (abstractFeature.isSetGenericADEComponent())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractFeature.getGenericADEComponent()))
				accept(ade);
	}

	public void accept(AbstractFeatureCollection abstractFeatureCollection) {
		if (abstractFeatureCollection.isSetFeatureMember())
			for (FeatureProperty<? extends AbstractFeature> member : new ArrayList<FeatureProperty<? extends AbstractFeature>>(abstractFeatureCollection.getFeatureMember()))
				accept(member);

		if (abstractFeatureCollection.isSetFeatureMembers()) {
			FeatureArrayProperty featureProperty = abstractFeatureCollection.getFeatureMembers();
			for (AbstractFeature feature : new ArrayList<AbstractFeature>(featureProperty.getFeature()))
				if (feature != null && shouldWalk && visited.add(feature))
					feature.visit(this);

			if (featureProperty.isSetGenericADEComponent())
				for (ADEComponent ade : new ArrayList<ADEComponent>(featureProperty.getGenericADEComponent()))
					accept(ade);
		}

		accept((AbstractFeature)abstractFeatureCollection);
	}

	public void accept(CityObject cityObject) {
		if (cityObject.isSetGeneralizesTo()) {
			for (GeneralizationRelation generalizationRelation : new ArrayList<GeneralizationRelation>(cityObject.getGeneralizesTo()))
				accept(generalizationRelation);
		}

		if (cityObject.isSetAppearance()) {
			for (AppearanceProperty appearanceProperty : new ArrayList<AppearanceProperty>(cityObject.getAppearance()))
				accept(appearanceProperty);
		}

		if (cityObject.isSetGenericApplicationPropertyOfCityObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityObject.getGenericApplicationPropertyOfCityObject()))
				accept(ade);

		accept((AbstractFeature)cityObject);
	}

	public void accept(AbstractSurfaceData abstractSurfaceData) {
		if (abstractSurfaceData.isSetGenericApplicationPropertyOfSurfaceData())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractSurfaceData.getGenericApplicationPropertyOfSurfaceData()))
				accept(ade);

		accept((AbstractFeature)abstractSurfaceData);
	}

	public void accept(AbstractTexture abstractTexture) {
		if (abstractTexture.isSetGenericApplicationPropertyOfTexture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTexture.getGenericApplicationPropertyOfTexture()))
				accept(ade);

		accept((AbstractSurfaceData)abstractTexture);
	}	

	public void accept(Site site) {
		if (site.isSetGenericApplicationPropertyOfSite())
			for (ADEComponent ade : new ArrayList<ADEComponent>(site.getGenericApplicationPropertyOfSite()))
				accept(ade);

		accept((CityObject)site);
	}

	public void accept(AbstractBuilding abstractBuilding) {
		if (abstractBuilding.isSetOuterBuildingInstallation())
			for (BuildingInstallationProperty buildingInstallationProperty : new ArrayList<BuildingInstallationProperty>(abstractBuilding.getOuterBuildingInstallation()))
				accept(buildingInstallationProperty);

		if (abstractBuilding.isSetInteriorBuildingInstallation())
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : new ArrayList<IntBuildingInstallationProperty>(abstractBuilding.getInteriorBuildingInstallation())) 
				accept(intBuildingInstallationProperty);

		if (abstractBuilding.isSetBoundedBySurface())
			for (BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<BoundarySurfaceProperty>(abstractBuilding.getBoundedBySurface()))
				accept(boundarySurfaceProperty);

		if (abstractBuilding.isSetConsistsOfBuildingPart())
			for (BuildingPartProperty buildingPartProperty : new ArrayList<BuildingPartProperty>(abstractBuilding.getConsistsOfBuildingPart()))
				accept(buildingPartProperty);

		if (abstractBuilding.isSetInteriorRoom())
			for (InteriorRoomProperty interiorRoomProperty : new ArrayList<InteriorRoomProperty>(abstractBuilding.getInteriorRoom()))
				accept(interiorRoomProperty);

		if (abstractBuilding.isSetAddress())
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(abstractBuilding.getAddress()))
				accept(addressProperty);

		if (abstractBuilding.isSetGenericApplicationPropertyOfAbstractBuilding())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBuilding.getGenericApplicationPropertyOfAbstractBuilding()))
				accept(ade);

		accept((Site)abstractBuilding);
	}

	public void accept(BoundarySurface boundarySurface) {
		if (boundarySurface.isSetOpening())
			for (OpeningProperty openingProperty : new ArrayList<OpeningProperty>(boundarySurface.getOpening()))
				accept(openingProperty);

		if (boundarySurface.isSetGenericApplicationPropertyOfBoundarySurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(boundarySurface.getGenericApplicationPropertyOfBoundarySurface()))
				accept(ade);

		accept((CityObject)boundarySurface);
	}

	public void accept(Opening opening) {
		if (opening.isSetGenericApplicationPropertyOfOpening())
			for (ADEComponent ade : new ArrayList<ADEComponent>(opening.getGenericApplicationPropertyOfOpening()))
				accept(ade);

		accept((CityObject)opening);
	}

	public void accept(ReliefComponent reliefComponent) {
		if (reliefComponent.isSetGenericApplicationPropertyOfReliefComponent())
			for (ADEComponent ade : new ArrayList<ADEComponent>(reliefComponent.getGenericApplicationPropertyOfReliefComponent()))
				accept(ade);

		accept((CityObject)reliefComponent);
	}

	public void accept(TransportationObject transportationObject) {
		if (transportationObject.isSetGenericApplicationPropertyOfTransportationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(transportationObject.getGenericApplicationPropertyOfTransportationObject()))
				accept(ade);

		accept((CityObject)transportationObject);
	}

	public void accept(VegetationObject vegetationObject) {
		if (vegetationObject.isSetGenericApplicationPropertyOfVegetationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(vegetationObject.getGenericApplicationPropertyOfVegetationObject()))
				accept(ade);

		accept((CityObject)vegetationObject);
	}

	public void accept(WaterObject waterObject) {
		if (waterObject.isSetGenericApplicationPropertyOfWaterObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterObject.getGenericApplicationPropertyOfWaterObject()))
				accept(ade);

		accept((CityObject)waterObject);
	}

	public void accept(WaterBoundarySurface waterBoundarySurface) {
		if (waterBoundarySurface.isSetGenericApplicationPropertyOfWaterBoundarySurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterBoundarySurface.getGenericApplicationPropertyOfWaterBoundarySurface()))
				accept(ade);

		accept((CityObject)waterBoundarySurface);
	}

	public void accept(FeatureProperty<? extends AbstractFeature> featureProperty) {
		if (featureProperty.isSetFeature() && shouldWalk && visited.add(featureProperty.getFeature()))
			featureProperty.getFeature().visit(this);

		if (featureProperty.isSetGenericADEComponent())
			accept(featureProperty.getGenericADEComponent());
	}

	public void accept(Association<? extends AbstractFeature> association) {
		if (association.isSetObject() && shouldWalk && visited.add(association.getObject()))
			association.getObject().visit(this);

		if (association.isSetGenericADEComponent())
			accept(association.getGenericADEComponent());
	}
	
	public void accept(RectifiedGridCoverage rectifiedGridCoverage) {
		accept((AbstractDiscreteCoverage)rectifiedGridCoverage);
	}

	public void accept(Appearance appearance) {
		if (appearance.isSetSurfaceDataMember())
			for (SurfaceDataProperty surfaceDataProperty : new ArrayList<SurfaceDataProperty>(appearance.getSurfaceDataMember()))
				accept(surfaceDataProperty);

		if (appearance.isSetGenericApplicationPropertyOfAppearance())
			for (ADEComponent ade : new ArrayList<ADEComponent>(appearance.getGenericApplicationPropertyOfAppearance()))
				accept(ade);

		accept((AbstractFeature)appearance);
	}	

	public void accept(GeoreferencedTexture georeferencedTexture) {
		if (georeferencedTexture.isSetGenericApplicationPropertyOfGeoreferencedTexture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(georeferencedTexture.getGenericApplicationPropertyOfGeoreferencedTexture()))
				accept(ade);

		accept((AbstractTexture)georeferencedTexture);	
	}

	public void accept(ParameterizedTexture parameterizedTexture) {
		if (parameterizedTexture.isSetTarget()) {
			for (TextureAssociation textureAssociation : new ArrayList<TextureAssociation>(parameterizedTexture.getTarget())) {
				if (textureAssociation.isSetTextureParameterization() && shouldWalk && visited.add(textureAssociation.getTextureParameterization())) {
					TextureParameterization textureParameterization = textureAssociation.getTextureParameterization();

					if (textureParameterization instanceof TexCoordGen) {
						TexCoordGen texCoordGen = (TexCoordGen)textureParameterization;
						if (texCoordGen.isSetGenericApplicationPropertyOfTexCoordGen()) 
							for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordGen.getGenericApplicationPropertyOfTexCoordGen()))
								accept(ade);
					} 

					else if (textureParameterization instanceof TexCoordList) {
						TexCoordList texCoordList = (TexCoordList)textureParameterization;
						if (texCoordList.isSetGenericApplicationPropertyOfTexCoordList()) 
							for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordList.getGenericApplicationPropertyOfTexCoordList()))
								accept(ade);
					}

					if (textureParameterization.isSetGenericADEComponent())
						for (ADEComponent ade : new ArrayList<ADEComponent>(textureParameterization.getGenericADEComponent()))
							accept(ade);

					if (textureParameterization.isSetGenericApplicationPropertyOfTextureParameterization()) 
						for (ADEComponent ade : new ArrayList<ADEComponent>(textureParameterization.getGenericApplicationPropertyOfTextureParameterization()))
							accept(ade);
				}
			}
		}

		if (parameterizedTexture.isSetGenericApplicationPropertyOfParameterizedTexture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(parameterizedTexture.getGenericApplicationPropertyOfParameterizedTexture()))
				accept(ade);

		accept((AbstractTexture)parameterizedTexture);
	}

	public void accept(X3DMaterial x3dMaterial) {
		if (x3dMaterial.isSetGenericApplicationPropertyOfX3DMaterial())
			for (ADEComponent ade : new ArrayList<ADEComponent>(x3dMaterial.getGenericApplicationPropertyOfX3DMaterial()))
				accept(ade);

		accept((AbstractSurfaceData)x3dMaterial);
	}

	public void accept(BuildingFurniture buildingFurniture) {
		if (buildingFurniture.isSetGenericApplicationPropertyOfBuildingFurniture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingFurniture.getGenericApplicationPropertyOfBuildingFurniture()))
				accept(ade);

		accept((CityObject)buildingFurniture);
	}

	public void accept(Building building) {
		if (building.isSetGenericApplicationPropertyOfBuilding())
			for (ADEComponent ade : new ArrayList<ADEComponent>(building.getGenericApplicationPropertyOfBuilding()))
				accept(ade);

		accept((AbstractBuilding)building);
	}

	public void accept(BuildingInstallation buildingInstallation) {
		if (buildingInstallation.isSetGenericApplicationPropertyOfBuildingInstallation())
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingInstallation.getGenericApplicationPropertyOfBuildingInstallation()))
				accept(ade);

		accept((CityObject)buildingInstallation);
	}

	public void accept(BuildingPart buildingPart) {
		if (buildingPart.isSetGenericApplicationPropertyOfBuildingPart())
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingPart.getGenericApplicationPropertyOfBuildingPart()))
				accept(ade);

		accept((AbstractBuilding)buildingPart);
	}

	public void accept(CeilingSurface ceilingSurface) {
		if (ceilingSurface.isSetGenericApplicationPropertyOfCeilingSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(ceilingSurface.getGenericApplicationPropertyOfCeilingSurface()))
				accept(ade);

		accept((BoundarySurface)ceilingSurface);
	}

	public void accept(ClosureSurface closureSurface) {
		if (closureSurface.isSetGenericApplicationPropertyOfClosureSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(closureSurface.getGenericApplicationPropertyOfClosureSurface()))
				accept(ade);

		accept((BoundarySurface)closureSurface);
	}

	public void accept(Door door) {
		if (door.isSetAddress())
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(door.getAddress()))
				accept(addressProperty);

		if (door.isSetGenericApplicationPropertyOfDoor())
			for (ADEComponent ade : new ArrayList<ADEComponent>(door.getGenericApplicationPropertyOfDoor()))
				accept(ade);

		accept((Opening)door);
	}

	public void accept(FloorSurface floorSurface) {
		if (floorSurface.isSetGenericApplicationPropertyOfFloorSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(floorSurface.getGenericApplicationPropertyOfFloorSurface()))
				accept(ade);

		accept((BoundarySurface)floorSurface);
	}

	public void accept(GroundSurface groundSurface) {
		if (groundSurface.isSetGenericApplicationPropertyOfGroundSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(groundSurface.getGenericApplicationPropertyOfGroundSurface()))
				accept(ade);

		accept((BoundarySurface)groundSurface);
	}

	public void accept(IntBuildingInstallation intBuildingInstallation) {
		if (intBuildingInstallation.isSetGenericApplicationPropertyOfIntBuildingInstallation())
			for (ADEComponent ade : new ArrayList<ADEComponent>(intBuildingInstallation.getGenericApplicationPropertyOfIntBuildingInstallation()))
				accept(ade);

		accept((CityObject)intBuildingInstallation);
	}

	public void accept(InteriorWallSurface interiorWallSurface) {
		if (interiorWallSurface.isSetGenericApplicationPropertyOfInteriorWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface()))
				accept(ade);

		accept((BoundarySurface)interiorWallSurface);
	}

	public void accept(RoofSurface roofSurface) {
		if (roofSurface.isSetGenericApplicationPropertyOfRoofSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(roofSurface.getGenericApplicationPropertyOfRoofSurface()))
				accept(ade);

		accept((BoundarySurface)roofSurface);
	}

	public void accept(Room room) {
		if (room.isSetBoundedBySurface())
			for (BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<BoundarySurfaceProperty>(room.getBoundedBySurface()))
				accept(boundarySurfaceProperty);

		if (room.isSetInteriorFurniture())
			for (InteriorFurnitureProperty interiorFurnitureProperty : new ArrayList<InteriorFurnitureProperty>(room.getInteriorFurniture()))
				accept(interiorFurnitureProperty);

		if (room.isSetRoomInstallation())
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : new ArrayList<IntBuildingInstallationProperty>(room.getRoomInstallation()))
				accept(intBuildingInstallationProperty);

		if (room.isSetGenericApplicationPropertyOfRoom())
			for (ADEComponent ade : new ArrayList<ADEComponent>(room.getGenericApplicationPropertyOfRoom()))
				accept(ade);

		accept((CityObject)room);
	}

	public void accept(WallSurface wallSurface) {
		if (wallSurface.isSetGenericApplicationPropertyOfWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(wallSurface.getGenericApplicationPropertyOfWallSurface()))
				accept(ade);

		accept((BoundarySurface)wallSurface);
	}

	public void accept(Window window) {
		if (window.isSetGenericApplicationPropertyOfWindow())
			for (ADEComponent ade : new ArrayList<ADEComponent>(window.getGenericApplicationPropertyOfWindow()))
				accept(ade);

		accept((Opening)window);
	}

	public void accept(CityFurniture cityFurniture) {
		if (cityFurniture.isSetGenericApplicationPropertyOfCityFurniture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityFurniture.getGenericApplicationPropertyOfCityFurniture()))
				accept(ade);

		accept((CityObject)cityFurniture);
	}

	public void accept(CityObjectGroup cityObjectGroup) {
		if (cityObjectGroup.isSetGroupMember())
			for (CityObjectGroupMember cityObjectGroupMember : new ArrayList<CityObjectGroupMember>(cityObjectGroup.getGroupMember()))
				accept(cityObjectGroupMember);

		if (cityObjectGroup.isSetGroupParent())
			accept(cityObjectGroup.getGroupParent());

		if (cityObjectGroup.isSetGenericApplicationPropertyOfCityObjectGroup())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityObjectGroup.getGenericApplicationPropertyOfCityObjectGroup()))
				accept(ade);

		accept((CityObject)cityObjectGroup);
	}

	public void accept(Address address) {
		if (address.isSetGenericApplicationPropertyOfAddress())
			for (ADEComponent ade : new ArrayList<ADEComponent>(address.getGenericApplicationPropertyOfAddress()))
				accept(ade);

		accept((AbstractFeature)address);
	}

	public void accept(CityModel cityModel) {
		if (cityModel.isSetCityObjectMember())
			for (CityObjectMember member : new ArrayList<CityObjectMember>(cityModel.getCityObjectMember()))
				accept(member);

		if (cityModel.isSetAppearanceMember())
			for (AppearanceProperty member : new ArrayList<AppearanceProperty>(cityModel.getAppearanceMember()))
				accept(member);

		if (cityModel.isSetGenericApplicationPropertyOfCityModel())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityModel.getGenericApplicationPropertyOfCityModel()))
				accept(ade);

		accept((AbstractFeatureCollection)cityModel);
	}

	public void accept(GenericCityObject genericCityObject) {
		accept((CityObject)genericCityObject);
	}

	public void accept(LandUse landUse) {
		if (landUse.isSetGenericApplicationPropertyOfLandUse())
			for (ADEComponent ade : new ArrayList<ADEComponent>(landUse.getGenericApplicationPropertyOfLandUse()))
				accept(ade);

		accept((CityObject)landUse);
	}

	public void accept(BreaklineRelief breaklineRelief) {
		if (breaklineRelief.isSetGenericApplicationPropertyOfBreaklineRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(breaklineRelief.getGenericApplicationPropertyOfBreaklineRelief()))
				accept(ade);

		accept((ReliefComponent)breaklineRelief);
	}

	public void accept(MassPointRelief massPointRelief) {
		if (massPointRelief.isSetGenericApplicationPropertyOfMassPointRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(massPointRelief.getGenericApplicationPropertyOfMassPointRelief()))
				accept(ade);

		accept((ReliefComponent)massPointRelief);
	}

	public void accept(RasterRelief rasterRelief) {
		if (rasterRelief.isSetGrid())
			accept(rasterRelief.getGrid());
		
		if (rasterRelief.isSetGenericApplicationPropertyOfRasterRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(rasterRelief.getGenericApplicationPropertyOfRasterRelief()))
				accept(ade);

		accept((ReliefComponent)rasterRelief);
	}

	public void accept(ReliefFeature reliefFeature) {
		if (reliefFeature.isSetReliefComponent())
			for (ReliefComponentProperty reliefComponentProperty : new ArrayList<ReliefComponentProperty>(reliefFeature.getReliefComponent()))
				accept(reliefComponentProperty);

		if (reliefFeature.isSetGenericApplicationPropertyOfReliefFeature())
			for (ADEComponent ade : new ArrayList<ADEComponent>(reliefFeature.getGenericApplicationPropertyOfReliefFeature()))
				accept(ade);

		accept((CityObject)reliefFeature);
	}

	public void accept(TINRelief tinRelief) {
		if (tinRelief.isSetGenericApplicationPropertyOfTinRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(tinRelief.getGenericApplicationPropertyOfTinRelief()))
				accept(ade);

		accept((ReliefComponent)tinRelief);
	}

	public void accept(AuxiliaryTrafficArea auxiliaryTrafficArea) {
		if (auxiliaryTrafficArea.isSetGenericApplicationPropertyOfAuxiliaryTrafficArea())
			for (ADEComponent ade : new ArrayList<ADEComponent>(auxiliaryTrafficArea.getGenericApplicationPropertyOfAuxiliaryTrafficArea()))
				accept(ade);

		accept((TransportationObject)auxiliaryTrafficArea);
	}

	public void accept(Railway railway) {
		if (railway.isSetGenericApplicationPropertyOfRailway())
			for (ADEComponent ade : new ArrayList<ADEComponent>(railway.getGenericApplicationPropertyOfRailway()))
				accept(ade);

		accept((TransportationComplex)railway);
	}
	
	public void accept(Road road) {
		if (road.isSetGenericApplicationPropertyOfRoad())
			for (ADEComponent ade : new ArrayList<ADEComponent>(road.getGenericApplicationPropertyOfRoad()))
				accept(ade);

		accept((TransportationComplex)road);
	}

	public void accept(Square square) {
		if (square.isSetGenericApplicationPropertyOfSquare())
			for (ADEComponent ade : new ArrayList<ADEComponent>(square.getGenericApplicationPropertyOfSquare()))
				accept(ade);

		accept((TransportationComplex)square);
	}

	public void accept(Track track) {
		if (track.isSetGenericApplicationPropertyOfTrack())
			for (ADEComponent ade : new ArrayList<ADEComponent>(track.getGenericApplicationPropertyOfTrack()))
				accept(ade);

		accept((TransportationComplex)track);
	}

	public void accept(TrafficArea trafficArea) {
		if (trafficArea.isSetGenericApplicationPropertyOfTrafficArea())
			for (ADEComponent ade : new ArrayList<ADEComponent>(trafficArea.getGenericApplicationPropertyOfTrafficArea()))
				accept(ade);

		accept((TransportationObject)trafficArea);
	}

	public void accept(TransportationComplex transportationComplex) {
		if (transportationComplex.isSetTrafficArea())
			for (TrafficAreaProperty trafficAreaProperty : new ArrayList<TrafficAreaProperty>(transportationComplex.getTrafficArea()))
				accept(trafficAreaProperty);

		if (transportationComplex.isSetAuxiliaryTrafficArea())
			for (AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty : new ArrayList<AuxiliaryTrafficAreaProperty>(transportationComplex.getAuxiliaryTrafficArea()))
				accept(auxiliaryTrafficAreaProperty);

		if (transportationComplex.isSetGenericApplicationPropertyOfTransportationComplex())
			for (ADEComponent ade : new ArrayList<ADEComponent>(transportationComplex.getGenericApplicationPropertyOfTransportationComplex()))
				accept(ade);

		accept((TransportationObject)transportationComplex);
	}

	public void accept(PlantCover plantCover) {
		if (plantCover.isSetGenericApplicationPropertyOfPlantCover())
			for (ADEComponent ade : new ArrayList<ADEComponent>(plantCover.getGenericApplicationPropertyOfPlantCover()))
				accept(ade);

		accept((VegetationObject)plantCover);
	}

	public void accept(SolitaryVegetationObject solitaryVegetationObject) {
		if (solitaryVegetationObject.isSetGenericApplicationPropertyOfSolitaryVegetationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(solitaryVegetationObject.getGenericApplicationPropertyOfVegetationObject()))
				accept(ade);

		accept((VegetationObject)solitaryVegetationObject);
	}

	public void accept(WaterBody waterBody) {
		if (waterBody.isSetBoundedBySurface())
			for (BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty : new ArrayList<BoundedByWaterSurfaceProperty>(waterBody.getBoundedBySurface()))
				accept(boundedByWaterSurfaceProperty);

		if (waterBody.isSetGenericApplicationPropertyOfWaterBody())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterBody.getGenericApplicationPropertyOfWaterBody()))
				accept(ade);

		accept((WaterObject)waterBody);
	}

	public void accept(WaterClosureSurface waterClosureSurface) {
		if (waterClosureSurface.isSetGenericApplicationPropertyOfWaterClosureSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterClosureSurface.getGenericApplicationPropertyOfWaterClosureSurface()))
				accept(ade);

		accept((WaterBoundarySurface)waterClosureSurface);
	}

	public void accept(WaterGroundSurface waterGroundSurface) {
		if (waterGroundSurface.isSetGenericApplicationPropertyOfWaterGroundSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterGroundSurface.getGenericApplicationPropertyOfWaterGroundSurface()))
				accept(ade);

		accept((WaterBoundarySurface)waterGroundSurface);
	}

	public void accept(WaterSurface waterSurface) {
		if (waterSurface.isSetGenericApplicationPropertyOfWaterSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterSurface.getGenericApplicationPropertyOfWaterSurface()))
				accept(ade);

		accept((WaterBoundarySurface)waterSurface);
	}

	public void accept(Element element, ElementDecl decl) {
		iterateNodeList(element, decl);
	}

	public void accept(ADEComponent adeComponent) {
		if (adeComponent.isSetContent() && shouldWalk && visited.add(adeComponent.getContent()) && schemaHandler != null)
			adeComponent(adeComponent.getContent(), null); 
	}

	protected void adeComponent(Element element, ElementDecl decl) {
		Schema schema = schemaHandler.getSchema(element.getNamespaceURI());

		if (schema != null) {
			decl = schema.getElementDecl(element.getLocalName(), decl);
			if (decl != null && decl.isFeature())
				accept(element, decl);
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

	protected void accept(CompositeValue compositeValue) {
		if (compositeValue.isSetValueComponent()) {
			for (ValueProperty valueProperty : compositeValue.getValueComponent()) {
				if (valueProperty.isSetValue())
					accept(valueProperty.getValue());
			}
		}

		if (compositeValue.isSetValueComponents()) {
			ValueArrayProperty valueArrayProperty = compositeValue.getValueComponents();
			if (valueArrayProperty.isSetValue()) {
				for (Value value : valueArrayProperty.getValue())
					accept(value);
			}
		}
	}
	
	protected void accept(Value value) {
		if (value.isSetGMLObject()) {
			AbstractGML abstractGML = value.getGMLObject();
			if (abstractGML instanceof AbstractFeature && shouldWalk && visited.add(abstractGML))
				((AbstractFeature)abstractGML).visit(this);		
		} else if (value.isSetValueObject()) {
			ValueObject valueObject = value.getValueObject();
			if (valueObject.isSetCompositeValue())
				accept((CompositeValue)valueObject.getCompositeValue());
		} else if (value.isSetGenericValueObject()) {
			GenericValueObject genericValueObject = value.getGenericValueObject();
			if (genericValueObject.isSetContent() && shouldWalk && visited.add(genericValueObject.getContent()))
				adeComponent(genericValueObject.getContent(), null);
		}
	}
}
