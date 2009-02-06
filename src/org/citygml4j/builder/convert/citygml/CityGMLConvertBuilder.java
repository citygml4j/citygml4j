package org.citygml4j.builder.convert.citygml;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.convert.gml.GMLConvertBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.ADEConvertBuilder;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
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
import org.citygml4j.model.citygml.core.Site;
import org.citygml4j.model.citygml.core.TransformationMatrix2x2;
import org.citygml4j.model.citygml.core.TransformationMatrix3x4;
import org.citygml4j.model.citygml.core.TransformationMatrix4x4;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.generics.GenericDateAttribute;
import org.citygml4j.model.citygml.generics.GenericDoubleAttribute;
import org.citygml4j.model.citygml.generics.GenericIntAttribute;
import org.citygml4j.model.citygml.generics.GenericStringAttribute;
import org.citygml4j.model.citygml.generics.GenericUriAttribute;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponent;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TextureType;
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

public class CityGMLConvertBuilder {
	protected CityGMLContext cityGMLContext;
	protected CityGMLConvertContext convertContext;

	protected CoreConverter core;
	protected AppearanceConverter app;
	protected BuildingConverter bldg;
	protected CityFurnitureConverter frn;
	protected CityObjectGroupConverter grp;
	protected GenericsConverter gen;
	protected LandUseConverter luse;
	protected ReliefConverter dem;
	protected TexturedSurfaceConverter tex;
	protected TransportationConverter tran;
	protected VegetationConverter veg;
	protected WaterBodyConverter wtr;
	protected ADEConverter ade;
	protected GMLConvertBuilder gml;

	public CityGMLConvertBuilder(CityGMLContext cityGMLContext, CityGMLConvertContext convertContext) {
		this.cityGMLContext = cityGMLContext;
		this.convertContext = convertContext;

		core = new CoreConverter(this);
		app = new AppearanceConverter(this);
		bldg = new BuildingConverter(this);
		frn = new CityFurnitureConverter(this);
		grp = new CityObjectGroupConverter(this);
		gen = new GenericsConverter(this);
		luse = new LandUseConverter(this);
		dem = new ReliefConverter(this);
		tex = new TexturedSurfaceConverter(this);
		tran = new TransportationConverter(this);
		veg = new VegetationConverter(this);
		wtr = new WaterBodyConverter(this);
		ade = new ADEConverter(this);		
		gml = new GMLConvertBuilder(this);
	}

	public CityGMLConvertContext getConvertContext() {
		return convertContext;
	}

	public void setConvertContext(CityGMLConvertContext convertContext) {
		this.convertContext = convertContext;
	}

	public GMLConvertBuilder getGMLConvertBuilder() {
		return gml;
	}

	// core
	public Address convertAddress(Address address) {
		return core.convertAddress(address);
	}

	public AddressProperty convertAddressProperty(AddressProperty addressProperty) {
		return core.convertAddressProperty(addressProperty);
	}

	public CityModel convertCityModel(CityModel cityModel) {
		return core.convertCityModel(cityModel);
	}

	public CityObject convertCityObject(CityObject cityObject) {
		return core.convertCityObject(cityObject);
	}

	public CityObjectMember convertCityObjectMember(CityObjectMember cityObjectMember) {
		return core.convertCityObjectMember(cityObjectMember);
	}

	public ExternalObject convertExternalObject(ExternalObject externalObject) {
		return core.convertExternalObject(externalObject);
	}

	public ExternalReference convertExternalReference(ExternalReference externalReference) {
		return core.convertExternalReference(externalReference);
	}

	public GeneralizationRelation convertGeneralizationRelation(GeneralizationRelation generalizationRelation) {
		return core.convertGeneralizationRelation(generalizationRelation);
	}

	public ImplicitGeometry convertImplicitGeometry(ImplicitGeometry implicitGeometry) {
		return core.convertImplicitGeometry(implicitGeometry);
	}

