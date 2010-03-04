import java.io.File;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;


public class ValidatingChunkReader {

	public static void main(String[] args) throws Exception {
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();
		
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		CityGMLInputFactory in = builder.createCityGMLInputFactory(schemaHandler);
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_FEATURE);
		in.setProperty(CityGMLInputFactory.USE_VALIDATION, true);
			
		ValidationEventHandlerImpl validationEventHandler = new ValidationEventHandlerImpl();
		in.setValidationEventHandler(validationEventHandler);
		
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_SubsurfaceStructureADE_invalid_v100.xml"));
		
		while (reader.hasNextFeature()) {
			CityGML chunk = reader.nextFeature();			

			String type = null;
			if (chunk instanceof ADEComponent){
				Element element = ((ADEComponent)chunk).getContent();
				type = element.getPrefix() + ':' + element.getLocalName();
			} else
				type = chunk.getCityGMLClass().toString();
			
			System.out.print(type + ": ");
			System.out.println(validationEventHandler.isValid ? "valid" : "invalid (see error messages above)");

			validationEventHandler.isValid = true;
		}

		reader.close();
	}

	private static final class ValidationEventHandlerImpl implements ValidationEventHandler {
		boolean isValid = true;		
		
		public boolean handleEvent(ValidationEvent event) {
			System.out.print("\t[" + event.getLocator().getLineNumber() + "," + event.getLocator().getColumnNumber() + "] ");
			System.out.println(event.getMessage());
			isValid = false;
			return true;
		}
	}
}
