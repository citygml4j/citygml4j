import java.io.File;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.schema.SchemaHandler;


public class CatchingSchemaParseErrors {

	public static void main(String[] args) throws Exception {
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.setSchemaEntityResolver(new SchemaEntityResolver());
		schemaHandler.setErrorHandler(new SchemaParseErrorHandler());
		
		schemaHandler.registerSchemaLocation("http://www.citygml.org/ade/noise_de", 
				new File("/nowhere/nofile.xsd"));

		CityGMLInputFactory in = builder.createCityGMLInputFactory(schemaHandler);
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_FEATURE);

		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD0_Railway_NoiseADE_v100.xml"));
		
		while (reader.hasNextFeature()) {
			CityGML citygml = reader.nextFeature();
			
			if (citygml instanceof AbstractFeature)
				System.out.println("Found CityGML: " + citygml.getCityGMLClass());
			else 
				System.out.println("Found ADE: " + ((ADEComponent)citygml).getContent().getLocalName());
		}
		
		reader.close();
	}

}
