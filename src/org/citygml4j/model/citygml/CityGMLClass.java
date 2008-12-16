package org.citygml4j.model.citygml;

public enum CityGMLClass {
	// String representation follows the official naming. 
	// It is mainly used to ensure a consistent String representation, e.g.
	// for attributes of database tables
	UNDEFINED("undefined", null, null) {
		public CityGMLClass getParent() { return UNDEFINED; }
	},
	GMLGEOMETRY("gmlGeometry", UNDEFINED, null),
	ADE("ApplicationDomainExtension", UNDEFINED, null),
	
	// Core
	CITYOBJECT("_CityObject", UNDEFINED, CityGMLModuleType.CORE),
	CITYMODEL("CityModel", UNDEFINED, CityGMLModuleType.CORE),
	ADDRESS("Address", UNDEFINED, CityGMLModuleType.CORE),
	EXTERNALOBJECT("externalObject", UNDEFINED, CityGMLModuleType.CORE),
	EXTERNALREFERENCE("externalReference", UNDEFINED, CityGMLModuleType.CORE),
	IMPLICITGEOMETRY("ImplicitGeometry", UNDEFINED, CityGMLModuleType.CORE),
	SITE("_Site", CITYOBJECT, CityGMLModuleType.CORE),
	ADDRESSPROPERTY("AddressPropertyType", UNDEFINED, CityGMLModuleType.CORE),
	CITYOBJECTMEMBER("cityObjectMember", UNDEFINED, CityGMLModuleType.CORE),
	GENERALIZATIONRELATION("GeneralizationRelationType", UNDEFINED, CityGMLModuleType.CORE),
	IMPLICITREPRESENTATIONPROPERTY("ImplicitRepresentationPropertyType", UNDEFINED, CityGMLModuleType.CORE),
	XALADDRESSPROPERTYTYPE("xalAddressPropertyType", UNDEFINED, CityGMLModuleType.CORE),	
	TRANSFORMATIONMATRIX2X2("TransformationMatrix2x2Type", UNDEFINED, CityGMLModuleType.CORE),
	TRANSFORMATIONMATRIX3X4("TransformationMatrix3x4Type", UNDEFINED, CityGMLModuleType.CORE),
	TRANSFORMATIONMATRIX4X4("TransformationMatrix4x4Type", UNDEFINED, CityGMLModuleType.CORE),

	// Appearance
	APPEARANCE("Appearance", UNDEFINED, CityGMLModuleType.APPEARANCE),
	ABSTRACTSURFACEDATA("_SurfaceData", UNDEFINED, CityGMLModuleType.APPEARANCE),
	ABSTRACTTEXTURE("_Texture", ABSTRACTSURFACEDATA, CityGMLModuleType.APPEARANCE),	
	COLOR("Color", UNDEFINED, CityGMLModuleType.APPEARANCE),
	COLORPLUSOPACITY("ColorPlusOpacity", UNDEFINED, CityGMLModuleType.APPEARANCE),
	GEOREFERENCEDTEXTURE("GeoreferencedTexture", ABSTRACTTEXTURE, CityGMLModuleType.APPEARANCE),
	PARAMETERIZEDTEXTURE("ParameterizedTexture", ABSTRACTTEXTURE, CityGMLModuleType.APPEARANCE),
	TEXTUREPARAMETERIZATION("_TextureParameterization", UNDEFINED, CityGMLModuleType.APPEARANCE),
	TEXCOORDGEN("TexCoordGen", TEXTUREPARAMETERIZATION, CityGMLModuleType.APPEARANCE),
	TEXCOORDLIST("TexCoordList", TEXTUREPARAMETERIZATION, CityGMLModuleType.APPEARANCE),
	TEXTURECOORDINATES("textureCoordinates", UNDEFINED, CityGMLModuleType.APPEARANCE),
	TEXTURETYPE("TextureTypeType", UNDEFINED, CityGMLModuleType.APPEARANCE),
	WORLDTOTEXTURE("worldToTexture", UNDEFINED, CityGMLModuleType.APPEARANCE),
	WRAPMODE("WrapModeType", UNDEFINED, CityGMLModuleType.APPEARANCE),
	X3DMATERIAL("X3DMaterial", ABSTRACTSURFACEDATA, CityGMLModuleType.APPEARANCE),
	APPEARANCEMEMBER("appearanceMember", UNDEFINED, CityGMLModuleType.APPEARANCE),
	APPEARANCEPROPERTY("AppearancePropertyType", UNDEFINED, CityGMLModuleType.APPEARANCE),
	SURFACEDATAPROPERTY("SurfaceDataPropertyType", UNDEFINED, CityGMLModuleType.APPEARANCE),
	TEXTUREASSOCIATION("TextureAssociationType", UNDEFINED, CityGMLModuleType.APPEARANCE),
	
