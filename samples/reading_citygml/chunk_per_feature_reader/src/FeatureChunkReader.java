import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.building.AbstractOpening;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.reader.ParentInfo;

public class FeatureChunkReader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();
		
		System.out.println(df.format(new Date()) + "reading CityGML file LOD3_Building_v100.xml feature by feature");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_FEATURE);
		in.setProperty(CityGMLInputFactory.EXCLUDE_FROM_SPLITTING, new Class[]{AbstractOpening.class, Address.class});

		// see difference when setting to true
		in.setProperty(CityGMLInputFactory.KEEP_INLINE_APPEARANCE, false);
		
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD3_Building_v100.xml"));
		
		System.out.println(df.format(new Date()) + "printing feature currently read and its (transitive) parents");
		while (reader.hasNextFeature()) {
			CityGML chunk = reader.nextFeature();	
			System.out.println("found: " + chunk.getCityGMLClass());
			
			if (reader.isSetParentInfo()) {
				ParentInfo parentInfo = reader.getParentInfo();
				System.out.println(" --parent: " + parentInfo.getCityGMLClass());
				
				while ((parentInfo = parentInfo.getParentInfo()) != null)
					System.out.println(" --transitive parent: " + parentInfo.getCityGMLClass());
			}
			
		}

		reader.close();
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
	
}
