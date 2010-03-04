import java.io.File;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.commons.gmlid.DefaultGMLIdManager;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLModuleType;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.AbstractCityGMLWriter;
import org.citygml4j.xml.io.writer.CityGMLWriter;
import org.citygml4j.xml.io.writer.FeatureWriteMode;
import org.citygml4j.xml.schema.SchemaHandler;


public class WritingCityGML {

	public static void main(String[] args) throws Exception {
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();
		
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-NoiseADE-0-5-0.xsd"));
		
		CityGMLInputFactory in = builder.createCityGMLInputFactory(schemaHandler);
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD0_Railway_NoiseADE_v100.xml"));
		
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(schemaHandler);
		ModuleContext moduleContext = new ModuleContext(CityGMLVersion.v1_0_0);
		
		FeatureWriteMode writeMode = FeatureWriteMode.SPLIT_PER_COLLECTION_MEMBER;
		boolean splitOnCopy = false;
		
		out.setModuleContext(moduleContext);
		out.setGMLIdManager(DefaultGMLIdManager.getInstance());
		out.setProperty(CityGMLOutputFactory.FEATURE_WRITE_MODE, writeMode);		
		out.setProperty(CityGMLOutputFactory.SPLIT_COPY, splitOnCopy);
		
		//out.setProperty(CityGMLOutputFactory.EXCLUDE_FROM_SPLITTING, ADEComponent.class);
		
		CityGMLWriter writer = out.createCityGMLWriter(new File("LOD0_Railway_NoiseADE_split_v100.xml"), "utf-8");
		setContext(writer, moduleContext, writeMode, splitOnCopy);
		
		writer.write(cityModel);
		writer.close();
		
		writer = out.createCityGMLWriter(new File("LOD0_Railway_NoiseADE_orig_v100.xml"), "utf-8");
		setContext(writer, moduleContext, writeMode, splitOnCopy);
		
		writer.write(cityModel);
		writer.close();
	}
	
	private static void setContext(AbstractCityGMLWriter writer, 
			ModuleContext moduleContext, 
			FeatureWriteMode writeMode,
			boolean splitOnCopy) {
		writer.setPrefixes(moduleContext);
		writer.setPrefix("noise", "http://www.citygml.org/ade/noise_de");
		writer.setDefaultNamespace(moduleContext.getModule(CityGMLModuleType.CORE));
		writer.setSchemaLocation("http://www.citygml.org/ade/noise_de", "../../datasets/schemas/CityGML-NoiseADE-0-5-0.xsd");
		writer.setIndentString("  ");
		writer.setHeaderComment("written by citygml4j", 
				"using a CityGMLWriter instance", 
				"Split mode: " + writeMode, 
				"Split on copy: " + splitOnCopy);
	}

}
