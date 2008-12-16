package org.citygml4j.impl.jaxb.citygml.core._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AbstractFeatureImpl;
import org.citygml4j.jaxb.citygml._0_4.AuxiliaryTrafficAreaType;
import org.citygml4j.jaxb.citygml._0_4.BreaklineReliefType;
import org.citygml4j.jaxb.citygml._0_4.BuildingFurnitureType;
import org.citygml4j.jaxb.citygml._0_4.BuildingInstallationType;
import org.citygml4j.jaxb.citygml._0_4.BuildingPartType;
import org.citygml4j.jaxb.citygml._0_4.BuildingType;
import org.citygml4j.jaxb.citygml._0_4.CeilingSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.CityFurnitureType;
import org.citygml4j.jaxb.citygml._0_4.CityObjectGroupType;
import org.citygml4j.jaxb.citygml._0_4.ClosureSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.DoorType;
import org.citygml4j.jaxb.citygml._0_4.FloorSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.GenericCityObjectType;
import org.citygml4j.jaxb.citygml._0_4.GroundSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.IntBuildingInstallationType;
import org.citygml4j.jaxb.citygml._0_4.InteriorWallSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.LandUseType;
import org.citygml4j.jaxb.citygml._0_4.MassPointReliefType;
import org.citygml4j.jaxb.citygml._0_4.PlantCoverType;
import org.citygml4j.jaxb.citygml._0_4.RailwayType;
import org.citygml4j.jaxb.citygml._0_4.RasterReliefType;
import org.citygml4j.jaxb.citygml._0_4.ReliefFeatureType;
import org.citygml4j.jaxb.citygml._0_4.RoadType;
import org.citygml4j.jaxb.citygml._0_4.RoofSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.RoomType;
import org.citygml4j.jaxb.citygml._0_4.SolitaryVegetationObjectType;
import org.citygml4j.jaxb.citygml._0_4.SquareType;
import org.citygml4j.jaxb.citygml._0_4.TINReliefType;
import org.citygml4j.jaxb.citygml._0_4.TrackType;
import org.citygml4j.jaxb.citygml._0_4.TrafficAreaType;
import org.citygml4j.jaxb.citygml._0_4.TransportationComplexType;
import org.citygml4j.jaxb.citygml._0_4.WallSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.WaterBodyType;
import org.citygml4j.jaxb.citygml._0_4.WaterClosureSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.WaterGroundSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.WaterSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.WindowType;
import org.citygml4j.jaxb.citygml._0_4._AbstractBuildingType;
import org.citygml4j.jaxb.citygml._0_4._BoundarySurfaceType;
import org.citygml4j.jaxb.citygml._0_4._CityObjectType;
import org.citygml4j.jaxb.citygml._0_4._OpeningType;
import org.citygml4j.jaxb.citygml._0_4._ReliefComponentType;
import org.citygml4j.jaxb.citygml._0_4._SiteType;
import org.citygml4j.jaxb.citygml._0_4._TransportationObjectType;
import org.citygml4j.jaxb.citygml._0_4._VegetationObjectType;
import org.citygml4j.jaxb.citygml._0_4._WaterBoundarySurfaceType;
import org.citygml4j.jaxb.citygml._0_4._WaterObjectType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractFeatureType;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.building.BoundarySurface;
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
import org.citygml4j.model.citygml.building.Opening;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.core.CityObjectMapper;
import org.citygml4j.model.citygml.core.Site;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponent;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.citygml.transportation.TransportationObject;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.vegetation.VegetationObject;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterObject;
import org.citygml4j.model.citygml.waterbody.WaterSurface;

public class CityObjectMapperImpl implements CityObjectMapper {

