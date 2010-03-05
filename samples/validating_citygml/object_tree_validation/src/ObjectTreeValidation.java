import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.schema.SchemaHandler;
import org.citygml4j.xml.validation.Validator;

public class ObjectTreeValidation {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();
		
		CityGMLFactory citygml = new CityGMLFactory();
		
		// creating example (and simple) CityGML object tree
		System.out.println(df.format(new Date()) + "creating simple city model with invalid content");
		Building building = citygml.createBuilding();
		building.setId("1st-Building");
		
		BuildingPart buildingPart = citygml.createBuildingPart();
		buildingPart.setId("PART");
		building.addConsistsOfBuildingPart(citygml.createBuildingPartProperty('#' + buildingPart.getId()));
		
		CityModel cityModel = citygml.createCityModel();
		cityModel.addCityObjectMember(citygml.createCityObjectMember(building));
		cityModel.addCityObjectMember(citygml.createCityObjectMember(buildingPart));
		
		System.out.println(df.format(new Date()) + "creating citygml4j Validator and validating city model against CityGML 0.4.0");
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		Validator validator = builder.createValidator(schemaHandler);
		
		validator.setValidationEventHandler(new ValidationEventHandler() {			
			public boolean handleEvent(ValidationEvent event) {
				System.out.println(event.getMessage());
				return true;
			}
		});		
		
		validator.validate(cityModel, CityGMLVersion.v0_4_0);
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
