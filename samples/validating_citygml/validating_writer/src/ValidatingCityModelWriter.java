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

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.writer.CityModelWriter;
import org.citygml4j.xml.io.writer.FeatureWriteMode;
import org.citygml4j.xml.schema.SchemaHandler;


public class ValidatingCityModelWriter {

	public static void main(String[] args) throws Exception {
		/*
		 * PLEASE NOTE, that you receive less errors if the the in-memory objects
		 * derived from the input document are validated than if the input document
		 * itself is validated.
		 * reason: citygml4j tries to reconstruct a valid object tree from the
		 * input document. Generally, this means
		 * 1) Invalid order of XML elements will be corrected automatically (see ADDRESS element)
		 * 2) Invalid text values of XML elements cannot be automatically corrected
		 *    and thus will be reported (see, e.g., gml:id of BUILDING element)
		 * 3) Invalid XML child elements will be omitted in the object tree (see CLOSURESURFACE element)
		 * 
		 * Due to 3) you should always make sure to generate object trees from 
		 * valid CityGML documents!
		 */
		
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		System.out.println(df.format(new Date()) + "creating SchemaHandler and parsing ADE schema file CityGML-SubsurfaceADE-0_9_0.xsd");		
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_invalid_v100.xml chunk-wise");
		CityGMLInputFactory in = builder.createCityGMLInputFactory(schemaHandler);
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER);

		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_SubsurfaceStructureADE_invalid_v100.xml"));

		System.out.println(df.format(new Date()) + "creating validating CityGML 1.0.0 chunk-writer");
		CityGMLVersion version = CityGMLVersion.v1_0_0;
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(version, schemaHandler);
		out.setProperty(CityGMLOutputFactory.FEATURE_WRITE_MODE, FeatureWriteMode.SPLIT_PER_COLLECTION_MEMBER);
		
		out.setProperty(CityGMLOutputFactory.USE_VALIDATION, true);
		out.setValidationEventHandler(new ValidationEventHandler() {
			public boolean handleEvent(ValidationEvent event) {
				System.out.println(event.getMessage());
				return true;
			}
		});		
		
		System.out.println(df.format(new Date()) + "validating citygml4j in-memory object tree whilst writing to file");
		CityModelWriter writer = out.createCityModelWriter(new File("LOD2_SubsurfaceStructureADE_invalid_v100.xml"));
		writer.setPrefixes(version);
		writer.setPrefix("sub", "http://www.citygml.org/ade/sub/0.9.0");
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocation("http://www.citygml.org/ade/sub/0.9.0", "../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd");
		writer.setIndentString("  ");
		
		writer.writeStartDocument();
		
		while (reader.hasNextFeature()) {
			CityGML citygml = reader.nextFeature();
			
			if (citygml instanceof ADEComponent)
				writer.writeFeatureMember((ADEComponent)citygml);
			else 
				writer.writeFeatureMember((AbstractFeature)citygml);
		}
		
		writer.writeEndDocument();
		
		reader.close();
		writer.close();

		System.out.println(df.format(new Date()) + "CityGML file LOD2_SubsurfaceStructureADE_invalid_v100.xml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