	@Override
	public CityObject toCityGML(JAXBElement<? extends AbstractFeatureType> abstractFeature) {
		CityObject cityObject = null;
		
		if (abstractFeature.getValue() != null) {
			AbstractFeatureType elem = abstractFeature.getValue();
			QName name = abstractFeature.getName();
				
			// Building module
			if (elem instanceof BuildingType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((BuildingType)elem, name);
			else if (elem instanceof BuildingPartType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((BuildingPartType)elem, name);
			else if (elem instanceof BuildingFurnitureType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((BuildingFurnitureType)elem, name);
			else if (elem instanceof BuildingInstallationType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((BuildingInstallationType)elem, name);
			else if (elem instanceof IntBuildingInstallationType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((IntBuildingInstallationType)elem, name);
			else if (elem instanceof CeilingSurfaceType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((CeilingSurfaceType)elem, name);
			else if (elem instanceof ClosureSurfaceType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((ClosureSurfaceType)elem, name);				
			else if (elem instanceof FloorSurfaceType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((FloorSurfaceType)elem, name);
			else if (elem instanceof GroundSurfaceType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((GroundSurfaceType)elem, name);
			else if (elem instanceof InteriorWallSurfaceType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((InteriorWallSurfaceType)elem, name);
			else if (elem instanceof RoofSurfaceType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((RoofSurfaceType)elem, name);
			else if (elem instanceof WallSurfaceType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((WallSurfaceType)elem, name);				
			else if (elem instanceof RoomType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((RoomType)elem, name);					
			else if (elem instanceof DoorType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((DoorType)elem, name);
			else if (elem instanceof WindowType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((WindowType)elem, name);
			else if (elem instanceof _AbstractBuildingType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((_AbstractBuildingType)elem, name);	
			else if (elem instanceof _BoundarySurfaceType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((_BoundarySurfaceType)elem, name);	
			else if (elem instanceof _OpeningType)
				cityObject = ModelMapper.BLDG_0_4.toCityGML((_OpeningType)elem, name); 
			
			// LandUse module
			else if (elem instanceof LandUseType)
				cityObject = ModelMapper.LUSE_0_4.toCityGML((LandUseType)elem, name);	
			
			// Transportation module
			else if (elem instanceof TrafficAreaType)
				cityObject = ModelMapper.TRAN_0_4.toCityGML((TrafficAreaType)elem, name);	
			else if (elem instanceof AuxiliaryTrafficAreaType)
				cityObject = ModelMapper.TRAN_0_4.toCityGML((AuxiliaryTrafficAreaType)elem, name);	
			else if (elem instanceof RailwayType)
				cityObject = ModelMapper.TRAN_0_4.toCityGML((RailwayType)elem, name);
			else if (elem instanceof RoadType)
				cityObject = ModelMapper.TRAN_0_4.toCityGML((RoadType)elem, name);
			else if (elem instanceof SquareType)
				cityObject = ModelMapper.TRAN_0_4.toCityGML((SquareType)elem, name);
			else if (elem instanceof TrackType)
				cityObject = ModelMapper.TRAN_0_4.toCityGML((TrackType)elem, name);
			else if (elem instanceof TransportationComplexType)
				cityObject = ModelMapper.TRAN_0_4.toCityGML((TransportationComplexType)elem, name);
			else if (elem instanceof _TransportationObjectType)
				cityObject = ModelMapper.TRAN_0_4.toCityGML((_TransportationObjectType)elem, name);
			
			// Vegetation module
			else if (elem instanceof PlantCoverType)
				cityObject = ModelMapper.VEG_0_4.toCityGML((PlantCoverType)elem, name);
			else if (elem instanceof SolitaryVegetationObjectType)
				cityObject = ModelMapper.VEG_0_4.toCityGML((SolitaryVegetationObjectType)elem, name);
			else if (elem instanceof _VegetationObjectType)
				cityObject = ModelMapper.VEG_0_4.toCityGML((_VegetationObjectType)elem, name);
			
			// WaterBody module
			else if (elem instanceof WaterBodyType)
				cityObject = ModelMapper.WTR_0_4.toCityGML((WaterBodyType)elem, name);
			else if (elem instanceof WaterClosureSurfaceType)
				cityObject = ModelMapper.WTR_0_4.toCityGML((WaterClosureSurfaceType)elem, name);
			else if (elem instanceof WaterGroundSurfaceType)
				cityObject = ModelMapper.WTR_0_4.toCityGML((WaterGroundSurfaceType)elem, name);
			else if (elem instanceof WaterSurfaceType)
				cityObject = ModelMapper.WTR_0_4.toCityGML((WaterSurfaceType)elem, name);
			else if (elem instanceof _WaterObjectType)
				cityObject = ModelMapper.WTR_0_4.toCityGML((_WaterObjectType)elem, name);	
			else if (elem instanceof _WaterBoundarySurfaceType)
				cityObject = ModelMapper.WTR_0_4.toCityGML((_WaterBoundarySurfaceType)elem, name);
			
			// Generics module
			else if (elem instanceof GenericCityObjectType)
				cityObject = ModelMapper.GEN_0_4.toCityGML((GenericCityObjectType)elem, name);
			
			// CityObjectGroup module
			else if (elem instanceof CityObjectGroupType)
				cityObject = ModelMapper.GRP_0_4.toCityGML((CityObjectGroupType)elem, name);
			
			// Relief module
			else if (elem instanceof ReliefFeatureType)
				cityObject = ModelMapper.DEM_0_4.toCityGML((ReliefFeatureType)elem, name);
			else if (elem instanceof BreaklineReliefType)
				cityObject = ModelMapper.DEM_0_4.toCityGML((BreaklineReliefType)elem, name);
			else if (elem instanceof RasterReliefType)
				cityObject = ModelMapper.DEM_0_4.toCityGML((RasterReliefType)elem, name);
			else if (elem instanceof MassPointReliefType)
				cityObject = ModelMapper.DEM_0_4.toCityGML((MassPointReliefType)elem, name);
			else if (elem instanceof TINReliefType)
				cityObject = ModelMapper.DEM_0_4.toCityGML((TINReliefType)elem, name);
			else if (elem instanceof _ReliefComponentType)
				cityObject = ModelMapper.DEM_0_4.toCityGML((_ReliefComponentType)elem, name);
			
			// CityFurniture module
			else if (elem instanceof CityFurnitureType)
				cityObject = ModelMapper.FRN_0_4.toCityGML((CityFurnitureType)elem, name);

			// Core module
			else if (elem instanceof _SiteType)
				cityObject = ModelMapper.CORE_0_4.toCityGML((_SiteType)elem, name);
			else if (elem instanceof _CityObjectType)
				cityObject = ModelMapper.CORE_0_4.toCityGML((_CityObjectType)elem, name);
		}
		
		return cityObject;
	}

	@Override
	public JAXBElement<? extends AbstractFeatureType> toJAXB(CityObject cityObject) {
		JAXBElement<? extends _CityObjectType> cityObjectElem = null;

		// we only consider subclasses of _CityObjectType
		if (!(((AbstractFeatureImpl)cityObject).getJAXBObject() instanceof _CityObjectType))
			return null;
		
		// Building module
		if (cityObject instanceof Building)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((Building)cityObject);
		else if (cityObject instanceof BuildingPart)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((BuildingPart)cityObject);
		else if (cityObject instanceof BuildingFurniture)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((BuildingFurniture)cityObject);
		else if (cityObject instanceof BuildingInstallation)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((BuildingInstallation)cityObject);	
		else if (cityObject instanceof IntBuildingInstallation)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((IntBuildingInstallation)cityObject);
		else if (cityObject instanceof CeilingSurface)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((CeilingSurface)cityObject);
		else if (cityObject instanceof ClosureSurface)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((ClosureSurface)cityObject);
		else if (cityObject instanceof FloorSurface)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((FloorSurface)cityObject);
		else if (cityObject instanceof GroundSurface)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((GroundSurface)cityObject);
		else if (cityObject instanceof InteriorWallSurface)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((InteriorWallSurface)cityObject);
		else if (cityObject instanceof RoofSurface)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((RoofSurface)cityObject);
		else if (cityObject instanceof WallSurface)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((WallSurface)cityObject);
		else if (cityObject instanceof Room)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((Room)cityObject);
		else if (cityObject instanceof Door)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((Door)cityObject);
		else if (cityObject instanceof Window)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((Window)cityObject);
		else if (cityObject instanceof AbstractBuilding)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((AbstractBuilding)cityObject);
		else if (cityObject instanceof BoundarySurface)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((BoundarySurface)cityObject);
		else if (cityObject instanceof Opening)
			cityObjectElem = ModelMapper.BLDG_0_4.toJAXB((Opening)cityObject);
			
		// LandUse module
		else if (cityObject instanceof LandUse)
			cityObjectElem = ModelMapper.LUSE_0_4.toJAXB((LandUse)cityObject);

		// Transportation module
		else if (cityObject instanceof TrafficArea)
			cityObjectElem = ModelMapper.TRAN_0_4.toJAXB((TrafficArea)cityObject);
		else if (cityObject instanceof AuxiliaryTrafficArea)
			cityObjectElem = ModelMapper.TRAN_0_4.toJAXB((AuxiliaryTrafficArea)cityObject);
		else if (cityObject instanceof Railway)
			cityObjectElem = ModelMapper.TRAN_0_4.toJAXB((Railway)cityObject);
		else if (cityObject instanceof Road)
			cityObjectElem = ModelMapper.TRAN_0_4.toJAXB((Road)cityObject);	
		else if (cityObject instanceof Square)
			cityObjectElem = ModelMapper.TRAN_0_4.toJAXB((Square)cityObject);
		else if (cityObject instanceof Track)
			cityObjectElem = ModelMapper.TRAN_0_4.toJAXB((Track)cityObject);
		else if (cityObject instanceof TransportationComplex)
			cityObjectElem = ModelMapper.TRAN_0_4.toJAXB((TransportationComplex)cityObject);
		else if (cityObject instanceof TransportationObject)
			cityObjectElem = ModelMapper.TRAN_0_4.toJAXB((TransportationObject)cityObject);
			
		// Vegetation module
		else if (cityObject instanceof PlantCover)
			cityObjectElem = ModelMapper.VEG_0_4.toJAXB((PlantCover)cityObject);
		else if (cityObject instanceof SolitaryVegetationObject)
			cityObjectElem = ModelMapper.VEG_0_4.toJAXB((SolitaryVegetationObject)cityObject);	
		else if (cityObject instanceof VegetationObject)
			cityObjectElem = ModelMapper.VEG_0_4.toJAXB((VegetationObject)cityObject);
		
		// WaterBody module
		else if (cityObject instanceof WaterBody)
			cityObjectElem = ModelMapper.WTR_0_4.toJAXB((WaterBody)cityObject);
		else if (cityObject instanceof WaterClosureSurface)
			cityObjectElem = ModelMapper.WTR_0_4.toJAXB((WaterClosureSurface)cityObject);
		else if (cityObject instanceof WaterGroundSurface)
			cityObjectElem = ModelMapper.WTR_0_4.toJAXB((WaterGroundSurface)cityObject);
		else if (cityObject instanceof WaterSurface)
			cityObjectElem = ModelMapper.WTR_0_4.toJAXB((WaterSurface)cityObject);	
		else if (cityObject instanceof WaterObject)
			cityObjectElem = ModelMapper.WTR_0_4.toJAXB((WaterObject)cityObject);	
		else if (cityObject instanceof WaterBoundarySurface)
			cityObjectElem = ModelMapper.WTR_0_4.toJAXB((WaterBoundarySurface)cityObject);
		
		// Generics module
		else if (cityObject instanceof GenericCityObject)
			cityObjectElem = ModelMapper.GEN_0_4.toJAXB((GenericCityObject)cityObject);
		
		// CityObjectGroup module
		else if (cityObject instanceof CityObjectGroup)
			cityObjectElem = ModelMapper.GRP_0_4.toJAXB((CityObjectGroup)cityObject);
		
		// Relief module
		else if (cityObject instanceof ReliefFeature)
			cityObjectElem = ModelMapper.DEM_0_4.toJAXB((ReliefFeature)cityObject);
		else if (cityObject instanceof BreaklineRelief)
			cityObjectElem = ModelMapper.DEM_0_4.toJAXB((BreaklineRelief)cityObject);
		else if (cityObject instanceof RasterRelief)
			cityObjectElem = ModelMapper.DEM_0_4.toJAXB((RasterRelief)cityObject);
		else if (cityObject instanceof MassPointRelief)
			cityObjectElem = ModelMapper.DEM_0_4.toJAXB((MassPointRelief)cityObject);	
		else if (cityObject instanceof TINRelief)
			cityObjectElem = ModelMapper.DEM_0_4.toJAXB((TINRelief)cityObject);
		else if (cityObject instanceof ReliefComponent)
			cityObjectElem = ModelMapper.DEM_0_4.toJAXB((ReliefComponent)cityObject);
		
		// CityFurniture module
		else if (cityObject instanceof CityFurniture)
			cityObjectElem = ModelMapper.FRN_0_4.toJAXB((CityFurniture)cityObject);
		
		
		// Core module
		else if (cityObject instanceof Site)
			cityObjectElem = ModelMapper.CORE_0_4.toJAXB((Site)cityObject);
		else if (cityObject instanceof CityObject)
			cityObjectElem = ModelMapper.CORE_0_4.toJAXB((CityObject)cityObject);

		return cityObjectElem;
	}

}