	public ImplicitRepresentationProperty convertImplicitRepresentationProperty(ImplicitRepresentationProperty implicitRepresentationProperty) {
		return core.convertImplicitRepresentationProperty(implicitRepresentationProperty);
	}

	public TransformationMatrix2x2 convertTransformationMatrix2x2(TransformationMatrix2x2 transformationMatrix2x2) {
		return core.convertTransformationMatrix2x2(transformationMatrix2x2);
	}

	public TransformationMatrix3x4 convertTransformationMatrix3x4(TransformationMatrix3x4 transformationMatrix3x4) {
		return core.convertTransformationMatrix3x4(transformationMatrix3x4);
	}

	public TransformationMatrix4x4 convertTransformationMatrix4x4(TransformationMatrix4x4 transformationMatrix4x4) {
		return core.convertTransformationMatrix4x4(transformationMatrix4x4);
	}

	public XalAddressProperty convertXalAddressProperty(XalAddressProperty xalAddressProperty) {
		return core.convertXalAddressProperty(xalAddressProperty);
	}

	public void convertAddress(Address src, Address dest) {
		if (dest.getCityGMLModule() == convertContext.coreModule)
			core.convertAddress(src, dest);
	}

	public void convertCityModel(CityModel src, CityModel dest) {
		if (dest.getCityGMLModule() == convertContext.coreModule)
			core.convertCityModel(src, dest);
	}

	public void convertCityObject(CityObject src, CityObject dest) {
		if (dest.getCityGMLModule() == convertContext.coreModule)
			core.convertCityObject(src, dest);
	}

	public void convertSite(Site src, Site dest) {
		if (dest.getCityGMLModule() == convertContext.coreModule)
			core.convertSite(src, dest);
	}

	// appearance
	public Appearance convertAppearance(Appearance appearance) {
		return app.convertAppearance(appearance);
	}

	public AppearanceMember convertAppearanceMember(AppearanceMember appearanceMember) {
		return app.convertAppearanceMember(appearanceMember);
	}

	public AppearanceProperty convertAppearanceProperty(AppearanceProperty appearanceProperty) {
		return app.convertAppearanceProperty(appearanceProperty);
	}

	public Color convertColor(Color color) {
		return app.convertColor(color);
	}

	public ColorPlusOpacity convertColorPlusOpacity(ColorPlusOpacity colorPlusOpacity) {
		return app.convertColorPlusOpacity(colorPlusOpacity);
	}

	public GeoreferencedTexture convertGeoreferencedTexture(GeoreferencedTexture georeferencedTexture) {
		return app.convertGeoreferencedTexture(georeferencedTexture);
	}

	public ParameterizedTexture convertParameterizedTexture(ParameterizedTexture parameterizedTexture) {
		return app.convertParameterizedTexture(parameterizedTexture);
	}

	public SurfaceDataProperty convertSurfaceDataProperty(SurfaceDataProperty surfaceDataProperty) {
		return app.convertSurfaceDataProperty(surfaceDataProperty);
	}

	public TexCoordGen convertTexCoordGen(TexCoordGen texCoordGen) {
		return app.convertTexCoordGen(texCoordGen);
	}

	public TexCoordList convertTexCoordList(TexCoordList texCoordList) {
		return app.convertTexCoordList(texCoordList);
	}

	public TextureAssociation convertTextureAssociation(TextureAssociation textureAssociation) {
		return app.convertTextureAssociation(textureAssociation);
	}

	public TextureCoordinates convertTextureCoordinates(TextureCoordinates textureCoordinates) {
		return app.convertTextureCoordinates(textureCoordinates);
	}

	public TextureType convertTextureType(TextureType textureType) {
		return app.convertTextureType(textureType);
	}

	public WorldToTexture convertWorldToTexture(WorldToTexture worldToTexture) {
		return app.convertWorldToTexture(worldToTexture);
	}

	public WrapMode convertWrapMode(WrapMode wrapMode) {
		return app.convertWrapMode(wrapMode);
	}

