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
package org.citygml4j.builder.jaxb.unmarshal.citygml.vegetation;

import net.opengis.citygml.vegetation._1.AbstractVegetationObjectType;
import net.opengis.citygml.vegetation._1.PlantCoverType;
import net.opengis.citygml.vegetation._1.SolitaryVegetationObjectType;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.vegetation.AbstractVegetationObject;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.module.citygml.VegetationModule;
import org.citygml4j.util.mapper.CheckedTypeMapper;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.concurrent.locks.ReentrantLock;

public class Vegetation100Unmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final VegetationModule module = VegetationModule.v1_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;
	private CheckedTypeMapper<CityGML> typeMapper;

	public Vegetation100Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	private CheckedTypeMapper<CityGML> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = CheckedTypeMapper.<CityGML>create()
							.with(PlantCoverType.class, this::unmarshalPlantCover)
							.with(SolitaryVegetationObjectType.class, this::unmarshalSolitaryVegetationObject)
							.with(JAXBElement.class, this::unmarshal);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		return unmarshal(src.getValue());
	}

	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		return getTypeMapper().apply(src);
	}

	public void unmarshalAbstractVegetationObject(AbstractVegetationObjectType src, AbstractVegetationObject dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSet_GenericApplicationPropertyOfVegetationObject()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfVegetationObject()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfVegetationObject(ade);
			}
		}
	}

	public void unmarshalPlantCover(PlantCoverType src, PlantCover dest) throws MissingADESchemaException {
		unmarshalAbstractVegetationObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(new Code(src.getClazz()));

		if (src.isSetFunction()) {
			for (String function : src.getFunction())
				dest.addFunction(new Code(function));
		}

		if (src.isSetAverageHeight())
			dest.setAverageHeight(jaxb.getGMLUnmarshaller().unmarshalLength(src.getAverageHeight()));

		if (src.isSetLod1MultiSurface())
			dest.setLod1MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod1MultiSurface()));

		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod2MultiSurface()));

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod4MultiSurface()));

		if (src.isSetLod1MultiSolid())
			dest.setLod1MultiSolid(jaxb.getGMLUnmarshaller().unmarshalMultiSolidProperty(src.getLod1MultiSolid()));

		if (src.isSetLod2MultiSolid())
			dest.setLod2MultiSolid(jaxb.getGMLUnmarshaller().unmarshalMultiSolidProperty(src.getLod2MultiSolid()));

		if (src.isSetLod3MultiSolid())
			dest.setLod3MultiSolid(jaxb.getGMLUnmarshaller().unmarshalMultiSolidProperty(src.getLod3MultiSolid()));

		if (src.isSet_GenericApplicationPropertyOfPlantCover()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfPlantCover()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfPlantCover(ade);
			}
		}
	}

	public PlantCover unmarshalPlantCover(PlantCoverType src) throws MissingADESchemaException {
		PlantCover dest = new PlantCover(module);
		unmarshalPlantCover(src, dest);

		return dest;
	}

	public void unmarshalSolitaryVegetationObject(SolitaryVegetationObjectType src, SolitaryVegetationObject dest) throws MissingADESchemaException {
		unmarshalAbstractVegetationObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(new Code(src.getClazz()));

		if (src.isSetFunction()) {
			for (String function : src.getFunction())
				dest.addFunction(new Code(function));
		}

		if (src.isSetSpecies())
			dest.setSpecies(new Code(src.getSpecies()));

		if (src.isSetHeight())
			dest.setHeight(jaxb.getGMLUnmarshaller().unmarshalLength(src.getHeight()));

		if (src.isSetTrunkDiameter())
			dest.setTrunkDiameter(jaxb.getGMLUnmarshaller().unmarshalLength(src.getTrunkDiameter()));

		if (src.isSetCrownDiameter())
			dest.setCrownDiameter(jaxb.getGMLUnmarshaller().unmarshalLength(src.getCrownDiameter()));

		if (src.isSetLod1Geometry())
			dest.setLod1Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod1Geometry()));

		if (src.isSetLod2Geometry())
			dest.setLod2Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod2Geometry()));

		if (src.isSetLod3Geometry())
			dest.setLod3Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod3Geometry()));

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod1ImplicitRepresentation())
			dest.setLod1ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod1ImplicitRepresentation()));

		if (src.isSetLod2ImplicitRepresentation())
			dest.setLod2ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation()));

		if (src.isSetLod3ImplicitRepresentation())
			dest.setLod3ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));

		if (src.isSet_GenericApplicationPropertyOfSolitaryVegetationObject()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfSolitaryVegetationObject()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfSolitaryVegetationObject(ade);
			}
		}
	}

	public SolitaryVegetationObject unmarshalSolitaryVegetationObject(SolitaryVegetationObjectType src) throws MissingADESchemaException {
		SolitaryVegetationObject dest = new SolitaryVegetationObject(module);
		unmarshalSolitaryVegetationObject(src, dest);

		return dest;
	}

	public boolean assignGenericProperty(ADEGenericElement genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;

		if (dest instanceof AbstractVegetationObject && name.equals("_GenericApplicationPropertyOfVegetationObject"))
			((AbstractVegetationObject)dest).addGenericApplicationPropertyOfVegetationObject(genericProperty);		
		else if (dest instanceof PlantCover && name.equals("_GenericApplicationPropertyOfPlantCover"))
			((PlantCover)dest).addGenericApplicationPropertyOfPlantCover(genericProperty);		
		else if (dest instanceof SolitaryVegetationObject && name.equals("_GenericApplicationPropertyOfSolitaryVegetationObject"))
			((SolitaryVegetationObject)dest).addGenericApplicationPropertyOfSolitaryVegetationObject(genericProperty);		
		else
			success = false;

		return success;
	}

}