	// Building	
	ABSTRACTBUILDING("_AbstractBuilding", SITE, CityGMLModuleType.BUILDING),
	BUILDING("Building", ABSTRACTBUILDING, CityGMLModuleType.BUILDING),
	BUILDINGFURNITURE("BuildingFurniture", CITYOBJECT, CityGMLModuleType.BUILDING),
	BUILDINGINSTALLATION("BuildingInstallation", CITYOBJECT, CityGMLModuleType.BUILDING),
	BUILDINGPART("BuildingPart", ABSTRACTBUILDING, CityGMLModuleType.BUILDING),
	INTBUILDINGINSTALLATION("IntBuildingInstallation", CITYOBJECT, CityGMLModuleType.BUILDING),
	ROOM("Room", CITYOBJECT, CityGMLModuleType.BUILDING),	
	BOUNDARYSURFACE("_BoundarySurface", CITYOBJECT, CityGMLModuleType.BUILDING),
	CEILINGSURFACE("CeilingSurface", BOUNDARYSURFACE, CityGMLModuleType.BUILDING),
	CLOSURESURFACE("ClosureSurface", BOUNDARYSURFACE, CityGMLModuleType.BUILDING),
	FLOORSURFACE("FloorSurface", BOUNDARYSURFACE, CityGMLModuleType.BUILDING),
	GROUNDSURFACE("GroundSurface", BOUNDARYSURFACE, CityGMLModuleType.BUILDING),	
	INTERIORWALLSURFACE("InteriorWallSurface", BOUNDARYSURFACE, CityGMLModuleType.BUILDING),
	ROOFSURFACE("RoofSurface", BOUNDARYSURFACE, CityGMLModuleType.BUILDING),
	WALLSURFACE("WallSurface", BOUNDARYSURFACE, CityGMLModuleType.BUILDING),	
	OPENING("_Opening", CITYOBJECT, CityGMLModuleType.BUILDING) ,
	DOOR("Door", OPENING, CityGMLModuleType.BUILDING),
	WINDOW("Window", OPENING, CityGMLModuleType.BUILDING),	
	BOUNDARYSURFACEPROPERTY("BoundarySurfacePropertyType", UNDEFINED, CityGMLModuleType.BUILDING),
	BUILDINGINSTALLATIONPROPERTY("BuildingInstallationPropertyType", UNDEFINED, CityGMLModuleType.BUILDING),
	BUILDINGPARTPROPERTY("BuildingPartPropertyType", UNDEFINED, CityGMLModuleType.BUILDING),
	INTBUILDINGINSTALLATIONPROPERTY("IntBuildingInstallationPropertyType", UNDEFINED, CityGMLModuleType.BUILDING),
	INTERIORFURNITUREPROPERTY("InteriorFurniturePropertyType", UNDEFINED, CityGMLModuleType.BUILDING),
	INTERIORROOMPROPERTY("InteriorRoomPropertyType", UNDEFINED, CityGMLModuleType.BUILDING),
	OPENINGPROPERTY("OpeningPropertyType", UNDEFINED, CityGMLModuleType.BUILDING),
	
