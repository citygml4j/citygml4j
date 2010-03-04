import java.io.File;
import java.util.List;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.commons.gmlid.GMLIdManager;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.util.transform.FeatureSplitMode;
import org.citygml4j.util.transform.FeatureSplitter;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.AbstractCityGMLWriter;
import org.citygml4j.xml.io.writer.CityGMLWriter;
import org.citygml4j.xml.io.writer.CityModelWriter;
import org.citygml4j.xml.schema.SchemaHandler;

public class SplittingFeature {

	public static void main(String[] args) throws Exception {
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setSchemaHandler(schemaHandler);

		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_SubsurfaceStructureADE_v100.xml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		FeatureSplitter splitter = new FeatureSplitter(schemaHandler, new GMLIdCreator());
		splitter.setSplitMode(FeatureSplitMode.SPLIT_PER_FEATURE);
		splitter.exlcude(RoofSurface.class);
		
		//splitter.exlcude(ADEComponent.class);
		//splitter.setSplitCopy(true);

		List<CityGML> splitResult = splitter.split(cityModel);
		for (CityGML item : splitResult) {
			if (item.getCityGMLClass() == CityGMLClass.ADECOMPONENT) {
				ADEComponent ade = (ADEComponent)item;
				System.out.println("Split ADE component: " + ade.getLocalName());
			} else
				System.out.println("Split CityGML feature: " + item.getCityGMLClass());
		}
		
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v1_0_0);
		out.setSchemaHandler(schemaHandler);

		CityModelWriter modelWriter = out.createCityModelWriter(new File("LOD2_SubsurfaceStructureADE_split_v100.xml"));
		setContext(modelWriter);
		modelWriter.writeStartDocument();
		
		for (CityGML citygml : splitResult) {
			if (citygml instanceof AbstractFeature)
				modelWriter.writeFeatureMember((AbstractFeature)citygml);
			else if (citygml instanceof ADEComponent)
				modelWriter.writeFeatureMember((ADEComponent)citygml);
		}
		
		modelWriter.writeEndDocument();		
		modelWriter.close();
		
		CityGMLWriter cityGMLWriter = out.createCityGMLWriter(new File("LOD2_SubsurfaceStructureADE_orig_v100.xml"));
		setContext(cityGMLWriter);
		cityGMLWriter.write(cityModel);	
		cityGMLWriter.close();
	}
	
	private static void setContext(AbstractCityGMLWriter writer) {
		writer.setPrefixes(CityGMLVersion.v1_0_0);
		writer.setPrefix("sub", "http://citygml.org/ade/sub/0.9.0");
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocation("http://citygml.org/ade/sub/0.9.0", "../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd");
		writer.setIndentString("  ");
	}
	
	private static class GMLIdCreator implements GMLIdManager {
		int counter;
		
		public String generateGmlId() {
			return "ID_" + (++counter);
		}
		
	}
	
}
