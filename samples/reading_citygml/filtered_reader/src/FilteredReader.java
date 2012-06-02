import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLInputFilter;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;


public class FilteredReader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading only roads from CityGML file LOD2_CityObjectGroup_v100.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_FEATURE);

		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_CityObjectGroup_v100.gml"));
		reader = in.createFilteredCityGMLReader(reader, new CityGMLInputFilter() {

			// return true if you want to consume the CityGML feature
			// of the given CityGMLClass type, false otherwise
			public boolean accept(CityGMLClass type) {
				return type == CityGMLClass.ROAD;
			}
			
		});

		System.out.println(df.format(new Date()) + "printing road features");
		while (reader.hasNext()) {
			Road road = (Road)reader.nextFeature();
			System.out.println(df.format(new Date()) + "found Road with gml:id " + road.getId());	
			
			System.out.println(df.format(new Date()) + "\t" + road.getTrafficArea().size() + " traffic area(s)");	
			System.out.println(df.format(new Date()) + "\t" + road.getAuxiliaryTrafficArea().size() + " auxiliary traffic area(s)");	
		}

		reader.close();
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
