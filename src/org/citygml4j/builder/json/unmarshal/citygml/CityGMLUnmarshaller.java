package org.citygml4j.builder.json.unmarshal.citygml;

import java.util.List;
import java.util.Map;

import org.citygml4j.builder.json.objects.CityJSON;
import org.citygml4j.builder.json.objects.feature.AbstractCityObjectType;
import org.citygml4j.builder.json.objects.feature.AbstractTransportationComplexType;
import org.citygml4j.builder.json.objects.feature.AbstractVegetationObjectType;
import org.citygml4j.builder.json.objects.feature.BuildingType;
import org.citygml4j.builder.json.objects.feature.CityFurnitureType;
import org.citygml4j.builder.json.objects.feature.GenericCityObjectType;
import org.citygml4j.builder.json.objects.feature.LandUseType;
import org.citygml4j.builder.json.objects.feature.TINReliefType;
import org.citygml4j.builder.json.objects.feature.WaterBodyType;
import org.citygml4j.builder.json.objects.geometry.AbstractSemanticsObject;
import org.citygml4j.builder.json.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.json.unmarshal.citygml.appearance.AppearanceUnmarshaller;
import org.citygml4j.builder.json.unmarshal.citygml.building.BuildingUnmarshaller;
import org.citygml4j.builder.json.unmarshal.citygml.cityfurniture.CityFurnitureUnmarshaller;
import org.citygml4j.builder.json.unmarshal.citygml.core.CoreUnmarshaller;
import org.citygml4j.builder.json.unmarshal.citygml.gen.GenericsUnmarshaller;
import org.citygml4j.builder.json.unmarshal.citygml.landuse.LandUseUnmarshaller;
import org.citygml4j.builder.json.unmarshal.citygml.relief.ReliefUnmarshaller;
import org.citygml4j.builder.json.unmarshal.citygml.transportation.TransportationUnmarshaller;
import org.citygml4j.builder.json.unmarshal.citygml.vegetation.VegetationUnmarshaller;
import org.citygml4j.builder.json.unmarshal.citygml.waterbody.WaterBodyUnmarshaller;
import org.citygml4j.model.citygml.building.BuildingModuleComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.transportation.TransportationModuleComponent;
import org.citygml4j.model.citygml.waterbody.WaterBodyModuleComponent;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;

public class CityGMLUnmarshaller {
	private final CityJSONUnmarshaller json;
	
	private final AppearanceUnmarshaller app;
	private final BuildingUnmarshaller bldg;
	private final CityFurnitureUnmarshaller frn;
	private final CoreUnmarshaller core;
	private final GenericsUnmarshaller gen;
	private final LandUseUnmarshaller luse;
	private final ReliefUnmarshaller dem;
	private final TransportationUnmarshaller tran;
	private final VegetationUnmarshaller veg;
	private final WaterBodyUnmarshaller wtr;

	public CityGMLUnmarshaller(CityJSONUnmarshaller json) {
		this.json = json;
		
		app = new AppearanceUnmarshaller();
		bldg = new BuildingUnmarshaller(this);
		frn = new CityFurnitureUnmarshaller(this);
		core = new CoreUnmarshaller(this);
		gen = new GenericsUnmarshaller(this);
		luse = new LandUseUnmarshaller(this);		
		dem = new ReliefUnmarshaller(this);
		tran = new TransportationUnmarshaller(this);
		veg = new VegetationUnmarshaller(this);
		wtr = new WaterBodyUnmarshaller(this);
	}

	public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
		AbstractCityObject cityObject = null;
		
		if (src instanceof BuildingType)
			cityObject = bldg.unmarshal(src, cityJSON);
		else if (src instanceof CityFurnitureType)
			cityObject = frn.unmarshalCityFurniture((CityFurnitureType)src);		
		else if (src instanceof GenericCityObjectType)
			cityObject = gen.unmarshalGenericCityObject((GenericCityObjectType)src);
		else if (src instanceof LandUseType)
			cityObject = luse.unmarshalLandUse((LandUseType)src);
		else if (src instanceof TINReliefType)
			cityObject = dem.unmarshalTINRelief((TINReliefType)src);
		else if (src instanceof AbstractTransportationComplexType)
			cityObject = tran.unmarshal(src, cityJSON);
		else if (src instanceof AbstractVegetationObjectType)
			cityObject = veg.unmarshal(src, cityJSON);
		else if (src instanceof WaterBodyType)
			cityObject = wtr.unmarshalWaterBody((WaterBodyType)src);
		
		return cityObject;
	}
	
	public void unmarshalSemantics(AbstractSemanticsObject src, Map<Integer, List<AbstractSurface>> surfaces, Number lod, AbstractCityObject parent) {
		if (parent instanceof BuildingModuleComponent)
			bldg.unmarshalSemantics(src, surfaces, lod, parent);
		else if (parent instanceof TransportationModuleComponent)
			tran.unmarshalSemantics(src, surfaces, lod, parent);
		else if (parent instanceof WaterBodyModuleComponent)
			wtr.unmarshalSemantics(src, surfaces, lod, parent);
	}
	
	public AppearanceUnmarshaller getAppearanceUnmarshaller() {
		return app;
	}
	
	public BuildingUnmarshaller getBuildingUnmarshaller() {
		return bldg;
	}
	
	public CityFurnitureUnmarshaller getCityFurnitureUnmarshaller() {
		return frn;
	}
	
	public CoreUnmarshaller getCoreUnmarshaller() {
		return core;
	}
	
	public GenericsUnmarshaller getGenericsUnmarshaller() {
		return gen;
	}
	
	public LandUseUnmarshaller getLandUseUnmarshaller() {
		return luse;
	}

	public ReliefUnmarshaller getReliefUnmarshaller() {
		return dem;
	}
	
	public TransportationUnmarshaller getTransportationUnmarshaller() {
		return tran;
	}
	
	public VegetationUnmarshaller getVegetationUnmarshaller() {
		return veg;
	}
	
	public WaterBodyUnmarshaller getWaterBodyUnmarshaller() {
		return wtr;
	}
	
	public CityJSONUnmarshaller getCityJSONUnmarshaller() {
		return json;
	}
}
