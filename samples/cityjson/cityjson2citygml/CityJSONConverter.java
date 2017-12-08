package cityjson.cityjson2citygml;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.cityjson.CityJSONBuilder;
import org.citygml4j.builder.cityjson.json.io.reader.CityJSONInputFactory;
import org.citygml4j.builder.cityjson.json.io.reader.CityJSONReader;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriter;

import cityjson.cityjson2citygml.util.SimpleTextureFileHandler;

public class CityJSONConverter {

	public static void main(String[] args) throws Exception {
		final SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityJSON builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityJSONBuilder builder = ctx.createCityJSONBuilder();

		// reading CityJSON dataset
		System.out.println(df.format(new Date()) + "reading LOD3_Railway.json into main memory");
		CityJSONInputFactory in = builder.createCityJSONInputFactory();

		/**
		 * we can use different helpers on the CityJSON output factory such as builders
		 * for the "vertices" and "vertices-texture" arrays. Especially when converting
		 * an existing CityGML dataset, it is recommended that you provide your own 
		 * texture file handler.
		 * A texture file handler is invoked for every texture image found in the CityGML
		 * data. Its task is to generate a filename for the "image" property of a CityJSON
		 * texture object and to possibly copy the image file to the "appearances" folder.
		 * If you do not provide your own texture file handler, a default one will be used
		 * which only adapts the file name for the CityJSON file. 
		 */

		SimpleTextureFileHandler textureFileHandler = new SimpleTextureFileHandler(Paths.get("../../datasets/appearances"), Paths.get("appearance"));
		in.setProperty(CityJSONInputFactory.TEXTURE_FILE_HANDLER, textureFileHandler);

		CityJSONReader reader = in.createCityJSONReader(new File("../../datasets/LOD3_Railway.json"));

		CityModel cityModel = reader.read();
		reader.close();

		// create a CityGML builder 
		System.out.println(df.format(new Date()) + "creating CityJSON builder");
		CityGMLBuilder cityGMLBuilder = ctx.createCityGMLBuilder();

		// create a CityGML output factory
		System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityGML v2.0 file");
		CityGMLOutputFactory out = cityGMLBuilder.createCityGMLOutputFactory();

		CityGMLWriter writer = out.createCityGMLWriter(new File("LOD3_Railway_v200.gml"));
		writer.setIndentString("  ");
		writer.setPrefixes(CityGMLVersion.v2_0_0);
		writer.setDefaultNamespace(CoreModule.v2_0_0);
		writer.setSchemaLocations(CityGMLVersion.v2_0_0);

		writer.write(cityModel);
		writer.close();

		System.out.println(df.format(new Date()) + "CityGML file LOD3_Railway_v200.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
