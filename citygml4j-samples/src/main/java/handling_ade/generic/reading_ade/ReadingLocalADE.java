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
package handling_ade.generic.reading_ade;

import com.sun.xml.xsom.XSType;
import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReadingLocalADE {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD0_Railway_NoiseADE_v200.gml");
		System.out.println(df.format(new Date()) + "ADE schema file is read from xsi:schemaLocation attribute on root XML element");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();

		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD0_Railway_NoiseADE_v200.gml"));
		CityGML citygml = reader.nextFeature();
		reader.close();

		System.out.println(df.format(new Date()) + "exploring ADE content of Railway element");
		CityModel cityModel = (CityModel)citygml;
		Railway railway = (Railway)cityModel.getCityObjectMember().get(0).getCityObject();
		
		if (railway.isSetGenericApplicationPropertyOfRailway()) {
			System.out.println("Found ADE content for Railway instance:\n");

			List<ADEComponent> ades = railway.getGenericApplicationPropertyOfRailway();
			for (ADEComponent ade : ades) {
				if (ade.getADEClass() == ADEClass.GENERIC_ELEMENT)
					checkADE(in.getSchemaHandler(), ((ADEGenericElement)ade).getContent(), null, 0);
			}
		}
		
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

	static void checkADE(SchemaHandler schemaHandler, Element element, ElementDecl parent, int level) {		
		System.out.print(indent(level) + element.getLocalName());

		Schema schema = schemaHandler.getSchema(element.getNamespaceURI());
		ElementDecl decl = null;

		if (schema != null) {
			decl = schema.getElementDecl(element.getLocalName(), parent);
			if (decl != null) {

				if (decl.isCityObject())
					System.out.print(" [CITYOBJECT]");
				else if (decl.isFeature())
					System.out.print(" [FEATURE]");
				else if (decl.isGeometry())
					System.out.print(" [GEOMETRY]");
				else if (decl.isFeatureProperty())
					System.out.print(" [FEATURE_PROPERTY]");
				else if (decl.isGeometryProperty())
					System.out.print(" [GEOMETRY_PROPERTY]");

				XSType type = decl.getXSElementDecl().getType();
				System.out.println(": " + type.getName() + "{" + type.getTargetNamespace() + "}");
			}
		}

		parent = decl;

		NodeList children = element.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (child.getNodeType() == Node.ELEMENT_NODE)
				checkADE(schemaHandler, (Element)child, parent, level + 1);	
		}

		if (element.getFirstChild().getNodeType() == Node.TEXT_NODE)
			System.out.println(indent(level) + "--> " + element.getFirstChild().getNodeValue());
	}

	static String indent(int level) {
		StringBuilder indent = new StringBuilder();		
		for (int i = 0; i < level; ++i)
			indent.append("    ");

		return indent.toString();
	}

}
