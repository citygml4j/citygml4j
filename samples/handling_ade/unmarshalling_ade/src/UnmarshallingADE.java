import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.factory.GMLFactory;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.StringOrRef;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.visitor.walker.GMLWalker;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityModelWriter;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;

public class UnmarshallingADE {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_v100.xml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();		
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_SubsurfaceStructureADE_v100.xml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();

		System.out.println(df.format(new Date()) + "unmarshalling geometries of ADE features to citygml4j objects");
		SchemaHandler schemaHandler = in.getSchemaHandler();
		final JAXBUnmarshaller unmarshaller = builder.createJAXBUnmarshaller(schemaHandler);
		final JAXBMarshaller marshaller = builder.createJAXBMarshaller();
		final GMLFactory gml = new GMLFactory();
		
		GMLWalker walker = new GMLWalker(schemaHandler) {

			@Override
			public void accept(Element element, ElementDecl decl) {

				if (decl.isGeometry()) {
					System.out.print("  Processing geometry: ");
					
					AbstractGeometry geometry = (AbstractGeometry)unmarshaller.unmarshal(element);
					if (geometry != null) {
						System.out.println(geometry.getGMLClass());
						
						StringOrRef description = gml.createStringOrRef();
						description.setValue("processed by citygml4j");
						geometry.setDescription(description);
						
						Element processed = marshaller.marshalDOMElement(geometry, element.getOwnerDocument()); 
						element.getParentNode().replaceChild(processed, element);
					}
				} else {
					if (decl.isFeature())
						System.out.println("ADE feature: " + element.getLocalName());
					
					super.accept(element, decl);
				}
			}

		};

		cityModel.visit(walker);

		System.out.println(df.format(new Date()) + "writing processed citygml4j object tree");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v1_0_0);
		out.setSchemaHandler(schemaHandler);
		
		CityModelWriter writer = out.createCityModelWriter(new File("LOD2_SubsurfaceStructureADE_processed_v100.xml"));
		writer.setPrefixes(CityGMLVersion.v1_0_0);
		writer.setPrefix("sub", "http://www.citygml.org/ade/sub/0.9.0");
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocation("http://citygml.org/ade/sub/0.9.0", "../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd");
		writer.setIndentString("  ");

		writer.writeStartDocument();
		
		for (CityObjectMember member : cityModel.getCityObjectMember())
			if (member.isSetGenericADEComponent())
				writer.writeFeatureMember(member.getGenericADEComponent());
		
		writer.writeEndDocument();		
		writer.close();
		
		System.out.println(df.format(new Date()) + "ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_processed_v100.xml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
