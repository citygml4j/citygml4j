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
package org.citygml4j.builder.jaxb.marshal.citygml.ade;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.appearance.Appearance100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.appearance.Appearance200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.bridge.Bridge200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.building.Building100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.building.Building200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.cityfurniture.CityFurniture100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.cityfurniture.CityFurniture200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.cityobjectgroup.CityObjectGroup100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.cityobjectgroup.CityObjectGroup200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.core.Core100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.core.Core200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.generics.Generics100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.generics.Generics200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.landuse.LandUse100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.landuse.LandUse200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.relief.Relief100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.relief.Relief200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.texturedsurface.TexturedSurface100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.texturedsurface.TexturedSurface200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.transportation.Transportation100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.transportation.Transportation200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.tunnel.Tunnel200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.vegetation.Vegetation100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.vegetation.Vegetation200Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.waterbody.WaterBody100Marshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.waterbody.WaterBody200Marshaller;
import org.citygml4j.builder.jaxb.marshal.gml.GMLMarshaller;
import org.citygml4j.builder.jaxb.marshal.xal.XALMarshaller;
import org.citygml4j.model.module.citygml.CityGMLVersion;

public class ADEMarshallerHelper {
	private final JAXBMarshaller jaxb;
	
	public ADEMarshallerHelper(JAXBMarshaller jaxb) {
		this.jaxb = jaxb;
	}
	
	public CityGMLVersion getTargetCityGMLVersion() {
		return jaxb.getModuleContext().getCityGMLVersion();
	}
	
	public JAXBMarshaller getJAXBMarshaller() {
		return jaxb;
	}
	
	public Appearance200Marshaller getAppearance200Marshaller() {
		return jaxb.getCityGMLMarshaller().getAppearance200Marshaller();
	}

	public Bridge200Marshaller getBridge200Marshaller() {
		return jaxb.getCityGMLMarshaller().getBridge200Marshaller();
	}

	public Building200Marshaller getBuilding200Marshaller() {
		return jaxb.getCityGMLMarshaller().getBuilding200Marshaller();
	}

	public CityFurniture200Marshaller getCityFurniture200Marshaller() {
		return jaxb.getCityGMLMarshaller().getCityFurniture200Marshaller();
	}

	public CityObjectGroup200Marshaller getCityObjectGroup200Marshaller() {
		return jaxb.getCityGMLMarshaller().getCityObjectGroup200Marshaller();
	}

	public Core200Marshaller getCore200Marshaller() {
		return jaxb.getCityGMLMarshaller().getCore200Marshaller();
	}

	public Generics200Marshaller getGenerics200Marshaller() {
		return jaxb.getCityGMLMarshaller().getGenerics200Marshaller();
	}

	public LandUse200Marshaller getLandUse200Marshaller() {
		return jaxb.getCityGMLMarshaller().getLandUse200Marshaller();
	}

	public Relief200Marshaller getRelief200Marshaller() {
		return jaxb.getCityGMLMarshaller().getRelief200Marshaller();
	}

	public TexturedSurface200Marshaller getTexturedSurface200Marshaller() {
		return jaxb.getCityGMLMarshaller().getTexturedSurface200Marshaller();
	}

	public Transportation200Marshaller getTransportation200Marshaller() {
		return jaxb.getCityGMLMarshaller().getTransportation200Marshaller();
	}

	public Tunnel200Marshaller getTunnel200Marshaller() {
		return jaxb.getCityGMLMarshaller().getTunnel200Marshaller();
	}

	public Vegetation200Marshaller getVegetation200Marshaller() {
		return jaxb.getCityGMLMarshaller().getVegetation200Marshaller();
	}

	public WaterBody200Marshaller getWaterBody200Marshaller() {
		return jaxb.getCityGMLMarshaller().getWaterBody200Marshaller();
	}

	public Appearance100Marshaller getAppearance100Marshaller() {
		return jaxb.getCityGMLMarshaller().getAppearance100Marshaller();
	}

	public Building100Marshaller getBuilding100Marshaller() {
		return jaxb.getCityGMLMarshaller().getBuilding100Marshaller();
	}

	public CityFurniture100Marshaller getCityFurniture100Marshaller() {
		return jaxb.getCityGMLMarshaller().getCityFurniture100Marshaller();
	}

	public CityObjectGroup100Marshaller getCityObjectGroup100Marshaller() {
		return jaxb.getCityGMLMarshaller().getCityObjectGroup100Marshaller();
	}

	public Core100Marshaller getCore100Marshaller() {
		return jaxb.getCityGMLMarshaller().getCore100Marshaller();
	}

	public Generics100Marshaller getGenerics100Marshaller() {
		return jaxb.getCityGMLMarshaller().getGenerics100Marshaller();
	}

	public LandUse100Marshaller getLandUse100Marshaller() {
		return jaxb.getCityGMLMarshaller().getLandUse100Marshaller();
	}

	public Relief100Marshaller getRelief100Marshaller() {
		return jaxb.getCityGMLMarshaller().getRelief100Marshaller();
	}

	public TexturedSurface100Marshaller getTexturedSurface100Marshaller() {
		return jaxb.getCityGMLMarshaller().getTexturedSurface100Marshaller();
	}

	public Transportation100Marshaller getTransportation100Marshaller() {
		return jaxb.getCityGMLMarshaller().getTransportation100Marshaller();
	}

	public Vegetation100Marshaller getVegetation100Marshaller() {
		return jaxb.getCityGMLMarshaller().getVegetation100Marshaller();
	}

	public WaterBody100Marshaller getWaterBody100Marshaller() {
		return jaxb.getCityGMLMarshaller().getWaterBody100Marshaller();
	}
	
	public GMLMarshaller getGMLMarshaller() {
		return jaxb.getGMLMarshaller();
	}

	public XALMarshaller getXALMarshaller() {
		return jaxb.getXALMarshaller();
	}
	
}
