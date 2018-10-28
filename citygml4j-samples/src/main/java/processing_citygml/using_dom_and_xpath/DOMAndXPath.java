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
package processing_citygml.using_dom_and_xpath;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.xml.SAXWriter;
import org.citygml4j.xml.CityGMLNamespaceContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DOMAndXPath {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "creating citygml4j JAXBUnmarshaller and JAXBMarshaller instances");
		JAXBUnmarshaller unmarshaller = builder.createJAXBUnmarshaller();
		JAXBMarshaller marshaller = builder.createJAXBMarshaller();
		marshaller.setModuleContext(new ModuleContext(CityGMLVersion.v2_0_0));
		
		// create DOM model from CityGML document
		System.out.println(df.format(new Date()) + "reading CityGML file LOD2_Building_with_Placeholder_v200.gml as DOM tree");
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setNamespaceAware(true);		
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document document = docBuilder.parse("datasets/LOD2_Building_with_Placeholder_v200.gml");

		// create XPath factory
		System.out.println(df.format(new Date()) + "creating XPath factory");
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();

		// get CityGML namespace context
		CityGMLNamespaceContext nsContext = new CityGMLNamespaceContext();
		nsContext.setPrefixes(CityGMLVersion.v2_0_0);
		xpath.setNamespaceContext(nsContext);

		// first: retrieve building node using XPath
		System.out.println(df.format(new Date()) + "searching for bldg:Building node in DOM tree using an XPath expression");
		Node buildingNode = (Node)xpath.evaluate("//bldg:Building", document, XPathConstants.NODE);

		// unmarshal DOM node to citygml4j
		System.out.println(df.format(new Date()) + "unmarshalling DOM node to citygml4j");
		Building building = (Building)unmarshaller.unmarshal(buildingNode);

		// add gml:id and gml:description to building
		System.out.println(df.format(new Date()) + "processing content using citygml4j");
		building.setId(DefaultGMLIdManager.getInstance().generateUUID());
		StringOrRef description = new StringOrRef();
		description.setValue("processed by citygml4j using DOM and XPath");
		building.setDescription(description);

		// marshal to DOM and put into document
		System.out.println(df.format(new Date()) + "marshalling back to DOM");
		Element newBuildingNode = marshaller.marshalDOMElement(building, document);
		buildingNode.getParentNode().replaceChild(newBuildingNode, buildingNode);
		
		// second: get placeholder using XPath
		System.out.println(df.format(new Date()) + "searching for 'Placeholder' in DOM tree using an XPath expression");
		Node memberNode = (Node)xpath.evaluate("//core:cityObjectMember[comment()='Placeholder']", document, XPathConstants.NODE);

		// create simple citygml4j object to insert into placeholder
		System.out.println(df.format(new Date()) + "inserting CityFurniture instance at placeholder using citygml4j");
		CityFurniture cityFurniture = new CityFurniture();
		cityFurniture.setDescription(description);		
		CityObjectMember member = new CityObjectMember(cityFurniture);

		// marshal to DOM and put into document
		System.out.println(df.format(new Date()) + "marshalling back to DOM");
		Element newMemberNode = marshaller.marshalDOMElement(member, document);
		memberNode.getParentNode().replaceChild(newMemberNode, memberNode);
		
		// write DOM to file
		System.out.println(df.format(new Date()) + "writing DOM tree");
		Files.createDirectories(Paths.get("output"));

		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer trans = transFactory.newTransformer();
		DOMSource source = new DOMSource(document);

		try (SAXWriter saxWriter = new SAXWriter(new FileOutputStream("output/LOD2_DOM_result_v200.gml"), "UTF-8")) {
			saxWriter.setIndentString("  ");
			saxWriter.setNamespaceContext(nsContext);
			trans.transform(source, new SAXResult(saxWriter));
		}

		System.out.println(df.format(new Date()) + "CityGML file LOD2_DOM_result_v200.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
