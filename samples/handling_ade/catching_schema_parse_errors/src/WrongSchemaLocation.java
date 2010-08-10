import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.schema.SchemaHandler;

import util.SchemaEntityResolver;
import util.SchemaParseErrorHandler;


public class WrongSchemaLocation {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		System.out.println(df.format(new Date()) + "setting up schema handler");
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.setSchemaEntityResolver(new SchemaEntityResolver());
		schemaHandler.setErrorHandler(new SchemaParseErrorHandler());
		
		// register false schema location in order to provoke a schema parse error
		schemaHandler.registerSchemaLocation("http://www.citygml.org/ade/noise_de", 
				new File("/nowhere/nofile.xsd"));

		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD0_Railway_NoiseADE_v100.xml");
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
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