	public X3DMaterial convertX3DMaterial(X3DMaterial x3DMaterial) {
		return app.convertX3DMaterial(x3DMaterial);
	}

	public void convertAbstractSurfaceData(AbstractSurfaceData src, AbstractSurfaceData dest) {
		if (dest.getCityGMLModule() == convertContext.appModule)
			app.convertAbstractSurfaceData(src, dest);
	}

	public void convertAbstractTexture(AbstractTexture src, AbstractTexture dest) {
		if (dest.getCityGMLModule() == convertContext.appModule)
			app.convertAbstractTexture(src, dest);
	}

	public void convertAppearance(Appearance src, Appearance dest) {
		if (dest.getCityGMLModule() == convertContext.appModule)
			app.convertAppearance(src, dest);
	}

	public void convertGeoreferencedTexture(GeoreferencedTexture src, GeoreferencedTexture dest) {
		if (dest.getCityGMLModule() == convertContext.appModule)
			app.convertGeoreferencedTexture(src, dest);
	}

	public void convertParameterizedTexture(ParameterizedTexture src, ParameterizedTexture dest) {
		if (dest.getCityGMLModule() == convertContext.appModule)
			app.convertParameterizedTexture(src, dest);
	}

	public void convertX3DMaterial(X3DMaterial src, X3DMaterial dest) {
		if (dest.getCityGMLModule() == convertContext.appModule)
			app.convertX3DMaterial(src, dest);
	}

	// building
	public BoundarySurfaceProperty convertBoundarySurfaceProperty(BoundarySurfaceProperty boundarySurfaceProperty) {
		return bldg.convertBoundarySurfaceProperty(boundarySurfaceProperty);
	}	

	public Building convertBuilding(Building building) {
		return bldg.convertBuilding(building);
	}

	public BuildingFurniture convertBuildingFurniture(BuildingFurniture buildingFurniture) {
		return bldg.convertBuildingFurniture(buildingFurniture);
	}

	public BuildingInstallation convertBuildingInstallation(BuildingInstallation buildingInstallation) {
		return bldg.convertBuildingInstallation(buildingInstallation);
	}

	public BuildingInstallationProperty convertBuildingInstallationProperty(BuildingInstallationProperty buildingInstallationProperty) {
		return bldg.convertBuildingInstallationProperty(buildingInstallationProperty);
	}

	public BuildingPart convertBuildingPart(BuildingPart buildingPart) {
		return bldg.convertBuildingPart(buildingPart);
	}

	public BuildingPartProperty convertBuildingPartProperty(BuildingPartProperty buildingPartProperty) {
		return bldg.convertBuildingPartProperty(buildingPartProperty);
	}

	public CeilingSurface convertCeilingSurface(CeilingSurface ceilingSurface) {
		return bldg.convertCeilingSurface(ceilingSurface);
	}

	public ClosureSurface convertClosureSurface(ClosureSurface closureSurface) {
		return bldg.convertClosureSurface(closureSurface);
	}

	public Door convertDoor(Door door) {
		return bldg.convertDoor(door);
	}

	public FloorSurface convertFloorSurface(FloorSurface floorSurface) {
		return bldg.convertFloorSurface(floorSurface);
	}

	public GroundSurface convertGroundSurface(GroundSurface groundSurface) {
		return bldg.convertGroundSurface(groundSurface);
	}

	public IntBuildingInstallation convertIntBuildingInstallation(IntBuildingInstallation intBuildingInstallation) {
		return bldg.convertIntBuildingInstallation(intBuildingInstallation);
	}

	public IntBuildingInstallationProperty convertIntBuildingInstallationProperty(IntBuildingInstallationProperty intBuildingInstallationProperty) {
		return bldg.convertIntBuildingInstallationProperty(intBuildingInstallationProperty);
	}

	public InteriorFurnitureProperty convertInteriorFurnitureProperty(InteriorFurnitureProperty interiorFurnitureProperty) {
		return bldg.convertInteriorFurnitureProperty(interiorFurnitureProperty);
	}

