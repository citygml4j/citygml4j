package org.citygml4j.impl.jaxb;

import org.citygml4j.impl.jaxb.citygml.ade.ADEModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.appearance._0_4.Appearance040ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.appearance._1.Appearance100ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.building._0_4.Building040ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.building._1.Building100ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.cityfurniture._0_4.CityFurniture040ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.cityfurniture._1.CityFurniture100ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.cityobjectgroup._0_4.CityObjectGroup040ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.cityobjectgroup._1.CityObjectGroup100ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.core._0_4.Core040ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.core._1.Core100ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.generics._0_4.Generics040ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.generics._1.Generics100ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.landuse._0_4.LandUse040ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.landuse._1.LandUse100ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.relief._0_4.Relief040ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.relief._1.Relief100ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.transportation._0_4.Transportation040ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.transportation._1.Transportation100ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.vegetation._0_4.Vegetation040ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.vegetation._1.Vegetation100ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.waterbody._0_4.WaterBody040ModelMapperImpl;
import org.citygml4j.impl.jaxb.citygml.waterbody._1.WaterBody100ModelMapperImpl;
import org.citygml4j.model.citygml.CityGMLModelMapper;
import org.citygml4j.model.citygml.CityGMLModuleType;
import org.citygml4j.model.citygml.CityGMLModuleVersion;

public class ModelMapper {
	public static final ADEModelMapperImpl ADE = new ADEModelMapperImpl();
	
	// CityGML version 0.4.0
	public static final Appearance040ModelMapperImpl APP_0_4 = new Appearance040ModelMapperImpl();
	public static final Building040ModelMapperImpl BLDG_0_4 = new Building040ModelMapperImpl();
	public static final CityFurniture040ModelMapperImpl FRN_0_4 = new CityFurniture040ModelMapperImpl();
	public static final CityObjectGroup040ModelMapperImpl GRP_0_4 = new CityObjectGroup040ModelMapperImpl();
	public static final Core040ModelMapperImpl CORE_0_4 = new Core040ModelMapperImpl();
	public static final Generics040ModelMapperImpl GEN_0_4 = new Generics040ModelMapperImpl();
	public static final LandUse040ModelMapperImpl LUSE_0_4 = new LandUse040ModelMapperImpl();
	public static final Relief040ModelMapperImpl DEM_0_4 = new Relief040ModelMapperImpl();
	public static final Transportation040ModelMapperImpl TRAN_0_4 = new Transportation040ModelMapperImpl();
	public static final Vegetation040ModelMapperImpl VEG_0_4 = new Vegetation040ModelMapperImpl();
	public static final WaterBody040ModelMapperImpl WTR_0_4 = new WaterBody040ModelMapperImpl();
	
	// CityGML version 1.0.0
	public static final Appearance100ModelMapperImpl APP_1 = new Appearance100ModelMapperImpl();
	public static final Building100ModelMapperImpl BLDG_1 = new Building100ModelMapperImpl();
	public static final CityFurniture100ModelMapperImpl FRN_1 = new CityFurniture100ModelMapperImpl();
	public static final CityObjectGroup100ModelMapperImpl GRP_1 = new CityObjectGroup100ModelMapperImpl();
	public static final Core100ModelMapperImpl CORE_1 = new Core100ModelMapperImpl();
	public static final Generics100ModelMapperImpl GEN_1 = new Generics100ModelMapperImpl();
	public static final LandUse100ModelMapperImpl LUSE_1 = new LandUse100ModelMapperImpl();
	public static final Relief100ModelMapperImpl DEM_1 = new Relief100ModelMapperImpl();
	public static final Transportation100ModelMapperImpl TRAN_1 = new Transportation100ModelMapperImpl();
	public static final Vegetation100ModelMapperImpl VEG_1 = new Vegetation100ModelMapperImpl();
	public static final WaterBody100ModelMapperImpl WTR_1 = new WaterBody100ModelMapperImpl();
	
	// CityObjectMember 
	public static final org.citygml4j.impl.jaxb.citygml.core._0_4.CityObjectMapperImpl CITYOBJECT_0_4 = new org.citygml4j.impl.jaxb.citygml.core._0_4.CityObjectMapperImpl();
	public static final org.citygml4j.impl.jaxb.citygml.core._1.CityObjectMapperImpl CITYOBJECT_1 = new org.citygml4j.impl.jaxb.citygml.core._1.CityObjectMapperImpl();

	public static CityGMLModelMapper getModelMapperInstance(CityGMLModuleType type, CityGMLModuleVersion version) {
		CityGMLModelMapper mapper = null;
		
		switch (type) {
		case APPEARANCE:
			switch (version) {
			case v0_4_0:
				mapper = APP_0_4;
				break;
			case v1_0_0:
				mapper = APP_1;
				break;
			}
			
			break;
		case BUILDING:
			switch (version) {
			case v0_4_0:
				mapper = BLDG_0_4;
				break;
			case v1_0_0:
				mapper = BLDG_1;
				break;
			}
			
			break;
		case CITYFURNITURE:
			switch (version) {
			case v0_4_0:
				mapper = FRN_0_4;
				break;
			case v1_0_0:
				mapper = FRN_1;
				break;
			}
			
			break;
		case CITYOBJECTGROUP:
			switch (version) {
			case v0_4_0:
				mapper = GRP_0_4;
				break;
			case v1_0_0:
				mapper = GRP_1;
				break;
			}
			
			break;
		case CORE:
			switch (version) {
			case v0_4_0:
				mapper = CORE_0_4;
				break;
			case v1_0_0:
				mapper = CORE_1;
				break;
			}
			
			break;
		case GENERICS:
			switch (version) {
			case v0_4_0:
				mapper = GEN_0_4;
				break;
			case v1_0_0:
				mapper = GEN_1;
				break;
			}
			
			break;
		case LANDUSE:
			switch (version) {
			case v0_4_0:
				mapper = LUSE_0_4;
				break;
			case v1_0_0:
				mapper = LUSE_1;
				break;
			}
			
			break;
		case RELIEF:
			switch (version) {
			case v0_4_0:
				mapper = DEM_0_4;
				break;
			case v1_0_0:
				mapper = DEM_1;
				break;
			}
			
			break;
		case TRANSPORTATION:
			switch (version) {
			case v0_4_0:
				mapper = TRAN_0_4;
				break;
			case v1_0_0:
				mapper = TRAN_1;
				break;
			}
			
			break;
		case VEGETATION:
			switch (version) {
			case v0_4_0:
				mapper = VEG_0_4;
				break;
			case v1_0_0:
				mapper = VEG_1;
				break;
			}
			
			break;
		case WATERBODY:
			switch (version) {
			case v0_4_0:
				mapper = WTR_0_4;
				break;
			case v1_0_0:
				mapper = WTR_1;
				break;
			}
			
			break;
		}
		
		return mapper;
	}
}
