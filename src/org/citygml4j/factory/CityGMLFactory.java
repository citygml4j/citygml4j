package org.citygml4j.factory;

import org.citygml4j.geometry.Matrix;
import org.citygml4j.impl.citygml.appearance.AppearanceImpl;
import org.citygml4j.impl.citygml.appearance.AppearanceMemberImpl;
import org.citygml4j.impl.citygml.appearance.AppearancePropertyImpl;
import org.citygml4j.impl.citygml.appearance.ColorImpl;
import org.citygml4j.impl.citygml.appearance.ColorPlusOpacityImpl;
import org.citygml4j.impl.citygml.appearance.GeoreferencedTextureImpl;
import org.citygml4j.impl.citygml.appearance.ParameterizedTextureImpl;
import org.citygml4j.impl.citygml.appearance.SurfaceDataPropertyImpl;
import org.citygml4j.impl.citygml.appearance.TexCoordGenImpl;
import org.citygml4j.impl.citygml.appearance.TexCoordListImpl;
import org.citygml4j.impl.citygml.appearance.TextureAssociationImpl;
import org.citygml4j.impl.citygml.appearance.TextureCoordinatesImpl;
import org.citygml4j.impl.citygml.appearance.WorldToTextureImpl;
import org.citygml4j.impl.citygml.appearance.X3DMaterialImpl;
import org.citygml4j.impl.citygml.building.BoundarySurfacePropertyImpl;
import org.citygml4j.impl.citygml.building.BuildingFurnitureImpl;
import org.citygml4j.impl.citygml.building.BuildingImpl;
import org.citygml4j.impl.citygml.building.BuildingInstallationImpl;
import org.citygml4j.impl.citygml.building.BuildingInstallationPropertyImpl;
import org.citygml4j.impl.citygml.building.BuildingPartImpl;
import org.citygml4j.impl.citygml.building.BuildingPartPropertyImpl;
import org.citygml4j.impl.citygml.building.CeilingSurfaceImpl;
import org.citygml4j.impl.citygml.building.ClosureSurfaceImpl;
import org.citygml4j.impl.citygml.building.DoorImpl;
import org.citygml4j.impl.citygml.building.FloorSurfaceImpl;
import org.citygml4j.impl.citygml.building.GroundSurfaceImpl;
import org.citygml4j.impl.citygml.building.IntBuildingInstallationImpl;
import org.citygml4j.impl.citygml.building.IntBuildingInstallationPropertyImpl;
import org.citygml4j.impl.citygml.building.InteriorFurniturePropertyImpl;
import org.citygml4j.impl.citygml.building.InteriorRoomPropertyImpl;
import org.citygml4j.impl.citygml.building.InteriorWallSurfaceImpl;
import org.citygml4j.impl.citygml.building.OpeningPropertyImpl;
import org.citygml4j.impl.citygml.building.RoofSurfaceImpl;
import org.citygml4j.impl.citygml.building.RoomImpl;
import org.citygml4j.impl.citygml.building.WallSurfaceImpl;
import org.citygml4j.impl.citygml.building.WindowImpl;
import org.citygml4j.impl.citygml.cityfurniture.CityFurnitureImpl;
import org.citygml4j.impl.citygml.cityobjectgroup.CityObjectGroupImpl;
import org.citygml4j.impl.citygml.cityobjectgroup.CityObjectGroupMemberImpl;
import org.citygml4j.impl.citygml.cityobjectgroup.CityObjectGroupParentImpl;
import org.citygml4j.impl.citygml.core.AddressImpl;
import org.citygml4j.impl.citygml.core.AddressPropertyImpl;
import org.citygml4j.impl.citygml.core.CityModelImpl;
import org.citygml4j.impl.citygml.core.CityObjectMemberImpl;
import org.citygml4j.impl.citygml.core.ExternalObjectImpl;
import org.citygml4j.impl.citygml.core.ExternalReferenceImpl;
import org.citygml4j.impl.citygml.core.GeneralizationRelationImpl;
import org.citygml4j.impl.citygml.core.ImplicitGeometryImpl;
import org.citygml4j.impl.citygml.core.ImplicitRepresentationPropertyImpl;
import org.citygml4j.impl.citygml.core.TransformationMatrix2x2Impl;
import org.citygml4j.impl.citygml.core.TransformationMatrix3x4Impl;
import org.citygml4j.impl.citygml.core.TransformationMatrix4x4Impl;
import org.citygml4j.impl.citygml.core.XalAddressPropertyImpl;
import org.citygml4j.impl.citygml.generics.DateAttributeImpl;
import org.citygml4j.impl.citygml.generics.DoubleAttributeImpl;
import org.citygml4j.impl.citygml.generics.GenericCityObjectImpl;
import org.citygml4j.impl.citygml.generics.IntAttributeImpl;
import org.citygml4j.impl.citygml.generics.StringAttributeImpl;
import org.citygml4j.impl.citygml.generics.UriAttributeImpl;
import org.citygml4j.impl.citygml.landuse.LandUseImpl;
import org.citygml4j.impl.citygml.relief.BreaklineReliefImpl;
import org.citygml4j.impl.citygml.relief.MassPointReliefImpl;
import org.citygml4j.impl.citygml.relief.RasterReliefImpl;
import org.citygml4j.impl.citygml.relief.ReliefComponentPropertyImpl;
import org.citygml4j.impl.citygml.relief.ReliefFeatureImpl;
import org.citygml4j.impl.citygml.relief.TINReliefImpl;
import org.citygml4j.impl.citygml.relief.TinPropertyImpl;
import org.citygml4j.impl.citygml.texturedsurface._AppearancePropertyImpl;
import org.citygml4j.impl.citygml.texturedsurface._ColorImpl;
import org.citygml4j.impl.citygml.texturedsurface._MaterialImpl;
import org.citygml4j.impl.citygml.texturedsurface._SimpleTextureImpl;
import org.citygml4j.impl.citygml.texturedsurface._TexturedSurfaceImpl;
import org.citygml4j.impl.citygml.transportation.AuxiliaryTrafficAreaImpl;
import org.citygml4j.impl.citygml.transportation.AuxiliaryTrafficAreaPropertyImpl;
import org.citygml4j.impl.citygml.transportation.RailwayImpl;
import org.citygml4j.impl.citygml.transportation.RoadImpl;
import org.citygml4j.impl.citygml.transportation.SquareImpl;
import org.citygml4j.impl.citygml.transportation.TrackImpl;
import org.citygml4j.impl.citygml.transportation.TrafficAreaImpl;
import org.citygml4j.impl.citygml.transportation.TrafficAreaPropertyImpl;
import org.citygml4j.impl.citygml.transportation.TransportationComplexImpl;
import org.citygml4j.impl.citygml.vegetation.PlantCoverImpl;
import org.citygml4j.impl.citygml.vegetation.SolitaryVegetationObjectImpl;
import org.citygml4j.impl.citygml.waterbody.BoundedByWaterSurfacePropertyImpl;
import org.citygml4j.impl.citygml.waterbody.WaterBodyImpl;
import org.citygml4j.impl.citygml.waterbody.WaterClosureSurfaceImpl;
import org.citygml4j.impl.citygml.waterbody.WaterGroundSurfaceImpl;
import org.citygml4j.impl.citygml.waterbody.WaterSurfaceImpl;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
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
import org.citygml4j.model.citygml.appearance.TextureParameterization;
import org.citygml4j.model.citygml.appearance.WorldToTexture;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
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
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.ExternalObject;
import org.citygml4j.model.citygml.core.ExternalReference;
import org.citygml4j.model.citygml.core.GeneralizationRelation;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.TransformationMatrix2x2;
import org.citygml4j.model.citygml.core.TransformationMatrix3x4;
import org.citygml4j.model.citygml.core.TransformationMatrix4x4;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.citygml.generics.DateAttribute;
import org.citygml4j.model.citygml.generics.DoubleAttribute;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.generics.IntAttribute;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.citygml.generics.UriAttribute;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponent;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;
import org.citygml4j.model.citygml.texturedsurface._Appearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.gml.TriangulatedSurface;
import org.citygml4j.model.xal.AddressDetails;
import org.w3c.dom.Element;