	public InteriorRoomProperty convertInteriorRoomProperty(InteriorRoomProperty interiorRoomProperty) {
		return bldg.convertInteriorRoomProperty(interiorRoomProperty);
	}

	public InteriorWallSurface convertInteriorWallSurface(InteriorWallSurface interiorWallSurface) {
		return bldg.convertInteriorWallSurface(interiorWallSurface);
	}

	public OpeningProperty convertOpeningProperty(OpeningProperty openingProperty) {
		return bldg.convertOpeningProperty(openingProperty);
	}

	public RoofSurface convertRoofSurface(RoofSurface roofSurface) {
		return bldg.convertRoofSurface(roofSurface);
	}

	public Room convertRoom(Room room) {
		return bldg.convertRoom(room);
	}

	public WallSurface convertWallSurface(WallSurface wallSurface) {
		return bldg.convertWallSurface(wallSurface);
	}

	public Window convertWindow(Window window) {
		return bldg.convertWindow(window);
	}	

	public void convertAbstractBuilding(AbstractBuilding src, AbstractBuilding dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertAbstractBuilding(src, dest);
	}

	public void convertBoundarySurface(BoundarySurface src, BoundarySurface dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertBoundarySurface(src, dest);
	}

	public void convertBuilding(Building src, Building dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertBuilding(src, dest);
	}

	public void convertBuildingFurniture(BuildingFurniture src, BuildingFurniture dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertBuildingFurniture(src, dest);
	}

	public void convertBuildingInstallation(BuildingInstallation src, BuildingInstallation dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertBuildingInstallation(src, dest);
	}

	public void convertBuildingPart(BuildingPart src, BuildingPart dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertBuildingPart(src, dest);
	}

	public void convertCeilingSurface(CeilingSurface src, CeilingSurface dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertCeilingSurface(src, dest);
	}

	public void convertClosureSurface(ClosureSurface src, ClosureSurface dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertClosureSurface(src, dest);
	}

	public void convertDoor(Door src, Door dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertDoor(src, dest);
	}

	public void convertFloorSurface(FloorSurface src, FloorSurface dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertFloorSurface(src, dest);
	}

	public void convertGroundSurface(GroundSurface src, GroundSurface dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertGroundSurface(src, dest);
	}

	public void convertIntBuildingInstallation(IntBuildingInstallation src, IntBuildingInstallation dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertIntBuildingInstallation(src, dest);
	}

	public void convertInteriorWallSurface(InteriorWallSurface src, InteriorWallSurface dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertInteriorWallSurface(src, dest);
	}

	public void convertOpening(Opening src, Opening dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertOpening(src, dest);
	}

	public void convertRoofSurface(RoofSurface src, RoofSurface dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertRoofSurface(src, dest);
	}

	public void convertRoom(Room src, Room dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertRoom(src, dest);
	}

	public void convertWallSurface(WallSurface src, WallSurface dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertWallSurface(src, dest);
	}

	public void convertWindow(Window src, Window dest) {
		if (dest.getCityGMLModule() == convertContext.bldgModule)
			bldg.convertWindow(src, dest);
	}

	// cityFurniture
	public CityFurniture convertCityFurniture(CityFurniture cityFurniture) {
		return frn.convertCityFurniture(cityFurniture);
	}

	public void convertCityFurniture(CityFurniture src, CityFurniture dest) {
		if (dest.getCityGMLModule() == convertContext.frnModule)
			frn.convertCityFurniture(src, dest);
	}

	// cityObjectGroup
	public CityObjectGroup convertCityObjectGroup(CityObjectGroup cityObjectGroup) {
		return grp.convertCityObjectGroup(cityObjectGroup);
	}

	public CityObjectGroupMember convertCityObjectGroupMember(CityObjectGroupMember cityObjectGroupMember) {
		return grp.convertCityObjectGroupMember(cityObjectGroupMember);
	}

