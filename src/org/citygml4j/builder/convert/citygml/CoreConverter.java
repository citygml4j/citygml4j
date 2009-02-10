package org.citygml4j.builder.convert.citygml;

import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.building.CeilingSurface;
import org.citygml4j.model.citygml.building.ClosureSurface;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.building.FloorSurface;
import org.citygml4j.model.citygml.building.GroundSurface;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.InteriorWallSurface;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
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
import org.citygml4j.model.citygml.generics.GenericAttribute;
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
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.gml.FeatureProperty;
import org.citygml4j.model.gml.GeometryProperty;

public class CoreConverter {
	private CityGMLConvertBuilder builder;
	private CityGMLFactory citygml;

	protected CoreConverter(CityGMLConvertBuilder builder) {
		this.builder = builder;
		citygml = new CityGMLFactory();
	}

	protected Address convertAddress(Address src) {
		Address dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof Address)
				dest = (Address)tmp;
		} else {
			dest = citygml.createAddress(builder.convertContext.coreModule);
			if (dest != null) 
				convertAddress(src, dest);
		}

		return dest;
	}

	protected AddressProperty convertAddressProperty(AddressProperty src) {
		AddressProperty dest = citygml.createAddressProperty(builder.convertContext.coreModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				Address tmp = convertAddress(src.getObject());
				if (tmp != null)
					dest.setObject(tmp);
			}
		}

		return dest;
	}
	
	protected CityObject convertCityObject(CityObject src) {
		CityObject tmp = null;

		if (src instanceof Building)
			tmp = builder.bldg.convertBuilding((Building)src);
		else if (src instanceof BuildingPart)
			tmp = builder.bldg.convertBuildingPart((BuildingPart)src);
		else if (src instanceof BuildingFurniture)
			tmp = builder.bldg.convertBuildingFurniture((BuildingFurniture)src);
		else if (src instanceof BuildingInstallation)
			tmp = builder.bldg.convertBuildingInstallation((BuildingInstallation)src);	
		else if (src instanceof IntBuildingInstallation)
			tmp = builder.bldg.convertIntBuildingInstallation((IntBuildingInstallation)src);
		else if (src instanceof CeilingSurface)
			tmp = builder.bldg.convertCeilingSurface((CeilingSurface)src);
		else if (src instanceof ClosureSurface)
			tmp = builder.bldg.convertClosureSurface((ClosureSurface)src);
		else if (src instanceof FloorSurface)
			tmp = builder.bldg.convertFloorSurface((FloorSurface)src);
		else if (src instanceof GroundSurface)
			tmp = builder.bldg.convertGroundSurface((GroundSurface)src);
		else if (src instanceof InteriorWallSurface)
			tmp = builder.bldg.convertInteriorWallSurface((InteriorWallSurface)src);
		else if (src instanceof RoofSurface)
			tmp = builder.bldg.convertRoofSurface((RoofSurface)src);
		else if (src instanceof WallSurface)
			tmp = builder.bldg.convertWallSurface((WallSurface)src);
		else if (src instanceof Room)
			tmp = builder.bldg.convertRoom((Room)src);
		else if (src instanceof Door)
			tmp = builder.bldg.convertDoor((Door)src);
		else if (src instanceof Window)
			tmp = builder.bldg.convertWindow((Window)src);
		
		else if (src instanceof LandUse)
			tmp = builder.luse.convertLandUse((LandUse)src);
		
		else if (src instanceof TrafficArea)
			tmp = builder.tran.convertTrafficArea((TrafficArea)src);
		else if (src instanceof AuxiliaryTrafficArea)
			tmp = builder.tran.convertAuxiliaryTrafficArea((AuxiliaryTrafficArea)src);
		else if (src instanceof Railway)
			tmp = builder.tran.convertRailway((Railway)src);
		else if (src instanceof Road)
			tmp = builder.tran.convertRoad((Road)src);	
		else if (src instanceof Square)
			tmp = builder.tran.convertSquare((Square)src);
		else if (src instanceof Track)
			tmp = builder.tran.convertTrack((Track)src);
		else if (src instanceof TransportationComplex)
			tmp = builder.tran.convertTransportationComplex((TransportationComplex)src);
		
		else if (src instanceof PlantCover)
			tmp = builder.veg.convertPlantCover((PlantCover)src);
		else if (src instanceof SolitaryVegetationObject)
			tmp = builder.veg.convertSolitaryVegetationObject((SolitaryVegetationObject)src);	
		
		else if (src instanceof WaterBody)
			tmp = builder.wtr.convertWaterBody((WaterBody)src);
		else if (src instanceof WaterClosureSurface)
			tmp = builder.wtr.convertWaterClosureSurface((WaterClosureSurface)src);
		else if (src instanceof WaterGroundSurface)
			tmp = builder.wtr.convertWaterGroundSurface((WaterGroundSurface)src);
		else if (src instanceof WaterSurface)
			tmp = builder.wtr.convertWaterSurface((WaterSurface)src);		
		
		else if (src instanceof GenericCityObject)
			tmp = builder.gen.convertGenericCityObject((GenericCityObject)src);
		
		else if (src instanceof CityObjectGroup)
			tmp = builder.grp.convertCityObjectGroup((CityObjectGroup)src);
		
		else if (src instanceof ReliefFeature)
			tmp = builder.dem.convertReliefFeature((ReliefFeature)src);
		else if (src instanceof BreaklineRelief)
			tmp = builder.dem.convertBreaklineRelief((BreaklineRelief)src);
		else if (src instanceof RasterRelief)
			tmp = builder.dem.convertRasterRelief((RasterRelief)src);
		else if (src instanceof MassPointRelief)
			tmp = builder.dem.convertMassPointRelief((MassPointRelief)src);	
		else if (src instanceof TINRelief)
			tmp = builder.dem.convertTINRelief((TINRelief)src);
		
		else if (src instanceof CityFurniture)
			tmp = builder.frn.convertCityFurniture((CityFurniture)src);
		
		else if (src instanceof ADEComponent) {
			ADEComponent tmpADE = builder.ade.convertADEComponent((ADEComponent)src);
			if (tmpADE != null && tmpADE instanceof CityObject)
				tmp = (CityObject)tmpADE;
		}
		
		return tmp;
	}

	protected CityModel convertCityModel(CityModel src) {
		CityModel dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof CityModel)
				dest = (CityModel)tmp;
		} else {
			dest = citygml.createCityModel(builder.convertContext.coreModule);
			if (dest != null)
				convertCityModel(src, dest);
		}

		return dest;
	}

	protected CityObjectMember convertCityObjectMember(CityObjectMember src) {
		CityObjectMember dest = citygml.createCityObjectMember(builder.convertContext.coreModule);	
		if (dest != null) {
			builder.gml.convertAssociationAttributeGroup(src, dest);

			if (src.isSetCityObject()) {
				CityObject tmp = convertCityObject(src.getCityObject());
				if (tmp != null)
					dest.setCityObject(tmp);
			}
		}

		return dest;
	}

	protected ExternalObject convertExternalObject(ExternalObject src) {
		ExternalObject dest = citygml.createExternalObject(builder.convertContext.coreModule);
		if (dest != null) {
			if (src.isSetName())
				dest.setName(src.getName());

			if (src.isSetUri())
				dest.setUri(src.getUri());
		}

		return dest;
	}

	protected ExternalReference convertExternalReference(ExternalReference src) {
		ExternalReference dest = citygml.createExternalReference(builder.convertContext.coreModule);
		if (dest != null) {
			if (src.isSetInformationSystem())
				dest.setInformationSystem(src.getInformationSystem());

			if (src.isSetExternalObject()) {
				ExternalObject tmp = convertExternalObject(src.getExternalObject());
				if (tmp != null)
					dest.setExternalObject(tmp);
			}
		}

		return dest;
	}

	protected GeneralizationRelation convertGeneralizationRelation(GeneralizationRelation src) {
		GeneralizationRelation dest = citygml.createGeneralizationRelation(builder.convertContext.coreModule);		
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				CityObject tmp = convertCityObject(src.getObject());
				if (tmp != null)
					dest.setObject(tmp);
			}
		}

		return dest;
	}

	protected ImplicitGeometry convertImplicitGeometry(ImplicitGeometry src) {
		ImplicitGeometry dest = citygml.createImplicitGeometry(builder.convertContext.coreModule);
		if (dest != null) {
			builder.gml.convertAbstractGML(src, dest);

			if (src.isSetMimeType())
				dest.setMimeType(src.getMimeType());

			if (src.isSetTransformationMatrix()) {
				TransformationMatrix4x4 tmp = convertTransformationMatrix4x4(src.getTransformationMatrix());
				if (tmp != null)
					dest.setTransformationMatrix(tmp);
			}

			if (src.isSetLibraryObject())
				dest.setLibraryObject(src.getLibraryObject());

			if (src.isSetRelativeGMLGeometry()) {
				GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getRelativeGMLGeometry());
				if (tmp != null)
					dest.setRelativeGeometry(tmp);
			}

			if (src.isSetReferencePoint())
				dest.setReferencePoint(src.getReferencePoint());
		}

		return dest;
	}

	protected ImplicitRepresentationProperty convertImplicitRepresentationProperty(ImplicitRepresentationProperty src) {
		ImplicitRepresentationProperty dest = citygml.createImplicitRepresentationProperty(builder.convertContext.coreModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				ImplicitGeometry tmp = convertImplicitGeometry(src.getObject());
				if (tmp != null)
					dest.setObject(tmp);
			}
		}

		return dest;
	}

	protected TransformationMatrix2x2 convertTransformationMatrix2x2(TransformationMatrix2x2 src) {
		return citygml.createTransformationMatrix2x2(src.getMatrix(), builder.convertContext.coreModule);
	}

	protected TransformationMatrix3x4 convertTransformationMatrix3x4(TransformationMatrix3x4 src) {
		return citygml.createTransformationMatrix3x4(src.getMatrix(), builder.convertContext.coreModule);
	}

	protected TransformationMatrix4x4 convertTransformationMatrix4x4(TransformationMatrix4x4 src) {
		return citygml.createTransformationMatrix4x4(src.getMatrix(), builder.convertContext.coreModule);
	}

	protected XalAddressProperty convertXalAddressProperty(XalAddressProperty src) {
		XalAddressProperty dest = citygml.createXalAddressProperty(builder.convertContext.coreModule);
		if (dest != null) 
			if (src.isSetAddressDetails())
				dest.setAddressDetails(src.getAddressDetails());

		return dest;
	}

	protected void convertAddress(Address src, Address dest) {
		builder.gml.convertAbstractFeature(src, dest);

		if (src.isSetXalAddress()) {
			XalAddressProperty tmp = convertXalAddressProperty(src.getXalAddress());
			if (tmp != null)
				dest.setXalAddress(tmp);
		}

		if (src.isSetMultiPoint())
			dest.setMultiPoint(src.getMultiPoint());

		if (src.isSetGenericApplicationPropertyOfAddress()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfAddress()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfAddress(tmp);
			}
		}
	}

	protected void convertCityModel(CityModel src, CityModel dest) {
		builder.gml.convertAbstractFeatureCollection(src, dest);

		if (src.isSetCityObjectMember()) {
			for (CityObjectMember cityObjectMember : src.getCityObjectMember()) {
				CityObjectMember tmp = convertCityObjectMember(cityObjectMember);
				if (tmp != null)
					dest.addCityObjectMember(tmp);
			}
		}

		if (src.isSetAppearanceMember()) {
			for (AppearanceMember appearanceMember : src.getAppearanceMember()) {
				AppearanceMember tmp = builder.app.convertAppearanceMember(appearanceMember);
				if (tmp != null)
					dest.addAppearanceMember(tmp);
			}
		}

		if (src.isSetFeatureMember()) {
			for (FeatureProperty featureMember : src.getFeatureMember())
				dest.addFeatureMember(featureMember);
		}

		if (src.isSetGenericApplicationPropertyOfCityModel()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfCityModel()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfCityModel(tmp);
			}
		}
	}

	protected void convertCityObject(CityObject src, CityObject dest) {
		builder.gml.convertAbstractFeature(src, dest);

		if (src.isSetCreationDate())
			dest.setCreationDate(src.getCreationDate());

		if (src.isSetTerminationDate())
			dest.setTerminationDate(src.getTerminationDate());

		if (src.isSetExternalReference()) {
			for (ExternalReference externalReference : src.getExternalReference()) {
				ExternalReference tmp = convertExternalReference(externalReference);
				if (tmp != null)
					dest.addExternalReference(tmp);
			}
		}

		if (src.isSetGeneralizesTo()) {
			for (GeneralizationRelation generalizationRelation : src.getGeneralizesTo()) {
				GeneralizationRelation tmp = convertGeneralizationRelation(generalizationRelation);
				if (tmp != null)
					dest.addGeneralizesTo(tmp);
			}
		}

		if (src.isSetAppearance()) {
			for (AppearanceProperty appearanceProperty : src.getAppearance()) {
				AppearanceProperty tmp = builder.app.convertAppearanceProperty(appearanceProperty);
				if (tmp != null)
					dest.addAppearance(tmp);
			}
		}

		if (src.isSetGenericAttribute()) {
			for (GenericAttribute genericAttribute : src.getGenericAttribute()) {
				GenericAttribute tmp = null;

				switch (genericAttribute.getCityGMLClass()) {
				case DATEATTRIBUTE:
					tmp = builder.gen.convertGenericDateAttribute((GenericDateAttribute)genericAttribute);
					break;
				case DOUBLEATTRIBUTE:
					tmp = builder.gen.convertGenericDoubleAttribute((GenericDoubleAttribute)genericAttribute);
					break;
				case INTATTRIBUTE:
					tmp = builder.gen.convertGenericIntAttribute((GenericIntAttribute)genericAttribute);
					break;
				case STRINGATTRIBUTE:
					tmp = builder.gen.convertGenericStringAttribute((GenericStringAttribute)genericAttribute);
					break;
				case URIATTRIBUTE:
					tmp = builder.gen.convertGenericUriAttribute((GenericUriAttribute)genericAttribute);
					break;
				}

				if (tmp != null)
					dest.addGenericAttribute(tmp);
			}
		}

		if (src.isSetGenericApplicationPropertyOfCityObject()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfCityObject()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfCityObject(tmp);
			}
		}
	}

	protected void convertSite(Site src, Site dest) {
		convertCityObject(src, dest);

		if (src.isSetGenericApplicationPropertyOfSite()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfSite()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfSite(tmp);
			}
		}
	}
}
