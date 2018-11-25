/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.builder.cityjson.unmarshal.citygml;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.AbstractTransportationComplexType;
import org.citygml4j.binding.cityjson.feature.AbstractVegetationObjectType;
import org.citygml4j.binding.cityjson.feature.BridgeType;
import org.citygml4j.binding.cityjson.feature.BuildingType;
import org.citygml4j.binding.cityjson.feature.CityFurnitureType;
import org.citygml4j.binding.cityjson.feature.CityObjectGroupType;
import org.citygml4j.binding.cityjson.feature.GenericCityObjectType;
import org.citygml4j.binding.cityjson.feature.LandUseType;
import org.citygml4j.binding.cityjson.feature.TINReliefType;
import org.citygml4j.binding.cityjson.feature.TunnelType;
import org.citygml4j.binding.cityjson.feature.WaterBodyType;
import org.citygml4j.binding.cityjson.geometry.AbstractSemanticsObject;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.appearance.AppearanceUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.bridge.BridgeUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.building.BuildingUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.cityfurniture.CityFurnitureUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.cityobjectgroup.CityObjectGroupUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.core.CoreUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.generics.GenericsUnmarshaller;
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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CityGMLUnmarshaller {
	private final CityJSONUnmarshaller json;
	
	private final AppearanceUnmarshaller app;
	private final BridgeUnmarshaller brid;
	private final BuildingUnmarshaller bldg;
	private final CityFurnitureUnmarshaller frn;
	private final CityObjectGroupUnmarshaller grp;
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
		
		app = new AppearanceUnmarshaller(this);
		brid = new BridgeUnmarshaller(this);
		bldg = new BuildingUnmarshaller(this);
		frn = new CityFurnitureUnmarshaller(this);
		grp = new CityObjectGroupUnmarshaller(this);
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
		AbstractCityObject dest = null;
		
		if (src instanceof BridgeType)
			dest = brid.unmarshal(src, cityJSON);
		else if (src instanceof BuildingType)
			dest = bldg.unmarshal(src, cityJSON);
		else if (src instanceof CityFurnitureType)
			dest = frn.unmarshalCityFurniture((CityFurnitureType)src);
		else if (src instanceof CityObjectGroupType)
			dest = grp.unmarshalCityObjectGroup((CityObjectGroupType)src);
		else if (src instanceof GenericCityObjectType)
			dest = gen.unmarshalGenericCityObject((GenericCityObjectType)src);
		else if (src instanceof LandUseType)
			dest = luse.unmarshalLandUse((LandUseType)src);
		else if (src instanceof TINReliefType)
			dest = dem.unmarshalTINRelief((TINReliefType)src);
		else if (src instanceof AbstractTransportationComplexType)
			dest = tran.unmarshal(src, cityJSON);
		else if (src instanceof TunnelType)
			dest = tun.unmarshal(src, cityJSON);
		else if (src instanceof AbstractVegetationObjectType)
			dest = veg.unmarshal(src, cityJSON);
		else if (src instanceof WaterBodyType)
			dest = wtr.unmarshalWaterBody((WaterBodyType)src);
		
		return dest;
	}
	
	public void unmarshalSemantics(AbstractSemanticsObject src, Map<Integer, List<AbstractSurface>> surfaces, Number lod, AbstractCityObject root) {
		Map<Integer, AbstractCityObject> parents = new HashMap<>();
		List<Integer> indexes = orderByParents(src);

		for (int index : indexes) {
			SemanticsType semanticsType = src.getSurfaces().get(index);
			List<AbstractSurface> tmp = surfaces.get(index);
			if (tmp == null)
				tmp = Collections.emptyList();

			AbstractCityObject parent = null;
			if (semanticsType.isSetParent())
				parent = parents.get(semanticsType.getParent());

			if (parent == null)
				parent = root;

			AbstractCityObject cityObject = null;
			if (parent instanceof BridgeModuleComponent)
				cityObject = brid.unmarshalSemantics(semanticsType, tmp, lod, parent);
			else if (parent instanceof BuildingModuleComponent)
				cityObject = bldg.unmarshalSemantics(semanticsType, tmp, lod, parent);
			else if (parent instanceof TransportationModuleComponent)
				cityObject = tran.unmarshalSemantics(semanticsType, tmp, lod, parent);
			else if (parent instanceof TunnelModuleComponent)
				cityObject = tun.unmarshalSemantics(semanticsType, tmp, lod, parent);
			else if (parent instanceof WaterBodyModuleComponent)
				cityObject = wtr.unmarshalSemantics(semanticsType, tmp, lod, parent);

			if (cityObject != null)
				parents.put(index, cityObject);
		}
	}

	private List<Integer> orderByParents(AbstractSemanticsObject semanticsObject) {
		Map<Integer, Integer> indexes = new HashMap<>();
		for (int i = 0; i < semanticsObject.getNumSurfaces(); i++) {
			SemanticsType type = semanticsObject.getSurfaces().get(i);
			int weight = 0;

			SemanticsType parent = type;
			while (parent.isSetParent()) {
				parent = semanticsObject.getSurfaces().get(parent.getParent());
				weight++;
			}

			indexes.put(i, weight);
		}

		return indexes.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
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

	public CityObjectGroupUnmarshaller getCiyCityObjectGroupUnmarshaller() {
		return grp;
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
