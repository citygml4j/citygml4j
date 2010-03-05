import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLModuleType;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityModelInfo;
import org.citygml4j.xml.io.writer.CityModelWriter;


public class MixedVersionsWriter {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		System.out.println(df.format(new Date()) + "reading CityGML file LOD3_Ettenheim_v100.xml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD3_Ettenheim_v100.xml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		System.out.println(df.format(new Date()) + "setting CityGML version flags up for mixed file context"); 
		ModuleContext moduleContext100 = new ModuleContext(CityGMLVersion.v1_0_0);
		ModuleContext moduleContext040 = new ModuleContext(CityGMLVersion.v0_4_0);
		
		HashMap<CityGMLModuleType, ModuleContext> convertContext = new HashMap<CityGMLModuleType, ModuleContext>();
		convertContext.put(CityGMLModuleType.CITYFURNITURE, moduleContext100);
		convertContext.put(CityGMLModuleType.TRANSPORTATION, moduleContext100);
		convertContext.put(CityGMLModuleType.WATERBODY, moduleContext100);
		convertContext.put(CityGMLModuleType.GENERICS, moduleContext100);
		convertContext.put(CityGMLModuleType.LANDUSE, moduleContext100);
		convertContext.put(CityGMLModuleType.RELIEF, moduleContext040);
		convertContext.put(CityGMLModuleType.BUILDING, moduleContext040);
		convertContext.put(CityGMLModuleType.VEGETATION, moduleContext100);		
		
		System.out.println(df.format(new Date()) + "creating CityGML mixed version model writer"); 
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory();
		out.setModuleContext(moduleContext100);
		
		CityModelWriter writer = out.createCityModelWriter(new File("LOD3_Ettenheim_mixed_v040_and_v100.xml"));
		writer.setPrefixes(moduleContext040);
		writer.setPrefixes(moduleContext100);
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocations(CityGMLVersion.v1_0_0);
		writer.setSchemaLocations(CityGMLVersion.v0_4_0);
		writer.setIndentString("  ");

		writer.setCityModelInfo(new CityModelInfo(cityModel));
		writer.writeStartDocument();
		
		for (CityObjectMember member : cityModel.getCityObjectMember()) {
			if (member.isSetCityObject()) {
				CityObject cityObject = member.getCityObject();
				writer.setModuleContext(convertContext.get(cityObject.getCityGMLModule().getType()));

				writer.writeFeatureMember(cityObject);
			}			
		}
		
		writer.writeEndDocument();		
		writer.close();

		System.out.println(df.format(new Date()) + "CityGML file LOD3_Ettenheim_mixed_v040_and_v100.xml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
