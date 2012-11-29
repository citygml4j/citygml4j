/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
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
 * 
 * $Id: LandUse200Unmarshaller.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.builder.jaxb.unmarshal.citygml.landuse;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.jaxb.citygml.luse._2.LandUseType;
import org.citygml4j.jaxb.gml._3_1_1.CodeType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.module.citygml.LandUseModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class LandUse200Unmarshaller {
	private final LandUseModule module = LandUseModule.v2_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public LandUse200Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		return unmarshal(src.getValue());
	}

	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);

		CityGML dest = null;

		if (src instanceof LandUseType)
			dest = unmarshalLandUse((LandUseType)src);

		return dest;
	}

	public void unmarshalLandUse(LandUseType src, LandUse dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLUnmarshaller().unmarshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (CodeType function : src.getFunction())
				dest.addFunction(jaxb.getGMLUnmarshaller().unmarshalCode(function));
		}

		if (src.isSetUsage()) {
			for (CodeType usage : src.getUsage())
				dest.addUsage(jaxb.getGMLUnmarshaller().unmarshalCode(usage));
		}

		if (src.isSetLod0MultiSurface())
			dest.setLod0MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod0MultiSurface()));

		if (src.isSetLod1MultiSurface())
			dest.setLod1MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod1MultiSurface()));

		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod2MultiSurface()));

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod4MultiSurface()));
	}

	public LandUse unmarshalLandUse(LandUseType src) throws MissingADESchemaException {
		LandUse dest = new LandUse(module);
		unmarshalLandUse(src, dest);

		return dest;
	}
	
	public boolean assignGenericProperty(ADEComponent genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;
		
		if (dest instanceof LandUse && name.equals("_GenericApplicationPropertyOfLandUse"))
			((LandUse)dest).addGenericApplicationPropertyOfLandUse(genericProperty);
		else 
			success = false;
		
		return success;
	}

}
