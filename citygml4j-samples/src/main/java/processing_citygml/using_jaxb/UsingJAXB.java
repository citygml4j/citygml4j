/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package processing_citygml.using_jaxb;

import net.opengis.citygml._1.CityModelType;
import net.opengis.citygml.building._1.AbstractBoundarySurfaceType;
import net.opengis.citygml.building._1.BoundarySurfacePropertyType;
import net.opengis.citygml.building._1.BuildingType;
import net.opengis.gml.AbstractFeatureType;
import net.opengis.gml.FeaturePropertyType;
import net.opengis.gml.ObjectFactory;
import net.opengis.gml.StringOrRefType;
import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.model.module.citygml.CityFurnitureModule;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsingJAXB {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext cityGMLCtx = CityGMLContext.getInstance();
		CityGMLBuilder builder = cityGMLCtx.createCityGMLBuilder();
		
		System.out.println(df.format(new Date()) + "creating JAXB Unmarshaller instance");
		JAXBContext ctx = builder.getJAXBContext();		
		Unmarshaller unmarshaller = ctx.createUnmarshaller();
		Marshaller marshaller = ctx.createMarshaller();
		ObjectFactory jaxbGMLFactory = new ObjectFactory();
		
		JAXBMarshaller jaxbMarshaller = builder.createJAXBMarshaller(CityGMLVersion.v1_0_0);

		System.out.println(df.format(new Date()) + "unmarshalling CityGML file LOD2_Building_v100.gml to JAXB objects");
		JAXBElement<?> cityModelElem = (JAXBElement<?>)unmarshaller.unmarshal(new File("datasets/LOD2_Building_v100.gml"));

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
		Files.createDirectory(Paths.get("output"));

		// customize Marshaller instance
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
				CoreModule.v1_0_0.getNamespaceURI() + " " + CoreModule.v1_0_0.getSchemaLocation() + " " +
				BuildingModule.v1_0_0.getNamespaceURI() + " " + BuildingModule.v1_0_0.getSchemaLocation() + " " +
				CityFurnitureModule.v1_0_0.getNamespaceURI() + " " + CityFurnitureModule.v1_0_0.getSchemaLocation());

		// marshal object tree to CityGML instance document
		marshaller.marshal(cityModelElem, new File("output/LOD2_JAXB_result_v100.gml"));
		
		System.out.println(df.format(new Date()) + "CityGML file LOD2_JAXB_result_v100.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
