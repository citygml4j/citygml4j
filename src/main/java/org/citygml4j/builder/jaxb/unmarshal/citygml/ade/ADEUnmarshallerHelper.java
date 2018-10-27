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
package org.citygml4j.builder.jaxb.unmarshal.citygml.ade;

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
import org.citygml4j.builder.jaxb.unmarshal.gml.GMLUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.xal.XALUnmarshaller;

public class ADEUnmarshallerHelper {
	private final JAXBUnmarshaller jaxb;
	
	public ADEUnmarshallerHelper(JAXBUnmarshaller jaxb) {
		this.jaxb = jaxb;
	}
	
	public JAXBUnmarshaller getJAXBUnmarshaller() {
		return jaxb;
	}
	
	public Appearance200Unmarshaller getAppearance200Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getAppearance200Unmarshaller();
	}

	public Bridge200Unmarshaller getBridge200Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getBridge200Unmarshaller();
	}

	public Building200Unmarshaller getBuilding200Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getBuilding200Unmarshaller();
	}

	public CityFurniture200Unmarshaller getCityFurniture200Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getCityFurniture200Unmarshaller();
	}

	public CityObjectGroup200Unmarshaller getCityObjectGroup200Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getCityObjectGroup200Unmarshaller();
	}

	public Core200Unmarshaller getCore200Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getCore200Unmarshaller();
	}

	public Generics200Unmarshaller getGenerics200Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getGenerics200Unmarshaller();
	}

	public LandUse200Unmarshaller getLandUse200Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getLandUse200Unmarshaller();
	}

	public Relief200Unmarshaller getRelief200Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getRelief200Unmarshaller();
	}

	public TexturedSurface200Unmarshaller getTexturedSurface200Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getTexturedSurface200Unmarshaller();
	}

	public Tunnel200Unmarshaller getTunnel200Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getTunnel200Unmarshaller();
	}

	public Transportation200Unmarshaller getTransportation200Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getTransportation200Unmarshaller();
	}

	public Vegetation200Unmarshaller getVegetation200Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getVegetation200Unmarshaller();
	}

	public WaterBody200Unmarshaller getWaterBody200Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getWaterBody200Unmarshaller();
	}

	public Appearance100Unmarshaller getAppearance100Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getAppearance100Unmarshaller();
	}

	public Building100Unmarshaller getBuilding100Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getBuilding100Unmarshaller();
	}

	public CityFurniture100Unmarshaller getCityFurniture100Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getCityFurniture100Unmarshaller();
	}

	public CityObjectGroup100Unmarshaller getCityObjectGroup100Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getCityObjectGroup100Unmarshaller();
	}

	public Core100Unmarshaller getCore100Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getCore100Unmarshaller();
	}

	public Generics100Unmarshaller getGenerics100Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getGenerics100Unmarshaller();
	}

	public LandUse100Unmarshaller getLandUse100Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getLandUse100Unmarshaller();
	}

	public Relief100Unmarshaller getRelief100Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getRelief100Unmarshaller();
	}

	public TexturedSurface100Unmarshaller getTexturedSurface100Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getTexturedSurface100Unmarshaller();
	}

	public Transportation100Unmarshaller getTransportation100Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getTransportation100Unmarshaller();
	}

	public Vegetation100Unmarshaller getVegetation100Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getVegetation100Unmarshaller();
	}

	public WaterBody100Unmarshaller getWaterBody100Unmarshaller() {
		return jaxb.getCityGMLUnmarshaller().getWaterBody100Unmarshaller();
	}

	public GMLUnmarshaller getGMLUnmarshaller() {
		return jaxb.getGMLUnmarshaller();
	}

	public XALUnmarshaller getXALUnmarshaller() {
		return jaxb.getXALUnmarshaller();
	}
	
}
