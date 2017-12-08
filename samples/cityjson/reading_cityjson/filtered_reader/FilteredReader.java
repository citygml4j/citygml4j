package cityjson.reading_cityjson.filtered_reader;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.binding.cityjson.feature.CityObjectTypeFilter;
import org.citygml4j.binding.cityjson.feature.CityObjectTypeName;
import org.citygml4j.builder.cityjson.CityJSONBuilder;
import org.citygml4j.builder.cityjson.json.io.reader.CityJSONInputFactory;
import org.citygml4j.builder.cityjson.json.io.reader.CityJSONReader;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.LodRepresentation;

public class FilteredReader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityJSON builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityJSONBuilder builder = ctx.createCityJSONBuilder();

		System.out.println(df.format(new Date()) + "reading only city furniture objects from CityJSON file LOD3_Railway.json");
		CityJSONInputFactory in = builder.createCityJSONInputFactory();

		CityJSONReader reader = in.createCityJSONReader(new File("../../../datasets/LOD3_Railway.json"));
		reader = in.createFilteredCityJSONReader(reader, new CityObjectTypeFilter() {

			// return true if you want to consume the CityJSON feature
			// of the given "type" 
			public boolean accept(String type) {
				// CityObjectTypeName is an enum of the predefined "type" values in CityJSON
				// but any other String can be used as well
				return type.equals(CityObjectTypeName.CITY_FURNITURE.getValue());
			}
		});

		CityModel cityModel = reader.read();
		reader.close();
		
		// iterate over all city objects of the city model
		for (CityObjectMember member : cityModel.getCityObjectMember()) {
			if (member.isSetCityObject()) {
				AbstractCityObject cityObject = member.getCityObject();
				System.out.println("Found " + cityObject.getCityGMLClass() + " feature");
				System.out.println("\tgml:id '" + cityObject.getId() + "'");
				
				// check and print LoD geometries
				LodRepresentation lods = cityObject.getLodRepresentation();
				for (int lod = 0; lod < 5; lod++) {
					if (lods.isSetGeometry(lod))
						System.out.println("\thas LoD " + lod + " geometry");
				}
			}
		}
		
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
