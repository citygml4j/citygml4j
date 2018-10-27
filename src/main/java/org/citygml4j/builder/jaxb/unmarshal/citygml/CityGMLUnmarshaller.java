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
package org.citygml4j.builder.jaxb.unmarshal.citygml;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.appearance.Appearance100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.appearance.Appearance200Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.bridge.Bridge200Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.building.Building100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.building.Building200Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.cityfurniture.CityFurniture100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.cityfurniture.CityFurniture200Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.cityobjectgroup.CityObjectGroup100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.cityobjectgroup.CityObjectGroup200Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.core.Core100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.core.Core200Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.generics.Generics100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.generics.Generics200Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.landuse.LandUse100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.landuse.LandUse200Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.relief.Relief100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.relief.Relief200Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.texturedsurface.TexturedSurface100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.texturedsurface.TexturedSurface200Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.transportation.Transportation100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.transportation.Transportation200Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.tunnel.Tunnel200Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.vegetation.Vegetation100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.vegetation.Vegetation200Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.waterbody.WaterBody100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.waterbody.WaterBody200Unmarshaller;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLModuleComponent;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.module.Modules;
import org.citygml4j.model.module.ade.ADEModule;
import org.citygml4j.model.module.citygml.AppearanceModule;
import org.citygml4j.model.module.citygml.BridgeModule;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.model.module.citygml.CityFurnitureModule;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CityGMLModuleType;
import org.citygml4j.model.module.citygml.CityGMLModuleVersion;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CityObjectGroupModule;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.module.citygml.GenericsModule;
import org.citygml4j.model.module.citygml.LandUseModule;
import org.citygml4j.model.module.citygml.ReliefModule;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;
import org.citygml4j.model.module.citygml.TransportationModule;
import org.citygml4j.model.module.citygml.TunnelModule;
import org.citygml4j.model.module.citygml.VegetationModule;
import org.citygml4j.model.module.citygml.WaterBodyModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CityGMLUnmarshaller {
	private final JAXBUnmarshaller jaxb;

	private final Appearance200Unmarshaller app200;
	private final Bridge200Unmarshaller brid200;
	private final Building200Unmarshaller bldg200;
	private final CityFurniture200Unmarshaller frn200;
	private final CityObjectGroup200Unmarshaller grp200;
	private final Core200Unmarshaller core200;
	private final Generics200Unmarshaller gen200;
	private final LandUse200Unmarshaller luse200;
	private final Relief200Unmarshaller dem200;
	private final TexturedSurface200Unmarshaller tex200;
	private final Transportation200Unmarshaller tran200;
	private final Tunnel200Unmarshaller tun200;
	private final Vegetation200Unmarshaller veg200;
	private final WaterBody200Unmarshaller wtr200;

	private final Appearance100Unmarshaller app100;
	private final Building100Unmarshaller bldg100;
	private final CityFurniture100Unmarshaller frn100;
	private final CityObjectGroup100Unmarshaller grp100;
	private final Core100Unmarshaller core100;
	private final Generics100Unmarshaller gen100;
	private final LandUse100Unmarshaller luse100;
	private final Relief100Unmarshaller dem100;
	private final TexturedSurface100Unmarshaller tex100;
	private final Transportation100Unmarshaller tran100;
	private final Vegetation100Unmarshaller veg100;
	private final WaterBody100Unmarshaller wtr100;
	
	private final Matcher moduleMatcher;

	public CityGMLUnmarshaller(JAXBUnmarshaller jaxb) {
		this.jaxb = jaxb;

		app200 = new Appearance200Unmarshaller(this);
		brid200 = new Bridge200Unmarshaller(this);
		bldg200 = new Building200Unmarshaller(this);
		frn200 = new CityFurniture200Unmarshaller(this);
		grp200 = new CityObjectGroup200Unmarshaller(this);
		core200 = new Core200Unmarshaller(this);
		gen200 = new Generics200Unmarshaller(this);
		luse200 = new LandUse200Unmarshaller(this);
		dem200 = new Relief200Unmarshaller(this);
		tex200 = new TexturedSurface200Unmarshaller(this);
		tran200 = new Transportation200Unmarshaller(this);
		tun200 = new Tunnel200Unmarshaller(this);
		veg200 = new Vegetation200Unmarshaller(this);
		wtr200 = new WaterBody200Unmarshaller(this);

		app100 = new Appearance100Unmarshaller(this);
		bldg100 = new Building100Unmarshaller(this);
		frn100 = new CityFurniture100Unmarshaller(this);
		grp100 = new CityObjectGroup100Unmarshaller(this);
		core100 = new Core100Unmarshaller(this);
		gen100 = new Generics100Unmarshaller(this);
		luse100 = new LandUse100Unmarshaller(this);
		dem100 = new Relief100Unmarshaller(this);
		tex100 = new TexturedSurface100Unmarshaller(this);
		tran100 = new Transportation100Unmarshaller(this);
		veg100 = new Vegetation100Unmarshaller(this);
		wtr100 = new WaterBody100Unmarshaller(this);
		
		moduleMatcher = Pattern.compile("net\\.opengis\\.citygml\\.([\\w]+)?\\.?(_\\d)").matcher("");
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		final String namespaceURI = src.getName().getNamespaceURI();

		CityGML dest = null;

		// CityGML version 2.0.0
		if (namespaceURI.equals(AppearanceModule.v2_0_0.getNamespaceURI()))
			dest = app200.unmarshal(src);
		else if (namespaceURI.equals(BridgeModule.v2_0_0.getNamespaceURI()))
			dest = brid200.unmarshal(src);
		else if (namespaceURI.equals(BuildingModule.v2_0_0.getNamespaceURI()))
			dest = bldg200.unmarshal(src);
		else if (namespaceURI.equals(CityFurnitureModule.v2_0_0.getNamespaceURI()))
			dest = frn200.unmarshal(src);
		else if (namespaceURI.equals(CityObjectGroupModule.v2_0_0.getNamespaceURI()))
			dest = grp200.unmarshal(src);
		else if (namespaceURI.equals(CoreModule.v2_0_0.getNamespaceURI()))
			dest = core200.unmarshal(src);
		else if (namespaceURI.equals(GenericsModule.v2_0_0.getNamespaceURI()))
			dest = gen200.unmarshal(src);
		else if (namespaceURI.equals(LandUseModule.v2_0_0.getNamespaceURI()))
			dest = luse200.unmarshal(src);
		else if (namespaceURI.equals(ReliefModule.v2_0_0.getNamespaceURI()))
			dest = dem200.unmarshal(src);
		else if (namespaceURI.equals(TexturedSurfaceModule.v2_0_0.getNamespaceURI()))
			dest = tex200.unmarshal(src);
		else if (namespaceURI.equals(TransportationModule.v2_0_0.getNamespaceURI()))
			dest = tran200.unmarshal(src);
		else if (namespaceURI.equals(TunnelModule.v2_0_0.getNamespaceURI()))
			dest = tun200.unmarshal(src);
		else if (namespaceURI.equals(VegetationModule.v2_0_0.getNamespaceURI()))
			dest = veg200.unmarshal(src);
		else if (namespaceURI.equals(WaterBodyModule.v2_0_0.getNamespaceURI()))
			dest = wtr200.unmarshal(src);

		// CityGML version 1.0.0
		else if (namespaceURI.equals(AppearanceModule.v1_0_0.getNamespaceURI()))
			dest = app100.unmarshal(src);
		else if (namespaceURI.equals(BuildingModule.v1_0_0.getNamespaceURI()))
			dest = bldg100.unmarshal(src);
		else if (namespaceURI.equals(CityFurnitureModule.v1_0_0.getNamespaceURI()))
			dest = frn100.unmarshal(src);
		else if (namespaceURI.equals(CityObjectGroupModule.v1_0_0.getNamespaceURI()))
			dest = grp100.unmarshal(src);
		else if (namespaceURI.equals(CoreModule.v1_0_0.getNamespaceURI()))
			dest = core100.unmarshal(src);
		else if (namespaceURI.equals(GenericsModule.v1_0_0.getNamespaceURI()))
			dest = gen100.unmarshal(src);
		else if (namespaceURI.equals(LandUseModule.v1_0_0.getNamespaceURI()))
			dest = luse100.unmarshal(src);
		else if (namespaceURI.equals(ReliefModule.v1_0_0.getNamespaceURI()))
			dest = dem100.unmarshal(src);
		else if (namespaceURI.equals(TexturedSurfaceModule.v1_0_0.getNamespaceURI()))
			dest = tex100.unmarshal(src);
		else if (namespaceURI.equals(TransportationModule.v1_0_0.getNamespaceURI()))
			dest = tran100.unmarshal(src);
		else if (namespaceURI.equals(VegetationModule.v1_0_0.getNamespaceURI()))
			dest = veg100.unmarshal(src);
		else if (namespaceURI.equals(WaterBodyModule.v1_0_0.getNamespaceURI()))
			dest = wtr100.unmarshal(src);

		return dest;
	}

	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);

		CityGMLModule module = getCityGMLModule(src);
		if (module == null)
			return null;

		CityGML dest = null;
		CityGMLModuleType type = module.getType();
		CityGMLModuleVersion version = module.getVersion();

		if (type == CityGMLModuleType.APPEARANCE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = app200.unmarshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = app100.unmarshal(src);
		}

		else if (type == CityGMLModuleType.BRIDGE) {
			dest = brid200.unmarshal(src);
		}

		else if (type == CityGMLModuleType.BUILDING) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = bldg200.unmarshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = bldg100.unmarshal(src);
		}

		else if (type == CityGMLModuleType.CITY_FURNITURE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = frn200.unmarshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = frn100.unmarshal(src);
		}

		else if (type == CityGMLModuleType.CITY_OBJECT_GROUP) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = grp200.unmarshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = grp100.unmarshal(src);
		}	

		else if (type == CityGMLModuleType.GENERICS) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = gen200.unmarshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = gen100.unmarshal(src);
		}

		else if (type == CityGMLModuleType.LAND_USE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = luse200.unmarshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = luse100.unmarshal(src);
		}

		else if (type == CityGMLModuleType.RELIEF) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = dem200.unmarshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = dem100.unmarshal(src);
		}

		else if (type == CityGMLModuleType.TEXTURED_SURFACE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = tex200.unmarshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = tex100.unmarshal(src);
		}

		else if (type == CityGMLModuleType.TRANSPORTATION) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = tran200.unmarshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = tran100.unmarshal(src);
		}

		else if (type == CityGMLModuleType.TUNNEL) {
			dest = tun200.unmarshal(src);
		}

		else if (type == CityGMLModuleType.VEGETATION) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = veg200.unmarshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = veg100.unmarshal(src);
		}

		else if (type == CityGMLModuleType.WATER_BODY) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = wtr200.unmarshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = wtr100.unmarshal(src);
		}

		else if (type == CityGMLModuleType.CORE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = core200.unmarshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = core100.unmarshal(src);
		}			

		return dest;
	}

	public boolean assignGenericProperty(ADEGenericElement genericProperty, QName substitutionGroup, CityGMLModuleComponent dest) {
		String namespaceURI = substitutionGroup.getNamespaceURI();		
		CityGMLVersion version = null;		
		
		// try and identify CityGML version of feature 
		if (dest.isSetCityGMLModule()) {
			version = CityGMLVersion.fromCityGMLModule(dest.getCityGMLModule());
		} else if (dest instanceof ADEModelObject && dest instanceof AbstractCityObject) {
			CityGMLVersion tmp = CityGMLVersion.fromCityGMLNamespaceURI(namespaceURI);
			
			for (ADEModule module : Modules.getADEModules()) {
				if (module.getCityGMLVersion() == tmp
						&& module.getFeatureName(((AbstractCityObject)dest).getClass()) != null) {
					version = tmp;
					break;
				}					
			}
		}
		
		if (version == CityGMLVersion.v2_0_0) {			
			if (namespaceURI.equals(AppearanceModule.v2_0_0.getNamespaceURI()))
				return app200.assignGenericProperty(genericProperty, substitutionGroup, dest);
			else if (namespaceURI.equals(BridgeModule.v2_0_0.getNamespaceURI()))
				return brid200.assignGenericProperty(genericProperty, substitutionGroup, dest);
			else if (namespaceURI.equals(BuildingModule.v2_0_0.getNamespaceURI()))
				return bldg200.assignGenericProperty(genericProperty, substitutionGroup, dest);
			else if (namespaceURI.equals(CityFurnitureModule.v2_0_0.getNamespaceURI()))
				return frn200.assignGenericProperty(genericProperty, substitutionGroup, dest);		
			else if (namespaceURI.equals(CityObjectGroupModule.v2_0_0.getNamespaceURI()))
				return grp200.assignGenericProperty(genericProperty, substitutionGroup, dest);		
			else if (namespaceURI.equals(CoreModule.v2_0_0.getNamespaceURI()))
				return core200.assignGenericProperty(genericProperty, substitutionGroup, dest);		
			else if (namespaceURI.equals(LandUseModule.v2_0_0.getNamespaceURI()))
				return luse200.assignGenericProperty(genericProperty, substitutionGroup, dest);		
			else if (namespaceURI.equals(ReliefModule.v2_0_0.getNamespaceURI()))
				return dem200.assignGenericProperty(genericProperty, substitutionGroup, dest);		
			else if (namespaceURI.equals(TransportationModule.v2_0_0.getNamespaceURI()))
				return tran200.assignGenericProperty(genericProperty, substitutionGroup, dest);	
			else if (namespaceURI.equals(TunnelModule.v2_0_0.getNamespaceURI()))
				return tun200.assignGenericProperty(genericProperty, substitutionGroup, dest);	
			else if (namespaceURI.equals(VegetationModule.v2_0_0.getNamespaceURI()))
				return veg200.assignGenericProperty(genericProperty, substitutionGroup, dest);		
			else if (namespaceURI.equals(WaterBodyModule.v2_0_0.getNamespaceURI()))
				return wtr200.assignGenericProperty(genericProperty, substitutionGroup, dest);	
		}

		else if (version == CityGMLVersion.v1_0_0) {			
			if (namespaceURI.equals(AppearanceModule.v1_0_0.getNamespaceURI()))
				return app100.assignGenericProperty(genericProperty, substitutionGroup, dest);
			else if (namespaceURI.equals(BuildingModule.v1_0_0.getNamespaceURI()))
				return bldg100.assignGenericProperty(genericProperty, substitutionGroup, dest);
			else if (namespaceURI.equals(CityFurnitureModule.v1_0_0.getNamespaceURI()))
				return frn100.assignGenericProperty(genericProperty, substitutionGroup, dest);		
			else if (namespaceURI.equals(CityObjectGroupModule.v1_0_0.getNamespaceURI()))
				return grp100.assignGenericProperty(genericProperty, substitutionGroup, dest);		
			else if (namespaceURI.equals(CoreModule.v1_0_0.getNamespaceURI()))
				return core100.assignGenericProperty(genericProperty, substitutionGroup, dest);		
			else if (namespaceURI.equals(LandUseModule.v1_0_0.getNamespaceURI()))
				return luse100.assignGenericProperty(genericProperty, substitutionGroup, dest);		
			else if (namespaceURI.equals(ReliefModule.v1_0_0.getNamespaceURI()))
				return dem100.assignGenericProperty(genericProperty, substitutionGroup, dest);		
			else if (namespaceURI.equals(TransportationModule.v1_0_0.getNamespaceURI()))
				return tran100.assignGenericProperty(genericProperty, substitutionGroup, dest);		
			else if (namespaceURI.equals(VegetationModule.v1_0_0.getNamespaceURI()))
				return veg100.assignGenericProperty(genericProperty, substitutionGroup, dest);		
			else if (namespaceURI.equals(WaterBodyModule.v1_0_0.getNamespaceURI()))
				return wtr100.assignGenericProperty(genericProperty, substitutionGroup, dest);	
		
			else if (namespaceURI.startsWith("http://www.citygml.org/citygml")) {
				boolean success = app100.assignGenericProperty(genericProperty, substitutionGroup, dest);
				if (!success)
					success = bldg100.assignGenericProperty(genericProperty, substitutionGroup, dest);
				if (!success)
					success = frn100.assignGenericProperty(genericProperty, substitutionGroup, dest);		
				if (!success)
					success = grp100.assignGenericProperty(genericProperty, substitutionGroup, dest);		
				if (!success)
					success = core100.assignGenericProperty(genericProperty, substitutionGroup, dest);		
				if (!success)
					success = luse100.assignGenericProperty(genericProperty, substitutionGroup, dest);		
				if (!success)
					success = dem100.assignGenericProperty(genericProperty, substitutionGroup, dest);		
				if (!success)
					success = tran100.assignGenericProperty(genericProperty, substitutionGroup, dest);		
				if (!success)
					success = veg100.assignGenericProperty(genericProperty, substitutionGroup, dest);		
				if (!success)
					success = wtr100.assignGenericProperty(genericProperty, substitutionGroup, dest);	

				return success;
			}
		}

		return false;
	}

	public JAXBUnmarshaller getJAXBUnmarshaller() {
		return jaxb;
	}

	public Appearance200Unmarshaller getAppearance200Unmarshaller() {
		return app200;
	}

	public Bridge200Unmarshaller getBridge200Unmarshaller() {
		return brid200;
	}

	public Building200Unmarshaller getBuilding200Unmarshaller() {
		return bldg200;
	}

	public CityFurniture200Unmarshaller getCityFurniture200Unmarshaller() {
		return frn200;
	}

	public CityObjectGroup200Unmarshaller getCityObjectGroup200Unmarshaller() {
		return grp200;
	}

	public Core200Unmarshaller getCore200Unmarshaller() {
		return core200;
	}

	public Generics200Unmarshaller getGenerics200Unmarshaller() {
		return gen200;
	}

	public LandUse200Unmarshaller getLandUse200Unmarshaller() {
		return luse200;
	}

	public Relief200Unmarshaller getRelief200Unmarshaller() {
		return dem200;
	}

	public TexturedSurface200Unmarshaller getTexturedSurface200Unmarshaller() {
		return tex200;
	}

	public Tunnel200Unmarshaller getTunnel200Unmarshaller() {
		return tun200;
	}

	public Transportation200Unmarshaller getTransportation200Unmarshaller() {
		return tran200;
	}

	public Vegetation200Unmarshaller getVegetation200Unmarshaller() {
		return veg200;
	}

	public WaterBody200Unmarshaller getWaterBody200Unmarshaller() {
		return wtr200;
	}

	public Appearance100Unmarshaller getAppearance100Unmarshaller() {
		return app100;
	}

	public Building100Unmarshaller getBuilding100Unmarshaller() {
		return bldg100;
	}

	public CityFurniture100Unmarshaller getCityFurniture100Unmarshaller() {
		return frn100;
	}

	public CityObjectGroup100Unmarshaller getCityObjectGroup100Unmarshaller() {
		return grp100;
	}

	public Core100Unmarshaller getCore100Unmarshaller() {
		return core100;
	}

	public Generics100Unmarshaller getGenerics100Unmarshaller() {
		return gen100;
	}

	public LandUse100Unmarshaller getLandUse100Unmarshaller() {
		return luse100;
	}

	public Relief100Unmarshaller getRelief100Unmarshaller() {
		return dem100;
	}

	public TexturedSurface100Unmarshaller getTexturedSurface100Unmarshaller() {
		return tex100;
	}

	public Transportation100Unmarshaller getTransportation100Unmarshaller() {
		return tran100;
	}

	public Vegetation100Unmarshaller getVegetation100Unmarshaller() {
		return veg100;
	}

	public WaterBody100Unmarshaller getWaterBody100Unmarshaller() {
		return wtr100;
	}

	private CityGMLModule getCityGMLModule(Object src) {
		if (src != null) {
			moduleMatcher.reset(src.getClass().getPackage().getName());
			
			if (moduleMatcher.matches()) {
				String moduleString = moduleMatcher.group(1);
				if (moduleString == null)
					moduleString = "core";
				
				CityGMLModuleVersion version = moduleMatcher.group(2).equals("_2") ? CityGMLModuleVersion.v2_0_0 : CityGMLModuleVersion.v1_0_0;
				for (CityGMLModule module : Modules.getCityGMLModules()) {
					if (module.getVersion() == version && module.getType().toString().toLowerCase().equals(moduleString))
						return module;
				}	
			}
		}

		return null;
	}

}
