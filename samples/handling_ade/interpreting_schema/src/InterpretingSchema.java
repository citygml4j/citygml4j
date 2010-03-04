import java.io.File;
import java.io.PrintWriter;

import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;

public class InterpretingSchema {

	public static void main(String[] args) throws Exception {
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		// com.sun.xml.xsom.impl.util.SchemaWriter
		
		// As the documentation of SchemaWriter says, SchemaWriter
		// is not intended to be a fully-fledged round-trippable schema writer.
		SchemaWriter writer = new SchemaWriter(new PrintWriter(new File("CityGML-SubsurfaceADE-0_9_0.xml")));
		Schema schema = schemaHandler.getSchema("http://www.citygml.org/ade/sub/0.9.0");
		writer.schema(schema.getXSSchema());
	}

}
