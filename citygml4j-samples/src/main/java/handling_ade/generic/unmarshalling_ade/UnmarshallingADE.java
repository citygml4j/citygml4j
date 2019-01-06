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
package handling_ade.generic.unmarshalling_ade;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.util.walker.GMLWalker;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.citygml4j.xml.io.writer.CityModelWriter;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UnmarshallingADE {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_v100.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();		
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_SubsurfaceStructureADE_v100.gml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();

		System.out.println(df.format(new Date()) + "unmarshalling geometries of ADE features to citygml4j objects");
		SchemaHandler schemaHandler = in.getSchemaHandler();
		final JAXBUnmarshaller unmarshaller = builder.createJAXBUnmarshaller(schemaHandler);
		final JAXBMarshaller marshaller = builder.createJAXBMarshaller();

		GMLWalker walker = new GMLWalker() {

			@Override
			public void visit(Element element, ElementDecl decl) {

				if (decl.isGeometry()) {
					System.out.print("  Processing geometry: ");

					try {
						AbstractGeometry geometry = (AbstractGeometry)unmarshaller.unmarshal(element);
						if (geometry != null) {
							System.out.println(geometry.getGMLClass());

							StringOrRef description = new StringOrRef();
							description.setValue("processed by citygml4j");
							geometry.setDescription(description);

							Element processed = marshaller.marshalDOMElement(geometry, element.getOwnerDocument()); 
							element.getParentNode().replaceChild(processed, element);
						}
					} catch (MissingADESchemaException e) {
						//
					}

				} else {
					if (decl.isFeature())
						System.out.println("ADE feature: " + element.getLocalName());

					super.visit(element, decl);
				}
			}

		};
		
		walker.setSchemaHandler(schemaHandler);
		cityModel.accept(walker);

		System.out.println(df.format(new Date()) + "writing processed citygml4j object tree");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v1_0_0);
		out.setSchemaHandler(schemaHandler);

		CityModelWriter writer = out.createCityModelWriter(new File("output/LOD2_SubsurfaceStructureADE_processed_v100.gml"));
		writer.setPrefixes(CityGMLVersion.v1_0_0);
		writer.setPrefix("sub", "http://www.citygml.org/ade/sub/0.9.0");
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocation("http://citygml.org/ade/sub/0.9.0", "../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd");
		writer.setIndentString("  ");

		writer.writeStartDocument();

		for (CityObjectMember member : cityModel.getCityObjectMember())
			if (member.isSetGenericADEElement())
				writer.writeFeatureMember(member.getGenericADEElement());

		writer.writeEndDocument();		
		writer.close();

		System.out.println(df.format(new Date()) + "ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_processed_v100.xml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
