package org.citygml4j.builder.cityjson.marshal.citygml;

import java.util.Collections;
import java.util.List;

import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.appearance.AppearanceMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.bridge.BridgeMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.building.BuildingMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.cityfurniture.CityFurnitureMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.core.CoreMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.generics.GenericsMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.landuse.LandUseMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.relief.ReliefMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.transportation.TransportationMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.tunnel.TunnelMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.vegetation.VegetationMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.waterbody.WaterBodyMarshaller;
import org.citygml4j.model.citygml.bridge.BridgeModuleComponent;
import org.citygml4j.model.citygml.building.BuildingModuleComponent;
import org.citygml4j.model.citygml.cityfurniture.CityFurnitureModuleComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CoreModuleComponent;
import org.citygml4j.model.citygml.generics.GenericsModuleComponent;
import org.citygml4j.model.citygml.landuse.LandUseModuleComponent;
import org.citygml4j.model.citygml.relief.ReliefModuleComponent;
import org.citygml4j.model.citygml.transportation.TransportationModuleComponent;
import org.citygml4j.model.citygml.tunnel.TunnelModuleComponent;
import org.citygml4j.model.citygml.vegetation.VegetationModuleComponent;
import org.citygml4j.model.citygml.waterbody.WaterBodyModuleComponent;
import org.citygml4j.model.common.base.ModelObject;

public class CityGMLMarshaller {
	private final CityJSONMarshaller json;
	
	private final AppearanceMarshaller app;
	private final BridgeMarshaller brid;
	private final BuildingMarshaller bldg;
	private final CityFurnitureMarshaller frn;
	private final CoreMarshaller core;
	private final GenericsMarshaller gen;
	private final LandUseMarshaller luse;
	private final ReliefMarshaller dem;
	private final TransportationMarshaller tran;
	private final TunnelMarshaller tun;
	private final VegetationMarshaller veg;
	private final WaterBodyMarshaller wtr;
	
	public CityGMLMarshaller(CityJSONMarshaller json) {
		this.json = json;
		
		app = new AppearanceMarshaller(this);
		brid = new BridgeMarshaller(this);
		bldg = new BuildingMarshaller(this);
		frn = new CityFurnitureMarshaller(this);
		core = new CoreMarshaller(this);
		gen = new GenericsMarshaller(this);
		luse = new LandUseMarshaller(this);
		dem = new ReliefMarshaller(this);
		tran = new TransportationMarshaller(this);
		tun = new TunnelMarshaller(this);
		veg = new VegetationMarshaller(this);
		wtr = new WaterBodyMarshaller(this);
	}
	
	public List<AbstractCityObjectType> marshal(ModelObject src) {
		List<AbstractCityObjectType> dest = null;
		
		if (src instanceof BridgeModuleComponent)
			dest = brid.marshal(src);
		else if (src instanceof BuildingModuleComponent)
			dest = bldg.marshal(src);
		else if (src instanceof CityFurnitureModuleComponent)
			dest = frn.marshal(src);		
		else if (src instanceof GenericsModuleComponent)
			dest = gen.marshal(src);
		else if (src instanceof LandUseModuleComponent)
			dest = luse.marshal(src);
		else if (src instanceof ReliefModuleComponent)
			dest = dem.marshal(src);
		else if (src instanceof TransportationModuleComponent)
			dest = tran.marshal(src);
		else if (src instanceof TunnelModuleComponent)
			dest = tun.marshal(src);
		else if (src instanceof VegetationModuleComponent)
			dest = veg.marshal(src);
		else if (src instanceof WaterBodyModuleComponent)
			dest = wtr.marshal(src);
		else if (src instanceof CoreModuleComponent)
			dest = core.marshal(src);

		return dest != null ? dest : Collections.emptyList();
	}
	
	public SemanticsType marshalSemantics(AbstractCityObject cityObject) {
		SemanticsType semantics = null;
		
		if (cityObject instanceof BridgeModuleComponent)
			semantics = brid.marshalSemantics(cityObject);
		else if (cityObject instanceof BuildingModuleComponent)
			semantics = bldg.marshalSemantics(cityObject);
		else if (cityObject instanceof TransportationModuleComponent)
			semantics = tran.marshalSemantics(cityObject);
		else if (cityObject instanceof TunnelModuleComponent)
			semantics = tun.marshalSemantics(cityObject);
		else if (cityObject instanceof WaterBodyModuleComponent)
			semantics = wtr.marshalSemantics(cityObject);
		
		return semantics;
	}
	
	public AppearanceMarshaller getAppearanceMarshaller() {
		return app;
	}
	
	public BridgeMarshaller getBridgeMarshaller() {
		return brid;
	}
	
	public BuildingMarshaller getBuildingMarshaller() {
		return bldg;
	}	

	public CoreMarshaller getCoreMarshaller() {
		return core;
	}
	
	public CityFurnitureMarshaller getCityFurnitureMarshaller() {
		return frn;
	}
	
	public GenericsMarshaller getGenericsMarshaller() {
		return gen;
	}
	
	public LandUseMarshaller getLandUseMarshaller() {
		return luse;
	}
	
	public ReliefMarshaller getReliefMarshaller() {
		return dem;
	}
	
	public TransportationMarshaller getTransportationMarshaller() {
		return tran;
	}
	
	public TunnelMarshaller getTunnelMarshaller() {
		return tun;
	}
	
	public VegetationMarshaller getVegetationMarshaller() {
		return veg;
	} 
	
	public WaterBodyMarshaller getWaterBodyMarshaller() {
		return wtr;
	}

	public CityJSONMarshaller getCityJSONMarshaller() {
		return json;
	}
	
}