public class CityGMLFactory {

	public CityGMLFactory() {
		
	}

	// Appearance module
	
	public Appearance createAppearance() {
		return new AppearanceImpl();
	}

	public AppearanceMember createAppearanceMember() {
		return new AppearanceMemberImpl();
	}
	
	public AppearanceMember createAppearanceMember(Appearance appearance) {
		AppearanceMember appearanceMember = new AppearanceMemberImpl();
		appearanceMember.setAppearance(appearance);
		return appearanceMember;
	}
	
	public AppearanceMember createAppearanceMember(String xlink) {
		AppearanceMember appearanceMember = new AppearanceMemberImpl();
		appearanceMember.setHref(xlink);
		return appearanceMember;
	}

	public AppearanceProperty createAppearanceProperty() {
		return new AppearancePropertyImpl();
	}
	
	public AppearanceProperty createAppearanceProperty(Appearance appearance) {
		AppearanceProperty appearanceProperty = new AppearancePropertyImpl();
		appearanceProperty.setAppearance(appearance);
		return appearanceProperty;
	}
	
	public AppearanceProperty createAppearanceProperty(String xlink) {
		AppearanceProperty appearanceProperty = new AppearancePropertyImpl();
		appearanceProperty.setHref(xlink);
		return appearanceProperty;
	}

