package cityjson.citygml2cityjson;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.cityjson.CityJSONBuilder;
import org.citygml4j.builder.cityjson.json.io.writer.CityJSONOutputFactory;
import org.citygml4j.builder.cityjson.json.io.writer.CityJSONWriter;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;

import cityjson.citygml2cityjson.util.SimpleTextureFileHandler;

public class SimpleConverter {

	public static void main(String[] args) throws Exception {
		final SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 
		
		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		// reading CityGML dataset
		System.out.println(df.format(new Date()) + "reading LOD3_Building_v200.gml into main memory");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD3_Building_v200.gml"));
		
		// we know that the root element is a <core:CityModel> so we use a shortcut here
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		// create a CityJSON builder 
		System.out.println(df.format(new Date()) + "creating CityJSON builder");
		CityJSONBuilder jsonBuilder = ctx.createCityJSONBuilder();
		
		// create a CityJSON output factory
		System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityJSON file");
		CityJSONOutputFactory out = jsonBuilder.createCityJSONOutputFactory();		

		/**
		 * we can use different helpers on the CityJSON output factory such as builders
		 * for the "vertices" and "vertices-texture" arrays. Especially when converting
		 * an existing CityGML dataset, it is recommended that you provide your own 
		 * texture file handler.
		 * A texture file handler is invoked for every texture image found in the CityGML
		 * data. Its task is to generate a filename for the "image" property of a CityJSON
		 * texture object and to possibly copy the image file to the "appearances" folder.
		 */
		
		SimpleTextureFileHandler textureFileHandler = new SimpleTextureFileHandler(Paths.get("../../datasets"), Paths.get("appearances"));
		out.setProperty(CityJSONOutputFactory.TEXTURE_FILE_HANDLER, textureFileHandler);
		
		// create a simple CityJSON writer
		CityJSONWriter writer = out.createCityJSONWriter(new File("LOD3_Building_v200.json"));
		writer.write(cityModel);
		writer.close();
		
		System.out.println(df.format(new Date()) + "CityJSON file LOD3_Building_v200.json written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
