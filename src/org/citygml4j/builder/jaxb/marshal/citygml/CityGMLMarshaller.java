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
import org.citygml4j.builder.jaxb.marshal.citygml.building.Building040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.building.Building100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.cityfurniture.CityFurniture040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.cityfurniture.CityFurniture100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.cityobjectgroup.CityObjectGroup040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.cityobjectgroup.CityObjectGroup100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.core.Core040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.core.Core100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.generics.Generics040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.generics.Generics100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.landuse.LandUse040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.landuse.LandUse100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.relief.Relief040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.relief.Relief100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.texturedsurface.TexturedSurface040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.texturedsurface.TexturedSurface100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.transportation.Transportation040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.transportation.Transportation100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.vegetation.Vegetation040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.vegetation.Vegetation100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.waterbody.WaterBody040Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.waterbody.WaterBody100Marshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AppearanceModuleComponent;
import org.citygml4j.model.citygml.building.BuildingModuleComponent;
import org.citygml4j.model.citygml.cityfurniture.CityFurnitureModuleComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupModuleComponent;
import org.citygml4j.model.citygml.generics.GenericsModuleComponent;
import org.citygml4j.model.citygml.landuse.LandUseModuleComponent;
import org.citygml4j.model.citygml.relief.ReliefModuleComponent;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModuleComponent;
import org.citygml4j.model.citygml.transportation.TransportationModuleComponent;
import org.citygml4j.model.citygml.vegetation.VegetationModuleComponent;
import org.citygml4j.model.citygml.waterbody.WaterBodyModuleComponent;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.AppearanceModule;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.model.module.citygml.CityFurnitureModule;
import org.citygml4j.model.module.citygml.CityGMLModuleType;
import org.citygml4j.model.module.citygml.CityGMLModuleVersion;
import org.citygml4j.model.module.citygml.CityObjectGroupModule;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.module.citygml.GenericsModule;
import org.citygml4j.model.module.citygml.LandUseModule;
import org.citygml4j.model.module.citygml.ReliefModule;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;
import org.citygml4j.model.module.citygml.TransportationModule;
import org.citygml4j.model.module.citygml.VegetationModule;
import org.citygml4j.model.module.citygml.WaterBodyModule;

public class CityGMLMarshaller {
	private final JAXBMarshaller jaxb;

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
		JAXBElement<?> dest = null;
		ModuleContext moduleContext = jaxb.getModuleContext();

		AppearanceModule app = (AppearanceModule)moduleContext.getModule(CityGMLModuleType.APPEARANCE);
		if (app.getVersion() == CityGMLModuleVersion.v1_0_0)
			dest = app100.marshalJAXBElement(src);
		else if (app.getVersion() == CityGMLModuleVersion.v0_4_0)
			dest = app040.marshalJAXBElement(src);

