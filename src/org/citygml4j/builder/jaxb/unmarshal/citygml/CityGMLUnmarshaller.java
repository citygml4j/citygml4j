/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
package org.citygml4j.builder.jaxb.unmarshal.citygml;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.appearance.Appearance040Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.appearance.Appearance100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.building.Building040Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.building.Building100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.cityfurniture.CityFurniture040Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.cityfurniture.CityFurniture100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.cityobjectgroup.CityObjectGroup040Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.cityobjectgroup.CityObjectGroup100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.core.Core040Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.core.Core100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.generics.Generics040Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.generics.Generics100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.landuse.LandUse040Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.landuse.LandUse100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.relief.Relief040Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.relief.Relief100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.texturedsurface.TexturedSurface040Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.texturedsurface.TexturedSurface100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.transportation.Transportation040Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.transportation.Transportation100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.vegetation.Vegetation040Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.vegetation.Vegetation100Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.waterbody.WaterBody040Unmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.waterbody.WaterBody100Unmarshaller;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.module.citygml.AppearanceModule;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.model.module.citygml.CityFurnitureModule;
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
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class CityGMLUnmarshaller {
	private final JAXBUnmarshaller jaxb;	

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

	private final Appearance040Unmarshaller app040;
	private final Building040Unmarshaller bldg040;
	private final CityFurniture040Unmarshaller frn040;
	private final CityObjectGroup040Unmarshaller grp040;
	private final Core040Unmarshaller core040;
	private final Generics040Unmarshaller gen040;
	private final LandUse040Unmarshaller luse040;
	private final Relief040Unmarshaller dem040;
	private final TexturedSurface040Unmarshaller tex040;
	private final Transportation040Unmarshaller tran040;
	private final Vegetation040Unmarshaller veg040;
	private final WaterBody040Unmarshaller wtr040;

	public CityGMLUnmarshaller(JAXBUnmarshaller jaxb) {
		this.jaxb = jaxb;		

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

		app040 = new Appearance040Unmarshaller(this);
		bldg040 = new Building040Unmarshaller(this);
		frn040 = new CityFurniture040Unmarshaller(this);
		grp040 = new CityObjectGroup040Unmarshaller(this);
		core040 = new Core040Unmarshaller(this);
		gen040 = new Generics040Unmarshaller(this);
		luse040 = new LandUse040Unmarshaller(this);
		dem040 = new Relief040Unmarshaller(this);
		tex040 = new TexturedSurface040Unmarshaller(this);
		tran040 = new Transportation040Unmarshaller(this);
		veg040 = new Vegetation040Unmarshaller(this);
		wtr040 = new WaterBody040Unmarshaller(this);
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		final String namespaceURI = src.getName().getNamespaceURI();

		CityGML dest = null;

		// CityGML version 1.0.0
		if (namespaceURI.equals(AppearanceModule.v1_0_0.getNamespaceURI()))
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

		// CityGML version 0.4.0
		else if (namespaceURI.equals(CoreModule.v0_4_0.getNamespaceURI())) {			
			dest = app040.unmarshal(src);			
			if (dest == null)
				dest = bldg040.unmarshal(src);			
			if (dest == null)
				dest = frn040.unmarshal(src);			
			if (dest == null)
				dest = grp040.unmarshal(src);			
			if (dest == null)
				dest = core040.unmarshal(src);			
			if (dest == null)
				dest = gen040.unmarshal(src);			
			if (dest == null)
				dest = luse040.unmarshal(src);			
			if (dest == null)
				dest = dem040.unmarshal(src);			
			if (dest == null)
				dest = tex040.unmarshal(src);			
			if (dest == null)
				dest = tran040.unmarshal(src);			
			if (dest == null)
				dest = veg040.unmarshal(src);			
			if (dest == null)
				dest = wtr040.unmarshal(src);			
		}

		return dest;
	}

	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);
			
		CityGML dest = app100.unmarshal(src);
		if (dest == null)
			dest = bldg100.unmarshal(src);
		if (dest == null)
			dest = frn100.unmarshal(src);
		if (dest == null)
			dest = grp100.unmarshal(src);
		if (dest == null)
			dest = core100.unmarshal(src);
		if (dest == null)
			dest = gen100.unmarshal(src);
		if (dest == null)
			dest = luse100.unmarshal(src);
		if (dest == null)
			dest = dem100.unmarshal(src);
		if (dest == null)
			dest = tex100.unmarshal(src);
		if (dest == null)
			dest = tran100.unmarshal(src);
		if (dest == null)
			dest = veg100.unmarshal(src);
		if (dest == null)
			dest = wtr100.unmarshal(src);

		// CityGML version 0.4.0
		if (dest == null)
			dest = app040.unmarshal(src);			
		if (dest == null)
			dest = bldg040.unmarshal(src);			
		if (dest == null)
			dest = frn040.unmarshal(src);			
		if (dest == null)
			dest = grp040.unmarshal(src);			
		if (dest == null)
			dest = core040.unmarshal(src);			
		if (dest == null)
			dest = gen040.unmarshal(src);			
		if (dest == null)
			dest = luse040.unmarshal(src);			
		if (dest == null)
			dest = dem040.unmarshal(src);			
		if (dest == null)
			dest = tex040.unmarshal(src);			
		if (dest == null)
			dest = tran040.unmarshal(src);			
		if (dest == null)
			dest = veg040.unmarshal(src);			
		if (dest == null)
			dest = wtr040.unmarshal(src);			

		return dest;
	}

	public boolean assignGenericProperty(ADEComponent genericProperty, QName substitutionGroup, CityGML dest) {
		String namespaceURI = substitutionGroup.getNamespaceURI();
		CityGMLModuleVersion version = ((CityGML)dest).getCityGMLModule().getVersion();

		if (version == CityGMLModuleVersion.v1_0_0) {			
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
		}

		else if (version == CityGMLModuleVersion.v0_4_0) {
			if (namespaceURI.equals(CoreModule.v0_4_0.getNamespaceURI())) {
				boolean success = app040.assignGenericProperty(genericProperty, substitutionGroup, dest);
				if (!success)	
					success = bldg040.assignGenericProperty(genericProperty, substitutionGroup, dest);
				if (!success)	
					success = frn040.assignGenericProperty(genericProperty, substitutionGroup, dest);
				if (!success)	
					success = grp040.assignGenericProperty(genericProperty, substitutionGroup, dest);
				if (!success)	
					success = core040.assignGenericProperty(genericProperty, substitutionGroup, dest);
				if (!success)	
					success = luse040.assignGenericProperty(genericProperty, substitutionGroup, dest);
				if (!success)	
					success = dem040.assignGenericProperty(genericProperty, substitutionGroup, dest);
				if (!success)	
					success = tran040.assignGenericProperty(genericProperty, substitutionGroup, dest);
				if (!success)	
					success = veg040.assignGenericProperty(genericProperty, substitutionGroup, dest);
				if (!success)	
					success = wtr040.assignGenericProperty(genericProperty, substitutionGroup, dest);

				return success;
			}
		}

		return false;
	}

	public JAXBUnmarshaller getJAXBUnmarshaller() {
		return jaxb;
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

	public Appearance040Unmarshaller getAppearance040Unmarshaller() {
		return app040;
	}

	public Building040Unmarshaller getBuilding040Unmarshaller() {
		return bldg040;
	}

	public CityFurniture040Unmarshaller getCityFurniture040Unmarshaller() {
		return frn040;
	}

	public CityObjectGroup040Unmarshaller getCityObjectGroup040Unmarshaller() {
		return grp040;
	}

	public Core040Unmarshaller getCore040Unmarshaller() {
		return core040;
	}

	public Generics040Unmarshaller getGenerics040Unmarshaller() {
		return gen040;
	}

	public LandUse040Unmarshaller getLandUse040Unmarshaller() {
		return luse040;
	}

	public Relief040Unmarshaller getRelief040Unmarshaller() {
		return dem040;
	}

	public TexturedSurface040Unmarshaller getTexturedSurface040Unmarshaller() {
		return tex040;
	}

	public Transportation040Unmarshaller getTransportation040Unmarshaller() {
		return tran040;
	}

	public Vegetation040Unmarshaller getVegetation040Unmarshaller() {
		return veg040;
	}

	public WaterBody040Unmarshaller getWaterBody040Unmarshaller() {
		return wtr040;
	}

}
