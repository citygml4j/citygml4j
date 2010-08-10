import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.visitor.walker.FeatureWalker;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityGMLWriter;

public class Converter {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 
		
		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();
		
		System.out.println(df.format(new Date()) + "reading CityGML 1.0.0 file LOD2_Buildings_v100.xml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("../datasets/LOD2_Buildings_v100.xml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		System.out.println(df.format(new Date()) + "features and their CityGML version contained in the document:");
		FeatureWalker walker = new FeatureWalker() {

			@Override
			public void accept(AbstractFeature abstractFeature) {
				if (abstractFeature instanceof CityGML) {
					CityGML cityGML = (CityGML)abstractFeature;
					System.out.println("Original CityGML version of " + cityGML.getCityGMLClass() + " instance: "+
							cityGML.getCityGMLModule().getVersion());
				}
				
				super.accept(abstractFeature);
			}
			
		};
		
		cityModel.visit(walker);
		
		System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityGML 0.4.0 document");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory();
		out.setCityGMLVersion(CityGMLVersion.v0_4_0);
		
		CityGMLWriter writer = out.createCityGMLWriter(new File("LOD2_Buildings_v040.xml"));
		writer.setPrefixes(CityGMLVersion.v0_4_0);
		writer.setDefaultNamespace(CoreModule.v0_4_0);
		writer.setSchemaLocations(CityGMLVersion.v0_4_0);
		writer.setIndentString("  ");
		
		writer.write(cityModel);
		writer.close();
		
		System.out.println(df.format(new Date()) + "CityGML file LOD2_Buildings_v040.xml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