		if (dest == null) {
			BuildingModule bldg = (BuildingModule)moduleContext.getModule(CityGMLModuleType.BUILDING);
			if (bldg.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = bldg100.marshalJAXBElement(src);
			else if (bldg.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = bldg040.marshalJAXBElement(src);
		}
		
		if (dest == null) {
			CityFurnitureModule frn = (CityFurnitureModule)moduleContext.getModule(CityGMLModuleType.CITY_FURNITURE);
			if (frn.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = frn100.marshalJAXBElement(src);
			else if (frn.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = frn040.marshalJAXBElement(src);
		}

		if (dest == null) {
			CityObjectGroupModule grp = (CityObjectGroupModule)moduleContext.getModule(CityGMLModuleType.CITY_OBJECT_GROUP);
			if (grp.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = grp100.marshalJAXBElement(src);
			else if (grp.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = grp040.marshalJAXBElement(src);
		}		
		
		if (dest == null) {
			GenericsModule gen = (GenericsModule)moduleContext.getModule(CityGMLModuleType.GENERICS);
			if (gen.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = gen100.marshalJAXBElement(src);
			else if (gen.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = gen040.marshalJAXBElement(src);
		}
		
		if (dest == null) {
			LandUseModule luse = (LandUseModule)moduleContext.getModule(CityGMLModuleType.LAND_USE);
			if (luse.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = luse100.marshalJAXBElement(src);
			else if (luse.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = luse040.marshalJAXBElement(src);
		}
		
		if (dest == null) {
			ReliefModule dem = (ReliefModule)moduleContext.getModule(CityGMLModuleType.RELIEF);
			if (dem.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = dem100.marshalJAXBElement(src);
			else if (dem.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = dem040.marshalJAXBElement(src);
		}
		
		if (dest == null) {
			TexturedSurfaceModule tex = (TexturedSurfaceModule)moduleContext.getModule(CityGMLModuleType.TEXTURED_SURFACE);
			if (tex.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = tex100.marshalJAXBElement(src);
			else if (tex.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = tex040.marshalJAXBElement(src);
		}
		
		if (dest == null) {
			TransportationModule tran = (TransportationModule)moduleContext.getModule(CityGMLModuleType.TRANSPORTATION);
			if (tran.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = tran100.marshalJAXBElement(src);
			else if (tran.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = tran040.marshalJAXBElement(src);
		}
		
		if (dest == null) {
			VegetationModule veg = (VegetationModule)moduleContext.getModule(CityGMLModuleType.VEGETATION);
			if (veg.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = veg100.marshalJAXBElement(src);
			else if (veg.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = veg040.marshalJAXBElement(src);
		}
		
		if (dest == null) {
			WaterBodyModule wtr = (WaterBodyModule)moduleContext.getModule(CityGMLModuleType.WATER_BODY);
			if (wtr.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = wtr100.marshalJAXBElement(src);
			else if (wtr.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = wtr040.marshalJAXBElement(src);
		}

		if (dest == null) {
			CoreModule core = (CoreModule)moduleContext.getModule(CityGMLModuleType.CORE);		
			if (core.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = core100.marshalJAXBElement(src);
			else if (core.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = core040.marshalJAXBElement(src);
		}

		return dest;
	}

	public Object marshal(ModelObject src) {		
		Object dest = null;
		ModuleContext moduleContext = jaxb.getModuleContext();

		if (src instanceof AppearanceModuleComponent) {
			AppearanceModule app = (AppearanceModule)moduleContext.getModule(CityGMLModuleType.APPEARANCE);
			if (app.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = app100.marshal(src);
			else if (app.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = app040.marshal(src);
		}

		else if (src instanceof BuildingModuleComponent) {
			BuildingModule bldg = (BuildingModule)moduleContext.getModule(CityGMLModuleType.BUILDING);
			if (bldg.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = bldg100.marshal(src);
			else if (bldg.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = bldg040.marshal(src);
		}

		else if (src instanceof CityFurnitureModuleComponent) {
			CityFurnitureModule frn = (CityFurnitureModule)moduleContext.getModule(CityGMLModuleType.CITY_FURNITURE);
			if (frn.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = frn100.marshal(src);
			else if (frn.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = frn040.marshal(src);
		}
		
		else if (src instanceof CityObjectGroupModuleComponent) {
			CityObjectGroupModule grp = (CityObjectGroupModule)moduleContext.getModule(CityGMLModuleType.CITY_OBJECT_GROUP);
			if (grp.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = grp100.marshal(src);
			else if (grp.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = grp040.marshal(src);
		}	

		else if (src instanceof GenericsModuleComponent) {
			GenericsModule gen = (GenericsModule)moduleContext.getModule(CityGMLModuleType.GENERICS);
			if (gen.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = gen100.marshal(src);
			else if (gen.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = gen040.marshal(src);
		}
		
		else if (src instanceof LandUseModuleComponent) {
			LandUseModule luse = (LandUseModule)moduleContext.getModule(CityGMLModuleType.LAND_USE);
			if (luse.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = luse100.marshal(src);
			else if (luse.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = luse100.marshal(src);
		}
		
		else if (src instanceof ReliefModuleComponent) {
			ReliefModule dem = (ReliefModule)moduleContext.getModule(CityGMLModuleType.RELIEF);
			if (dem.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = dem100.marshal(src);
			else if (dem.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = dem040.marshal(src);
		}
		
		else if (src instanceof TexturedSurfaceModuleComponent) {
			TexturedSurfaceModule tex = (TexturedSurfaceModule)moduleContext.getModule(CityGMLModuleType.TEXTURED_SURFACE);
			if (tex.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = tex100.marshal(src);
			else if (tex.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = tex040.marshal(src);
		}
		
		else if (src instanceof TransportationModuleComponent) {
			TransportationModule tran = (TransportationModule)moduleContext.getModule(CityGMLModuleType.TRANSPORTATION);
			if (tran.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = tran100.marshal(src);
			else if (tran.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = tran040.marshal(src);
		}

		else if (src instanceof VegetationModuleComponent) {
			VegetationModule veg = (VegetationModule)moduleContext.getModule(CityGMLModuleType.VEGETATION);
			if (veg.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = veg100.marshal(src);
			else if (veg.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = veg040.marshal(src);
		}

		else if (src instanceof WaterBodyModuleComponent) {
			WaterBodyModule wtr = (WaterBodyModule)moduleContext.getModule(CityGMLModuleType.WATER_BODY);
			if (wtr.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = wtr100.marshal(src);
			else if (wtr.getVersion() == CityGMLModuleVersion.v0_4_0)
				dest = wtr040.marshal(src);
		}
		
		else {
			CoreModule core = (CoreModule)moduleContext.getModule(CityGMLModuleType.CORE);		
			if (core.getVersion() == CityGMLModuleVersion.v1_0_0)
				dest = core100.marshal(src);
			else if (core.getVersion() == CityGMLModuleVersion.v0_4_0)
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

	public WaterBody040Marshaller getWaterBody040Marshaller() {
		return wtr040;
	}
	
}
