import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.commons.gmlid.DefaultGMLIdManager;
import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.factory.GMLFactory;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.gml.StringOrRef;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.CityGMLNamespaceContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class DOMAndXPath {

	public static void main(String[] args) throws Exception {
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		CityGMLFactory citygml = new CityGMLFactory();
		GMLFactory gml = new GMLFactory();
		
		JAXBUnmarshaller unmarshaller = builder.createJAXBUnmarshaller();
		JAXBMarshaller marshaller = builder.createJAXBMarshaller();
		marshaller.setModuleContext(new ModuleContext(CityGMLVersion.v1_0_0));
		
		// create DOM model from CityGML document
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setNamespaceAware(true);		
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document document = docBuilder.parse("../../datasets/LOD2_Building_with_Placeholder_v100.xml");

		// create XPath factory
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();

		// get CityGML namespace context
		CityGMLNamespaceContext nsContext = new CityGMLNamespaceContext();
		nsContext.setPrefixes(CityGMLVersion.v1_0_0);
		xpath.setNamespaceContext(nsContext);

		// first: retrieve building node using XPath
		Node buildingNode = (Node)xpath.evaluate("//bldg:Building", document, XPathConstants.NODE);

		// unmarshal DOM node to citygml4j
		Building building = (Building)unmarshaller.unmarshal(buildingNode);

		// add gml:id and gml:description to building
		building.setId(DefaultGMLIdManager.getInstance().generateGmlId());
		StringOrRef description = gml.createStringOrRef();
		description.setValue("processed by citygml4j using DOM and XPath");
		building.setDescription(description);

		// marshal to DOM and put into document
		Element newBuildingNode = marshaller.marshalDOMElement(building, document);
		buildingNode.getParentNode().replaceChild(newBuildingNode, buildingNode);
		
		// second: get placeholder using XPath
		Node memberNode = (Node)xpath.evaluate("//core:cityObjectMember[comment()='Placeholder']", document, XPathConstants.NODE);

		// create simple citygml4j object to insert into placeholder
		CityFurniture cityFurniture = citygml.createCityFurniture();
		cityFurniture.setDescription(description);		
		CityObjectMember member = citygml.createCityObjectMember(cityFurniture);

		// marshal to DOM and put into document
		Element newMemberNode = marshaller.marshalDOMElement(member, document);
		memberNode.getParentNode().replaceChild(newMemberNode, memberNode);
		
		// write DOM to file
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer trans = transFactory.newTransformer();		
		trans.setOutputProperty(OutputKeys.INDENT, "yes");

		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new FileOutputStream("LOD2_DOM_result_v100.xml"));
		trans.transform(source, result); 
	}

}
