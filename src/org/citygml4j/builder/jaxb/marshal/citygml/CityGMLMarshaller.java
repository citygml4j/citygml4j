/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.builder.jaxb.marshal.citygml;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.appearance.Appearance040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.appearance.Appearance100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.appearance.Appearance200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.bridge.Bridge200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.building.Building040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.building.Building100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.building.Building200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.cityfurniture.CityFurniture040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.cityfurniture.CityFurniture100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.cityfurniture.CityFurniture200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.cityobjectgroup.CityObjectGroup040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.cityobjectgroup.CityObjectGroup100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.cityobjectgroup.CityObjectGroup200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.core.Core040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.core.Core100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.core.Core200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.generics.Generics040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.generics.Generics100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.generics.Generics200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.landuse.LandUse040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.landuse.LandUse100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.landuse.LandUse200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.relief.Relief040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.relief.Relief100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.relief.Relief200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.texturedsurface.TexturedSurface040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.texturedsurface.TexturedSurface100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.texturedsurface.TexturedSurface200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.transportation.Transportation040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.transportation.Transportation100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.transportation.Transportation200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.tunnel.Tunnel200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.vegetation.Vegetation040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.vegetation.Vegetation100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.vegetation.Vegetation200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.waterbody.WaterBody040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.waterbody.WaterBody100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.waterbody.WaterBody200Marshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AppearanceModuleComponent;
import org.citygml4j.model.citygml.bridge.BridgeModuleComponent;
import org.citygml4j.model.citygml.building.BuildingModuleComponent;
import org.citygml4j.model.citygml.cityfurniture.CityFurnitureModuleComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupModuleComponent;
import org.citygml4j.model.citygml.generics.GenericsModuleComponent;
import org.citygml4j.model.citygml.landuse.LandUseModuleComponent;
import org.citygml4j.model.citygml.relief.ReliefModuleComponent;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModuleComponent;
import org.citygml4j.model.citygml.transportation.TransportationModuleComponent;
import org.citygml4j.model.citygml.tunnel.TunnelModuleComponent;
import org.citygml4j.model.citygml.vegetation.VegetationModuleComponent;
import org.citygml4j.model.citygml.waterbody.WaterBodyModuleComponent;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.Modules;
import org.citygml4j.model.module.citygml.AppearanceModule;
import org.citygml4j.model.module.citygml.BridgeModule;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.model.module.citygml.CityFurnitureModule;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CityGMLModuleType;
import org.citygml4j.model.module.citygml.CityGMLModuleVersion;
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

public class CityGMLMarshaller {
	private final JAXBMarshaller jaxb;

	private final Appearance200Marshaller app200;
	private final Bridge200Marshaller brid200;
	private final Building200Marshaller bldg200;
	private final CityFurniture200Marshaller frn200;
	private final CityObjectGroup200Marshaller grp200;
	private final Core200Marshaller core200;
	private final Generics200Marshaller gen200;
	private final LandUse200Marshaller luse200;
	private final Relief200Marshaller dem200;
	private final TexturedSurface200Marshaller tex200;
	private final Transportation200Marshaller tran200;
	private final Tunnel200Marshaller tun200;
	private final Vegetation200Marshaller veg200;
	private final WaterBody200Marshaller wtr200;

	private final Appearance100Marshaller app100;
	private final Building100Marshaller bldg100;
	private final CityFurniture100Marshaller frn100;
	private final CityObjectGroup100Marshaller grp100;
	private final Core100Marshaller core100;
	private final Generics100Marshaller gen100;
	private final LandUse100Marshaller luse100;
	private final Relief100Marshaller dem100;
	private final TexturedSurface100Marshaller tex100;
	private final Transportation100Marshaller tran100;
	private final Vegetation100Marshaller veg100;
	private final WaterBody100Marshaller wtr100;

	private final Appearance040Marshaller app040;
	private final Building040Marshaller bldg040;
	private final CityFurniture040Marshaller frn040;
	private final CityObjectGroup040Marshaller grp040;
	private final Core040Marshaller core040;
	private final Generics040Marshaller gen040;
	private final LandUse040Marshaller luse040;
	private final Relief040Marshaller dem040;
	private final TexturedSurface040Marshaller tex040;
	private final Transportation040Marshaller tran040;
	private final Vegetation040Marshaller veg040;
	private final WaterBody040Marshaller wtr040;

