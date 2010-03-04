import java.io.File;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.AbstractFeature;
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
		
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		CityGMLInputFactory in = builder.createCityGMLInputFactory(schemaHandler);
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER);

		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_SubsurfaceStructureADE_invalid_v100.xml"));

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
		
		CityModelWriter writer = out.createCityModelWriter(new File("LOD2_SubsurfaceStructureADE_invalid_v100.xml"));
		writer.setPrefixes(version);
		writer.setPrefix("sub", "http://www.citygml.org/ade/sub/0.9.0");
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocation("http://www.citygml.org/ade/sub/0.9.0", "../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd");
		writer.setIndentString("  ");
		
		System.out.println("Validating citygml4j in-memory object tree whilst writing to file...\n");
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
	}

}
