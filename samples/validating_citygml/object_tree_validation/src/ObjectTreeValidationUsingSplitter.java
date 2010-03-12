import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.util.transform.FeatureSplitMode;
import org.citygml4j.util.transform.FeatureSplitter;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.schema.SchemaHandler;
import org.citygml4j.xml.validation.Validator;
import org.w3c.dom.Element;


public class ObjectTreeValidationUsingSplitter {

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
		
		System.out.println(df.format(new Date()) + "parsing ADE schema file CityGML-SubsurfaceADE-0_9_0.xsd");
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_invalid_v100.xml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory(schemaHandler);
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.NO_SPLIT);

		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_SubsurfaceStructureADE_invalid_v100.xml"));
		CityGML citygml = reader.nextFeature();		
		reader.close();
		
		System.out.println(df.format(new Date()) + "creating citygml4j Validator");
		Validator validator = builder.createValidator(schemaHandler);		
		validator.setValidationEventHandler(new ValidationEventHandler() {
			public boolean handleEvent(ValidationEvent event) {
				System.out.println("\t" + event.getMessage());
				return true;
			}
		});
		
		System.out.println(df.format(new Date()) + "creating citygml4j FeatureSplitter and splitting document into single features");
		FeatureSplitter splitter = new FeatureSplitter(schemaHandler);
		splitter.setSplitMode(FeatureSplitMode.SPLIT_PER_FEATURE);
		splitter.setSplitCopy(true);
		
		System.out.println(df.format(new Date()) + "iterating over splitting result and validating features against CityGML 1.0.0");
		for (CityGML feature : splitter.split(citygml)) {
			
			String type = null;
			if (feature instanceof ADEComponent){
				Element element = ((ADEComponent)feature).getContent();
				type = element.getPrefix() + ':' + element.getLocalName();
			} else
				type = feature.getCityGMLClass().toString();
			
			System.out.println("Validating " + type);
			validator.validate(feature, CityGMLVersion.v1_0_0);
		}
		
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
	
}
