import java.io.File;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;

public class SimpleReader {

	public static void main(String[] args) throws Exception {
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();
		
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_Buildings_v100.xml"));
		
		while (reader.hasNextFeature()) {
			CityGML citygml = reader.nextFeature();
			
			System.out.println("Found " + citygml.getCityGMLClass() + 
					" version " + citygml.getCityGMLModule().getVersion());
			
			if (citygml.getCityGMLClass() == CityGMLClass.CITYMODEL) {
				CityModel cityModel = (CityModel)citygml;

				int count = 0;
				for (CityObjectMember cityObjectMember : cityModel.getCityObjectMember()) {
					CityObject cityObject = cityObjectMember.getCityObject();
					if (cityObject.getCityGMLClass() == CityGMLClass.BUILDING)
						count++;
				}

				System.out.println("The city model contains " + count + " building features");
			}	
		}			
		
		reader.close();
	}

}
