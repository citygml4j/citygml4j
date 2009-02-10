package org.citygml4j.factory;

import javax.xml.bind.JAXBElement;

import org.citygml4j.geometry.Matrix;
import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.AbstractAppearanceFactoryImpl;
import org.citygml4j.impl.jaxb.citygml.AbstractBuildingFactoryImpl;
import org.citygml4j.impl.jaxb.citygml.AbstractCityFurnitureFactoryImpl;
import org.citygml4j.impl.jaxb.citygml.AbstractCityObjectGroupFactoryImpl;
import org.citygml4j.impl.jaxb.citygml.AbstractCoreFactoryImpl;
import org.citygml4j.impl.jaxb.citygml.AbstractGenericsFactoryImpl;
import org.citygml4j.impl.jaxb.citygml.AbstractLandUseFactoryImpl;
import org.citygml4j.impl.jaxb.citygml.AbstractReliefFactoryImpl;
import org.citygml4j.impl.jaxb.citygml.AbstractTexturedSurfaceFactoryImpl;
import org.citygml4j.impl.jaxb.citygml.AbstractTransportationFactoryImpl;
import org.citygml4j.impl.jaxb.citygml.AbstractVegetationFactoryImpl;
import org.citygml4j.impl.jaxb.citygml.AbstractWaterBodyFactoryImpl;
import org.citygml4j.model.citygml.CityGMLModelMapper;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.CityGMLModuleType;
import org.citygml4j.model.citygml.CityGMLModuleVersion;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
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
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.building.BuildingModule;
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
import org.citygml4j.model.citygml.cityfurniture.CityFurnitureModule;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupModule;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.ExternalObject;
import org.citygml4j.model.citygml.core.ExternalReference;
import org.citygml4j.model.citygml.core.GeneralizationRelation;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
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
import org.citygml4j.model.citygml.generics.GenericsModule;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.landuse.LandUseModule;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.ReliefModule;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModule;
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
import org.citygml4j.model.citygml.transportation.TransportationModule;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.vegetation.VegetationModule;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterBodyModule;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.util.CityGMLModules;

public class CityGMLFactory {
	private AppearanceModule appModule;
	private BuildingModule bldgModule;
	private CityFurnitureModule frnModule;
	private CityObjectGroupModule grpModule;
	private CoreModule coreModule;
	private GenericsModule genModule;
	private LandUseModule luseModule;
	private ReliefModule demModule;
	private TexturedSurfaceModule texModule;
	private TransportationModule tranModule;
	private VegetationModule vegModule;
	private WaterBodyModule wtrModule;

	public CityGMLFactory() {
		this(CityGMLModuleVersion.v1_0_0);
	}
	
	public CityGMLFactory(CityGMLModuleVersion version) {
		switch (version) {
		case v0_4_0:
		case v1_0_0:
			init(version);
			break;
		default:
			throw new IllegalArgumentException("illegal CityGML module version");
		}
	}
	
	// Factory methods supporting versioning
	public Address createAddress(CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createAddress();
	}

	public AddressProperty createAddressProperty(CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createAddressProperty();
	}

	public CityModel createCityModel(CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createCityModel();
	}

	public CityObjectMember createCityObjectMember(CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createCityObjectMember();
	}

	public ExternalObject createExternalObject(CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createExternalObject();
	}

	public ExternalReference createExternalReference(CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createExternalReference();
	}

	public GeneralizationRelation createGeneralizationRelation(CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createGeneralizationRelation();
	}

	public ImplicitGeometry createImplicitGeometry(CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createImplicitGeometry();
	}

	public ImplicitRepresentationProperty createImplicitRepresentationProperty(CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createImplicitRepresentationProperty();
	}

	public TransformationMatrix2x2 createTransformationMatrix2x2(CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createTransformationMatrix2x2();
	}

	public TransformationMatrix2x2 createTransformationMatrix2x2(Matrix matrix, CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createTransformationMatrix2x2(matrix);
	}

	public TransformationMatrix3x4 createTransformationMatrix3x4(CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createTransformationMatrix3x4();
	}
	
	public TransformationMatrix3x4 createTransformationMatrix3x4(Matrix matrix, CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createTransformationMatrix3x4(matrix);
	}

	public TransformationMatrix4x4 createTransformationMatrix4x4(CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createTransformationMatrix4x4();
	}