	public CityObjectGroupParent convertCityObjectGroupParent(CityObjectGroupParent cityObjectGroupParent) {
		return grp.convertCityObjectGroupParent(cityObjectGroupParent);
	}

	public void convertCityObjectGroup(CityObjectGroup src, CityObjectGroup dest) {
		if (dest.getCityGMLModule() == convertContext.grpModule)
			grp.convertCityObjectGroup(src, dest);
	}

	// generics
	public GenericCityObject convertGenericCityObject(GenericCityObject genericCityObject) {
		return gen.convertGenericCityObject(genericCityObject);
	}

	public GenericDateAttribute convertGenericDateAttribute(GenericDateAttribute genericDateAttribute) {
		return gen.convertGenericDateAttribute(genericDateAttribute);
	}

	public GenericDoubleAttribute convertGenericDoubleAttribute(GenericDoubleAttribute genericDoubleAttribute) {
		return gen.convertGenericDoubleAttribute(genericDoubleAttribute);
	}

	public GenericIntAttribute convertGenericIntAttribute(GenericIntAttribute genericIntAttribute) {
		return gen.convertGenericIntAttribute(genericIntAttribute);
	}

	public GenericStringAttribute convertGenericStringAttribute(GenericStringAttribute genericStringAttribute) {
		return gen.convertGenericStringAttribute(genericStringAttribute);
	}

	public GenericUriAttribute convertGenericUriAttribute(GenericUriAttribute genericUriAttribute) {
		return gen.convertGenericUriAttribute(genericUriAttribute);
	}

	public void convertGenericCityobject(GenericCityObject src, GenericCityObject dest) {
		if (dest.getCityGMLModule() == convertContext.genModule)
			gen.convertGenericCityobject(src, dest);
	}

	// landUse
	public LandUse convertLandUse(LandUse landUse) {
		return luse.convertLandUse(landUse);
	}

	public void convertLandUse(LandUse src, LandUse dest) {
		if (dest.getCityGMLModule() == convertContext.luseModule)
			luse.convertLandUse(src, dest);
	}

	// relief
	public BreaklineRelief convertBreaklineRelief(BreaklineRelief breaklineRelief) {
		return dem.convertBreaklineRelief(breaklineRelief);
	}

	public MassPointRelief convertMassPointRelief(MassPointRelief massPointRelief) {
		return dem.convertMassPointRelief(massPointRelief);
	}

	public RasterRelief convertRasterRelief(RasterRelief rasterRelief) {
		return dem.convertRasterRelief(rasterRelief);
	}

	public ReliefComponentProperty convertReliefComponentProperty(ReliefComponentProperty reliefComponentProperty) {
		return dem.convertReliefComponentProperty(reliefComponentProperty);
	}

	public ReliefFeature convertReliefFeature(ReliefFeature reliefFeature) {
		return dem.convertReliefFeature(reliefFeature);
	}

	public TinProperty convertTinProperty(TinProperty tinProperty) {
		return dem.convertTinProperty(tinProperty);
	}

	public TINRelief convertTINRelief(TINRelief tinRelief) {
		return dem.convertTINRelief(tinRelief);
	}

	public void convertReliefComponent(ReliefComponent src, ReliefComponent dest) {
		if (dest.getCityGMLModule() == convertContext.demModule)
			dem.convertReliefComponent(src, dest);
	}

	public void convertBreaklineRelief(BreaklineRelief src, BreaklineRelief dest) {
		if (dest.getCityGMLModule() == convertContext.demModule)
			dem.convertBreaklineRelief(src, dest);
	}

	public void convertMassPointRelief(MassPointRelief src, MassPointRelief dest) {
		if (dest.getCityGMLModule() == convertContext.demModule)
			dem.convertMassPointRelief(src, dest);
	}

	public void convertRasterRelief(RasterRelief src, RasterRelief dest) {
		if (dest.getCityGMLModule() == convertContext.demModule)
			dem.convertRasterRelief(src, dest);
	}

