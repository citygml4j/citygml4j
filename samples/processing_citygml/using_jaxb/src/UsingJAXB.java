import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.JAXBNamespacePrefixMapper;
import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.factory.GMLFactory;
import org.citygml4j.jaxb.citygml.bldg._1.AbstractBoundarySurfaceType;
import org.citygml4j.jaxb.citygml.bldg._1.BoundarySurfacePropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.BuildingType;
import org.citygml4j.jaxb.citygml.core._1.CityModelType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractFeatureType;
import org.citygml4j.jaxb.gml._3_1_1.FeaturePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.StringOrRefType;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.gml.StringOrRef;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.model.module.citygml.CityFurnitureModule;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;

public class UsingJAXB {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		CityGMLContext cityGMLCtx = new CityGMLContext();
		JAXBBuilder builder = cityGMLCtx.createJAXBBuilder();
		
		JAXBContext ctx = builder.getJAXBContext();		
		Unmarshaller unmarshaller = ctx.createUnmarshaller();
		Marshaller marshaller = ctx.createMarshaller();
		ObjectFactory jaxbGMLFactory = new ObjectFactory();
		
		JAXBMarshaller jaxbMarshaller = builder.createJAXBMarshaller(CityGMLVersion.v1_0_0);
		GMLFactory gml = new GMLFactory();
		CityGMLFactory citygml = new CityGMLFactory();

		JAXBElement<?> cityModelElem = (JAXBElement<?>)unmarshaller.unmarshal(new File("../../datasets/LOD2_Building_v100.xml"));

		if (cityModelElem != null && cityModelElem.getValue() instanceof CityModelType) {
			CityModelType cityModelType = (CityModelType)cityModelElem.getValue();

			if (cityModelType.isSetFeatureMember()) {
				for (JAXBElement<? extends FeaturePropertyType> memberElem : cityModelType.getFeatureMember()) {
					if (memberElem.getValue() != null) {
						FeaturePropertyType memberType = memberElem.getValue();

						if (memberType.isSet_Feature()) {
							JAXBElement<? extends AbstractFeatureType> featureElem = memberType.get_Feature();
							if (featureElem.getValue() != null) {
								AbstractFeatureType featureType = featureElem.getValue();
								if (featureType instanceof BuildingType) {
									System.out.println("Found Building (CityGML version 1.0)");
									BuildingType buildingType = (BuildingType)featureType;

									if (buildingType.isSetBoundedBySurface()) {
										for (BoundarySurfacePropertyType boundedBy : buildingType.getBoundedBySurface()) {
											JAXBElement<?> boundarySurfaceElem = boundedBy.get_Object();
											if (boundarySurfaceElem.getValue() instanceof AbstractBoundarySurfaceType) {
												AbstractBoundarySurfaceType boundarySurfaceType = (AbstractBoundarySurfaceType)boundarySurfaceElem.getValue();
												System.out.println("  -- Found " + boundarySurfaceType);
												
												StringOrRefType description = jaxbGMLFactory.createStringOrRefType();
												description.setValue("processed by citygml4j using JAXB");												
												boundarySurfaceType.setDescription(description);
											}
										}
									}
								}
							}
						}
					}				
				}
			}
			
			CityFurniture cityFurniture = citygml.createCityFurniture();
			StringOrRef description = gml.createStringOrRef();
			description.setValue("processed by citygml4j");
			cityFurniture.setDescription(description);
			CityObjectMember member = citygml.createCityObjectMember(cityFurniture);
			
			JAXBElement<? extends FeaturePropertyType> memberElem = (JAXBElement<? extends FeaturePropertyType>)jaxbMarshaller.marshalJAXBElement(member);
			cityModelType.getFeatureMember().add(memberElem);
		}		
		
		JAXBNamespacePrefixMapper nsMapper = new JAXBNamespacePrefixMapper();
		nsMapper.setNamespacePrefixMapping(CoreModule.v1_0_0.getNamespaceURI(), "");

		// customize Marshaller instance
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", nsMapper);
		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
				CoreModule.v1_0_0.getNamespaceURI() + " " + CoreModule.v1_0_0.getSchemaLocation() + " " +
				BuildingModule.v1_0_0.getNamespaceURI() + " " + BuildingModule.v1_0_0.getSchemaLocation() + " " +
				CityFurnitureModule.v1_0_0.getNamespaceURI() + " " + CityFurnitureModule.v1_0_0.getSchemaLocation());

		// marshal object tree to CityGML instance document
		marshaller.marshal(cityModelElem, new File("LOD2_JAXB_result_v100.xml"));
		System.out.println("Sample CityGML document written to 'LOD2_JAXB_result_v100.xml'.");
	}

}