	public TransformationMatrix4x4 createTransformationMatrix4x4(Matrix matrix, CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createTransformationMatrix4x4(matrix);
	}

	public XalAddressProperty createXalAddressProperty(CoreModule module) {
		return (AbstractCoreFactoryImpl.getInstance(module)).createXalAddressProperty();
	}
	
	public Appearance createAppearance(AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createAppearance();
	}

	public AppearanceMember createAppearanceMember(AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createAppearanceMember();
	}

	public AppearanceProperty createAppearanceProperty(AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createAppearanceProperty();
	}

	public Color createColor(AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createColor();
	}

	public Color createColor(Double red, Double green, Double blue, AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createColor(red, green, blue);
	}

	public ColorPlusOpacity createColorPlusOpacity(AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createColorPlusOpacity();
	}

	public ColorPlusOpacity createColorPlusOpacity(Color color, Double opacity, AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createColorPlusOpacity(color, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue, Double opacity, AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createColorPlusOpacity(defaultColorValue, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double defaulColorValue, AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createColorPlusOpacity(defaulColorValue);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double red, Double green, Double blue, Double opacity, AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createColorPlusOpacity(red, green, blue, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double red, Double green, Double blue, AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createColorPlusOpacity(red, green, blue);
	}

	public GeoreferencedTexture createGeoreferencedTexture(AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createGeoreferencedTexture();
	}

	public ParameterizedTexture createParameterizedTexture(AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createParameterizedTexture();
	}

	public SurfaceDataProperty createSurfaceDataProperty(AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createSurfaceDataProperty();
	}

	public TexCoordGen createTexCoordGen(AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createTexCoordGen();
	}

	public TexCoordList createTexCoordList(AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createTexCoordList();
	}

	public TextureAssociation createTextureAssociation(AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createTextureAssociation();
	}

	public TextureCoordinates createTextureCoordinates(AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createTextureCoordinates();
	}

	public TextureType createTextureType(String textureType, AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createTextureType(textureType);
	}

	public WorldToTexture createWorldToTexture(AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createWorldToTexture();
	}

	public WrapMode createWrapMode(String wrapMode, AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createWrapMode(wrapMode);
	}

	public X3DMaterial createX3DMaterial(AppearanceModule module) {
		return (AbstractAppearanceFactoryImpl.getInstance(module)).createX3DMaterial();
	}
	
	public BoundarySurfaceProperty createBoundarySurfaceProperty(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createBoundarySurfaceProperty();
	}

	public Building createBuilding(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createBuilding();
	}

	public BuildingFurniture createBuildingFurniture(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createBuildingFurniture();
	}

	public BuildingInstallation createBuildingInstallation(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createBuildingInstallation();
	}

	public BuildingInstallationProperty createBuildingInstallationProperty(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createBuildingInstallationProperty();
	}

	public BuildingPart createBuildingPart(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createBuildingPart();
	}

	public BuildingPartProperty createBuildingPartProperty(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createBuildingPartProperty();
	}

	public CeilingSurface createCeilingSurface(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createCeilingSurface();
	}

	public ClosureSurface createClosureSurface(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createClosureSurface();
	}

	public Door createDoor(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createDoor();
	}

	public FloorSurface createFloorSurface(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createFloorSurface();
	}

	public GroundSurface createGroundSurface(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createGroundSurface();
	}

	public IntBuildingInstallation createIntBuildingInstallation(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createIntBuildingInstallation();
	}

	public IntBuildingInstallationProperty createIntBuildingInstallationProperty(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createIntBuildingInstallationProperty();
	}

	public InteriorFurnitureProperty createInteriorFurnitureProperty(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createInteriorFurnitureProperty();
	}

	public InteriorRoomProperty createInteriorRoomProperty(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createInteriorRoomProperty();
	}

	public InteriorWallSurface createInteriorWallSurface(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createInteriorWallSurface();
	}

	public OpeningProperty createOpeningProperty(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createOpeningProperty();
	}

	public RoofSurface createRoofSurface(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createRoofSurface();
	}

	public Room createRoom(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createRoom();
	}

	public WallSurface createWallSurface(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createWallSurface();
	}

	public Window createWindow(BuildingModule module) {
		return (AbstractBuildingFactoryImpl.getInstance(module)).createWindow();
	}

	public CityFurniture createCityFurniture(CityFurnitureModule module) {
		return (AbstractCityFurnitureFactoryImpl.getInstance(module)).createCityFurniture();
	}

	public CityObjectGroup createCityObjectGroup(CityObjectGroupModule module) {
		return (AbstractCityObjectGroupFactoryImpl.getInstance(module)).createCityObjectGroup();
	}

	public CityObjectGroupMember createCityObjectGroupMember(CityObjectGroupModule module) {
		return (AbstractCityObjectGroupFactoryImpl.getInstance(module)).createCityObjectGroupMember();
	}

	public CityObjectGroupParent createCityObjectGroupParent(CityObjectGroupModule module) {
		return (AbstractCityObjectGroupFactoryImpl.getInstance(module)).createCityObjectGroupParent();
	}

	public GenericCityObject createGenericCityObject(GenericsModule module) {
		return (AbstractGenericsFactoryImpl.getInstance(module)).createGenericCityObject();
	}

	public GenericDateAttribute createGenericDateAttribute(GenericsModule module) {
		return (AbstractGenericsFactoryImpl.getInstance(module)).createGenericDateAttribute();
	}

	public GenericDoubleAttribute createGenericDoubleAttribute(GenericsModule module) {
		return (AbstractGenericsFactoryImpl.getInstance(module)).createGenericDoubleAttribute();
	}

	public GenericIntAttribute createGenericIntAttribute(GenericsModule module) {
		return (AbstractGenericsFactoryImpl.getInstance(module)).createGenericIntAttribute();
	}

	public GenericStringAttribute createGenericStringAttribute(GenericsModule module) {
		return (AbstractGenericsFactoryImpl.getInstance(module)).createGenericStringAttribute();
	}

	public GenericUriAttribute createGenericUriAttribute(GenericsModule module) {
		return (AbstractGenericsFactoryImpl.getInstance(module)).createGenericUriAttribute();
	}

	public LandUse createLandUse(LandUseModule module) {
		return (AbstractLandUseFactoryImpl.getInstance(module)).createLandUse();
	}

	public BreaklineRelief createBreaklineRelief(ReliefModule module) {
		return (AbstractReliefFactoryImpl.getInstance(module)).createBreaklineRelief();
	}

	public MassPointRelief createMassPointRelief(ReliefModule module) {
		return (AbstractReliefFactoryImpl.getInstance(module)).createMassPointRelief();
	}

	public RasterRelief createRasterRelief(ReliefModule module) {
		return (AbstractReliefFactoryImpl.getInstance(module)).createRasterRelief();
	}

	public ReliefComponentProperty createReliefComponentProperty(ReliefModule module) {
		return (AbstractReliefFactoryImpl.getInstance(module)).createReliefComponentProperty();
	}

	public ReliefFeature createReliefFeature(ReliefModule module) {
		return (AbstractReliefFactoryImpl.getInstance(module)).createReliefFeature();
	}

	public TINRelief createTINRelief(ReliefModule module) {
		return (AbstractReliefFactoryImpl.getInstance(module)).createTINRelief();
	}

	public TinProperty createTinProperty(ReliefModule module) {
		return (AbstractReliefFactoryImpl.getInstance(module)).createTinProperty();
	}

	public AuxiliaryTrafficArea createAuxiliaryTrafficArea(TransportationModule module) {
		return (AbstractTransportationFactoryImpl.getInstance(module)).createAuxiliaryTrafficArea();
	}

	public AuxiliaryTrafficAreaProperty createAuxiliaryTrafficAreaProperty(TransportationModule module) {
		return (AbstractTransportationFactoryImpl.getInstance(module)).createAuxiliaryTrafficAreaProperty();
	}

	public Railway createRailway(TransportationModule module) {
		return (AbstractTransportationFactoryImpl.getInstance(module)).createRailway();
	}

	public Road createRoad(TransportationModule module) {
		return (AbstractTransportationFactoryImpl.getInstance(module)).createRoad();
	}

	public Square createSquare(TransportationModule module) {
		return (AbstractTransportationFactoryImpl.getInstance(module)).createSquare();
	}

	public Track createTrack(TransportationModule module) {
		return (AbstractTransportationFactoryImpl.getInstance(module)).createTrack();
	}

	public TrafficArea createTrafficArea(TransportationModule module) {
		return (AbstractTransportationFactoryImpl.getInstance(module)).createTrafficArea();
	}

	public TrafficAreaProperty createTrafficAreaProperty(TransportationModule module) {
		return (AbstractTransportationFactoryImpl.getInstance(module)).createTrafficAreaProperty();
	}

	public TransportationComplex createTransportationComplex(TransportationModule module) {
		return (AbstractTransportationFactoryImpl.getInstance(module)).createTransportationComplex();
	}

	public PlantCover createPlantCover(VegetationModule module) {
		return (AbstractVegetationFactoryImpl.getInstance(module)).createPlantCover();
	}

	public SolitaryVegetationObject createSolitaryVegetationObject(VegetationModule module) {
		return (AbstractVegetationFactoryImpl.getInstance(module)).createSolitaryVegetationObject();
	}

	public BoundedByWaterSurfaceProperty createBoundedByWaterSurfaceProperty(WaterBodyModule module) {
		return (AbstractWaterBodyFactoryImpl.getInstance(module)).createBoundedByWaterSurfaceProperty();
	}

	public WaterBody createWaterBody(WaterBodyModule module) {
		return (AbstractWaterBodyFactoryImpl.getInstance(module)).createWaterBody();
	}

	public WaterClosureSurface createWaterClosureSurface(WaterBodyModule module) {
		return (AbstractWaterBodyFactoryImpl.getInstance(module)).createWaterClosureSurface();
	}

	public WaterGroundSurface createWaterGroundSurface(WaterBodyModule module) {
		return (AbstractWaterBodyFactoryImpl.getInstance(module)).createWaterGroundSurface();
	}

	public WaterSurface createWaterSurface(WaterBodyModule module) {
		return (AbstractWaterBodyFactoryImpl.getInstance(module)).createWaterSurface();
	}

	public _AppearanceProperty create_AppearanceProperty(TexturedSurfaceModule module) {
		return (AbstractTexturedSurfaceFactoryImpl.getInstance(module)).create_AppearanceProperty();
	}

	public _Material create_Material(TexturedSurfaceModule module) {
		return (AbstractTexturedSurfaceFactoryImpl.getInstance(module)).create_Material();
	}

	public _SimpleTexture create_SimpleTexture(TexturedSurfaceModule module) {
		return (AbstractTexturedSurfaceFactoryImpl.getInstance(module)).create_SimpleTexture();
	}

	public _TexturedSurface create_TexturedSurface(TexturedSurfaceModule module) {
		return (AbstractTexturedSurfaceFactoryImpl.getInstance(module)).create_TexturedSurface();
	}

	public _Color create_Color(TexturedSurfaceModule module) {
		return (AbstractTexturedSurfaceFactoryImpl.getInstance(module)).create_Color();
	}

	public _Color create_Color(Double red, Double green, Double blue, TexturedSurfaceModule module) {
		return (AbstractTexturedSurfaceFactoryImpl.getInstance(module)).create_Color(red, green, blue);
	}

	public _TextureType create_TextureType(String _textureType, TexturedSurfaceModule module) {
		return (AbstractTexturedSurfaceFactoryImpl.getInstance(module)).create_TextureType(_textureType);
	}

	public JAXBElement<?> cityGML2jaxb(CityGMLBase cityGML) {
		JAXBElement<?> jaxbElem = null;
		
		CityGMLModelMapper mapper = ModelMapper.getModelMapperInstance(
				cityGML.getCityGMLModule().getModuleType(), 
				cityGML.getCityGMLModule().getModuleVersion());
		
		if (mapper != null)
			jaxbElem = mapper.toJAXB(cityGML);
		
		return jaxbElem;
	}

	public CityGMLBase jaxb2cityGML(JAXBElement<?> jaxbElem) {
		CityGMLBase cityGMLClass = null;
		CityGMLModule moduleFactory = CityGMLModules.getModuleByNamespaceUri(jaxbElem.getName().getNamespaceURI());
				
		if (moduleFactory != null) {			
			// for CityGML v0.4.0 all modules share the same namespace uri.
			// thus, we need to check all model mapper...
			if (moduleFactory == CoreModule.v0_4_0) {
				cityGMLClass = ModelMapper.APP_0_4.toCityGML(jaxbElem);
				if (cityGMLClass == null)
					cityGMLClass = ModelMapper.BLDG_0_4.toCityGML(jaxbElem);
				if (cityGMLClass == null)
					cityGMLClass = ModelMapper.CORE_0_4.toCityGML(jaxbElem);
				if (cityGMLClass == null)
					cityGMLClass = ModelMapper.DEM_0_4.toCityGML(jaxbElem);
				if (cityGMLClass == null)
					cityGMLClass = ModelMapper.FRN_0_4.toCityGML(jaxbElem);
				if (cityGMLClass == null)
					cityGMLClass = ModelMapper.GEN_0_4.toCityGML(jaxbElem);
				if (cityGMLClass == null)
					cityGMLClass = ModelMapper.GRP_0_4.toCityGML(jaxbElem);
				if (cityGMLClass == null)
					cityGMLClass = ModelMapper.LUSE_0_4.toCityGML(jaxbElem);
				if (cityGMLClass == null)
					cityGMLClass = ModelMapper.TRAN_0_4.toCityGML(jaxbElem);
				if (cityGMLClass == null)
					cityGMLClass = ModelMapper.VEG_0_4.toCityGML(jaxbElem);
				if (cityGMLClass == null)
					cityGMLClass = ModelMapper.WTR_0_4.toCityGML(jaxbElem);
			}
			
			else {
				CityGMLModelMapper mapper = ModelMapper.getModelMapperInstance(
						moduleFactory.getModuleType(), 
						moduleFactory.getModuleVersion());
				if (mapper != null)
					cityGMLClass = mapper.toCityGML(jaxbElem);
			}				
		} else {
			// ADEs typically define their own namespace. Thus, they need to be treated separately
			ADEComponent ade = ModelMapper.ADE.toADEComponent(jaxbElem, jaxbElem.getName());
			if (ade instanceof CityGMLBase)
				cityGMLClass = (CityGMLBase)ade;
		}
		
		return cityGMLClass;
	}
	
	// Factory methods using default factories
	public Address createAddress() {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createAddress();
	}

	public AddressProperty createAddressProperty() {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createAddressProperty();
	}

	public CityModel createCityModel() {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createCityModel();
	}

	public CityObjectMember createCityObjectMember() {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createCityObjectMember();
	}

	public ExternalObject createExternalObject() {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createExternalObject();
	}

	public ExternalReference createExternalReference() {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createExternalReference();
	}

	public GeneralizationRelation createGeneralizationRelation() {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createGeneralizationRelation();
	}

	public ImplicitGeometry createImplicitGeometry() {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createImplicitGeometry();
	}

	public ImplicitRepresentationProperty createImplicitRepresentationProperty() {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createImplicitRepresentationProperty();
	}

	public TransformationMatrix2x2 createTransformationMatrix2x2() {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createTransformationMatrix2x2();
	}

	public TransformationMatrix2x2 createTransformationMatrix2x2(Matrix matrix) {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createTransformationMatrix2x2(matrix);
	}

	public TransformationMatrix3x4 createTransformationMatrix3x4() {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createTransformationMatrix3x4();
	}

	public TransformationMatrix3x4 createTransformationMatrix3x4(Matrix matrix) {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createTransformationMatrix3x4(matrix);
	}

	public TransformationMatrix4x4 createTransformationMatrix4x4() {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createTransformationMatrix4x4();
	}

	public TransformationMatrix4x4 createTransformationMatrix4x4(Matrix matrix) {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createTransformationMatrix4x4(matrix);
	}

	public XalAddressProperty createXalAddressProperty() {
		return (AbstractCoreFactoryImpl.getInstance(coreModule)).createXalAddressProperty();
	}
	
	public Appearance createAppearance() {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createAppearance();
	}

	public AppearanceMember createAppearanceMember() {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createAppearanceMember();
	}

	public AppearanceProperty createAppearanceProperty() {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createAppearanceProperty();
	}

	public Color createColor() {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createColor();
	}

	public Color createColor(Double red, Double green, Double blue) {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createColor(red, green, blue);
	}

	public ColorPlusOpacity createColorPlusOpacity() {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createColorPlusOpacity();
	}

	public ColorPlusOpacity createColorPlusOpacity(Color color, Double opacity) {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createColorPlusOpacity(color, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue, Double opacity) {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createColorPlusOpacity(defaultColorValue, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double defaulColorValue) {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createColorPlusOpacity(defaulColorValue);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double red, Double green, Double blue, Double opacity) {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createColorPlusOpacity(red, green, blue, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double red, Double green, Double blue) {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createColorPlusOpacity(red, green, blue);
	}

	public GeoreferencedTexture createGeoreferencedTexture() {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createGeoreferencedTexture();
	}

	public ParameterizedTexture createParameterizedTexture() {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createParameterizedTexture();
	}

	public SurfaceDataProperty createSurfaceDataProperty() {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createSurfaceDataProperty();
	}

	public TexCoordGen createTexCoordGen() {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createTexCoordGen();
	}

	public TexCoordList createTexCoordList() {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createTexCoordList();
	}

	public TextureAssociation createTextureAssociation() {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createTextureAssociation();
	}

	public TextureCoordinates createTextureCoordinates() {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createTextureCoordinates();
	}

	public TextureType createTextureType(String textureType) {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createTextureType(textureType);
	}

	public WorldToTexture createWorldToTexture() {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createWorldToTexture();
	}

	public WrapMode createWrapMode(String wrapMode) {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createWrapMode(wrapMode);
	}

	public X3DMaterial createX3DMaterial() {
		return (AbstractAppearanceFactoryImpl.getInstance(appModule)).createX3DMaterial();
	}
	
	public BoundarySurfaceProperty createBoundarySurfaceProperty() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createBoundarySurfaceProperty();
	}

	public Building createBuilding() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createBuilding();
	}

	public BuildingFurniture createBuildingFurniture() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createBuildingFurniture();
	}

	public BuildingInstallation createBuildingInstallation() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createBuildingInstallation();
	}

	public BuildingInstallationProperty createBuildingInstallationProperty() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createBuildingInstallationProperty();
	}

	public BuildingPart createBuildingPart() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createBuildingPart();
	}

