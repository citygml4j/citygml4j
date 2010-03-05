import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;

public class InterpretingSchema {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "parsing ADE schema file CityGML-SubsurfaceADE-0_9_0.xsd");
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		// using com.sun.xml.xsom.impl.util.SchemaWriter		
		// as the documentation of SchemaWriter says, SchemaWriter is not intended 
		// to be a fully-fledged round-trippable schema writer.
		System.out.println(df.format(new Date()) + "creating SchemaWriter instance to interpret ADE schema");
		SchemaWriter writer = new SchemaWriter(new PrintWriter(new File("CityGML-SubsurfaceADE-0_9_0.xml")));
		Schema schema = schemaHandler.getSchema("http://www.citygml.org/ade/sub/0.9.0");

		System.out.println(df.format(new Date()) + "writing ADE schema file CityGML-SubsurfaceADE-0_9_0.xsd");
		writer.schema(schema.getXSSchema());
		
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
