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
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.JAXBNamespacePrefixMapper;
import org.citygml4j.jaxb.citygml.bldg._1.AbstractBoundarySurfaceType;
import org.citygml4j.jaxb.citygml.bldg._1.BoundarySurfacePropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.BuildingType;
import org.citygml4j.jaxb.citygml.core._1.CityModelType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractFeatureType;
import org.citygml4j.jaxb.gml._3_1_1.FeaturePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.StringOrRefType;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.model.module.citygml.CityFurnitureModule;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;

public class UsingJAXB {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext cityGMLCtx = new CityGMLContext();
		JAXBBuilder builder = cityGMLCtx.createJAXBBuilder();
		
		System.out.println(df.format(new Date()) + "creating JAXB Unmarshaller instance");
		JAXBContext ctx = builder.getJAXBContext();		
		Unmarshaller unmarshaller = ctx.createUnmarshaller();
		Marshaller marshaller = ctx.createMarshaller();
		ObjectFactory jaxbGMLFactory = new ObjectFactory();
		
		JAXBMarshaller jaxbMarshaller = builder.createJAXBMarshaller(CityGMLVersion.v1_0_0);

		System.out.println(df.format(new Date()) + "unmarshalling CityGML file LOD2_Building_v100.xml to JAXB objects");
		JAXBElement<?> cityModelElem = (JAXBElement<?>)unmarshaller.unmarshal(new File("../../datasets/LOD2_Building_v100.xml"));

		System.out.println(df.format(new Date()) + "iterating through JAXB object tree searching for boundary surfaces");
		if (cityModelElem != null && cityModelElem.getValue() instanceof CityModelType) {
			CityModelType cityModelType = (CityModelType)cityModelElem.getValue();

			if (cityModelType.isSetFeatureMember()) {
				for (JAXBElement<? extends FeaturePropertyType> memberElem : cityModelType.getFeatureMember()) {
					if (memberElem.getValue() != null) {
						FeaturePropertyType memberType = memberElem.getValue();

						if (memberType.isSet_Feature()) {
							JAXBElement<? extends AbstractFeatureType> featureElem = memberType.get_Feature();
							if (featureElem.getValue() != null) {
								AbstractFeatureType featureType = featureElem.getValue();
								if (featureType instanceof BuildingType) {
									System.out.println("Found Building (CityGML version 1.0)");
									BuildingType buildingType = (BuildingType)featureType;

									if (buildingType.isSetBoundedBySurface()) {
										for (BoundarySurfacePropertyType boundedBy : buildingType.getBoundedBySurface()) {
											JAXBElement<?> boundarySurfaceElem = boundedBy.get_Object();
											if (boundarySurfaceElem.getValue() instanceof AbstractBoundarySurfaceType) {
												AbstractBoundarySurfaceType boundarySurfaceType = (AbstractBoundarySurfaceType)boundarySurfaceElem.getValue();
												System.out.println("  -- Found " + boundarySurfaceType);
												
												StringOrRefType description = jaxbGMLFactory.createStringOrRefType();
												description.setValue("processed by citygml4j using JAXB");												
												boundarySurfaceType.setDescription(description);
											}
										}
									}
								}
							}
						}
					}				
				}
			}
			
			System.out.println(df.format(new Date()) + "creating citygml4j CityFurniture object");
			CityFurniture cityFurniture = new CityFurniture();
			StringOrRef description = new StringOrRef();
			description.setValue("processed by citygml4j");
			cityFurniture.setDescription(description);
			CityObjectMember member = new CityObjectMember(cityFurniture);
			
			System.out.println(df.format(new Date()) + "unmarshalling citygml4j CityFurniture object to JAXB and inserting it into JAXB object tree");
			JAXBElement<? extends FeaturePropertyType> memberElem = (JAXBElement<? extends FeaturePropertyType>)jaxbMarshaller.marshalJAXBElement(member);
			cityModelType.getFeatureMember().add(memberElem);
		}		
		
		System.out.println(df.format(new Date()) + "marshalling JAXB object tree as CityGML 1.0.0 document");
		JAXBNamespacePrefixMapper nsMapper = new JAXBNamespacePrefixMapper(CityGMLVersion.v1_0_0);
		nsMapper.setNamespacePrefixMapping(CoreModule.v1_0_0.getNamespaceURI(), "");

		// customize Marshaller instance
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", nsMapper);
		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
				CoreModule.v1_0_0.getNamespaceURI() + " " + CoreModule.v1_0_0.getSchemaLocation() + " " +
				BuildingModule.v1_0_0.getNamespaceURI() + " " + BuildingModule.v1_0_0.getSchemaLocation() + " " +
				CityFurnitureModule.v1_0_0.getNamespaceURI() + " " + CityFurnitureModule.v1_0_0.getSchemaLocation());

		// marshal object tree to CityGML instance document
		marshaller.marshal(cityModelElem, new File("LOD2_JAXB_result_v100.xml"));
		
		System.out.println(df.format(new Date()) + "CityGML file LOD2_JAXB_result_v100.xml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
