import java.io.File;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.schema.SchemaHandler;

public class ValidatingSimpleReader {

	public static void main(String[] args) throws Exception {
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();
		
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		CityGMLInputFactory in = builder.createCityGMLInputFactory(schemaHandler);
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.NO_SPLIT);
		
		in.setProperty(CityGMLInputFactory.USE_VALIDATION, true);	
		in.setValidationEventHandler(new ValidationEventHandler() {
			public boolean handleEvent(ValidationEvent event) {
				System.out.print("[" + event.getLocator().getLineNumber() + "," + event.getLocator().getColumnNumber() + "] ");
				System.out.println(event.getMessage());
				return true;
			}
		});
		
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_SubsurfaceStructureADE_invalid_v100.xml"));
		
		System.out.println("Reading and validating CityGML instance document...\n");
		
		CityGML citygml = reader.nextFeature();

		System.out.println("\n" + citygml.getCityGMLClass() + " read. See validation error messages above.");
		reader.close();
	}

}