	public CityGMLMarshaller(JAXBMarshaller jaxb) {
		this.jaxb = jaxb;	

		app200 = new Appearance200Marshaller(this);
		brid200 = new Bridge200Marshaller(this);
		bldg200 = new Building200Marshaller(this);
		frn200 = new CityFurniture200Marshaller(this);
		grp200 = new CityObjectGroup200Marshaller(this);		
		core200 = new Core200Marshaller(this);
		gen200 = new Generics200Marshaller(this);
		luse200 = new LandUse200Marshaller(this);
		dem200 = new Relief200Marshaller(this);
		tex200 = new TexturedSurface200Marshaller(this);
		tran200 = new Transportation200Marshaller(this);
		tun200 = new Tunnel200Marshaller(this);
		veg200 = new Vegetation200Marshaller(this);
		wtr200 = new WaterBody200Marshaller(this);

		app100 = new Appearance100Marshaller(this);
		bldg100 = new Building100Marshaller(this);
		frn100 = new CityFurniture100Marshaller(this);
		grp100 = new CityObjectGroup100Marshaller(this);		
		core100 = new Core100Marshaller(this);
		gen100 = new Generics100Marshaller(this);
		luse100 = new LandUse100Marshaller(this);
		dem100 = new Relief100Marshaller(this);
		tex100 = new TexturedSurface100Marshaller(this);
		tran100 = new Transportation100Marshaller(this);
		veg100 = new Vegetation100Marshaller(this);
		wtr100 = new WaterBody100Marshaller(this);

		core040 = new Core040Marshaller(this);
		app040 = new Appearance040Marshaller(this);
		bldg040 = new Building040Marshaller(this);
		frn040 = new CityFurniture040Marshaller(this);
		grp040 = new CityObjectGroup040Marshaller(this);
		gen040 = new Generics040Marshaller(this);
		luse040 = new LandUse040Marshaller(this);
		dem040 = new Relief040Marshaller(this);
		tex040 = new TexturedSurface040Marshaller(this);
		tran040 = new Transportation040Marshaller(this);
		veg040 = new Vegetation040Marshaller(this);
		wtr040 = new WaterBody040Marshaller(this);		
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {		
		CityGMLModule module = getCityGMLModule(src);
		if (module == null)
			return null;
		
		JAXBElement<?> dest = null;
		CityGMLModuleType type = module.getType();
		CityGMLModuleVersion version = module.getVersion();

		if (type == CityGMLModuleType.APPEARANCE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = app200.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = app100.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = app040.marshalJAXBElement(src);
		}
		
		else if (type == CityGMLModuleType.BRIDGE) {
			dest = brid200.marshalJAXBElement(src);
		}

		else if (type == CityGMLModuleType.BUILDING) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = bldg200.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = bldg100.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = bldg040.marshalJAXBElement(src);
		}

		else if (type == CityGMLModuleType.CITY_FURNITURE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = frn200.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = frn100.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = frn040.marshalJAXBElement(src);
		}

		else if (type == CityGMLModuleType.CITY_OBJECT_GROUP) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = grp200.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = grp100.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = grp040.marshalJAXBElement(src);
		}		