	// CityFurniture
	CITYFURNITURE("CityFurniture", CITYOBJECT, CityGMLModuleType.CITYFURNITURE),
	
	// CityObjectGroup
	CITYOBJECTGROUP("CityObjectGroup", CITYOBJECT, CityGMLModuleType.CITYOBJECTGROUP),
	CITYOBJECTGROUPMEMBER("CityObjectGroupMemberType", UNDEFINED, CityGMLModuleType.CITYOBJECTGROUP),
	CITYOBJECTGROUPPARENT("CityObjectGroupParentType", UNDEFINED, CityGMLModuleType.CITYOBJECTGROUP),
	
	// Generics
	GENERICATTRIBUTE("_genericAttribute", UNDEFINED, CityGMLModuleType.GENERICS),
	GENERICCITYOBJECT("GenericCityObject", CITYOBJECT, CityGMLModuleType.GENERICS),
	DATEATTRIBUTE("dateAttribute", GENERICATTRIBUTE, CityGMLModuleType.GENERICS),
	DOUBLEATTRIBUTE("doubleAttribute", GENERICATTRIBUTE, CityGMLModuleType.GENERICS),
	INTATTRIBUTE("intAttribute", GENERICATTRIBUTE, CityGMLModuleType.GENERICS),
	STRINGATTRIBUTE("stringAttribute", GENERICATTRIBUTE, CityGMLModuleType.GENERICS),
	URIATTRIBUTE("uriAttribute", GENERICATTRIBUTE, CityGMLModuleType.GENERICS),
	
	// LandUse
	LANDUSE("LandUse", CITYOBJECT, CityGMLModuleType.LANDUSE),
	
	// Relief
	RELIEFCOMPONENT("ReliefComponent", CITYOBJECT, CityGMLModuleType.RELIEF),
	RELIEFFEATURE("ReliefFeature", CITYOBJECT, CityGMLModuleType.RELIEF),
	BREAKLINERELIEF("BreaklineRelief", RELIEFCOMPONENT, CityGMLModuleType.RELIEF),
	MASSPOINTRELIEF("MassPointRelief", RELIEFCOMPONENT, CityGMLModuleType.RELIEF),
	RASTERRELIEF("RasterRelief", RELIEFCOMPONENT, CityGMLModuleType.RELIEF),
	TINRELIEF("TINRelief", RELIEFCOMPONENT, CityGMLModuleType.RELIEF),
	RELIEFCOMPONENTPROPERTY("ReliefComponentProperty", UNDEFINED, CityGMLModuleType.RELIEF),
	TINPROPERTY("tinPropertyType", UNDEFINED, CityGMLModuleType.RELIEF),
	
	// Transportation
	TRANSPORTATIONOBJECT("_TransportationObject", CITYOBJECT, CityGMLModuleType.TRANSPORTATION),
	TRANSPORTATIONCOMPLEX("TransportationComplex", TRANSPORTATIONOBJECT, CityGMLModuleType.TRANSPORTATION),	
	AUXILIARYTRAFFICAREA("AuxiliaryTrafficArea", TRANSPORTATIONOBJECT, CityGMLModuleType.TRANSPORTATION),	
	RAILWAY("Railway", TRANSPORTATIONCOMPLEX, CityGMLModuleType.TRANSPORTATION),	
	ROAD("Road", TRANSPORTATIONCOMPLEX, CityGMLModuleType.TRANSPORTATION),
	SQUARE("Square", TRANSPORTATIONCOMPLEX, CityGMLModuleType.TRANSPORTATION),	
	TRACK("Track", TRANSPORTATIONCOMPLEX, CityGMLModuleType.TRANSPORTATION),
	TRAFFICAREA("TrafficArea", TRANSPORTATIONOBJECT, CityGMLModuleType.TRANSPORTATION),
	AUXILIARYTRAFFICAREAPROPERTY("AppearancePropertyType", UNDEFINED, CityGMLModuleType.TRANSPORTATION),
	TRAFFICAREAPROPERTY("TrafficAreaPropertyType", UNDEFINED, CityGMLModuleType.TRANSPORTATION),
	
