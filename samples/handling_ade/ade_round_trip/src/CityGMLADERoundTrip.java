import java.io.File;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityGMLWriter;
import org.citygml4j.xml.schema.SchemaHandler;

public class CityGMLADERoundTrip {

	public static void main(String[] args) throws Exception {
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();
		
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-NoiseADE-0-5-0.xsd"));
		
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setSchemaHandler(schemaHandler);
		
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD0_Railway_NoiseADE_v100.xml"));
		CityGML citygml = reader.nextFeature();
		reader.close();
		
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v1_0_0);
		
		CityGMLWriter writer = out.createCityGMLWriter(new File("LOD0_Railway_NoiseADE_v100.xml"), "ISO-8859-15");
		writer.setPrefixes(CityGMLVersion.v1_0_0);
		writer.setPrefix("noise", "http://www.citygml.org/ade/noise_de");
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocation("http://www.citygml.org/ade/noise_de", "../../datasets/schemas/CityGML-NoiseADE-0-5-0.xsd");
		writer.setIndentString("  ");
		
		writer.write((AbstractFeature)citygml);
		writer.close();
	}
	
}
