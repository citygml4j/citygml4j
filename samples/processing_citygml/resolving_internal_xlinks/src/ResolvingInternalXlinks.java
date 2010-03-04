import java.io.File;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.util.xlink.XLinkResolver;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;

public class ResolvingInternalXlinks {

	public static void main(String[] args) throws Exception {
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_CityObjectGroup_v100.xml"));

		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		XLinkResolver xLinkResolver = new XLinkResolver();
		
		for (CityObjectMember member : cityModel.getCityObjectMember()) {
			if (member.isSetCityObject() && 
					member.getCityObject().getCityGMLClass() == CityGMLClass.CITYOBJECTGROUP) {
				CityObjectGroup group = (CityObjectGroup)member.getCityObject();
				
				for (CityObjectGroupMember groupMember : group.getGroupMember()) {
					System.out.println("Group member:");
					System.out.println("   Role: " + groupMember.getGroupRole());
					
					CityObject cityObject = xLinkResolver.getAbstractGML(groupMember.getHref(), cityModel, CityObject.class);
					System.out.println("   Referenced city object: " + cityObject.getCityGMLClass() + 
							", gml:id='" + cityObject.getId() +"'");
					 
					if (cityObject.getId().equals("ID_76")) {
						Road road = (Road)cityObject;
						TrafficArea trafficArea = road.getTrafficArea().get(2).getTrafficArea();
						
						Object object = xLinkResolver.getObject(trafficArea.getLod2MultiSurface().getHref(), road);
						if (object instanceof MultiSurface) {
							MultiSurface multiSurface = (MultiSurface)object;
							System.out.println("   Referenced geometry: " + multiSurface.getGMLClass() + 
									", gml:id='" + multiSurface.getId() + "'");
						}
					}
				}
			}
		}
	}

}