	public BuildingPartProperty createBuildingPartProperty() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createBuildingPartProperty();
	}

	public CeilingSurface createCeilingSurface() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createCeilingSurface();
	}

	public ClosureSurface createClosureSurface() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createClosureSurface();
	}

	public Door createDoor() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createDoor();
	}

	public FloorSurface createFloorSurface() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createFloorSurface();
	}

	public GroundSurface createGroundSurface() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createGroundSurface();
	}

	public IntBuildingInstallation createIntBuildingInstallation() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createIntBuildingInstallation();
	}

	public IntBuildingInstallationProperty createIntBuildingInstallationProperty() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createIntBuildingInstallationProperty();
	}

	public InteriorFurnitureProperty createInteriorFurnitureProperty() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createInteriorFurnitureProperty();
	}

	public InteriorRoomProperty createInteriorRoomProperty() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createInteriorRoomProperty();
	}

	public InteriorWallSurface createInteriorWallSurface() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createInteriorWallSurface();
	}

	public OpeningProperty createOpeningProperty() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createOpeningProperty();
	}

	public RoofSurface createRoofSurface() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createRoofSurface();
	}

	public Room createRoom() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createRoom();
	}

	public WallSurface createWallSurface() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createWallSurface();
	}

	public Window createWindow() {
		return (AbstractBuildingFactoryImpl.getInstance(bldgModule)).createWindow();
	}

	public CityFurniture createCityFurniture() {
		return (AbstractCityFurnitureFactoryImpl.getInstance(frnModule)).createCityFurniture();
	}

	public CityObjectGroup createCityObjectGroup() {
		return (AbstractCityObjectGroupFactoryImpl.getInstance(grpModule)).createCityObjectGroup();
	}

	public CityObjectGroupMember createCityObjectGroupMember() {
		return (AbstractCityObjectGroupFactoryImpl.getInstance(grpModule)).createCityObjectGroupMember();
	}

	public CityObjectGroupParent createCityObjectGroupParent() {
		return (AbstractCityObjectGroupFactoryImpl.getInstance(grpModule)).createCityObjectGroupParent();
	}

	public GenericCityObject createGenericCityObject() {
		return (AbstractGenericsFactoryImpl.getInstance(genModule)).createGenericCityObject();
	}

	public GenericDateAttribute createGenericDateAttribute() {
		return (AbstractGenericsFactoryImpl.getInstance(genModule)).createGenericDateAttribute();
	}

	public GenericDoubleAttribute createGenericDoubleAttribute() {
		return (AbstractGenericsFactoryImpl.getInstance(genModule)).createGenericDoubleAttribute();
	}

	public GenericIntAttribute createGenericIntAttribute() {
		return (AbstractGenericsFactoryImpl.getInstance(genModule)).createGenericIntAttribute();
	}

	public GenericStringAttribute createGenericStringAttribute() {
		return (AbstractGenericsFactoryImpl.getInstance(genModule)).createGenericStringAttribute();
	}

	public GenericUriAttribute createGenericUriAttribute() {
		return (AbstractGenericsFactoryImpl.getInstance(genModule)).createGenericUriAttribute();
	}

	public LandUse createLandUse() {
		return (AbstractLandUseFactoryImpl.getInstance(luseModule)).createLandUse();
	}

	public BreaklineRelief createBreaklineRelief() {
		return (AbstractReliefFactoryImpl.getInstance(demModule)).createBreaklineRelief();
	}

	public MassPointRelief createMassPointRelief() {
		return (AbstractReliefFactoryImpl.getInstance(demModule)).createMassPointRelief();
	}

	public RasterRelief createRasterRelief() {
		return (AbstractReliefFactoryImpl.getInstance(demModule)).createRasterRelief();
	}

	public ReliefComponentProperty createReliefComponentProperty() {
		return (AbstractReliefFactoryImpl.getInstance(demModule)).createReliefComponentProperty();
	}

	public ReliefFeature createReliefFeature() {
		return (AbstractReliefFactoryImpl.getInstance(demModule)).createReliefFeature();
	}

	public TINRelief createTINRelief() {
		return (AbstractReliefFactoryImpl.getInstance(demModule)).createTINRelief();
	}

	public TinProperty createTinProperty() {
		return (AbstractReliefFactoryImpl.getInstance(demModule)).createTinProperty();
	}

	public AuxiliaryTrafficArea createAuxiliaryTrafficArea() {
		return (AbstractTransportationFactoryImpl.getInstance(tranModule)).createAuxiliaryTrafficArea();
	}

	public AuxiliaryTrafficAreaProperty createAuxiliaryTrafficAreaProperty() {
		return (AbstractTransportationFactoryImpl.getInstance(tranModule)).createAuxiliaryTrafficAreaProperty();
	}

	public Railway createRailway() {
		return (AbstractTransportationFactoryImpl.getInstance(tranModule)).createRailway();
	}

	public Road createRoad() {
		return (AbstractTransportationFactoryImpl.getInstance(tranModule)).createRoad();
	}

	public Square createSquare() {
		return (AbstractTransportationFactoryImpl.getInstance(tranModule)).createSquare();
	}

	public Track createTrack() {
		return (AbstractTransportationFactoryImpl.getInstance(tranModule)).createTrack();
	}

	public TrafficArea createTrafficArea() {
		return (AbstractTransportationFactoryImpl.getInstance(tranModule)).createTrafficArea();
	}

	public TrafficAreaProperty createTrafficAreaProperty() {
		return (AbstractTransportationFactoryImpl.getInstance(tranModule)).createTrafficAreaProperty();
	}

	public TransportationComplex createTransportationComplex() {
		return (AbstractTransportationFactoryImpl.getInstance(tranModule)).createTransportationComplex();
	}

	public PlantCover createPlantCover() {
		return (AbstractVegetationFactoryImpl.getInstance(vegModule)).createPlantCover();
	}

	public SolitaryVegetationObject createSolitaryVegetationObject() {
		return (AbstractVegetationFactoryImpl.getInstance(vegModule)).createSolitaryVegetationObject();
	}

	public BoundedByWaterSurfaceProperty createBoundedByWaterSurfaceProperty() {
		return (AbstractWaterBodyFactoryImpl.getInstance(wtrModule)).createBoundedByWaterSurfaceProperty();
	}

	public WaterBody createWaterBody() {
		return (AbstractWaterBodyFactoryImpl.getInstance(wtrModule)).createWaterBody();
	}

	public WaterClosureSurface createWaterClosureSurface() {
		return (AbstractWaterBodyFactoryImpl.getInstance(wtrModule)).createWaterClosureSurface();
	}

	public WaterGroundSurface createWaterGroundSurface() {
		return (AbstractWaterBodyFactoryImpl.getInstance(wtrModule)).createWaterGroundSurface();
	}

	public WaterSurface createWaterSurface() {
		return (AbstractWaterBodyFactoryImpl.getInstance(wtrModule)).createWaterSurface();
	}

	public _AppearanceProperty create_AppearanceProperty() {
		return (AbstractTexturedSurfaceFactoryImpl.getInstance(texModule)).create_AppearanceProperty();
	}

	public _Material create_Material() {
		return (AbstractTexturedSurfaceFactoryImpl.getInstance(texModule)).create_Material();
	}

	public _SimpleTexture create_SimpleTexture() {
		return (AbstractTexturedSurfaceFactoryImpl.getInstance(texModule)).create_SimpleTexture();
	}

	public _TexturedSurface create_TexturedSurface() {
		return (AbstractTexturedSurfaceFactoryImpl.getInstance(texModule)).create_TexturedSurface();
	}

	public _Color create_Color() {
		return (AbstractTexturedSurfaceFactoryImpl.getInstance(texModule)).create_Color();
	}

	public _Color create_Color(Double red, Double green, Double blue) {
		return (AbstractTexturedSurfaceFactoryImpl.getInstance(texModule)).create_Color(red, green, blue);
	}

	public _TextureType create_TextureType(String _textureType) {
		return (AbstractTexturedSurfaceFactoryImpl.getInstance(texModule)).create_TextureType(_textureType);
	}
	
	// getters and setters
	public AppearanceModule getAppearanceModule() {
		return appModule;
	}

	public void setAppearanceModule(AppearanceModule appearanceModule) {
		appModule = appearanceModule;
	}

	public BuildingModule getBuildingModule() {
		return bldgModule;
	}

	public void setBuildingModule(BuildingModule buildingModule) {
		bldgModule = buildingModule;
	}

	public CityFurnitureModule getCityFurnitureModule() {
		return frnModule;
	}

	public void setCityFurnitureModule(CityFurnitureModule cityFurnitureModule) {
		frnModule = cityFurnitureModule;
	}

	public CityObjectGroupModule getCityObjectGroupModule() {
		return grpModule;
	}

	public void setCityObjectGroupModule(CityObjectGroupModule cityObjectGroupModule) {
		grpModule = cityObjectGroupModule;
	}

	public CoreModule getCoreModule() {
		return coreModule;
	}

	public void setCoreModule(CoreModule coreModule) {
		this.coreModule = coreModule;
	}

	public GenericsModule getGenericsModule() {
		return genModule;
	}

	public void setGenericsModule(GenericsModule genericsModule) {
		genModule = genericsModule;
	}

	public LandUseModule getLandUseModule() {
		return luseModule;
	}

	public void setLandUseModule(LandUseModule landUseModule) {
		luseModule = landUseModule;
	}

	public ReliefModule getReliefModule() {
		return demModule;
	}

	public void setReliefModule(ReliefModule reliefModule) {
		demModule = reliefModule;
	}

	public TexturedSurfaceModule getTexturedSurfaceModule() {
		return texModule;
	}

	public void setTexturedSurfaceModule(TexturedSurfaceModule texturedSurfaceModule) {
		texModule = texturedSurfaceModule;
	}

	public TransportationModule getTransportationModule() {
		return tranModule;
	}

	public void setTransportationModule(TransportationModule transportationModule) {
		tranModule = transportationModule;
	}

	public VegetationModule getVegetationModule() {
		return vegModule;
	}

	public void setVegetationModule(VegetationModule vegetationModule) {
		vegModule = vegetationModule;
	}

	public WaterBodyModule getWaterBodyModule() {
		return wtrModule;
	}

	public void setWaterBodyModule(WaterBodyModule waterBodyModule) {
		wtrModule = waterBodyModule;
	}
	
	public void setCityGMLModuleVersion(CityGMLModuleVersion version) {
		switch (version) {
		case v0_4_0:
		case v1_0_0:
			init(version);
			break;
		default:
			throw new IllegalArgumentException("illegal CityGML module version");
		}
	}
	
	private void init(CityGMLModuleVersion version) {
		appModule = (AppearanceModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.APPEARANCE, version);
		bldgModule = (BuildingModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.BUILDING, version);
		frnModule = (CityFurnitureModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.CITYFURNITURE, version);
		grpModule = (CityObjectGroupModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.CITYOBJECTGROUP, version);
		coreModule = (CoreModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.CORE, version);
		genModule = (GenericsModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.GENERICS, version);
		luseModule = (LandUseModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.LANDUSE, version);
		demModule = (ReliefModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.RELIEF, version);
		texModule = (TexturedSurfaceModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.TEXTUREDSURFACE, version);
		tranModule = (TransportationModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.TRANSPORTATION, version);
		vegModule = (VegetationModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.VEGETATION, version);
		wtrModule = (WaterBodyModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.WATERBODY, version);
	}
}