	public Color createColor() {
		return new ColorImpl();
	}

	public Color createColor(Double red, Double green, Double blue) {
		return new ColorImpl(red, green, blue);
	}

	public ColorPlusOpacity createColorPlusOpacity() {
		return new ColorPlusOpacityImpl();
	}

	public ColorPlusOpacity createColorPlusOpacity(Color color, Double opacity) {
		return new ColorPlusOpacityImpl(color, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double red, Double green, Double blue, Double opacity) {
		return new ColorPlusOpacityImpl(red, green, blue, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double red, Double green, Double blue) {
		return new ColorPlusOpacityImpl(red, green, blue);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue, Double opacity) {
		return new ColorPlusOpacityImpl(defaultColorValue, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue) {
		return new ColorPlusOpacityImpl(defaultColorValue);
	}

	public GeoreferencedTexture createGeoreferencedTexture() {
		return new GeoreferencedTextureImpl();
	}

	public ParameterizedTexture createParameterizedTexture() {
		return new ParameterizedTextureImpl();
	}

	public SurfaceDataProperty createSurfaceDataProperty() {
		return new SurfaceDataPropertyImpl();
	}
	
	public SurfaceDataProperty createSurfaceDataProperty(AbstractSurfaceData abstractSurfaceData) {
		SurfaceDataProperty surfaceDataProperty = new SurfaceDataPropertyImpl();
		surfaceDataProperty.setSurfaceData(abstractSurfaceData);
		return surfaceDataProperty;
	}
	
	public SurfaceDataProperty createSurfaceDataProperty(String xlink) {
		SurfaceDataProperty surfaceDataProperty = new SurfaceDataPropertyImpl();
		surfaceDataProperty.setHref(xlink);
		return surfaceDataProperty;
	}

	public TexCoordGen createTexCoordGen() {
		return new TexCoordGenImpl();
	}

	public TexCoordList createTexCoordList() {
		return new TexCoordListImpl();
	}

	public TextureAssociation createTextureAssociation() {
		return new TextureAssociationImpl();
	}
	
	public TextureAssociation createTextureAssociation(TextureParameterization textureParameterization) {
		TextureAssociation textureAssociation = new TextureAssociationImpl();
		textureAssociation.setTextureParameterization(textureParameterization);
		return textureAssociation;
	}
	
	public TextureAssociation createTextureAssociation(String xlink) {
		TextureAssociation textureAssociation = new TextureAssociationImpl();
		textureAssociation.setHref(xlink);
		return textureAssociation;
	}

	public TextureCoordinates createTextureCoordinates() {
		return new TextureCoordinatesImpl();
	}

	public WorldToTexture createWorldToTexture() {
		return new WorldToTextureImpl();
	}

	public X3DMaterial createX3DMaterial() {
		return new X3DMaterialImpl();
	}

	// Building module
	
	public BoundarySurfaceProperty createBoundarySurfaceProperty() {
		return new BoundarySurfacePropertyImpl();
	}
	
	public BoundarySurfaceProperty createBoundarySurfaceProperty(BoundarySurface boundarySurface) {
		BoundarySurfaceProperty boundarySurfaceProperty = new BoundarySurfacePropertyImpl();
		boundarySurfaceProperty.setBoundarySurface(boundarySurface);
		return boundarySurfaceProperty;
	}
	
	public BoundarySurfaceProperty createBoundarySurfaceProperty(String xlink) {
		BoundarySurfaceProperty boundarySurfaceProperty = new BoundarySurfacePropertyImpl();
		boundarySurfaceProperty.setHref(xlink);
		return boundarySurfaceProperty;
	}

	public Building createBuilding() {
		return new BuildingImpl();
	}

	public BuildingFurniture createBuildingFurniture() {
		return new BuildingFurnitureImpl();
	}

	public BuildingInstallation createBuildingInstallation() {
		return new BuildingInstallationImpl();
	}

	public BuildingInstallationProperty createBuildingInstallationProperty() {
		return new BuildingInstallationPropertyImpl();
	}
	
	public BuildingInstallationProperty createBuildingInstallationProperty(BuildingInstallation buildingInstallation) {
		BuildingInstallationProperty buildingInstallationProperty = new BuildingInstallationPropertyImpl();
		buildingInstallationProperty.setBuildingInstallation(buildingInstallation);
		return buildingInstallationProperty;
	}
	
	public BuildingInstallationProperty createBuildingInstallationProperty(String xlink) {
		BuildingInstallationProperty buildingInstallationProperty = new BuildingInstallationPropertyImpl();
		buildingInstallationProperty.setHref(xlink);
		return buildingInstallationProperty;
	}

	public BuildingPart createBuildingPart() {
		return new BuildingPartImpl();
	}

	public BuildingPartProperty createBuildingPartProperty() {
		return new BuildingPartPropertyImpl();
	}
	
	public BuildingPartProperty createBuildingPartProperty(BuildingPart buildingPart) {
		BuildingPartProperty buildingPartProperty = new BuildingPartPropertyImpl();
		buildingPartProperty.setBuildingPart(buildingPart);
		return buildingPartProperty;
	}
	
	public BuildingPartProperty createBuildingPartProperty(String xlink) {
		BuildingPartProperty buildingPartProperty = new BuildingPartPropertyImpl();
		buildingPartProperty.setHref(xlink);
		return buildingPartProperty;
	}

	public CeilingSurface createCeilingSurface() {
		return new CeilingSurfaceImpl();
	}

	public ClosureSurface createClosureSurface() {
		return new ClosureSurfaceImpl();
	}

	public Door createDoor() {
		return new DoorImpl();
	}

	public FloorSurface createFloorSurface() {
		return new FloorSurfaceImpl();
	}

	public GroundSurface createGroundSurface() {
		return new GroundSurfaceImpl();
	}

	public IntBuildingInstallation createIntBuildingInstallation() {
		return new IntBuildingInstallationImpl();
	}

	public IntBuildingInstallationProperty createIntBuildingInstallationProperty() {
		return new IntBuildingInstallationPropertyImpl();
	}
	
	public IntBuildingInstallationProperty createIntBuildingInstallationProperty(IntBuildingInstallation intBuildingInstallation) {
		IntBuildingInstallationProperty intBuildingInstallationProperty = new IntBuildingInstallationPropertyImpl();
		intBuildingInstallationProperty.setIntBuildingInstallation(intBuildingInstallation);
		return intBuildingInstallationProperty;
	}
	
	public IntBuildingInstallationProperty createIntBuildingInstallationProperty(String xlink) {
		IntBuildingInstallationProperty intBuildingInstallationProperty = new IntBuildingInstallationPropertyImpl();
		intBuildingInstallationProperty.setHref(xlink);
		return intBuildingInstallationProperty;
	}

	public InteriorFurnitureProperty createInteriorFurnitureProperty() {
		return new InteriorFurniturePropertyImpl();
	}
	
	public InteriorFurnitureProperty createInteriorFurnitureProperty(BuildingFurniture buildingFurniture) {
		InteriorFurnitureProperty interiorFurnitureProperty = new InteriorFurniturePropertyImpl();
		interiorFurnitureProperty.setBuildingFurniture(buildingFurniture);
		return interiorFurnitureProperty;
	}
	
	public InteriorFurnitureProperty createInteriorFurnitureProperty(String xlink) {
		InteriorFurnitureProperty interiorFurnitureProperty = new InteriorFurniturePropertyImpl();
		interiorFurnitureProperty.setHref(xlink);
		return interiorFurnitureProperty;
	}

	public InteriorRoomProperty createInteriorRoomProperty() {
		return new InteriorRoomPropertyImpl();
	}
	
	public InteriorRoomProperty createInteriorRoomProperty(Room room) {
		InteriorRoomProperty interiorRoomProperty = new InteriorRoomPropertyImpl();
		interiorRoomProperty.setRoom(room);
		return interiorRoomProperty;
	}
	
	public InteriorRoomProperty createInteriorRoomProperty(String xlink) {
		InteriorRoomProperty interiorRoomProperty = new InteriorRoomPropertyImpl();
		interiorRoomProperty.setHref(xlink);
		return interiorRoomProperty;
	}

	public InteriorWallSurface createInteriorWallSurface() {
		return new InteriorWallSurfaceImpl();
	}

	public OpeningProperty createOpeningProperty() {
		return new OpeningPropertyImpl();
	}
	
	public OpeningProperty createOpeningProperty(Opening opening) {
		OpeningProperty openingProperty = new OpeningPropertyImpl();
		openingProperty.setOpening(opening);
		return openingProperty;
	}
	
	public OpeningProperty createOpeningProperty(String xlink) {
		OpeningProperty openingProperty = new OpeningPropertyImpl();
		openingProperty.setHref(xlink);
		return openingProperty;
	}

	public RoofSurface createRoofSurface() {
		return new RoofSurfaceImpl();
	}

	public Room createRoom() {
		return new RoomImpl();
	}

	public WallSurface createWallSurface() {
		return new WallSurfaceImpl();
	}

	public Window createWindow() {
		return new WindowImpl();
	}

	// CityFurniture module
	
	public CityFurniture createCityFurniture() {
		return new CityFurnitureImpl();
	}

	// CityObjectGroup module
	
	public CityObjectGroup createCityObjectGroup() {
		return new CityObjectGroupImpl();
	}

	public CityObjectGroupMember createCityObjectGroupMember() {
		return new CityObjectGroupMemberImpl();
	}
	
	public CityObjectGroupMember createCityObjectGroupMember(CityObject cityObject) {
		CityObjectGroupMember cityObjectGroupMember = new CityObjectGroupMemberImpl();
		cityObjectGroupMember.setCityObject(cityObject);
		return cityObjectGroupMember;
	}
	
	public CityObjectGroupMember createCityObjectGroupMember(String xlink) {
		CityObjectGroupMember cityObjectGroupMember = new CityObjectGroupMemberImpl();
		cityObjectGroupMember.setHref(xlink);
		return cityObjectGroupMember;
	}

	public CityObjectGroupParent createCityObjectGroupParent() {
		return new CityObjectGroupParentImpl();
	}
	
	public CityObjectGroupParent createCityObjectGroupParent(CityObject cityObject) {
		CityObjectGroupParent cityObjectGroupParent = new CityObjectGroupParentImpl();
		cityObjectGroupParent.setCityObject(cityObject);
		return cityObjectGroupParent;
	}
	
	public CityObjectGroupParent createCityObjectGroupParent(String xlink) {
		CityObjectGroupParent cityObjectGroupParent = new CityObjectGroupParentImpl();
		cityObjectGroupParent.setHref(xlink);
		return cityObjectGroupParent;
	}

	// Core module

	public Address createAddress() {
		return new AddressImpl();
	}

	public AddressProperty createAddressProperty() {
		return new AddressPropertyImpl();
	}
	
	public AddressProperty createAddressProperty(Address address) {
		AddressProperty addressProperty = new AddressPropertyImpl();
		addressProperty.setAddress(address);
		return addressProperty;
	}
	
	public AddressProperty createAddressProperty(String xlink) {
		AddressProperty addressProperty = new AddressPropertyImpl();
		addressProperty.setHref(xlink);
		return addressProperty;
	}

	public CityModel createCityModel() {
		return new CityModelImpl();
	}

	public CityObjectMember createCityObjectMember() {
		return new CityObjectMemberImpl();
	}
	
	public CityObjectMember createCityObjectMember(CityObject cityObject) {
		CityObjectMember cityObjectMember = new CityObjectMemberImpl();
		cityObjectMember.setCityObject(cityObject);
		return cityObjectMember;
	}
	
	public CityObjectMember createCityObjectMember(String xlink) {
		CityObjectMember cityObjectMember = new CityObjectMemberImpl();
		cityObjectMember.setHref(xlink);
		return cityObjectMember;
	}

	public ExternalObject createExternalObject() {
		return new ExternalObjectImpl();
	}

	public ExternalReference createExternalReference() {
		return new ExternalReferenceImpl();
	}

	public GeneralizationRelation createGeneralizationRelation() {
		return new GeneralizationRelationImpl();
	}
	
	public GeneralizationRelation createGeneralizationRelation(CityObject cityObject) {
		GeneralizationRelation generalizationRelation = new GeneralizationRelationImpl();
		generalizationRelation.setCityObject(cityObject);
		return generalizationRelation;
	}
	
	public GeneralizationRelation createGeneralizationRelation(String xlink) {
		GeneralizationRelation generalizationRelation = new GeneralizationRelationImpl();
		generalizationRelation.setHref(xlink);
		return generalizationRelation;
	}
	
	public ADEComponent createADEComponent() {
		return new ADEComponent();
	}

	public ADEComponent createADEComponent(Element content) {
		return new ADEComponent(content);
	}
	
	public ImplicitGeometry createImplicitGeometry() {
		return new ImplicitGeometryImpl();
	}

	public ImplicitRepresentationProperty createImplicitRepresentationProperty() {
		return new ImplicitRepresentationPropertyImpl();
	}
	
	public ImplicitRepresentationProperty createImplicitRepresentationProperty(ImplicitGeometry implicitGeometry) {
		ImplicitRepresentationProperty implicitRepresentationProperty = new ImplicitRepresentationPropertyImpl();
		implicitRepresentationProperty.setImplicitGeometry(implicitGeometry);
		return implicitRepresentationProperty;
	}
	
	public ImplicitRepresentationProperty createImplicitRepresentationProperty(String xlink) {
		ImplicitRepresentationProperty implicitRepresentationProperty = new ImplicitRepresentationPropertyImpl();
		implicitRepresentationProperty.setHref(xlink);
		return implicitRepresentationProperty;
	}

	public TransformationMatrix2x2 createTransformationMatrix2x2() {
		return new TransformationMatrix2x2Impl();
	}

	public TransformationMatrix2x2 createTransformationMatrix2x2(Matrix matrix) {
		return new TransformationMatrix2x2Impl(matrix);
	}

	public TransformationMatrix3x4 createTransformationMatrix3x4() {
		return new TransformationMatrix3x4Impl();
	}

	public TransformationMatrix3x4 createTransformationMatrix3x4(Matrix matrix) {
		return new TransformationMatrix3x4Impl(matrix);
	}

	public TransformationMatrix4x4 createTransformationMatrix4x4() {
		return new TransformationMatrix4x4Impl();
	}

	public TransformationMatrix4x4 createTransformationMatrix4x4(Matrix matrix) {
		return new TransformationMatrix4x4Impl(matrix);
	}

	public XalAddressProperty createXalAddressProperty() {
		return new XalAddressPropertyImpl();
	}
	
	public XalAddressProperty createXalAddressProperty(AddressDetails addressDetails) {
		XalAddressProperty xalAddressProperty = new XalAddressPropertyImpl();
		xalAddressProperty.setAddressDetails(addressDetails);
		return xalAddressProperty;
	}

	// Generics module
	
	public GenericCityObject createGenericCityObject() {
		return new GenericCityObjectImpl();
	}

	public DateAttribute createDateAttribute() {
		return new DateAttributeImpl();
	}

	public DoubleAttribute createDoubleAttribute() {
		return new DoubleAttributeImpl();
	}

	public IntAttribute createIntAttribute() {
		return new IntAttributeImpl();
	}

	public StringAttribute createStringAttribute() {
		return new StringAttributeImpl();
	}

	public UriAttribute createUriAttribute() {
		return new UriAttributeImpl();
	}

	// LandUse module
	
	public LandUse createLandUse() {
		return new LandUseImpl();
	}

	// Relief module
	
	public BreaklineRelief createBreaklineRelief() {
		return new BreaklineReliefImpl();
	}

	public MassPointRelief createMassPointRelief() {
		return new MassPointReliefImpl();
	}

	public RasterRelief createRasterRelief() {
		return new RasterReliefImpl();
	}

	public ReliefComponentProperty createReliefComponentProperty() {
		return new ReliefComponentPropertyImpl();
	}
	
	public ReliefComponentProperty createReliefComponentProperty(ReliefComponent reliefComponent) {
		ReliefComponentProperty reliefComponentProperty = new ReliefComponentPropertyImpl();
		reliefComponentProperty.setReliefComponent(reliefComponent);
		return reliefComponentProperty;
	}
	
	public ReliefComponentProperty createReliefComponentProperty(String xlink) {
		ReliefComponentProperty reliefComponentProperty = new ReliefComponentPropertyImpl();
		reliefComponentProperty.setHref(xlink);
		return reliefComponentProperty;
	}

	public ReliefFeature createReliefFeature() {
		return new ReliefFeatureImpl();
	}

	public TinProperty createTinProperty() {
		return new TinPropertyImpl();
	}
	
	public TinProperty createTinProperty(TriangulatedSurface triangulatedSurface) {
		TinProperty tinProperty = new TinPropertyImpl();
		tinProperty.setTriangulatedSurface(triangulatedSurface);
		return tinProperty;
	}
	
	public TinProperty createTinProperty(String xlink) {
		TinProperty tinProperty = new TinPropertyImpl();
		tinProperty.setHref(xlink);
		return tinProperty;
	}

	public TINRelief createTINRelief() {
		return new TINReliefImpl();
	}

	// TexturedSurface module
	
	public _AppearanceProperty create_AppearanceProperty() {
		return new _AppearancePropertyImpl();
	}
	
	public _AppearanceProperty create_AppearanceProperty(_Appearance appearance) {
		_AppearanceProperty appearanceProperty = new _AppearancePropertyImpl();
		appearanceProperty.setAppearance(appearance);
		return appearanceProperty;
	}
	
	public _AppearanceProperty create_AppearanceProperty(String xlink) {
		_AppearanceProperty appearanceProperty = new _AppearancePropertyImpl();
		appearanceProperty.setHref(xlink);
		return appearanceProperty;
	}

	public _Color create_Color() {
		return new _ColorImpl();
	}

	public _Color create_Color(Double red, Double green, Double blue) {
		return new _ColorImpl(red, green, blue);
	}

	public _Material create_Material() {
		return new _MaterialImpl();
	}

	public _SimpleTexture create_SimpleTexture() {
		return new _SimpleTextureImpl();
	}

	public _TexturedSurface create_TexturedSurface() {
		return new _TexturedSurfaceImpl();
	}

	// Transportation module
	
	public AuxiliaryTrafficArea createAuxiliaryTrafficArea() {
		return new AuxiliaryTrafficAreaImpl();
	}

	public AuxiliaryTrafficAreaProperty createAuxiliaryTrafficAreaProperty() {
		return new AuxiliaryTrafficAreaPropertyImpl();
	}
	
	public AuxiliaryTrafficAreaProperty createAuxiliaryTrafficAreaProperty(AuxiliaryTrafficArea auxiliaryTrafficArea) {
		AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty = new AuxiliaryTrafficAreaPropertyImpl();
		auxiliaryTrafficAreaProperty.setAuxiliaryTrafficArea(auxiliaryTrafficArea);
		return auxiliaryTrafficAreaProperty;
	}
	
	public AuxiliaryTrafficAreaProperty createAuxiliaryTrafficAreaProperty(String xlink) {
		AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty = new AuxiliaryTrafficAreaPropertyImpl();
		auxiliaryTrafficAreaProperty.setHref(xlink);
		return auxiliaryTrafficAreaProperty;
	}

	public Railway createRailway() {
		return new RailwayImpl();
	}

	public Road createRoad() {
		return new RoadImpl();
	}

	public Square createSquare() {
		return new SquareImpl();
	}

	public Track createTrack() {
		return new TrackImpl();
	}

	public TrafficArea createTrafficArea() {
		return new TrafficAreaImpl();
	}

	public TrafficAreaProperty createTrafficAreaProperty() {
		return new TrafficAreaPropertyImpl();
	}
	
	public TrafficAreaProperty createTrafficAreaProperty(TrafficArea trafficArea) {
		TrafficAreaProperty trafficAreaProperty = new TrafficAreaPropertyImpl();
		trafficAreaProperty.setTrafficArea(trafficArea);
		return trafficAreaProperty;
	}
	
	public TrafficAreaProperty createTrafficAreaProperty(String xlink) {
		TrafficAreaProperty trafficAreaProperty = new TrafficAreaPropertyImpl();
		trafficAreaProperty.setHref(xlink);
		return trafficAreaProperty;
	}

	public TransportationComplex createTransportationComplex() {
		return new TransportationComplexImpl();
	}
	
	// Vegetation module

	public PlantCover createPlantCover() {
		return new PlantCoverImpl();
	}

	public SolitaryVegetationObject createSolitaryVegetationObject() {
		return new SolitaryVegetationObjectImpl();
	}

	// WaterBody module
	
	public BoundedByWaterSurfaceProperty createBoundedByWaterSurfaceProperty() {
		return new BoundedByWaterSurfacePropertyImpl();
	}
	
	public BoundedByWaterSurfaceProperty createBoundedByWaterSurfaceProperty(WaterBoundarySurface waterBoundarySurface) {
		BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty = new BoundedByWaterSurfacePropertyImpl();
		boundedByWaterSurfaceProperty.setWaterBoundarySurface(waterBoundarySurface);
		return boundedByWaterSurfaceProperty;
	}
	
	public BoundedByWaterSurfaceProperty createBoundedByWaterSurfaceProperty(String xlink) {
		BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty = new BoundedByWaterSurfacePropertyImpl();
		boundedByWaterSurfaceProperty.setHref(xlink);
		return boundedByWaterSurfaceProperty;
	}

	public WaterBody createWaterBody() {
		return new WaterBodyImpl();
	}

	public WaterClosureSurface createWaterClosureSurface() {
		return new WaterClosureSurfaceImpl();
	}

	public WaterGroundSurface createWaterGroundSurface() {
		return new WaterGroundSurfaceImpl();
	}

	public WaterSurface createWaterSurface() {
		return new WaterSurfaceImpl();
	}
		
}