	// Vegetation	
	VEGETATIONOBJECT("_VegetationObject", CITYOBJECT, CityGMLModuleType.VEGETATION),
	PLANTCOVER("PlantCover", VEGETATIONOBJECT, CityGMLModuleType.VEGETATION),	
	SOLITARYVEGETATIONOBJECT("SolitaryVegetationObject", VEGETATIONOBJECT, CityGMLModuleType.VEGETATION),
	
	// WaterBody	
	WATEROBJECT("_WaterObject", CITYOBJECT, CityGMLModuleType.WATERBODY),
	WATERBODY("WaterBody", WATEROBJECT, CityGMLModuleType.WATERBODY),
	WATERBOUNDARYSURFACE("_WaterBoundarySurface", CITYOBJECT, CityGMLModuleType.WATERBODY),
	WATERCLOSURESURFACE("WaterClosureSurface", WATERBOUNDARYSURFACE, CityGMLModuleType.WATERBODY),
	WATERGROUNDSURFACE("WaterGroundSurface", WATERBOUNDARYSURFACE, CityGMLModuleType.WATERBODY),	
	WATERSURFACE("WaterSurface", WATERBOUNDARYSURFACE, CityGMLModuleType.WATERBODY),
	BOUNDEDBYWATERSURFACEPROPERTY("BoundedByWaterSurfacePropertyType", UNDEFINED, CityGMLModuleType.WATERBODY),
	
	// TexturedSurface
	_APPEARANCE("_Appearance", UNDEFINED, CityGMLModuleType.TEXTUREDSURFACE),
	_MATERIAL("Material", _APPEARANCE, CityGMLModuleType.TEXTUREDSURFACE),
	_SIMPLETEXTURE("SimpleTexture", _APPEARANCE, CityGMLModuleType.TEXTUREDSURFACE),
	_TEXTUREDSURFACE("TexturedSurface", GMLGEOMETRY, CityGMLModuleType.TEXTUREDSURFACE),	
	_COLOR("Color", UNDEFINED, CityGMLModuleType.TEXTUREDSURFACE),
	_TEXTURETYPE("TextureTypeType", UNDEFINED, CityGMLModuleType.TEXTUREDSURFACE),
	_APPEARANCEPROPERTY("AppearancePropertyType", UNDEFINED, CityGMLModuleType.TEXTUREDSURFACE);
	
	private final String value;
	private final CityGMLClass parent;
	private final CityGMLModuleType moduleName;

	CityGMLClass(String value, CityGMLClass parent, CityGMLModuleType moduleName) {
		this.value = value;
		this.parent = parent;
		this.moduleName = moduleName;
	}

	public String getValue() {
		return value;
	}

	public static CityGMLClass fromValue(String v) {
		for (CityGMLClass c: CityGMLClass.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}

		return UNDEFINED;
	}

	public static CityGMLClass fromInt(int i) {
		for (CityGMLClass c : CityGMLClass.values()) {
			if (c.ordinal() == i) {
				return c;
			}
		}

		return UNDEFINED;
	}
	
	public String toString() {
		return value;
	}
	
	public CityGMLClass getParent() {
		return parent;
	}
	
	public CityGMLClass getBaseClass() {
		CityGMLClass type = this;
		
		while (type.getParent() != UNDEFINED)
			type = type.getParent();
		
		return type;
	}
	
	public boolean childOrSelf(CityGMLClass ancestor) {
		CityGMLClass type = this;
		
		if (type == ancestor)
			return true;
		
		while (type.getParent() != UNDEFINED) {			
			type = type.getParent();			
			if (type == ancestor)
				return true;
		}
		
		return false;
	}
	
	public CityGMLModuleType getModuleName() {
		return moduleName;
	}
}