		else if (type == CityGMLModuleType.GENERICS) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = gen200.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = gen100.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = gen040.marshalJAXBElement(src);
		}

		else if (type == CityGMLModuleType.LAND_USE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = luse200.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = luse100.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = luse040.marshalJAXBElement(src);
		}

		else if (type == CityGMLModuleType.RELIEF) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = dem200.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = dem100.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = dem040.marshalJAXBElement(src);
		}

		else if (type == CityGMLModuleType.TEXTURED_SURFACE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = tex200.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = tex100.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = tex040.marshalJAXBElement(src);
		}

		else if (type == CityGMLModuleType.TRANSPORTATION) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = tran200.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = tran100.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = tran040.marshalJAXBElement(src);
		}
		
		else if (type == CityGMLModuleType.TUNNEL) {
			dest = tun200.marshalJAXBElement(src);
		}

		else if (type == CityGMLModuleType.VEGETATION) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = veg200.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = veg100.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = veg040.marshalJAXBElement(src);
		}

		else if (type == CityGMLModuleType.WATER_BODY) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = wtr200.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = wtr100.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = wtr040.marshalJAXBElement(src);
		}

		else if (type == CityGMLModuleType.CORE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = core200.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = core100.marshalJAXBElement(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = core040.marshalJAXBElement(src);
		}

		return dest;
	}

	public Object marshal(ModelObject src) {
		CityGMLModule module = getCityGMLModule(src);
		if (module == null)
			return null;
		
		Object dest = null;
		CityGMLModuleType type = module.getType();
		CityGMLModuleVersion version = module.getVersion();

		if (type == CityGMLModuleType.APPEARANCE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = app200.marshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = app100.marshal(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = app040.marshal(src);
		}
		
		else if (type == CityGMLModuleType.BRIDGE) {
			dest = brid200.marshal(src);
		}

		else if (type == CityGMLModuleType.BUILDING) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = bldg200.marshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = bldg100.marshal(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = bldg040.marshal(src);
		}

		else if (type == CityGMLModuleType.CITY_FURNITURE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = frn200.marshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = frn100.marshal(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = frn040.marshal(src);
		}

		else if (type == CityGMLModuleType.CITY_OBJECT_GROUP) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = grp200.marshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = grp100.marshal(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = grp040.marshal(src);
		}	

		else if (type == CityGMLModuleType.GENERICS) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = gen200.marshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = gen100.marshal(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = gen040.marshal(src);
		}

		else if (type == CityGMLModuleType.LAND_USE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = luse200.marshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = luse100.marshal(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = luse100.marshal(src);
		}

		else if (type == CityGMLModuleType.RELIEF) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = dem200.marshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = dem100.marshal(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = dem040.marshal(src);
		}

		else if (type == CityGMLModuleType.TEXTURED_SURFACE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = tex200.marshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = tex100.marshal(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = tex040.marshal(src);
		}

		else if (type == CityGMLModuleType.TRANSPORTATION) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = tran200.marshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = tran100.marshal(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = tran040.marshal(src);
		}
		
		else if (type == CityGMLModuleType.TUNNEL) {
			dest = tun200.marshal(src);
		}

		else if (type == CityGMLModuleType.VEGETATION) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = veg200.marshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = veg100.marshal(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = veg040.marshal(src);
		}

		else if (type == CityGMLModuleType.WATER_BODY) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = wtr200.marshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = wtr100.marshal(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = wtr040.marshal(src);
		}

		else if (type == CityGMLModuleType.CORE) {
			if (version == CityGMLModuleVersion.v2_0_0)
				dest = core200.marshal(src);
			else if (version == CityGMLModuleVersion.v1_0_0)
				dest = core100.marshal(src);
			else if (version == CityGMLModuleVersion.v0_4_0)
				dest = core040.marshal(src);
		}

		return dest;
	}

	public JAXBElement<Object> ade2jaxbElement(ADEComponent ade) {
		QName qName = new QName(ade.getNamespaceURI(), ade.getLocalName());
		return new JAXBElement<Object>(qName, Object.class, ade.getContent());
	}

	public JAXBMarshaller getJAXBMarshaller() {
		return jaxb;
	}

	public Appearance200Marshaller getAppearance200Marshaller() {
		return app200;
	}

	public Bridge200Marshaller getBridge200Marshaller() {
		return brid200;
	}

	public Building200Marshaller getBuilding200Marshaller() {
		return bldg200;
	}

	public CityFurniture200Marshaller getCityFurniture200Marshaller() {
		return frn200;
	}

	public CityObjectGroup200Marshaller getCityObjectGroup200Marshaller() {
		return grp200;
	}

	public Core200Marshaller getCore200Marshaller() {
		return core200;
	}

	public Generics200Marshaller getGenerics200Marshaller() {
		return gen200;
	}

	public LandUse200Marshaller getLandUse200Marshaller() {
		return luse200;
	}

	public Relief200Marshaller getRelief200Marshaller() {
		return dem200;
	}

	public TexturedSurface200Marshaller getTexturedSurface200Marshaller() {
		return tex200;
	}

	public Transportation200Marshaller getTransportation200Marshaller() {
		return tran200;
	}

	public Tunnel200Marshaller getTunnel200Marshaller() {
		return tun200;
	}

	public Vegetation200Marshaller getVegetation200Marshaller() {
		return veg200;
	}

	public WaterBody200Marshaller getWaterBody200Marshaller() {
		return wtr200;
	}

	public Appearance100Marshaller getAppearance100Marshaller() {
		return app100;
	}

	public Building100Marshaller getBuilding100Marshaller() {
		return bldg100;
	}

	public CityFurniture100Marshaller getCityFurniture100Marshaller() {
		return frn100;
	}

	public CityObjectGroup100Marshaller getCityObjectGroup100Marshaller() {
		return grp100;
	}

	public Core100Marshaller getCore100Marshaller() {
		return core100;
	}

	public Generics100Marshaller getGenerics100Marshaller() {
		return gen100;
	}

	public LandUse100Marshaller getLandUse100Marshaller() {
		return luse100;
	}

	public Relief100Marshaller getRelief100Marshaller() {
		return dem100;
	}

	public TexturedSurface100Marshaller getTexturedSurface100Marshaller() {
		return tex100;
	}

	public Transportation100Marshaller getTransportation100Marshaller() {
		return tran100;
	}

	public Vegetation100Marshaller getVegetation100Marshaller() {
		return veg100;
	}

	public WaterBody100Marshaller getWaterBody100Marshaller() {
		return wtr100;
	}	

	public Appearance040Marshaller getAppearance040Marshaller() {
		return app040;
	}

	public Building040Marshaller getBuilding040Marshaller() {
		return bldg040;
	}

	public CityFurniture040Marshaller getCityFurniture040Marshaller() {
		return frn040;
	}

	public CityObjectGroup040Marshaller getCityObjectGroup040Marshaller() {
		return grp040;
	}

	public Core040Marshaller getCore040Marshaller() {
		return core040;
	}

	public Generics040Marshaller getGenerics040Marshaller() {
		return gen040;
	}

	public LandUse040Marshaller getLandUse040Marshaller() {
		return luse040;
	}

	public Relief040Marshaller getRelief040Marshaller() {
		return dem040;
	}

	public TexturedSurface040Marshaller getTexturedSurface040Marshaller() {
		return tex040;
	}

	public Transportation040Marshaller getTransportation040Marshaller() {
		return tran040;
	}

	public Vegetation040Marshaller getVegetation040Marshaller() {
		return veg040;
	}

	public WaterBody040Marshaller getWaterBody040Marshaller() {
		return wtr040;
	}

	private CityGMLModule getCityGMLModule(Object src) {

		if (src instanceof ModelObject) {
			ModuleContext moduleContext = jaxb.getModuleContext();

			if (src instanceof AppearanceModuleComponent)
				return (AppearanceModule)moduleContext.getModule(CityGMLModuleType.APPEARANCE);
			else if (src instanceof BridgeModuleComponent)
				return (BridgeModule)moduleContext.getModule(CityGMLModuleType.BRIDGE);
			else if (src instanceof BuildingModuleComponent)
				return (BuildingModule)moduleContext.getModule(CityGMLModuleType.BUILDING);
			else if (src instanceof CityFurnitureModuleComponent)
				return (CityFurnitureModule)moduleContext.getModule(CityGMLModuleType.CITY_FURNITURE);
			else if (src instanceof CityObjectGroupModuleComponent)
				return (CityObjectGroupModule)moduleContext.getModule(CityGMLModuleType.CITY_OBJECT_GROUP);
			else if (src instanceof GenericsModuleComponent)
				return (GenericsModule)moduleContext.getModule(CityGMLModuleType.GENERICS);
			else if (src instanceof LandUseModuleComponent)
				return (LandUseModule)moduleContext.getModule(CityGMLModuleType.LAND_USE);
			else if (src instanceof ReliefModuleComponent)
				return (ReliefModule)moduleContext.getModule(CityGMLModuleType.RELIEF);
			else if (src instanceof TexturedSurfaceModuleComponent)
				return (TexturedSurfaceModule)moduleContext.getModule(CityGMLModuleType.TEXTURED_SURFACE);
			else if (src instanceof TransportationModuleComponent)
				return (TransportationModule)moduleContext.getModule(CityGMLModuleType.TRANSPORTATION);
			else if (src instanceof TunnelModuleComponent)
				return (TunnelModule)moduleContext.getModule(CityGMLModuleType.TUNNEL);
			else if (src instanceof VegetationModuleComponent)
				return (VegetationModule)moduleContext.getModule(CityGMLModuleType.VEGETATION);
			else if (src instanceof WaterBodyModuleComponent)
				return (WaterBodyModule)moduleContext.getModule(CityGMLModuleType.WATER_BODY);
			else
				return (CoreModule)moduleContext.getModule(CityGMLModuleType.CORE);		
		}

		else if (src.getClass().getPackage().getName().startsWith("org.citygml4j.jaxb.citygml")) {
			String packagePart = src.getClass().getPackage().getName().replaceFirst("org.citygml4j.jaxb.citygml", "");
			String versionPart = packagePart.substring(packagePart.lastIndexOf('.') + 1, packagePart.length());

			if (versionPart.equals("_0_4"))
				return CoreModule.v0_4_0;
			else {
				String modulePart = packagePart.substring(1, packagePart.lastIndexOf('.'));
				CityGMLModuleVersion version = versionPart.equals("_2") ? CityGMLModuleVersion.v2_0_0 : CityGMLModuleVersion.v1_0_0;

				for (CityGMLModule module : Modules.getCityGMLModules()) {
					if (module.getVersion() == version && module.getNamespacePrefix().equals(modulePart))
						return module;
				}			
			}
		}

		return null;
	}

}