	public void convertReliefFeature(ReliefFeature src, ReliefFeature dest) {
		if (dest.getCityGMLModule() == convertContext.demModule)
			dem.convertReliefFeature(src, dest);
	}

	public void convertTINRelief(TINRelief src, TINRelief dest) {
		if (dest.getCityGMLModule() == convertContext.demModule)
			dem.convertTINRelief(src, dest);
	}

	// texturedSurface
	public _AppearanceProperty convert_AppearanceProperty(_AppearanceProperty _appearanceProperty) {
		return tex.convert_AppearanceProperty(_appearanceProperty);
	}

	public _Color convert_Color(_Color _color) {
		return tex.convert_Color(_color);
	}

	public _Material convert_Material(_Material _material) {
		return tex.convert_Material(_material);
	}

	public _SimpleTexture convert_SimpleTexture(_SimpleTexture _simpleTexture) {
		return tex.convert_SimpleTexture(_simpleTexture);
	}

	public _TexturedSurface convert_TexturedSurface(_TexturedSurface _texturedSurface) {
		return tex.convert_TexturedSurface(_texturedSurface);
	}

	public _TextureType convert_TextureType(_TextureType _textureType) {
		return tex.convert_TextureType(_textureType);
	}

	// transportation
	public AuxiliaryTrafficArea convertAuxiliaryTrafficArea(AuxiliaryTrafficArea auxiliaryTrafficArea) {
		return tran.convertAuxiliaryTrafficArea(auxiliaryTrafficArea);
	}

	public AuxiliaryTrafficAreaProperty convertAuxiliaryTrafficAreaProperty(AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty) {
		return tran.convertAuxiliaryTrafficAreaProperty(auxiliaryTrafficAreaProperty);
	}

	public Railway convertRailway(Railway railway) {
		return tran.convertRailway(railway);
	}

	public Road convertRoad(Road road) {
		return tran.convertRoad(road);
	}

	public Square convertSquare(Square square) {
		return tran.convertSquare(square);
	}

	public Track convertTrack(Track track) {
		return tran.convertTrack(track);
	}

	public TrafficArea convertTrafficArea(TrafficArea trafficArea) {
		return tran.convertTrafficArea(trafficArea);
	}

	public TrafficAreaProperty convertTrafficAreaProperty(TrafficAreaProperty trafficAreaProperty) {
		return tran.convertTrafficAreaProperty(trafficAreaProperty);
	}

	public TransportationComplex convertTransportationComplex(TransportationComplex transportationComplex) {
		return tran.convertTransportationComplex(transportationComplex);
	}

	public void convertAuxiliaryTrafficArea(AuxiliaryTrafficArea src, AuxiliaryTrafficArea dest) {
		if (dest.getCityGMLModule() == convertContext.tranModule)
			tran.convertAuxiliaryTrafficArea(src, dest);
	}

	public void convertRailway(Railway src, Railway dest) {
		if (dest.getCityGMLModule() == convertContext.tranModule)
			tran.convertRailway(src, dest);
	}

	public void convertRoad(Road src, Road dest) {
		if (dest.getCityGMLModule() == convertContext.tranModule)
			tran.convertRoad(src, dest);
	}

	public void convertSquare(Square src, Square dest) {
		if (dest.getCityGMLModule() == convertContext.tranModule)
			tran.convertSquare(src, dest);
	}

	public void convertTrack(Track src, Track dest) {
		if (dest.getCityGMLModule() == convertContext.tranModule)
			tran.convertTrack(src, dest);
	}

	public void convertTrafficArea(TrafficArea src, TrafficArea dest) {
		if (dest.getCityGMLModule() == convertContext.tranModule)
			tran.convertTrafficArea(src, dest);
	}

	public void convertTransportationComplex(TransportationComplex src, TransportationComplex dest) {
		if (dest.getCityGMLModule() == convertContext.tranModule)
			tran.convertTransportationComplex(src, dest);
	}

