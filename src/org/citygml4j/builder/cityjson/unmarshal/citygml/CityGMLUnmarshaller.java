package org.citygml4j.builder.cityjson.unmarshal.citygml;

import java.util.List;
import java.util.Map;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.AbstractTransportationComplexType;
import org.citygml4j.binding.cityjson.feature.AbstractTunnelType;
import org.citygml4j.binding.cityjson.feature.AbstractVegetationObjectType;
import org.citygml4j.binding.cityjson.feature.BridgeType;
import org.citygml4j.binding.cityjson.feature.BuildingType;
import org.citygml4j.binding.cityjson.feature.CityFurnitureType;
import org.citygml4j.binding.cityjson.feature.GenericCityObjectType;
import org.citygml4j.binding.cityjson.feature.LandUseType;
import org.citygml4j.binding.cityjson.feature.TINReliefType;
import org.citygml4j.binding.cityjson.feature.WaterBodyType;
import org.citygml4j.binding.cityjson.geometry.AbstractSemanticsObject;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.appearance.AppearanceUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.bridge.BridgeUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.building.BuildingUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.cityfurniture.CityFurnitureUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.core.CoreUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.gen.GenericsUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.landuse.LandUseUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.relief.ReliefUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.transportation.TransportationUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.tunnel.TunnelUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.vegetation.VegetationUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.waterbody.WaterBodyUnmarshaller;
import org.citygml4j.model.citygml.bridge.BridgeModuleComponent;
import org.citygml4j.model.citygml.building.BuildingModuleComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.transportation.TransportationModuleComponent;
import org.citygml4j.model.citygml.tunnel.TunnelModuleComponent;
import org.citygml4j.model.citygml.waterbody.WaterBodyModuleComponent;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;

public class CityGMLUnmarshaller {
	private final CityJSONUnmarshaller json;
	
	private final AppearanceUnmarshaller app;
	private final BridgeUnmarshaller brid;
	private final BuildingUnmarshaller bldg;
	private final CityFurnitureUnmarshaller frn;
	private final CoreUnmarshaller core;
	private final GenericsUnmarshaller gen;
	private final LandUseUnmarshaller luse;
	private final ReliefUnmarshaller dem;
	private final TransportationUnmarshaller tran;
	private final TunnelUnmarshaller tun;
	private final VegetationUnmarshaller veg;
	private final WaterBodyUnmarshaller wtr;

	public CityGMLUnmarshaller(CityJSONUnmarshaller json) {
		this.json = json;
		
		app = new AppearanceUnmarshaller();
		brid = new BridgeUnmarshaller(this);
		bldg = new BuildingUnmarshaller(this);
		frn = new CityFurnitureUnmarshaller(this);
		core = new CoreUnmarshaller(this);
		gen = new GenericsUnmarshaller(this);
		luse = new LandUseUnmarshaller(this);		
		dem = new ReliefUnmarshaller(this);
		tran = new TransportationUnmarshaller(this);
		tun = new TunnelUnmarshaller(this);
		veg = new VegetationUnmarshaller(this);
		wtr = new WaterBodyUnmarshaller(this);
	}

	public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
		AbstractCityObject cityObject = null;
		
		if (src instanceof BridgeType)
			cityObject = brid.unmarshal(src, cityJSON);
		else if (src instanceof BuildingType)
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
		else if (src instanceof AbstractTunnelType)
			cityObject = tun.unmarshal(src, cityJSON);
		else if (src instanceof AbstractVegetationObjectType)
			cityObject = veg.unmarshal(src, cityJSON);
		else if (src instanceof WaterBodyType)
			cityObject = wtr.unmarshalWaterBody((WaterBodyType)src);
		
		return cityObject;
	}
	
	public void unmarshalSemantics(AbstractSemanticsObject src, Map<Integer, List<AbstractSurface>> surfaces, Number lod, AbstractCityObject parent) {
		if (parent instanceof BridgeModuleComponent)
			brid.unmarshalSemantics(src, surfaces, lod, parent);
		else if (parent instanceof BuildingModuleComponent)
			bldg.unmarshalSemantics(src, surfaces, lod, parent);
		else if (parent instanceof TransportationModuleComponent)
			tran.unmarshalSemantics(src, surfaces, lod, parent);
		else if (parent instanceof TunnelModuleComponent)
			tun.unmarshalSemantics(src, surfaces, lod, parent);
		else if (parent instanceof WaterBodyModuleComponent)
			wtr.unmarshalSemantics(src, surfaces, lod, parent);
	}
	
	public AppearanceUnmarshaller getAppearanceUnmarshaller() {
		return app;
	}
	
	public BridgeUnmarshaller getBridgeUnmarshaller() {
		return brid;
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
