import java.io.File;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriter;

public class ValidatingCityGMLWriter {

	public static void main(String[] args) throws Exception {
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();
		
		CityGMLFactory citygml = new CityGMLFactory();
		
		// creating example (and simple) CityGML object tree
		Building building = citygml.createBuilding();
		building.setId("1st-Building");
		
		BuildingPart buildingPart = citygml.createBuildingPart();
		buildingPart.setId("PART");
		building.addConsistsOfBuildingPart(citygml.createBuildingPartProperty('#' + buildingPart.getId()));
		
		CityModel cityModel = citygml.createCityModel();
		cityModel.addCityObjectMember(citygml.createCityObjectMember(building));
		cityModel.addCityObjectMember(citygml.createCityObjectMember(buildingPart));
		
		CityGMLVersion version = CityGMLVersion.v0_4_0;
		
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(version);
		out.setProperty(CityGMLOutputFactory.USE_VALIDATION, true);
		out.setValidationEventHandler(new ValidationEventHandler() {
			public boolean handleEvent(ValidationEvent event) {
				System.out.println(event.getMessage());
				return true;
			}
		});		
		
		CityGMLWriter writer = out.createCityGMLWriter(new File("Simple_but_invalid_building_v040.xml"));
		writer.setPrefixes(version);
		writer.setDefaultNamespace(CoreModule.v0_4_0);
		writer.setSchemaLocations(version);
		writer.setIndentString("  ");
		
		System.out.println("Validating citygml4j in-memory object tree whilst writing to file...\n");		
		writer.write(cityModel);
		
		writer.close();
	}

}
