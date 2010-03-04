import java.io.File;
import java.util.List;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
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

import com.sun.xml.xsom.XSType;


public class ReadingRemoteADE {
	
	public static void main(String[] args) throws Exception {
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		CityGMLInputFactory in = builder.createCityGMLInputFactory();

		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD0_Railway_NoiseADE_from_Web_v100.xml"));
		CityGML citygml = reader.nextFeature();
		reader.close();

		CityModel cityModel = (CityModel)citygml;
		Railway railway = (Railway)cityModel.getCityObjectMember().get(0).getCityObject();
		
		SchemaHandler schemaHandler = in.getSchemaHandler();
		
		if (railway.isSetGenericApplicationPropertyOfRailway()) {
			System.out.println("Found ADE content for Railway instance:\n");

			List<ADEComponent> ades = railway.getGenericApplicationPropertyOfRailway();
			for (ADEComponent ade : ades)
				checkADE(schemaHandler, ade.getContent(), null, 0);
		}
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