	public void convertTransportationObject(TransportationObject src, TransportationObject dest) {
		if (dest.getCityGMLModule() == convertContext.tranModule)
			tran.convertTransportationObject(src, dest);
	}

	// vegetation
	public PlantCover convertPlantCover(PlantCover plantCover) {
		return veg.convertPlantCover(plantCover);
	}

	public SolitaryVegetationObject convertSolitaryVegetationObject(SolitaryVegetationObject solitaryVegetationObject) {
		return veg.convertSolitaryVegetationObject(solitaryVegetationObject);
	}

	public void convertPlantCover(PlantCover src, PlantCover dest) {
		if (dest.getCityGMLModule() == convertContext.vegModule)
			veg.convertPlantCover(src, dest);
	}

	public void convertSolitaryVegetationObject(SolitaryVegetationObject src, SolitaryVegetationObject dest) {
		if (dest.getCityGMLModule() == convertContext.vegModule)
			veg.convertSolitaryVegetationObject(src, dest);
	}

	public void convertVegetationObject(VegetationObject src, VegetationObject dest) {
		if (dest.getCityGMLModule() == convertContext.vegModule)
			veg.convertVegetationObject(src, dest);
	}

	// waterBody
	public BoundedByWaterSurfaceProperty convertBoundedByWaterSurfaceProperty(BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty) {
		return wtr.convertBoundedByWaterSurfaceProperty(boundedByWaterSurfaceProperty);
	}

	public WaterBody convertWaterBody(WaterBody waterBody) {
		return wtr.convertWaterBody(waterBody);
	}

	public WaterClosureSurface convertWaterClosureSurface(WaterClosureSurface waterClosureSurface) {
		return wtr.convertWaterClosureSurface(waterClosureSurface);
	}

	public WaterGroundSurface convertWaterGroundSurface(WaterGroundSurface waterGroundSurface) {
		return wtr.convertWaterGroundSurface(waterGroundSurface);
	}

	public WaterSurface convertWaterSurface(WaterSurface waterSurface) {
		return wtr.convertWaterSurface(waterSurface);
	}

	public void convertWaterBody(WaterBody src, WaterBody dest) {
		if (dest.getCityGMLModule() == convertContext.wtrModule)
			wtr.convertWaterBody(src, dest);
	}

	public void convertWaterBoundarySurface(WaterBoundarySurface src, WaterBoundarySurface dest) {
		if (dest.getCityGMLModule() == convertContext.wtrModule)
			wtr.convertWaterBoundarySurface(src, dest);
	}

	public void convertWaterClosureSurface(WaterClosureSurface src, WaterClosureSurface dest) {
		if (dest.getCityGMLModule() == convertContext.wtrModule)
			wtr.convertWaterClosureSurface(src, dest);
	}

	public void convertWaterGroundSurface(WaterGroundSurface src, WaterGroundSurface dest) {
		if (dest.getCityGMLModule() == convertContext.wtrModule)
			wtr.convertWaterGroundSurface(src, dest);
	}

	public void convertWaterObject(WaterObject src, WaterObject dest) {
		if (dest.getCityGMLModule() == convertContext.wtrModule)
			wtr.convertWaterObject(src, dest);
	}

	public void convertWaterSurface(WaterSurface src, WaterSurface dest) {
		if (dest.getCityGMLModule() == convertContext.wtrModule)
			wtr.convertWaterSurface(src, dest);
	}

	// ade
	public ADEComponent convertADEComponent(ADEComponent adeComponent) {
		return ade.convertADEComponent(adeComponent);
	}

	public void registerADEConvertBuilder(String namespaceURI, ADEConvertBuilder adeConvertBuilder) {
		ade.registerADEConvertBuilder(namespaceURI, adeConvertBuilder);
	}

	public void unregisterADEConvertBuilder(String namespaceURI) {
		ade.unregisterADEConvertBuilder(namespaceURI);
	}
}
